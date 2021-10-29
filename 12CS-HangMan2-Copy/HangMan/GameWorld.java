import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Arrays;
/**
 * This is the game page of the game, including a user input space, score, level, timer ...
 * 
 * @author Tanya Gu
 * @version Oct 28 2021
 */
public class GameWorld extends World
{
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount = new Counter();
    
    public static int health = 10;
    Label healthLabel;
    Label scoreLabel;
    Label inputLabel;
    public static String word;
    
    Blank blank = new Blank();
    String userInput;
    int score = 0;
    int totalScore = 0;
    CheckMark checkMark;
    /**
     * Constructor for the Start World, initializes objects and adds them to the world.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 550x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the game page of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage gameSidePic = new GreenfootImage("gameSidePic.jpg");//the image that is drawed;
        gameSidePic.scale(gameSidePic.getWidth() - 400, gameSidePic.getHeight() - 400);
        getBackground().drawImage(gameSidePic,-100, 60);

        if(checkMark!=null) {
            removeObject(checkMark);
        }
        
        addObject(timeCount,165,30);
        timeCount.setValue(StartWorld.time); 
        
        Label levelLabel = new Label("Level " + StartWorld.lv,30);
        addObject(levelLabel,60,30);
        
        
        healthLabel = new Label("Health " + health,30);
        addObject(healthLabel,60,70);
        
                
        word = StartWorld.stackList.pop();
        addObject(blank, 410, 180);
        Label defLabel = new Label(StartWorld.stackDefList.pop(),20);
        addObject(defLabel,400,320);
        Label hint = new Label("\u2665 Hint: The length of the word is " + word.length() + " letters long",20);
        addObject(hint,400,380);
        
        scoreLabel = new Label("Score " + score + " / " + word.length(),30);
        addObject(scoreLabel,60,110);
        
    }
    
    
    /**
     * Starts music
     * Changes music depending on level
     * Changes music if the player wins
     * Creates new WinningWorld if the player wins
     */
    public void act()
    {    
        timeCountDown();
        readInput();
        if(StartWorld.lv == 12) {
            if(StartWorld.musicStatus) {
                StartWorld.bgm.stop();
                StartWorld.bgm = new GreenfootSound("finalbgm.mp3");
                StartWorld.bgm.play();
            }
        } else if (StartWorld.lv == 15) { //when player wins
            if(StartWorld.musicStatus) {
                StartWorld.bgm.stop();
                StartWorld.bgm = new GreenfootSound("winningbgm.mp3");
                StartWorld.bgm.play();
            }
            Greenfoot.setWorld(new WinningWorld());
        }
    }
    
    /**
     * Counts down time for every level
     * If player loses (runs out of time), creates new LoseWorld
     * Changes music if player loses.
     */
    public void timeCountDown()
    {    
        if(tim.millisElapsed() > 1000) { //time count down every second
            timeCount.add(-1);
            tim.mark();
        }
        
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
            if(StartWorld.musicStatus) {
                StartWorld.bgm.stop();
                StartWorld.bgm = new GreenfootSound("lossingbgm.mp3");
                StartWorld.bgm.play();
            }
            Greenfoot.setWorld(new LoseWorld());
        }

    }
    
    /**
     * Reads input of user
     * 
     */
    public void readInput()
    {    
        if (Greenfoot.mouseClicked(blank)) {
            score = 0;
            userInput = JOptionPane.showInputDialog("Please enter your word: "); //put out window asking user for input
            if(userInput != null) { //if user inputed something
                updateInput();
                if(userInput.equalsIgnoreCase(word)) { //if user input equals answer word
                    //updateInput();
                    nextLv();
                } else { //find the number of input characters that are correct
                    health --;
                    updateHealth();
                    findScore();
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void updateInput()
    {    
        if (inputLabel != null) {
            removeObject(inputLabel);
            inputLabel = new Label(userInput,50);
            addObject(inputLabel,410,175);//display user input on screen
        } else {
            inputLabel = new Label(userInput,50);
            addObject(inputLabel,410,175);//display user input on screen
        }
    }
    
    /**
     * 
     * 
     */
    public void updateHealth()
    {    
        removeObject(healthLabel);
        healthLabel = new Label("Health " + health,30);
        addObject(healthLabel,60,70);
        
        if (health == 0) { //if health is zero
            if(StartWorld.musicStatus) {
                StartWorld.bgm.stop();
                StartWorld.bgm = new GreenfootSound("lossingbgm.mp3");
                StartWorld.bgm.play();
            }
            Greenfoot.setWorld(new LoseWorld());
        }
    }
    
    /**
     * 
     * 
     */
    public void findScore()
    {    
        HashSet<Character> arrSet1 = new HashSet<Character>();
        HashSet<Character> arrSet2 = new HashSet<Character>();
        
        for (int i = 0; i < userInput.length(); i++) {
            arrSet1.add(userInput.charAt(i));
        }
        for (int j = 0; j < word.length(); j++) {
            arrSet2.add(word.charAt(j));
        }
        arrSet1.retainAll(arrSet2);
        score  = arrSet1.size();
        updateScore();
    }
    
    /**
     * 
     * 
     */
    public void updateScore()
    {    
        removeObject(scoreLabel);
        scoreLabel = new Label("Score " + score + " / " + word.length(),30);
        addObject(scoreLabel,60,110);
    }
    
    /**
     * 
     * 
     */
    public void nextLv()
    {    
        findScore();
        updateInput();
        checkMark = new CheckMark();
        addObject(checkMark, 400, 160); //add checkmark image
        
        StartWorld.lv++; //upgrade level
        health = 6;
        StartWorld.time -= 10;
        timeCount.setValue(StartWorld.time); 
        
        Greenfoot.delay(15);
        Greenfoot.setWorld(new GameWorld());
    }
}
