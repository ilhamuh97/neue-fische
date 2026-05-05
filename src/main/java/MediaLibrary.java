import java.util.ArrayList;

public interface MediaLibrary {
    void add(String item);
    void remove(String item);
    ArrayList<String> getAll();
}
