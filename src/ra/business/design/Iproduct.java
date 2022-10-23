package ra.business.design;

import java.util.List;

public interface Iproduct<T, E> extends Ishop<T, E>{
    List<T> sort();
    boolean changeStatus(T t);

}
