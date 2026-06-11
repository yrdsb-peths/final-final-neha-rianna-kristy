import greenfoot.*;

public class SnakeParts extends Actor
{
    private String imageName;
    /**
     * Creates a snake part using an image
     * 
     * @param picture The image file for the snake part
     */
    public SnakeParts(String picture)
    {
        imageName = picture;
        setImageScaled(picture);
    }

    /**
     * Sets and scales the snake part to the grid size
     * 
     * @param picture The image file
     */
    public void setImageScaled(String picture)
    {
        GreenfootImage img = new GreenfootImage(picture);
        img.scale(BaseGrid.GRID_SIZE, BaseGrid.GRID_SIZE);
        setImage(img);
        imageName = picture;
    }
    
    /**
     * Checks if the snakepart is touching the apple
     * 
     * @return The apple touching the part
     */
    public Actor getTouchingApple()
    {
        return getOneObjectAtOffset(0, 0, Apple.class);
    }
}