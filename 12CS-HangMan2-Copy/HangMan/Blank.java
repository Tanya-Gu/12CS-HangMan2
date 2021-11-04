import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Blank Class - An object in which the user can click on
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class Blank extends Actor
{
    /**
     * Constructor for Blank Class - resizes the image
     */
    public Blank()
    {
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
}
