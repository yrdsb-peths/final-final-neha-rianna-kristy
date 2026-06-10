import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class FastGrid extends BaseGrid
{
    private int oldSeconds = 0;
    public FastGrid()
    {    
        super(436, 436);
        addObject(new Snake(false), 90, 110);
    }
    
    public void act()
    {
        super.act();
        showText("Level: " + level, 259, 20);
        
        if (seconds != oldSeconds)
        {
            oldSeconds = seconds;
    
            if (seconds % 5 == 0)
            {
                level++;
    
                showText("Level: " + level, 259, 20);
    
                List<Snake> snakes = getObjects(Snake.class);
    
                if (!snakes.isEmpty())
                {
                    snakes.get(0).increaseSpeed();
                }
            }
        }
    }
}
