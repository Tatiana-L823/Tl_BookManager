package main.java.myapp.model;

//Die Book-Klasse repräsentiert ein Buchobjekt mit Titel, Autor, Genre und einem Lesestatus.
    public class Book {
        private String title;
        private String author;
        private String genre;
        private boolean read;

    //Konstruktor für die Erstellung eines neuen Buchobjekts.
        public Book(String title, String author, String genre, boolean read) {
            this.title = title; //Der Titel des Buches.
            this.author = author; //Der Autor des Buches.
            this.genre = genre; //Das Genre des Buches.
            this.read = read; //Der Lesestatus des Buches (true, wenn das Buch gelesen wurde, sonst false).
        }

    //Gibt den Titel des Buches zurück.
        public String getTitle() {
            return title;
        }

    //Gibt den Autor des Buches zurück.
        public String getAuthor() {
            return author;
        }

    //Gibt das Genre des Buches zurück.
        public String getGenre() {
            return genre;
        }

    //Gibt den Lesestatus des Buches zurück.
        public boolean isRead() {
            return read;
        } //return true, wenn das Buch gelesen wurde, sonst false.


    //Gibt eine CSV-Darstellung des Buches zurück (Titel, Autor, Genre, Lesestatus).
        public String toCSV() {
            return title + "," + author + "," + genre + "," + read;
        } //return Die CSV-Darstellung des Buches.

        @Override //Gibt eine String-Repräsentation des Buchobjekts zurück.
        public String toString() {
            //Eine String-Repräsentation des Buchobjekts.
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre='" + genre + '\'' +
                    ", read=" + read +
                    '}';
        }
    }


