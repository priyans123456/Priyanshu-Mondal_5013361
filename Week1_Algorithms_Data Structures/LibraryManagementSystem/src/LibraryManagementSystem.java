import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryManagementSystem {
    
    // Class to represent a Book
    static class Book {
        private int bookId;
        private String title;
        private String author;

        // Constructor
        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getters
        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    // Class to manage the library system
    static class LibrarySystem {
        private List<Book> books;

        public LibrarySystem() {
            books = new ArrayList<>();
        }

        // Method to add a book to the library
        public void addBook(Book book) {
            books.add(book);
        }

        // Linear search to find a book by title
        public Book linearSearchByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null; // Not found
        }

        // Binary search to find a book by title (assuming the list is sorted)
        public Book binarySearchByTitle(String title) {
            int left = 0;
            int right = books.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Book midBook = books.get(mid);

                int comparison = midBook.getTitle().compareToIgnoreCase(title);

                if (comparison == 0) {
                    return midBook;
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null; // Not found
        }

        // Method to sort the books by title for binary search
        public void sortBooksByTitle() {
            books.sort(Comparator.comparing(Book::getTitle));
        }

        // Method to display all books
        public void displayBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Adding books
        library.addBook(new Book(1, "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3, "1984", "George Orwell"));
        library.addBook(new Book(4, "Moby-Dick", "Herman Melville"));

        // Display all books
        System.out.println("All Books:");
        library.displayBooks();

        // Perform linear search
        String searchTitleLinear = "1984";
        Book foundBookLinear = library.linearSearchByTitle(searchTitleLinear);
        if (foundBookLinear != null) {
            System.out.println("Linear Search Found: " + foundBookLinear);
        } else {
            System.out.println("Linear Search: Book not found.");
        }

        // Sort books by title
        library.sortBooksByTitle();

        // Perform binary search
        String searchTitleBinary = "Moby-Dick";
        Book foundBookBinary = library.binarySearchByTitle(searchTitleBinary);
        if (foundBookBinary != null) {
            System.out.println("Binary Search Found: " + foundBookBinary);
        } else {
            System.out.println("Binary Search: Book not found.");
        }
    }
}
