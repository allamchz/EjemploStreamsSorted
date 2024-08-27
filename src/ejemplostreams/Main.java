package ejemplostreams;

/**
 * Programa principal donde se aplican distintas ordenaciones para procesar un listado de personas
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Enrique", 42));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("May", 41));

        System.out.println("Personas ordenadas de mayor a menor edad y de menor a mayor nombre:");
        Comparator<Persona> cEdad = (p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad());
        Comparator<Persona> cNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        listaPersonas.stream()
                     .sorted(cEdad.thenComparing(cNombre))
                     .forEach(System.out::println);
    }
}
