/*
Implementá en Java Quicksort sobre un arreglo de números enteros ya ordenado de menor a mayor, utilizando siempre el primer elemento de cada subarreglo como pivote y contabilizando la cantidad de llamadas recursivas realizadas.

**Estrategia:** aplicar Quicksort mediante particiones recursivas, seleccionando siempre el primer elemento del segmento como pivote. Utilizar un arreglo previamente ordenado para observar cómo se generan particiones desbalanceadas.

**Justificación:** cuando el arreglo ya está ordenado y se selecciona siempre el primer elemento como pivote, este resulta ser el menor del segmento. Por eso, después de cada partición queda un subarreglo vacío y otro con todos los elementos restantes. La división es muy desigual y provoca un mayor número de niveles recursivos.

**Caso base:** cuando el segmento contiene cero o un elemento, finalizar la llamada porque ya se encuentra ordenado.

**Caso recursivo:** particionar el segmento alrededor del primer elemento y llamar nuevamente a Quicksort sobre los segmentos izquierdo y derecho.

**Reducción del problema:** cada llamada procesa un subarreglo más pequeño, pero en el peor caso su tamaño disminuye solamente en una unidad, generando una profundidad recursiva lineal.

**Complejidad:**
- Mejor caso: Θ(n log n), con particiones equilibradas.
- Caso promedio: Θ(n log n), bajo una distribución adecuada de los datos.
- Peor caso: Θ(n²), para particiones completamente desbalanceadas.
- Espacio auxiliar: O(log n) con particiones equilibradas y O(n) en el peor caso, debido a la pila de llamadas.

**Requisitos:**
- Crear `Ejercicio7.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar manualmente Quicksort utilizando siempre el primer elemento del segmento como pivote.
- Utilizar particiones in-place y llamadas recursivas, sin crear arreglos auxiliares para cada partición.
- Utilizar un método auxiliar recursivo que reciba los límites del segmento.
- Incorporar un contador que se incremente al entrar a cada invocación del método recursivo, incluyendo las llamadas que llegan directamente al caso base.
- Mostrar el arreglo original, el pivote utilizado en cada partición, los tamaños de los subarreglos izquierdo y derecho y la cantidad total de llamadas recursivas.
- Mostrar el arreglo final ordenado.
- Explicar mediante comentarios por qué las particiones quedan desbalanceadas y cómo esto produce una complejidad temporal cuadrática.
- Utilizar como ejemplo principal `{1, 2, 3, 4, 5, 6, 7}`.
- No utilizar `Arrays.sort()` ni otros métodos predefinidos de ordenamiento.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar un arreglo ya ordenado, uno inversamente ordenado y otro desordenado para comparar los comportamientos.
- Probar también arreglos vacíos, unitarios, con elementos repetidos y números negativos.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que los arreglos queden correctamente ordenados y conserven todos sus elementos.
- Verificar que el contador de llamadas sea consistente con la implementación, incluyendo los casos base.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio7 {
    public static long quickSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        System.out.print("Original: ");
        mostrarArreglo(array);
        long llamadas = quickSort(array, 0, array.length - 1, 0L);
        System.out.print("Ordenado: ");
        mostrarArreglo(array);
        System.out.println("Llamadas recursivas: " + llamadas);
        return llamadas;
    }

    private static long quickSort(int[] array, int inicio, int fin, long llamadas) {
        // Cada entrada cuenta, incluida la inicial y las que llegan al caso base.
        llamadas++;
        if (inicio >= fin) {
            return llamadas;
        }
        int posicion = particionar(array, inicio, fin);
        System.out.println("Pivote: " + array[posicion] + ", izquierda="
                + (posicion - inicio) + ", derecha=" + (fin - posicion));
        // Caso recursivo: excluimos el pivote, reduciendo ambos segmentos.
        llamadas = quickSort(array, inicio, posicion - 1, llamadas);
        return quickSort(array, posicion + 1, fin, llamadas);
    }

    private static int particionar(int[] array, int inicio, int fin) {
        int pivote = array[inicio];
        int limite = inicio;
        for (int i = inicio + 1; i <= fin; i++) {
            if (array[i] < pivote) {
                limite++;
                intercambiar(array, limite, i);
            }
        }
        intercambiar(array, inicio, limite);
        return limite;
    }

    private static void intercambiar(int[] array, int i, int j) {
        int temporal = array[i];
        array[i] = array[j];
        array[j] = temporal;
    }

    // En orden ascendente el primer pivote siempre es el menor: quedan 0 y n-1
    // elementos. La profundidad es lineal y el trabajo n-1 + n-2 + ... es cuadratico.
    // Tiempo: mejor/promedio Theta(n log n), peor Theta(n^2).
    // Espacio de pila: O(log n) equilibrado, O(n) en el peor caso.
    // El contador mide invocaciones, no comparaciones ni profundidad de la pila.
    private static void mostrarArreglo(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[][] ejemplos = {{1,2,3,4,5,6,7}, {7,6,5,4,3,2,1}, {4,2,6,1,3,5,7},
                {}, {7}, {3,1,3,1}, {-1,-5,0,-3}};
        for (int[] array : ejemplos) quickSort(array);
        try {
            quickSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
    }
}
