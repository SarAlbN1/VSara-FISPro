package metrics;

import java.lang.reflect.Method;

public class FanInFanOutMetric {

    public int calculateFanIn(Class<?> clazz) {
        int fanIn = 0;
        // Lógica simplificada para calcular el fan-in: cantidad de métodos que llaman a métodos de esta clase
        for (Method method : clazz.getDeclaredMethods()) {
            // Suponemos que cada método llamado representa un fan-in
            fanIn += method.getParameterCount();
        }
        return fanIn;
    }

    public int calculateFanOut(Class<?> clazz) {
        int fanOut = 0;
        // Lógica simplificada para calcular el fan-out: cantidad de métodos llamados desde esta clase
        for (Method method : clazz.getDeclaredMethods()) {
            fanOut += method.getReturnType() != void.class ? 1 : 0;
        }
        return fanOut;
    }
}
