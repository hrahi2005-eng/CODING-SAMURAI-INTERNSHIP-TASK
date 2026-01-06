import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}


class Library {
    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, String> borrowHistory = new HashMap<>();

    void addBook(Book book) {
        books.add(book);
    }

    void searchBook(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                found = true;
                System.out.println("ID: " + b.id + ", Title: " + b.title +
                        ", Author: " + b.author +
                        ", Available: " + b.isAvailable);
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    void borrowBook(int id, String user) {
        for (Book b : books) {
            if (b.id == id && b.isAvailable) {
                b.isAvailable = false;
                borrowHistory.put(id, user);
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.isAvailable) {
                b.isAvailable = true;
                borrowHistory.remove(id);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid return.");
    }

    void showHistory() {
        if (borrowHistory.isEmpty()) {
            System.out.println("No borrow history.");
        } else {
            for (Map.Entry<Integer, String> entry : borrowHistory.entrySet()) {
                System.out.println("Book ID: " + entry.getKey() +
                        " borrowed by " + entry.getValue());
            }
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample books
        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Data Structures", "Mark Weiss"));
        library.addBook(new Book(3, "Operating Systems", "Galvin"));

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Search Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Borrow History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    library.searchBook(title);
                    break;

                case 2:
                    System.out.print("Enter book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your name: ");
                    String user = sc.nextLine();
                    library.borrowBook(id, user);
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 4:
                    library.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}