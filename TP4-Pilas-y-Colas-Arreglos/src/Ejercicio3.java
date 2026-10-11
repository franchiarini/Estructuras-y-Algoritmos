/*
Implementá en Java un programa que determine si los paréntesis de una expresión matemática están correctamente balanceados, utilizando una pila implementada manualmente mediante un arreglo de caracteres.

**Estructura elegida:** pila (Stack) de caracteres, que respeta el principio LIFO (Last In, First Out).

**Estrategia:** recorrer la expresión de izquierda a derecha, analizando sus caracteres. Cada vez que aparezca un paréntesis de apertura `(`, agregarlo a la pila mediante `push()`. Cuando aparezca un paréntesis de cierre `)`, retirar un paréntesis abierto mediante `pop()`. Si aparece un cierre cuando la pila está vacía, devolver inmediatamente `false`. Al finalizar el recorrido, devolver `true` solamente si la pila quedó vacía.

**Justificación:** el principio LIFO permite que cada paréntesis de cierre corresponda con el último paréntesis de apertura pendiente. Una pila resulta apropiada porque las aperturas anidadas deben cerrarse en el orden inverso al que se agregaron.

**Operaciones utilizadas:**
- `push(char parentesis)`: almacenar un paréntesis de apertura.
- `pop()`: retirar la apertura correspondiente cuando se encuentra un cierre.
- `isEmpty()`: comprobar si existen aperturas pendientes de cerrar.

**Casos especiales:**
- Un cierre `)` cuando la pila está vacía indica una expresión inválida.
- Si al finalizar quedan aperturas en la pila, la expresión es inválida.
- Si no quedan aperturas pendientes, la expresión es válida.
- Una expresión vacía se considera balanceada.
- Una expresión sin paréntesis se considera balanceada.
- Una entrada `null` debe rechazarse mediante `IllegalArgumentException`.
- El programa debe evaluar exclusivamente los paréntesis redondos `(` y `)`, tal como solicita la consigna. No necesita validar la sintaxis matemática ni otros tipos de delimitadores.

**Complejidad:**
- Tiempo: O(n), porque cada carácter se analiza una sola vez.
- Espacio auxiliar: O(n) en el peor caso, debido al arreglo utilizado para almacenar paréntesis abiertos.
- Las operaciones individuales `push()`, `pop()` e `isEmpty()` deben ejecutarse en O(1).

**Requisitos:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio3.java`.
- Implementar una clase pública `Ejercicio3` con un método `main`.
- Implementar un método `validarParentesis(String expresion)` que devuelva `boolean`.
- Implementar manualmente una pila auxiliar mediante `char[]` y una variable `top`, inicialmente igual a -1.
- La capacidad de la pila puede determinarse a partir de la longitud de la expresión, permitiendo también el caso de longitud cero.
- Incrementar `top` al agregar una apertura y disminuirlo al retirar una apertura.
- Evitar desbordamientos verificando los límites del arreglo antes de agregar elementos.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- No utilizar métodos de validación de paréntesis predefinidos.
- Ignorar los caracteres que no sean `(` o `)`, como números, espacios y operadores.
- Incluir comentarios que expliquen el principio LIFO, el uso del arreglo y de `top`, los casos inválidos y la comprobación final de pila vacía.
- Mostrar cada expresión evaluada y si sus paréntesis están balanceados.

**Ejemplos principales:**
1. `(5 + 3) * (2 + 1)` debe ser válida.
2. `(5 + 3)) * (2 + 1` debe ser inválida.
3. `((2 + 3) * (4 - 1))` debe ser válida.
4. `((5 + 3)` debe ser inválida.
5. `5 + 3` debe ser válida.
6. La cadena vacía debe ser válida.

**Pruebas adicionales:**
- Un único paréntesis de apertura.
- Un único paréntesis de cierre.
- Varios paréntesis anidados correctamente.
- Varios pares de paréntesis consecutivos.
- Más cierres que aperturas.
- Más aperturas que cierres.
- Un cierre que aparece antes de una apertura, como `)(`.
- Expresiones largas con anidamiento.
- Expresiones con letras, espacios y operadores.
- Entrada `null`, verificando la excepción esperada.

Comprobar que todas las expresiones válidas devuelvan `true` y todas las inválidas devuelvan `false`.

Compilar y ejecutar con Java 21 y `-Xlint:all`, documentando las pruebas realmente realizadas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio3 {
    private static class PilaParentesis {
        private final char[] elementos;
        private int top = -1;

        PilaParentesis(int capacidad) {
            elementos = new char[capacidad]; // Se admite capacidad cero.
        }

        void push(char parentesis) {
            if (top == elementos.length - 1) {
                throw new IllegalStateException("La pila esta llena.");
            }
            elementos[++top] = parentesis;
        }

        char pop() {
            if (isEmpty()) throw new IllegalStateException("La pila esta vacia.");
            return elementos[top--];
        }

        boolean isEmpty() { return top == -1; }
    }

    public static boolean validarParentesis(String expresion) {
        if (expresion == null) {
            throw new IllegalArgumentException("La expresion no puede ser nula.");
        }
        // Como maximo puede haber una apertura por caracter: capacidad suficiente.
        PilaParentesis pila = new PilaParentesis(expresion.length());
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                // Un cierre sin apertura pendiente es invalido, aunque luego haya aperturas.
                if (pila.isEmpty()) return false;
                // LIFO: cerrar la ultima apertura pendiente, respetando el anidamiento.
                pila.pop();
            }
            // Los demas caracteres no intervienen: no se valida sintaxis matematica.
        }
        // Si quedaron aperturas sin cerrar, la expresion no esta balanceada.
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String[] expresiones = {
            "(5 + 3) * (2 + 1)", "(5 + 3)) * (2 + 1", "((2 + 3) * (4 - 1))",
            "((5 + 3)", "5 + 3", "", "(", ")", "((()))", "()()()", ")(",
            "(a + b) * (c - d)"
        };
        for (String expresion : expresiones) {
            System.out.println("Expresion: \"" + expresion + "\"; balanceada: "
                    + validarParentesis(expresion));
        }
        try {
            validarParentesis(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Entrada null: " + e.getMessage());
        }
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
