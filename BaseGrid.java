import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // REQUIRED: Lets us find the Snake in the world to speed it up

public class BaseGrid extends World
{
    public static final int GRID_SIZE = 20;

    private int time = 0;
    private int seconds = 0;
    private int score = 0;
    private boolean isGameOver = false; 
    
    // Tracks the current level
    private int level = 1; 
    
    private Scoreboard scoreboard = new Scoreboard();
    private GreenfootSound bgMusic = new GreenfootSound("background.mp3");
    private boolean musicStarted = false;

    public BaseGrid(int width, int height)
    {    
        super(width, height, 1);
        
        setBackground("easy_grid.png");
        
        addObject(scoreboard, 109, 20); 
        
        showText("Level: " + level, 100, 200);
        
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
            
            // Every 5 seconds, increase the difficulty level!
            if (seconds % 5 == 0)
            {
                level++;
                
                showText("Level: " + level, 100, 200);
                
                List<Snake> snakes = getObjects(Snake.class);
                if (!snakes.isEmpty())
                {
                    snakes.get(0).increaseSpeed();
                }
            }
        }
    }

    public void spawnBomb()
    {
        
    }

    private void prepare()
    {
    }
}