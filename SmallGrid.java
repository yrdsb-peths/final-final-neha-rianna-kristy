import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SmallGrid extends BaseGrid
{
    public SmallGrid()
    {
        super(350, 306);

        addObject(new Snake(false), 198, 154);
    }
}
