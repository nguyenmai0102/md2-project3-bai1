package ra.business.design;

import java.util.List;
import java.util.Scanner;

public interface Ishop<T, E> {
    boolean create(T t);
    boolean upDate(T t);
    List<T> findAll();
    T inputData (Scanner sc);
    void displayData();
    List<T> readFromFile();
    boolean writeToFile(List<T> list);
}
