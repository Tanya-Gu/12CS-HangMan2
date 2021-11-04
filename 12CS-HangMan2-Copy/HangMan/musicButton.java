import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MusicButton Class - An object in which the user can click on
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class musicButton extends Actor
{
    /**
     * Constructor for MusicButton Class - resizes the image
     */
    public musicButton()
    {
        getImage().scale(getImage().getWidth()/6, getImage().getHeight()/6);
    }
}
