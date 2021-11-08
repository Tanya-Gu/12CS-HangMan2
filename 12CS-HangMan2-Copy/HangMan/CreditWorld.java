import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Credit World - Show authors of the game
 * 
 * @author Tanya Gu and Marissa Abesdris
 * @version Oct 28 2021
 */
public class CreditWorld extends World
{
    /**
     * Constructor of CreditWorld - Calls super class and adds a label
     * 
     */
    public CreditWorld()
    {    
        // Create a new world with 800x540 cells with a cell size of 1x1 pixels.
        super(800, 540, 1); 
        
        Label subtitleLabel = new Label("Credits \n\u27D0Sherman Leung \n\u27D0Tanya Gu \n\u27D0Marissa Abesdris", 30);
        addObject(subtitleLabel, 405, 280);
    }
}
