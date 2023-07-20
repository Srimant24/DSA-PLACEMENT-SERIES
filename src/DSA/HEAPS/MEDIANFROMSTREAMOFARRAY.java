package DSA.HEAPS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class MEDIANFROMSTREAMOFARRAY {
    MEDIANFROMSTREAMOFARRAY(){

    }
    static int compare(int a,int b){
        if (a>b){
            return 1;
        }
        if (b<a){
            return -1;
        }
        return 0;
    }
    public void med(int element, PriorityQueue<Integer> maxHeap,PriorityQueue<Integer> minHeap,int median){
        switch (compare(maxHeap.size(), minHeap.size())){
            case 0:
                if (element>median){
                    minHeap.offer(element);
                    median= minHeap.peek();
                }
                else {
                    maxHeap.offer(element);
                    median=maxHeap.peek();
                }
                break;
            case 1:
                if (element>median){
                    minHeap.offer(element);
                    median= maxHeap.size()+ minHeap.size()/2;
                }
                else {
                    minHeap.offer(maxHeap.peek());
                    maxHeap.poll();
                    maxHeap.offer(element);
                    median= maxHeap.peek()+ minHeap.peek()/2;
                }
                break;
            case -1:
                if (element>median){
                    maxHeap.offer(maxHeap.peek());
                    minHeap.poll();
                    maxHeap.offer(element);
                    median= maxHeap.peek()+ minHeap.peek()/2;
                }
                else {
                   maxHeap.offer(element);
                   median= maxHeap.peek()+ minHeap.peek()/2;
                }
                break;
            }
        }
        public Vector<Integer> findmedian(int[] arr){
             Vector<Integer>ans=new Vector<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            int median=0;
            for (int i=0;i< arr.length;i++){
                med(arr[i],maxHeap,minHeap,median);
                ans.add(median);
            }
            return ans;
        }
    }
