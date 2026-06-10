import greenfoot.*;

public class ReverseButton extends Button
{
    private String text = "Reverse";

    public ReverseButton()
    {
        updateImage();
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ReverseGrid());
        }
    }

    private void updateImage()
    {
        GreenfootImage textImg = new GreenfootImage(text, 60, Color.BLACK, new Color(0,0,0,0));
        textImg.setFont(new Font("Monospaced", true, false, 30));

        setImage(textImg);
    }
}
