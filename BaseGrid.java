import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // REQUIRED: Lets us find the Snake in the world to speed it up

public class BaseGrid extends World
{
    public static final int GRID_SIZE = 20;

    public int time = 0;
    public int seconds = 0;
    public int score = 0;
    public boolean isGameOver = false; 
    
    // Tracks the current level
    public int level = 1; 
    
    public Scoreboard scoreboard = new Scoreboard();
    public GreenfootSound bgMusic = new GreenfootSound("background.mp3");
    public boolean musicStarted = false;

    public BaseGrid(int width, int height)
    {    
        super(width, height, 1);
        
        setBackground("easy_grid.png");
        
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
        isGameOver = true; 
    }

    public void act()
    {
        if (isGameOver)
        {
            return;
        }

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

    public void spawnBomb()
    {
        
    }

    private void prepare()
    {
    }
}