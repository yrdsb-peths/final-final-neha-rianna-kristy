import greenfoot.*;

public class MyWorld extends World
{
    private int time = 0;
    private int seconds = 0;
    public MyWorld()
    {    
        super(600, 400, 1);

        setBackground("background.png");
        
    }
    
    public void act()
    {
        time++;
    
        if(time % 60 == 0)
        {
            seconds++;
        }
    
        showText("Time: " + seconds, 80, 20);
    }
}