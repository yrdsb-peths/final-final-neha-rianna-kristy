import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyGrid extends World
{

    public static final int GRID_SIZE = 20;
    public EasyGrid()
    {    
        super(218, 218, 1);
        setBackground("easy_grid.png");
        addObject(new Snake(), 90, 110);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
