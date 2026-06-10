import greenfoot.*;

public class GamemodePopup extends Actor
{
    public GamemodePopup()
    {
        GreenfootImage img = new GreenfootImage(700, 500);

        img.setColor(Color.WHITE);
        img.fillRect(0, 0, 700, 500);

        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 699, 499);

        setImage(img);
    }

    public void addedToWorld(World world)
    {
        world.addObject(new ClassicButton(), 300, 225);
        world.addObject(new BombsButton(), 300, 375);
        world.addObject(new FastButton(), 300, 525);
        world.addObject(new ReverseButton(), 600, 225);
        world.addObject(new MegaButton(), 600, 375);
        world.addObject(new AppleRainButton(), 600, 525);
    }
}