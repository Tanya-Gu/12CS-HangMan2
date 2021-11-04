import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CheckMark Class - An object that tells the user if they entered correctly
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class CheckMark extends Actor
{
    /**
     * Constructor for CheckMark Class - resizes the image
     */
    public CheckMark()
    {
        getImage().scale(getImage().getWidth()/8, getImage().getHeight()/8);
    }
}
