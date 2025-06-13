
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author yenyhernandezsantiago
 */
public class Mavenproject1 {

        public static void main(String[] args) {
                List<Auto> listaAutos = Arrays.asList(
                                new Auto("Volkswagen", "Amarok", 25000),
                                new Auto("Volkswagen", "Taos", 32000),
                                new Auto("Chevrolet", "Onix", 22000),
                                new Auto("Chevrolet", "Tracker", 30000),
                                new Auto("Fiat", "Cronos", 21000),
                                new Auto("Fiat", "Pulse", 24000),
                                new Auto("Toyota", "Corolla", 28000),
                                new Auto("Toyota", "Yaris", 23000),
                                new Auto("Renault", "Stepway", 20000),
                                new Auto("Renault", "Duster", 27000),
                                new Auto("Nissan", "Versa", 25000));

                // 1. Ordenar por precio de menor a mayor
                System.out.println("Ordenado por precio de menor a mayor mediante sorted");
                List<Auto> autosOrdenados = listaAutos.stream()
                                .sorted(Comparator.comparingInt(Auto::getPrecio))
                                .collect(Collectors.toList());

                autosOrdenados.forEach(
                                a -> System.out.println(a.getMarca() + " " + a.getModelo() + " - $" + a.getPrecio()));

                // 1. Ordenar por precio de menor a mayor mediante sort
                System.out.println("Ordenado por precio de menor a mayor mediante sort");
                List<Auto> ordenPrecio = new ArrayList<Auto>(listaAutos);
                ordenPrecio.sort(Comparator.comparing(Auto::getPrecio));
                ordenPrecio.forEach(System.out::println);
                System.out.println("--------------------------");

                // 2. Ordenar por marca y luego por precio
                System.out.println("Ordenado por marca y precio");
                List<Auto> autosOrdenadosMarcaPrecio = listaAutos.stream()
                                .sorted(Comparator.comparing(Auto::getPrecio))
                                .sorted(Comparator.comparing(Auto::getMarca))
                                .collect(Collectors.toList());

                autosOrdenadosMarcaPrecio.forEach(
                                a -> System.out.println(a.getMarca() + " " + a.getModelo() + " - $" + a.getPrecio()));

                // 2. Ordenar por marca y luego por precio usando sorted()
                System.out.println("Ordenado por marca y luego por precio usando sorted()");
                listaAutos.stream()
                                .sorted(Comparator.comparing(Auto::getMarca).thenComparing(Auto::getPrecio))
                                .forEach(System.out::println);
                System.out.println("--------------------------");

                // 3. Autos cuyo precio no supere los 23000
                System.out.println("Filtrado autos más baratos que 23000");
                List<Auto> autosBaratos = listaAutos.stream()
                                .filter(auto -> auto.getPrecio() <= 23000)
                                .collect(Collectors.toList());

                autosBaratos.forEach(
                                a -> System.out.println(a.getMarca() + " " + a.getModelo() + " - $" + a.getPrecio()));
                System.out.println("--------------------------");

                // 3. Autos cuyo precio no supere los 23000
                System.out.println("Filtrado autos más baratos que 23000");
                listaAutos.stream()
                                .filter(auto -> auto.getPrecio() <= 23000)
                                .forEach(System.out::println);
                System.out.println("--------------------------");

                // 4. Autos de marca Chevrolet o Volkswagen
                System.out.println("Filtrado autos Chevrolet y Volkswagen");
                List<Auto> modelosChevrolet = listaAutos.stream()
                                .filter(auto -> auto.getMarca().equals("Chevrolet")
                                                || auto.getMarca().equals("Volkswagen"))
                                .collect(Collectors.toList());

                modelosChevrolet.forEach(
                                a -> System.out.println(a.getMarca() + " " + a.getModelo() + " - $" + a.getPrecio()));
                System.out.println("--------------------------");

                // 5. Autos cuyo modelo contiene al menos una “a”
                System.out.println("Filtrado autos cuyo modelo tiene una a");
                listaAutos.stream()
                                .filter(auto -> auto.getModelo().toLowerCase().contains("a"))
                                .forEach(System.out::println);

                System.out.println("--------------------------");
                System.out.println("Mapa con modelo como clave y precio como valor");
                Map<String, Integer> modeloPrecio = listaAutos.stream()
                                .collect(Collectors.toMap(
                                                Auto::getModelo,
                                                Auto::getPrecio));

                modeloPrecio.forEach((modelo, precio) -> System.out.println(modelo + ": $" + precio));

        }
}
