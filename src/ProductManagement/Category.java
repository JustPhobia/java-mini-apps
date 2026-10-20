package ProductManagement;

public class Category {
    String categoryName;
    String description;

    //Default Constructor
    public Category (){

    }
    //Set constructor
    public Category (String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
    /*Category Name*/
    //Mutator
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    //Accessor
    public String getCategoryName(){
        return categoryName;
    }

    /*Description*/
    //Mutator
    public void setDescription(String description){
        this.description = description;
    }
    //Accessor
    public String getDescription(){
        return description;
    }
    @Override
    public String toString() {
        return "Category name='" + categoryName + "\nDescription='" + description + "'}";
    }

}
