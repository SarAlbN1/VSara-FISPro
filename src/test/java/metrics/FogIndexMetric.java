package metrics;

import java.lang.reflect.Method;

public class FogIndexMetric {

    public double calculateFogIndex(Class<?> clazz) {
        int wordCount = 0;
        int complexWords = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            int length = method.getName().length();
            wordCount++;
            if (length > 5) {
                complexWords++;
            }
        }
        return wordCount == 0 ? 0 : (double) complexWords / wordCount * 100;
    }
}
