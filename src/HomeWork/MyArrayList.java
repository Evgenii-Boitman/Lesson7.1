package HomeWork;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class MyArrayList<T> implements MyList<T> {

    public static void main(String[] args) {
        MyList<String> arrayList = new MyArrayList<>();
        //arrayList.add("A");
        //arrayList.add("B");
        //arrayList.add("C");
        //arrayList.add("D");
        //arrayList.add("E");
        //arrayList.add("F");
        //arrayList.add("G");
        //arrayList.add("H");

        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains("var1"));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList);
        System.out.println(arrayList.addAll(Collections.singleton("var1")));
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.indexOf("obj"));
        System.out.println(arrayList.lastIndexOf("A"));
        System.out.println(arrayList.remove("var1"));
        System.out.println(arrayList.removeAll(Collections.singleton("col")));
        System.out.println(arrayList.remove(5));
        System.out.println(arrayList.set(1, "obj"));
    }

    private T[] values;
    private int size;
    private int capacity = 0;
    private final int CAPACITY = 8;
    // public MyArrayList() {
    //    values = (T[]) new Object[0];
    //}

    public MyArrayList() {
        capacity = CAPACITY;
        values = (T[]) new Object[capacity];
    }

    public MyArrayList(MyList<? extends T> col) {

    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        values = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public boolean contains(Object var1) {
        return indexOf(var1) >= 0;
    }

    @Override
    public boolean add(T var1) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = var1;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Object var1) {
        if ((values.length == 0)) {
            return false;
        }
        int i;
        for (i = 0; i < values.length; i++) {
            if (values[i] == null && var1 == null) {
                break;
            }
            if ((values[i] != null) && (values[i].equals(var1))) {
                break;
            }
        }
        if (i < values.length) {
            shiftToLeft(i);
            return true;
        }
        return false;
    }

    private void shiftToLeft(int i) {
    }

    @Override
    public boolean addAll(Collection<? extends T> var1) {
        boolean modified = false;
        for (T t : var1) if (add(t)) modified = true;
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> col) {
        if (col == null) {
            return false;
        }
        if ((col.size() == 0) || (values.length == 0)) {
            return false;
        }
        boolean modyfied = false;
        int i = 0;
        while (i < values.length) {
            if (col.contains(values[i])) {
                shiftToLeft(i);
                modyfied = true;
            } else {
                i++;
            }
        }
        return modyfied;
    }

    @Override
    public void add(int index, T obj) {

    }

    @Override
    public boolean addAll(int index, MyList<? extends T> col) {

        return false;
    }

    @Override
    public T get(int index) {

        return values[index];
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < values.length; i++) {
            if (obj.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int lastIndex = -1;
        if (obj == null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] == null) {
                    lastIndex = i;
                }
            }
            return lastIndex;
        } else {
            for (int i = 0; i < values.length; i++) {
                if (obj.equals(values[i])) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    @Override
    public T remove(int index) {
        Object obj = null;
        if ((index < values.length) && (index >= 0)) {
            obj = get(index);
            shiftToLeft(index);
        }
        return (T) obj;
    }

    @Override
    public T set(int index, T obj) {
        if ((index < values.length) && (index >= 0)) {
            T j = values[index];
            values[index] = obj;
            return j;
        }
        return null;
    }

    @Override
    public void sort(Comparator<? super T> comp) {

    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
