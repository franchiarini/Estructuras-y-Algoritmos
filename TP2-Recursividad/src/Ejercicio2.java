/*
Implementá en Java una función recursiva que calcule la suma de los primeros N números naturales, desde n hasta 1.

**Estrategia:** utilizar recursividad para descomponer la suma de los primeros n números en el valor n más la suma de los números anteriores.

**Justificación:** la suma puede resolverse recursivamente porque `suma(n)` equivale a `n + suma(n - 1)`. De esta manera, cada llamada resuelve una parte del problema y delega el resto a una versión más pequeña de la misma función.

**Caso base:** cuando `n == 0`, devolver 0, porque no quedan números por sumar.

**Caso recursivo:** cuando `n > 0`, devolver `n + suma(n - 1)`.

**Reducción del problema:** en cada llamada se disminuye n en una unidad hasta alcanzar el caso base.

**Complejidad:**

- Temporal: Θ(n), porque se realizan n llamadas recursivas más el caso base.
- Espacial auxiliar: O(n), debido a la pila de llamadas.

**Requisitos:**

- Crear `Ejercicio2.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `suma(int n)` que devuelva un `long`.
- Utilizar exclusivamente recursividad para calcular la suma, sin ciclos `for` ni `while`.
- No utilizar la fórmula matemática `n * (n + 1) / 2` como implementación, ya que el objetivo es demostrar la recursividad. Puede utilizarse para verificar los resultados.
- Manejar los números negativos mediante `IllegalArgumentException`.
- Establecer un límite superior conservador de `n = 1000` para evitar una pila de llamadas excesivamente profunda.
- Incluir comentarios explicativos sobre el caso base, el caso recursivo y el funcionamiento del Call Stack.
- Incorporar un método `main` con ejemplos.
- Probar suma(0), suma(1), suma(4), suma(5), suma(10), suma(100) y suma(1000).
- Verificar que suma(5) devuelva 15 y suma(100) devuelva 5050.
- Probar entradas negativas y mayores que 1000, verificando que se rechacen correctamente.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio2 {

    public static long suma(int n) {
        if (n < 0 || n > 1000) {
            throw new IllegalArgumentException("El numero debe estar entre 0 y 1000.");
        }

        // Caso base: no quedan numeros por sumar.
        if (n == 0) {
            return 0L;
        }

        // Caso recursivo: disminuimos n en uno hasta llegar a cero.
        // Cada llamada queda en el Call Stack esperando el resultado anterior.
        // Al retornar, se suman los valores pendientes y se liberan las llamadas.
        return n + suma(n - 1);
    }

    // Tiempo Theta(n); espacio auxiliar O(n) por la pila de llamadas.
    public static void main(String[] args) {
        System.out.println("suma(0) = " + suma(0));
        System.out.println("suma(1) = " + suma(1));
        System.out.println("suma(4) = " + suma(4));
        System.out.println("suma(5) = " + suma(5));
        System.out.println("suma(10) = " + suma(10));
        System.out.println("suma(100) = " + suma(100));
        System.out.println("suma(1000) = " + suma(1000));

        try {
            suma(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("suma(-1): " + e.getMessage());
        }
        try {
            suma(1001);
        } catch (IllegalArgumentException e) {
            System.out.println("suma(1001): " + e.getMessage());
        }
    }
}
