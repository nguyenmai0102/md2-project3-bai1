package ra.business.design;

import ra.business.entity.Catalog;

import java.util.List;

public interface ICatalog<T, E> extends Ishop<T, E> {

    List<T> sort();

    List<T> findByName(E e);

    boolean changStatus(T t);


}
