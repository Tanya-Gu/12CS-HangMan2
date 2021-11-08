import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WinningWorld - Displays if the player wins the game (Guessed all the words within the time limit)
 * 
 * @author Tanya Gu and Marissa Abesdris. Cleaning stuff up done by Sherman
 * @version Oct 28 2021
 */
public class WinningWorld extends World
{
    SimpleTimer returnTime = new SimpleTimer();
    int time = 400; //8s
    instructionButton creditBtn;
    GreenfootSound bgm;
    /**
     * Constructor for WinningWorld - Calls super class, initializes objects and adds them to the world.
     * 
     * @param bgm
     */ 
    public WinningWorld(GreenfootSound bgm)
    {    
        // Create a new world with 800x540 cells with a cell size of 1x1 pixels.
        super(800, 540, 1); 
        this.bgm = bgm;
        prepare();
    }
    
    /**
     * Prepare the WinningWorld for the program - Create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label winningMsg = new Label("Thank you, \nfor saving \none's life. ", 60);
        addObject(winningMsg,310,320);
        
        creditBtn = new instructionButton();
        addObject(creditBtn,50,470);
    }
    
    /**
     * Called every act, displays the credit page if applicable
     */
    public void act()
    {    
        if(returnTime.millisElapsed() > 1000) { //time count down every second
            time --;
        }
        
        if (time == 0) { 
            bgm.stop();
            Greenfoot.stop();
        }
        
        showCredit();
    }  
    
    /**
     * If the player clicks on the credit button, the credit world will be displayed
     */
    public void showCredit()
    {    
        if (Greenfoot.mouseClicked(creditBtn)) { //if user clicked instructions button
            Greenfoot.setWorld(new CreditWorld()); //display credit world
            Greenfoot.stop();
        }
    }
}
