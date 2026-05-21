import greenfoot.*;

public class MyWorld extends World 
{
    // These numbers define our cowboy snake grid
    public static final int TILE_SIZE = 30; 
    public static final int GRID_WIDTH = 20;  // 20 tiles * 30 pixels = 600 pixels wide
    public static final int GRID_HEIGHT = 20; // 20 tiles * 30 pixels = 600 pixels high

    public MyWorld() 
    {
        super(GRID_WIDTH, GRID_HEIGHT, TILE_SIZE, true); 
        
        setBackground("game_background.png");
        GreenfootImage bg = getBackground();
        bg.scale(GRID_WIDTH * TILE_SIZE, GRID_HEIGHT * TILE_SIZE);
        
        //Draw the grid overlay lines so you can see the tiles
        bg.setColor(new Color(0, 0, 0, 75)); 
        
        // Draw vertical lines
        for (int i = 0; i <= GRID_WIDTH; i++) {
            int x = i * TILE_SIZE;
            bg.drawLine(x, 0, x, getHeight() * TILE_SIZE);
        }
        
        // Draw horizontal lines
        for (int j = 0; j <= GRID_HEIGHT; j++) {
            int y = j * TILE_SIZE;
            bg.drawLine(0, y, getWidth() * TILE_SIZE, y);
        }
    }
}
