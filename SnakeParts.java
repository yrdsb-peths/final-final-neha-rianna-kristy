import greenfoot.*;

public class SnakeParts extends Actor
{
    private String imageName;
    
    public SnakeParts(String picture)
    {
        imageName = picture;
        setImageScaled(picture);
    }

    public void setImageScaled(String picture)
    {
        GreenfootImage img = new GreenfootImage(picture);
        img.scale(BaseGrid.GRID_SIZE, BaseGrid.GRID_SIZE);
        setImage(img);
        imageName = picture;
    }
    
    public void act()
    {
    }

    public Actor getTouchingApple()
    {
        return getOneObjectAtOffset(0, 0, Apple.class);
    }
}