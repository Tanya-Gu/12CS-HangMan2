import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Stack;
/**
 * GameWorld - Allows player to play; includes an user input space, score, health, level, and timer.
 * 
 * @author Tanya Gu
 * @version Oct 28 2021
 */
public class GameWorld extends World
{
    private SimpleTimer tim = new SimpleTimer();
    private Counter timeCount = new Counter();
    private GreenfootSound bgm;
    private boolean musicStatus;
    private Stack<String> stackList = new Stack<String>();
    private Stack<String> stackDefList = new Stack<String>();
    
    private int health = 6;
    private int time;
    private int lv;
    private int score = 0;
    private Label healthLabel;
    private Label scoreLabel;
    private Label inputLabel;
    private Label clickHint;
    private Label clickHint2;
    private String word;    
    
    private Blank blank = new Blank();
    private String userInput;
    private CheckMark checkMark;
    private XMark xMark;
    /**
     * Constructor for GameWorld - Calls super class, initializes objects and adds them to the world.
     * 
     * @param time
     * @param lv
     * @param bgm
     * @param musicStatus
     * @param stackList
     * @param stackDefList
     */
    public GameWorld(int time,int lv, GreenfootSound bgm,boolean musicStatus,Stack<String>stackList, Stack<String>stackDefList)
    {    
        // Create a new world with 800x540 cells with a cell size of 1x1 pixels.
        super(800, 540, 1); 
        
        this.time = time;
        this.musicStatus = musicStatus;
        this.lv = lv;
        this.bgm = bgm;
        this.stackList = stackList;
        this.stackDefList = stackDefList;
        
        prepare();
    }
    
    /**
     * Prepare the GameWorld for the program - Create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage gameSidePic = new GreenfootImage("gameSidePic.jpg"); //draws an image for aesthetic purpose
        gameSidePic.scale(gameSidePic.getWidth() - 470, gameSidePic.getHeight() - 470);
        getBackground().drawImage(gameSidePic,460, 35);
        
        if(checkMark != null) { //removes check mark from previous level if there is one
            removeObject(checkMark);
        }
        
        addObject(timeCount,70,30);
        timeCount.setValue(time); 
        
        Label levelLabel = new Label("Level " + lv,30);
        addObject(levelLabel,190,30);
        
        healthLabel = new Label("Health " + health,30);
        addObject(healthLabel,310,30);
                
        word = stackList.pop();
        addObject(blank,240,210);
        Label defLabel = new Label("\u2665 " + stackDefList.pop(),30); //pop the definition and show as a label
        addObject(defLabel,400,420);
        Label hint = new Label("\u2665 Hint: The length of the word is " + word.length() + " long",30); //find the length of the word and show as a label
        addObject(hint,400,480);
        
        scoreLabel = new Label("Score " + score + " / " + word.length(),30);
        addObject(scoreLabel,450,30);
        
        if(lv == 1) {
            clickHint = new Label("Click Here to Enter",30);
            addObject(clickHint,240,210);
        }
    }
    
    
    /**
     * Called every act, changes the time, reads user input, updates music and changes world if applicable.
     */
    public void act()
    {    
        timeCountDown();
        checkLv();
        readInput();
    }
    
    /**
     * Called every act; updates the time counter every second.
     * If time limit is reached, change to lose world.
     */
    public void timeCountDown()
    {    
        if(tim.millisElapsed() > 1000) { //time count down every second
            timeCount.add(-1);
            tim.mark();
        }
        
        if (tim.millisElapsed() * 1000 == timeCount.getValue()) { //if time limit is reached
            if(musicStatus) { //if music status is on, change to lossing bgm
                bgm.stop();
                bgm = new GreenfootSound("lossingbgm.mp3");
                bgm.play();
            }
            Greenfoot.setWorld(new LoseWorld(word,bgm)); //change to lose world
        }

    }
    
