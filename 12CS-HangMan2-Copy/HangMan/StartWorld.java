import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Stack;
/**
 * StartWorld - Includes a lightning animation; allows the player to check instructions, turn on or off the music and play the game
 * 
 * @author Tanya Gu, testing + cleaning stuff up done by Sherman
 * @version Oct 27 2021
 */
public class StartWorld extends World
{
    private proceedButton proceed;
    private musicButton music;
    private GreenfootSound bgm;
    private boolean musicStatus = true;
    private instructionButton instructionBtn;
    
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> defList = new ArrayList<String>();
    private Stack<String> stackList = new Stack<String>();
    private Stack<String> stackDefList = new Stack<String>();
    
    private int lv;
    private int time = 30;
    /**
     * Constructor for StartWorld - Calls super class, initializes objects and adds them to the world.
     */
    public StartWorld()
    {    
        // Create a new world with 800x540 cells with a cell size of 1x1 pixels.
        super(800, 540, 1); 
        prepare();
    }

    /**
     * Prepare the GameWorld for the program - Create the initial objects and add them to the world.
     */
    private void prepare()
    {
        try{
            Reader.readInto(list); //reads word list
            Reader.readInto2(defList); //reads definition lsit
        } catch(Exception e) {
            System.out.println("error");
        }
        
        for (int i = 0; i < list.size(); i++) { //stores all words and definitions to corresponding stacks
            stackList.push(list.get(i));
            stackDefList.push(defList.get(i));
        }
        
        proceed = new proceedButton();
        addObject(proceed, 150, 495);
        
        music = new musicButton();
        addObject(music, 50, 495);
        bgm = new GreenfootSound("bgm.mp3");
        musicStatus = true;
        
        instructionBtn = new instructionButton();
        addObject(instructionBtn,50,440);
        
        Lightning lightning1 = new Lightning();
        addObject(lightning1,75,85);
        Lightning lightning2 = new Lightning();
        addObject(lightning2,200,45);
        
        lv = 1;
        time = 180;
    }
    
    /**
     * Called every act; plays music, display the instruction page or proceeds the game if applicable
     */
    public void act()
    {    
        proceedGame();
        playMusic();
        showInstruction();
    }
    
    /**
     * Plays music upon creating the world
     * The player can control the music status by clicking the music button
     */
    public void playMusic()
    {    
        if (Greenfoot.mouseClicked(music)) { 
            if(musicStatus) { //if music is on
                musicStatus = false; //turn music off
                bgm.stop(); //stop music
                music.setImage("musicOff.jpg"); //change image to off
                music.getImage().scale(music.getImage().getWidth()/6, music.getImage().getHeight()/6);
            } else { //if music is off
                musicStatus = true; //turn music on
                bgm.playLoop(); //play music
                music.setImage("musicOn.png"); //change image to on
                music.getImage().scale(music.getImage().getWidth()/6, music.getImage().getHeight()/6);   
            }
        } else{
            if (musicStatus) { //if music is on
                bgm.playLoop(); //keep playing music
            }
        }
    }
    
    /**
     * Checks if the proceed button is clicked
     * If so, start the game and initialize the GameWorld
     */
    public void proceedGame()
    {    
        if (Greenfoot.mouseClicked(proceed)) { //if user clicked proceed
            Greenfoot.setWorld(new GameWorld(time,lv,bgm,musicStatus,stackList,stackDefList));
        }
    }
    
    /**
     * Checks if the instruction button is clicked
     * If so, initialize the InstructionWorld
     */
    public void showInstruction()
    {    
        if (Greenfoot.mouseClicked(instructionBtn)) { //if user clicked instructions button
            Greenfoot.setWorld(new InstructionWorld(time,lv,bgm,musicStatus,stackList,stackDefList));
        }
    }
}
