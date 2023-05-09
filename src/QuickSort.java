import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort<T extends Comparable<T>> extends Sorter<T> {

    public QuickSort(List<T> list) {
        super(list);
    }

    public QuickSort() {
        super();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        QuickSort<Integer> sorter = new QuickSort<>(test);
        sorter.setList(test);
        sorter.sort();
        System.out.println(sorter.getList());
    }

    public void  sort() {
        doSort(list, 0, list.size() - 1);
    }

    private void doSort(List<T> list, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(list, left, right);
            doSort(list, left, pivot - 1);
            doSort(list, pivot, right);
        }
    }


    private int randomPartition(List<T> list, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        T temp = list.get(randomIndex);
        list.set(randomIndex, list.get(right));
        list.set(right, temp);
        return partition(list, left, right);
    }


    private int partition(List<T> list, int left, int right) {
        int mid = (left + right) >>> 1;
        T pivot = list.get(mid);

        while (left <= right) {
            while (less(list.get(left), pivot)) {
                ++left;
            }
            while (less(pivot, list.get(right))) {
                --right;
            }
            if (left <= right) {
                T temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right,temp);
                ++left;
                --right;
            }
        }
        return left;
    }

    private boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
}
