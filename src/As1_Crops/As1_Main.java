package As1_Crops;

import Examples.Ex3_Client;
//import Examples.Library;

import java.util.ArrayList;

public class As1_Main {

    public static void run() {

        ArrayList<As1_Crop> allCrops = new ArrayList();

        allCrops.add(new As1_Crop(   "Canola", 38.4 , "Bushels per acre", 16.44   )  );
        allCrops.add(new As1_Crop(   "Wheat", 57.8 , "Bushels per acre", 8.30     )  );
        allCrops.add(new As1_Crop(   "Potato", 400, "cwt/acre", 28.62      )  );
        allCrops.add(new As1_Crop(   "Onion", 9 , "ton/acre", 408.35      )  );
        allCrops.add(new As1_Crop(   "Flax", 15, "lb/acre", 12.57      )  );

        allCrops.get(0).setAcres(  300  );
        allCrops.get(1).setAcres(  150  );
        allCrops.get(2).setAcres(  250  );
        allCrops.get(3).setAcres(  50  );
        allCrops.get(4).setAcres(  250  );



        for(int i=0; i<allCrops.size(); i++){
            System.out.println(allCrops.get(i).toString());
        }

        System.out.println("Welcome Atticus' farm");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print farm summary");
            System.out.println("2.  Search & harvest a crop");
            System.out.println("3.  Get total revenue");
            System.out.println("4.  Plant a crop");
            System.out.println("5.  Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {
//                System.out.println("Not Yet Implemented");
                for (int i = 0; i < allCrops.size(); i++) {
                    allCrops.get(i).printMe();
                }

            } else if (choice == 2) {
//                System.out.println("Not Yet Implemented");
                System.out.println("What crop would you like?");
                String name = Library.input.nextLine();
                int foundCrop = searchByName(allCrops, name);
                allCrops.get(foundCrop).printMe();





            } else if (choice == 3) {
                System.out.println("Not Yet Implemented");

            } else if (choice == 4) {
                System.out.println("Not Yet Implemented");

            }  else {

                break;
            }
        } // while
        System.out.println("Good bye.");




    }//run

    public static int searchByName( ArrayList<As1_Crop> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }


}//class
