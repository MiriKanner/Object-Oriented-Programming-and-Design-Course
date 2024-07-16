/// Aspect Oriented Programming for measuring execution time and number of invocations of sorting algorithms

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class SortingTimeAspect {
    private long totalStartTime;
    private long totalEndTime;
    private int totalInvocations;
    private long quickSortTime;
    private int quickSortInvocations;
    private long bubbleSortTime;
    private int bubbleSortInvocations;
    private long insertionSortTime;
    private int insertionSortInvocations;
    private long mergeSortTime;
    private int mergeSortInvocations;
    private long randomAlgorithm1Time;
    private int randomAlgorithm1Invocations;
    private long randomAlgorithm2Time;
    private int randomAlgorithm2Invocations;

    @Before("execution(void SortingAlgorithm.sort(..))")
    public void beforeSorting(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
    }
    @After("execution(void SortingAlgorithm.sort(..))")
    public void afterSorting(ProceedingJoinPoint joinPoint) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Function sort in " + joinPoint.getTarget().getClass().getSimpleName() + " took " + duration + " ms");
        totalInvocations++;
        if (joinPoint.getTarget() instanceof QuickSort) {
            quickSortInvocations++;
            quickSortTime += duration;
        } else if (joinPoint.getTarget() instanceof BubbleSort) {
            bubbleSortInvocations++;
            bubbleSortTime += duration;
        } else if (joinPoint.getTarget() instanceof InsertionSort) {
            insertionSortInvocations++;
            insertionSortTime += duration;
        } else if (joinPoint.getTarget() instanceof MergeSort) {
            mergeSortInvocations++;
            mergeSortTime += duration;
        } else if (joinPoint.getTarget().getClass().getSimpleName().equals("randomAlgorithm1")) {
            randomAlgorithm1Invocations++;
            randomAlgorithm1Time += duration;
        } else if (joinPoint.getTarget().getClass().getSimpleName().equals("randomAlgorithm2")) {
            randomAlgorithm2Invocations++;
            randomAlgorithm2Time += duration;
        }
    }
    @After("execution(void AlgorithmRunner.runAlgorithms())")
    public void afterSorting(ProceedingJoinPoint joinPoint) {
        totalEndTime = System.currentTimeMillis();
        long totalDuration = totalEndTime - totalStartTime;
        System.out.println("Total time of running all sort functions was " + totalDuration + " ms");
        System.out.println("In detail:");
        System.out.println("Function sort in QuickSort ran " + quickSortInvocations + " times and took in total " + quickSortTime + " ms");
        System.out.println("Function sort in BubbleSort ran " + bubbleSortInvocations + " times and took in total " + bubbleSortTime + " ms");
        System.out.println("Function sort in InsertionSort ran " + insertionSortInvocations + " times and took in total " + insertionSortTime + " ms");
        System.out.println("Function sort in MergeSort ran " + mergeSortInvocations + " times and took in total " + mergeSortTime + " ms");
        System.out.println("Function sort in randomAlgorithm1 ran " + randomAlgorithm1Invocations + " times and took in total " + randomAlgorithm1Time + " ms");
        System.out.println("Function sort in randomAlgorithm2 ran " + randomAlgorithm2Invocations + " times and took in total " + randomAlgorithm2Time + " ms");
    }
}