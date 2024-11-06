package metrics;

import java.lang.reflect.Method;

public class IdentifierLengthMetric {

    public double calculateAverageIdentifierLength(Class<?> clazz) {
        int totalLength = 0;
        int count = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            totalLength += method.getName().length();
            count++;
        }
        return count == 0 ? 0 : (double) totalLength / count;
    }
}
