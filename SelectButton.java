import greenfoot.*;

public class SelectButton extends Button
{
    private String text = "SELECT GAMEMODE";
    private boolean hover = false;

    public SelectButton()
    {
        updateImage();
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        hover = (mouse != null && mouse.getActor() == this);
        updateImage();

        if (Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new GamemodePopup(), 500, 375);
        }
    }

    private void updateImage()
    {
        Color textColor = hover ? Color.BLACK : Color.WHITE;

        GreenfootImage img = new GreenfootImage(text, 70, textColor, new Color(0,0,0,0));
        img.setFont(new Font("Monospaced", true, false, 30));

        GreenfootImage outline = new GreenfootImage(text, 70, Color.BLACK, new Color(0,0,0,0));
        outline.setFont(new Font("Monospaced", true, false, 30));

        GreenfootImage result = new GreenfootImage(img.getWidth() + 6, img.getHeight() + 6);

        result.drawImage(outline, 2, 2); 
        result.drawImage(img, 0, 0);   

        setImage(result);
    }
}