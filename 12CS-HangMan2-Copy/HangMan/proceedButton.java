import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gets image and resizes it.
 * 
 * @author Tanya Gu 
 * @version Oct 27 2021
 */
public class proceedButton extends Actor
{
    public proceedButton()
    {
        getImage().scale(getImage().getWidth()/6, getImage().getHeight()/6);
    }
    
    /**
     * Act - do whatever the proceedButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
