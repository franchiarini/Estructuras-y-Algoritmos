/*
Implementá en Java una función recursiva que busque un número entero dentro de un arreglo, sin utilizar ciclos.

**Estrategia:** utilizar búsqueda lineal recursiva, comenzando desde el índice 0 y avanzando de una posición a la siguiente mediante llamadas recursivas.

**Justificación:** podemos recorrer un arreglo recursivamente porque, después de examinar una posición, el problema se reduce a buscar el elemento en las posiciones restantes. No necesitamos utilizar ciclos, ya que cada llamada recursiva reemplaza una iteración.

**Caso base 1 — Elemento encontrado:** si el elemento ubicado en el índice actual coincide con el valor buscado, devolver ese índice inmediatamente.

**Caso base 2 — Fin del arreglo:** si el índice alcanza la longitud del arreglo, devolver -1, indicando que el valor no fue encontrado.

**Caso recursivo:** si el elemento actual no coincide, llamar nuevamente a la función aumentando el índice en una unidad.

**Reducción del problema:** comenzar en la primera posición y avanzar mediante `indice + 1`, reduciendo la cantidad de elementos pendientes de revisar hasta encontrar una coincidencia o llegar al final.

**Complejidad:**

- Mejor caso: Θ(1), si el elemento está en la primera posición.
- Peor caso: Θ(n), si está al final o no existe.
- Caso promedio: Θ(n), suponiendo que el elemento buscado puede estar en cualquiera de las posiciones con igual probabilidad.
- Espacio auxiliar: O(n), debido a la pila de llamadas recursivas en el peor caso.

**Requisitos:**

- Crear `Ejercicio10.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método público `buscar(int[] arreglo, int valor)` y un método auxiliar recursivo que reciba el arreglo, el valor buscado y el índice actual.
- Comenzar siempre la búsqueda desde el índice 0.
- No utilizar ciclos `for`, `while` ni métodos predefinidos de búsqueda dentro del algoritmo.
- Devolver el índice de la primera aparición del elemento o -1 si no existe.
- Verificar primero si se alcanzó el final del arreglo, para evitar accesos fuera de sus límites.
- Finalizar inmediatamente al encontrar el valor buscado.
- Considerar que un arreglo vacío devuelve -1.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Incorporar comentarios que expliquen los dos casos base, el caso recursivo, la reducción del problema y el funcionamiento de la pila de llamadas.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar un valor al inicio, en el medio, al final, inexistente y repetido.
- Probar también arreglos vacíos, de un único elemento, números negativos y extremos de `int`.
- Verificar que el arreglo original no se modifica.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio10 {

    public static int buscar(int[] arreglo, int valor) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        // Toda busqueda comienza desde la primera posicion.
        return buscar(arreglo, valor, 0);
    }

    private static int buscar(int[] arreglo, int valor, int indice) {
        // Caso base: comprobar el final antes de acceder evita salir del arreglo.
        // Un arreglo vacio llega aqui inmediatamente.
        if (indice == arreglo.length) {
            return -1;
        }

        // Caso base: la primera coincidencia termina la busqueda.
        if (arreglo[indice] == valor) {
            return indice;
        }

        // Caso recursivo: avanzar reduce las posiciones pendientes en una unidad.
        // Cada llamada espera en la pila el resultado de la siguiente.
        // Al retornar, se propaga el indice encontrado o -1 sin modificar el arreglo.
        return buscar(arreglo, valor, indice + 1);
    }

    // Mejor tiempo Theta(1); peor y promedio Theta(n), con posiciones equiprobables.
    // Espacio auxiliar O(n) por la pila de llamadas en el peor caso.
    public static void main(String[] args) {
        int[] arreglo = {8, 3, 12, 1, 3, 6};
        System.out.println("Arreglo: {8, 3, 12, 1, 3, 6}");
        System.out.println("Inicio, buscar 8: " + buscar(arreglo, 8));
        System.out.println("Medio, buscar 12: " + buscar(arreglo, 12));
        System.out.println("Final, buscar 6: " + buscar(arreglo, 6));
        System.out.println("Inexistente, buscar 10: " + buscar(arreglo, 10));
        System.out.println("Repetido, buscar 3: " + buscar(arreglo, 3));
        System.out.println("Vacio: " + buscar(new int[0], 8));
        System.out.println("Un elemento coincidente: " + buscar(new int[]{7}, 7));
        System.out.println("Un elemento distinto: " + buscar(new int[]{7}, 8));
        System.out.println("Negativos: " + buscar(new int[]{-5, -2, -1}, -2));
        System.out.println("Extremo minimo: "
                + buscar(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, Integer.MIN_VALUE));
        System.out.println("Extremo maximo: "
                + buscar(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, Integer.MAX_VALUE));

        try {
            buscar(null, 8);
        } catch (IllegalArgumentException e) {
            System.out.println("Arreglo nulo: " + e.getMessage());
        }
    }
}
