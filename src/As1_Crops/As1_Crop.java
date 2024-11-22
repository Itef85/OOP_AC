package As1_Crops;

import java.util.ArrayList;

public class As1_Crop {

    private String name;

    private double yield; // per acre

    private String units; //The units used in the above calculation

    private double price; //The price per unit you will get for each crop

    private int acres; // The number of acres you currently have planted

    public As1_Crop(String n, double y, String u, double p) {
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;

    }//crop

    public String toString(){
        return name + ", " + yield + ", " + units + ", " + price + ", " + acres;
    }//toString


    public void setAcres(int acres) {
        this.acres = acres;
    }//setter method

    public void printMe(){
        System.out.println(name + " is planted in " + acres + " acres yielding " + yield + " " + units + " at the cost of $" + price + " per bu/cwt/ton/lb" );
    }

    public double Harvest(){
        double total =  this.price * this.yield * this.acres;
        System.out.println("Harvest Value: $" + total);
        this.acres = 0;
        return total;
    }



    public String getName() {
        return name;
    }
}//class
