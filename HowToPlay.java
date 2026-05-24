import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HowToPlay extends Actor
{
    public HowToPlay()
    {
        GreenfootImage img = new GreenfootImage(" How To Play ", 30, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
        img.setFont(new Font("Arial", true, false, 30));
        setImage(img);
    }
    
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
