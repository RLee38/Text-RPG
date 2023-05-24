import java.util.*;


public class player {
    int health;
    String name;
    int money;
    int damage;
    int posX;
    int posY;
    Sword heldItem;
    ArrayList<Sword> backpack = new ArrayList<>();
    ArrayList<String> myBag = new ArrayList<>();
    
    public player(String name) {
        this.name = name;
        health = 100;
        money = 50000;
        damage = 1;
        posX = 50;
        posY = 75;
        heldItem = new Sword(); // empty new null sword just to prevent errors
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
    public Sword getHeldItem() {
        return heldItem;
    }
    public ArrayList<Sword> getBackpack() {
        return backpack;
    }
    public void printBackpack() {
        for (int i = 0; i<backpack.size();i++) {
            System.out.println((backpack.get(i)).getName() + " : " + (backpack.get(i)).getDamage());
        }
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
    public boolean setHeldItem(String swordName) {
        int index = -1;
        for (int i = 0; i<backpack.size();i++) {
            if( backpack.get(i).getName().equalsIgnoreCase(swordName)) {
                index =i;
            }
           
        }
        if (index == -1) {
            System.out.println("Invalid Entry");
            return false;
        }
        Sword tempo = backpack.remove(index);
        backpack.add(heldItem);
        heldItem = tempo;
        if (backpack.get(backpack.size()-1).getName().equalsIgnoreCase("NULLNAME")) {
            backpack.remove(backpack.size()-1);
        }
       return true;
    }
    
    public void backpackAdd(Sword mySword) {
        backpack.add(mySword);
    }
    
    
    public boolean move(String[][] mapper,String dir) {
       boolean isTreasure = false;
        if (dir.equalsIgnoreCase("N") && posY>0 && (mapper[posY-1][posX].equals(" ") || mapper[posY-1][posX].equalsIgnoreCase("L"))) {
            mapper[posY][posX] = " ";
            posY--;
            if (mapper[posY][posX].equalsIgnoreCase("L")) {
                mapper[posY][posX] = "P";
                return true;
            }
            mapper[posY][posX] = "P";
            return false;
        } else if(dir.equalsIgnoreCase("E") && posX<99 && (mapper[posY][posX+1].equals(" ") || mapper[posY][posX+1].equalsIgnoreCase("L"))) {
           mapper[posY][posX] = " ";
            posX++;
            if (mapper[posY][posX].equalsIgnoreCase("L")) {
                mapper[posY][posX] = "P";
                return true;
            }
             mapper[posY][posX] = "P";
            return false;
        } else if(dir.equalsIgnoreCase("S") && posY<99 && (mapper[posY+1][posX].equals(" ") || mapper[posY][posX+1].equalsIgnoreCase("L"))) {//mapper[posY][posX].equalsIgnoreCase("L")
            mapper[posY][posX] = " ";
            posY++;
            if (mapper[posY][posX].equalsIgnoreCase("L")) {
                mapper[posY][posX] = "P";
                return true;
            }
            mapper[posY][posX] = "P";
            return false;
        } else if(dir.equalsIgnoreCase("W") && posX>0 && (mapper[posY][posX-1].equals(" ") || mapper[posY][posX-1].equalsIgnoreCase("L"))) {
          mapper[posY][posX] = " ";
            posX--;
            if (mapper[posY][posX].equalsIgnoreCase("L")) {
                mapper[posY][posX] = "P";
                return true;
            }
            mapper[posY][posX] = "P";
            return false;
        } else if (dir.equalsIgnoreCase("X")) {
        return false;
       } else {
            System.out.println("Invalid Entry");
            return false;
        }

    }
    
    
    public void treasure(String[] adj, String[] noun) {
       // System.out.println(adj[0]);
        int adjective = (int) (Math.random()*adj.length);
        int nouner = (int) (Math.random()*noun.length);
           //System.out.println(adj[adjective]);
        Sword temp = new Sword(adj[adjective],noun[nouner]);
        int coins = (int) (Math.random()*25+1);
        System.out.println("OHHHH TREASURE!!! You found a sword named " + temp.getName() + " with a damage of " + temp.getDamage() + ". You also found " + coins  + " coins.");
     money+= coins;
        backpack.add(temp);
    }
    
    
    


    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
}