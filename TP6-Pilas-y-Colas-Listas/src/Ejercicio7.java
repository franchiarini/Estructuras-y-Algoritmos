/*
Implementar en Java un verificador que determine si los paréntesis `(` y `)` de una expresión están correctamente balanceados, utilizando una pila enlazada construida desde cero.

**Estructura y justificación:** utilizar una pila de caracteres implementada mediante nodos, con `head` como tope. La pila es adecuada porque el último paréntesis abierto debe ser el primero en cerrarse (LIFO).

**Clases:**

- `Ejercicio7`: clase pública con `main` y método `static boolean estanBalanceados(String expresion)`.
- `Nodo`: almacena un `char` y una referencia al siguiente nodo.
- `PilaCaracteres`: administra `head` e implementa `push(char)`, `pop()` e `isEmpty()`.

Implementar las clases auxiliares como estáticas anidadas dentro de `Ejercicio7`.

**Algoritmo:**

1. Validar que la expresión no sea `null`; lanzar `IllegalArgumentException` si lo es.
2. Recorrer sus caracteres de izquierda a derecha.
3. Si aparece `(`, apilarlo mediante `push`.
4. Si aparece `)`, verificar si la pila está vacía. Si está vacía, devolver `false`; si no, retirar una apertura con `pop`.
5. Ignorar letras, números, espacios y operadores, porque solamente se evalúan paréntesis.
6. Al finalizar, devolver `true` únicamente si la pila está vacía.

**Manejo de referencias:** implementar `push` y `pop` modificando exclusivamente `head`, en O(1), sin recorrer ni copiar la pila. Mantener todos los nodos correctamente enlazados durante el proceso, sin ciclos ni pérdidas.

**Casos especiales:** expresión vacía (balanceada), expresión sin paréntesis (balanceada), paréntesis anidados, varios grupos separados, cierres sin apertura, aperturas sin cierre y expresiones mal ordenadas. Una expresión inválida no debe producir una extracción sobre una pila vacía.

**Complejidad:** O(n) de tiempo para una expresión de n caracteres y O(n) de espacio auxiliar en el peor caso por los nodos de apertura almacenados. Cada `push`, `pop` e `isEmpty` cuesta O(1).

**Ejemplos y pruebas:**

- `(2 + 3) * (5 - 1)` → `true`.
- `((a + b) * c)` → `true`.
- `(2 + 3` → `false`.
- `())(` → `false`.
- `)(` → `false`.
- `()` y `(()())` → `true`.
- `(()` y `())` → `false`.
- `""` y `"a + b"` → `true`.

Incluir pruebas adicionales con expresiones largas, aperturas consecutivas, cierres consecutivos, `null` y caracteres no relacionados con paréntesis.

**Restricciones:** implementar manualmente la pila enlazada, sin `Stack`, `Deque`, `LinkedList`, arreglos auxiliares ni otras colecciones para administrar los paréntesis. No usar recursividad ni depender de otros ejercicios. No modificar archivos anteriores ni realizar commits o push.

Compilar individualmente y conjuntamente con los ejercicios 1 al 6 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas.
*/
public class Ejercicio7 {
    public static class Nodo {
        private final char dato;
        private Nodo siguiente;
        public Nodo(char dato) { this.dato = dato; siguiente = null; }
    }
    public static class PilaCaracteres {
        private Nodo head = null;
        public void push(char dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = head; // Preservar el tope anterior antes de actualizar head.
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
    public static boolean estanBalanceados(String expresion) {
        if (expresion == null) throw new IllegalArgumentException("La expresion no puede ser nula.");
        PilaCaracteres pila = new PilaCaracteres();
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(') pila.push(caracter);
            else if (caracter == ')') {
                // No extraer si no existe una apertura pendiente.
                if (pila.isEmpty()) return false;
                pila.pop(); // LIFO: cerrar la ultima apertura pendiente.
            }
            // Los demas caracteres no intervienen en la validacion.
        }
        return pila.isEmpty(); // Si quedan aperturas, faltan cierres.
    }
    public static void main(String[] args) {
        String[] expresiones = {"(2 + 3) * (5 - 1)", "((a + b) * c)", "(2 + 3", "())(",
                ")(", "()", "(()())", "(()", "())", "", "a + b"};
        for (String expresion : expresiones) {
            System.out.println("Expresion: \"" + expresion + "\"; balanceada: " + estanBalanceados(expresion));
        }
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
