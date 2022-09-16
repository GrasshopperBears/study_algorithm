class Secret {
    int forget = 0, start = 0;
}

class Leet2327 {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int MODULO = 1000000007, knowing = 0, pending = 1;
        Secret[] secrets = new Secret[n + 1];
        for (int i = 1; i <= n; i++)
            secrets[i] = new Secret();
        if (1 + delay <= n)
            secrets[1 + delay].start++;
        if (1 + forget <= n)
            secrets[1 + forget].forget++;

        for (int day = 1 + delay; day <= n; day++) {
            knowing = (knowing + secrets[day].start - secrets[day].forget) % MODULO;
            pending = (pending + knowing - secrets[day].start) % MODULO;
            if (knowing < 0)
                knowing += MODULO;
            if (pending < 0)
                pending += MODULO;
            if (day + delay <= n)
                secrets[day + delay].start = (secrets[day + delay].start + knowing) % MODULO;
            if (day + forget <= n)
                secrets[day + forget].forget = (secrets[day + forget].forget + knowing) % MODULO;
        }
        return (knowing + pending) % MODULO;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4)); // 5
        System.out.println(peopleAwareOfSecret(4, 1, 3)); // 6
        System.out.println(peopleAwareOfSecret(684, 18, 496)); // 653668527
    }
}