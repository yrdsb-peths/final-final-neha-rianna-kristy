import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // ADDED THIS LINE

public class EasyGrid extends World
{
    public static final int GRID_SIZE = 20;

    private int time = 0;
    private int seconds = 0;
    private int score = 0;
    private boolean isGameOver = false; 
    
    private int level = 1; // ADDED THIS LINE
    
    private Scoreboard scoreboard = new Scoreboard();
    private GreenfootSound bgMusic = new GreenfootSound("background.mp3");
    private boolean musicStarted = false;
    
    // Sound that plays when a bomb appears
    private GreenfootSound bombSpawnSound = new GreenfootSound("bomb_spawn.mp3");

    public EasyGrid()
    {    
        super(218, 218, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);
        
        addObject(scoreboard, 109, 20); 
        
        showText("Level: " + level, 109, 5); // ADDED THIS LINE
        prepare();
    }

    // This is the method that drops a bomb randomly on your grid
    public void spawnBomb()
    {
        int numCols = getWidth() / GRID_SIZE;
        int numRows = getHeight() / GRID_SIZE;

        int col = Greenfoot.getRandomNumber(numCols);
        int row = Greenfoot.getRandomNumber(numRows);

        int x = col * GRID_SIZE + GRID_SIZE / 2;
        int y = row * GRID_SIZE + GRID_SIZE / 2;

        // Keep it below the scoreboard area
        if (y > 40) 
        {
            addObject(new Bomb(), x, y);
            bombSpawnSound.play(); // Plays your spawn audio!
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
            
            // --- ADDED THIS BLOCK BELOW ---
            if (seconds % 5 == 0)
            {
                level++;
                showText("Level: " + level, 109, 5);
                
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