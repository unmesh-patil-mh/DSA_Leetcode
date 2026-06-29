class Solution {

    static class Node {
        Node[] next = new Node[26];
        Node fail, last;
        int count;
    }

    public int numOfStrings(String[] patterns, String word) {

        Node root = new Node();

        // Build Trie
        for (String p : patterns) {
            Node cur = root;
            for (int i = 0, len = p.length(); i < len; i++) {
                int idx = p.charAt(i) - 'a';
                if (cur.next[idx] == null)
                    cur.next[idx] = new Node();
                cur = cur.next[idx];
            }
            cur.count++;
        }

        Node[] queue = new Node[10005];
        int head = 0, tail = 0;

        root.fail = root;

        for (int i = 0; i < 26; i++) {
            if (root.next[i] == null) {
                root.next[i] = root;
            } else {
                Node child = root.next[i];
                child.fail = root;
                queue[tail++] = child;
            }
        }

        while (head < tail) {
            Node cur = queue[head++];

            for (int i = 0; i < 26; i++) {
                Node child = cur.next[i];

                if (child == null) {
                    cur.next[i] = cur.fail.next[i];
                    continue;
                }

                Node f = cur.fail.next[i];
                child.fail = f;
                child.last = (f.count > 0) ? f : f.last;
                queue[tail++] = child;
            }
        }

        int ans = 0;
        Node cur = root;

        for (int i = 0, len = word.length(); i < len; i++) {
            cur = cur.next[word.charAt(i) - 'a'];

            for (Node t = cur; t != null; t = t.last) {
                ans += t.count;
                t.count = 0;
            }
        }

        return ans;
    }
}