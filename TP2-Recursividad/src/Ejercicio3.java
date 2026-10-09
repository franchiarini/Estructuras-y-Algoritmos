/*
Implementá en Java una función recursiva que permita multiplicar dos números enteros mediante sumas repetidas, sin utilizar el operador de multiplicación `*`.

**Estrategia:** interpretar la multiplicación como la suma repetida del primer factor. Mantener constante el parámetro `a` y disminuir el segundo parámetro `b` en cada llamada recursiva.

**Justificación:** una multiplicación puede representarse como sumas sucesivas. Por ejemplo, multiplicar 4 por 3 equivale a sumar 4 tres veces. Esto permite reducir progresivamente el problema hasta llegar a una multiplicación por cero.

**Caso base:** cuando `b == 0`, devolver 0, porque cualquier número multiplicado por cero es igual a cero.

**Caso recursivo:** cuando `b > 0`, devolver `a + multiplicar(a, b - 1)`.

**Reducción del problema:** en cada llamada disminuye `b` en una unidad, hasta llegar al caso base, mientras `a` permanece constante.

**Complejidad:**

- Temporal: Θ(b + 1), siendo b el segundo factor no negativo.
- Espacial auxiliar: O(b + 1), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio3.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar el método recursivo `multiplicar(int a, int b)` con retorno `long`.
- Utilizar exclusivamente sumas y llamadas recursivas para calcular la multiplicación.
- No utilizar el operador `*`, ciclos `for`, `while` ni métodos predefinidos de multiplicación dentro del algoritmo.
- Reducir exclusivamente el segundo parámetro `b`.
- Permitir que `a` sea positivo, negativo o cero.
- Admitir valores de `b` entre 0 y 1000, rechazando los negativos y superiores a 1000 mediante `IllegalArgumentException`, para evitar una profundidad de recursión excesiva.
- Incorporar comentarios que expliquen el caso base, el caso recursivo y el comportamiento de la pila de llamadas.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar multiplicar(4, 3), multiplicar(5, 0), multiplicar(0, 5), multiplicar(-4, 3), multiplicar(7, 1) y multiplicar(10, 10).
- Probar también valores grandes de `a`, incluyendo los extremos de `int`, para verificar que el resultado `long` sea correcto.
- Comprobar que los valores negativos y superiores a 1000 de `b` sean rechazados.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio3 {

    public static long multiplicar(int a, int b) {
        if (b < 0 || b > 1000) {
            throw new IllegalArgumentException("El segundo factor debe estar entre 0 y 1000.");
        }

        // Caso base: sumar el primer factor cero veces da cero.
        if (b == 0) {
            return 0L;
        }

        // Caso recursivo: a permanece constante y solo b disminuye.
        // Cada llamada espera en la pila el resultado de la siguiente.
        // Al retornar, se suma a y se libera la llamada pendiente.
        // El retorno long de la llamada hace que la suma se realice como long.
        return a + multiplicar(a, b - 1);
    }

    // Tiempo Theta(b + 1) y espacio O(b + 1) por la pila de llamadas.
    public static void main(String[] args) {
        System.out.println("multiplicar(4, 3) = " + multiplicar(4, 3));
        System.out.println("multiplicar(5, 0) = " + multiplicar(5, 0));
        System.out.println("multiplicar(0, 5) = " + multiplicar(0, 5));
        System.out.println("multiplicar(-4, 3) = " + multiplicar(-4, 3));
        System.out.println("multiplicar(7, 1) = " + multiplicar(7, 1));
        System.out.println("multiplicar(10, 10) = " + multiplicar(10, 10));
        System.out.println("multiplicar(Integer.MAX_VALUE, 1000) = "
                + multiplicar(Integer.MAX_VALUE, 1000));
        System.out.println("multiplicar(Integer.MIN_VALUE, 1000) = "
                + multiplicar(Integer.MIN_VALUE, 1000));

        try {
            multiplicar(4, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("multiplicar(4, -1): " + e.getMessage());
        }
        try {
            multiplicar(4, 1001);
        } catch (IllegalArgumentException e) {
            System.out.println("multiplicar(4, 1001): " + e.getMessage());
        }
    }
}
