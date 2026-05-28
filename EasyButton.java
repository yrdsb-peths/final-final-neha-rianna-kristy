import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EasyButton extends Actor
{
    private GreenfootImage clearImg;
    private GreenfootImage whiteImg;

    public EasyButton()
    {
        // Create the two different look states for your button
        // "easy_button_clear.png" and "easy_button_white.png" are placeholders!
        // Replace them with your actual button image filenames if you have them.
        clearImg = new GreenfootImage("easy_button_clear.png");
        whiteImg = new GreenfootImage("easy_button_white.png");
        
        // Set the starting image
        setImage(clearImg);
    }

    public void setWhiteBackground()
    {
        setImage(whiteImg);
    }

    public void setClearBackground()
    {
        setImage(clearImg);
    }
}
