class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;

    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getFormattedDetails() {
        return "Title: " + title +
               "\nAuthor: " + author +
               "\nISBN: " + formatIsbn(isbn) +
               "\nAvailable Copies: " + availableCopies;
    }

    private String formatIsbn(String isbn) {
        return isbn.substring(0, 3) + "-" +
               isbn.substring(3, 4) + "-" +
               isbn.substring(4, 8) + "-" +
               isbn.substring(8, 12) + "-" +
               isbn.substring(12);
    }
}