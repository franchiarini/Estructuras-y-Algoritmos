/*
Implementá en Java una función recursiva que calcule el factorial de un número natural.

**Estrategia:** utilizar recursividad, expresando el factorial de n como n multiplicado por el factorial de n - 1.

**Justificación:** el factorial puede resolverse recursivamente porque el resultado de un número depende del factorial del número inmediatamente anterior, hasta alcanzar un caso sencillo que conocemos.

**Caso base:** cuando n vale 0 o 1, devolver 1, porque matemáticamente 0! = 1 y 1! = 1.

**Caso recursivo:** devolver `n * factorial(n - 1)` cuando n sea mayor que 1.

**Reducción del problema:** en cada llamada se disminuye n en una unidad, acercándose progresivamente al caso base.

**Complejidad:**

- Temporal: Θ(n).
- Espacial auxiliar: O(n), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio1.java` dentro de `TP2-Recursividad/src`, verificando primero la estructura real del proyecto.
- Implementar un método recursivo `factorial(int n)`.
- Utilizar `long` como tipo de retorno, para calcular correctamente factoriales hasta 20!.
- No utilizar ciclos `for` ni `while` para calcular el factorial.
- No utilizar bibliotecas que reemplacen el algoritmo recursivo.
- Manejar números negativos mediante `IllegalArgumentException`.
- Rechazar valores mayores que 20, ya que producirían desbordamiento del tipo long.
- Incorporar comentarios explicando el caso base, el caso recursivo y cómo funciona la pila de llamadas.
- Incluir un método `main` con ejemplos que muestren los resultados.
- Probar factorial(0), factorial(1), factorial(4), factorial(5), factorial(10) y factorial(20), además de entradas negativas y mayores que 20.
- Compilar y ejecutar el código con Java 21 y verificar los resultados.

No modificar ejercicios anteriores ni realizar commits o push.
*/
public class Ejercicio1 {

    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("El numero debe estar entre 0 y 20.");
        }

        // Caso base: 0! y 1! valen 1; no se necesita otra llamada.
        if (n == 0 || n == 1) {
            return 1L;
        }

        // Caso recursivo: reducimos n en uno hasta alcanzar el caso base.
        // Cada llamada queda en la pila esperando el factorial anterior.
        // Al retornar, se realizan las multiplicaciones y se liberan las llamadas.
        return n * factorial(n - 1);
    }

    // Tiempo Theta(n) y espacio O(n) por la pila de llamadas.
    public static void main(String[] args) {
        System.out.println("0! = " + factorial(0));
        System.out.println("1! = " + factorial(1));
        System.out.println("4! = " + factorial(4));
        System.out.println("5! = " + factorial(5));
        System.out.println("10! = " + factorial(10));
        System.out.println("20! = " + factorial(20));

        try {
            factorial(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("factorial(-1): " + e.getMessage());
        }
        try {
            factorial(21);
        } catch (IllegalArgumentException e) {
            System.out.println("factorial(21): " + e.getMessage());
        }
    }
}
