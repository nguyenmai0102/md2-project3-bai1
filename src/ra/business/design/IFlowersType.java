package ra.business.design;

import java.util.List;
import java.util.Scanner;

public abstract interface IFlowersType<T, E> extends Ishop<T, E>{


    void findById(E e);


    List<T> sort();

    boolean changeStatus(E e);

}
