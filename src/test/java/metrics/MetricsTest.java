package metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.teamconect.models.ChatMessage;
import com.teamconect.models.Departamento;
import com.teamconect.models.Rol;
import com.teamconect.models.Task;
import com.teamconect.models.User;

public class MetricsTest {

    private final Class<?>[] classesToTest = {
            User.class, Task.class, ChatMessage.class, Departamento.class, Rol.class
    };

    @Test
    public void testMetrics() {
        FanInFanOutMetric fanInFanOutMetric = new FanInFanOutMetric();
        CodeLengthMetric codeLengthMetric = new CodeLengthMetric();
        CyclomaticComplexityMetric cyclomaticComplexityMetric = new CyclomaticComplexityMetric();
        IdentifierLengthMetric identifierLengthMetric = new IdentifierLengthMetric();
        ConditionalNestingDepthMetric conditionalNestingDepthMetric = new ConditionalNestingDepthMetric();
        FogIndexMetric fogIndexMetric = new FogIndexMetric();

        List<Integer> fanInList = new ArrayList<>();
        List<Integer> fanOutList = new ArrayList<>();
        List<Integer> codeLengthList = new ArrayList<>();
        List<Integer> cyclomaticComplexityList = new ArrayList<>();
        List<Double> identifierLengthList = new ArrayList<>();
        List<Integer> nestingDepthList = new ArrayList<>();
        List<Double> fogIndexList = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(new FileWriter("metrics_summary.txt"))) {
            writer.println("=== Resumen de Métricas para Todas las Clases ===");

            for (Class<?> clazz : classesToTest) {
                int fanIn = fanInFanOutMetric.calculateFanIn(clazz);
                int fanOut = fanInFanOutMetric.calculateFanOut(clazz);
                int codeLength = codeLengthMetric.calculateCodeLength(clazz);
                int cyclomaticComplexity = cyclomaticComplexityMetric.calculateCyclomaticComplexity(clazz);
                double identifierLength = identifierLengthMetric.calculateAverageIdentifierLength(clazz);
                int nestingDepth = conditionalNestingDepthMetric.calculateMaxNestingDepth(clazz);
                double fogIndex = fogIndexMetric.calculateFogIndex(clazz);

                // Añadir a las listas para cálculo de promedios
                fanInList.add(fanIn);
                fanOutList.add(fanOut);
                codeLengthList.add(codeLength);
                cyclomaticComplexityList.add(cyclomaticComplexity);
                identifierLengthList.add(identifierLength);
                nestingDepthList.add(nestingDepth);
                fogIndexList.add(fogIndex);

                // Guardar resultados individuales en el archivo
                writer.println("\nResultados para " + clazz.getSimpleName() + ":");
                writer.printf("  Fan-In: %d\n", fanIn);
                writer.printf("  Fan-Out: %d\n", fanOut);
                writer.printf("  Longitud de código: %d\n", codeLength);
                writer.printf("  Complejidad ciclomatica: %d\n", cyclomaticComplexity);
                writer.printf("  Longitud de identificadores: %.2f\n", identifierLength);
                writer.printf("  Profundidad de anidado condicional: %d\n", nestingDepth);
                writer.printf("  Índice Fog: %.2f\n", fogIndex);

                // Conclusiones individuales
                if (codeLength > 200) writer.printf("Conclusión: La clase %s tiene una longitud de código alta. Considera dividir en métodos más pequeños.\n", clazz.getSimpleName());
                if (cyclomaticComplexity > 10) writer.printf("Conclusión: La clase %s tiene alta complejidad. Considera simplificar la lógica.\n", clazz.getSimpleName());
                if (nestingDepth > 3) writer.printf("Conclusión: La clase %s tiene anidado condicional profundo, revisa su lógica.\n", clazz.getSimpleName());
                if (fogIndex > 50) writer.printf("Conclusión: La clase %s podría ser difícil de entender. Revisa el uso de términos complejos.\n", clazz.getSimpleName());
            }

            // Cálculo de promedios
            double avgFanIn = fanInList.stream().mapToInt(Integer::intValue).average().orElse(0);
            double avgFanOut = fanOutList.stream().mapToInt(Integer::intValue).average().orElse(0);
            double avgCodeLength = codeLengthList.stream().mapToInt(Integer::intValue).average().orElse(0);
            double avgCyclomaticComplexity = cyclomaticComplexityList.stream().mapToInt(Integer::intValue).average().orElse(0);
            double avgIdentifierLength = identifierLengthList.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            double avgNestingDepth = nestingDepthList.stream().mapToInt(Integer::intValue).average().orElse(0);
            double avgFogIndex = fogIndexList.stream().mapToDouble(Double::doubleValue).average().orElse(0);

            // Guardar resultados promedio en el archivo
            writer.println("\n=== Promedio de Métricas para el Proyecto ===");
            writer.printf("  Fan-In Promedio: %.2f\n", avgFanIn);
            writer.printf("  Fan-Out Promedio: %.2f\n", avgFanOut);
            writer.printf("  Longitud de Código Promedio: %.2f\n", avgCodeLength);
            writer.printf("  Complejidad Ciclomatica Promedio: %.2f\n", avgCyclomaticComplexity);
            writer.printf("  Longitud de Identificadores Promedio: %.2f\n", avgIdentifierLength);
            writer.printf("  Profundidad de Anidado Promedio: %.2f\n", avgNestingDepth);
            writer.printf("  Índice Fog Promedio: %.2f\n", avgFogIndex);

            writer.println("\n=== Conclusión General del Proyecto ===");
            if (avgCodeLength > 200) writer.println("Conclusión: El proyecto tiene una longitud de código alta en promedio. Considera dividir en métodos más pequeños.");
            if (avgCyclomaticComplexity > 10) writer.println("Conclusión: El proyecto presenta alta complejidad en promedio. Considera simplificar la lógica.");
            if (avgNestingDepth > 3) writer.println("Conclusión: El proyecto tiene un anidado condicional profundo en promedio, revisa la lógica.");
            if (avgFogIndex > 50) writer.println("Conclusión: El proyecto podría ser difícil de entender en promedio. Revisa el uso de términos complejos.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
