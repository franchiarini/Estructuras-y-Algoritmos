/*
Implementá en Java dos algoritmos de ordenamiento para comparar Bubble Sort y Selection Sort utilizando el mismo arreglo de números enteros.

**Estrategia A — Bubble Sort:** recorrer el arreglo mediante dos ciclos `for` anidados, comparar elementos vecinos e intercambiarlos cuando estén desordenados. Reducir el límite interno después de cada pasada, sin incorporar finalización anticipada.

**Estrategia B — Selection Sort:** recorrer el arreglo buscando el elemento mínimo de la parte desordenada y colocarlo en su posición definitiva mediante un intercambio. Realizar el intercambio solamente si el mínimo está en una posición diferente de la actual.

**Justificación:** Bubble Sort realiza intercambios entre elementos vecinos, mientras que Selection Sort primero busca el mínimo y después lo coloca en la posición correspondiente. Comparar sus operaciones permite observar que dos algoritmos con complejidad temporal cuadrática pueden realizar diferentes cantidades de intercambios.

**Complejidad:**

- Bubble Sort: mejor, peor y caso promedio Θ(n²), espacio auxiliar O(1).
- Selection Sort: mejor, peor y caso promedio Θ(n²), espacio auxiliar O(1).
- Explicar que Selection Sort realiza como máximo n - 1 intercambios, mientras que Bubble Sort puede realizar O(n²).

**Requisitos:**

- Crear `Ejercicio2.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar los métodos `bubbleSort(int[] array)` y `selectionSort(int[] array)`.
- Ordenar los arreglos de menor a mayor.
- Implementar ambos algoritmos manualmente, sin `Arrays.sort()` ni otros métodos predefinidos de ordenamiento.
- Contabilizar por separado comparaciones entre elementos e intercambios reales de cada algoritmo.
- Considerar comparación cada vez que se comparan dos valores del arreglo, sin contar condiciones de control de los ciclos.
- Considerar intercambio solamente cuando se modifican efectivamente las posiciones de dos elementos; no contar intercambios consigo mismo.
- Utilizar copias independientes del mismo arreglo original para que ambos algoritmos reciban exactamente los mismos datos.
- Mostrar el arreglo original, el resultado de cada algoritmo y los contadores correspondientes.
- Incorporar comentarios explicando la estrategia de cada algoritmo y las diferencias entre ambos.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{5, 3, 8, 2}` y verificar que Bubble Sort realice 6 comparaciones y 4 intercambios, mientras que Selection Sort realice 6 comparaciones y 2 intercambios.
- Probar arreglos ordenados, inversamente ordenados, con elementos repetidos, negativos, vacíos y de un solo elemento.
- Manejar entradas nulas explícitamente.
- Verificar que ambos algoritmos produzcan exactamente el mismo arreglo ordenado.
- Compilar y ejecutar con Java 21, informando los resultados de las pruebas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio2 {

    public static void bubbleSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        long comparaciones = 0;
        long intercambios = 0;
        for (int pasada = 0; pasada < array.length - 1; pasada++) {
            // Las ultimas posiciones ya estan ordenadas. No hay salida anticipada.
            for (int i = 0; i < array.length - 1 - pasada; i++) {
                // Solo se cuentan comparaciones entre valores, no controles del ciclo.
                comparaciones++;
                if (array[i] > array[i + 1]) {
                    int temporal = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temporal;
                    intercambios++; // Un intercambio real entre vecinos.
                }
            }
        }
        System.out.println("Bubble Sort: comparaciones=" + comparaciones
                + ", intercambios=" + intercambios);
    }

    public static void selectionSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        long comparaciones = 0;
        long intercambios = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int indiceMinimo = i;
            // Primero buscamos el minimo de la parte pendiente.
            for (int j = i + 1; j < array.length; j++) {
                comparaciones++; // Comparacion entre dos valores del arreglo.
                if (array[j] < array[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            // No se cuentan ni se realizan intercambios consigo mismo.
            if (indiceMinimo != i) {
                int temporal = array[i];
                array[i] = array[indiceMinimo];
                array[indiceMinimo] = temporal;
                intercambios++;
            }
        }
        System.out.println("Selection Sort: comparaciones=" + comparaciones
                + ", intercambios=" + intercambios);
    }

    // Ambos: tiempo Theta(n^2) en mejor, peor y promedio; espacio auxiliar O(1).
    // Seleccion realiza como maximo n - 1 intercambios; burbuja puede hacer O(n^2).
    public static void main(String[] args) {
        int[][] ejemplos = {
            {5, 3, 8, 2}, {1, 2, 3, 4}, {4, 3, 2, 1},
            {3, 1, 3, 1}, {-1, -5, 0, -3}, {}, {7}
        };
        for (int[] original : ejemplos) {
            // Las copias son independientes: ningun algoritmo recibe el ya ordenado.
            int[] burbuja = original.clone();
            int[] seleccion = original.clone();
            System.out.print("Original: ");
            mostrarArreglo(original);
            bubbleSort(burbuja);
            System.out.print("Resultado Bubble Sort: ");
            mostrarArreglo(burbuja);
            selectionSort(seleccion);
            System.out.print("Resultado Selection Sort: ");
            mostrarArreglo(seleccion);
        }
        try {
            bubbleSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Bubble Sort nulo: " + e.getMessage());
        }
        try {
            selectionSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Selection Sort nulo: " + e.getMessage());
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
