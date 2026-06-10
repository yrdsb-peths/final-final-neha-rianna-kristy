import greenfoot.*;

public class MyWorld extends World
{
    private int time = 0;
    private int seconds = 0;
    private int score = 0;
    
    private GreenfootSound bgMusic = new GreenfootSound("background.wav");
    private boolean musicStarted = false;
    
    public MyWorld()
    {
        super(600, 300, 1);
        setBackground("backgroundSnake.png");
        
        
        updateScoreboard();
    } 
    
    public void addScore()
    {
        score++;
        updateScoreboard();
    }
    
    public void stopBackgroundMusic()
    {
        bgMusic.stop();
        musicStarted = true; 
    }
    
    
    private void updateScoreboard()
    {
        GreenfootImage bg = new GreenfootImage("backgroundSnake.png");
        
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", true, false, 20));
        
        bg.drawString("Time: " + seconds + "s", 30, 30);
        bg.drawString("Score: " + score, 480, 30);
        
        setBackground(bg);
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
            updateScoreboard(); 
        }
    }
}