/*
Implementá en Java una función recursiva que calcule la suma de los dígitos de un número entero no negativo.

**Estrategia:** utilizar el operador módulo `%` para obtener el último dígito y la división entera `/ 10` para eliminarlo en cada llamada recursiva.

**Justificación:** un número puede descomponerse en su último dígito y los dígitos restantes. Esto permite sumar el último dígito al resultado obtenido recursivamente del número reducido.

**Caso base:** cuando `n < 10`, devolver n, porque un número de una sola cifra tiene como suma de sus dígitos su propio valor.

**Caso recursivo:** cuando `n >= 10`, devolver `n % 10 + sumarDigitos(n / 10)`.

**Reducción del problema:** dividir n entre 10 mediante división entera, eliminando el último dígito en cada llamada hasta alcanzar un número menor que 10.

**Complejidad:**

- Temporal: Θ(log₁₀ n), para n >= 10.
- Espacial auxiliar: O(log₁₀ n), debido a la pila de llamadas.
- Para n entre 0 y 9, ambas complejidades son Θ(1).

**Requisitos:**

- Crear `Ejercicio7.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `sumarDigitos(int n)` que devuelva un `int`.
- Utilizar exclusivamente operaciones de módulo, división entera y llamadas recursivas para calcular la suma.
- No utilizar ciclos `for` ni `while` dentro del algoritmo.
- No convertir el número a `String` ni utilizar métodos predefinidos para procesar sus dígitos.
- Manejar números negativos mediante `IllegalArgumentException`.
- Considerar que sumar los dígitos de cero devuelve cero.
- Incorporar comentarios que expliquen el caso base, el caso recursivo y cómo se combinan los resultados al regresar por la pila de llamadas.
- Incluir un método `main` con ejemplos.
- Probar sumarDigitos(0), sumarDigitos(5), sumarDigitos(10), sumarDigitos(5832), sumarDigitos(9999), sumarDigitos(10000) y sumarDigitos(2147483647).
- Verificar que los resultados sean respectivamente 0, 5, 1, 18, 36, 1 y 46.
- Probar entradas negativas y comprobar que sean rechazadas correctamente.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio7 {

    public static int sumarDigitos(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo.");
        }

        // Caso base: una sola cifra devuelve su valor, incluido el cero.
        if (n < 10) {
            return n;
        }

        // El modulo obtiene el ultimo digito y la division entera lo elimina.
        // Cada llamada espera en la pila la suma de los digitos restantes.
        // Al retornar, agrega el ultimo digito y combina los resultados pendientes.
        return n % 10 + sumarDigitos(n / 10);
    }

    // Para n >= 10: tiempo Theta(log10 n) y espacio O(log10 n).
    // Para valores de 0 a 9: tiempo y espacio Theta(1).
    public static void main(String[] args) {
        System.out.println("sumarDigitos(0) = " + sumarDigitos(0));
        System.out.println("sumarDigitos(5) = " + sumarDigitos(5));
        System.out.println("sumarDigitos(10) = " + sumarDigitos(10));
        System.out.println("sumarDigitos(5832) = " + sumarDigitos(5832));
        System.out.println("sumarDigitos(9999) = " + sumarDigitos(9999));
        System.out.println("sumarDigitos(10000) = " + sumarDigitos(10000));
        System.out.println("sumarDigitos(2147483647) = " + sumarDigitos(2147483647));

        try {
            sumarDigitos(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("sumarDigitos(-1): " + e.getMessage());
        }
    }
}
