import java.util.*;

public class LibraryMember {
    private String name;
    private String memberId;
    private int booksIssued;
    private List<Book> booksIssuedToMember;
    private Library library;
    public LibraryMember(String name, String memberId, Library library) {
        this.name = name;
        this.memberId = memberId;
        this.library = library;
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
        sc.nextLine(); // consumes the new line character;
        List<Book> books = library.getBookList();
        switch (choice) {
            case 1:
                System.out.println("Enter the author :");
                String author = sc.nextLine();
                searchByAuthor(author, books, sc);
                break;
            case 2:
                System.out.println("Enter the title of book :");
                String title = sc.nextLine();
                searchByTitle(title, books, sc);
                break;
            case 3:
                System.out.println("Enter the genre of book :");
                String genre = sc.nextLine();
                searchByGenre(genre, books, sc);
                break;
            default:
                System.out.println("Please provide a valid input.");
        }
    }

    private void searchByAuthor(String authorName, List<Book> books, Scanner scanner) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
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
            chooseBook(scanner, booksByAuthor, true);
        }
    }

    private void searchByTitle(String title, List<Book> books, Scanner scanner) {
        List<Book> booksByTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
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
            chooseBook(scanner, booksByTitle, true);
        }
    }

    private void searchByGenre(String genre, List<Book> books, Scanner scanner) {
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                booksByGenre.add(book);
            }
        }
        if (booksByGenre.size() == 0) {
            System.out.println("No books found by genre : " + genre);
        } else {
            System.out.println(booksByGenre.size() + " Books found by genre : " + genre);
            for (Book bookByGenre : booksByGenre) {
                System.out.println(bookByGenre.getTitle());
            }
            //boolean wantToIssueBook = true;
            chooseBook(scanner, booksByGenre, true);
        }
    }

    private void chooseBook(Scanner scanner, List<Book> books, boolean wantToIssueBook) {
        if (!wantToIssueBook) {
            return;
        }

        System.out.println("Do you want to issue a book, press 'Y' or 'N' ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("N")) {
            wantToIssueBook = false;
        }
        if (wantToIssueBook) {
            issueBookToMember(this.memberId, this.booksIssued, books);
        } else if (!wantToIssueBook) {
            System.out.println("Sorry to see you go, happy searching !!");
        } else {
            System.out.println("Invalid choice provided please try again. ");
        }

        searchBook();
    }


    private void issueBookToMember(String memberId, int numOfBooksIssued, List<Book> books) {
        boolean bookFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book name you want :");
        String bookTitle = sc.nextLine();

            for(Book book : books) {
                if(bookTitle.equalsIgnoreCase(book.getTitle())) {
                    bookFound = true;
                    int remainingCopies = Math.max(book.getCopies() - 1, 0);
                    if(remainingCopies == 0) {
                        System.out.println("Oops !! " + book.getTitle() + " is currently not available. We regret the inconvenience ");
                        return;
                    }
                    this.booksIssued = numOfBooksIssued + 1;
                    this.booksIssuedToMember.add(book);
                    book.setCopies(remainingCopies);
                    System.out.printf("Congratulations, %s memberId %s book %s has been issued to you. ", this.name, memberId, book.getTitle());
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if (!bookFound) {
                System.out.println("Wrong name entered, please try again !!");
            }

    }


    public String getName() {
        return name;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void getBooksIssuedToMember() {
        int count=1;
        for(Book book : booksIssuedToMember) {
            System.out.printf("%d %s", count, book.getTitle());
            count++;
        }
    }
}
