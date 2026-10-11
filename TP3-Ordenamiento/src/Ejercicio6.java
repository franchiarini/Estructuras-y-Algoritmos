/*
Implementá en Java el algoritmo Quicksort para ordenar un arreglo de números enteros de menor a mayor, utilizando siempre el primer elemento de cada subarreglo como pivote.

**Estrategia:** aplicar el paradigma divide y vencerás. Seleccionar el primer elemento del segmento como pivote, particionar el arreglo para ubicar los elementos menores a su izquierda y los mayores o iguales a su derecha, y ordenar recursivamente ambas partes.

**Justificación:** Quicksort permite resolver el ordenamiento dividiendo el arreglo en subproblemas más pequeños. El pivote establece una separación entre elementos menores y mayores, y la recursividad permite ordenar cada segmento de manera independiente.

**Caso base:** cuando el subarreglo contiene cero o un elemento, finalizar la llamada recursiva porque ese segmento ya está ordenado.

**Caso recursivo:** seleccionar el primer elemento como pivote, realizar la partición y llamar nuevamente a Quicksort sobre los segmentos izquierdo y derecho.

**Reducción del problema:** cada llamada recursiva trabaja sobre una porción menor del arreglo, excluyendo el pivote que ya quedó ubicado en su posición definitiva.

**Complejidad:**
- Mejor caso: Θ(n log n), cuando las particiones están equilibradas.
- Caso promedio: Θ(n log n), bajo una distribución adecuada de los datos.
- Peor caso: Θ(n²), cuando las particiones quedan muy desbalanceadas.
- Espacio auxiliar: O(log n) en particiones equilibradas y O(n) en el peor caso, debido a la pila de llamadas.

**Requisitos:**
- Crear `Ejercicio6.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `quickSort(int[] array)` y los métodos auxiliares necesarios para la recursividad y la partición.
- Utilizar siempre el primer elemento del segmento actual como pivote, incluso durante las llamadas recursivas.
- Implementar manualmente la partición utilizando intercambios dentro del mismo arreglo, sin crear arreglos auxiliares para cada subarreglo.
- Utilizar un esquema de partición consistente que garantice que el pivote quede en su posición definitiva y que las llamadas recursivas reduzcan el tamaño del problema.
- Ordenar de menor a mayor.
- Mostrar el arreglo original.
- En cada partición, mostrar el pivote elegido, los elementos del segmento izquierdo y los del segmento derecho después de particionar.
- Indicar visualmente mediante mensajes qué segmentos se procesan recursivamente y cuál es el caso base.
- Mostrar el arreglo final ordenado.
- Incorporar comentarios que expliquen el pivote, la partición, el caso base, el caso recursivo y el paradigma divide y vencerás.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{5, 3, 8, 2, 7, 1}` y comprobar que el resultado final sea `{1, 2, 3, 5, 7, 8}`.
- Probar arreglos ordenados, inversamente ordenados, con valores repetidos, negativos, vacíos, unitarios y extremos de `int`.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que todos los elementos originales se conserven y que el arreglo final esté correctamente ordenado.
- Compilar y ejecutar con Java 21, verificando los resultados y las trazas de partición.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio6 {
    public static void quickSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        System.out.print("Arreglo original: ");
        mostrarSegmento(array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1);
        System.out.print("Arreglo ordenado: ");
        mostrarSegmento(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int inicio, int fin) {
        System.out.print("Procesando [" + inicio + ", " + fin + "]: ");
        mostrarSegmento(array, inicio, fin);
        // Caso base: un segmento vacio o unitario ya esta ordenado.
        if (inicio >= fin) {
            System.out.println("Caso base: cero o un elemento.");
            return;
        }
        // Divide y venceras: particionar y ordenar ambos lados por separado.
        int posicionPivote = particionar(array, inicio, fin);
        System.out.println("Pivote: " + array[posicionPivote] + ", indice definitivo: " + posicionPivote);
        System.out.print("Izquierda: ");
        mostrarSegmento(array, inicio, posicionPivote - 1);
        System.out.print("Derecha: ");
        mostrarSegmento(array, posicionPivote + 1, fin);
        // Excluir el pivote garantiza que ambos problemas sean menores.
        System.out.println("Recursion izquierda:");
        quickSort(array, inicio, posicionPivote - 1);
        System.out.println("Recursion derecha:");
        quickSort(array, posicionPivote + 1, fin);
    }

    private static int particionar(int[] array, int inicio, int fin) {
        // Siempre se elige el primer elemento del segmento actual.
        int pivote = array[inicio];
        int limiteMenores = inicio;
        for (int i = inicio + 1; i <= fin; i++) {
            if (array[i] < pivote) {
                limiteMenores++;
                intercambiar(array, limiteMenores, i);
            }
        }
        // A la izquierda quedan valores menores; a la derecha, mayores o iguales.
        intercambiar(array, inicio, limiteMenores);
        return limiteMenores;
    }

    private static void intercambiar(int[] array, int i, int j) {
        int temporal = array[i];
        array[i] = array[j];
        array[j] = temporal;
    }

    private static void mostrarSegmento(int[] array, int inicio, int fin) {
        System.out.print("{");
        for (int i = inicio; i <= fin; i++) {
            if (i > inicio) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("}");
    }

    // Tiempo: mejor y promedio Theta(n log n), peor Theta(n^2).
    // Pila: O(log n) equilibrada, O(n) en el peor caso.
    public static void main(String[] args) {
        int[][] ejemplos = {{5, 3, 8, 2, 7, 1}, {1, 2, 3, 4}, {4, 3, 2, 1},
            {3, 1, 3, 1}, {-1, -5, 0, -3}, {}, {7},
            {Integer.MAX_VALUE, 0, Integer.MIN_VALUE}};
        for (int[] array : ejemplos) quickSort(array);
        try {
            quickSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
    }
}
