import library.model.Library;

import java.util.Scanner;

public class LibraryApplication {
    //instance variables
    static Scanner sc = new Scanner(System.in);
    Library library = new Library();
    boolean run = true;
    //main method
    public static void main(String[] args) {
        LibraryApplication app = new LibraryApplication();
        app.run();
    }

    //run application loop
    void run() {
        System.out.println("Good morning, good afternoon or good evening, what can we assist you with today?");
        do {
            System.out.println("Which of the following would you like to do: ");
            System.out.println("1. Add Books To Library");
            System.out.println("2. Add A New Member");
            System.out.println("3. Member Borrowing A New Book");
            System.out.println("4. Member Returning Book");
            System.out.println("5. Cancel Member");
            System.out.println("6. View Library Books");
            System.out.println("7. View Members");
            System.out.println("8. Close application");
            int uChoice = sc.nextInt();
            sc.nextLine();
            switch (uChoice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.addMember();
                    break;
                case 3:
                    library.borrowBook();
                    break;
                case 4:
                    library.returnBook();
                    break;
                case 5:
                    library.cancelMember();
                    break;
                case 6:
                    System.out.println(library.showBooks());
                    break;
                case 7:
                    System.out.println(library.showMembers());
                    break;
                case 8:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (run);
        sc.close();
    }


}