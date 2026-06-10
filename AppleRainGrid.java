import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AllApplesGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppleRainGrid extends BaseGrid
{
    public AppleRainGrid()
    {
        super(800, 659);

        addObject(new Snake(false), 90, 110);

        int gridSize = BaseGrid.GRID_SIZE;
        
        mode = "appleRain";

        for (int x = gridSize / 2; x < getWidth(); x += gridSize)
        {
            for (int y = 50; y < getHeight(); y += gridSize)
            {
                addObject(new Apple(), x, y);
            }
        }
    }
}
