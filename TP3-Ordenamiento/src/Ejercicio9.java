/*
Implementá en Java una comparación de los algoritmos Bubble Sort, Selection Sort e Insertion Sort, utilizando el mismo arreglo de números enteros y contabilizando las operaciones realizadas por cada uno.

**Estrategia A — Bubble Sort:** utilizar dos ciclos `for` anidados para comparar elementos vecinos e intercambiarlos cuando estén desordenados. Reducir el límite interno después de cada pasada, sin finalización anticipada.

**Estrategia B — Selection Sort:** buscar el elemento mínimo de la parte desordenada mediante dos ciclos `for` anidados y colocarlo en su posición definitiva. Intercambiar solamente cuando la posición del mínimo sea distinta de la posición actual.

**Estrategia C — Insertion Sort:** recorrer el arreglo desde el segundo elemento e insertar cada valor en su posición dentro de la parte previamente ordenada, desplazando hacia la derecha los elementos mayores.

**Justificación:** los tres algoritmos resuelven el mismo problema utilizando estrategias diferentes. Bubble Sort intercambia vecinos, Selection Sort busca el mínimo antes de moverlo e Insertion Sort construye progresivamente una zona ordenada. Comparar sus operaciones permite observar diferencias que no se reflejan únicamente en la notación Big O.

**Complejidad:**
- Bubble Sort tradicional: mejor, promedio y peor caso Θ(n²).
- Selection Sort: mejor, promedio y peor caso Θ(n²).
- Insertion Sort: mejor caso Θ(n), promedio y peor caso Θ(n²).
- Los tres algoritmos utilizan O(1) de espacio auxiliar, sin contar las copias independientes utilizadas exclusivamente para la comparación.

**Requisitos:**
- Crear `Ejercicio9.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar manualmente tres métodos: `bubbleSort(int[] array)`, `selectionSort(int[] array)` e `insertionSort(int[] array)`.
- No utilizar `Arrays.sort()` ni otros métodos predefinidos de ordenamiento para implementar los algoritmos.
- Utilizar copias independientes del mismo arreglo original, de modo que los tres algoritmos reciban exactamente los mismos datos.
- Ordenar todos los arreglos de menor a mayor.
- Contabilizar las comparaciones reales entre valores del arreglo, sin contar las condiciones de control de los ciclos.
- En Bubble Sort, contabilizar cada intercambio efectivo entre elementos vecinos.
- En Selection Sort, contabilizar cada intercambio efectivo, evitando intercambios consigo mismo.
- En Insertion Sort, contabilizar cada desplazamiento hacia la derecha dentro del ciclo interno; no contar la escritura final de la clave como desplazamiento.
- En Insertion Sort, contabilizar cada comparación entre la clave y un elemento previo, incluida la comparación que detiene el desplazamiento cuando la clave no es menor.
- Mostrar el arreglo original y los resultados ordenados de los tres algoritmos.
- Mostrar para cada algoritmo su cantidad de comparaciones y de intercambios o desplazamientos, usando etiquetas que distingan ambos tipos de movimiento.
- Incorporar una conclusión textual que explique las diferencias observadas, sin equiparar directamente el costo de un intercambio con el de un desplazamiento.
- Incorporar comentarios explicando la estrategia y la contabilización de operaciones de cada algoritmo.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal `{5, 3, 8, 2}`.
- Verificar que los tres algoritmos produzcan `{2, 3, 5, 8}`.
- Para el ejemplo principal, verificar los contadores: Bubble Sort, 6 comparaciones y 4 intercambios; Selection Sort, 6 comparaciones y 2 intercambios; Insertion Sort, 5 comparaciones y 4 desplazamientos.
- Probar también arreglos ya ordenados, inversamente ordenados, casi ordenados, con elementos repetidos, negativos, vacíos, unitarios y extremos de `int`.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que todos los algoritmos produzcan el mismo resultado, conserven los elementos originales y no modifiquen el arreglo utilizado como fuente para las copias.
- Compilar y ejecutar con Java 21, documentando los resultados reales de las pruebas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio9 {
    public static void bubbleSort(int[] array) {
        validar(array);
        long comparaciones = 0, intercambios = 0;
        // Burbuja tradicional: vecinos, limite decreciente, sin salida anticipada.
        for (int pasada = 0; pasada < array.length - 1; pasada++) {
            for (int i = 0; i < array.length - 1 - pasada; i++) {
                comparaciones++;
                if (array[i] > array[i + 1]) {
                    int temporal = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temporal;
                    intercambios++;
                }
            }
        }
        System.out.println("Bubble Sort: comparaciones=" + comparaciones + ", intercambios=" + intercambios);
    }

    public static void selectionSort(int[] array) {
        validar(array);
        long comparaciones = 0, intercambios = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < array.length; j++) {
                comparaciones++; // Solo comparar valores, no indices ni controles.
                if (array[j] < array[minimo]) minimo = j;
            }
            // Buscar primero el minimo permite hacer a lo sumo un intercambio por pasada.
            if (minimo != i) {
                int temporal = array[i];
                array[i] = array[minimo];
                array[minimo] = temporal;
                intercambios++;
            }
        }
        System.out.println("Selection Sort: comparaciones=" + comparaciones + ", intercambios=" + intercambios);
    }

    public static void insertionSort(int[] array) {
        validar(array);
        long comparaciones = 0, desplazamientos = 0;
        for (int i = 1; i < array.length; i++) {
            int clave = array[i];
            int j = i - 1;
            // La zona izquierda ya esta ordenada; insertar la clave en ella.
            while (j >= 0) {
                // Incluimos la comparacion que detiene los desplazamientos.
                // No contamos j >= 0, porque es una condicion de control.
                comparaciones++;
                if (array[j] <= clave) break;
                array[j + 1] = array[j];
                desplazamientos++;
                j--;
            }
            array[j + 1] = clave; // La escritura final no es un desplazamiento.
        }
        System.out.println("Insertion Sort: comparaciones=" + comparaciones + ", desplazamientos=" + desplazamientos);
    }

    private static void validar(int[] array) {
        if (array == null) throw new IllegalArgumentException("El arreglo no puede ser nulo.");
    }

    private static void mostrar(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("}");
    }

    // Burbuja y seleccion: Theta(n^2) en todos los casos.
    // Insercion: mejor Theta(n), promedio/peor Theta(n^2). Todos: espacio O(1).
    public static void main(String[] args) {
        int[][] ejemplos = {{5,3,8,2}, {1,2,3,4}, {4,3,2,1}, {1,2,3,5,4,6,7},
                {3,1,3,1}, {-1,-5,0,-3}, {}, {7}, {Integer.MAX_VALUE,0,Integer.MIN_VALUE}};
        for (int[] original : ejemplos) {
            int[] burbuja = original.clone();
            int[] seleccion = original.clone();
            int[] insercion = original.clone();
            System.out.print("Original: "); mostrar(original);
            bubbleSort(burbuja);
            System.out.print("Resultado Bubble Sort: "); mostrar(burbuja);
            selectionSort(seleccion);
            System.out.print("Resultado Selection Sort: "); mostrar(seleccion);
            insertionSort(insercion);
            System.out.print("Resultado Insertion Sort: "); mostrar(insercion);
        }
        System.out.println("Conclusion: en {5, 3, 8, 2}, Burbuja hace 6 comparaciones y 4 intercambios;");
        System.out.println("Seleccion hace 6 comparaciones y 2 intercambios; Insercion, 5 comparaciones y 4 desplazamientos.");
        System.out.println("Insercion aprovecha el orden previo; Burbuja y Seleccion mantienen sus comparaciones.");
        System.out.println("Un intercambio cambia dos posiciones; un desplazamiento mueve un elemento a la derecha.");
        System.out.println("Sus cantidades describen operaciones distintas y no equivalen directamente en costo.");
    }
}
