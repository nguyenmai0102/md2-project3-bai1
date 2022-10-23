package ra.business.design;

import java.util.List;

public abstract interface Iuser<T, E> extends Ishop<T, E>{
    List<T> sort();
    boolean changStatus(T t);
    boolean changPermision(T t);
    List<T> findByName(E e);

}

