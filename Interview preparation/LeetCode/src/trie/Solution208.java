package trie;

// 208. Implement Trie (Prefix Tree)
public class Solution208 {
    private class Trie {
        private TrieNode root;
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }
        public Trie() {

        }

        public void insert(String word) {
            root = insert(root, word, 0);
        }

        private TrieNode insert(TrieNode node, String word, int i){
            if(node == null){
                node = new TrieNode();
            }
            if(i == word.length()){
                node.val = new Object();
            } else {
                char c = word.charAt(i);
                node.children[c-'a'] = insert(node.children[c-'a'], word, i+1);
            }

            return node;
        }

        public boolean search(String word) {
            TrieNode p = root;
            if(root == null){
                return false;
            }
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                p = p.children[c-'a'];
                if(p == null){
                    return false;
                }
            }

            return (p.val == null) ? false : true;
        }



        public boolean startsWith(String prefix) {
            TrieNode p = root;
            if(root == null){
                return false;
            }
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                p = p.children[c-'a'];
                if(p == null){
                    return false;
                }
            }

            if(p.val != null){
                return true;
            }
            for(int i = 0; i < 26; i++){
                if(p.children[i] != null) {
                    return true;
                }
            }

            return false;
        }
    }
}
