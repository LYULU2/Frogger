Test on: Lab Machine<br/>
Build Script: Maven<br/>
![StartscreenShot](https://projects.cs.nott.ac.uk/scyll1/g52swm_cw2_scyll1/raw/master/Frogger/img/cap.PNG)
# Improvements
1. fix the path of reading the pictures, and put them all in a separate file
2. fix the scale problem
3. [add the real-time highest score for the game](#add-high-score)
4. separate big classes into small classes
5. [extend the code by adding start, info and score scene](#add-scenes)
6. [Design pattern used in this project(refactor)](#design-pattern-used-in-this-project)
7. [Handling songs](#handling-songs)
8. [New models(actors) added](#new-models-added)
9. [New levels added](#new-levels-added)
10. Pause function
11. Multiple players enabled
12. Add 'animation' to buttons
13. History score kept and score ranking for rounds
14. [Score scene and info scene](#scenes)

# Add high score
before the game starts, the highest score will be read from the file, controller 
will compare that with real-time score to see if new high score is been made.
and the highest digit is been tracked so when the number of digits decrease, the
redundant digit will be removed.

# Add scenes
New scene will be created and shown on the stage when user clicked the button to 
invoke the method.

enable user to enter name to record the score, only valid names accepted.

# Design pattern used in this project 
**MVC Pattern**<br />
Instead of stacking all the code in main, concrete view classes are used to add 
elements in the scene, which are models that been put in the model package, and 
these view classes can return the elements inside of it to control classes, so 
control classes will be able to add actions or other choices to the models, while
are prevented from accessing protected objects.

**Singleton**<br />
This encapsulates the data and keeps the points consistent.

**Factory Pattern**<br />
To better encapsulate the process of how a scene is built, a concrete factory for 
each scene is used to produce and change different scenes, this will create less
coupling between different classes of scenes.
Because the clients (in this case are the classes that need to build a new scene) 
does not need to return an object but are used to call the init method to build 
the scene, so the final implementation may not really be the factory pattern known,
main concepts are used to improve this particular situation.

# Handling songs 
Path and time the song is played are made parameters.

# New models added
**handling Frogger lives**<br />
To add and remove them in the scene, I put them in an arrayList.

**crocodile in water**<br />
This model is added in the scene like any other models, the function is only to
change the theme song.

**crocodile in end**<br />
The data structure used is also arrayList. To make the showing of the crocodile less 
fixed, random numbers are generated.

**snake**<br />

**two froggers**<br />
There are two different frogs inherits from Animal class and play the game 
collaboratively, of which singleton is applied.

# New levels added
Since even in different levels of the game, most of the code will be duplicated, so
parent abstract classes are generated to do the basic setup for the game.
Player will enter the second stage after wining the first.<br />
![screenShot](https://projects.cs.nott.ac.uk/scyll1/g52swm_cw2_scyll1/raw/master/Frogger/img/screenShot.PNG)

# Scenes
![screenShot](https://projects.cs.nott.ac.uk/scyll1/g52swm_cw2_scyll1/raw/master/Frogger/img/infopic.PNG)
![screenShot](https://projects.cs.nott.ac.uk/scyll1/g52swm_cw2_scyll1/raw/master/Frogger/img/score.PNG)