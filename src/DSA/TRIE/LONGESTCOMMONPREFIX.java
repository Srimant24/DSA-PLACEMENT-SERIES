package DSA.TRIE;

import java.util.Vector;

public class LONGESTCOMMONPREFIX {
    LONGESTCOMMONPREFIX(){

    }
    class trinode1{
        char data;
        trinode1[] alphabets = new trinode1[26];
        boolean isterminal;
        int childcount;
        trinode1(char data){
            this.data=data;
            for (int i=0;i<26;i++){
                alphabets[i]=null;
            }
            childcount=0;
            isterminal=false;
        }
    }
    public trinode1 root;
    public String commonprefix(String[] arr,int n){
        String prefix="";
        for(int i=0;i<arr[0].length();i++){
            boolean match=true;
            for (int j=1;j<n;j++) {
                if (arr[j].length() < i || arr[j].charAt(i) != arr[0].charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match==false){
                    break;
                }else {
                    prefix+=arr[0].charAt(i);
                }
           }
        return prefix;
    }
     public String prefix(String[] arr,int n){
        for (int i=0;i<n;i++){
            insertit(root,arr[i]);
        }
        String str=arr[0];
        String ans=" ";
        lcs(str,ans);
        return ans;
     }

    public void lcs(String str, String ans) {
        for (int i=0;i<str.length();i++){
            if (root.childcount==1){
                ans+=str.charAt(i);
                int index=str.charAt(i)-'a';
                root=root.alphabets[index];
            }
            else {
                break;
            }
            if (root.isterminal){
                break;
            }
        }
    }

    public void insertit(trinode1 root, String word) {
        if (word.length()==0){
            root.isterminal=true;
            return;
        }
        int index =word.charAt(0)-'A';
        trinode1 node;
        if (root.alphabets[index]!=null){
            node=root.alphabets[index];
        }
        else {
            node=new trinode1(word.charAt(0));
            root.childcount++;
            root.alphabets[index]=node;
        }
        insertit(root,word.substring(1));
    }
}
