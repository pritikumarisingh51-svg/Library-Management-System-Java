public class Book {
    private String title;
    private String author;
    private boolean issued;

    public Book(String title, String author, boolean issued) {
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issue() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public String getData() {
        return title + "," + author + "," + issued;
    }

    public String toString() {
        return title + " | " + author + " | " + (issued ? "Issued" : "Available");
    }
}