package As1_Crops;

import java.util.ArrayList;

public class As1_Main {

    public static void run() {

        ArrayList<As1_Crop> allCrops = new ArrayList();

        allCrops.add(new As1_Crop(   "Canola", 38.4 , "Bushels per acre", 16.44   )  );
        allCrops.add(new As1_Crop(   "Wheat", 57.8 , "Bushels per acre", 8.30     )  );
        allCrops.add(new As1_Crop(   "Potato", 400, "cwt/acre", 28.62      )  );
        allCrops.add(new As1_Crop(   "Onion", 9 , "ton/acre", 408.35      )  );
        allCrops.add(new As1_Crop(   "Flax", 15, "lb/acre", 12.57      )  );

        for(int i=0; i<allCrops.size(); i++){
            System.out.println(allCrops.get(1).toString());
        }


    }//run

}//class
