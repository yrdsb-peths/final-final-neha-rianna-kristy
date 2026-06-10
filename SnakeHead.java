import greenfoot.*;

public class SnakeHead extends SnakeParts
{
    private GreenfootImage[] headFrames = new GreenfootImage[10];
    private int currentFrame = 0;
    private int timer = 0;

    public SnakeHead()
    {
        super("head0.png");

        for (int i = 0; i < 10; i++)
        {
            headFrames[i] = new GreenfootImage("head" + i + ".png");
            headFrames[i].scale(EasyGrid.GRID_SIZE, EasyGrid.GRID_SIZE);
        }

        setImage(headFrames[0]);
    }

    public void act()
    {
        timer++;

        if (timer >= 10)
        {
            currentFrame = (currentFrame + 1) % 10;
            setImage(headFrames[currentFrame]);
            timer = 0;
        }
    }
}