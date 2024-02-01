package main.java.myapp.persistence;
import main.java.myapp.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//package main.java.myapp.persistence;





public class BookManager {
    private static BookManager instance;
    private List<Book> books;
    private static final String FILENAME = "books.csv";

    private BookManager() {
        books = new ArrayList<>();
        loadBooks();
    }

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void saveBooks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Book book : books) {
                writer.println(book.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            // File does not exist or empty, do nothing
        }
    }
}
