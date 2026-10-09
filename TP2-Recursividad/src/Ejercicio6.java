/*
Implementá en Java una función recursiva que cuente la cantidad de dígitos de un número entero no negativo.

**Estrategia:** utilizar división entera sucesiva por 10 para eliminar el último dígito del número en cada llamada recursiva.

**Justificación:** un número puede descomponerse eliminando progresivamente su último dígito. Cada división entera por 10 reduce la cantidad de dígitos hasta llegar a un número de una sola cifra.

**Caso base:** cuando `n < 10`, devolver 1, ya que cualquier número entero no negativo menor que 10 tiene un solo dígito.

**Caso recursivo:** cuando `n >= 10`, devolver `1 + contarDigitos(n / 10)`.

**Reducción del problema:** dividir n por 10 utilizando división entera. Esto elimina el último dígito y acerca el problema al caso base.

**Complejidad:**

- Temporal: Θ(log₁₀ n) para n >= 10, porque se elimina un dígito en cada llamada.
- Espacial auxiliar: O(log₁₀ n), debido a la pila de llamadas.
- Para n entre 0 y 9, ambas complejidades son Θ(1).

**Requisitos:**

- Crear `Ejercicio6.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `contarDigitos(int n)` que devuelva un `int`.
- Utilizar división entera por 10 y llamadas recursivas.
- No utilizar ciclos `for` ni `while` para contar los dígitos.
- No convertir el número a `String` ni utilizar métodos predefinidos para obtener su longitud.
- Manejar números negativos mediante `IllegalArgumentException`.
- Considerar que el número cero tiene un dígito.
- Incorporar comentarios explicando el caso base, el caso recursivo y cómo funciona la pila de llamadas.
- Incluir un método `main` con ejemplos.
- Probar contarDigitos(0), contarDigitos(5), contarDigitos(10), contarDigitos(5832), contarDigitos(10000) y contarDigitos(2147483647).
- Verificar que los resultados sean respectivamente 1, 1, 2, 4, 5 y 10.
- Probar entradas negativas y comprobar que se rechacen correctamente.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio6 {

    public static int contarDigitos(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero no puede ser negativo.");
        }

        // Caso base: los valores de 0 a 9 tienen un digito, incluido el cero.
        if (n < 10) {
            return 1;
        }

        // Caso recursivo: la division entera por 10 elimina el ultimo digito.
        // Cada llamada espera en la pila el conteo del numero reducido.
        // Al retornar se suma el digito eliminado y se libera la llamada.
        return 1 + contarDigitos(n / 10);
    }

    // Para n >= 10: tiempo Theta(log10 n) y espacio O(log10 n).
    // Para valores de 0 a 9: tiempo y espacio Theta(1).
    public static void main(String[] args) {
        System.out.println("contarDigitos(0) = " + contarDigitos(0));
        System.out.println("contarDigitos(5) = " + contarDigitos(5));
        System.out.println("contarDigitos(10) = " + contarDigitos(10));
        System.out.println("contarDigitos(5832) = " + contarDigitos(5832));
        System.out.println("contarDigitos(10000) = " + contarDigitos(10000));
        System.out.println("contarDigitos(2147483647) = " + contarDigitos(2147483647));

        try {
            contarDigitos(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("contarDigitos(-1): " + e.getMessage());
        }
    }
}
