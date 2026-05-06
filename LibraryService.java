import java.util.*;
import java.io.*;

public class LibraryService {

    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE = "books.txt";

    public LibraryService() {
        load();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author, false));
        save();
    }

    public Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public void issueBook(String title) {
        Book b = findBook(title);
        if (b != null && !b.isIssued()) {
            b.issue();
            save();
        }
    }

    public void returnBook(String title) {
        Book b = findBook(title);
        if (b != null && b.isIssued()) {
            b.returnBook();
            save();
        }
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public void save() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE));
            for (Book b : books) {
                pw.println(b.getData());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving");
        }
    }

    public void load() {
        try {
            File file = new File(FILE);
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                books.add(new Book(
                        data[0],
                        data[1],
                        Boolean.parseBoolean(data[2])
                ));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading");
        }
    }
}
