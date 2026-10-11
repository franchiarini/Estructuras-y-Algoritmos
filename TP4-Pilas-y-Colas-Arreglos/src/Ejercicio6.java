/*
Implementá en Java una clase `ColaEnteros` utilizando un arreglo de enteros de tamaño fijo, que permita agregar, retirar y consultar elementos respetando el principio FIFO.

**Estructura elegida:** cola simple o lineal (Queue), implementada manualmente mediante `int[]`.

**Estrategia:** utilizar un arreglo interno de capacidad fija y dos índices: `front`, que identifica el primer elemento disponible, y `rear`, que identifica la última posición utilizada para insertar. Inicializar `front = 0`, `rear = -1` y `cantidad = 0`. Agregar elementos por el extremo posterior y retirarlos por el extremo anterior, sin desplazar los elementos restantes.

**Justificación:** una cola sigue el principio FIFO (First In, First Out), por lo que los elementos deben retirarse en el mismo orden en que ingresaron. Los índices `front` y `rear` permiten administrar esta regla sin recorrer el arreglo en cada operación.

**Operaciones requeridas:**
- `enqueue(int valor)`: agregar el elemento al final de la cola, incrementando `rear` y almacenando el valor.
- `dequeue()`: retirar y devolver el elemento que está en `front`, incrementando `front` y disminuyendo `cantidad`.
- `front()`: consultar y devolver el primer elemento sin retirarlo.
- `isEmpty()`: devolver `true` cuando `cantidad == 0`.
- `isFull()`: devolver `true` cuando `rear == capacidad - 1`, porque se agotaron las posiciones disponibles al final de esta cola lineal.
- `size()`: devolver la cantidad de elementos activos almacenados.

**Manejo de índices y espacio:**
- Esta implementación debe ser estrictamente lineal, NO circular.
- Los índices avanzan solamente hacia la derecha.
- No utilizar el operador módulo `%` para mover `front` o `rear`.
- No desplazar elementos hacia el inicio después de ejecutar `dequeue()`.
- No reiniciar automáticamente `front` ni `rear` cuando la cola quede vacía, porque el objetivo es observar la limitación de reutilización de espacio de una cola simple.
- Diferenciar correctamente una cola vacía de una cola con espacio disponible al final: `isEmpty()` puede ser `true` al mismo tiempo que `isFull()` si el arreglo ya agotó sus posiciones de inserción.
- Cuando se hayan utilizado todas las posiciones del arreglo, nuevos intentos de `enqueue()` deben producir overflow aunque existan posiciones liberadas al comienzo.

**Casos especiales:**
- Overflow: intentar `enqueue()` cuando `rear` ya está en la última posición debe lanzar `IllegalStateException` sin modificar la estructura.
- Underflow: intentar `dequeue()` o `front()` cuando `cantidad == 0` debe lanzar `IllegalStateException` sin modificar el estado.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Permitir valores negativos, cero, repetidos y extremos de `int`.

**Complejidad:**
- `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija del arreglo.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio6.java`.
- Implementar una clase `ColaEnteros` con constructor que reciba una capacidad fija.
- Implementar `ColaEnteros` como clase auxiliar propia de `Ejercicio6` para evitar conflictos con otros ejercicios.
- Implementar una clase pública `Ejercicio6` con método `main`.
- Mantener privados el arreglo, los índices y el contador de elementos.
- Implementar manualmente las seis operaciones solicitadas.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- Incorporar comentarios que expliquen FIFO, la función de `front` y `rear`, la diferencia entre consultar y retirar, y los casos de overflow y underflow.
- Mostrar el contenido lógico de la cola y el valor de los índices después de las operaciones importantes.
- Mostrar también, cuando corresponda, las posiciones físicas liberadas al comienzo del arreglo.
- No depender de clases de ejercicios anteriores.

**Ejemplo principal:**

Crear una cola de capacidad 5 y ejecutar:

1. Mostrar el estado inicial: `front = 0`, `rear = -1`, `size = 0`.
2. Ejecutar `enqueue(10)`.
3. Ejecutar `enqueue(20)`.
4. Ejecutar `enqueue(30)`.
5. Consultar `front()`: debe devolver 10 sin modificar la cantidad de elementos.
6. Ejecutar `dequeue()`: debe devolver 10.
7. Comprobar que `front()` ahora devuelve 20.
8. Ejecutar `enqueue(40)`.
9. Ejecutar `enqueue(50)`.
10. Comprobar que la cola lógica contiene `{20, 30, 40, 50}`, con `front = 1` y `rear = 4`.
11. Intentar `enqueue(60)`: debe producir overflow, aunque la posición 0 esté liberada.
12. Retirar los elementos restantes en orden 20, 30, 40 y 50.
13. Comprobar que la cola queda vacía y `size()` devuelve 0.
14. Intentar `dequeue()` y `front()` sobre la cola vacía: deben producir underflow.
15. Comprobar que, al no reiniciar los índices, un nuevo `enqueue(70)` continúa rechazándose porque `rear` llegó al final del arreglo. Explicar que este comportamiento representa la limitación de la cola lineal y que se resolverá con una cola circular.

**Pruebas adicionales:**
- Cola de capacidad 1.
- Cola recién creada.
- Cola parcialmente ocupada.
- Cola con todas las posiciones de inserción utilizadas.
- Secuencias alternadas de `enqueue` y `dequeue`.
- Valores negativos, cero, repetidos y extremos de `int`.
- Verificar que `front()` no modifica la cola.
- Verificar que `dequeue()` respeta estrictamente FIFO.
- Verificar que `size()` refleja únicamente los elementos activos.
- Verificar que overflow y underflow no alteran el estado.
- Verificar que las posiciones liberadas al inicio no se reutilizan.
- Verificar el rechazo de capacidades inválidas.

Compilar y ejecutar con Java 21 y `-Xlint:all`, realizando pruebas reales y documentando sus resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio6 {
    public static class ColaEnteros {
        private final int[] elementos;
        private int front = 0;
        private int rear = -1;
        private int cantidad = 0;

        public ColaEnteros(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
            }
            elementos = new int[capacidad];
        }

        public void enqueue(int valor) {
            // Overflow depende del espacio al final, no de la cantidad activa.
            if (isFull()) throw new IllegalStateException("Overflow: posiciones de insercion agotadas.");
            elementos[++rear] = valor;
            cantidad++;
        }

        public int dequeue() {
            if (isEmpty()) throw new IllegalStateException("Underflow: cola vacia.");
            // FIFO: retirar el mas antiguo. No desplazar ni reiniciar los indices.
            int valor = elementos[front++];
            cantidad--;
            return valor;
        }

        public int front() {
            if (isEmpty()) throw new IllegalStateException("Underflow: cola vacia.");
            return elementos[front]; // Consultar no cambia indices ni cantidad.
        }

        public boolean isEmpty() { return cantidad == 0; }
        public boolean isFull() { return rear == elementos.length - 1; }
        public int size() { return cantidad; }
    }

    private static void mostrarEstado(ColaEnteros cola) {
        System.out.print("Cola logica: {");
        for (int i = cola.front; i <= cola.rear; i++) {
            if (i > cola.front) System.out.print(", ");
            System.out.print(cola.elementos[i]);
        }
        System.out.println("}; front = " + cola.front + ", rear = " + cola.rear
                + ", size = " + cola.size() + ", vacia = " + cola.isEmpty()
                + ", llena = " + cola.isFull());
        if (cola.front > 0) {
            System.out.println("Posiciones fisicas liberadas: 0 a " + (cola.front - 1)
                    + ". No se reutilizan en esta cola lineal.");
        }
    }

    public static void main(String[] args) {
        ColaEnteros cola = new ColaEnteros(5);
        mostrarEstado(cola);
        for (int valor : new int[]{10, 20, 30}) {
            cola.enqueue(valor);
            System.out.println("enqueue(" + valor + ")");
            mostrarEstado(cola);
        }
        System.out.println("front(): " + cola.front());
        mostrarEstado(cola);
        System.out.println("dequeue(): " + cola.dequeue());
        System.out.println("front(): " + cola.front());
        mostrarEstado(cola);
        for (int valor : new int[]{40, 50}) {
            cola.enqueue(valor);
            System.out.println("enqueue(" + valor + ")");
            mostrarEstado(cola);
        }
        try {
            cola.enqueue(60);
        } catch (IllegalStateException e) {
            System.out.println("enqueue(60): " + e.getMessage());
        }
        mostrarEstado(cola);
        while (!cola.isEmpty()) {
            System.out.println("dequeue(): " + cola.dequeue());
            mostrarEstado(cola);
        }
        try {
            cola.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("dequeue(): " + e.getMessage());
        }
        try {
            cola.front();
        } catch (IllegalStateException e) {
            System.out.println("front(): " + e.getMessage());
        }
        try {
            cola.enqueue(70);
        } catch (IllegalStateException e) {
            System.out.println("enqueue(70): " + e.getMessage());
        }
        mostrarEstado(cola);
        System.out.println("Vacia y llena a la vez: no hay elementos activos ni posiciones nuevas al final.");
        System.out.println("Una cola circular permitiria reutilizar las posiciones liberadas.");
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
