import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort<T extends Comparable<T>> extends Sorter<T> {
    public InsertionSort(List<T> list) {
        super(list);
    }

    public InsertionSort() {
        super();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        InsertionSort<Integer> sorter = new InsertionSort<>(test);
        sorter.setList(test);
        sorter.sort();
        System.out.println(sorter.getList());
    }

    @Override
    public void sort() {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) swap(j, j + 1);
            }
        }
    }
}
