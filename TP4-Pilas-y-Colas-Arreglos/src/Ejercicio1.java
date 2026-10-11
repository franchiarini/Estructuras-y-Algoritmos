/*
Implementá en Java una clase `PilaEnteros` utilizando exclusivamente un arreglo de enteros de tamaño fijo, que permita agregar, retirar y consultar elementos respetando el principio LIFO.

**Estructura elegida:** pila (Stack) implementada manualmente mediante `int[]`.

**Estrategia:** utilizar un arreglo interno de capacidad fija y una variable entera `top` para indicar el índice del último elemento agregado. Inicializar `top = -1` para representar que la pila está vacía. Las operaciones deben modificar o consultar exclusivamente el extremo superior de la pila.

**Justificación:** una pila sigue el principio LIFO (Last In, First Out), por lo que el último elemento agregado es el primero en retirarse. El índice `top` permite administrar esta regla sin desplazar los elementos del arreglo.

**Operaciones requeridas:**
- `push(int valor)`: agregar un elemento al tope. Incrementar `top` y almacenar el valor.
- `pop()`: retirar y devolver el elemento del tope. Decrementar `top` después de obtenerlo.
- `peek()`: consultar y devolver el elemento superior sin retirarlo.
- `isEmpty()`: devolver `true` cuando `top == -1`.
- `isFull()`: devolver `true` cuando `top == capacidad - 1`.
- `size()`: devolver la cantidad de elementos almacenados, calculada como `top + 1`.

**Casos especiales:**
- Overflow: cuando se intenta ejecutar `push()` sobre una pila llena, lanzar `IllegalStateException` sin modificar la estructura.
- Underflow: cuando se intenta ejecutar `pop()` o `peek()` sobre una pila vacía, lanzar `IllegalStateException` sin modificar la estructura.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.

**Complejidad:**
- `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio del arreglo interno: O(C), siendo C la capacidad fija de la pila.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-con-Arreglos/src/Ejercicio1.java`.
- Implementar una clase `PilaEnteros` con un constructor que reciba la capacidad.
- Definir el arreglo y la variable `top` como atributos privados.
- Inicializar correctamente la pila vacía.
- Implementar manualmente las seis operaciones solicitadas.
- Mantener la encapsulación, evitando que el código externo modifique directamente el arreglo o `top`.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la pila.
- Incorporar comentarios explicando el principio LIFO, el uso de `top`, las operaciones y los casos de overflow y underflow.
- Incluir un método `main` ejecutable para mostrar el funcionamiento.
- Mostrar por pantalla el estado lógico de la pila y sus cambios después de las operaciones importantes.
- No confundir `peek()` con `pop()`: consultar no debe eliminar elementos.

**Ejemplo principal:**

Crear una pila de capacidad 3 y ejecutar:

1. Mostrar pila vacía: `top = -1`, `size = 0`.
2. Ejecutar `push(10)`.
3. Ejecutar `push(20)`.
4. Ejecutar `push(30)`.
5. Consultar `peek()`: debe devolver 30 y conservar los tres elementos.
6. Intentar `push(40)`: debe producir overflow.
7. Ejecutar `pop()`: debe devolver 30.
8. Ejecutar `pop()`: debe devolver 20.
9. Ejecutar `pop()`: debe devolver 10.
10. Intentar `pop()` y `peek()` nuevamente: deben producir underflow.

**Pruebas adicionales:**
- Pila de capacidad 1.
- Pila parcialmente llena.
- Pila completamente llena.
- Pila vacía.
- Alternancia entre operaciones `push` y `pop`.
- Valores negativos, cero, valores repetidos y extremos de `int`.
- Comprobar que `peek()` no modifica el tamaño.
- Comprobar que las excepciones por overflow y underflow no alteran el estado.
- Comprobar que `isEmpty`, `isFull` y `size` coinciden con el estado real.
- Capacidades inválidas.

Compilar y ejecutar con Java 21 utilizando `-Xlint:all`, verificando los resultados y documentando las pruebas efectivamente realizadas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio1 {
    public static class PilaEnteros {
        private final int[] elementos;
        private int top;

        public PilaEnteros(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
            }
            elementos = new int[capacidad];
            top = -1; // No hay elementos: el primer push utilizara la posicion cero.
        }

        public void push(int valor) {
            // Verificar overflow antes de cambiar el estado.
            if (isFull()) throw new IllegalStateException("Overflow: pila llena.");
            top++;
            elementos[top] = valor;
        }

        public int pop() {
            // LIFO: retirar el ultimo agregado, sin desplazar los demas.
            if (isEmpty()) throw new IllegalStateException("Underflow: pila vacia.");
            int valor = elementos[top];
            top--; // El valor fuera del segmento logico deja de pertenecer a la pila.
            return valor;
        }

        public int peek() {
            if (isEmpty()) throw new IllegalStateException("Underflow: pila vacia.");
            return elementos[top]; // Consultar no cambia top ni el tamanio.
        }

        public boolean isEmpty() { return top == -1; }
        public boolean isFull() { return top == elementos.length - 1; }
        public int size() { return top + 1; }
    }

    private static void mostrarEstado(PilaEnteros pila) {
        System.out.print("Pila (base a tope): [");
        // Solo mostrar el segmento logico, no las celdas libres del arreglo.
        for (int i = 0; i <= pila.top; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(pila.elementos[i]);
        }
        System.out.println("] top = " + pila.top + ", size = " + pila.size()
                + ", vacia = " + pila.isEmpty() + ", llena = " + pila.isFull());
    }

    public static void main(String[] args) {
        PilaEnteros pila = new PilaEnteros(3);
        mostrarEstado(pila);
        pila.push(10);
        mostrarEstado(pila);
        pila.push(20);
        mostrarEstado(pila);
        pila.push(30);
        mostrarEstado(pila);
        System.out.println("peek(): " + pila.peek());
        mostrarEstado(pila);
        try {
            pila.push(40);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarEstado(pila);
        for (int i = 0; i < 3; i++) {
            System.out.println("pop(): " + pila.pop());
            mostrarEstado(pila);
        }
        try {
            pila.pop();
        } catch (IllegalStateException e) {
            System.out.println("pop(): " + e.getMessage());
        }
        try {
            pila.peek();
        } catch (IllegalStateException e) {
            System.out.println("peek(): " + e.getMessage());
        }
        mostrarEstado(pila);
    }
}

/* Ajuste de ubicacion: se utiliza TP4-Pilas-y-Colas-Arreglos, la carpeta existente,
   para evitar duplicar el practico. El prompt inicial se conserva literalmente;
   no se modificaron el algoritmo ni los requisitos funcionales. */
