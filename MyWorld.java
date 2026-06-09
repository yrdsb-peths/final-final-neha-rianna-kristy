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
        
        // Draw the initial board right when the game loads
        updateScoreboard();
    } 
    
    public void addScore()
    {
        score++;
        updateScoreboard(); // Redraw the scoreboard with the new score
    }
    
    public void stopBackgroundMusic()
    {
        bgMusic.stop();
        musicStarted = true; 
    }
    
    // A CUSTOM METHOD TO DRAW CLEAN TEXT ONTO THE BACKGROUND
    private void updateScoreboard()
    {
        // 1. Start with a fresh copy of your background image to clear old text
        GreenfootImage bg = new GreenfootImage("backgroundSnake.png");
        
        // 2. Set the text color and font size (Color.WHITE, 20pt font)
        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", true, false, 20));
        
        // 3. Draw the strings onto the image at specific (X, Y) coordinates
        bg.drawString("Time: " + seconds + "s", 30, 30);
        bg.drawString("Score: " + score, 480, 30);
        
        // 4. Apply this freshly drawn image as the world's background
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
            updateScoreboard(); // Redraw the scoreboard every second to update the time
        }
    }
}