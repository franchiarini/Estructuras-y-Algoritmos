/*
Implementá en Java una función recursiva que calcule la potencia de un número entero, sin utilizar `Math.pow()`.

**Estrategia:** representar una potencia como multiplicaciones sucesivas de la base. Utilizar recursividad, manteniendo constante la base y disminuyendo el exponente en cada llamada.

**Justificación:** una potencia puede expresarse como la multiplicación de una base por sí misma tantas veces como indique el exponente. Esto permite dividir el problema en una multiplicación y una potencia con exponente menor.

**Caso base:** cuando `exponente == 0`, devolver 1, porque toda base distinta de cero elevada a cero es igual a uno. Para esta implementación también se adopta la convención de devolver 1 cuando base y exponente son ambos cero.

**Caso recursivo:** cuando `exponente > 0`, devolver `base * potencia(base, exponente - 1)`.

**Reducción del problema:** disminuir el exponente en una unidad por cada llamada, manteniendo constante la base hasta alcanzar el caso base.

**Complejidad:**

- Temporal: Θ(n + 1), siendo n el exponente no negativo.
- Espacial auxiliar: O(n + 1), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio4.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar el método recursivo `potencia(int base, int exponente)` con retorno `long`.
- Utilizar multiplicaciones sucesivas y llamadas recursivas, sin ciclos `for` ni `while` dentro del algoritmo.
- No utilizar `Math.pow()` ni otros métodos predefinidos de potenciación.
- Manejar exponentes negativos mediante `IllegalArgumentException`.
- Verificar que las multiplicaciones no produzcan desbordamiento del tipo `long`, utilizando `Math.multiplyExact()` para detectar el error si resulta necesario.
- Limitar el exponente a un máximo de 1000 para evitar una profundidad excesiva de recursión.
- Incorporar comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
- Incluir un método `main` con ejemplos que muestren los resultados.
- Probar potencia(2, 4), potencia(3, 3), potencia(5, 0), potencia(0, 5), potencia(-2, 3), potencia(-2, 4) y potencia(1, 1000).
- Probar también exponentes negativos, valores que produzcan desbordamiento y el caso potencia(0, 0).
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio4 {

    public static long potencia(int base, int exponente) {
        if (exponente < 0 || exponente > 1000) {
            throw new IllegalArgumentException("El exponente debe estar entre 0 y 1000.");
        }

        // Caso base: toda potencia de exponente cero devuelve 1.
        // Se incluye la convencion adoptada para cero elevado a cero.
        if (exponente == 0) {
            return 1L;
        }

        // Caso recursivo: la base permanece constante y el exponente disminuye.
        // Cada llamada espera en la pila el resultado de la potencia anterior.
        // Al retornar se multiplica y se libera la llamada pendiente.
        // multiplyExact lanza ArithmeticException si el resultado no cabe en long.
        return Math.multiplyExact((long) base, potencia(base, exponente - 1));
    }

    // Tiempo Theta(n + 1), espacio O(n + 1), siendo n el exponente.
    public static void main(String[] args) {
        System.out.println("potencia(2, 4) = " + potencia(2, 4));
        System.out.println("potencia(3, 3) = " + potencia(3, 3));
        System.out.println("potencia(5, 0) = " + potencia(5, 0));
        System.out.println("potencia(0, 5) = " + potencia(0, 5));
        System.out.println("potencia(-2, 3) = " + potencia(-2, 3));
        System.out.println("potencia(-2, 4) = " + potencia(-2, 4));
        System.out.println("potencia(1, 1000) = " + potencia(1, 1000));
        System.out.println("potencia(0, 0) = " + potencia(0, 0));

        try {
            potencia(2, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("potencia(2, -1): " + e.getMessage());
        }
        try {
            potencia(1, 1001);
        } catch (IllegalArgumentException e) {
            System.out.println("potencia(1, 1001): " + e.getMessage());
        }
        try {
            potencia(2, 63);
        } catch (ArithmeticException e) {
            System.out.println("potencia(2, 63): desbordamiento de long.");
        }
    }
}
