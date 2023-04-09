import java.util.Date;

public class Book {

    private String title;
    private String author;
    private String genre;
    private Date publicationDate;
    private long uid;
    private int copies;

    public Book(String title, String author, String genre, Date publicationDate, long uid, int copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.uid = uid;
        this.copies = copies;
    }

    public static Book createBook(String title, String author, String genre, Date publicationDate, long uid, int copies) {
        return new Book(title,author,genre,publicationDate,uid,copies);
    }

    public long getUid() {
        return uid;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }



}
