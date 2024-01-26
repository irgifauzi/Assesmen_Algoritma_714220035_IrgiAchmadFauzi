import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class musuh extends Actor
{
    /**
     * Act - do whatever the musuh wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image1,image2;
    int xSpeed;
    musuh(){
        image1=new GreenfootImage("pesawatku.png");
        image2=new GreenfootImage("pesaw.png");
        xSpeed=Greenfoot.getRandomNumber(5);
    }
    
    public void moveMusuh(){
        setLocation(getX()+xSpeed,getY());
        if(getX()>MyWorld.width-10 || getX()<10){
            xSpeed*=-1;
            setLocation(getX(),Greenfoot.getRandomNumber(MyWorld.height));
            if(getImage()==image1)
                setImage(image2);
            else
                setImage(image1);
        }
    }

    public void act()
    {
        detectAndRemoveEater();
        moveMusuh();
        
        
    }
    
    public void detectAndRemoveEater(){
        
        Actor eaterTouched=getOneObjectAtOffset(0,0,Eater.class);
        if(eaterTouched!=null){
            MyWorld.carExplosionSound.play();
            if(Eater.lives>=1){
                Eater.lives--;
                getWorld().removeObject(eaterTouched);
                getWorld().addObject(new Eater(),MyWorld.width/2,MyWorld.height-20);
                setLocation(30+Greenfoot.getRandomNumber(MyWorld.width-30),30+Greenfoot.getRandomNumber(MyWorld.height-30));
            
            }
            if(Eater.lives==0){
                
                Greenfoot.setWorld(new GameOver());
                Eater.lives=2;
                
                if(Eater.score>Eater.highScore)
                    Eater.highScore=Eater.score;
                Eater.score=0;
            }
        }
    }
    
}
