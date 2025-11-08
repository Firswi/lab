package lab3;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    public static class Book {
        public String title;
        public String author;
        public String genre;
        public int year;
        public String publisher;
        public int quantity;

        public Book(String title, String author, String genre, int year, String publisher, int quantity) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.year = year;
            this.publisher = publisher;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return title + " by " + author + " (" + year + ", " + publisher + ", " + genre + ") - Available: " + quantity;
        }
    }

    public static class Visitor {
        public String name;
        public String cardNumber;

        public Visitor(String name, String cardNumber) {
            this.name = name;
            this.cardNumber = cardNumber;
        }

        @Override
        public String toString() {
            return name + " (Card: " + cardNumber + ")";
        }
    }

    private static List<Book> books = new ArrayList<>();
    private static List<Visitor> visitors = new ArrayList<>();
    private static Map<String, List<Book>> issuedBooks = new HashMap<>(); // Key - cardNumber

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public static boolean issueBook(String cardNumber, String bookTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(bookTitle) && book.quantity > 0) {
                book.quantity--;
                issuedBooks.putIfAbsent(cardNumber, new ArrayList<>());
                issuedBooks.get(cardNumber).add(book);
                return true;
            }
        }
        return false;
    }

    public static boolean returnBook(String cardNumber, String bookTitle) {
        List<Book> userBooks = issuedBooks.get(cardNumber);
        if (userBooks != null) {
            for (Book book : userBooks) {
                if (book.title.equalsIgnoreCase(bookTitle)) {
                    book.quantity++;
                    userBooks.remove(book);
                    if (userBooks.isEmpty()) {
                        issuedBooks.remove(cardNumber);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(b -> b.title.toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(b -> b.author.toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(b -> b.genre.equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public static List<Book> sortByYear() {
        return books.stream()
                .sorted(Comparator.comparingInt(b -> b.year))
                .collect(Collectors.toList());
    }

    public static List<Book> sortByAuthor() {
        return books.stream()
                .sorted(Comparator.comparing(b -> b.author))
                .collect(Collectors.toList());
    }

    public static void showBooks() {
        books.forEach(System.out::println);
    }

    public static void showVisitors() {
        visitors.forEach(System.out::println);
    }

    public static void showIssuedBooks() {
        issuedBooks.forEach((card, bookList) -> {
            System.out.println("Visitor Card: " + card);
            bookList.forEach(System.out::println);
        });
    }


}

