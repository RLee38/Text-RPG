import java.util.*;


public class Sword {
    String name;
    int dmgBonus;
    boolean isGilded;
    
   public Sword() {
       name = "NULLNAME";
       dmgBonus = 0;
   }
   
    public Sword(String adj, String noun) {
        name = adj + " " + noun;// name is being properly assigned however not properly returned
        dmgBonus = (int) (Math.random()*21+1);
        isGilded = false;
        if (dmgBonus == 21) {
           if ((int)(Math.random()*2) == 0) {
               dmgBonus = 25;
            name = "GILDED " + name;
            isGilded = true;
           }
        }
        
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return dmgBonus;
    }
    public boolean getIsGilded() {
        return isGilded;
    }
    
    
    
    
    
}