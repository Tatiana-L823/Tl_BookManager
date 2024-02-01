import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookManager bookManager = BookManager.getInstance();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Willkommen zur Bücherverwaltungsanwendung!");
            System.out.println("1. Bücher anzeigen");
            System.out.println("2. Buch hinzufügen");
            System.out.println("3. Anwendung beenden");
            System.out.print("Wählen Sie eine Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Leere den Scanner-Puffer

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    running = false;
                    System.out.println("Vielen Dank für die Nutzung der Anwendung. Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }

    private static void displayBooks() {
        System.out.println("Bücherliste:");
        for (Book book : bookManager.getBooks()) {
            System.out.println(book);
        }
    }

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

        Book newBook1 = new Book("Sherlock Holmes", "Conan Doyle", "Detective stories", true);
        bookManager.addBook(newBook);

        Book newBook2 = new Book("Thinking, Fast and Slow", "Daniel Kahneman", "populärwissenschaftliches Buch", false);
        bookManager.addBook(newBook);

        Book newBook3 = new Book("Unschuldsengel vom Broadway", "O. Henry", "Kurzgeschichten", true);
        bookManager.addBook(newBook);

        Book newBook4 = new Book("Harry Potter and the Order of the Phoenix", "J.K.Rowling", "Fantasy", false);
        bookManager.addBook(newBook);


        // Liste in CSV-Datei aktualisieren
        bookManager.saveBooks();
        System.out.println("Das Buch wurde erfolgreich hinzugefügt und die Bücherliste wurde aktualisiert!");
    }
}
