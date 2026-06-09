import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (Rianna) 
 * @version (June 2026background.wav)
 */
public class Scoreboard extends Actor
{
    private int score = 0;
    private int seconds = 0;

    public Scoreboard()
    {
        updateImage();
    }

    public void updateValues(int newScore, int newSeconds)
    {
        this.score = newScore;
        this.seconds = newSeconds;
        updateImage();
    }

    private void updateImage()
    {
        // Creates a transparent box (Width: 200 pixels, Height: 40 pixels)
        GreenfootImage img = new GreenfootImage(200, 40);
        
        // Customize text appearance
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", true, false, 18));
        
        // Draw the scoreboard text onto the box
        img.drawString("Time: " + seconds + "s | Score: " + score, 5, 25);
        
        setImage(img);
    }
}
