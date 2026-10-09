/*
Implementá en Java una función recursiva que imprima un conteo regresivo desde un número entero n hasta cero.

**Estrategia:** utilizar una función recursiva de tipo `void` que imprima el número actual antes de llamar nuevamente a la función con un valor menor.

**Justificación:** el conteo regresivo puede resolverse recursivamente porque cada número da lugar al mismo problema con un valor reducido en una unidad, hasta llegar a cero. La función no necesita devolver un valor, ya que su propósito es imprimir números en pantalla.

**Caso base:** cuando `n == 0`, imprimir el número 0 y finalizar sin realizar otra llamada recursiva.

**Caso recursivo:** cuando `n > 0`, imprimir el valor actual y ejecutar `conteoRegresivo(n - 1)`.

**Reducción del problema:** disminuir n en una unidad en cada llamada hasta alcanzar el caso base. Si se utilizara `n + 1`, la función se alejaría de cero y podría producir un `StackOverflowError` por no alcanzar el caso base.

**Complejidad:**

- Temporal: Θ(n + 1), porque se imprimen todos los números desde n hasta cero.
- Espacial auxiliar: O(n + 1), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio5.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `conteoRegresivo(int n)` con retorno `void`.
- Imprimir los números desde n hasta cero, incluyendo ambos extremos.
- Utilizar exclusivamente recursividad, sin ciclos `for` ni `while` para generar el conteo.
- Manejar números negativos mediante `IllegalArgumentException`.
- Limitar n a un máximo de 1000 para evitar una profundidad de recursión excesiva.
- Incorporar comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
- Explicar mediante comentarios por qué se utiliza `void` y qué sucedería si se llamara con `n + 1`.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar conteoRegresivo(0), conteoRegresivo(1), conteoRegresivo(4), conteoRegresivo(5) y conteoRegresivo(10).
- Verificar que la secuencia impresa sea correcta, incluyendo el cero.
- Probar entradas negativas y superiores a 1000, verificando que se rechacen correctamente.
- No ejecutar intencionalmente una recursión infinita para demostrar el error.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio5 {

    // void indica que el metodo imprime la secuencia, sin devolver un valor.
    public static void conteoRegresivo(int n) {
        if (n < 0 || n > 1000) {
            throw new IllegalArgumentException("El numero debe estar entre 0 y 1000.");
        }

        // Caso base: imprimimos el cero y terminamos sin otra llamada.
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Caso recursivo: imprimimos antes de reducir el problema.
        System.out.println(n);
        // Cada llamada permanece en la pila hasta que la siguiente finaliza.
        // Al llegar a cero, las llamadas retornan y se liberan en orden inverso.
        // Con n + 1 nos alejariamos del caso base: sin limite de validacion,
        // podria ocurrir StackOverflowError. Aqui el limite rechazaria 1001.
        conteoRegresivo(n - 1);
    }

    // Tiempo Theta(n + 1); espacio auxiliar O(n + 1) por la pila.
    public static void main(String[] args) {
        System.out.println("Conteo desde 0:");
        conteoRegresivo(0);
        System.out.println("Conteo desde 1:");
        conteoRegresivo(1);
        System.out.println("Conteo desde 4:");
        conteoRegresivo(4);
        System.out.println("Conteo desde 5:");
        conteoRegresivo(5);
        System.out.println("Conteo desde 10:");
        conteoRegresivo(10);

        try {
            conteoRegresivo(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("conteoRegresivo(-1): " + e.getMessage());
        }
        try {
            conteoRegresivo(1001);
        } catch (IllegalArgumentException e) {
            System.out.println("conteoRegresivo(1001): " + e.getMessage());
        }
    }
}
