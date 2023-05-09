import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort<T extends Comparable<T>> extends Sorter<T> {
    public MergeSort(List<T> list) {
        super(list);
    }

    public MergeSort() {
        super();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        MergeSort<Integer> sorter = new MergeSort<>(test);
        sorter.setList(test);
        sorter.sort();
        System.out.println(sorter.getList());
    }

    public void sort() {
        performSort(list, 0, list.size() - 1);
    }

    private void performSort(List<T> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            performSort(list, left, mid);
            performSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(List<T> list, int left, int mid, int right) {
        int length = right - left + 1;
        List<T> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            temp.add(null);
        }
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (list.get(i).compareTo(list.get(j)) <= 0) {
                    temp.set(k,list.get(i));
                    k++;i++;
            } else {
                    temp.set(k,list.get(j));
                    k++;j++;
            }
        }

        while (i <= mid) {
            temp.set(k, list.get(i));
            k++;
            i++;
        }

        while (j <= right) {
            temp.set(k, list.get(j));
            k++;
            j++;
        }

        for (i = left, j = 0; i <= right; i++, j++) list.set(i, temp.get(j));
    }
}
