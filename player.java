import java.util.*;


public class player {
    int health;
    String name;
    int money;
    int damage;
    int posX;
    int posY;
    ArrayList<String> myBag = new ArrayList<>();
    
    public player(String name) {
        this.name = name;
        health = 100;
        money = 500;
        damage = 1;
        posX = 75;
        posY = 75;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public int getMoney() {
        return money;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setPosX(int pos) {
        posX = pos;
    }
    public void setPosY(int pos) {
        posY = pos;
    }
    
    
    public boolean move(String[][] mapper,String dir) {
       
        if (dir.equalsIgnoreCase("N") && posY>0 && (mapper[posY-1][posX].equals(" "))) {
            mapper[posY][posX] = " ";
            posY--;
            mapper[posY][posX] = "P";
            return true;
        } else if(dir.equalsIgnoreCase("E") && posX<149 && (mapper[posY][posX+1].equals(" "))) {
           mapper[posY][posX] = " ";
            posX++;
             mapper[posY][posX] = "P";
            return true;
        } else if(dir.equalsIgnoreCase("S") && posY<149 && (mapper[posY+1][posX].equals(" "))) {
            mapper[posY][posX] = " ";
            posY++;
            mapper[posY][posX] = "P";
            return true;
        } else if(dir.equalsIgnoreCase("W") && posX>0 && (mapper[posY][posX-1].equals(" "))) {
          mapper[posY][posX] = " ";
            posX--;
            mapper[posY][posX] = "P";
            return true;
        } else if (dir.equalsIgnoreCase("X")) {
        return false;
       } else {
            System.out.println("Invalid Entry");
            return false;
        }



    }
    
   
    
    
    
    
    
    
    
    
    
    
}