package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import sortingClean.BubbleSort;
//import sortingClean.InsertionSort;
//import sortingClean.MergeSort;
//import sortingClean.QuickSort;

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
    private  long startTime;

    @Before("execution(void SortingAlgorithm.sort(..))")
    public void beforeMeasureSortingTime() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(void SortingAlgorithm.sort(..))")
    public void afterMeasureSortingTime(JoinPoint joinPoint) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        totalInvocations++;
        switch (joinPoint.getTarget().getClass().getSimpleName()) {
            case "QuickSort":
                quickSortInvocations++;
                quickSortTime += duration;
                break;
            case "BubbleSort":
                bubbleSortInvocations++;
                bubbleSortTime += duration;
                break;
            case "InsertionSort":
                insertionSortInvocations++;
                insertionSortTime += duration;
                break;
            case "MergeSort":
                mergeSortInvocations++;
                mergeSortTime += duration;
                break;
            case "randomAlgorithm1":
                randomAlgorithm1Invocations++;
                randomAlgorithm1Time += duration;
                break;
            case "randomAlgorithm2":
                randomAlgorithm2Invocations++;
                randomAlgorithm2Time += duration;
                break;
            default:
                // Handle default case
                break;
        }
    }
    @Before("execution(void AlgorithmRunner.runAlgorithms())")
    public void beforeMeasureTotalTime() {
        totalStartTime = System.currentTimeMillis();
    }

    @After("execution(void AlgorithmRunner.runAlgorithms())")
    public void afterMeasureTotalTime() {
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