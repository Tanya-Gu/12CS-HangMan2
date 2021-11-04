import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LoseWorld - Displays if the player loses the game (Does not guess all the words within the time limit)
 * 
 * @author Tanya Gu and Marissa Abesdris
 * @version Oct 28 2021
 */
public class LoseWorld extends World
{
    SimpleTimer returnTime = new SimpleTimer();
    int time = 250; //5s
    instructionButton creditBtn;
    String word;
    GreenfootSound bgm;
    /**
     * Constructor for LoseWorld - Calls super class, initializes objects and adds them to the world.
     * 
     * @param bgm
     */
    public LoseWorld(String word, GreenfootSound bgm)
    {    
        // Create a new world with 590x440 cells with a cell size of 1x1 pixels.
        super(590, 440, 1); 
        
        this.word = word;
        this.bgm = bgm;
        
        prepare();
    }
    
    /**
     * Prepare the LoseWorld for the program - Create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label losemsg = new Label("GameOver", 70);
        addObject(losemsg, 300,90);
        
        Label answerWord = new Label("The answer word is: \n"+ word, 40);
        addObject(answerWord, 300,385);
        
        creditBtn = new instructionButton();
        addObject(creditBtn,50,390);
    }
    
    /**
     * Called every act, displays the credit page if applicable
     */
    public void act()
    {    
        if(returnTime.millisElapsed() > 1000) { //time count down every second
            time --;
        }
        
        if (time == 0) { 
            bgm.stop();
            Greenfoot.stop();
        }
        
        showCredit(); 
    }  
    
    /**
     * If the player clicks on the credit button, the credit world will be displayed
     */
    public void showCredit()
    {    
        if (Greenfoot.mouseClicked(creditBtn)) { //if user clicked credit button
            Greenfoot.setWorld(new CreditWorld()); //display credit world
            Greenfoot.stop();
        }
    }
}
