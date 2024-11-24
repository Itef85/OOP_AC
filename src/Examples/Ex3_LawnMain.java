package Examples;

import java.util.ArrayList;
import java.io.*;

public class Ex3_LawnMain {

    public static void run(){

        ArrayList <Ex3_Client> allClient = new ArrayList <>();

        loadFile("data/ClientData.csv", allClient);
        allClient.add(  new Ex3_Client(  "McDavid", "100 Maple Dr", 1000, true  )  );
        allClient.add(  new Ex3_Client(  "Draisaitl", "102 Maple Dr", 600, true  )  );
        allClient.add(  new Ex3_Client(  "Nugent-Hopkins", "50 Main Dr", 600, false  )  );
        allClient.add(  new Ex3_Client(  "Skinner", "10450 82 Avenue ", 300, true  )  );
        allClient.add(  new Ex3_Client(  "Podkolzin", "5 Putin Lane", 200, false  )  );

//
//        for (int i = 0; i < allClient.size(); i++) {
//            allClient.get(i).mowLawn();
//        }
//        for (int i = 0; i < allClient.size(); i++) {
//            allClient.get(i).mowLawn();
//        }
//
//
//        for ( Ex3_Client clientTemp : allClient) {
//
//            System.out.println(clientTemp);
//            // System.out.println(allClient.get(i) );
//
//
//        }


        System.out.println("Welcome to Moe's Mowing");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print all Clients");
            System.out.println("2.  Mow all lawns");
            System.out.println("3.  Receive Payment");
            System.out.println("4.  Add new client");
            System.out.println("5.  Delinquent Payments");
            System.out.println("6.  Save and Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {

                for (int i = 0; i < allClient.size(); i++) {
                    System.out.println(allClient.get(i));

                }

            } else if (choice == 2) {
                for (int i = 0; i < allClient.size(); i++) {
                    allClient.get(i).mowLawn();

                }
            } else if (choice == 3) {
                System.out.println("Who is paying?");
                String name = Library.input.nextLine();
                System.out.println("How much?");
                double amount = Library.input.nextDouble();
                Library.input.nextLine();

                int foundClient = searchByName(allClient, name);
                allClient.get(foundClient).processPayment(amount);

            } else if (choice == 4) {

            } else if (choice == 5) {
            //delinquent payment
                for(Ex3_Client clientTemp: allClient){
                    clientTemp.delinquent();
                }



            } else {

                break;
            }
        } // while
        System.out.println("There is no use moanin as there is no mow like Moe's mowin.  \nGood bye.");


    }//run

    public static int searchByName( ArrayList<Ex3_Client> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }

    public static void loadFile(String filename, ArrayList<Ex3_Client> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new Ex3_Client(  tempArray[0],tempArray[1], Integer.parseInt(tempArray[4]),Boolean.parseBoolean(tempArray[5]), Double.parseDouble(tempArray[2])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile





}//lawnMain
