import java.util.*;

//Week 1 Movement, terrain gen, monster gen, equipment gen, loot boxes added, item equipment
//Week 2 attack system, shop system, shop gen,
//Week 3 quests 

//ERRORS : (FIXED) FIX THE ARRAYOUTOFBOUNDS ERROR WHEN TRAVELING TO THE RIGHT SIDE
//IN GOBLIN GEN, I GEN GOBLINS THEN ERASE "G" FROM AROUND THE PLAYER, THIS DOESNT ERASE THE GOBLINS POSY AND POSX IN THE ARRAYLIST
//(FIXED)WHEN PRINTING THE NAME OF THE SWORDS GENERATED FOR TREASURES METHOD RETURNS NULL
//(FIXED)ERROR IN CASE 3 
//When Reading case 4 and 3 i dont check to see if they are actually true i just check for the input from the player.
public class GameLoop {
    static player myPlayer = characterCreation();
    
    public static void printFullMap(String[][] mapper) {
        for (String[] a : mapper) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println("");
        }
    }
    
    
    public static void printMap(int posY, int posX, String[][] mapper) {
        if (posY<10) posY = 10;
          if (posY>99) posY = 89;  
        if (posX<10) posX = 10;
        if (posX>99) posX = 89;
        for (int i = 0; i<62;i++) {
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
    
    public static void basicGen(String[][] mapper) { // generates trees and the mountains boundary around the map
     for (int i = 0; i<(mapper.length *9);i++) {
         int pY = (int) (Math.random()*mapper.length);
         int pX = (int) (Math.random()*mapper[0].length);
         while (mapper[pY][pX].equals("P") || mapper[pY][pX].equals("^")) {
              pY = (int) (Math.random()*mapper.length);
              pX = (int) (Math.random()*mapper[0].length);
         }
         mapper[pY][pX] = "T";
     }   
    for (int i = 0; i<mapper.length;i++) {
    mapper[i][0] = "^";
    }
     for (int i = 0; i<mapper.length;i++) {
    mapper[i][mapper.length-1] = "^";
    }
     for (int j = 0; j<mapper[0].length;j++) {
    mapper[0][j] = "^";
    }
     for (int j = 0; j<mapper[0].length;j++) {
    mapper[mapper[0].length-1][j] = "^";
    }
    }
    /*
    public static void ridgeGen() {
        
    }
    */
    
    /*
    public static void goblinParty() {
        
    }
    */
    public static void clusterGen(String[][] mapper, int posY, int posX) {
        int pY = (int)((Math.random()*93)+3);
        int pX = (int)((Math.random()*93)+3);
        mapper[pY][pX] = "^";mapper[pY][pX+1] = "^"; mapper[pY][pX-1] = "^";mapper[pY+1][pX] = "^";mapper[pY-1][pX] = "^"; // creates a cross pattern
       
      int guagua = ((int)(Math.random()*6));
       switch(guagua) {
       
    case 0: for (int i = 1;i<3;i++) {
            mapper[pY+((int)(Math.random()*3))][pX] = "^"; // ((int)(Math.random()*3))
            mapper[pY-((int)(Math.random()*3))][pX] = "^";
            mapper[pY][pX-((int)(Math.random()*3))] = "^";
            mapper[pY][pX+((int)(Math.random()*3))] = "^";
        }
        break;
    case 1: for (int i = 1;i<3;i++) {
            mapper[pY+((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^"; // ((int)(Math.random()*3))
            mapper[pY-((int)(Math.random()*3))][pX-((int)(Math.random()*3))] = "^";
            mapper[pY+((int)(Math.random()*3))][pX-((int)(Math.random()*3))] = "^";
            mapper[pY][pX+((int)(Math.random()*3))] = "^";
        }
        break;
    case 2: for (int i = 1;i<3;i++) {
            mapper[pY][pX] = "^"; // ((int)(Math.random()*3))
            mapper[pY-((int)(Math.random()*3))][pX-((int)(Math.random()*3))] = "^";
            mapper[pY][pX-((int)(Math.random()*3))] = "^";
            mapper[pY-((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^";
        }
        break;
    case 3:  for (int i = 1;i<3;i++) {
            mapper[pY][pX+((int)(Math.random()*3))] = "^"; // ((int)(Math.random()*3))
            mapper[pY-((int)(Math.random()*3))][pX] = "^";
            mapper[pY-((int)(Math.random()*3))][pX-((int)(Math.random()*3))] = "^";
            mapper[pY-((int)(Math.random()*3))][pX] = "^";
        }
        break;
    case 4: for (int i = 1;i<3;i++) {
            mapper[pY-((int)(Math.random()*3))][pX-((int)(Math.random()*3))] = "^"; // ((int)(Math.random()*3))
            mapper[pY][pX+((int)(Math.random()*3))] = "^";
            mapper[pY-((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^";
            mapper[pY][pX+((int)(Math.random()*3))] = "^";
        }
        break;
    case 5:  for (int i = 1;i<3;i++) {
            mapper[pY+((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^"; // ((int)(Math.random()*3))
            mapper[pY+((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^";
            mapper[pY+((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^";
            mapper[pY+((int)(Math.random()*3))][pX+((int)(Math.random()*3))] = "^";
        }
        break;
        
       }
       for (int i = posY-5; i<posY+5;i++) {
           for (int j = posX-5;j<posX+5;j++) {
               mapper[i][j] = " ";
           }
       }
        mapper[posY][posX] = "P";
    }
    
    public static void goblinGen(String[][] mapper, String[] names, ArrayList<Goblin> myGoblins, int posY, int posX) {
        int pY = (int) (Math.random()*mapper.length);
        int pX = (int) (Math.random()*mapper.length);
        while (mapper[pY][pX].equalsIgnoreCase("^") || (mapper[pY][pX].equalsIgnoreCase("T") || mapper[pY][pX].equalsIgnoreCase("P"))) {
             pY = (int) (Math.random()*mapper.length);
             pX = (int) (Math.random()*mapper.length);
        }
        int whichName = (int) (Math.random()*names.length);
        int decideBrute = (int) (Math.random()*100);
        boolean brute = false;
        if (decideBrute == 0) {
        brute = true;
        mapper[pY][pX] = "G";
        } else {
            brute = false;
            mapper[pY][pX] = "g";
        }
        myGoblins.add(new Goblin(pY,pX,names[whichName],brute));
         for (int i = posY-5; i<posY+5;i++) {
           for (int j = posX-5;j<posX+5;j++) {
               mapper[i][j] = " ";
           }
       }
        mapper[posY][posX] = "P";
    }
    
    public static void lootboxGen(String[][] mapper, int posY, int posX) {
          int pY = (int) (Math.random()*mapper.length);
         int pX = (int) (Math.random()*mapper[0].length);
         while (mapper[pY][pX].equals("P") || (mapper[pY][pX].equals("^") || mapper[pY][pX].equals("T"))) {
              pY = (int) (Math.random()*mapper.length);
              pX = (int) (Math.random()*mapper[0].length);
         }
         mapper[pY][pX] = "L";
    }
    
    public static void npcGen(String[][] mapper, int posY, int posX, String[] adjs, String[] nouns, ArrayList<NPC> myNPCs) {
            //the random generation of shopkeepers will be commented out. If this is implemented later be sure to create a 
            //posY and PosX dont represent player position in this method
            /*
            //Write random NPC gen in here
              int pY = (int) (Math.random()*mapper.length);
         int pX = (int) (Math.random()*mapper[0].length);
         while (mapper[pY][pX].equals("P") || (mapper[pY][pX].equals("^") || mapper[pY][pX].equals("T"))) {
              pY = (int) (Math.random()*mapper.length);
              pX = (int) (Math.random()*mapper[0].length);
         }
               myNPCs.add(new NPC(pY,pX,adjs,nouns));
            mapper[pY][pX] = "S";
            //Now ensure to call a find direction method
            
            */
            
            
            myNPCs.add(new NPC(posY,posX,adjs,nouns));
            for (int i = posY-3;i<posY+3;i++) {
                for (int j = posX-3;j<posX+3;j++) {
                   mapper[i][j] = " "; 
                }
            }
            mapper[posY][posX] = "S";
            
            
            
    }
    
    /*
    public static void findDirection() {
        
    }
    
        */
        
    public static player characterCreation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a name for your character: ");
        player myBoy = new player(sc.nextLine());
        return myBoy;
    }
    
    public static boolean eneNear(String[][] mapper, int PosY, int PosX, ArrayList<Integer> latest, ArrayList<Goblin> myGobs) {
      for (int i = latest.size()-1; i>0;i--) {
         myGobs.get(latest.get(i)).setBattleMode(false);
         latest.remove(i);
     }
    // latest.remove(0);
       int wCY = 3;
        int wCX = 3;
        while (true) {
        if (PosY+wCY>mapper.length-1 || PosY-wCY<0) {
            wCY--;
          } else {
            break;
          }
        }
        
        while(true) {
            if(PosX+wCX>mapper.length-1 || PosX-wCX<0) {
                wCX--;
            } else {
              break;
            }
        }
       
        //System.out.println(wCY + "   " + wCX);
        for (int i = PosY-wCY;i<PosY+wCY;i++) {
            for (int j = PosX-wCX;j<PosX+wCX;j++) {
               // System.out.println(i + "   " + j);
                if (mapper[i][j].equalsIgnoreCase("G")) {
                   for (int k = 0; k<myGobs.size();k++) {
                       
                       if (myGobs.get(k).getPosY() == i && myGobs.get(k).getPosX() == j) {
                           System.out.println("ADDED TO LATEST");
                           myGobs.get(k).setBattleMode(true);
                           latest.add(k); 
                           
                       }
                       
                       
                   }
                   return true;
                }
                
            }
        }
        return false;
    }
    
         public static boolean shopNear(String[][] mapper, int PosY, int PosX, int[] latest) {
       int wCY = 3;
        int wCX = 3;
        while (true) {
        if (PosY+wCY>mapper.length-1 || PosY-wCY<0) {
            wCY--;
          } else {
            break;
          }
        }
        
        while(true) {
            if(PosX+wCX>mapper.length-1 || PosX-wCX<0) {
                wCX--;
            } else {
              break;
            }
        }
        
        //System.out.println(wCY + "   " + wCX);
        for (int i = PosY-wCY;i<PosY+wCY;i++) {
            for (int j = PosX-wCX;j<PosX+wCX;j++) {
               // System.out.println(i + "   " + j);
                if (mapper[i][j].equalsIgnoreCase("S")) {
                    latest[0] = i;
                    latest[1] = j;
                    return true;
                }
                
            }
        }
        return false;
    }
        
        
        
    
    
    public static void main(String args[]) {
        /*
        String[][] arr = new String[5][5];
       for (int i = 0; i<arr.length;i++) {
           for (int j = 0; j<arr[0].length;j++) {
               arr[i][j] = " ";
           }
       }
        arr[2][1] = "G";
        System.out.println(eneNear(arr,2,2));
        */
        
        String names = "Aggu Bait Bentarms Bigchin Bodrol Brainmush Cagrerk Chowder Delduk Dullarms Fatleg Frailtooth Fugh Globarm Goutmaw Grishnar Gully Hurrub IzIz Jan Kalo Louse Milvok Mitemouth Moldnose Mongrel Muchot Mudmug Nibras Nurteyun Owlball Peon Qebranda Qeldar Qoldin Rulgran Shake Spear Snailnose Snotear Stinkarm Tik Toenail Tugdark Ulnat Verdrak Vigdarg Vragek Vrudgark Weasel Yameeka Zarl Zok Zrurdok Larnar Lmaysu Lurkit Muaskas Nadkrus Nadrak Naglok Nagnus Nurgras Nyajas Opasas Pmasyg Qywjais Ragrat Ranluk Rodgott Rodrast Sjasooas Tjoaks Ugkit Ukoasla Ulnuff Unjaks Urlus Vyasoas Wiaisokas Xiasokas Yoasas Zmaskas Adlirg Ailluilas Alkar Arkus Bankit Bannuk Billywig Bogragg Brodnott Brunknas Brwaos Bugragg Crasoas Drejask Eglus Erioos Ernuk Farnaff Farrod Filragg Freias Furguss Furrak Garlaff Garrast Gorluk Graggrat Gragnok Granguss Grejia Grinkrat Grukgrat Gurgrot Gurnuff HtejasJiaspas Karguff Karnott Kmasoas Koglig Kragraff Krugnott Kurluk Kyuasas Lagnuff";
        String[] goblinNames = names.split(" ");
        String adjectives = "Attractive Bald Beautiful Chubby Clean Dazzling Drab Elegant Fancy Fit Flabby Glamorous Gorgeous Handsome Long Magnificent Muscular Plain Plump Quaint Shapely Short Skinny Stocky Ugly Unkempt Unsightly Ashy Black Blue Gray Green Icy Lemon Mango Orange Purple Red Salmon White Yellow Alive Better Careful Clever Dead Easy Famous Gifted Hallowed Helpful Important Inexpensive Mealy Mushy Odd Poor Powerful Rich Shy Tender Unimportant Uninterested Vast Wrong Aggressive Agreeable Ambitious Brave Calm Delightful Eager Faithful Gentle Happy Jolly Kind Lively Nice Obedient Polite Proud Silly Thankful Victorious Witty Wonderful Zealous Angry Bewildered Clumsy Defeated Embarrassed Fierce Grumpy Helpless Itchy Jealous Lazy Mysterious Nervous Obnoxious Panicky Pitiful Repulsive Scary Thoughtless Uptight Worried Broad Chubby Crooked Curved Deep Flat High Hollow Low Narrow Refined Round Shallow Skinny Square Steep Straight Wide Big Colossal Fat Gigantic Great Huge Immense Large Little Mammoth Massive Microscopic Miniature Petite Puny Scrawny Short Small Tall Teeny Tiny Ancient Early Fast Future Late Long Modern Old Old-Fashioned Prehistoric Quick Rapid Short Swift Young Acidic Bitter Cool Creamy Delicious Disgusting Fresh Greasy Juicy Hot Moldy Nutritious Nutty Putrid Rancid Ripe Rotten Salty Savory Sour Spicy Spoiled Stale Sweet Tangy Tart Tasteless Tasty Yummy";
        adjectives = adjectives.toUpperCase();
        String[] swordAdj = adjectives.split(" ");
        String nouns = "Sword Blade Steel Brand Dagger Rapier Foil Scimitar Cutlass Epee Axe Knife Katana Spear Mace Hammer Trident Machete Bat";
       nouns = nouns.toUpperCase();
        String[] swordNouns = nouns.split(" ");
        ArrayList<Goblin> goblinList = new ArrayList<>();
        ArrayList<NPC> npcList = new ArrayList<>();
        ArrayList<Integer> latestGob = new ArrayList<>();
        int[] latestShop = new int[2];
        String[][] map = new String[100][100];                                     //^=mountain,   T=Tree,   S=Shopkeeper,   G=Goblins,   P=Player,   
        for (int i = 0; i<map.length;i++) {
            for (int j = 0; j<map[0].length;j++) {
                map[i][j] = " ";
            }
        }
        map[myPlayer.getPosY()][myPlayer.getPosX()] = "P";
        Scanner sc = new Scanner(System.in);
        basicGen(map);
        for (int i = 0; i < map.length;i++) {
            clusterGen(map,myPlayer.getPosY(),myPlayer.getPosX());
        }
        for (int i = 0; i<150;i++) {
            goblinGen(map,goblinNames,goblinList,myPlayer.getPosY(),myPlayer.getPosX());
        }
        for (int i = 0; i<250;i++) {
            lootboxGen(map,myPlayer.getPosY(),myPlayer.getPosX());
        }
       // for (int i = 0; i<10;i++) {
       //shopkeeper gen?
      //  }
        npcGen(map,25,25,swordAdj,swordNouns,npcList); npcGen(map,70,50,swordAdj,swordNouns,npcList); npcGen(map,25,80,swordAdj,swordNouns,npcList); npcGen(map,50,25,swordAdj,swordNouns,npcList); npcGen(map,80,26,swordAdj,swordNouns,npcList);npcGen(map,80,80,swordAdj,swordNouns,npcList);
        
        
   
    System.out.println("Hey you, yeah you, youre finally awake. Good. Were almost there. The Kingdom of Worcestershire.\n Here, heres a map. Were located at the P. The ^ are mountains they are impassable. The T represent great trees These are impassable as well. \n An S represents a shopkeeper. Here you can use your hard earned Pesos to buy health or damage. A g represents a goblin but a capital G represents a goblin brute. Theyre dangerous and will attack given the chance.\n This map is magic it will update every time you move but it will only show you the surrounding lands. Not the whole world.");
   printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
  // map[myPlayer.getPosY()+1][myPlayer.getPosX()] = "g";
  // printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
  // System.out.println(eneNear(map,myPlayer.getPosY(),myPlayer.getPosX()));
    while (myPlayer.getHealth() > 0) {
       //eneNear(map);
       //shopNear(map);
       int choice = 0;
       System.out.println("Enter (1) to move"); // 1 will be moving, 2 will be equipping, 3 will be purchasing, 4 will be fighting, 
       System.out.println("Enter (2) to equip items");
       if (shopNear(map,myPlayer.getPosY(),myPlayer.getPosX(),latestShop)) {
            System.out.println("Enter (3) to talk");
       } else {
           System.out.println("There is no one near");
       }
       if (eneNear(map,myPlayer.getPosY(),myPlayer.getPosX(),latestGob,goblinList)) {
       System.out.println("Enter (4) to attack");
       } else {
       System.out.println("There are no Goblins near");
       }
       
       
       //sc.nextLine(); //Neccessary?
       choice = sc.nextInt();
    
    switch(choice) {
    case 1:  //Case 1 handles movement
        boolean contMove = true;
       // boolean treasure = false;
        String direction = "";
        sc.nextLine();
        while (contMove) {
            System.out.println("Enter (N) for north, (E) for east, (S) for south, (W) for west, and (X) to exit moving");
            direction = sc.nextLine();
            if (direction.equalsIgnoreCase("X")) {
                 printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
                break;
            } else if(direction.equalsIgnoreCase("N") || direction.equalsIgnoreCase("E") || direction.equalsIgnoreCase("S") || direction.equalsIgnoreCase("W")) {
            //   if (latestGob.size()==1) {
           // latestGob.remove(0);
          //  }
               eneNear(map,myPlayer.getPosY(),myPlayer.getPosX(),latestGob,goblinList);
                if(myPlayer.move(map,direction)) {
                    //int whichAdj = (int) (Math.random()*swordAdj.length);
                    // int whichNoun = (int) (Math.random()*swordNouns.length);
                    myPlayer.treasure(swordAdj,swordNouns);
                }
                printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
            } else {
                System.out.println("Invalid Entry");
            }
            
            
            
            for (int i = 0; i<goblinList.size();i++) {
                goblinList.get(i).randMove(map);
            }
            
            
            
            /*
            //Put an if statement here to see if they are engaged in combat
            for (int j = 0; j<latestGob.size();j++) {
            if (goblinList.get(latestGob.get(j)).getBattleMode()) {
                System.out.println(j + "   " + latestGob.get(j));
            if(goblinList.get(latestGob.get(j)).pathToPlayer(map,myPlayer.getPosY(),myPlayer.getPosX())) {
                //ATTACK IN HERE
                
                
                
                
                
                
                
                }
            } else {
            for (int i = 0; i<goblinList.size();i++) {
                for (int g = 0; g<latestGob.size();g++) {
                if (i == latestGob.get(g)) {
                } else {
                goblinList.get(i).randMove(map);
                }
            }
                }
            }
        
            }
        */
        
        }
        
        break;
    case 2:    //case 2 handles the movement of equipment into the damage calculation, into hands
    boolean contE = true;
    while(contE) {
    System.out.println("(1) to look into your backpack \n(2) to equip a new item\n(3) to look at your held item\n(4) to print your money\n(9) to return to the main menu");
        int which = sc.nextInt();
        if (which==1) {
            myPlayer.printBackpack();
        } else if(which == 2) {
            System.out.println("Enter the name of the weapon you want to equip: ");
            sc.nextLine();
            String nameDecide = sc.nextLine();
            myPlayer.setHeldItem(nameDecide);
        } else if(which == 3){
          System.out.println(myPlayer.getHeldItem().getName() + " : " + myPlayer.getHeldItem().getDamage());
        } else if(which == 4) {
            System.out.println("You have " + myPlayer.getMoney() + " Pesos");
        } else if(which==9) {
             printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
            contE = false;
        } else {
              System.out.println("Invalid Entry");
        }
    }
        break;
    case 3:  //case 3 handles the purchase of items and the distribution of quests
    if (shopNear(map,myPlayer.getPosY(),myPlayer.getPosX(),latestShop)) {
    boolean contS = true;
    String tempor = "";
   
        //NPC temp = new NPC(swordAdj,swordNouns);
        int temp = -1;
        for (int i = 0; i<npcList.size();i++) {
            if (npcList.get(i).getPosY() == latestShop[0] && npcList.get(i).getPosX() == latestShop[1]) {
                temp = i;
            }
        }
       
        
        while(contS) {
             System.out.println("(1) to shop for equipment"/*\n(2) to gain a quest*/ + "\n(9) to exit to main menu");
        int witch = sc.nextInt();
        if(witch==1) {
             npcList.get(temp).printMySwords();
        System.out.println("Enter the name of the sword you would like to purchase: ");
       sc.nextLine();
        tempor = sc.nextLine();
       myPlayer.setMoney( npcList.get(temp).swordShop(tempor, myPlayer.getMoney(),myPlayer)); // ERROR
       // } else if(witch==2) {
            //quests go here
            
            
            
            
            
            
            
            
        } else if(witch==9) {
             printMap(myPlayer.getPosY(),myPlayer.getPosX(),map);
            contS = false;
        } else {
            System.out.println("Invalid Entry");
        }
        
        
        }//end of while loop
        
        
        
        break;
    } else {
        System.out.println("Invalid Entry");
        break;
    }
    case 4: // case 4 handles the attacking, not the detection of Goblins thats handled by the . You need to find out what instance of enemy is there as well as distributing damage and health
        if (eneNear(map,myPlayer.getPosY(),myPlayer.getPosX(),latestGob,goblinList)) {
          /*
         if (map[myPlayer.getPosY()-1][myPlayer.getPosX()].equalsIgnoreCase("g")) {
             for (int k = 0; k<goblinList.size();k++) {
                 
             }
         } else if (map[myPlayer.getPosY()+1][myPlayer.getPosX()].equalsIgnoreCase("g")) {
             
         } else if (map[myPlayer.getPosY()][myPlayer.getPosX()+1].equalsIgnoreCase("g")) {
             
         } else if(map[myPlayer.getPosY()][myPlayer.getPosX()-1].equalsIgnoreCase("g")) {
             
         }
          */
          
          
          
          
          
          
          
            
        } 
        break;
    default: System.out.println("Invalid Entry");
    } // end of switch case
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    } // end of Game while loop
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    } // end of Main
    
} // end of class