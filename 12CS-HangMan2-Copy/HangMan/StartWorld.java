import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Stack;
/**
 * This is the start page of the game, including a lighning animation, a proceed button, a instructions tab and a music control button.
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class StartWorld extends World
{
    proceedButton proceed;
    musicButton music;
    instructionButton instructionBtn;
    public static GreenfootSound bgm;
    public static boolean musicStatus = true;
    
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> defList = new ArrayList<String>();
    public static Stack<String> stackList = new Stack<String>();
    public static Stack<String> stackDefList = new Stack<String>();
    
    public static int lv;
    public static int time = 30;
    /**
     * Constructor for the Start World, initializes objects and adds them to the world.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 550x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        try{
            Reader.readInto(list);
            Reader.readInto2(defList);
        } catch(Exception e) {
            System.out.println("error");
        }
        
        //store all words and definitions to corresponding stacks
        for (int i = 0; i < list.size(); i++) {
            stackList.push(list.get(i));
            stackDefList.push(defList.get(i));
        }
        
        proceed = new proceedButton();
        addObject(proceed, 150, 420);
        
        music = new musicButton();
        addObject(music, 50, 420);
        
        instructionBtn = new instructionButton();
        addObject(instructionBtn,45,360);
        
        Lightning lightning1 = new Lightning();
        addObject(lightning1,75,85);
        Lightning lightning2 = new Lightning();
        addObject(lightning2,200,45);
        
        bgm = new GreenfootSound("bgm.mp3");
        
        GameWorld.health = 6;
        lv = 1;
        time = 150;
        musicStatus = true;
    }
    
    /**
     * Plays music
     * Checks if user has clicked the proceed button or the instructions button
     */
    public void act()
    {    
        proceedGame();
        playMusic();
        showInstruction();
    }
    
    /**
     * Plays music upon creating the world
     * If user clicks the music button, music will stop playing
     */
    public void playMusic()
    {    
        if (Greenfoot.mouseClicked(music)) { //if user clicked music off
            if(musicStatus) {
                musicStatus = false;
                bgm.stop(); //stop music
                music.setImage("musicOff.jpg"); //change image to off
                music.getImage().scale(music.getImage().getWidth()/6, music.getImage().getHeight()/6);
            } else {
                musicStatus = true;
                bgm.playLoop(); //play music
                music.setImage("musicOn.png"); //change image to on
                music.getImage().scale(music.getImage().getWidth()/6, music.getImage().getHeight()/6);   
            }
        } else{
            if (musicStatus) { //if music is on
                bgm.playLoop();
            }
        }
    }
    
    /**
     * Checks if user has clicked proceed
     * If so, start the game and initialize a new GameWorld
     */
    public void proceedGame()
    {    
        if (Greenfoot.mouseClicked(proceed)) { //if user clicked proceed
            Greenfoot.setWorld(new GameWorld());
        }
    }
    
    /**
     * Checks if user has clicked the instructions button
     * If so, create a new InstructionWorld
     */
    public void showInstruction()
    {    
        if (Greenfoot.mouseClicked(instructionBtn)) { //if user clicked instructions button
            Greenfoot.setWorld(new InstructionWorld());
        }
    }
}
