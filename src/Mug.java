import java.util.Random;
import java.util.Scanner;

public class Mug {
    //Instance variables
    int capacity;
    int liquid;

    //Constructor
    Mug(int fCapacity,int fLiguid){
        capacity = fCapacity;
        liquid = fLiguid;
    }

    //Mutator method
    void setCapacity(int capacity) {
        this.capacity = capacity; //keyword, assigns to instance variable
    }

    //Mutator method
    void fill(){
        liquid = capacity;
    }

    //mutator method
    void sip(int amount){
        if (liquid-amount <0){
            liquid = 0;
        }else{
            liquid -= amount;
        }
    }

    //Mutator method
    void empty(int amount) {
        if (amount <= liquid) {
            liquid -= amount;
        } else {
            System.out.println("Not enough liquid.");
        }
    }

    //Mutator method
    void smash(){
        capacity =0;
        liquid = 0;
        System.out.println(
                "Your mug was smashed! " +
                 "\nWell that was stupid");
    }

    //Accessor method
    int getLiquidVolume(){
        return liquid;
    }
    // Accessor method
    String getLiquid(){
        return "The total liquid is:" + liquid +"ml";
    }

    // Accessor method
    String getCapacity(){
        return "The capacity is: "+capacity +"ml";
    }
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        Mug mug = new Mug(250,250);
        mug.fill();
        while(mug.getLiquidVolume()>0){
            System.out.println("Drink more?? (f): ");
            if (input.nextLine().equalsIgnoreCase("f")){
                mug.fill();
            } else  {
                mug.sip(rand.nextInt(25, 50));
            }
            System.out.println(mug.getCapacity());
            System.out.println(mug.getLiquid());;
        }

        mug.smash();

    }
}
