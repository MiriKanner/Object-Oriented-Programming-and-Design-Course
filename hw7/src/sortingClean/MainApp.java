package sortingClean;

import jakarta.enterprise.inject.Produces;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Random;

public class MainApp {
    static WeldContainer container = new Weld().initialize();

    @Produces
    @randAlgoritm
    private SortingAlgorithm<Integer> makeRandomSortingAlgorithm() {
        Random random = new Random(System.currentTimeMillis());
        SortingAlgorithm<Integer> sortAlg = null;
        switch (random.nextInt(4)) {
            case 0:
                sortAlg= container.select(QuickSort.class).get();
                break;
            case 1:
                sortAlg =container.select(MergeSort.class).get();
                break;
            case 2:
                sortAlg = container.select(BubbleSort.class).get();
                break;
            case 3:
                sortAlg =container.select(InsertionSort.class).get();
        }
        return sortAlg;
    }

    public static void main(String[] args) {
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        algorithmRunner.runAlgorithms();
    }


    @Produces
    @rundNumber
    public  int getRandNum() {
        return 10000;
    }
    @Produces
    @nlognAlgoritm
    public  SortingAlgorithm<Integer> quickSort() {
      return  container.select(QuickSort.class).get();
    }
    @Produces
    @squareAlgoritm
    public  SortingAlgorithm<Integer> BubbleSort() {
        return  container.select(BubbleSort.class).get();
    }


}

