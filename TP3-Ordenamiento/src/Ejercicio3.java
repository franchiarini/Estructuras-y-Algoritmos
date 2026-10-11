/*
Implementá en Java el algoritmo Insertion Sort para ordenar un arreglo de números enteros que se encuentra casi ordenado.

**Estrategia:** recorrer el arreglo desde la segunda posición, tomando cada elemento como valor a insertar dentro de la parte izquierda, que ya se encuentra ordenada. Desplazar una posición hacia la derecha los elementos mayores que el valor actual y colocarlo en su posición correcta.

**Justificación:** Insertion Sort es especialmente eficiente cuando los datos están casi ordenados porque cada elemento necesita pocos desplazamientos para alcanzar su posición definitiva. A diferencia de otros algoritmos, no necesita reorganizar constantemente todo el arreglo.

**Complejidad:**

- Mejor caso: Θ(n), cuando el arreglo ya está ordenado.
- Peor caso: Θ(n²), cuando está ordenado en sentido inverso.
- Caso promedio: Θ(n²), para arreglos con distribución aleatoria.
- Espacio auxiliar: O(1).

**Requisitos:**

- Crear `Ejercicio3.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `insertionSort(int[] array)` utilizando un ciclo `for` externo y un ciclo `while` interno.
- Ordenar los elementos de menor a mayor.
- Utilizar una variable temporal para almacenar el elemento que se desea insertar.
- Desplazar los elementos mayores hacia la derecha hasta encontrar la posición correcta.
- Contabilizar la cantidad de desplazamientos realizados.
- Considerar como desplazamiento cada movimiento de un elemento hacia la derecha dentro del ciclo interno.
- No contabilizar como desplazamiento la escritura final del elemento que se está insertando.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Mostrar el arreglo original, el arreglo ordenado y la cantidad total de desplazamientos.
- Incorporar comentarios que expliquen la estrategia, la parte ordenada del arreglo y la contabilización de desplazamientos.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{1, 2, 3, 5, 4, 6, 7}` y verificar que el resultado sea `{1, 2, 3, 4, 5, 6, 7}` con exactamente un desplazamiento.
- Probar también arreglos completamente ordenados, inversamente ordenados, con números repetidos, negativos, vacíos y de un único elemento.
- Manejar arreglos nulos explícitamente mediante `IllegalArgumentException`.
- Verificar que todos los elementos se conserven después del ordenamiento.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio3 {

    public static void insertionSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        long desplazamientos = 0;
        for (int i = 1; i < array.length; i++) {
            // La parte izquierda, desde 0 hasta i - 1, ya esta ordenada.
            int temporal = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temporal) {
                array[j + 1] = array[j];
                // Contamos solo el movimiento de un elemento hacia la derecha.
                desplazamientos++;
                j--;
            }
            // Esta escritura final no cuenta como desplazamiento.
            array[j + 1] = temporal;
        }
        System.out.println("Desplazamientos: " + desplazamientos);
    }

    // Mejor Theta(n); peor y promedio aleatorio Theta(n^2). Espacio O(1).
    public static void main(String[] args) {
        int[][] ejemplos = {
            {1, 2, 3, 5, 4, 6, 7}, {1, 2, 3, 4}, {4, 3, 2, 1},
            {3, 1, 3, 1}, {-1, -5, 0, -3}, {}, {7}
        };
        for (int[] array : ejemplos) {
            System.out.print("Arreglo original: ");
            mostrarArreglo(array);
            insertionSort(array);
            System.out.print("Arreglo ordenado: ");
            mostrarArreglo(array);
        }
        try {
            insertionSort(null);
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
