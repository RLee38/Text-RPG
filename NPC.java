import java.util.*;


public class NPC {
    int posY;
    int posX;
    String[] adjs;
    String[] nouns;
    //Sword[] mySwords = new Sword[20];
    ArrayList<Sword> mySwords = new ArrayList<>();
    int[] costs = new int[20];
    int whichN;
    int whichA;
    public NPC(int posY, int posX, String[] adjs, String[] nouns) {
        this.posY = posY;
        this.posX = posX;
        this.adjs = adjs;
        this.nouns = nouns;
        for (int i = 0; i<20;i++) {
            whichA = (int) (Math.random()*adjs.length);
            whichN = (int) (Math.random()*nouns.length);
            mySwords.add( new Sword(adjs[whichA],nouns[whichN]));
           // System.out.println("SWORD ADDED IN NPC CLASS");
           //System.out.println(((int) Math.random()*10) + "       " + mySwords.get(i).getDamage()*3);
           costs[i] = Math.abs(((int) (Math.random()*10)) + mySwords.get(i).getDamage()*3);
           //Math.abs((mySwords.get(i).getDamage()*3) + (int) Math.random()*10);
           if (mySwords.get(i).getIsGilded()) {
               costs[i] = costs[i]*2;
           }
        }
        
    }
   
    public int getPosY() {
        return posY;
    }
    public int getPosX() {
        return posX;
    }
    
    
    
    
    
    
    public void printMySwords() {
        for (int i = 0; i<mySwords.size();i++) {
            System.out.println("ITEM: " + mySwords.get(i).getName() + " : " + mySwords.get(i).getDamage() + " : COST : " + costs[i]);
        }
    }
    
    public int swordShop(String name, int money, player myPlayer) {
        int index = -1;
        int coster = -1;
        for (int i = 0; i<mySwords.size();i++) {
           if (mySwords.get(i).getName().equalsIgnoreCase(name)) { 
             //  System.out.println("EQUALS NAME");
               index = i;
               coster = costs[i];
           }
        }
        if (index == -1) {
            System.out.println("Invalid Entry");
            return money;
        }
        if (coster<money) {
            money = money-coster;
            myPlayer.backpackAdd(mySwords.remove(index));
            return money;
        } else {
            System.out.println("Insufficient Funds");
            return money;
        }
        
    }
    
    
    
    
    
    
    
    
}