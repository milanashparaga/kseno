
import java.util.Random;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String[] bookNames = new String[]{
                "All you need is kill", "Made in Abyss",
                "Spy x Family", "Jujutsu Kaisen", "Chainsaw Man",
                "1984", "Джейн Эйр", "Унесённые ветром",
                "Три товарища", "Библия"
        };

        String[] names = new String[]{
                "Митя", "Роман", "Митрофан", "Никита", "Артём"
        };

        Library library = new Library();
        Random random = new Random();

        for (String bookName : bookNames) {
            library.addToCatalog(new Book(bookName));
        }

        for (String name : names) {
            Reader reader = new Reader(name);
            library.addReader(reader);
        }

        for (Reader reader : library.getReaders()) {
            int numberOfBooksToTake = random.nextInt(3) + 1; // Случайное количество книг от 1 до 3
            for (int i = 0; i < numberOfBooksToTake; i++) {
                Book book = library.getBook(getRandomBookName(library));
                if (book != null) {
                    reader.takeBook(book);
                }
            }
        }

        System.out.println("Текущее количество книг в библиотеке: " + library.getCatalog().size());
        System.out.println("Названия книг в библиотеке: " + library.getCatalog());
        System.out.println("Текущее количество читателей: " + library.getReaders().size());
        System.out.println("Имена читателей: " + library.getReaders());
        System.out.println("Общее количество книг у читателей: " + getTotalBooksTaken(library.getReaders()));
    }

    private static String getRandomBookName(Library library) {
        Random random = new Random();
        int index = random.nextInt(library.getCatalog().size());
        return library.getCatalog().get(index).getName();
    }

    private static int getTotalBooksTaken(List<Reader> readers) {
        int total = 0;
        for (Reader reader : readers) {
            total += reader.getTakenBooks().size();
        }
        return total;
    }
}
