package ra.business.design;

import ra.business.entity.User;

import java.util.List;

public abstract interface Iuser<T, E> extends Ishop<T, E>{
    void displayData();

    void sort();
    boolean changStatus(T t);
    boolean changePermision(T t);


}

