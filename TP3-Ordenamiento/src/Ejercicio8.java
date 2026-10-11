/*
Implementá en Java el algoritmo MergeSort para ordenar un arreglo de números enteros de menor a mayor, mostrando paso a paso cómo se divide el arreglo y cómo se fusionan sus partes.

**Estrategia:** utilizar el paradigma divide y vencerás. Dividir recursivamente cada segmento del arreglo en dos mitades hasta obtener segmentos de un único elemento. Luego fusionar las partes ordenadas, comparando sus elementos para reconstruir segmentos cada vez más grandes.

**Justificación:** MergeSort resuelve el problema dividiendo el arreglo en subproblemas más pequeños y combinando posteriormente sus resultados. A diferencia de Quicksort, no utiliza pivotes y mantiene divisiones aproximadamente equilibradas.

**Caso base:** cuando el segmento contiene cero o un elemento, finalizar la recursión porque ese segmento ya está ordenado.

**Caso recursivo:** calcular el índice central, ordenar recursivamente la mitad izquierda, ordenar recursivamente la mitad derecha y finalmente fusionar ambas partes en orden ascendente.

**Reducción del problema:** en cada llamada recursiva se divide el segmento aproximadamente por la mitad, hasta alcanzar el caso base.

**Complejidad:**
- Mejor caso: Θ(n log n).
- Peor caso: Θ(n log n).
- Caso promedio: Θ(n log n).
- Espacio auxiliar: O(n), debido al arreglo utilizado durante las fusiones, además de la pila recursiva O(log n).

**Requisitos:**
- Crear `Ejercicio8.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `mergeSort(int[] array)` y los métodos auxiliares recursivos y de fusión necesarios.
- Implementar MergeSort manualmente, sin `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Dividir el arreglo utilizando un índice central calculado de forma segura.
- Utilizar recursividad para procesar ambas mitades.
- Utilizar un arreglo auxiliar para fusionar los elementos ordenados.
- Mostrar el arreglo original antes del ordenamiento.
- Mostrar en consola cada división, indicando el segmento actual y las mitades obtenidas.
- Identificar mediante mensajes cuándo una llamada alcanza el caso base.
- Mostrar las fusiones realizadas, indicando los segmentos que se combinan y el resultado ordenado.
- Diferenciar claramente los mensajes de DIVISIÓN, CASO BASE y FUSIÓN.
- Mostrar el arreglo final completamente ordenado.
- Incorporar comentarios explicando la recursividad, el caso base, la división, la fusión y el paradigma divide y vencerás.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal `{8, 5, 2, 9, 6, 3}` y verificar que el resultado sea `{2, 3, 5, 6, 8, 9}`.
- Probar arreglos ordenados, inversamente ordenados, con elementos repetidos, números negativos, vacíos, unitarios y extremos de `int`.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que el arreglo final conserve todos los elementos originales.
- Verificar que las trazas de división, caso base y fusión sean coherentes con el funcionamiento del algoritmo.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio8 {
    public static void mergeSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        System.out.print("Original: ");
        mostrarSegmento(array, 0, array.length - 1);
        // Se reserva una sola vez y se reutiliza durante todas las fusiones.
        int[] auxiliar = new int[array.length];
        mergeSort(array, auxiliar, 0, array.length - 1);
        System.out.print("Ordenado: ");
        mostrarSegmento(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] auxiliar, int inicio, int fin) {
        // Caso base: cero o un elemento ya estan ordenados.
        if (inicio >= fin) {
            System.out.print("CASO BASE: ");
            mostrarSegmento(array, inicio, fin);
            return;
        }
        int medio = inicio + (fin - inicio) / 2;
        System.out.print("DIVISIÓN: ");
        mostrarSegmento(array, inicio, fin);
        System.out.print("Izquierda: ");
        mostrarSegmento(array, inicio, medio);
        System.out.print("Derecha: ");
        mostrarSegmento(array, medio + 1, fin);
        // Divide y venceras: ordenar mitades menores y combinar sus resultados.
        mergeSort(array, auxiliar, inicio, medio);
        mergeSort(array, auxiliar, medio + 1, fin);
        System.out.println("FUSIÓN:");
        System.out.print("Izquierda: ");
        mostrarSegmento(array, inicio, medio);
        System.out.print("Derecha: ");
        mostrarSegmento(array, medio + 1, fin);
        fusionar(array, auxiliar, inicio, medio, fin);
        System.out.print("Resultado: ");
        mostrarSegmento(array, inicio, fin);
    }

    private static void fusionar(int[] array, int[] auxiliar, int inicio, int medio, int fin) {
        int izquierda = inicio;
        int derecha = medio + 1;
        int destino = inicio;
        // Las dos mitades ya estan ordenadas: tomamos el menor disponible.
        while (izquierda <= medio && derecha <= fin) {
            if (array[izquierda] <= array[derecha]) {
                auxiliar[destino++] = array[izquierda++];
            } else {
                auxiliar[destino++] = array[derecha++];
            }
        }
        while (izquierda <= medio) auxiliar[destino++] = array[izquierda++];
        while (derecha <= fin) auxiliar[destino++] = array[derecha++];
        for (int i = inicio; i <= fin; i++) array[i] = auxiliar[i];
    }

    private static void mostrarSegmento(int[] array, int inicio, int fin) {
        System.out.print("{");
        for (int i = inicio; i <= fin; i++) {
            if (i > inicio) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("}");
    }

    // Mejor, peor y promedio Theta(n log n). Auxiliar O(n) y pila O(log n).
    public static void main(String[] args) {
        int[][] ejemplos = {{8,5,2,9,6,3}, {1,2,3,4}, {4,3,2,1}, {3,1,3,1},
                {-1,-5,0,-3}, {}, {7}, {Integer.MAX_VALUE,0,Integer.MIN_VALUE}};
        for (int[] array : ejemplos) mergeSort(array);
        try {
            mergeSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
    }
}
