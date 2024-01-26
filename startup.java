import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startup extends World
{

    /**
     * Constructor for objects of class startup.
     * 
     */
    public startup()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1); 
    }
    
    public void act(){
        start();
    }

    public void start(){
        if (Greenfoot.isKeyDown("enter"))
        {
            MyWorld Next= new MyWorld();
            Greenfoot.setWorld(Next);
        }
    }
}