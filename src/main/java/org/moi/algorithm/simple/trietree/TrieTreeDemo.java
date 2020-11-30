package org.moi.algorithm.simple.trietree;

/**
 * @program:
 * @description: 前缀树
 * @author: moi
 * @create: 2020/11/30 21:54
 **/
public class TrieTreeDemo {

    /**
     * 前缀树的每个节点的结构
     */
    public static  class Node{
        //该节点被通过了多少次
        int pass;
        //该节点是多少个字符串的结尾
        int end;
        //该节点下面的后续节点
        Node[] next;
        public Node(){
            pass = 0;
            end = 0;
            //26个字符
            next = new Node[26];
        }
    }

    public static  class TrieTree{
        Node root = new Node();


        /**
         * 插入字符串到前缀树
         * @param word
         */
        public void insert(String word){
            if(word == null){
                return;
            }
            Node node = root;
            node.pass++;
            char[] chars = word.toCharArray();
            for(int i = 0;i<chars.length;i++){
                int index = chars[i]-'a';
                if(node.next[index] == null){
                    node.next[index] = new Node();
                }
                node = node.next[index];
                node.pass++;
            }
            node.end++;
        }

        /**
         * 查询前缀树中是否存在该字符
         * @param word
         * @return
         */
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            int index = 0;
            for(int i = 0;i<chars.length;i++){
                index = chars[i]-'a';
                if(node.next[index] == null){
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }


        /**
         * 删除前缀树中的字符
         * @param word
         */
        public void delete(String word){
            if(search(word) ==0){
                return;
            }
            char[] chars = word.toCharArray();
            Node node =  root;
            int index = 0;
            for(int i = 0; i < chars.length;i++){
                index = chars[i]-'a';
                if(--node.next[index].pass == 0){
                    node.next[index] = null;
                    return ;
                }
                node = node.next[index];
            }
            node.end--;

        }


        /**
         * 前缀树中有多少个树是以word字符串为开头的字符串数量
         * @param word
         * @return
         */
        public int prefixNumber(String word){
            if(word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            int index = 0;
            for(int i = 0;i<chars.length;i++){
                index = chars[i] - 'a';
                if(node.next[index] == null){
                    return 0;
                }
                node = node.next[index];
            }
            return node.pass;
        }
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    public static void main(String[] args) {


    }



}
