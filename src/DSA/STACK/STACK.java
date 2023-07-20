package DSA.STACK;
//IMPLEMENT
public  class STACK {
   static int[] arr;
   static int top;
    static int size;
    STACK(int size){
        this.size=size;
        arr=new int[size];
        top=-1;
    }
   public static void push(int el){
        if (top== arr.length-1){
            System.out.println("stack is overflowinng");
        }
        top++;
        arr[top]=el;
    }
    public static void pop(){
        if (top==-1){
            System.out.println("stack is underflowinng");
        }
        int x=arr[top];
        System.out.println(x);
        top--;
    }
    public static int peek(){
        if (top==-1){
            System.out.println("stack is underflowinng");
        }
       return arr[top];
    }
    public static boolean isempty(){
        if (top==-1){
            return true;
        }
        return false;
    }
    public static void print(){
        if (top!=-1){
            for (int i=top;i>=0;i--){
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        STACK stack=new STACK(5);
        stack.push(23);
        stack.push(45);
        stack.push(40);
        stack.push(10);
        stack.push(15);
        int x=stack.peek();
        System.out.println(x);
        stack.pop();
        System.out.println(stack.isempty());
        stack.print();
    }
}
