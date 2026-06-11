import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SmallGrid extends BaseGrid
{
    /**
     * Constructor for objects of small grid 
     */
    public SmallGrid()
    {
        super(350, 306);

        addObject(new Snake(false), 198, 154);
    }
}
