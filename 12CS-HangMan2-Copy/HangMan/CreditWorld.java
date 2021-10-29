import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * If user chooses to click on the credit button in
 * WinningWorld or LoseWorld, they will be taken to this world
 * 
 * @author Marissa Abesdris
 * @version Oct 28 2021
 */
public class CreditWorld extends World
{

    SimpleTimer returnTime = new SimpleTimer();
    int time = 250; //5s
    
    Label titleLabel = new Label("Credits", 30);
    Label subtitleLabel = new Label("Sherman Leung \n Tanya Gu \n Marissa Abesdris", 30);
    //proceedButton endButton;
    
    /**
     * Constructor for objects of class CreditWorld.
     * Adds all components of CreditWorld upon making the world.
     */
    public CreditWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the game page of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // my stuffs im not done yet tho
        //endButton = new proceedButton();
        addObject(titleLabel, 280, 48);
        addObject(subtitleLabel, 280, 123);
        //addObject(endButton, 150, 355);        
    }
    
    /**
     * Stops Greenfoot after 5 seconds.
     */
    public void act()
    {    
        if(returnTime.millisElapsed() > 1000) { //time count down every second
            time --;
        }
        
        if (time == 0) { 
            Greenfoot.stop();
        }
    }  
}
