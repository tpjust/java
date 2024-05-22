//Library mananagement system

import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                return "You have borrowed: " + book.getTitle();
            }
        }
        return "Book not available.";
    }

    public String returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                return "You have returned: " + book.getTitle();
            }
        }
        return "Book not found or already returned.";
    }

    public List<Book> searchByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> displayAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780747532743");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println(library.borrowBook("To Kill a Mockingbird"));
        System.out.println(library.borrowBook("To Kill a Mockingbird"));  // Trying to borrow the same book again

        System.out.println(library.returnBook("To Kill a Mockingbird"));

        System.out.println(library.searchByTitle("Harry Potter"));
        System.out.println(library.searchByAuthor("J.K. Rowling"));
        System.out.println(library.displayAvailableBooks());
    }
}
