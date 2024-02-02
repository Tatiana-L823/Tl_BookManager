package main.java.myapp.persistence;
import main.java.myapp.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//package main.java.myapp.persistence;




//Die BookManager-Klasse verwaltet die Persistenz von Büchern in einer CSV-Datei.
public class BookManager {
    // Singleton-Instanz des BookManagers
    private static BookManager instance;
    private List<Book> books;
    private static final String FILENAME = "books.csv";

    // Privater Konstruktor für Singleton
    private BookManager() {
        // Initialisiert die Bücherliste und lädt vorhandene Bücher aus der CSV-Datei
        books = new ArrayList<>();
        loadBooks();
    }

    //Gibt die Singleton-Instanz des BookManagers zurück.
    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }
    //Fügt ein neues Buch zur Liste hinzu und speichert die Liste in der CSV-Datei.
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    //Gibt die Liste aller Bücher zurück.
    public List<Book> getBooks() {
        return books;
    }

    //Speichert die Bücherliste in der CSV-Datei
    public void saveBooks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Book book : books) {
                writer.println(book.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Lädt Bücher aus der CSV-Datei und fügt sie der Bücherliste hinzu.
    private void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                String genre = parts[2].trim();
                boolean read = Boolean.parseBoolean(parts[3].trim());
                Book book = new Book(title, author, genre, read);
                books.add(book);
            }
        } catch (IOException e) {
            //  Die Datei existiert nicht oder ist leer, daher wird nichts unternommen
        }
    }
}
