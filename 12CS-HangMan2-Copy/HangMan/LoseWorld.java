import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * Tanya Gu 
 * Oct 26 2021
 */
public class LoseWorld extends World
{
    SimpleTimer returnTime = new SimpleTimer();
    int time = 250; //5s
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public LoseWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the game page of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label answerWord = new Label("The answer word is: \n"+ GameWorld.word, 60);
        addObject(answerWord, 280,120);
    }
    
    /**
     * 
     * 
     */
    public void act()
    {    
        if(returnTime.millisElapsed() > 1000) { //time count down every second
            time --;
        }
        
        if (time == 0) { 
            Greenfoot.stop();
        }
    }  
}
