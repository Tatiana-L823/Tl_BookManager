import main.java.myapp.model.Book;
import main.java.myapp.persistence.BookManager;

import java.util.Scanner;

public class Main {

    // Scanner-Objekt für Benutzereingaben initialisieren
    private static final Scanner scanner = new Scanner(System.in);

    // Instanz des BookManagers erstellen
    private static final BookManager bookManager = BookManager.getInstance();

    public static void main(String[] args) {
        // Boolean-Variable zum Verfolgen des Anwendungsstatus
        boolean running = true;
        // Hauptschleife der Anwendung
        while (running) {
            System.out.println("Willkommen zur Bücherverwaltungsanwendung!");
            System.out.println("1. Bücher anzeigen");
            System.out.println("2. Buch hinzufügen");
            System.out.println("3. Anwendung beenden");
            System.out.print("Wählen Sie eine Option: ");
            // Benutzereingabe einlesen
            int choice = scanner.nextInt();
            scanner.nextLine(); // Leere den Scanner-Puffer

// Entscheidungsstruktur basierend auf Benutzereingabe
            switch (choice) {
                case 1:
                    displayBooks(); // Methode zum Anzeigen der Bücher aufrufen
                    break;
                case 2:
                    addBook(); // Methode zum Hinzufügen eines Buches aufrufen
                    break;
                case 3:
                    running = false; // Anwendung beenden
                    System.out.println("Vielen Dank für die Nutzung der Anwendung. Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }

    // Methode zum Anzeigen der Liste von Büchern
    private static void displayBooks() {
        System.out.println("Bücherliste:");
        for (Book book : bookManager.getBooks()) {
            System.out.println(book);
        }
    }

    // Methode zum Hinzufügen eines neuen Buches
    private static void addBook() {
        System.out.println("Neues Buch hinzufügen:");
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Gelesen (true/false): ");
        boolean read = scanner.nextBoolean();
        scanner.nextLine(); // Leere den Scanner-Puffer

        Book newBook = new Book(title, author, genre, read); // Neues Buchobjekt erstellen
        bookManager.addBook(newBook); // Neues Buch zur Liste hinzufügen

        // Liste in CSV-Datei aktualisieren
        bookManager.saveBooks();
        System.out.println("Das Buch wurde erfolgreich hinzugefügt und die Bücherliste wurde aktualisiert!");
    }

}
