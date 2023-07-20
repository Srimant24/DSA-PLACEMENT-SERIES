package DSA.STACK;

public class NSTACKSINANARRAY {
    static int[] arr;
    static int[] top;
    static int[] next;
    static int n,s;
    static int freespot;
    NSTACKSINANARRAY(int n,int s){
        this.n=n;
        this.s=s;
        arr=new int[s];
        top=new int[n];
        next=new int[s];
        for (int i=0;i<n;i++){
            top[i]=-1;
        }
        for (int i=0;i<n;i++){
            next[i]=i+1;
        }
        next[s-1]=-1;
        freespot=0;
    }
    public static boolean push(int x,int m){
        if (freespot==-1){
            return false;
        }
        int index=freespot;
        freespot=next[index];
        arr[index]=x;
        next[index]=top[m-1];
        top[m-1]=index;
        return true;
    }
    public static int pop(int m){
        if (top[m-1]==-1){
            return -1;
        }
        int index=top[m-1];
         top[m-1]=next[index];
         int x=arr[index];
         next[index]=freespot;
         freespot=index;
         return x;
    }
}
