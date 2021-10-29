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
        super(550, 400, 1); 
        
        Label instruction1 = new Label("1. xxxx \n 2. yyyyy", 30);
        addObject(instruction1,70,50);
        
        proceed = new proceedButton();
        addObject(proceed, 100, 355);
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
