import java.util.HashMap;
import java.util.Map;

class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        t.insert("app");
        System.out.println(t.search("app"));
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode t = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!t.chs.containsKey(word.charAt(i))) {
                t.chs.put(word.charAt(i), new TrieNode());
            }
            t=t.chs.get(word.charAt(i));
        }
        t.isEnd=true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode t = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (t == null) return false;
            if (!t.chs.containsKey(word.charAt(i))) return false;
            if (i == word.length() - 1 && t.chs.get(word.charAt(i)).isEnd) return true;
            t = t.chs.get(word.charAt(i));
        }
        if (t != null && t.chs.size() > 0) return false;
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode t = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (t == null) return false;
            if (!t.chs.containsKey(prefix.charAt(i))) return false;
            t = t.chs.get(prefix.charAt(i));
        }
        return true;
    }
}

class TrieNode {
    public Map<Character, TrieNode> chs;
    public boolean isEnd=false;

    public TrieNode() {
        chs = new HashMap<>();
    }
}
