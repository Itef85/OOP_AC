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

            System.out.println("Press 1 to Print List of Teams\nPress 2 to Find the Average's\nPress 3 to View by Division\nPress 4 to Sort by Lowest to Highest Wins\nPress 5 to Update Stats\nPress 6 to Exit and Save");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
//                System.out.println("not yet implemented");
                for (int i = 0; i < allTeam.size(); i++) {
                    allTeam.get(i).printMe();
                }
            }
            if (choice == 2) {
             //  System.out.println("not yet implemented");
            int avrW = 0;
            int avrL = 0;
            int avrOTL = 0;

            for (int i=0; i<allTeam.size(); i++){
                avrW = avrW + allTeam.get(i).getWins();
                avrL = avrL + allTeam.get(i).getLoses();
                avrOTL = avrOTL + allTeam.get(i).getOverTimeLoses();

            }
                System.out.println("The Average Wins Are: " + (avrW / allTeam.size()) + "\nThe Average Loses Are: " + (avrL / allTeam.size()) + "\nThe Average Over Time Loses Are: " + (avrOTL / allTeam.size())       );
// set thing to 0 then for loop all things added to make 1 thing divide that by teamsize



            }
            if (choice == 3) {
               // System.out.println("not yet implemented");
                System.out.println("What Divison would you like to search in? \nMetropolitan\nAtlantic\nCentral\nPacific");
                System.out.println();
                String div = Library.input.nextLine();

                for( int i =0; i<allTeam.size(); i++){
                if(div.equalsIgnoreCase(allTeam.get(i).getDivision()  )   ){
                    System.out.println("The " + allTeam.get(i).getNickName() + " Who Play In " + allTeam.get(i).getCity() + " With " + allTeam.get(i).getWins() + " Wins And " + allTeam.get(i).getLoses() + " Loses"   );
                }

                }
                //in for loop if div .equals division print div at i


            }
            if (choice == 4) {
              //  System.out.println("not yet implemented");


                    selectionSortIntArr(allTeam);




            }
            if (choice == 5) {
              //  System.out.println("not yet implemented");

                System.out.println("What is the Nick Name of the first team that played?");
                String name = Library.input.nextLine();
                int foundIndex = searchByName(allTeam, name);
                if(foundIndex > -1  ){

                System.out.println("did they win?");
                String win = Library.input.nextLine();
                if( win.equalsIgnoreCase("yes")){
                    allTeam.get(foundIndex).setWins(1);
                }else {
                    System.out.println("did they Lose in overtime?");
                    String ot = Library.input.nextLine();
                    if ( ot.equalsIgnoreCase("yes")){
                        allTeam.get(foundIndex).setOverTimeLoses(1);
                        allTeam.get(foundIndex).setLoses(1);
                    }else {
                        allTeam.get(foundIndex).setLoses(1);
                    }
                }//else - win

                }else{
                    System.out.println("This is not a Team please try again?");
                    break;
                }//foundIndex

                System.out.println("What is the Nick Name of the first team that played?");
                String name2 = Library.input.nextLine();
                int foundIndex2 = searchByName(allTeam, name2);
                if(foundIndex2 > -1  ){

                    System.out.println("did they win?");
                    String win = Library.input.nextLine();
                    if( win.equalsIgnoreCase("yes")){
                        allTeam.get(foundIndex2).setWins(1);
                    }else {
                        System.out.println("did they Lose in overtime?");
                        String ot = Library.input.nextLine();
                        if ( ot.equalsIgnoreCase("yes")){
                            allTeam.get(foundIndex2).setOverTimeLoses(1);
                            allTeam.get(foundIndex2).setLoses(1);
                        }else {
                            allTeam.get(foundIndex2).setLoses(1);
                        }
                    }//else - win

                }else{
                    System.out.println("This is not a Team please try again?");
                    break;
                } //foundIndex2




                }
            if (choice == 6) {
                System.out.println("would you like to save?\nyes\nno");
                String save = Library.input.nextLine();
                if(save.equalsIgnoreCase("yes")) {
                    saveFile("data/nhlTeams.csv", allTeam);
                    break;
                }else{
                    break ;
                }
            }//6
            System.out.println();

        }//while

        System.out.println("Good bye");





    }//run




    public static int searchByName( ArrayList<As3_Team> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getNickName() )){
                return i;
            }
        }
        return -1;
    }


    public static void selectionSortIntArr(ArrayList<As3_Team> list){
        for(int i=0; i<list.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<list.size(); j++){
                if(list.get(j).getWins() < list.get(lowestIndex).getWins()     ){
                    lowestIndex = j;
                }
            }
//swaps the lowest to the beginning
            As3_Team tempCrop = list.get(i);
            list.set(i, list.get(lowestIndex) );
            list.set(lowestIndex, tempCrop);


        }
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
