import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gets image and resizes it.
 * 
 * @author Tanya Gu 
 * @version Oct 27 2021
 */
public class instructionButton extends Actor
{
    public instructionButton()
    {
        getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
    }
    /**
     * Act - do whatever the instructionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
