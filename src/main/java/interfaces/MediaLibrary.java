package interfaces;

import java.util.ArrayList;

public interface MediaLibrary {
    void add(String item);
    void remove(String item);
    void showList();
    ArrayList<String> getAll();
}
