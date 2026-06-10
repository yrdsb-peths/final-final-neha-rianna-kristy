import greenfoot.*;

public class SelectButton extends Button
{
    public SelectButton()
    {
        setText("SELECT GAMEMODE");
        update(false);
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        boolean hover = mouse != null && mouse.getActor() == this;

        update(hover);

        if (Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new GamemodePopup(), 500, 375);
        }
    }
}