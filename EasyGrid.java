import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyGrid here.
 * 
 * @author (Rianna) 
 * @version (June 2026)
 */
import greenfoot.*;

public class EasyGrid extends World
{
    public static final int GRID_SIZE = 20;

    private int time = 0;
    private int seconds = 0;
    private int score = 0;
    
    private Scoreboard scoreboard = new Scoreboard();
    private GreenfootSound bgMusic = new GreenfootSound("background.mp3");
    private boolean musicStarted = false;

    public EasyGrid()
    {    
        super(218, 218, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);
        
        // Adding the scoreboard to the screen (centered near the top)
        addObject(scoreboard, 109, 20); 
        
        prepare();
    }

    public void addScore()
    {
        score++;
        scoreboard.updateValues(score, seconds);
    }
    
    public void stopBackgroundMusic()
    {
        bgMusic.stop();
        musicStarted = true; 
    }

    public void act()
    {
        if (!musicStarted) 
        {
            bgMusic.playLoop();
            musicStarted = true;
        }

        time++;
    
        if(time % 60 == 0)
        {
            seconds++;
            scoreboard.updateValues(score, seconds);
        }
    }

    
    private void prepare()
    {
        
    }
}
