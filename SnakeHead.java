import greenfoot.*;

public class SnakeHead extends SnakeParts
{
    private GreenfootImage[] headFrames = new GreenfootImage[9];
    private int currentFrame = 0;
    private int timer = 0;

    public SnakeHead()
    {
        super("head0.png");

        for (int i = 0; i < 9; i++)
        {
            headFrames[i] = new GreenfootImage("head" + i + ".png");
        }

        setImage(headFrames[0]);
    }

    public void act()
    {
        timer++;

        if (timer >= 5)
        {
            currentFrame = (currentFrame + 1) % 9;
            setImage(headFrames[currentFrame]);
            timer = 0;
        }
    }
}