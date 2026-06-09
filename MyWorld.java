import greenfoot.*;

public class MyWorld extends World
{
    private int time = 0;
    private int seconds = 0;
    
    // LOAD THE BACKGROUND MUSIC
    private GreenfootSound bgMusic = new GreenfootSound("the_mountain-game-game-music-508018 (1).mp3");
    
    public MyWorld()
    {
        super(600, 300, 1);
        setBackground("backgroundSnake.png");
    } 
    
    // Fallback native checks
    public void started()
    {
        bgMusic.playLoop();
    }

    public void stopped()
    {
        bgMusic.pause();
    }

    // A method so the snake can turn off the music when it dies
    public void stopBackgroundMusic()
    {
        if (bgMusic.isPlaying())
        {
            bgMusic.stop();
        }
    }
    
    public void act()
    {
        // --- BULLETPROOF AUDIO FALLBACK ---
        // If the game is running but the music hasn't started yet, force play it!
        if (!bgMusic.isPlaying()) 
        {
            bgMusic.playLoop();
        }

        time++;
    
        if(time % 60 == 0)
        {
            seconds++;
        }
    
        showText("Time: " + seconds, 80, 20);
    }
}