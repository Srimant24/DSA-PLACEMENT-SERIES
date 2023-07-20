package DSA.TRIE;

import java.util.Vector;

public class PHONEDIRECTORY {
    PHONEDIRECTORY(){

    }
    class trinode2{
        char data;
       trinode2[] alphabets = new trinode2[26];
        boolean isterminal;
        trinode2(char data){
            this.data=data;
            for (int i=0;i<26;i++){
                alphabets[i]=null;
            }
            isterminal=false;
        }
    }
    public trinode2 root;
    void insert(String word){

        insertit(root,word);
    }

    public void insertit(trinode2 root, String word) {
        if (word.length()==0){
            root.isterminal=true;
            return;
        }
        int index =word.charAt(0)-'A';
        trinode2 node;
        if (root.alphabets[index]!=null){
            node=root.alphabets[index];
        }
        else {
            node=new trinode2(word.charAt(0));
            root.alphabets[index]=node;
        }
        insertit(root,word.substring(1));
    }
    public Vector<Vector<String>> directory(Vector<String>list,String str){
        for(int i=0;i<list.size();i++){
            insert(list.get(i));
        }
        return getsuggestion(str);
    }

     public Vector<Vector<String>> getsuggestion(String str) {
        trinode2 prv=root;
        Vector<Vector<String>>output=new Vector<>();
        String prefix=" ";
        for (int i=0;i<str.length();i++){
            char last=str.charAt(i);
            prefix+=str.charAt(i);
            trinode2 curr=prv.alphabets[last-'a'];
            if (curr==null){
                break;
            }
            Vector<String>temp=new Vector<>();
            pringtsuggestion(curr,temp,prefix);
            output.add(temp);
            prv=curr;
        }
        return output;
    }

    public void pringtsuggestion(trinode2 curr, Vector<String> temp, String prefix) {
        if (curr.isterminal){
          temp.add(prefix);
        }
        for (char ch='a';ch<='z';ch++){
            trinode2 next=curr.alphabets[ch-'a'];
            if (next!=null){
                prefix+=ch;
                pringtsuggestion(next,temp,prefix);
                prefix.substring(0,prefix.length()-1);
            }
        }
    }
}
