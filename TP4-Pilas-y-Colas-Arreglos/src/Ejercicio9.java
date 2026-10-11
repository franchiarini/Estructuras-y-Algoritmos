/*
Implementá en Java un programa que demuestre el problema de desperdicio de posiciones en una cola simple o lineal implementada manualmente mediante un arreglo de tamaño fijo.

**Estructura elegida:** cola simple (Queue) implementada mediante `int[]`, respetando FIFO (First In, First Out).

**Estrategia:** utilizar un arreglo de capacidad fija y administrar los elementos mediante los índices `front` y `rear` y un contador `cantidad`. Mostrar el estado físico del arreglo después de cada operación importante, para visualizar cómo las posiciones liberadas al comienzo no pueden reutilizarse cuando el índice `rear` llega al final.

**Justificación:** una cola lineal permite insertar por el final y retirar por el frente sin desplazar elementos. Sin embargo, al avanzar los índices únicamente hacia la derecha, las posiciones liberadas al principio quedan inutilizables para futuras inserciones. Esto puede producir overflow incluso cuando el arreglo contiene espacios físicamente libres.

**Variables de control:**
- `front`: índice del primer elemento activo.
- `rear`: índice de la última posición utilizada para insertar.
- `cantidad`: número de elementos que permanecen en la cola.
- Inicialmente: `front = 0`, `rear = -1` y `cantidad = 0`.

**Operaciones:**
- `enqueue(int valor)`: insertar al final incrementando `rear`, siempre que exista una posición disponible a la derecha.
- `dequeue()`: retirar el elemento ubicado en `front`, avanzar el índice y disminuir `cantidad`.
- `front()`: consultar el primer elemento activo sin retirarlo.
- `isEmpty()`: devolver `true` cuando `cantidad == 0`.
- `isFull()`: devolver `true` cuando `rear == capacidad - 1`, incluso si existen posiciones liberadas al inicio.
- `size()`: devolver la cantidad de elementos activos.
- `mostrarEstado()`: mostrar todas las posiciones físicas del arreglo e indicar `front`, `rear`, `cantidad`, posiciones libres y posiciones disponibles para nuevas inserciones.

**Manejo del arreglo:**
- Utilizar una implementación estrictamente lineal, NO circular.
- No aplicar módulo `%` para actualizar índices.
- No reiniciar automáticamente `front` ni `rear` cuando la cola quede vacía.
- No desplazar elementos hacia el inicio.
- No reutilizar las posiciones que quedaron detrás de `front`.
- Identificar explícitamente en la salida la diferencia entre posiciones físicamente libres y posiciones utilizables para nuevas inserciones.
- Para representar visualmente posiciones libres, administrar su estado lógico sin confundir el valor 0 con una celda vacía.
- Si se utiliza un arreglo auxiliar `boolean[]` únicamente para marcar las posiciones activas o una representación equivalente, justificarlo y mantener la estructura principal almacenada en `int[]`.
- Evitar que la visualización modifique el funcionamiento de la cola.

**Casos especiales:**
- Overflow: al intentar insertar cuando `rear` llegó a la última posición, lanzar `IllegalStateException` y conservar el estado.
- Underflow: al intentar retirar o consultar cuando `cantidad == 0`, lanzar `IllegalStateException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Permitir números negativos, cero, repetidos y extremos de `int`.
- Comprobar que las operaciones inválidas no alteren el arreglo lógico ni sus índices.

**Complejidad:**
- `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Visualización completa del arreglo: O(C), porque deben examinarse sus posiciones.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija.
- Espacio auxiliar por operación básica: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio9.java`.
- Implementar una clase pública `Ejercicio9` con método `main`.
- Implementar una clase auxiliar propia para la cola simple, preferentemente anidada dentro de `Ejercicio9`.
- Utilizar `int[]` como estructura principal de almacenamiento.
- Mantener privados el arreglo, los índices y el contador.
- No depender de clases implementadas en ejercicios anteriores.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la cola.
- Mostrar cada operación realizada y el estado físico completo del arreglo, identificando índices y celdas libres.
- Mostrar también el contenido lógico de la cola en orden FIFO.
- Incorporar comentarios que expliquen los índices `front` y `rear`, las posiciones liberadas y la imposibilidad de reutilizarlas.
- Explicar claramente en consola por qué el intento final de inserción produce overflow a pesar de que existen espacios libres.

**Ejemplo principal:**

Crear una cola lineal de capacidad 5 y ejecutar:

1. Mostrar el estado inicial: arreglo vacío, `front = 0`, `rear = -1`, `size = 0`.
2. Ejecutar `enqueue(10)`, `enqueue(20)` y `enqueue(30)`.
3. Mostrar el arreglo: `{10, 20, 30, libre, libre}`.
4. Ejecutar `dequeue()` y comprobar que devuelve 10.
5. Mostrar el arreglo: `{libre, 20, 30, libre, libre}`, con `front = 1`.
6. Ejecutar `dequeue()` y comprobar que devuelve 20.
7. Mostrar el arreglo: `{libre, libre, 30, libre, libre}`, con `front = 2`.
8. Ejecutar `enqueue(40)` y `enqueue(50)`.
9. Mostrar el arreglo: `{libre, libre, 30, 40, 50}`, con `front = 2`, `rear = 4` y `size = 3`.
10. Intentar `enqueue(60)` y verificar que produce overflow.
11. Mostrar que existen dos posiciones libres al principio, pero ninguna posición disponible al final.
12. Comprobar que los tres elementos activos siguen siendo 30, 40 y 50.
13. Retirar los elementos restantes en orden FIFO.
14. Verificar que la cola queda vacía y que un nuevo intento de inserción continúa rechazándose porque `rear` permanece en la última posición.

**Pruebas adicionales:**
- Cola inicialmente vacía.
- Cola de capacidad 1.
- Cola parcialmente ocupada.
- Cola con todas las posiciones de inserción utilizadas.
- Alternancia entre inserciones y retiros.
- Números repetidos.
- Números negativos, cero y extremos de `int`.
- Comprobar que `front()` no modifica la cola.
- Comprobar que `size()` coincide con la cantidad de elementos activos.
- Comprobar que el número de posiciones libres se calcula correctamente.
- Comprobar que las posiciones libres y las posiciones disponibles para nuevas inserciones no se confunden.
- Comprobar que overflow y underflow no alteran el estado.
- Verificar que la visualización no modifica los datos.
- Rechazar capacidades inválidas.
- Verificar que el orden de retiro siempre sea FIFO.

Compilar y ejecutar con Java 21 y `-Xlint:all`, realizando pruebas reales y documentando los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio9 {
    public static class ColaLineal {
        private final int[] elementos;
        private int front = 0;
        private int rear = -1;
        private int cantidad = 0;

        public ColaLineal(int capacidad) {
            if (capacidad <= 0) throw new IllegalArgumentException("La capacidad debe ser positiva.");
            elementos = new int[capacidad];
        }
        public void enqueue(int valor) {
            if (isFull()) throw new IllegalStateException("Overflow: no hay posiciones al final.");
            elementos[++rear] = valor;
            cantidad++;
        }
        public int dequeue() {
            if (isEmpty()) throw new IllegalStateException("Underflow: cola vacia.");
            // FIFO: avanzar el frente, sin desplazar ni reutilizar las celdas anteriores.
            int valor = elementos[front++];
            cantidad--;
            return valor;
        }
        public int front() {
            if (isEmpty()) throw new IllegalStateException("Underflow: cola vacia.");
            return elementos[front];
        }
        public boolean isEmpty() { return cantidad == 0; }
        public boolean isFull() { return rear == elementos.length - 1; }
        public int size() { return cantidad; }

        public void mostrarEstado() {
            // El intervalo [front, rear] identifica las celdas activas sin boolean[].
            // Un cero dentro del intervalo es un valor valido, no una celda vacia.
            System.out.print("Fisico: {");
            for (int i = 0; i < elementos.length; i++) {
                if (i > 0) System.out.print(", ");
                if (i >= front && i <= rear) System.out.print(elementos[i]);
                else System.out.print("libre");
            }
            System.out.println("}");
            System.out.print("Logico FIFO: {");
            for (int i = front; i <= rear; i++) {
                if (i > front) System.out.print(", ");
                System.out.print(elementos[i]);
            }
            System.out.println("}");
            System.out.println("front = " + front + ", rear = " + rear + ", cantidad = " + cantidad);
            System.out.println("Posiciones libres: " + (elementos.length - cantidad)
                    + "; liberadas al inicio: " + front
                    + "; disponibles para insertar al final: " + (elementos.length - rear - 1));
        }
    }

    private static void agregar(ColaLineal cola, int valor) {
        System.out.println("enqueue(" + valor + ")");
        try {
            cola.enqueue(valor);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        cola.mostrarEstado();
    }
    private static void retirar(ColaLineal cola) {
        System.out.println("dequeue(): " + cola.dequeue());
        cola.mostrarEstado();
    }
    public static void main(String[] args) {
        ColaLineal cola = new ColaLineal(5);
        System.out.println("Estado inicial:");
        cola.mostrarEstado();
        agregar(cola, 10);
        agregar(cola, 20);
        agregar(cola, 30);
        retirar(cola);
        retirar(cola);
        agregar(cola, 40);
        agregar(cola, 50);
        agregar(cola, 60);
        System.out.println("Hay dos posiciones libres al inicio, pero rear llego al final.");
        System.out.println("La cola lineal no reutiliza esas posiciones: por eso hay overflow.");
        while (!cola.isEmpty()) retirar(cola);
        agregar(cola, 70);
        System.out.println("Sin reiniciar indices, tampoco se puede insertar despues de vaciarla.");
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
