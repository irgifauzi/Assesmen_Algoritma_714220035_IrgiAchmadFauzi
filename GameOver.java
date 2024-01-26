import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1); 
        GreenfootImage img = new GreenfootImage ("gameover.jpg");
        img.scale (getWidth(), getHeight());
        setBackground(img);
    }
}
