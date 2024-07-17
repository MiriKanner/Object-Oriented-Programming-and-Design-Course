
package sortingClean;

import jakarta.inject.Inject;

import java.util.Random;

public class AlgorithmRunner {

    @Inject
    @squareAlgoritm
    private SortingAlgorithm<Integer> quadraticAlgorithm;
    @Inject
    @nlognAlgoritm
    private SortingAlgorithm<Integer> nlognAlgorithm;
    @Inject
    @randAlgoritm
    private SortingAlgorithm<Integer> randomAlgorithm1;
    @Inject
    @randAlgoritm
    private  SortingAlgorithm<Integer> randomAlgorithm2;
    @Inject
    @rundNumber
    private int numberOfElements;

    @sumAll
    public void runAlgorithms() {
        Random rand = new Random();
        Integer[] ints = rand.ints(1, Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm1.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm2.sort(intsClone);
    }
}
