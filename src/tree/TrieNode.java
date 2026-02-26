package tree;

public class TrieNode {
    private final TrieNode[] children;
    private boolean isEnd;

    public TrieNode(int size) {
        children = new TrieNode[size]; // 大小自定义，支持数字和字母
        isEnd = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public boolean containsKey(int ch) {
        return children[ch] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public TrieNode get(int ch) {
        return children[ch];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void put(int ch, TrieNode node) {
        children[ch] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}