    /**
     * Called every act; updates music and changes world if applicable
     */
    public void checkLv()
    {    
        if(lv == 15) { 
            if(musicStatus) { //if music status is on, change to final bgm when level 15 is reached
                bgm.stop();
                bgm = new GreenfootSound("finalbgm.mp3");
                bgm.play();
            }
        } else if (lv == 19) { 
            if(musicStatus) { //if music status is on, change to winning bgm when level 18 is reached
                bgm.stop();
                bgm = new GreenfootSound("winningbgm.mp3");
                bgm.play();
            }
            Greenfoot.setWorld(new WinningWorld(bgm)); //change to winning world
        }

    }
    
    /**
     * Called every act; updates user input, score and health.
     */
    public void readInput()
    {    
        if (Greenfoot.mouseClicked(blank)) { //if the input space is clicked
            score = 0;
            if (clickHint != null) { //removes click hint from previous level if there is one
                removeObject(clickHint);
            }
            if (xMark != null && clickHint2 != null) {
                removeObject(xMark);
                removeObject(clickHint2);
            }
            userInput = JOptionPane.showInputDialog("Please enter your word: "); //pop out window asking user for input
            if(userInput != null) { //if user inputed something
                updateInput();
                if(userInput.equalsIgnoreCase(word)) { //if user input equals answer word
                    nextLv(); 
                } else { 
                    health --;
                    updateHealth();
                    findScore();
                    
                    xMark = new XMark(); 
                    addObject(xMark, 350, 215); //show x
                    clickHint2 = new Label("\u00B7 Click Here to Try Again \u00B7",30);
                    addObject(clickHint2,240,300); //show try-again hint
                }
            }
        }
    }
    
    /**
     * Update user input by displaying it on the screen
     * 
     */
    public void updateInput()
    {    
        if (inputLabel != null) { //if there is an input label from previous level
            removeObject(inputLabel); //remove the label
            inputLabel = new Label(userInput,50);
            addObject(inputLabel,240,210); //display user input on screen
        } else {
            inputLabel = new Label(userInput,50);
            addObject(inputLabel,240,210); //display user input on screen
        }
    }
    
    /**
     * Updates health by displaying it on the screen
     * Changes bgm and world if 0 health is reached
     */
    public void updateHealth()
    {    
        removeObject(healthLabel);
        healthLabel = new Label("Health " + health,30);
        addObject(healthLabel,310,30); //display health on screen
        
        if (health == 0) { //if health is zero
            if(musicStatus) { //play lossing bgm if music status is on
                bgm.stop();
                bgm = new GreenfootSound("lossingbgm.mp3");
                bgm.play();
            }
            Greenfoot.setWorld(new LoseWorld(word,bgm)); //change to lose world
        }
    }
    
    /**
     * Find the number of characters entered correctly (ones that match the answer word)
     */
    public void findScore()
    {    
        HashSet<Character> userSet = new HashSet<Character>();
        HashSet<Character> wordSet = new HashSet<Character>();
        
        for (int i = 0; i < userInput.length(); i++) {
            userSet.add(userInput.charAt(i));
        }
        for (int j = 0; j < word.length(); j++) {
            wordSet.add(word.charAt(j));
        }
        
        userSet.retainAll(wordSet);
        score  = userSet.size();
        updateScore();
    }
    
    /**
     * Update score by dispalying it on the screen
     * 
     */
    public void updateScore()
    {    
        removeObject(scoreLabel);
        scoreLabel = new Label("Score " + score + " / " + word.length(),30);
        addObject(scoreLabel,450,30); //display score on the screen
    }
    
    /**
     * Update input, score, health, level, check mark, time and refreshes the page     * 
     */
    public void nextLv()
    {    
        findScore();
        updateInput();
        
        checkMark = new CheckMark();
        addObject(checkMark, 240,210); //add checkmark image
        
        lv++; //upgrade level
        health = 6; //reset health
        time -= 10; //decrease time by 10 seconds
        timeCount.setValue(time); 
        
        Greenfoot.delay(15); 
        Greenfoot.setWorld(new GameWorld(time,lv,bgm,musicStatus,stackList,stackDefList)); //refresh page
    }
}
