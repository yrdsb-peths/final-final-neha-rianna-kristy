import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
        public void setClearBackground()
    {
        GreenfootImage img = new GreenfootImage(" How To Play ", 30, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
        img.setFont(new Font("Arial", true, false, 30));
        setImage(img);
    }
    
    public void setWhiteBackground()
    {
        GreenfootImage img = new GreenfootImage(" How To Play ", 30, Color.WHITE, Color.WHITE, Color.BLACK);
        img.setFont(new Font("Arial", true, false, 30));
        setImage(img);
    }
}
