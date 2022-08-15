package HomeWork;

import java.util.Collection;
import java.util.Comparator;

public interface MyList<T> {
    int size();

    boolean isEmpty();

    boolean contains(Object var1);

    boolean add(T var1);

    boolean remove(Object var1);

    boolean addAll(Collection<? extends T> var1);

    boolean removeAll(Collection<?> col);

    void add(int index, T obj);

    boolean addAll(int index, MyList<? extends T> col);

    T get(int index);

    int indexOf(Object obj);

    int lastIndexOf(Object obj);

    T remove(int index);

    T set(int index, T obj);

    void sort(Comparator<? super T> comp);



}


