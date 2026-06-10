import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombGrid extends BaseGrid
{
    private GreenfootSound bombSpawnSound = new GreenfootSound("bomb_spawn.mp3");
    
    public BombGrid()
    {    
        addObject(new Snake(false), 90, 110);
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
}
