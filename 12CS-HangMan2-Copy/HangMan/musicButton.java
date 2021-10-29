import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gets image and resizes it.
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class musicButton extends Actor
{
    public musicButton()
    {
        getImage().scale(getImage().getWidth()/6, getImage().getHeight()/6);
    }
    
    /**
     * Act - do whatever the musicButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
