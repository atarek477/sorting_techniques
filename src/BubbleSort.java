import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort<T extends Comparable<T>> extends Sorter<T> {
    public BubbleSort(List<T> list) {
        super(list);
    }

    public BubbleSort() {
        super();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        BubbleSort<Integer> sorter = new BubbleSort<>(test);
        sorter.sort();
        System.out.println(sorter.getList());
    }

    @Override
    public void sort() {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean done = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    swap(j, j + 1);
                    done = false;
                }
            }
            if (done) break;
        }
    }
}
