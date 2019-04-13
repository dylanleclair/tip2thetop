# tip2thetop

A CPSC 233 Game.

![tiptop](https://user-images.githubusercontent.com/45270659/53685691-4da9f880-3cdb-11e9-9736-464edb5be0cb.gif)

The game is made for the Java CPSC 233 course. This game is much like a hotel simulator, where there are mutiple interactions
with multiple characters. Each character you interact with and the choices you make in this game will eventually influence
the gameplay experience.

## Technologies
Made with the JavaFX Library and JDK 1.8.

## Setup/Installation
>Remember to clone the master branch of the game, as that is the one that is the most up to date.
### For Windows

1.) Install git for the desktop [here](https://git-scm.com/downloads). Choose the appropriate operating system.

2.) Open the command line, then clone the source repository from GitHub

```
git clone https://github.com/dylanleclair/tip2thetop.git
```

If you are on windows, the repository will be cloned to wherever your initial directory is located from when you started the installation.

Such as here<br/>
![alt text](https://i.gyazo.com/2bbea0d516534f8e15f4eb27b055a2af.png)

You can see that the terminal is in 
```
C:\Users\J
```
That is where the git clone will be located.

3.) Make sure you have Java8 installed as you will need it to run the application.<br/> Recent versions such as JDK 11 lack support
for JavaFX

Instructions on the installation of Java can be found [here](https://www.java.com/en/download/help/download_options.xml)

4.) Compile the game in the terminal of your choice. First load the directory the repository is located in

Then follow the steps below.
```
cd tip2thetop
cd src
cd application
javac Game.java
```

If you get no compilation errors, proceed with running the CLASS file that was just made.

```
java Game
```
### For Mac OSX
1.) Make sure git is installed for your computer. The link can be found above in the *Windows* Section.

2.) "cd" to the desired location/repository

3.) Clone from the terminal

```
git clone https://github.com/dylanleclair/tip2thetop.git
```

4.) Load the application directory of the cloned repository

5.) Run the game.java file in the terminal

```
javac game.java
```

6.) If you get no compilation errors, proceed with running the CLASS file that was just made

```
java Game
```

## Running the JUNIT Tests

### Via IDE (IntelliJ)
1.) First, clone the TEST branch of the repository. Then checkout from version control and clone it onto IntelliJ

2.) Mark the test folder as the Tests sources root </br>
![alt text](https://i.gyazo.com/bb257b4c5558be72eb09f141365a0104.png) </br>

3.) Then run the Test through Run

### Through hamcrest-core and JUNIT
1.) Make sure all files are compiled in the directory <br/>
2.) Make sure the NPCTest is inside of the src <br/>
3.) Have the hamcrest-core.jar and junit.jar inside of the src directory <br/>
4.) Compile using command line and run via junit <br/>

## Version
Version 2.0

## Goals
As of 2019-04-12 </br>
-Finalze all debugging </br>
-Adding extra features

## Team
>Contributers and people

- [Jason Jiang](https://github.com/jjiaang)
- [Dylan Leclair](https://github.com/dylanleclair)
- [Patrica Lively](https://github.com/lively15)
- [Yvonne Ng](https://github.com/ng-yvonne)
- [Tiffany Chang](https://github.com/tiffany-TIFF)
