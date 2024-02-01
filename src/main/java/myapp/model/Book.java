package main.java.myapp.model;

    public class Book {
        private String title;
        private String author;
        private String genre;
        private boolean read;

        public Book(String title, String author, String genre, boolean read) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.read = read;
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

        public boolean isRead() {
            return read;
        }

        public String toCSV() {
            return title + "," + author + "," + genre + "," + read;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre='" + genre + '\'' +
                    ", read=" + read +
                    '}';
        }
    }


