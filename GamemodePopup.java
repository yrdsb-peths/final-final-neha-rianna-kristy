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
        world.addObject(new ClassicButton(), 350, 200);
        world.addObject(new BombsButton(), 350, 300);
        world.addObject(new FastButton(), 350, 400);
        world.addObject(new ReverseButton(), 350, 500);
        world.addObject(new MegaButton(), 350, 600);
    }
}