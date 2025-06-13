import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EstudianteMain {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = List.of(
                new Estudiante("Ana", "Ingeniería", 8.7),
                new Estudiante("Luis", "Medicina", 7.5),
                new Estudiante("Pedro", "Ingeniería", 6.9),
                new Estudiante("Lucía", "Derecho", 9.1),
                new Estudiante("Carla", "Medicina", 8.0),
                new Estudiante("Mario", "Ingeniería", 9.4),
                new Estudiante("Sofía", "Derecho", 7.8));

        // Obtener una lista de nombres de estudiantes con promedio mayor a 8.0
        System.out.println("lista de nombres de estudiantes con promedio mayor a 8.0");
        List<Estudiante> destacados = estudiantes.stream()
                .filter(e -> e.getPromedio() > 8.0)
                .collect(Collectors.toList());
        destacados.forEach(e -> System.out.println(e.getNombre() + " " + e.getCarrera() + " " + e.getPromedio()));

        // Crear un Map<Carrera, Promedio general> por carrera
        System.out.println("Carrera, Promedio general");
        Map<String, Double> promedioPorCarrera = estudiantes.stream()
                .collect(Collectors.groupingBy(
                        Estudiante::getCarrera,
                        Collectors.averagingDouble(Estudiante::getPromedio)));

        promedioPorCarrera
                .forEach((carrera, promedio) -> System.out.println("Carrera: " + carrera + " | Promedio: " + promedio));

        // Obtener un Set de carreras únicas:
        System.out.println("set de carreras únicas");
        Set<String> carreras = estudiantes.stream()
                .map(Estudiante::getCarrera)
                .collect(Collectors.toSet());

        carreras.forEach(System.out::println);

        // Buscar a un estudiante con promedio mayor a 9.0 usando Optional
        System.out.println("Buscar a un estudiante con promedio mayor a 9.0 usando Optional");
        Optional<Estudiante> topEstudiante = estudiantes.stream()
                .filter(e -> e.getPromedio() > 9.0)
                .findFirst();

        topEstudiante.ifPresent(e -> System.out.println("Top estudiante: " + e.getNombre()));

    }
}
