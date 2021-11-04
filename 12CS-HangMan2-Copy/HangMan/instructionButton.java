import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * InstructionButton Class - An object in which the user can click on
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class instructionButton extends Actor
{
    /**
     * Constructor for InstructionButton Class - resizes the image
     */
    public instructionButton()
    {
        getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
    }
}
