import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Map<String, Integer> variables = new HashMap<>();

    public static int calc(String str) throws Exception {
        Pattern pattern = Pattern.compile("\\s*[\\s\\+-]+\\s*\\w+");
        Matcher matcher = pattern.matcher("+" + str);
        int result = 0;
        int end = -1;

        while (matcher.find()) {
            String sub = matcher.group();
            int plus = 1;
            end = matcher.end();
            String subNum = null;

            for (int i = 0; i < sub.length(); i++) {
                char idx = sub.charAt(i);
                if (idx == ' ') continue;
                else if (idx == '+') plus *= 1;
                else if (idx == '-') plus *= -1;
                else {
                    subNum = sub.substring(i);
                    break;
                }
            }

            if (variables.containsKey(subNum)) {
                result = plus == 1 ? result + variables.get(subNum) : result - variables.get(subNum);
                continue;
            } else {
                try {
                    result = plus == 1 ? result + Integer.parseInt(subNum) : result - Integer.parseInt(subNum);
                } catch (Exception e) {
                    throw new InvalidObjectException("Unknown variable");
                }
            }
        }

        if (end != str.length() + 1) {
            throw new Exception();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        while (true) {
            String ip = scanner.nextLine();
            ip = ip.strip();

            if (ip.startsWith("&#39;")) {
                ip = ip.substring(5).strip();
            } else if (ip.startsWith("&gt;")) {
                ip = ip.substring(4).strip();
            }

            if (ip.length() == 0){
                continue;
            }
            else if (ip.equals("/help")) {
                System.out.println("This calculator supports the addition + and subtraction - operators.\n" +
                        "It supports both unary and binary minus operators. If you enter several operators following each other, this calculator still still works.\n" +
                        "For example: 2 -- 2 equals 2 - (-2) equals 2 + 2.)");
                continue;
            } else if (ip.equals("/exit")) {
                System.out.println("Bye!");
                break;
            } else if (ip.charAt(0) == '/') {
                System.out.println("Unknown command");
            } else if (ip.contains("=")) {
                String[] pieces = ip.split("=");

                if (pieces.length > 2) {
                    System.out.println("Invalid expression");
                    continue;
                }

                for (int i = 0; i < pieces.length; i++) {
                    pieces[i] = pieces[i].strip();
                }

                if (!pieces[0].matches("[a-zA-Z]+")) {
                    System.out.println("Invalid identifier");
                    continue;
                }

                try {
                    String key = pieces[0];
                    int val = calc(pieces[1]);
                    variables.put(key, val);
                } catch (InvalidObjectException e) {
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println("Invalid expression");
                }
            } else {
                try {
                    System.out.println(calc(ip));
                } catch (InvalidObjectException e) {
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println("Invalid expression");
                }
            }
        }

    }
}
