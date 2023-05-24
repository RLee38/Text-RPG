import java.util.*;

public class Goblin {

int posY;
int posX;
int health;
int dmg;
String name;
boolean isBrute;

public Goblin(int posY, int posX, String name, boolean isBrute) {
    this.posY = posY;
    this.posX = posX;
    this.name = name;
    this.isBrute = isBrute;
    if (isBrute) {
        health = 50;
        dmg = 20;
    } else {
    health = 25;
    dmg = 9;
    }
}
    
    public int getPosY() {
        return posY;
    }
     public int getPosX() {
        return posX;
    }
    public int getHealth() {
        return health;
    }
    public int getDmg() {
        return dmg;
    }
    public String getName() {
        return name;
    }
    public boolean getIsBrute() {
        return isBrute;
    }
    
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    
    
    
    //Need random move, path to player, calc attack, 
    /*
    public void randMove(String[][] mapper) {
    if (((int)(Math.random()*2)) == 0) {
        int dir = (int) (Math.random()*4);
        
        switch (dir) {
            case 0: 
                break;
            case 1:
                break;
            case 2 : 
                break;
            case 3:
                break;
            
            

        } // end of switch case
    }
        
   } */
    
    
    
    
    
    
    
    
    
    
    
    
    
}