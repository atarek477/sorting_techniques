import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeapSort<T extends Comparable<T>> extends Sorter<T> {
    public HeapSort(List<T> list) {
        super(list);
    }

    public HeapSort() {
        super();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        HeapSort<Integer> sorter = new HeapSort<>(test);
        sorter.setList(test);
        sorter.sort();
        System.out.println(sorter.getList());
    }

    @Override
    public void sort() {
        if (list.size() == 0) return;
        buildHeap();
        List<T> sorted = new ArrayList<>(list.size());
        while (list.size() > 0) sorted.add(pop());
        list = sorted;
    }

    private void buildHeap() {
        for (int i = list.size() / 2; i >= 0; i--)
            heapify(i);
    }

    private void heapify(int i) {
        int smallest = i;

        if (leftChild(i) < list.size() && list.get(leftChild(i)).compareTo(list.get(smallest)) < 0)
            smallest = leftChild(i);
        if (rightChild(i) < list.size() && list.get(rightChild(i)).compareTo(list.get(smallest)) < 0)
            smallest = rightChild(i);

        swap(i, smallest);
        if (smallest != i) heapify(smallest);
    }

    private T pop() {
        if (list.size() == 0) throw new ArrayIndexOutOfBoundsException();
        if (list.size() == 1) return list.remove(0);
        swap(0, list.size() - 1);
        T out = list.remove(list.size() - 1);
        heapify(0);
        return out;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }
}
