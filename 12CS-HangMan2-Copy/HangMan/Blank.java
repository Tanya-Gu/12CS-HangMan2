import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Gets image and resizes it.
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class Blank extends Actor
{
    public Blank()
    {
        getImage().scale(getImage().getWidth()/3, getImage().getHeight()/3);
    }
    /**
     * Act - do whatever the Blank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
