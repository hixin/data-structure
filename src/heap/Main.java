package heap;

import java.util.*;

public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

//        int n = 1000000;
//
//        Random random = new Random();
//        Integer[] testData = new Integer[n];
//        for(int i = 0 ; i < n ; i ++)
//            testData[i] = random.nextInt(Integer.MAX_VALUE);
//
//        double time1 = testHeap(testData, false);
//        System.out.println("Without heapify: " + time1 + " s");
//
//        double time2 = testHeap(testData, true);
//        System.out.println("With heapify: " + time2 + " s");


        int n = 10000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];

        for(int i = 0 ; i < n ; i ++)
           testData[i] = random.nextInt(Integer.MAX_VALUE);


        double time1 = top1(testData, 100);
        System.out.println("top: " + time1 + " s");
        System.out.println("------");
        double time2 = top2(testData, 100);
        System.out.println("top2: " + time2 + " s");
        System.out.println("------");
        double time3 = top3(testData, 100);
        System.out.println("top3: " + time3 + " s");
    }

    // 构建m个元素最小堆, 依次比较替换
    private static double top1(Integer[] data, int m) {

        long startTime = System.nanoTime();
        int len = data.length;
        Integer[] arr = new Integer[m];
        for (int i = 0; i < m; i++) {
            arr[i] = data[i];
        }

        MinHeap<Integer> minHeap = new MinHeap<>(arr);

        for (int j = m; j < len; j++) {
            if (data[j] > minHeap.findMin()) {
                minHeap.replace(data[j]);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            res.add(minHeap.extractMin());
        }

        for (int i = 0; i < m; i++) {
            System.out.println(res.removeLast());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    // 构建完整最大堆
    private static double top2(Integer[] data, int m) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap = new MaxHeap<>(data);
        for (int i = 0; i < m; i++) {
            System.out.println(maxHeap.extractMax());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    // 使用Java 优先队列, 默认是一个最小堆
    private static double top3(Integer[] data, int m) {
        long startTime = System.nanoTime();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int len = data.length;
        for (int i = 0; i < len; i++) {
            if (pq.size() < m) {
                pq.add(data[i]);
            } else if (data[i] > pq.peek()) {
                pq.remove();
                pq.add(data[i]);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            res.addFirst(pq.remove());
        }

        for (int i = 0; i < m; i++) {
            System.out.println(res.remove());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}
