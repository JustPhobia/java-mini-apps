package ProductManagement;

import java.util.Scanner;

public class ProductShop {
    Scanner sc = new Scanner(System.in);
    Product[] arrProducts= new Product[10];
    int countArr = 0;
    ProductShop(){
    }

    void addProduct(String name, String category, float price, int quantity, String description){
        Category catNew = new Category(category,description);
        Product p = new Product(name,price,catNew,quantity);

        arrProducts[countArr]=p;
        countArr++;
    }
    public void getProducts(){
        for (int i = 0; i < arrProducts.length-1; i++) {
            System.out.print(i+": "+arrProducts[i].toString());
        }
    }
    public void run(){
        boolean keepRun = true;
        boolean populate=false, update=false, view=false;
        String uChoice;
        String name;
        String category;
        String description;
        float price;
        int quantity;
        System.out.println("Welcome user!\nWhat would you like to do today?");
        Programme:
        do {
            System.out.print("[Add]/[Update]/[View][Stop]: ");
            uChoice = sc.nextLine();
            if (uChoice.trim().charAt(0) =='A' || uChoice.trim().charAt(0) == 'a'){
                populate = true;
            } else if (uChoice.trim().charAt(0) =='u' || uChoice.trim().charAt(0) == 'U'){
                update =true;
            }else if(uChoice.trim().charAt(0) =='v' || uChoice.trim().charAt(0) == 'V'){
                view =true;
            }else if(uChoice.trim().charAt(0) =='s' || uChoice.trim().charAt(0) == 'S'){
                keepRun = false;
            }else {
                System.out.println("Invalid, try again: ");
                continue  Programme;

            }

            Populate:
            while(populate) {
                if (countArr < 10) {
                    System.out.print("Name of the product: ");
                    name = sc.nextLine();

                    System.out.print("Category of the product: ");
                    category = sc.nextLine();

                    System.out.println("What is the description of the category: ");
                    description = sc.nextLine();

                    System.out.print("Price of the product: ");
                    price = sc.nextFloat();

                    System.out.print("Product quantity: ");
                    quantity = sc.nextInt();
                    addProduct(name,category,price,quantity,description);
                    System.out.println("Would you like to make another? \nYou currently have: " + countArr + "/10\n(Y/N):");
                    char uContinue = sc.nextLine().trim().toLowerCase().charAt(0);
                    if (uContinue == 'y'){
                        continue Populate;
                    }
                        populate = false;
                        continue Programme;
                }else {
                    System.out.println("You filled your array of products already.");
                    populate = false;
                    continue Programme;
                }
            }
            Update:
            while (update) {
                getProducts();
                System.out.println("Which product would you like to update? Please select it's number: ");
                int uChange = sc.nextInt();
                if (uChange > -1 && uChange < arrProducts.length - 1) {
                    System.out.println(arrProducts[uChange].toString());

                    System.out.println("What would you like to change? [Name]/[Price]/[Quantity]/[Category]");
                    if (sc.nextLine().trim().charAt(0) == 'N' || sc.nextLine().trim().charAt(0) == 'n') {
                        System.out.println("Please input new name: ");
                        arrProducts[uChange].setName(sc.nextLine());
                        update = false;
                    } else if (sc.nextLine().trim().charAt(0) == 'P' || sc.nextLine().trim().charAt(0) == 'p') {
                        System.out.println("Please input new price: ");
                        arrProducts[uChange].setPrice(sc.nextFloat());
                        update = false;
                    } else if (sc.nextLine().trim().charAt(0) == 'Q' || sc.nextLine().trim().charAt(0) == 'q') {
                        System.out.println("Please input new quantity: ");
                        arrProducts[uChange].setQuantity(sc.nextInt());

                        update = false;
                    } else if (sc.nextLine().trim().charAt(0) == 'C' || sc.nextLine().trim().charAt(0) == 'c') {
                        Category catUpdate = new Category();
                        System.out.println("Input the new category name: ");
                        catUpdate.setCategoryName(sc.nextLine());
                        System.out.println("Input the new category description: ");
                        catUpdate.setDescription(sc.nextLine());

                        arrProducts[uChange].setCategory(catUpdate);
                        update = false;
                    } else {
                        continue Update;
                    }
                }
            }
                    View:
            while (view){
                getProducts();
                view = false;
                continue Programme;
            }

        }while(keepRun);
    }
    //Accessor
    public Product[] getArrProducts() {
        return arrProducts;
    }

    public static void main(String[] args) {
        ProductShop productShop = new ProductShop();
        productShop.run();
    }
}
