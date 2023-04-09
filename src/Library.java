import java.util.List;

public class Library {

    List<Book> bookList;
    List<LibraryMember> members;

    public Library(List<Book> bookList, List<LibraryMember> members) {
        this.bookList = bookList;
        this.members = members;
    }
    protected void addBooksToLibrary(Book book) {
        this.bookList.add(book);
    }
    protected void addMembersToLibrary(LibraryMember libraryMember) {
        members.add(libraryMember);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    // Gets all the members of library.
    public List<LibraryMember> getMembers() {
        return members;
    }
}
