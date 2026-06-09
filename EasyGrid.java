import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyGrid here.
 * * @author (Rianna) 
 * @version (June 2026)
 */
public class EasyGrid extends World
{
    public static final int GRID_SIZE = 20;

    private int time = 0;
    private int seconds = 0;
    private int score = 0;
    
    // 1. ADD THIS FLAG TO TRACK IF THE PLAYER IS ALIVE OR DEAD
    private boolean isGameOver = false; 
    
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
        
        // 2. TRIGGER THE GAME OVER FLAG TO FREEZE THE WORLD TIMER
        isGameOver = true; 
    }

    public void act()
    {
        // 3. IF THE SNAKE DIES, EXIT IMMEDIATELY SO TIME STOPS INCREASING!
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

    private void prepare()
    {
        
    }
}