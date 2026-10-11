/*
Implementá en Java el algoritmo Bubble Sort para ordenar un arreglo de números enteros de menor a mayor, mostrando cómo evoluciona el arreglo después de cada pasada.

**Estrategia:** utilizar dos ciclos `for` anidados. El ciclo externo controla las pasadas y el interno compara elementos vecinos, intercambiándolos cuando el primero es mayor que el segundo. Reducir el límite interno después de cada pasada porque los últimos elementos ya estarán ordenados.

**Justificación:** Bubble Sort desplaza progresivamente los elementos mayores hacia el final del arreglo. Después de cada pasada, el mayor elemento de la parte pendiente queda ubicado en su posición definitiva.

**Complejidad:**

- Mejor caso: Θ(n²).
- Peor caso: Θ(n²).
- Caso promedio: Θ(n²).
- Espacio auxiliar: O(1).

Se utilizará la versión tradicional sin finalización anticipada, para mostrar todas las pasadas del algoritmo.

**Requisitos:**

- Crear `Ejercicio1.java` dentro de `TP3-Ordenamiento/src`, verificando primero la estructura real del proyecto.
- Implementar Bubble Sort manualmente mediante dos ciclos `for` anidados.
- Ordenar los números de menor a mayor.
- Mostrar el arreglo original antes del ordenamiento.
- Mostrar el estado completo del arreglo después de cada pasada del ciclo externo, indicando el número de pasada.
- Incorporar comentarios que expliquen las comparaciones, los intercambios y por qué el elemento mayor se desplaza hacia el final.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Implementar un método `bubbleSort(int[] arreglo)`.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{5, 3, 8, 2}`.
- Verificar que las pasadas del ejemplo produzcan `{3, 5, 2, 8}`, `{3, 2, 5, 8}` y `{2, 3, 5, 8}`.
- Probar arreglos ordenados, inversamente ordenados, con números negativos, repetidos, vacíos y de un único elemento.
- Manejar explícitamente arreglos nulos.
- Verificar que el arreglo final esté correctamente ordenado.
- Compilar y ejecutar con Java 21, informando los resultados de las pruebas.

No modificar ejercicios anteriores ni realizar commits o push.
*/
public class Ejercicio1 {

    public static void bubbleSort(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        System.out.print("Arreglo original: ");
        mostrarArreglo(arreglo);
        for (int pasada = 0; pasada < arreglo.length - 1; pasada++) {
            // Cada pasada deja el mayor pendiente en su posicion definitiva.
            // Reducimos el limite porque las ultimas posiciones ya estan ordenadas.
            for (int i = 0; i < arreglo.length - 1 - pasada; i++) {
                // Comparamos vecinos e intercambiamos si estan en orden incorrecto.
                // Asi los valores mayores avanzan hacia el final.
                if (arreglo[i] > arreglo[i + 1]) {
                    int temporal = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temporal;
                }
            }
            // Se muestran todas las pasadas, incluso cuando no hay intercambios.
            System.out.print("Pasada " + (pasada + 1) + ": ");
            mostrarArreglo(arreglo);
        }
        System.out.print("Arreglo ordenado: ");
        mostrarArreglo(arreglo);
    }

    private static void mostrarArreglo(int[] arreglo) {
        System.out.print("{");
        for (int i = 0; i < arreglo.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arreglo[i]);
        }
        System.out.println("}");
    }

    // Sin finalizacion anticipada: mejor, peor y promedio Theta(n^2).
    // Mostrar cada pasada tambien tiene costo cuadratico total. Espacio O(1).
    public static void main(String[] args) {
        System.out.println("Ejemplo principal:");
        bubbleSort(new int[]{5, 3, 8, 2});
        System.out.println("Ya ordenado:");
        bubbleSort(new int[]{1, 2, 3, 4});
        System.out.println("Orden inverso:");
        bubbleSort(new int[]{4, 3, 2, 1});
        System.out.println("Negativos:");
        bubbleSort(new int[]{-1, -5, 0, -3});
        System.out.println("Repetidos:");
        bubbleSort(new int[]{3, 1, 3, 1});
        System.out.println("Vacio:");
        bubbleSort(new int[0]);
        System.out.println("Un elemento:");
        bubbleSort(new int[]{7});
        try {
            bubbleSort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
    }
}
