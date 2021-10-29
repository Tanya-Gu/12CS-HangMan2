import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lightning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lightning extends Actor
{
    GreenfootImage[] lightning = new GreenfootImage[8];
    /**
     * Constructor - 
     */
    public Lightning()
    {
        for (int i = 0; i < lightning.length; i++) {
            lightning[i] = new GreenfootImage("images/lightning" + i + ".jpg");
            lightning[i].scale(lightning[i].getWidth()*125/100, lightning[i].getHeight()*125/100);
        }
        setImage(lightning[0]);
    }
    
    /**
     * Act - do whatever the Lightning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int imageIndex = 0;
    public void act()
    {
        setImage(lightning[imageIndex]);
        imageIndex = (imageIndex + 1) % lightning.length;
    }
}
