import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World that is made if the user wins the game 
 * (Guesses all words within the time limit)
 * 
 * @author Tanya Gu and Marissa Abesdris
 * @version Oct 28 2021
 */
public class WinningWorld extends World
{
    SimpleTimer returnTime = new SimpleTimer();
    int time = 250; //5s
    
    instructionButton creditBtn;
    
    /**
     * Constructor for objects of class WinningWorld.
     * Adds all the objects upon creating a new world.
     */
    public WinningWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the game page of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label winningMsg = new Label("Thank you, \nfor saving \none's life. ", 60);
        addObject(winningMsg,215,245);
        
        creditBtn = new instructionButton();
        addObject(creditBtn,50,350);
    }
    
    /**
     * Ends the game after a certain amount of time
     * Checks if user has clicked on the credit button
     */
    public void act()
    {    
        if(returnTime.millisElapsed() > 1000) { //time count down every second
            time --;
        }
        
        if (time == 0) { 
            Greenfoot.stop();
        }
        
        showCredit();
    }  
    
    /**
     * If the user clicks on the credit button, it will take them
     * to the credit screen
     */
    public void showCredit()
    {    
        if (Greenfoot.mouseClicked(creditBtn)) { //if user clicked instructions button
            Greenfoot.setWorld(new CreditWorld());
        }
    }
}
