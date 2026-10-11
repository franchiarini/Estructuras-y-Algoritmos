/*
Implementá en Java el algoritmo Selection Sort para ordenar alfabéticamente un arreglo de nombres representados mediante String.

**Estrategia:** recorrer el arreglo mediante dos ciclos `for` anidados. En cada pasada, buscar el nombre alfabéticamente menor dentro de la parte desordenada y colocarlo en la posición correspondiente mediante un intercambio.

**Justificación:** Selection Sort permite ordenar nombres utilizando la misma estrategia que con números, pero cambiando la forma de comparar los elementos. En lugar de operadores numéricos, debemos utilizar `compareTo()` para determinar qué cadena aparece primero alfabéticamente.

**Complejidad:**

- Mejor caso: Θ(n²) comparaciones de cadenas.
- Peor caso: Θ(n²) comparaciones de cadenas.
- Caso promedio: Θ(n²) comparaciones de cadenas.
- Espacio auxiliar: O(1).
- Aclarar que el costo individual de `compareTo()` depende de la longitud de las cadenas comparadas.

**Requisitos:**

- Crear `Ejercicio4.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `selectionSort(String[] nombres)`.
- Utilizar dos ciclos `for` anidados para buscar el nombre alfabéticamente menor en cada pasada.
- Comparar los nombres utilizando `String.compareTo()`.
- Ordenar los nombres de manera ascendente, siguiendo el orden lexicográfico de Java.
- Intercambiar los elementos únicamente cuando el índice del mínimo sea diferente de la posición actual.
- No utilizar `Arrays.sort()`, `Collections.sort()` ni métodos predefinidos de ordenamiento.
- Incorporar comentarios explicando cómo funciona Selection Sort y por qué se utiliza `compareTo()` en lugar de operadores numéricos.
- Incluir un método `main` con ejemplos de funcionamiento.
- Mostrar el arreglo original y el resultado ordenado.
- Utilizar como ejemplo principal `{"Lucia", "Ana", "Pedro", "Juan"}` y verificar que el resultado sea `{"Ana", "Juan", "Lucia", "Pedro"}`.
- Probar también nombres ya ordenados, inversamente ordenados, repetidos, arreglos vacíos y de un solo nombre.
- Utilizar nombres con capitalización consistente para mantener el criterio del ejemplo de la consigna.
- Manejar explícitamente arreglos nulos mediante `IllegalArgumentException`.
- Rechazar elementos String nulos mediante `IllegalArgumentException` antes de comenzar a ordenar, evitando modificaciones parciales.
- Verificar que el ordenamiento conserve todos los nombres originales.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar ejercicios anteriores ni realizar commits o push.
*/
public class Ejercicio4 {

    public static void selectionSort(String[] nombres) {
        if (nombres == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        // Validamos todo antes de intercambiar para evitar modificaciones parciales.
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] == null) {
                throw new IllegalArgumentException("Los nombres no pueden ser nulos.");
            }
        }

        for (int i = 0; i < nombres.length - 1; i++) {
            int indiceMinimo = i;
            // Buscamos el menor nombre de la parte que todavia no esta ordenada.
            for (int j = i + 1; j < nombres.length; j++) {
                // compareTo compara contenidos en orden lexicografico de Java.
                // Un resultado negativo indica que el primer nombre va antes.
                // Los operadores numericos no comparan contenidos de String.
                if (nombres[j].compareTo(nombres[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                String temporal = nombres[i];
                nombres[i] = nombres[indiceMinimo];
                nombres[indiceMinimo] = temporal;
            }
        }
    }

    // Mejor, peor y promedio: Theta(n^2) comparaciones de cadenas.
    // El costo de compareTo depende de las longitudes y del prefijo compartido.
    // Espacio auxiliar O(1).
    public static void main(String[] args) {
        String[][] ejemplos = {
            {"Lucia", "Ana", "Pedro", "Juan"},
            {"Ana", "Juan", "Lucia", "Pedro"},
            {"Pedro", "Lucia", "Juan", "Ana"},
            {"Lucia", "Ana", "Lucia", "Ana"}, {}, {"Ana"}
        };
        for (String[] nombres : ejemplos) {
            System.out.print("Original: ");
            mostrarNombres(nombres);
            selectionSort(nombres);
            System.out.print("Ordenado: ");
            mostrarNombres(nombres);
        }
        try {
            selectionSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
        try {
            selectionSort(new String[]{"Lucia", "Ana", null});
        } catch (IllegalArgumentException e) {
            System.out.println("Nombre nulo: " + e.getMessage());
        }
    }

    private static void mostrarNombres(String[] nombres) {
        System.out.print("{");
        for (int i = 0; i < nombres.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(nombres[i]);
        }
        System.out.println("}");
    }
}
