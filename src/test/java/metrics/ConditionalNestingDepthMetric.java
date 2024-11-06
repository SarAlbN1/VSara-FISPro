package metrics;

import java.lang.reflect.Method;

public class ConditionalNestingDepthMetric {

    public int calculateMaxNestingDepth(Class<?> clazz) {
        int maxDepth = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            int depth = method.getParameterCount(); // Suponiendo que el número de parámetros simula la profundidad
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        return maxDepth;
    }
}
