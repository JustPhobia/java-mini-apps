package library.model;

import java.util.Random;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    Book[] catalogue = new Book[100];
    int bookCount = 0;
    LibraryMember[] currentMembers = new LibraryMember[10];
    int memberCount = 0;
    Random rand = new Random();
    StringBuilder borrowedBooks = new StringBuilder();


    public Library() {
    }

    //adding book
    public void addCatalogue(String title, String author, int year) {
        boolean yesMatch = false;
        StringBuilder testISBN = new StringBuilder();
        System.out.println("It's running...");
        if (bookCount < 100) {
            Random:
            while (!yesMatch) {
                testISBN.delete(0, testISBN.length());
                if (bookCount < 10) {
                    testISBN.append(String.valueOf(rand.nextInt(1000, 9999))).append(bookCount);
                } else {
                    testISBN.append(String.valueOf(rand.nextInt(100, 999))).append(bookCount);
                }
                for (int i = 0; i < bookCount; i++) {
                    if (catalogue[i].getIsbnNum().contentEquals(testISBN)) {
                        yesMatch = true;
                    }
                }
                yesMatch = !yesMatch;
            }
            Book b = new Book(title, author, year, testISBN.toString());
            catalogue[bookCount] = b;
            bookCount++;
            System.out.println(title + "'s ISBN is: " + testISBN.toString());
        } else {
            System.out.println("Catalogue is full.");
        }

    }

    public void newMember(String name, String surname) {
        boolean yesMatch = false;
        StringBuilder memberID = new StringBuilder();
        if (memberCount < 9) {
            while (!yesMatch) {
                memberID.delete(0, memberID.length());
                memberID.append(String.valueOf(rand.nextInt(1000, 9999))).append(memberCount);

                for (int i = 0; i < memberCount; i++) {
                    if (currentMembers[i].memberID.contentEquals(memberID)) {
                        yesMatch = true;
                    }
                }
                yesMatch = !yesMatch;
            }
            LibraryMember L = new LibraryMember(memberID.toString(), name, surname);
            currentMembers[memberCount] = L;
            memberCount++;
        } else {
            System.out.println("Member slots are full.");
        }
    }

    public String showMembers() {
        StringBuilder members = new StringBuilder();
        for (int i = 0; i < memberCount; i++) {
            members.append(i).append(": ").append(currentMembers[i].getInfo()).append("\n");
        }
        return members.toString();
    }

    public String showBooks() {
        StringBuilder books = new StringBuilder();
        for (int i = 0; i < bookCount; i++) {
            books.append(i).append(": ").append(catalogue[i].toString()).append("\n");
        }
        return books.toString();
    }

    public void addBook() {
        String title, author;
        int year;

        System.out.print("Title: ");
        title = sc.nextLine();
        System.out.print("Author: ");
        author = sc.nextLine();
        System.out.print("Year: ");
        year = sc.nextInt();
        sc.nextLine();
        addCatalogue(title, author, year);
    }

    public void addMember() {
        String newName, newSurname;
        System.out.print("Please type name of the new member: ");
        newName = sc.nextLine();
        System.out.print("Please type surname of the new member: ");
        newSurname = sc.nextLine();

        newMember(newName, newSurname);
    }

    public void borrowBook() {
        System.out.println(showMembers());
        System.out.print("Which member is borrowing (index): ");
        int uRequester = sc.nextInt();
        sc.nextLine();

        if (uRequester >= 0 && uRequester < memberCount) {
            LibraryMember member = currentMembers[uRequester];
            if (member.borrowedCount < member.borrowedBooks.length) {
                System.out.println(showBooks());
                System.out.print("Which book (index): ");
                int uBook = sc.nextInt();
                sc.nextLine();

                if (uBook >= 0 && uBook < bookCount && catalogue[uBook] != null) {
                    member.borrowedBooks[member.borrowedCount] = catalogue[uBook];
                    member.borrowedCount++;
                    catalogue[uBook] = new Book();
                    borrowedBooks.append(uBook);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Invalid book choice.");
                }
            } else {
                System.out.println("Borrow limit reached.");
            }
        } else {
            System.out.println("Invalid member choice.");
        }
    }

    public void returnBook() {
        System.out.println(showMembers());
        System.out.print("Which member is returning (index): ");
        int uReturner = sc.nextInt();
        sc.nextLine();

        if (uReturner >= 0 && uReturner < memberCount) {
            LibraryMember member = currentMembers[uReturner];
            System.out.println(member.getBorrowedBooks());
            System.out.print("Which book index to return: ");
            int uBook = sc.nextInt();
            sc.nextLine();

            if (uBook >= 0 && uBook < member.borrowedCount && member.borrowedBooks[uBook] != null) {
                int bookPlace = (int) borrowedBooks.charAt(0);
                borrowedBooks.delete(0, 1);
                catalogue[bookPlace] = member.borrowedBooks[uBook];
                member.borrowedBooks[uBook] = null;
                member.borrowedCount--;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Invalid borrowed book choice.");
            }
        } else {
            System.out.println("Invalid member choice.");
        }
    }

    public void cancelMember() {
        int memberChoice;
        String confirmChoice;
        System.out.println(showMembers());
        System.out.println("Which member are you cancelling: ");
        memberChoice = sc.nextInt();
        sc.nextLine();
        if (memberChoice >= 0 && memberChoice <= memberCount) {
            System.out.println("Is  this the correct member:\n" + currentMembers[memberChoice].getInfo() + "\n[Yes]/[No]");
            confirmChoice = sc.nextLine();
            if (confirmChoice.trim().toLowerCase().charAt(0) == 'y') {
                currentMembers[memberChoice] = null;
                for (int i = 0; i <= memberCount - 1; i++) {
                    if (currentMembers[i] == null && i != memberCount) {
                        currentMembers[i] = currentMembers[i + 1];
                        currentMembers[i + 1] = null;
                    }
                }
                memberCount--;
            }
        }
    }

}
