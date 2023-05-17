import java.util.*;


public class GameLoop {
    static player myPlayer = characterCreation();
    
    
    public static void printMap(int posY, int posX, String[][] mapper) {
        if (posY<10) posY = 10;
          if (posY>99) posY = 139;  
        if (posX<10) posX = 10;
        if (posX>99) posX = 139;
        for (int i = 0; i<61;i++) {
            System.out.print("#");
        }
        System.out.println("");
        for (int i = posY-10; i<posY+10;i++) {
            System.out.print("#");
            for (int j = posX-10; j<posX+10;j++) {
                System.out.print(mapper[i][j] + "  ");
            }
            System.out.println("#");
        }
        for (int i = 0; i<62;i++) {
            System.out.print("#");
        }
        System.out.println("");
    }
    
    public static player characterCreation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a name for your character: ");
        player myBoy = new player(sc.nextLine());
        return myBoy;
    }
    
    public static boolean eneNear(String[][] mapper) {
         int whereCheckY = 2;
         int whereCheckX = 2;
          if (myPlayer.getPosY()<2 || myPlayer.getPosY()>147) {
             whereCheckY = 1;
             if (myPlayer.getPosY()<1 || myPlayer.getPosY()>148) {
                 whereCheckY = 0;
             }
         }
          if (myPlayer.getPosX()<2 || myPlayer.getPosX()>147) {
             whereCheckX = 1;
             if (myPlayer.getPosX()<1 || myPlayer.getPosX()>148) {
                 whereCheckX = 0;
             }
         }
        for (int i = myPlayer.getPosY()-2; i>myPlayer.getPosY()+2;i++) {
            for (int j = myPlayer.getPosX()-2;j>myPlayer.getPosX()+2;j++) {
                if (mapper[i][j].equals("G")) {
                    return true;
                }
            }
        }
        return false;
    }
    
     public static boolean shopNear(String[][] mapper) {
         int whereCheckY = 2;
         int whereCheckX = 2;
         if (myPlayer.getPosY()<2 || myPlayer.getPosY()>147) {
             whereCheckY = 1;
             if (myPlayer.getPosY()<1 || myPlayer.getPosY()>148) {
                 whereCheckY = 0;
             }
         }
          if (myPlayer.getPosX()<2 || myPlayer.getPosX()>147) {
             whereCheckX = 1;
             if (myPlayer.getPosX()<1 || myPlayer.getPosX()>148) {
                 whereCheckX = 0;
             }
         }
         
        for (int i = myPlayer.getPosY()-whereCheckY; i>myPlayer.getPosY()+whereCheckY;i++) {
            for (int j = myPlayer.getPosX()-whereCheckX;j>myPlayer.getPosX()+whereCheckX;j++) {
                if (mapper[i][j].equals("S")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String args[]) {
        
        String[][] map = new String[100][100];                                     //^=mountain,   T=Tree,   S=Shopkeeper,   G=Goblins,   P=Player,   
        for (int i = 0; i<map.length;i++) {
            for (int j = 0; j<map[0].length;j++) {
                map[i][j] = " ";
            }
        }
        map[myPlayer.getPosY()][myPlayer.getPosX()] = "P";
        Scanner sc = new Scanner(System.in);
        
        
        
    
    System.out.println("Jacob: Hey you, yeah you, youre finally awake. Good. Were almost there. The Kingdom of ****.\n Here, heres a map. Were located at the P. The ^ are mountains they are impassable. The T represent great trees These are impassable as well. \n An S represents a shopkeeper. Here you can use your hard earned Pesos to buy health or damage. A G represents a Goblin. Theyre dangerous and will attack given the chance.\n This map is magic it will update every time you move but it will only show you the surrounding lands. Not the whole world.");
   printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
    while (myPlayer.getHealth() > 0) {
       //eneNear(map);
       //shopNear(map);
       int choice = 0;
       System.out.println("Enter (1) to move"); // 1 will be moving, 2 will be equipping, 3 will be purchasing, 4 will be fighting, 
       System.out.println("Enter (2) to equip items");
       if (shopNear(map)) {
            System.out.println("Enter (3) to talk");
       } else {
           System.out.println("There is no one near");
       }
       if (eneNear(map)) {
       System.out.println("Enter (4) to ");
       } else {
       System.out.println("There are no Goblins near");
       }
       
       
       
       choice = sc.nextInt();
    
    switch(choice) {
    case 1:  //Case 1 handles movement
        boolean contMove = true;
        String direction = "";
        sc.nextLine();
        while (contMove) {
            System.out.println("Enter (N) for north, (E) for east, (S) for south, (W) for west, and (X) to exit moving");
            direction = sc.nextLine();
            if (direction.equalsIgnoreCase("X")) {
                break;
            } else if(direction.equalsIgnoreCase("N") || direction.equalsIgnoreCase("E") || direction.equalsIgnoreCase("S") || direction.equalsIgnoreCase("W")) {
                myPlayer.move(map,direction);
                printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
            } else {
                System.out.println("Invalid Entry");
            }
            
        }
        
        break;
    case 2:    //case 2 handles the movement of equipment into the damage calculation, into hands, armor, create gilding system here or shop?
        
        
        break;
    case 3:  //case 3 handles the purchase of items and the distribution of quests
        
        
        break;
    case 4: // case 4 handles the attacking, not the detection of attacks. You need to find out what instance of enemy is there as well as distributing damage and health
        
        
        break;
    default: System.out.println("Invalid Entry");
    }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    }
}