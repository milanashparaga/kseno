import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Reader {

    private final int rId;
    private final String name;
    private final Map<String, Book> takenBooks;

    public Reader(String name) {
        this.name = name;
        this.rId = ThreadLocalRandom.current().nextInt(1000);
        this.takenBooks = new HashMap<>();
    }

    public int getrId() {
        return rId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getTakenBooks() {
        return new ArrayList<>(takenBooks.values());
    }

    public void takeBook(Book book) {
        this.takenBooks.putIfAbsent(book.getName(), book);
    }

    @Override
    public String toString() {
        return name;
    }
}

