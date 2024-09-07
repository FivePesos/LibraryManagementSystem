import java.util.*;

public class Main {
    static int booksBorrowed = 0; 

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        
        String title = "", author = "", isbn = "";
        int availableCopies = 0, response;

        while (isbn.length() != 13 || availableCopies <= 0) {
            System.out.println("Welcome to the library management system");
            System.out.println("Please create/add your first book.");
            System.out.print("Enter Book title: ");
            title = scan.nextLine();
            System.out.print("Enter Book author: ");
            author = scan.nextLine();
            System.out.print("Enter Book ISBN (Must be unique and 13 digits): ");
            isbn = scan.nextLine();
            System.out.print("Enter Book Copies: ");
            availableCopies = scan.nextInt();
            scan.nextLine(); 

            if (isbn.length() != 13) {
                System.out.print("\033[H\033[2J");
                System.out.println("ISBN must contain exactly 13 digits.");
            } else if (availableCopies <= 0) {
                System.out.print("\033[H\033[2J");
                System.out.println("You must have at least 1 copy of your book.");
            } else {
                System.out.print("\033[H\033[2J");
                books.add(new Book(title, author, isbn, availableCopies));
                System.out.println("Book added successfully.");
                break;
            }
        }

        boolean loop = true;
        while (loop) {
            displayMenu();
            while (!scan.hasNextInt()) {
                scan.next(); 
                System.out.print("Invalid input. Please enter a number between 1 and 5: ");
            }
            response = scan.nextInt();

            switch (response) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    scan.nextLine(); 
                    boolean isbnDuplicate = false;
                    System.out.print("Enter Book title: ");
                    title = scan.nextLine();
                    System.out.print("Enter Book author: ");
                    author = scan.nextLine();
                    System.out.print("Enter Book ISBN (Must be unique and 13 digits): ");
                    isbn = scan.nextLine();
                    System.out.print("Enter Book Copies: ");
                    availableCopies = scan.nextInt();
                    scan.nextLine(); 
            
                    for (Book book : books) {
                        if (book.getIsbn().equals(isbn)) {
                            isbnDuplicate = true;
                            break;
                        }
                    }
            
                    if (!isbnDuplicate && isbn.length() == 13 && availableCopies > 0) {
                        books.add(new Book(title, author, isbn, availableCopies));
                        System.out.println("Book added successfully.");
                    } else if (isbnDuplicate) {
                        System.out.println("ISBN must be unique. Please enter a different ISBN.");
                    } else if (isbn.length() != 13) {
                        System.out.println("ISBN must contain exactly 13 digits.");
                    } else if (availableCopies <= 0) {
                        System.out.println("You must have at least 1 copy of your book.");
                    }
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    scan.nextLine(); 
                    System.out.print("Enter Book ISBN to borrow: ");
                    isbn = scan.nextLine();
                    boolean successfullyBorrowed = false;
            
                    for (Book book : books) {
                        if (book.getIsbn().equals(isbn) && book.getAvailableCopies() > 0) {
                            book.setAvailableCopies(book.getAvailableCopies() - 1);
                            System.out.println("Book borrowed successfully.");
                            System.out.println("=======================================");
                            System.out.println("Borrowed Book Details:");
                            System.out.println(book.getFormattedDetails());
                            System.out.println("=======================================");
                            successfullyBorrowed = true;
                            booksBorrowed++;
                            break;
                        }
                    }
            
                    if (!successfullyBorrowed) {
                        System.out.println("Invalid ISBN or no more copies available.");
                    }
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    scan.nextLine();
                    if (booksBorrowed > 0) {
                        System.out.print("Enter Book ISBN to return: ");
                        isbn = scan.nextLine();
                        boolean successfullyReturned = false;
            
                        for (Book book : books) {
                            if (book.getIsbn().equals(isbn)) {
                                book.setAvailableCopies(book.getAvailableCopies() + 1);
                                System.out.println("Book returned successfully.");
                                System.out.println("=======================================");
                                System.out.println("Returned Book Details:");
                                System.out.println("=======================================");
                                System.out.println(book.getFormattedDetails());
                                successfullyReturned = true;
                                booksBorrowed--;
                                break;
                            }
                        }
            
                        if (!successfullyReturned) {
                            System.out.println("Invalid ISBN or this book was not borrowed.");
                        }
                    } else {
                        System.out.println("No borrowed books to return.");
                    }
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    int num = 0;
                    for (Book book : books) {
                        num++;
                        System.out.println("=================================================");
                        System.out.println("Details: ");
                        System.out.println(num + ".)\t" + book.getFormattedDetails());
                        System.out.println("=================================================\n");
                    }
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Create/add another book");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Get details");
        System.out.println("5. Exit\n");
        System.out.print("Enter number: ");
    }

}