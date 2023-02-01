package trie;

public class Solution211 {
    private class WordDictionary {
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }

        private static class PrimitiveWrapper<T> {
            public T val;

            public PrimitiveWrapper(T val) {
                this.val = val;
            }
        }

        private TrieNode root;

        public WordDictionary() {

        }

        public void addWord(String word) {
            root = addWord(root, word, 0);
        }

        private TrieNode addWord(TrieNode node, String word, int index) {
            if (node == null) {
                node = new TrieNode();
            }
            if (index == word.length()) {
                node.val = new Object();
            } else {
                char c = word.charAt(index);
                node.children[c - 'a'] = addWord(node.children[c - 'a'], word, index + 1);
            }

            return node;
        }

        public boolean search(String word) {
            if (root == null) {
                return false;
            }
            PrimitiveWrapper<Boolean> resGot = new PrimitiveWrapper<>(false);
            backtracking(root, word, 0, resGot);

            return resGot.val;
        }

        private void backtracking(TrieNode node, String word, int index, PrimitiveWrapper<Boolean> resGot) {
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    TrieNode nextNode = node.children[i];
                    if (nextNode == null) {
                        continue;
                    }
                    if (index + 1 == word.length()) {
                        if(nextNode.val != null) {
                            resGot.val = true;
                            return;
                        }
                    } else {
                        backtracking(nextNode, word, index + 1, resGot);
                        if (resGot.val) {
                            return;
                        }
                    }
                }
            } else {
                TrieNode nextNode = node.children[c - 'a'];
                if (nextNode == null) {
                    return;
                }
                if (index + 1 == word.length()) {
                    if (nextNode.val != null) {
                        resGot.val = true;
                    }
                    return;
                } else {
                    backtracking(nextNode, word, index + 1, resGot);
                    if (resGot.val) {
                        return;
                    }
                }
            }
        }
    }
}


class Solution211_attempt1 {
    private class WordDictionary {
        private static class TrieNode {
            public Object val;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;

        public WordDictionary() {

        }

        public void addWord(String word) {
            root = addWord(root, word, 0);
        }

        private TrieNode addWord(TrieNode node, String word, int index) {
            if (node == null) {
                node = new TrieNode();
            }
            if (index == word.length()) {
                node.val = new Object();
            } else {
                char c = word.charAt(index);
                node.children[c - 'a'] = addWord(node.children[c - 'a'], word, index + 1);
            }

            return node;
        }

        public boolean search(String word) {
            return searchDivide(root, word, 0);
        }

        private boolean searchDivide(TrieNode node, String word, int index){
            if(node == null){
                return false;
            }
            if(index == word.length()){
                if(node.val != null){
                    return true;
                } else {
                    return false;
                }
            }

            char c = word.charAt(index);
            if(c == '.'){
                for(int i = 0; i < 26; i++){
                    if(searchDivide(node.children[i], word, index+1)){
                        return true;
                    }
                }

                return false;
            } else {
                return searchDivide(node.children[c-'a'], word, index+1);
            }
        }
    }
}