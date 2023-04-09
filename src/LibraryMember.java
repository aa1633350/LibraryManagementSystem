import java.util.*;

public class LibraryMember {
    private String name;
    private String memberId;
    private int booksIssued;
    private List<Book> booksIssuedToMember;
    private Library library;
    public LibraryMember(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.library = new Library();
        this.booksIssuedToMember = new ArrayList<>();
    }

    public void searchBook() {
        // Support multiple search criteria.
        // Search by title,author,published date etc.
        System.out.println("Welcome " + this.name + " to our Library, press");
        System.out.println("1 : To search book by Author");
        System.out.println("2 : To search book by Title");
        System.out.println("3 : To search book by Genre");
        System.out.println("4 : To search book by Published Date");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        List<Book> books = library.getBookList();
        switch (choice) {
            case 1:
                System.out.println("Enter the author :");
                String author = sc.next();
                searchByAuthor(author, books, sc);
            case 2:
                System.out.println("Enter the title of book :");
                String title = sc.next();
                searchByTitle(title, books, sc);
            case 3:
                System.out.println("Enter the genre of book :");
                String genre = sc.next();
                searchByGenre(genre, books, sc);
            default:
                System.out.println("Please provide a valid input.");
        }
    }

    private void searchByAuthor(String authorName, List<Book> books, Scanner scanner) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(authorName)) {
                booksByAuthor.add(book);
            }
        }
        if (booksByAuthor.size() == 0) {
            System.out.println("No books found by author : " + authorName);
        } else {
            System.out.println(booksByAuthor.size() + " Books found written by author : " + authorName);
            for (Book bookByAuthor : booksByAuthor) {
                System.out.println(bookByAuthor.getTitle());
            }
            chooseBook(scanner, booksByAuthor);
        }
    }

    private void searchByTitle(String title, List<Book> books, Scanner scanner) {
        List<Book> booksByTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                booksByTitle.add(book);
            }
        }
        if (booksByTitle.size() == 0) {
            System.out.println("No books found by title : " + title);
        } else {
            System.out.println(booksByTitle.size() + " Books found by title : " + title);
            for (Book bookByTitle : booksByTitle) {
                System.out.println(bookByTitle.getTitle());
            }
            chooseBook(scanner, booksByTitle);
        }
    }

    private void searchByGenre(String genre, List<Book> books, Scanner scanner) {
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                booksByGenre.add(book);
            }
        }
        if (booksByGenre.size() == 0) {
            System.out.println("No books found by author : " + genre);
        } else {
            System.out.println(booksByGenre.size() + " Books found written by author : " + genre);
            for (Book bookByGenre : booksByGenre) {
                System.out.println(bookByGenre.getTitle());
            }
            chooseBook(scanner, booksByGenre);
        }
    }

    private void chooseBook(Scanner scanner, List<Book> books) {
        System.out.println("Do you want to issue a book, press 'Y' or 'N' ");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase("Y")) {
            issueBookToMember(this.memberId, this.booksIssued, books, scanner);
        } else {
            System.out.println("Happy searching !!");
        }
    }


    private void issueBookToMember(String memberId, int numOfBooksIssued, List<Book> books, Scanner scanner) {
        System.out.println("Enter the book name you want :");
        String title = scanner.next();

        for(Book book : books) {
            if(title.equalsIgnoreCase(book.getTitle())) {
                int remainingCopies = Math.max(book.getCopies() - 1, 0);
                if(remainingCopies == 0) {
                    System.out.println("Oops !! " + book.getTitle() + " is currently not available. We regret the inconvenience ");
                    return;
                }
                this.booksIssued = numOfBooksIssued + 1;
                this.booksIssuedToMember.add(book);
                book.setCopies(remainingCopies);
            }
        }
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public List<Book> getBooksIssuedToMember() {
        return booksIssuedToMember;
    }

    public String getName() {
        return name;
    }

}
