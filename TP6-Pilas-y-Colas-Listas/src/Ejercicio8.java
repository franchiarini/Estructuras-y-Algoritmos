/*
Implementar en Java un programa que invierta una palabra utilizando una pila enlazada de caracteres, construida manualmente mediante nodos.

**Estructura y justificación:** utilizar una pila LIFO, ya que el último carácter ingresado debe ser el primero en salir. Apilar los caracteres de izquierda a derecha y desapilarlos permite obtener la palabra en orden inverso.

**Clases:**

- `Ejercicio8`: clase pública con `main` y método `static String invertirPalabra(String palabra)`.
- `Nodo`: almacena un `char` y una referencia al siguiente nodo.
- `PilaCaracteres`: administra `head` e implementa `push(char)`, `pop()` e `isEmpty()`.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio8`.

**Algoritmo:**

1. Validar que `palabra` no sea `null`; si lo es, lanzar `IllegalArgumentException`.
2. Recorrer la cadena de izquierda a derecha y ejecutar `push()` con cada carácter.
3. Crear un `StringBuilder` para formar el resultado.
4. Mientras la pila no esté vacía, ejecutar `pop()` y agregar el carácter retirado al resultado.
5. Devolver la cadena invertida.

**Manejo de referencias:** `push()` inserta un nodo al inicio mediante `nuevo.siguiente = head` y `head = nuevo`. `pop()` retira el tope avanzando `head = head.siguiente`. Ambas operaciones deben ser O(1), sin recorrer la pila.

**Casos especiales:** cadena vacía, un solo carácter, caracteres repetidos, palíndromos, números, mayúsculas y minúsculas. Conservar todos los caracteres, incluidos espacios y signos, si aparecen en la entrada. Aclarar que se invierten unidades `char` de Java; no implementar tratamiento adicional de caracteres Unicode compuestos, que excede la consigna.

**Complejidad:** O(n) de tiempo y O(n) de espacio auxiliar para una cadena de longitud n, por los nodos y el resultado construido. Cada `push`, `pop` e `isEmpty` cuesta O(1).

**Ejemplos y pruebas:**

- `"algoritmo"` → `"omtirogla"`.
- `"HOLA"` → `"ALOH"`.
- `"ana"` → `"ana"`.
- `"a"` → `"a"`.
- `""` → `""`.
- `"12345"` → `"54321"`.
- `"a b"` → `"b a"`.
- `null` → `IllegalArgumentException`.

Verificar que invertir dos veces restaura la cadena original para los ejemplos compatibles con `char`, que no se pierden caracteres y que la pila queda vacía después de construir el resultado.

**Restricciones:** implementar manualmente la pila mediante nodos, sin `Stack`, `Deque`, `LinkedList`, arreglos auxiliares ni otras colecciones. No utilizar `StringBuilder.reverse()`, `Collections.reverse()`, recursividad ni recorrer la palabra directamente desde el final para resolver la inversión. No depender de otros ejercicios ni modificar archivos anteriores.

Compilar individualmente y conjuntamente con los ejercicios 1 al 7 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No realizar commits ni push.
*/
public class Ejercicio8 {
    public static class Nodo {
        private final char dato;
        private Nodo siguiente;
        public Nodo(char dato) { this.dato = dato; siguiente = null; }
    }
    public static class PilaCaracteres {
        private Nodo head = null;
        public void push(char dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = head; // Preservar la cadena anterior antes de cambiar el tope.
            head = nuevo;
        }
        public char pop() {
            if (isEmpty()) throw new IllegalStateException("Pila vacia.");
            char dato = head.dato;
            head = head.siguiente;
            return dato;
        }
        public boolean isEmpty() { return head == null; }
    }
    public static String invertirPalabra(String palabra) {
        if (palabra == null) throw new IllegalArgumentException("La palabra no puede ser nula.");
        PilaCaracteres pila = new PilaCaracteres();
        // Se invierten unidades char de Java, sin tratamiento adicional de Unicode compuesto.
        for (int i = 0; i < palabra.length(); i++) pila.push(palabra.charAt(i));
        StringBuilder resultado = new StringBuilder();
        // LIFO: el ultimo caracter ingresado se agrega primero al resultado.
        while (!pila.isEmpty()) resultado.append(pila.pop());
        // Al salir, head es null: se retiraron todos los nodos.
        return resultado.toString();
    }
    public static void main(String[] args) {
        for (String palabra : new String[]{"algoritmo", "HOLA", "ana", "a", "", "12345", "a b"}) {
            System.out.println("Original: \"" + palabra + "\"; invertida: \"" + invertirPalabra(palabra) + "\"");
        }
        try { invertirPalabra(null); }
        catch (IllegalArgumentException e) { System.out.println("Entrada null: " + e.getMessage()); }
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
