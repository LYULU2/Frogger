package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import application.MyStage;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import models.Animal;
import models.BackgroundImage;
import models.Digit;
import models.Frogger;
import models.FroggerB;
import models.FroggerLife;
import models.TextButton;
import sceneFactory.ScoreFactory;
import sceneView.MainView;
/**
 * this class defines the basic controls for the main game
 * @author Luer Lyu
 *
 */
public abstract class MainController extends Controller{

	int highestScore;
	boolean multi;
	String fileName = "HighScore.txt";
	AnimationTimer timer;
	Frogger frog1;
	FroggerB frog2;
	MyStage background;
	int yPosScore = 40;
	ArrayList<FroggerLife> lives;
	int livesCount = 2;
	int[] highScoreList;
	String[] highScoreNames;
	String Name;
	Digit digit_s;
	Digit digit_h;
	// current level of the game
	public int level = 1;
	public int[] prevScores = {-100,-100,-100,-100,-100};
	public int scorePrev =0;
	ScoreFactory scoreFactory;
	TextButton pause;
	TextButton resume;
	BackgroundImage pausebkgd;
	boolean pass = false;
	/**
	 * constructor to get the models in the scene
	 * @param mainSceneView the view class which decides the look of the scene
	 */
	public MainController(MainView mainSceneView) {
		this.timer = mainSceneView.getTimer();
		this.frog1 = Frogger.getAnimal();
		this.frog2 = FroggerB.getAnimal();
		frog1.setDefault();
		this.background = mainSceneView.getStage();
		this.lives = mainSceneView.getLives();
		this.highestScore = mainSceneView.getHighestScore();
		this.highScoreList = mainSceneView.getScoreList();
		this.highScoreNames = mainSceneView.getScoreName();
		this.pause = mainSceneView.getPause();
		pause();
	}
	/**
	 * bind the pause button with the pause function
	 */
	public void pause() {
		pause.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				background.stop();
				stop();
				pausebkgd = new BackgroundImage("file:img/pausePage.png");
				resume = new TextButton("file:img/resume.png",220,350,140);
				background.add(pausebkgd);
				background.add(resume);
				bindButton();
			}
		});
	}
	
	/**
	 * bind the button with resume function
	 */
	private void bindButton() {
		resume.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				background.remove(resume);
				background.remove(pausebkgd);
				timer.start();
				background.start();
			}
		});
	}
	
	/**
	 * create a timer
	 */
	abstract public void createTimer();
    
	/**
	 * ask user for the name input
	 */
	public void NamePrompt() {
		background.add( new BackgroundImage("file:img/catbkgd.png") );
		TextButton btn = new TextButton("file:img/continue.png",220,350,140);
		setButtonAnimation(btn);
		background.add(btn);
		if(frog1.win()) {
			background.add(new TextButton("file:img/win.png",60,40,450));
		}else{
			background.add(new TextButton("file:img/lose.png",85,40,400));
		}
	}
	/**
	 * change the style of button when mouse hovers
	 * @param btn the button object
	 */
	public void setButtonAnimation(TextButton btn) {
		btn.setOnMouseClicked(
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						buttonEvent();
				}
		});
		btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btn.changeImage("file:img/continue2.png",220,350,145);
			}
			
		});
		btn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btn.changeImage("file:img/continue.png",220,350,140);
			}
			
		});
	}
	/**
	 * this describes the click event when button
	 * continue is clicked
	 */
	public void buttonEvent() {
		while(!pass) {
			TextInputDialog dialog = configureDialog();
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				Name = result.get();
				checkValid(Name);
			}
			else {
				try {
					writeScore();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	/**
	 * configure the content of the dialog
	 * @return TextInputDialog the dialog been prompted
	 */
	public TextInputDialog configureDialog() {
		TextInputDialog dialog = new TextInputDialog("e.g. aaa");
		dialog.setTitle("Get Your Score On Board!");
		dialog.setHeaderText("Enter Your Name");
		dialog.setContentText("Please enter your name\n"
				+ "if you want your score to be recorded:\n"
				+"(Name must be three letters)");
		return dialog;
	}
	/**
	 * check of the name input is valid or not
	 * @param Name represents the input string
	 */
	public void checkValid(String Name) {
		//ensure the name entered is valid
		if(Name.matches("[a-zA-Z]*")&&Name.length()==3) {
			pass = true;
			insertScore();
			try {
				writeScore();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * insert the score and name from this round to the array 
	 * containing history score if applicable
	 */
	public void insertScore() {
		int current = Animal.getPoints();
		int temp;
		String tempName;
		for(int i=0;i<highScoreList.length;i++) {
			//insert the current the score if applicable
			if(highScoreList[i] == 0) {
				highScoreList[i] = current;
				highScoreNames[i] = Name;
				break;
			}else {
				if(current>highScoreList[i]) {
					temp = highScoreList[i];
					tempName = highScoreNames[i];
					highScoreList[i] = current;
					highScoreNames[i] = Name;
					current = temp;
					Name = tempName;
				}
			}
		}
	}
	/**
	 * write the array consisting of all history score to the file
	 * @throws IOException if the file cannot be found
	 */
	public void writeScore() throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    for(int i =0;i<10;i++) {
	    	printWriter.print(highScoreList[i] + "\n");
	    	if(highScoreNames[i] == "\n"|| highScoreNames[i] == null) {
	    		printWriter.print("aaa\n");
	    	}else {
	    		printWriter.print(highScoreNames[i] + "\n");
	    	}
	    }
	    printWriter.close();
	    scoreFactory.init(Animal.getPoints(),multi);
	}
	
	/**
	 * create and start the timer, play music
	 */
	public void start() {
		background.playMusic("music/FroggerMainSong.mp3",true);
    	createTimer();
        timer.start();
    }
	/**
	 * stop the timer
	 */
    public void stop() {
        timer.stop();
    }
    
    /**
     * print the current highest score
     * @param n current points for the game
     */
    public void updateNumber(int n) {
    	// if new score has been created
    	if(highestScore < n) {
    		digit_h = printNumber(320,yPosScore,n,digit_h);
    	}else {
    		digit_h = printNumber(320,yPosScore,highestScore,digit_h);
    	}
    }
    
    /**
     * print the current score on the screen
     * @param x the x position of the digit 
     * @param y the y position of the digit
     * @param n the number need to be printed
     * @param digit the Digit object from the previous print representing the highest digit
     * @return the Digit object on the highest weight in this round
     */
    public Digit printNumber(int x, int y, int n, Digit digit) {
    	int shift = 0;
    	Digit temp = null;
    	if(digit != null) {
    		background.remove(digit);
    	}
    	if(n == 0) {
    		temp = new Digit(0, 30, x, y);
  		  	background.add(temp);
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  temp = new Digit(k, 30, x - shift, y);
    		  background.add(temp);
    		  shift+=30;
    		}
    	return temp;
    }
    /**
     * update the number of lives left in this class
     */
    public void updateLives() {
    	background.remove(lives.get(livesCount));
    	lives.remove(livesCount);
    	showAlert();
		livesCount--;
		
    }
    /**
     * when a round ends, an alert containing the points gained and ranking will pop up
     */
    public void showAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(livesCount>0) {
    		alert.setTitle("Checkout the summary for this round!");
    		prevScores[level-1]=Animal.getPoints()-scorePrev;
    		alert.setHeaderText("You Gained "+prevScores[level-1]+" points!");
    		sortRoundScores();
    		String info ="Ranking For The Scores: \n";
    		for(int i=0;i<level;i++) {
        		info+=(i+1)+": "+prevScores[i]+"\n";
        	}
        	alert.setContentText(info);
    		alert.show();
    	}
    	scorePrev = Animal.getPoints();
    	level++;
    }
    /**
     * this function sorts the scores so far
     * within the array prevScores
     */
    public void sortRoundScores() {
    	Arrays.sort(prevScores);
    	//reverse the array
    	for(int i = 0; i < prevScores.length / 2; i++)
    	{
    	    int temp = prevScores[i];
    	    prevScores[i] = prevScores[prevScores.length - i - 1];
    	    prevScores[prevScores.length - i - 1] = temp;
    	}
    	
    }
    /**
     * instantiate the factory to build the score scene
     * @param primaryStage the stage used to display the scene
     */
    public void createScoreFactory(Stage primaryStage) {
    	scoreFactory = new ScoreFactory(primaryStage);
    }
    /**
     * add frog if there are multiple players
     * @param multi true if there are multiple players, otherwise false
     */
    public void addFrog(boolean multi) {
    	this.multi = multi;
    	if(multi) {
    		background.add(frog2);
    	}
    }
}
