import java.util.*;

public class Goblin {

int posY;
int posX;
int health;
int dmg;
String name;
boolean isBrute;
boolean battleMode;

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
    battleMode = false;
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
    public boolean getBattleMode() {
        return battleMode;
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
    public void setBattleMode(boolean battleMode) {
        this.battleMode = battleMode;
    }
    
    
    
    //Need random move, path to player, calc attack, 
    
    public void randMove(String[][] mapper) {
  //  if (((int)(Math.random()*2)) == 0) {
        int dir = (int) (Math.random()*4);
        
        switch (dir) {
            case 0: //N
                if (mapper[posY-1][posX].equals(" ")) {
                    mapper[posY][posX] = " ";
                    posY--;
                    mapper[posY][posX] = "g";
                    if (isBrute) mapper[posY][posX] = "G";
                        
                }
                break;
            case 1: //S
                if (mapper[posY+1][posX].equals(" ")) {
                     mapper[posY][posX] = " ";
                    posY++;
                    mapper[posY][posX] = "g";
                    if (isBrute) mapper[posY][posX] = "G";
                }
                
                break;
            case 2 :  //E
                if (mapper[posY][posX+1].equals(" ")) {
                     mapper[posY][posX] = " ";
                    posX++;
                    mapper[posY][posX] = "g";
                    if (isBrute) mapper[posY][posX] = "G";
                }
                
                break;
            case 3: //W
                if (mapper[posY][posX-1].equals(" ")) {
                     mapper[posY][posX] = " ";
                    posX--;
                    mapper[posY][posX] = "g";
                    if (isBrute) mapper[posY][posX] = "G";
                }
                
                break;
            
            

        } // end of switch case
  //  }
        
   } // end of rand move
    
    /*
    public boolean pathToPlayer(String[][] mapper, int playerPosY, int playerPosX) {
        System.out.println("BATTLE MODE AINT STARTIN");
        if (battleMode) {
            System.out.println("STARTING BATTLE MODE");
        int yDir = playerPosY-posY;
        int xDir = playerPosX-posX;
        
        
        if (yDir>0) {//S
        System.out.println("SOUTH DIR");
            if (mapper[posY+1][posX].equals(" ")) {
                mapper[posY][posX] = " ";
                posY++;
                mapper[posY][posX] = "g";
                if (isBrute) {
                    mapper[posY][posX] = "G";
                }
                System.out.println(name+" is advancing!");
            } else {
                System.out.println(name + " ran into an obstacle!");
            }
            
            
        } else if (yDir<0) {//N
         System.out.println("NORTH DIR");
             if (mapper[posY-1][posX].equals(" ")) {
                mapper[posY][posX] = " ";
                posY--;
                mapper[posY][posX] = "g";
                if (isBrute) {
                    mapper[posY][posX] = "G";
                }
                System.out.println(name+" is advancing!");
            } else {
                System.out.println(name + " ran into an obstacle!");
            }
            
            
        } else if (xDir>0) {//E
         System.out.println("EAST DIR");
             if (mapper[posY][posX+1].equals(" ")) {
                mapper[posY][posX] = " ";
                posX++;
                mapper[posY][posX] = "g";
                if (isBrute) {
                    mapper[posY][posX] = "G";
                }
                System.out.println(name+" is advancing!");
            } else {
                System.out.println(name + " ran into an obstacle!");
            }
            
            
        } else if (xDir<0) { // W
         System.out.println("WEST DIR");
             if (mapper[posY][posX-1].equals(" ")) {
                mapper[posY][posX] = " ";
                posX--;
                mapper[posY][posX] = "g";
                if (isBrute) {
                    mapper[posY][posX] = "G";
                }
                System.out.println(name+" is advancing!");
            } else {
                System.out.println(name + " ran into an obstacle!");
            }
        }
        
        if (mapper[posY+1][posX].equals("P") || (mapper[posY-1][posX].equals("P") || (mapper[posY][posX+1].equals("P") || mapper[posY][posX-1].equals("P"))))   {
             System.out.println("NEXT TO PLAYER");
            
            
            return true;
        }
        
        
        
        
        
        
        
        
        
        }  
        return false;
    }
    */
    
    
    
    
    
    
    
    
    
}