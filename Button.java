import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String text;
    
    public void setText(String text)
    {
        this.text = text;
        setClearBackground();
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    
        public void setClearBackground()
    {
        GreenfootImage img = new GreenfootImage(text, 30, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
        img.setFont(new Font("Monospaced", true, false, 30));
        setImage(img);
    }
    
    public void setWhiteBackground()
    {
        GreenfootImage img = new GreenfootImage(text, 30, Color.WHITE, Color.WHITE, Color.BLACK);
        img.setFont(new Font("Monospaced", true, false, 30));
        setImage(img);
    }
}
