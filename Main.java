import java.util.*;

public class Main{
    public static void main(String... args){
        Scanner scan = new Scanner(System.in);
        
        String title, author, isbn;
        int availableCopies, response;

        System.out.println("Welcome to the library management system");
        System.out.println("    Please create you first book.       ");
        System.out.print("Enter Book title: ");
        title = scan.nextLine();
        System.out.print("Enter Book author: ");
        author = scan.nextLine();
        System.out.print("Enter Book isbn: ");
        isbn = scan.nextLine();
        System.out.print("Enter Book Copies: ");
        availableCopies = scan.nextInt();
        scan.nextLine();
        System.out.print("\033[H\033[2J");

        ArrayList <Book> book = new ArrayList<>();
        book.add(new Book(title, author, isbn, availableCopies));
        boolean loop = true;

        while(loop == true){
            System.out.println("1. Create another book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Get details");
            System.out.println("5. Exit\n");
            System.out.print("Enter number: ");
            response = scan.nextInt();
            scan.nextLine();

            switch(response){
                case 1:
                    System.out.print("\033[H\033[2J");

                    System.out.print("Enter Book title: ");
                    title = scan.nextLine();
                    System.out.print("Enter Book author: ");
                    author = scan.nextLine();
                    System.out.print("Enter Book isbn: ");
                    isbn = scan.nextLine();
                    System.out.print("Enter Book Copies: ");
                    availableCopies = scan.nextInt();
                    scan.nextLine();
                    book.add(new Book(title, author, isbn, availableCopies));
                    break;
                case 2:
                    System.out.print("\nEnter Book isbn to borrow: ");
                    isbn = scan.nextLine();
                    for(Book i: book){
                        if(i.getIsbn().equals(isbn) && i.getAvailableCopies() > 0){
                            i.setAvailableCopies(i.getAvailableCopies() - 1);
                            System.out.println("Book borrowed successfully.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("\nEnter Book isbn to return: ");
                    isbn = scan.nextLine();
                    for (Book i : book) {
                        if (i.getIsbn().equals(isbn)) {
                            i.setAvailableCopies(i.getAvailableCopies() + 1);
                            System.out.println("Book returned successfully.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    break;
                
                case 5:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
            }
        }

    }
}