package lab3;

public class lab3Main {
        public static void main(String[] args) {

            Library.addBook(new Library.Book("1984", "George Orwell", "Dystopia", 1949, "Secker & Warburg", 3));
            Library.addBook(new Library.Book("Brave New World", "Aldous Huxley", "Dystopia", 1932, "Chatto & Windus", 2));
            Library.addBook(new Library.Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937, "Allen & Unwin", 5));
            Library.addBook(new Library.Book("Fahrenheit 451", "Ray Bradbury", "Dystopia", 1953, "Ballantine Books", 4));


            Library.addVisitor(new Library.Visitor("Alice", "123"));
            Library.addVisitor(new Library.Visitor("Bob", "456"));

            Library.issueBook("123", "1984");
            Library.issueBook("456", "Brave New World");
            Library.issueBook("123", "The Hobbit");

            System.out.println("=== Все книги в библиотеке ===");
            Library.showBooks();

            System.out.println("\n=== Выданные книги ===");
            Library.showIssuedBooks();

            System.out.println("\n=== Поиск книг по автору 'Orwell' ===");
            Library.searchByAuthor("Orwell").forEach(System.out::println);

            System.out.println("\n=== Поиск книг по жанру 'Dystopia' ===");
            Library.searchByGenre("Dystopia").forEach(System.out::println);

            System.out.println("\n=== Книги, отсортированные по году выпуска ===");
            Library.sortByYear().forEach(System.out::println);

            Library.returnBook("123", "1984");
            System.out.println("\n=== Выданные книги после возврата '1984' ===");
            Library.showIssuedBooks();
        }


}
