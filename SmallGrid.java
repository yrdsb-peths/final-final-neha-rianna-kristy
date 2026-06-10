import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AllApplesGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallGrid extends BaseGrid
{
    public SmallGrid()
    {
        super(350, 306);

        addObject(new Snake(false), 330, 286);
    }
}
