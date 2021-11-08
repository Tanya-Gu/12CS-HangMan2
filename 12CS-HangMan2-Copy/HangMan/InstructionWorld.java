import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Stack;
/**
 * InstructionWorld - displays instructions of the game to the play
 * 
 * @author Tanya Gu 
 * @version Oct 28 2021
 */
public class InstructionWorld extends World
{
    private proceedButton proceed;
    private boolean musicStatus;
    private GreenfootSound bgm;
    private Stack<String> stackList = new Stack<String>();
    private Stack<String> stackDefList = new Stack<String>();
    private int time;
    private int lv;
    /**
     * Constructor for InstructionWorld - Calls super class, initializes objects and adds them to the world.
     * 
     * @param time
     * @param lv
     * @param bgm
     * @param musicStatus
     * @param stackList
     * @param stackDefList
     */
    public InstructionWorld(int time,int lv,GreenfootSound bgm,boolean musicStatus,Stack<String>stackList, Stack<String>stackDefList)
    {    
        // Create a new world with 800x540 cells with a cell size of 1x1 pixels.
        super(800, 540, 1); 
        
        this.time = time;
        this.musicStatus = musicStatus;
        this.lv = lv;
        this.bgm = bgm;
        this.stackList = stackList;
        this.stackDefList = stackDefList;
        
        Label instruction = new Label("Instructions: \n\n 1. Your goal is to guess the \n correct word using hints. \n\n 2. You have a limited amount of \n health(6) and time! \n\n 3. Click the paper to enter your word. ", 30);
        addObject(instruction,400,290); //displays instruction label
        
        proceed = new proceedButton();
        addObject(proceed, 710, 495);
        
        GreenfootImage clock = new GreenfootImage("clock.png"); //draws an image for aesthetic purpose
        clock.scale(clock.getWidth() - 400, clock.getHeight() - 480);
        getBackground().drawImage(clock,130, 140);
        GreenfootImage paper = new GreenfootImage("userInputBackground.png"); //draws an image for aesthetic purpose
        paper.scale(paper.getWidth() - 800, paper.getHeight() - 530);
        getBackground().drawImage(paper,600, 100);
        GreenfootImage mouse = new GreenfootImage("mouse.png"); //draws an image for aesthetic purpose
        mouse.scale(mouse.getWidth() - 540, mouse.getHeight() - 560);
        getBackground().drawImage(mouse,640, 150);
    }
    
    public void act()
    {    
        proceedGame();
    }
    
    /**
     * Called every act; changes to the gameWorld  
     */
    public void proceedGame()
    {    
        if (Greenfoot.mouseClicked(proceed)) { //if user clicked proceed
            Greenfoot.setWorld(new GameWorld(time,lv,bgm,musicStatus,stackList,stackDefList));
        }
    }
}
