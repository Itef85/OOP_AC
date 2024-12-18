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


            if( allTeam.get(0).getName().equals("New York Rangers")){
                allTeam.get(0).addPlayer("Alex Belzile", 60, 6, "RW");
                allTeam.get(0).addPlayer("Brett Berard", 65, 2, "LW");
                allTeam.get(0).addPlayer("Anton Blidh", 25, 0, "LW");
                allTeam.get(0).addPlayer("Jonny Brodzinski", 22, 2, "C");
                allTeam.get(0).addPlayer("Filip Chytil", 72, 6, "C");
           }

        if( allTeam.get(1).getName().equals("Detroit Red Wings")){
            allTeam.get(1).addPlayer("Andrew Copp",18,7,"C");
            allTeam.get(1).addPlayer("Joe Veleno",90,1,"C");
        }

        if( allTeam.get(2).getName().equals("Washington Capitals")){
            allTeam.get(2).addPlayer("Nicklas Backstrom",19,0,"C");
            allTeam.get(2).addPlayer("Sonny Milano",15,0,"LW");
        }

        if( allTeam.get(3).getName().equals("Montreal Canadiens")){
            allTeam.get(3).addPlayer("Josh Anderson",17,5,"RW");
            allTeam.get(3).addPlayer("Kirby Dach",77,2,"C");
        }

        if( allTeam.get(4).getName().equals("Los Angeles Kings")){
            allTeam.get(4).addPlayer("Quinton Byfield",55,4,"RW");
            allTeam.get(4).addPlayer("Trevor Moore",12,6,"LW");
        }

        if( allTeam.get(5).getName().equals("Winnipeg Jets")){
            allTeam.get(5).addPlayer("Mason Appleton",22,6,"C");
            allTeam.get(5).addPlayer("Kyle Connor",81,17,"LW");
        }

        if( allTeam.get(6).getName().equals("Edmonton Oilers")){
            allTeam.get(6).addPlayer("Connor McDavid",97,14,"C");
            allTeam.get(6).addPlayer("Evander Kane",91,4,"LW");
        }

        if( allTeam.get(7).getName().equals("St. Louis Blues")){
            allTeam.get(7).addPlayer("Nikita Alexandrov",59,0,"C");
            allTeam.get(7).addPlayer("Nathan Walker",26,3,"LW");
        }

        if( allTeam.get(8).getName().equals("Chicago Blackhawks")){
            allTeam.get(8).addPlayer("Andreas Athanasiou",89,0,"C");
            allTeam.get(8).addPlayer("Taylor Hall",71,7,"LW");
        }

        if( allTeam.get(9).getName().equals("las vegas golden knights")){
            allTeam.get(9).addPlayer("Ivan Barbashev",49,15,"C");
            allTeam.get(9).addPlayer("Jack Eichel",9,9,"C");
        }





        System.out.println("NHL 2023-24 season team stats");
        for(int i=0; i<allTeam.size(); i++){
            System.out.println(allTeam.get(i).toString());
        }

        while(true) {
            System.out.println();

            System.out.println("Press 1 to Print List of Teams\nPress 2 to Find the Average's\nPress 3 to View by Division\nPress 4 to Sort by Lowest to Highest Wins\nPress 5 to Update Stats\nPress 6 to Print Players\nPress 7 to Print Team name and total goals\nPress 8 to Update The Stats of A Player\nPress 9 to Exit and Save");

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
                System.out.println("What is the name of the team you want?");
                String name = Library.input.nextLine();

                int foundIndex = searchByName2(allTeam, name);
                if(foundIndex > -1  ){
                    allTeam.get(foundIndex).printMyPlayers();
                }else{
                    System.out.println(foundIndex);
                    System.out.println("Team not found please try again");
                }


            }
            if (choice == 7) {


                for (int i = 0; i < allTeam.size(); i++) {
                    System.out.println(allTeam.get(i).getName());
                    System.out.println( "Has: " + allTeam.get(i).avragegoals() + " Goals");
                }


            }
            if (choice == 8) {
//                System.out.println("What is the name of the Player you want?");
//                String name = Library.input.nextLine();
//                for (int i = 0; i < allTeam.size(); i++) {
//
//                int foundIndex = searchByPlayers(allTeam.get(i).getAllPlayers(), name);
//                if(foundIndex > -1  ){
//                    allTeam.get(foundIndex).updateStats();
//
//                }//foundIndex
//            }//for

                System.out.println("not implemented");

            }
            if (choice == 9) {
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

    public static int searchByName2( ArrayList<As3_Team> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }
    public static int searchByPlayers( ArrayList<As3_Players> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getNameP() )){
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
