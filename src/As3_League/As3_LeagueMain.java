package As3_League;

import As1_Crops.As1_Crop;
import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;
//import Examples.Library;

public class As3_LeagueMain {

    public static void run() {

        ArrayList<As3_Team> allTeam = new ArrayList();
        loadFile("data/nhlTeams.csv", allTeam);

        System.out.println("NHL 2023-24 season team stats");
        for(int i=0; i<allTeam.size(); i++){
            System.out.println(allTeam.get(i).toString());
        }

        while(true) {
            System.out.println();

            System.out.println("Press 1 to Print List of Teams\nPress 2 to Find the Average's\nPress 3 to View by Division\nPress 4 to Sort by team NickName\nPress 5 to Update Stats\nPress 6 to Exit and Save");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
//                System.out.println("not yet implemented");
                for (int i = 0; i < allTeam.size(); i++) {
                    allTeam.get(i).printMe();
                }
            }
            if (choice == 2) {
               System.out.println("not yet implemented");
            int avrW = 0;
            int avrL = 0;
            int avrOTL = 0;

// set thing to 0 then for loop all things added to make 1 thing divide that by teamsize



            }
            if (choice == 3) {
                System.out.println("not yet implemented");



            }
            if (choice == 4) {
                System.out.println("not yet implemented");

            }
            if (choice == 5) {
                System.out.println("not yet implemented");

            }
            if (choice == 6) {
                saveFile("data/nhlTeams.csv", allTeam);
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");





    }//run




    public static int searchByDivision( ArrayList<As3_Team> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getDivision() )){
                return i;
            }
        }
        return -1;
    }


    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new As3_Team(  tempArray[0],tempArray[1], tempArray[2] ,tempArray[3], Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile


    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getNickName();
                toSave +="," + tempList.get(i).getCity();
                toSave +="," + tempList.get(i).getDivision();
                toSave += "," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getLoses();
                toSave +="," + tempList.get(i).getOverTimeLoses();

//The above 6 lines could be replaced by a call to a carefully made toString() function


                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile




}//main
