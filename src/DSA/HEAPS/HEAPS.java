package DSA.HEAPS;

public class HEAPS {
   /* HEAPS(){
       heap[0]=-1;
       size=0;
    }

    /*int[] heap=new int[100];
     int size;
    public void insert(int val){
        size=size+1;
        int index=size;
        heap[index]=val;
        while (index>1){
            int parent=index/2;
            if (heap[index]>heap[parent]){
                swap(heap,parent,index);
                index=parent;
            }else{
                return;
            }
        }
    }
    public void print(){
        for (int i=1;i<=size;i++){
            System.out.println(heap[i]+" ");
        }
    }*/
    public void swap(int[] arr,int num1,int num2){
        int temp=arr[num1];
        arr[num1]=arr[num2];
        arr[num2]=temp;
    }
   /* public void delete(){
        if (size==0){
            return;
        }
        heap[1]=heap[size];
        size--;
        int i=1;
        while (i<size) {
            int left = 2 * i;
            int right = 2 * i + 1;
            if (left < size && heap[left] > heap[i]) {
                swap(heap,i, left);
                i = left;
            }
            if (right < size && heap[right] > heap[i]) {
                swap(heap,i, right);
                i = right;
            } else {
                return;
            }

        }
    }*/
    public void heapify(int[] arr,int n,int i){
        int largest=i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left<=n&&arr[largest]<arr[left]){
            largest=left;
        }if (right<=n&&arr[largest]<arr[right]){
            largest=right;
        }
        if (largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }


    public static void main(String[] args) {
        HEAPS heap = new HEAPS();
       /* heap.insert(20);
        heap.insert(78);
        heap.insert(50);
        heap.insert(30);
        heap.insert(90);
        heap.insert(10);
        heap.print();*/
        int[] nums = {-1, 23, 54, 12, 34, 43};
        int n = 5;
        for (int i = n / 2; i > 0; i--) {
            heap.heapify(nums, n, i);
        }
        for (int j=1;j<=n;j++){
            System.out.println(nums[j]);
        }
    }
}
