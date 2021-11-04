import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lightning Class - Uses sprites and creates an animation
 * 
 * @author Tanya Gu
 * @version Oct 27 2021
 */
public class Lightning extends Actor
{
    GreenfootImage[] lightning = new GreenfootImage[8];
    /**
     * Constructor for Lightning Class - sets the image
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
     * Called every act; Make the images animated
     */
    int imageIndex = 0;
    public void act()
    {
        setImage(lightning[imageIndex]);
        imageIndex = (imageIndex + 1) % lightning.length;
    }
}
