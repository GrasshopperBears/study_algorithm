import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class HashNode {
    String site, password;
    HashNode next;

    public HashNode(String site, String password) {
        this.site = site;
        this.password = password;
    }

    public String find(String site) {
        if (this.site.equals(site))
            return this.password;
        return this.next.find(site);
    }
}

public class Boj17219 {
    private static long getHash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++)
            hash = ((hash << 5) + hash) + s.charAt(i);

        return hash;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]);
        HashMap<Long, HashNode> passwords = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            long hash = getHash(tokens[0]);
            HashNode hn = new HashNode(tokens[0], tokens[1]);
            if (passwords.containsKey(hash)) {
                hn.next = passwords.get(hash);
                passwords.put(hash, hn);
            } else {
                passwords.put(hash, hn);
            }
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            HashNode hn = passwords.get(getHash(site));
            answer.append(hn.find(site)).append("\n");
        }

        System.out.println(answer.toString());
    }
}
