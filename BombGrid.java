import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombGrid extends World
{

    /**
     * Constructor for objects of class BombGrid.
     * 
     */
    public BombGrid()
    {    
        super(436, 436, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);
    }
}
