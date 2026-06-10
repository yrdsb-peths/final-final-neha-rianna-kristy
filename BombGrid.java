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
    private Bomb currentBomb;
    private int bombTimer = 0;
    private boolean bombVisible = false;
    
    public BombGrid()
    {    
        super(436, 436);
        addObject(new Snake(false), 90, 110);
        
        spawnBomb();
        bombVisible = true;
        bombTimer = 0;
    }
    
    public void spawnBomb()
    {
        int numCols = getWidth() / GRID_SIZE;
        int numRows = getHeight() / GRID_SIZE;

        int col = Greenfoot.getRandomNumber(numCols);
        int row = Greenfoot.getRandomNumber(numRows);

        int x = col * GRID_SIZE + GRID_SIZE / 2;
        int y = row * GRID_SIZE + GRID_SIZE / 2;

        
        while (y <= 40) 
        {
            row = Greenfoot.getRandomNumber(numRows);
            y = row * GRID_SIZE + GRID_SIZE / 2;
        }
        
        currentBomb = new Bomb();
        addObject(currentBomb, x, y);
        bombSpawnSound.play(); 
    }
    
    public void act()
    {
        super.act();
    
        bombTimer++;
    
        if (bombVisible && bombTimer >= 300) 
        {
            if (currentBomb != null)
            {
                removeObject(currentBomb);
                currentBomb = null;
            }
    
            bombVisible = false;
            bombTimer = 0;
        }
        else if (!bombVisible && bombTimer >= 300) 
        {
            spawnBomb();
    
            bombVisible = true;
            bombTimer = 0;
        }
    }
}
