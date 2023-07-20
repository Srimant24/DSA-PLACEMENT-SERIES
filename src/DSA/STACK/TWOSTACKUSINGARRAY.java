package DSA.STACK;

public class TWOSTACKUSINGARRAY {
    static int[] arr;
    static int top1;
    static int top2;
    static int size;
    TWOSTACKUSINGARRAY(int size){
        this.size=size;
        arr=new int[size];
        top1=-1;
        top2=size;
    }
    static void push(int el){
        if (top2-top1>1){
            top1++;
            arr[top1]=el;
        }
        System.out.println("stack is overflowing");
    }
   static void push2(int el){
       if (top2-top1>1){
           top2--;
           arr[top2]=el;
       }
       System.out.println("stack is overflowing");
   }
   static int pop1(){
        if (top1>-1){
            int x= arr[top1];
            top1--;
            return x;

        }else {
            System.out.println("stack is un derflowing");
            return -1;
        }
   }
   static int pop2(){
       if (top2<size){
           int x= arr[top2];
           top2++;
           return x;

       }else {
           System.out.println("stack is un derflowing");
           return -1;
       }
   }
}
