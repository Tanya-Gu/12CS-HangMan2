import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * Tanya Gu 
 * Oct 26 2021
 */
public class WinningWorld extends World
{
    SimpleTimer returnTime = new SimpleTimer();
    int time = 250; //5s
    /**
     * Constructor for objects of class EndWorld.
     * 
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
    }
    
    /**
     * 
     * 
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
