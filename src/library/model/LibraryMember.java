package library.model;

public class LibraryMember {
    //instance variables
    String memberID;
    String name;
    String surname;
    int borrowedCount;
    Book[] borrowedBooks = new Book[10];

    //default constructor
    LibraryMember() {
        memberID = "";
        name = "";
        surname = "";
        borrowedCount = 0;
    }

    //parameterized constructor
    LibraryMember(String memberID, String name, String surname) {
        this.memberID = memberID;
        this.surname = surname;
        this.name = name;
        borrowedCount = 0;
    }

    //accessor for member info
    String getInfo() {
        return "| ID: " + memberID + " | Name: " + name + " | Surname: " + surname + " | Borrowed count: " + borrowedCount + " |";
    }

    //accessor for ID
    String getMemberID() {
        return memberID;
    }

    //accessor for name
    String getName() {
        return name;
    }

    //accessor for surname
    String getSurname() {
        return surname;
    }

    //mutator for borrowed books
    public void setBorrowedBooks(String title, String author, int year, String isbnNum) {
        Book b = new Book(title, author, year, isbnNum);
        borrowedBooks[borrowedCount] = b;
        borrowedCount++;
    }

    //accessor for borrowed books
    public String getBorrowedBooks() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] != null) {
                temp.append(i).append(" : [").append(borrowedBooks[i].getTitle()).append("] [").append(borrowedBooks[i].getAuthor()).append("] [").append(borrowedBooks[i].getYear()).append("]");
            }
            temp.append("\n");
        }
        return temp.toString();
    }

    //display member info
    @Override
    public String toString() {
        return getInfo() + "\nBooks borrowed: \n" + getBorrowedBooks();
    }
}