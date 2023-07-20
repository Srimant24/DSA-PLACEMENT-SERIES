package DSA.BINARYTREE;

public class SUMOFNODESOFMAXLENGHT {
    SUMOFNODESOFMAXLENGHT(){

    }
    static class NODE13 {
        int value;
        NODE13 left;
        NODE13 right;

        public NODE13(int value) {

            this.value = value;
        }

    }
    public NODE13 root;
    public int sumofnode(NODE13 node){
        int len=0;
        int maxlen=0;

        int sum=0;
        int maxsum=0;
        sumofnode(node,len,maxlen,sum,maxsum);
        return maxsum;
    }

    public void sumofnode(NODE13 node, int len, int maxlen, int sum, int maxsum) {
        if (node==null){
            if (len>maxlen){
                maxlen=len;
                maxsum=sum;
            }
            if (len==maxlen){
                maxsum=Math.max(sum,maxsum);
            }
            return;
        }
        sum=sum+node.value;
        sumofnode(node.left,len+1,maxlen,sum,maxsum);
        sumofnode(node.right,len+1,maxlen,sum,maxsum);
    }
}
