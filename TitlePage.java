import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitlePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePage extends World
{
    private HowToPlay howToPlay;
    private Start start; 
    
    public TitlePage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();

    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(howToPlay))
        {
            howToPlay.setWhiteBackground();
        }
        if (Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse == null || mouse.getActor() != howToPlay)
            {
                howToPlay.setClearBackground();
            }
        }     
        
        if (Greenfoot.mouseMoved(start))
        {
            start.setWhiteBackground();
        }
        if (Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse == null || mouse.getActor() != start)
            {
                start.setClearBackground();
            }
        }  
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Snake", 70);
        addObject(label,300,150);
        
        start = new Start();
        addObject(start, 300, 240);
        
        howToPlay = new HowToPlay();
        addObject(howToPlay, 300, 300);
        howToPlay.setLocation(294,311);
        howToPlay.setLocation(306,314);
        howToPlay.setLocation(298,314);
        howToPlay.setLocation(298,314);
        howToPlay.setLocation(293,314);
    }
}
