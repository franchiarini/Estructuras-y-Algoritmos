/*
Implementá en Java una función recursiva que determine si una palabra es un palíndromo, es decir, si se lee igual desde ambos extremos.

**Estrategia:** comparar el primer carácter con el último. Si son iguales, continuar recursivamente con los caracteres interiores mediante dos índices que se acercan al centro.

**Justificación:** una palabra es palíndroma si sus caracteres extremos coinciden y la parte interior también es palíndroma. Si encontramos una diferencia, podemos finalizar inmediatamente porque ya sabemos que la palabra no cumple la condición.

**Caso base:** cuando `inicio >= fin`, devolver `true`, porque quedan cero o un carácter por comparar.

**Caso de diferencia:** si `palabra.charAt(inicio) != palabra.charAt(fin)`, devolver `false` inmediatamente.

**Caso recursivo:** cuando ambos caracteres coinciden, devolver el resultado de comparar las posiciones interiores, llamando a la función con `inicio + 1` y `fin - 1`.

**Reducción del problema:** en cada llamada se descartan los dos caracteres extremos y se reduce el intervalo de búsqueda hasta alcanzar el centro de la palabra.

**Complejidad:**

- Mejor caso: Θ(1), cuando los extremos son distintos.
- Peor caso: Θ(n), cuando es necesario comparar todos los pares.
- Espacio auxiliar: O(n), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio9.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método público `esPalindromo(String palabra)` y un método auxiliar recursivo que reciba la cadena y los índices `inicio` y `fin`.
- Utilizar exclusivamente recursividad para comprobar los caracteres, sin ciclos `for` ni `while`.
- No utilizar `StringBuilder.reverse()` ni métodos predefinidos que resuelvan directamente el problema.
- Comparar los caracteres respetando mayúsculas y minúsculas; no normalizar ni eliminar espacios.
- Considerar que una cadena vacía y una cadena de un solo carácter son palíndromos.
- Manejar entradas nulas mediante `IllegalArgumentException`.
- Incorporar comentarios que expliquen el caso base, la comparación de extremos, el caso recursivo y la pila de llamadas.
- Incluir un método `main` con ejemplos.
- Probar las palabras "radar", "reconocer", "oso", "casa" y "Java".
- Probar también cadenas vacías, de un carácter, con longitud par, con longitud impar y con caracteres repetidos.
- Verificar que la cadena original no se modifica.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio9 {

    public static boolean esPalindromo(String palabra) {
        if (palabra == null) {
            throw new IllegalArgumentException("La palabra no puede ser nula.");
        }
        return esPalindromo(palabra, 0, palabra.length() - 1);
    }

    private static boolean esPalindromo(String palabra, int inicio, int fin) {
        // Caso base: los indices se encuentran o se cruzan.
        // Esto tambien contempla las cadenas vacias y de un solo caracter.
        if (inicio >= fin) {
            return true;
        }

        // Comparamos literalmente: no cambiamos mayusculas ni quitamos espacios.
        if (palabra.charAt(inicio) != palabra.charAt(fin)) {
            return false; // La primera diferencia termina la comprobacion.
        }

        // Los extremos coinciden; comprobamos recursivamente el interior.
        // Cada llamada espera en la pila el resultado de la siguiente.
        // Al retornar, el booleano se propaga sin modificar la cadena original.
        return esPalindromo(palabra, inicio + 1, fin - 1);
    }

    // Mejor tiempo Theta(1), peor Theta(n), espacio auxiliar O(n).
    public static void main(String[] args) {
        System.out.println("radar: " + esPalindromo("radar"));
        System.out.println("reconocer: " + esPalindromo("reconocer"));
        System.out.println("oso: " + esPalindromo("oso"));
        System.out.println("casa: " + esPalindromo("casa"));
        System.out.println("Java: " + esPalindromo("Java"));
        System.out.println("Cadena vacia: " + esPalindromo(""));
        System.out.println("a: " + esPalindromo("a"));
        System.out.println("abba: " + esPalindromo("abba"));
        System.out.println("aaaa: " + esPalindromo("aaaa"));
        System.out.println("Radar: " + esPalindromo("Radar"));
        System.out.println("[ oso]: " + esPalindromo(" oso"));

        try {
            esPalindromo(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada nula: " + e.getMessage());
        }
    }
}
