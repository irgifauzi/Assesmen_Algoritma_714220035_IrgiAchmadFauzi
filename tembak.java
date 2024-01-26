    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tembak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tembak extends Actor
{
    /**
     * Act - do whatever the tembak wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //dd your action code here.
        removemusuh();
        tembak();
    }
    
    public void tembak() {
    int dx = 5;  // Seberapa jauh tembakan bergerak ke kanan
    setLocation(getX() + dx, getY());  // Menggeser posisi tembakan ke kanan
    
      if (getX() > getWorld().getWidth() - 2) {
        // Jika tembakan berada di luar batas kanan tembakan dihapus
        getWorld().removeObject(this);
     }
    }
    
    public void removemusuh(){
        Actor musuhTouched=getOneObjectAtOffset(0,0,musuh.class);
        if(musuhTouched!=null){
            MyWorld.shootSound.play();
            getWorld().removeObject(musuhTouched);
            Eater.score+=2;
            if(MyWorld.nbMusuhsShot<5){
                MyWorld.nbMusuhsShot+=1;
            }
        }
      }
}
