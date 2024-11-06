package metrics;

import java.lang.reflect.Method;

public class CyclomaticComplexityMetric {

    public int calculateCyclomaticComplexity(Class<?> clazz) {
        int complexity = 1; // Complejidad ciclomática mínima es 1
        for (Method method : clazz.getDeclaredMethods()) {
            complexity += method.getParameterCount();
        }
        return complexity;
    }
}
