/*
Implementá en Java el algoritmo ShellSort para ordenar un arreglo de números enteros de menor a mayor, mostrando cómo cambia el arreglo durante las diferentes etapas de ordenamiento.

**Estrategia:** utilizar ShellSort mediante inserciones con saltos. Comenzar con un gap igual a la mitad de la longitud del arreglo (`n / 2`) y reducirlo mediante división entera por 2 hasta llegar a 1. Para cada gap, aplicar una inserción que compare y desplace elementos separados por esa distancia.

**Justificación:** ShellSort mejora el ordenamiento por inserción porque permite desplazar elementos a distancias mayores durante las primeras etapas, acercándolos más rápidamente a sus posiciones correctas. Cuando el gap llega a 1, se completa el ordenamiento mediante una inserción convencional sobre un arreglo parcialmente ordenado.

**Complejidad:**

- Peor caso: O(n²) para la secuencia de gaps elegida.
- Mejor caso y caso promedio: dependen de la distribución de los elementos y de la secuencia de gaps.
- Espacio auxiliar: O(1), porque el algoritmo ordena el arreglo directamente sin utilizar estructuras auxiliares proporcionales a su tamaño.

**Requisitos:**

- Crear `Ejercicio5.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `shellSort(int[] array)`.
- Utilizar ciclos `for` y un ciclo `while` para realizar las inserciones con saltos.
- Comenzar con `gap = array.length / 2` y reducirlo a la mitad en cada etapa hasta llegar a 1.
- Ordenar los números de menor a mayor.
- Mostrar el arreglo original antes del ordenamiento.
- Mostrar el valor del gap utilizado al comienzo de cada etapa.
- Mostrar el estado completo del arreglo después de finalizar cada pasada correspondiente a un gap.
- Incorporar comentarios que expliquen qué representa el gap, cómo se realizan las comparaciones y desplazamientos, y por qué su reducción permite ordenar progresivamente el arreglo.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal `{8, 5, 3, 7, 6, 2, 4, 1}`.
- Verificar que las etapas del ejemplo produzcan los estados `{6, 2, 3, 1, 8, 5, 4, 7}` con gap 4, `{3, 1, 4, 2, 6, 5, 8, 7}` con gap 2 y `{1, 2, 3, 4, 5, 6, 7, 8}` con gap 1.
- Probar arreglos ordenados, inversamente ordenados, con elementos repetidos, números negativos, vacíos y de un solo elemento.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que el arreglo final esté ordenado y conserve todos sus elementos originales.
- Compilar y ejecutar con Java 21, comprobando los resultados y las trazas de los gaps.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio5 {

    public static void shellSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        System.out.print("Arreglo original: ");
        mostrarArreglo(array);
        // El gap es la distancia entre los elementos de cada insercion.
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            System.out.println("Gap: " + gap);
            for (int i = gap; i < array.length; i++) {
                int temporal = array[i];
                int j = i;
                // Comparamos y desplazamos elementos separados por el gap.
                while (j >= gap && array[j - gap] > temporal) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temporal;
            }
            // Reducir el salto acerca los elementos a sus posiciones finales.
            // Con gap 1, la insercion convencional completa el ordenamiento.
            System.out.print("Despues del gap " + gap + ": ");
            mostrarArreglo(array);
        }
        System.out.print("Arreglo ordenado: ");
        mostrarArreglo(array);
    }

    // Peor caso O(n^2) para estos gaps; el rendimiento depende de la secuencia
    // y la distribucion de los datos. Espacio auxiliar O(1).
    public static void main(String[] args) {
        int[][] ejemplos = {
            {8, 5, 3, 7, 6, 2, 4, 1}, {1, 2, 3, 4}, {4, 3, 2, 1},
            {3, 1, 3, 1}, {-1, -5, 0, -3}, {}, {7}
        };
        for (int[] array : ejemplos) {
            shellSort(array);
        }
        try {
            shellSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
    }

    private static void mostrarArreglo(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("}");
    }
}
