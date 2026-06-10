import greenfoot.*;

public class SnakeParts extends Actor
{
    public SnakeParts(String picture)
    {
        GreenfootImage img = new GreenfootImage(picture);
        img.scale(EasyGrid.GRID_SIZE, EasyGrid.GRID_SIZE);
        setImage(img);
    }

    public void act()
    {
    }

    public Actor getTouchingApple()
    {
        return getOneObjectAtOffset(0, 0, Apple.class);
    }
}