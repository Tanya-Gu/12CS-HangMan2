import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gets image and resizes it.
 * 
 * @author Tanya Gu 
 * @version Oct 27 2021
 */
public class CheckMark extends Actor
{
    public CheckMark()
    {
        getImage().scale(getImage().getWidth()/8, getImage().getHeight()/8);
    }
    /**
     * Act - do whatever the checkMark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
