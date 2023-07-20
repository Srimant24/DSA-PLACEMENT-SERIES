package DSA.HEAPS;

import java.util.Vector;

public class MERGETWOMAXHEAP {
    MERGETWOMAXHEAP(){

    }
    public void swap(Vector<Integer>ans, int num1, int num2) {
        int a=ans.get(num1);
        int b=ans.get(num2);
        int temp = a;
        a = b;
        b = temp;
    }
    public void heapify(Vector<Integer>ans, int n, int i) {
        int largest = i;
        int left = 2 * i+1;
        int right = 2 * i + 2;

        if (left < n && ans.get(left) > ans.get(largest)) {
            largest = left;
        }
        if (right < n && ans.get(right) > ans.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(ans, largest, i);
            heapify(ans, n, largest);
        }
    }
    public Vector merge(Vector<Integer>v1,Vector<Integer>v2){
        Vector<Integer>ans=new Vector<>();
        for (int i=0;i<v1.size();i++){
            ans.add(v1.get(i));
        }
        for (int i=0;i<v1.size();i++){
            ans.add(v2.get(i));
        }
        for (int i = ans.size() / 2-1; i >=0; i--) {
            heapify(ans, ans.size(), i);
        }
        return ans;
    }
}
