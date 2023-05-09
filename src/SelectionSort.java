import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort<T extends Comparable<T>> extends Sorter<T>{
    public SelectionSort(List<T> list) {
        super(list);
    }

    public SelectionSort() {
        super();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        SelectionSort<Integer> sorter = new SelectionSort<>(test);
        sorter.setList(test);
        sorter.sort();
        System.out.println(sorter.getList());
    }

    public void sort() {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(minIndex).compareTo(list.get(j)) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i,list.get(minIndex));
                list.set(minIndex,temp);

            }
        }
    }
}
