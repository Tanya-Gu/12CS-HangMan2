import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class instructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{
    proceedButton proceed;
    /**
     * Constructor for objects of class instructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 550x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        
        Label instruction1 = new Label("1. Your goal is to guess the right word \n 2. You have a limited amount of tries and time ", 30);
        addObject(instruction1,310,50);
        
        proceed = new proceedButton();
        addObject(proceed, 100, 420);
    }
    
    public void act()
    {    
        proceedGame();
    }
    
    /**
     * 
     * 
     */
    public void proceedGame()
    {    
        if (Greenfoot.mouseClicked(proceed)) { //if user clicked proceed
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
