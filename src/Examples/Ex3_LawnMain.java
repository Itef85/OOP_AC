package Examples;

import java.util.ArrayList;

public class Ex3_LawnMain {

    public static void run(){

        ArrayList <Ex3_Client> allClient = new ArrayList <>();

        allClient.add(  new Ex3_Client(  "McDavid", "100 Maple Dr", 1000, true  )  );
        allClient.add(  new Ex3_Client(  "Draisaitl", "102 Maple Dr", 600, true  )  );
        allClient.add(  new Ex3_Client(  "Nugent-Hopkins", "50 Main Dr", 600, false  )  );
        allClient.add(  new Ex3_Client(  "Skinner", "10450 82 Avenue ", 300, true  )  );
        allClient.add(  new Ex3_Client(  "Podkolzin", "5 Putin Lane", 200, false  )  );


        for (int i = 0; i < allClient.size(); i++) {
            allClient.get(i).mowLawn();
        }
        for (int i = 0; i < allClient.size(); i++) {
            allClient.get(i).mowLawn();
        }


        for ( Ex3_Client clientTemp : allClient) {

            System.out.println(clientTemp);
            // System.out.println(allClient.get(i) );


        }




    }//run

}//lawnMain
