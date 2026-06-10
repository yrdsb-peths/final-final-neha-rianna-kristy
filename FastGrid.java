import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class FastGrid extends BaseGrid
{
    private int oldSeconds = 0;
    public FastGrid()
    {    
        super(436, 436);
        addObject(new Snake(false), 90, 110);
        showText("Level: " + level, 100, 200);
    }
    
    public void act()
    {
        super.act();
    
        if (seconds != oldSeconds)
        {
            oldSeconds = seconds;
    
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
}
