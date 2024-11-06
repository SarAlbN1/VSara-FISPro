package metrics;

import java.lang.reflect.Method;

public class CodeLengthMetric {

    public int calculateCodeLength(Class<?> clazz) {
        int length = 0;
        // Suma la cantidad de líneas por método (simulación)
        for (Method method : clazz.getDeclaredMethods()) {
            length += method.toString().length();
        }
        return length;
    }
}
