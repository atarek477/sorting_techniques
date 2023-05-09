import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Sorter<Integer>> sorters = new ArrayList<>();
        sorters.add(new BubbleSort<>());
        sorters.add(new HeapSort<>());
        sorters.add(new InsertionSort<>());
        sorters.add(new SelectionSort<>());
        sorters.add(new QuickSort<>());
        sorters.add(new MergeSort<>());

        int noOfTests = args.length > 0 ? Integer.parseInt(args[0]) : 50;
        int[] lengthsOfTests = args.length <= 1 ? new int[]{5} :
                Arrays.stream(Arrays.copyOfRange(args, 1, args.length)).mapToInt(Integer::parseInt).toArray();

        List<List<List<Integer>>> allTests = new ArrayList<>();
        for (int lengthsOfTest : lengthsOfTests) {
            List<List<Integer>> tests = new ArrayList<>(noOfTests);
            for (int i = 0; i < noOfTests; i++)
                tests.add(generateTest(lengthsOfTest));
            allTests.add(tests);
        }

        for (List<List<Integer>> tests : allTests) {
            for (Sorter<Integer> sorter : sorters) {
                double time = 0;
                for (List<Integer> test : tests) {
                    List<Integer> copy = new ArrayList<>(test);
                    copy.sort(Comparator.comparingInt(i -> i));
                    sorter.setList(test);
                    long start = System.nanoTime();
                    sorter.sort();
                    time += System.nanoTime() - start;
                    List<Integer> result = sorter.getList();
                    assert result.size() == test.size();
                    for (int i = 0; i < test.size(); i++) {
                        try {
                            assert (result.get(i).equals(copy.get(i)));
                        } catch (AssertionError e) {
                            System.out.println("Sorter: " + sorter.getClass().getName());
                            System.out.println("test: " + test);
                            System.out.println("expected: " + copy);
                            System.out.println("result: " + result);
                            throw e;
                        }
                    }
                }

                System.out.println(sorter.getClass().getName() + " averaged " +
                        (time / 1000 / tests.size()) + " microseconds per test over " +
                        noOfTests + " tests of length " + tests.get(0).size());
            }
        }

        System.out.println("All tests passed!");
    }

    public static List<Integer> generateTest(int length) {
        Random r = new Random();
        List<Integer> out = new ArrayList<>(length);
        for (int i = 0; i < length; i++) out.add(r.nextInt(100000));
        return out;
    }
}
