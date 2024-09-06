import java.util.*;

public class Main{
    public static void main(String... args){
        Scanner scan = new Scanner(System.in);
        
        String title="", author="", isbn = "";
        int availableCopies = 0, response, booksBorrowed = 0;
        
        while(isbn.length() != 13 || availableCopies <= 0){
            System.out.println("Welcome to the library management system");
            System.out.println("    Please create/add you first book.       ");
            System.out.print("Enter Book title: ");
            title = scan.nextLine();
            System.out.print("Enter Book author: ");
            author = scan.nextLine();
            System.out.print("Enter Book isbn (Must be unique and have 13 characters): ");
            isbn = scan.nextLine();
            System.out.print("Enter Book Copies: ");
            availableCopies = scan.nextInt();
            scan.nextLine();
            if(isbn.length() != 13)
                System.out.print("\033[H\033[2J");
                System.out.println("ISBN must contain 13 characters.");
            if(availableCopies <= 0){
                System.out.print("\033[H\033[2J");
                System.out.println("You must have atleast 1 copy of your book.");
            }
        }
        
        System.out.print("\033[H\033[2J");
        ArrayList <Book> book = new ArrayList<>();
        book.add(new Book(title, author, isbn, availableCopies));
        boolean loop = true;
    
        while(loop == true){
            System.out.println("1. Create/add another book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Get details");
            System.out.println("5. Exit\n");
            System.out.print("Enter number: ");
            response = scan.nextInt();
            scan.nextLine();

            switch(response){
                case 1:
                    boolean isbnDuplicate = false;
                    System.out.print("\033[H\033[2J");

                    System.out.print("Enter Book title: ");
                    title = scan.nextLine();
                    System.out.print("Enter Book author: ");
                    author = scan.nextLine();
                    System.out.print("Enter Book isbn (Must be unique and have 13 characters): ");
                    isbn = scan.nextLine();
                    System.out.print("Enter Book Copies: ");
                    availableCopies = scan.nextInt();
                    scan.nextLine();

                    for(Book i : book){
                        if(i.getIsbn().equals(isbn)){
                            isbnDuplicate= true;
                        }
                    }

                    if(isbnDuplicate == false && isbn.length() == 13 && availableCopies > 0){
                        book.add(new Book(title, author, isbn, availableCopies));
                        System.out.println("BOOK ADDED SUCCESFULLY.");
                    }else if(isbnDuplicate == true && isbn.length() != 13 && availableCopies > 0){
                        System.out.println("Please enter a unique 13 character ISBN.\n");
                    }else if(isbnDuplicate == false && isbn.length() == 13 && availableCopies <= 0){
                        System.out.println("You must have atleast 1 copy of your book.");
                    }else{
                        System.out.println("Please enter a unique 13 character ISBN.");
                        System.out.println("You must have atleast 1 copy of your book.");
                    }
                    
                    break;

                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.print("\nEnter Book isbn to borrow: ");
                    isbn = scan.nextLine();
                    boolean successfullyBorrowed = false;
                    for(Book i: book){
                        if(i.getIsbn().equals(isbn) && i.getAvailableCopies() > 0){
                            successfullyBorrowed = true;
                            i.setAvailableCopies(i.getAvailableCopies() - 1);
                            System.out.println("Book borrowed successfully.");
                            booksBorrowed++;
                            break;
                        }

                        if(successfullyBorrowed == false){
                            System.out.print("\033[H\033[2J");
                            System.out.println("Invalid ISBN or No more copies of the book");
                        }
                    }
                    break;

                case 3:
                    System.out.print("\033[H\033[2J");
                    
                    if(booksBorrowed > 0){
                        System.out.print("\nEnter Book isbn to return: ");
                        isbn = scan.nextLine();
                        boolean successfullyReturned = false;
                        for (Book i : book) {
                            if (i.getIsbn().equals(isbn)) {
                                i.setAvailableCopies(i.getAvailableCopies() + 1);
                                System.out.println("Book returned successfully.");
                                booksBorrowed--;
                                successfullyReturned = true;
                                break;
                            }
    
                            if(successfullyReturned == false){
                                System.out.println("Invalid ISBN or this book was not borrowed.");
                            }
                        }
                    }else{
                        System.out.print("\033[H\033[2J");
                        System.out.println("No borrowed books to return.\n");
                    }
                    
                    break;
                case 4:
                    int num = 0;
                    System.out.print("\033[H\033[2J");
                    for(Book i : book){
                        num++;
                        System.out.println("=================================================");
                        System.out.println("Details: ");
                        System.out.println(num + ".)\tTitle: " + i.getTitle());
                        System.out.println("\tAuthor: " + i.getAuthor());
                        System.out.println("\tISBN: " + i.getIsbn());
                        System.out.println("\tAvailable Copies: " + i.getAvailableCopies());
                        System.out.println("=================================================\n");
                    }
                    break;
                
                case 5:
                    System.out.println("Exiting...");
                    loop = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }

    }
}