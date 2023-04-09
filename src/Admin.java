import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Admin {

    public static void main(String[] args) {
        Library library = new Library(new ArrayList<>(), new ArrayList<>());
        try {
            Date publishedDate = Utils.getDate("12-10-2011");
            Book book = Book.createBook("how to code in java","some guy", "IT",publishedDate,12,3);
            library.addBooksToLibrary(book);
            publishedDate = Utils.getDate("02-4-2021");
            book = Book.createBook("monk who sold ferrari","kipling xyz", "Fiction",publishedDate,13,0);
            library.addBooksToLibrary(book);
            publishedDate = Utils.getDate("26-2-2001");
            book = Book.createBook("Atomic habits","Tom holland", "Misc",publishedDate,14,1);
            library.addBooksToLibrary(book);
            publishedDate = Utils.getDate("12-10-2016");
            book = Book.createBook("Apache kafka","Xyz", "IT",publishedDate,12,4);
            library.addBooksToLibrary(book);
            publishedDate = Utils.getDate("22-03-2010");
            book = Book.createBook("Cindrella","ZORO", "Fiction",publishedDate,12,3);
            library.addBooksToLibrary(book);
            publishedDate = Utils.getDate("19-07-2009");
            book = Book.createBook("Cat exam","sanjai singh", "MBA",publishedDate,12,2);
            library.addBooksToLibrary(book);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Register a member.
        String uid = UUID.randomUUID().toString();
        LibraryMember member = new LibraryMember("Aditya",uid);
        library.addMembersToLibrary(member);
        uid = UUID.randomUUID().toString();
        member = new LibraryMember("Poonam",uid);
        library.addMembersToLibrary(member);
        int booksIssued = member.getBooksIssued();
        if(booksIssued<10) {
            member.searchBook();
        } else {
            System.out.printf("Hi %s, you already have 10 books issues , pls return books to issues more", member.getName());
        }



    }

}
