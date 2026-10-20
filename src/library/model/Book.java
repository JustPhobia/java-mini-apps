package library.model;

public class Book {
    //instance variables
    private String title;
    private String author;
    private int year;
    private String isbnNum;

    //default constructor
    Book() {
        title = "";
        author = "";
        year = 0;
    }

    //parameterized constructor
    Book(String title, String author, int year, String isbnNum) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbnNum = isbnNum;
    }

    //mutator for title
    public void setTitle(String title) {
        this.title = title;
    }

    //accessor for title
    public String getTitle() {
        return title;
    }

    //mutator for author
    public void setAuthor(String author) {
        this.author = author;
    }

    //accessor for author
    public String getAuthor() {
        return author;
    }

    //mutator for year
    public void setYear(int year) {
        this.year = year;
    }

    //accessor for year
    public int getYear() {
        return year;
    }

    //mutator for ISBN
    public void setIsbnNum(String isbnNum) {
        this.isbnNum = isbnNum;
    }

    //accessor for ISBN
    public String getIsbnNum() {
        return isbnNum;
    }

    //display book info
    @Override
    public String toString() {
        return "| Title: " + title + "\t | Author: " + author + "\t | Year: " + year + "\t | ISBN: " + isbnNum + " |";
    }
}