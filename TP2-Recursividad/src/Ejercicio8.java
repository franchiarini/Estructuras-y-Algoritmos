/*
Implementá en Java una función recursiva que invierta una palabra representada mediante un String.

**Estrategia:** separar el primer carácter de la cadena y resolver recursivamente la inversión del resto utilizando `substring(1)`. Cuando la llamada recursiva devuelva su resultado, agregar el primer carácter al final.

**Justificación:** una palabra puede invertirse resolviendo primero la inversión de una cadena más pequeña y colocando después el carácter que se separó inicialmente. Este procedimiento permite construir el resultado en orden inverso durante el retorno de las llamadas.

**Caso base:** cuando la cadena está vacía o contiene un único carácter, devolverla directamente porque ya está invertida.

**Caso recursivo:** devolver `invertir(palabra.substring(1)) + palabra.charAt(0)`.

**Reducción del problema:** en cada llamada se elimina el primer carácter, reduciendo la longitud de la cadena en una unidad hasta alcanzar el caso base.

**Complejidad:**

- Temporal: O(n²), debido a las operaciones de substring y concatenación de cadenas.
- Espacial auxiliar: O(n²), considerando las cadenas intermedias generadas durante la recursión y la pila de llamadas.

**Requisitos:**

- Crear `Ejercicio8.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `invertir(String palabra)` que devuelva un `String`.
- Utilizar `substring(1)` y `charAt(0)` para construir la solución recursiva.
- No utilizar ciclos `for` ni `while` dentro del algoritmo.
- No utilizar `StringBuilder.reverse()` ni métodos predefinidos para invertir cadenas.
- Considerar como casos base las cadenas vacías y las cadenas de un carácter.
- Manejar entradas nulas mediante `IllegalArgumentException`.
- Incorporar comentarios explicando el caso base, el caso recursivo y el funcionamiento de la pila de llamadas.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar invertir("HOLA"), invertir("Java"), invertir("recursion"), invertir("a") e invertir("").
- Verificar los resultados esperados: "ALOH", "avaJ", "noisrucer", "a" y "".
- Probar también palabras palíndromas, cadenas con espacios y caracteres repetidos.
- Verificar que el String original no se modifica.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio8 {

    public static String invertir(String palabra) {
        if (palabra == null) {
            throw new IllegalArgumentException("La palabra no puede ser nula.");
        }

        // Caso base: una cadena vacia o de un solo caracter ya esta invertida.
        if (palabra.length() <= 1) {
            return palabra;
        }

        // Caso recursivo: quitamos el primer caracter y reducimos la longitud.
        // Cada llamada espera en la pila la inversion de la subcadena.
        // Al retornar, agrega el primer caracter al final y construye el inverso.
        // String es inmutable: estas operaciones no modifican el original.
        return invertir(palabra.substring(1)) + palabra.charAt(0);
    }

    // Tiempo O(n^2) y espacio auxiliar O(n^2) por las cadenas intermedias
    // y la pila de llamadas; n es la longitud de la cadena.
    public static void main(String[] args) {
        System.out.println("HOLA -> " + invertir("HOLA"));
        System.out.println("Java -> " + invertir("Java"));
        System.out.println("recursion -> " + invertir("recursion"));
        System.out.println("a -> " + invertir("a"));
        System.out.println("Cadena vacia -> [" + invertir("") + "]");
        System.out.println("reconocer -> " + invertir("reconocer"));
        System.out.println("hola mundo -> " + invertir("hola mundo"));
        System.out.println("aabb -> " + invertir("aabb"));

        try {
            invertir(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada nula: " + e.getMessage());
        }
    }
}
