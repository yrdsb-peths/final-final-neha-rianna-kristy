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
        world.addObject(new ClassicButton(), 350, 225);
        world.addObject(new BombsButton(), 350, 375);
        world.addObject(new FastButton(), 350, 525);
        world.addObject(new ReverseButton(), 650, 225);
        world.addObject(new MegaButton(), 650, 375);
        world.addObject(new AppleRainButton(), 650, 525);
    }
}