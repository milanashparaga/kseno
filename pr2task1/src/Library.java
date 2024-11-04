import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private final Map<String, Book> catalogBook;
    private final Map<Integer, Reader> readers;

    public Library() {
        this.catalogBook = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Book getBook(String name) {
        return this.catalogBook.remove(name);
    }

    public void addToCatalog(Book book) {
        this.catalogBook.putIfAbsent(book.getName(), book);
    }

    public void addReader(Reader reader) {
        this.readers.putIfAbsent(reader.getrId(), reader);
    }

    public List<Book> getCatalog() {
        return new ArrayList<>(this.catalogBook.values());
    }

    public List<Reader> getReaders() {
        return new ArrayList<>(this.readers.values());
    }

    @Override
    public String toString() {
        return "Library{" +
                "catalogBook=" + catalogBook +
                ", readers=" + readers +
                '}';
    }
}
