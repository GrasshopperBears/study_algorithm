import leetLibrary.NestedInteger;
import java.util.*;

public class Leet339 {
    private int getSum(NestedInteger nestedInteger, int depth) {
        int sum = 0;

        if (nestedInteger.isInteger()) {
            sum += depth * nestedInteger.getInteger();
        } else {
            for (NestedInteger insideNestedInteger : nestedInteger.getList())
                sum += getSum(insideNestedInteger, depth + 1);
        }
        return sum;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;

        for (NestedInteger nestedInteger : nestedList)
            sum += getSum(nestedInteger, 1);

        return sum;
    }
}
