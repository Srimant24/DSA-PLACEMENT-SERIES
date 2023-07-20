package DSA.TRIE;

public class IMPLEMENTTRIE {
    IMPLEMENTTRIE(){

    }
    class trinode{
        char data;
        trinode[] alphabets = new trinode[26];
        boolean isterminal;
        trinode(char data){
            this.data=data;
            for (int i=0;i<26;i++){
                alphabets[i]=null;
            }
            isterminal=false;
        }
    }
    public trinode root;
    void insert(String word){
        insertit(root,word);
    }

    public void insertit(trinode root, String word) {
        if (word.length()==0){
            root.isterminal=true;
            return;
        }
        int index =word.charAt(0)-'A';
        trinode node;
        if (root.alphabets[index]!=null){
            node=root.alphabets[index];
        }
        else {
            node=new trinode(word.charAt(0));
            root.alphabets[index]=node;
        }
        insertit(root,word.substring(1));
    }
    public boolean search(String word){
        return searchit(root,word);
    }

    public boolean searchit(trinode root, String word) {
        if (word.length()==0){
           return root.isterminal;
        }
        int index =word.charAt(0)-'A';
        trinode node;
        if (root.alphabets[index]!=null){
            node=root.alphabets[index];
        }
        else {
           return false;
        }
        return searchit(root,word.substring(1));
    }
    public void delete(String word){
        if (search(word)){
            int index=word.charAt(word.length()-1)-'A';
            trinode node=root.alphabets[index];
            node.isterminal=false;
        }
    }
    public boolean start(String pre){
       return startswith(root,pre);
    }

    public boolean startswith(trinode root, String word) {
        if (word.length()==0){
            return true;
        }
        int index =word.charAt(0)-'A';
        trinode node;
        if (root.alphabets[index]!=null){
            node=root.alphabets[index];
        }
        else {
           return false;
        }
        return startswith(root,word.substring(1));
    }
}
