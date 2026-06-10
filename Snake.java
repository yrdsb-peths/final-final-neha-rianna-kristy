import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Snake extends Actor
{
    private int gridSize = BaseGrid.GRID_SIZE;
    private ArrayList<SnakeParts> parts = new ArrayList<SnakeParts>();

    private int xSpeed = 0;
    private int ySpeed = 0;
    private boolean isStarted = false;

    private int counter = 0;
    private int moveDelay = 10;
    private boolean isDead = false;

    private GreenfootSound eatSound = new GreenfootSound("eat_apple.wav");
    private GreenfootSound gameOverSound = new GreenfootSound("game_over.wav"); 
    
    // Sound that plays when you hit a bomb
    private GreenfootSound bombExplodeSound = new GreenfootSound("bomb_explode.mp3");
    
    private boolean reverseControls;

    public Snake(boolean reverseControls)
    {
        setImage(new GreenfootImage(1,1));
        this.reverseControls = reverseControls;
    }

    public void addedToWorld(World world)
    {
        SnakeHead head = new SnakeHead();
        SnakeParts body = new SnakeParts("middle.png");
        SnakeParts tail = new SnakeParts("tail.png");

        parts.add(head);
        parts.add(body);
        parts.add(tail);

        world.addObject(head, getX(), getY());
        world.addObject(body, getX() + gridSize, getY());
        world.addObject(tail, getX() + gridSize * 2, getY());
        spawnApple();
    }

    public void act()
    {
        if (isDead) 
        {
            return; 
        }

        checkKeys();
        counter++;

        if (counter >= moveDelay && isStarted)
        {
            moveSnake();

            if (checkWallCollision())
            {
                executeGameOver("GAME OVER");
                return;
            }

            if (checkSelfCollision())
            {
                executeGameOver("GAME OVER");
                return;
            }
            
            checkBombCollision();
            if (isDead) return; 
            
            checkApple();
            counter = 0;
        }
    }
    
    private void moveSnake()
    {
        for (int i = parts.size() - 1; i > 0; i--)
        {
            SnakeParts current = parts.get(i);
            SnakeParts inFront = parts.get(i - 1);
            
            int xMove = inFront.getX() - current.getX();
            int yMove = inFront.getY() - current.getY();
            
            current.setLocation(inFront.getX(), inFront.getY());
            rotatePart(current, xMove, yMove);
        }

        SnakeParts head = parts.get(0);
        head.setLocation(head.getX() + xSpeed, head.getY() + ySpeed);
        rotatePart(head, xSpeed, ySpeed);
    }
    
    private void checkKeys()
    {
        if (!reverseControls)
        {
            if (Greenfoot.isKeyDown("up") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = -gridSize;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("down") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = gridSize;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("left") && xSpeed == 0)
            {
                xSpeed = -gridSize;
                ySpeed = 0;
                isStarted = true;
            }
            else if (Greenfoot.isKeyDown("right") && xSpeed == 0)
            {
                xSpeed = gridSize;
                ySpeed = 0;
                isStarted = true;
            }
        }
        else
        {
            // Reversed controls
            if (Greenfoot.isKeyDown("up") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = gridSize;
            }
            else if (Greenfoot.isKeyDown("down") && ySpeed == 0)
            {
                xSpeed = 0;
                ySpeed = -gridSize;
            }
            else if (Greenfoot.isKeyDown("left") && xSpeed == 0)
            {
                xSpeed = gridSize;
                ySpeed = 0;
            }
            else if (Greenfoot.isKeyDown("right") && xSpeed == 0)
            {
                xSpeed = -gridSize;
                ySpeed = 0;
            }
        }
    }
    
    private void spawnApple()
    {
        int numCols = getWorld().getWidth() / gridSize;
        int numRows = getWorld().getHeight() / gridSize;
    
        int col = Greenfoot.getRandomNumber(numCols);
        int row = Greenfoot.getRandomNumber(numRows);
    
        int x = col * gridSize + gridSize / 2;
        int y = row * gridSize + gridSize / 2;
    
        getWorld().addObject(new Apple(), x, y);        
    }
    
    private void checkApple()
    {
        SnakeParts head = parts.get(0);
        Actor apple = head.getTouchingApple();
    
        if (apple != null)
        {
            eatSound.play(); 
            ((BaseGrid)getWorld()).addScore(); 
            getWorld().removeObject(apple);
            growSnake();
            if (!(getWorld() instanceof AppleRainGrid))
            {
                spawnApple();
            }
        }
    }

    private void checkBombCollision()
    {
        SnakeParts head = parts.get(0);
        
        // Look at the head's exact X and Y position for any Bombs
        List<Bomb> bombs = getWorld().getObjectsAt(head.getX(), head.getY(), Bomb.class);
        
        if (!bombs.isEmpty())
        {
            // Get the bomb we stepped on
            Bomb hitBomb = bombs.get(0);
            
            // Stop music and play explosion!
            ((BaseGrid)getWorld()).stopBackgroundMusic();
            bombExplodeSound.play(); 
            
            // Remove it from the grid
            getWorld().removeObject(hitBomb);
            
            // End the game
            executeGameOver("BOOM! GAME OVER");
        }
    }

    private void growSnake()
    {
        SnakeParts tail = parts.get(parts.size() - 1);
        SnakeParts newPart = new SnakeParts("middle.png");
        parts.add(parts.size()-1, newPart);
        getWorld().addObject(newPart, tail.getX(), tail.getY());
    }
    
    private boolean checkWallCollision()
    {
        SnakeParts head = parts.get(0);
        return head.getX() < 0 || head.getX() >= getWorld().getWidth() || head.getY() < 0 || head.getY() >= getWorld().getHeight();
    }
    
    private boolean checkSelfCollision()
    {
        SnakeParts head = parts.get(0);
        for (int i = 1; i < parts.size(); i++)
        {
            SnakeParts part = parts.get(i);
            if (head.getX() == part.getX() && head.getY() == part.getY())
            {
                return true;
            }
        }
        return false;
    }

    private void executeGameOver(String message)
    {
        ((BaseGrid)getWorld()).stopBackgroundMusic();
        isDead = true;
    
        BaseGrid world = (BaseGrid)getWorld();
    
        world.addObject(new EndPopup(message), world.getWidth()/2, world.getHeight()/2);
    }
    
    public void increaseSpeed()
    {
        if (moveDelay > 2)
        {
            moveDelay--; 
        }
    }
    
    private void rotatePart(SnakeParts part, int xMove, int yMove)
    {
        if (xMove > 0)
        {
            part.setRotation(180);
        }
        else if (xMove < 0)
        {
            part.setRotation(0);
        }
        else if (yMove > 0)
        {
            part.setRotation(270);
        }
        else if (yMove < 0)
        {
            part.setRotation(90);
        }
    }
}