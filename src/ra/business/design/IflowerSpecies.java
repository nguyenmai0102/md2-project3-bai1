package ra.business.design;

import java.util.List;
import java.util.Scanner;

public interface IflowerSpecies<T, E> extends Ishop<T, E> {
    boolean changStatus(T t);
    List<T> findByName(E e);
}
