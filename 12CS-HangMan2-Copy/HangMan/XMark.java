import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * xMark Class - An object that tells the user if they entered incorrectly
 * 
 * @author Tanya Gu
 * @version Oct 30 2021
 */
public class XMark extends Actor
{
    /**
     * Constructor for XMark Class - resizes the image
     */
    public XMark()
    {
        getImage().scale(getImage().getWidth()/18, getImage().getHeight()/18);
    }
}
