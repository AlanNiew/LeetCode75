package prefix.tree;

/**
 * @author Niu
 * @date 2026-05-09
 */
public class Problem70_Lt208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("orange");
        trie.search("app");
        trie.search("apple");
        trie.startsWith("ora");
    }

    static class Trie {
        //字典树节点
        class TrieNode{
            private TrieNode [] next = new TrieNode[26];
            private boolean isEnd;
            public void setIsEnd(boolean isEnd){
                this.isEnd = isEnd;
            }
        }

        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new TrieNode();
                }
                node = node.next[idx];
            }
            node.setIsEnd(true);
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    return false;
                }
                node = node.next[idx];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    return false;
                }
                node = node.next[idx];
            }
            return true;
        }
    }
}
