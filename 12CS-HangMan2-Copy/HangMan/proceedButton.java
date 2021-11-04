import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ProceedButton Class - An object in which the user can click on
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class proceedButton extends Actor
{
    /**
     * Constructor for ProceedButton Class - resizes the image
     */
    public proceedButton()
    {
        getImage().scale(getImage().getWidth()/6, getImage().getHeight()/6);
    }
}
