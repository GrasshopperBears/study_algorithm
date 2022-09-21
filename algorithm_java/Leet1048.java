import java.util.Arrays;
import java.util.HashMap;

public class Leet1048 {
    public int longestStrChain(String[] words) {
        int longest = 0;
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int currLongest = 1;
            for (int j = 0; j < word.length(); j++) {
                StringBuilder tmp = new StringBuilder(word);
                tmp.delete(j, j + 1);
                String deleted = tmp.toString();
                currLongest = Math.max(currLongest, map.getOrDefault(deleted, 0) + 1);
            }
            map.put(word, currLongest);
            longest = Math.max(longest, currLongest);
        }
        return longest;
    }
}
