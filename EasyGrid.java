import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // REQUIRED: Lets us find the Snake in the world to speed it up

public class EasyGrid extends World
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
    
    // Sound that plays when a bomb appears
    private GreenfootSound bombSpawnSound = new GreenfootSound("bomb_spawn.mp3");

    public EasyGrid()
    {    
        super(436, 436, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(false), 90, 110);
        
        addObject(scoreboard, 109, 20); 
        
        showText("Level: " + level, 100, 200);
        
        prepare();
    }

    public void spawnBomb()
    {
        int numCols = getWidth() / GRID_SIZE;
        int numRows = getHeight() / GRID_SIZE;

        int col = Greenfoot.getRandomNumber(numCols);
        int row = Greenfoot.getRandomNumber(numRows);

        int x = col * GRID_SIZE + GRID_SIZE / 2;
        int y = row * GRID_SIZE + GRID_SIZE / 2;

        
        if (y > 40) 
        {
            addObject(new Bomb(), x, y);
            bombSpawnSound.play(); 
        }
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

    private void prepare()
    {
    }
}