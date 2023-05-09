import java.util.ArrayList;
import java.util.List;

public abstract class Sorter<T extends Comparable<T>> {
    List<T> list;

    public Sorter(List<T> list) {
        setList(list);
    }

    public Sorter() {
        this.list = null;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    public abstract void sort();

    protected void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
