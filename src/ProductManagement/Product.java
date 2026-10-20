package ProductManagement;

public class Product {
    private String name;
    private Category category;
    private float price;
    private int quantity;



    //Default Constructor
    public Product (){
        this.name = "";
        this.price = 0;
        this.category = null;
        this.quantity = 0;
    }

    //Set Constructor
    public Product (String name, float price, Category category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    /*Name*/
    //Accessor
    public String getName() {
        return name;
    }
    //Mutator
    public void setName(String name) {
        this.name = name;
    }

    /*Price*/
    //Accessor
    public float getPrice() {
        return price;
    }
    //Mutator
    public void setPrice (float price) {
        this.price = price;
    }

    /*Category*/
    //Accessor
    public Category getCategory() {
        return category;
    }
    //Mutator
    public void setCategory(Category category) {
        this.category = category;
    }
    //toString

    /*quantity*/
    //Mutator
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    //Accessor
    public int getQuantity(){
        return quantity;
    }

    //toString
    @Override
    public String toString() {
        return "Product{name: " + name +
                " Category: " + category.categoryName +
                " Price: " + price +
                " Quantity: " + quantity;
    }
    }
