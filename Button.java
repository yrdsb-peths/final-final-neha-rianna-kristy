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
    private boolean isWhite = false;
    
    /**
     * Sets text on the button and makes the background clear
     * 
     * @param text The text for the button
     */
    public void setText(String text)
    {
        this.text = text;
        isWhite = true;
        setClearBackground();
    }
    
    /**
     * Makes the background of the button clear
     */
    public void setClearBackground()
    {
        if (!isWhite)
        {
            return;
        }
        
        GreenfootImage img = new GreenfootImage(text, 50, Color.WHITE, new Color(0, 0, 0, 0), Color.BLACK);
        img.setFont(new Font("Monospaced", true, false, 30));
        setImage(img);
        
        isWhite = false;
    }
    
    /**
     * Makes the background of the button white
     */
    public void setWhiteBackground()
    {
        if (isWhite) 
        {
            return;
        }
        GreenfootImage img = new GreenfootImage(text, 50, Color.WHITE, Color.WHITE, Color.BLACK);
        img.setFont(new Font("Monospaced", true, false, 30));
        setImage(img);
        
        isWhite = true;
    }
}
