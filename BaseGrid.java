import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class BaseGrid extends World
{
    //800x700
    public static final int GRID_SIZE = 49;

    public int time = 0;
    public int seconds = 0;
    public int score = 0;
    public boolean isGameOver = false;
    public boolean isWin = false; 
    
    public int level = 1; 
    
    public Scoreboard scoreboard = new Scoreboard();
    public GreenfootSound bgMusic = new GreenfootSound("background.mp3");
    public boolean musicStarted = false;
    
    public String mode = "classic";

    public BaseGrid(int width, int height)
    {    
        super(width, height, 1);
        
        setBackground("mediumgrid.png");
        
        addObject(scoreboard, 109, 20); 

        
        prepare();
    }

    public void addScore()
    {
        score++;
        scoreboard.updateValues(score, seconds);
        
        checkWinCondition();
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

    public void restart()
    {
        Greenfoot.setWorld(new BaseGrid(getWidth(), getHeight()));
    }
    
    public void checkWinCondition()
    {
        if (isGameOver)
        {
            return;
        }
    
        int targetScore;
    
        if (this instanceof SmallGrid)
        {
            targetScore = 56;
        }
        else if (this instanceof MegaGrid)
        {
            targetScore = 323;
        }
        else
        {
            targetScore = 224;
        }
    
        if (score == targetScore)
        {
            isGameOver = true;
            isWin = true;
    
            stopBackgroundMusic();
    
            addObject(
                new EndPopup("YOU WIN!", this),
                getWidth() / 2,
                getHeight() / 2
            );
        }
    }
    
    public void spawnBomb()
    {
        
    }

    private void prepare()
    {
    }
}