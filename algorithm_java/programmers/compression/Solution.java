package programmers.compression;

import java.util.*;

class TrieNode {
    int key;
    TrieNode[] children = new TrieNode[26];

    public TrieNode(int key) {
        this.key = key;
    }
}

class Solution {
    public int[] solution(String msg) {
        TrieNode root = new TrieNode(0);
        ArrayList<Integer> answer = new ArrayList<>();
        int nextKey = 27;

        for (int i = 0; i < 26; i++) {
            TrieNode child = new TrieNode(i + 1);
            root.children[i] = child;
        }

        int index = 0, len = msg.length();
        while (index < len) {
            TrieNode curr = root;
            int end = index, c = 0;

            while (end < len) {
                c = msg.charAt(end) - 'A';
                TrieNode child = curr.children[c];

                if (child != null) {
                    curr = child;
                    end++;
                } else {
                    break;
                }
            }
            answer.add(curr.key);
            curr.children[c] = new TrieNode(nextKey++);
            index = end;
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
            result[i] = answer.get(i);

        return result;
    }
}
