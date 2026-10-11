/*
Implementá en Java una cola circular de números enteros utilizando un arreglo de capacidad fija, que respete el principio FIFO y reutilice las posiciones liberadas al comienzo del arreglo.

**Estructura elegida:** cola circular (Circular Queue), implementada manualmente mediante `int[]`.

**Estrategia:** utilizar un arreglo de capacidad fija y administrar sus elementos mediante los índices `front` y `rear`, junto con un contador `cantidad`. Cuando un índice llegue al final del arreglo, debe volver al comienzo mediante el operador módulo `%`, permitiendo reutilizar las posiciones que fueron liberadas.

**Justificación:** una cola lineal puede agotar sus posiciones de inserción aun cuando existan celdas libres al inicio. La cola circular resuelve este problema porque permite que los índices recorran nuevamente el arreglo, sin desplazar los elementos ni perder el orden FIFO.

**Variables de control:**
- `front`: índice del primer elemento activo de la cola.
- `rear`: índice de la última posición en la que se insertó un elemento.
- `cantidad`: número de elementos activos.
- `capacidad`: tamaño fijo del arreglo interno.
- Inicialmente: `front = 0`, `rear = -1` y `cantidad = 0`.

**Operaciones requeridas:**
- `enqueue(int valor)`: verificar que la cola no esté llena, avanzar `rear` de forma circular, almacenar el valor e incrementar `cantidad`.
- `dequeue()`: verificar que la cola no esté vacía, devolver el elemento ubicado en `front`, avanzar `front` de forma circular y disminuir `cantidad`.
- `front()`: consultar y devolver el primer elemento sin retirarlo.
- `isEmpty()`: devolver `true` cuando `cantidad == 0`.
- `isFull()`: devolver `true` cuando `cantidad == capacidad`.
- `size()`: devolver la cantidad de elementos activos.

**Movimiento circular:**
- Para avanzar el índice posterior: `rear = (rear + 1) % capacidad`.
- Para avanzar el índice anterior: `front = (front + 1) % capacidad`.
- Cuando `rear` pasa del último índice al índice 0, se reutiliza una posición liberada.
- Cuando `front` pasa del último índice al índice 0, continúa retirando elementos en orden FIFO.
- No desplazar elementos físicamente para liberar posiciones.
- Utilizar `cantidad` para distinguir correctamente los estados vacío y lleno.
- La cola debe poder ocupar todas las posiciones del arreglo.

**Política de índices:**
- Mantener los índices de manera coherente después de cada operación.
- Cuando la cola quede vacía, `cantidad` debe valer 0. No es necesario reiniciar `front` ni `rear`, porque ambos seguirán funcionando correctamente mediante módulo.
- El arreglo debe poder reutilizarse indefinidamente mediante nuevas operaciones `enqueue` y `dequeue`, mientras se respete su capacidad.
- No confundir las posiciones físicas del arreglo con el orden lógico de los elementos.

**Casos especiales:**
- Overflow: intentar insertar cuando `cantidad == capacidad` debe lanzar `IllegalStateException` sin modificar el estado.
- Underflow: intentar retirar o consultar cuando `cantidad == 0` debe lanzar `IllegalStateException` sin modificar el estado.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Permitir números negativos, cero, repetidos y extremos de `int`.
- Comprobar que cualquier operación fallida preserve íntegramente los elementos, índices y contador.

**Complejidad:**
- `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija del arreglo.
- Espacio auxiliar por operación básica: O(1).
- La visualización completa del arreglo requiere O(C) de tiempo.

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio10.java`.
- Implementar una clase pública `Ejercicio10` con método `main`.
- Implementar una clase auxiliar `ColaCircularEnteros` mediante un arreglo `int[]`.
- Preferir una clase estática anidada dentro de `Ejercicio10` para evitar conflictos con otros ejercicios.
- Mantener privados el arreglo interno, los índices y el contador.
- Implementar manualmente todas las operaciones solicitadas.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- No depender de las clases de ejercicios anteriores.
- Incorporar comentarios explicando FIFO, la función de `front` y `rear`, el operador módulo, los casos de overflow y underflow y la diferencia con una cola lineal.
- Mostrar el arreglo físico con sus índices después de las operaciones importantes.
- Mostrar también el contenido lógico de la cola en orden FIFO.
- Distinguir visualmente las celdas activas de las libres sin confundir el valor 0 con una posición vacía.
- Evitar que la visualización modifique el contenido de la cola.
- Mostrar claramente cuándo `rear` y `front` vuelven al índice 0 mediante el operador módulo.

**Ejemplo principal:**

Crear una cola circular de capacidad 5 y ejecutar:

1. Mostrar el estado inicial: `front = 0`, `rear = -1`, `size = 0`.
2. Ejecutar `enqueue(10)`, `enqueue(20)` y `enqueue(30)`.
3. Mostrar el arreglo físico: `{10, 20, 30, libre, libre}`.
4. Ejecutar `dequeue()` dos veces y comprobar que se retiran 10 y 20.
5. Mostrar el arreglo físico: `{libre, libre, 30, libre, libre}`, con `front = 2`, `rear = 2` y `size = 1`.
6. Ejecutar `enqueue(40)` y `enqueue(50)`.
7. Comprobar que el arreglo contiene `{libre, libre, 30, 40, 50}`, con `front = 2`, `rear = 4` y `size = 3`.
8. Ejecutar `enqueue(60)`. Verificar que `rear` vuelve al índice 0 y que el arreglo queda `{60, libre, 30, 40, 50}`.
9. Ejecutar `enqueue(70)`. Verificar que `rear = 1`, `size = 5` y que el arreglo queda `{60, 70, 30, 40, 50}`.
10. Comprobar que `isFull()` devuelve `true`.
11. Intentar `enqueue(80)` y verificar overflow, sin modificar el estado.
12. Consultar `front()` y verificar que devuelve 30, sin retirarlo.
13. Ejecutar `dequeue()` repetidamente y comprobar que los elementos salen en orden 30, 40, 50, 60 y 70.
14. Verificar que `front` también atraviesa el final del arreglo y vuelve al índice 0.
15. Comprobar que la cola queda vacía y que `isEmpty()` devuelve `true`.
16. Intentar `dequeue()` y `front()` sobre la cola vacía y verificar underflow.
17. Agregar un nuevo elemento después de vaciarla y comprobar que la cola circular continúa funcionando, a diferencia de la cola lineal del Ejercicio 9.

**Pruebas adicionales:**
- Cola recién creada.
- Capacidad 1.
- Cola parcialmente ocupada.
- Cola completamente ocupada.
- Alternancia repetida de inserciones y retiros.
- Múltiples vueltas completas de los índices sobre el arreglo.
- Verificar que `rear` regrese al inicio.
- Verificar que `front` regrese al inicio.
- Insertar después de vaciar completamente la cola.
- Números repetidos, negativos, cero y extremos de `int`.
- Comprobar que `front()` no modifica la estructura.
- Comprobar que `size()` coincide con la cantidad real de elementos.
- Verificar que `isEmpty()` e `isFull()` funcionen correctamente incluso cuando los índices coincidan.
- Verificar que se utilice la capacidad completa del arreglo.
- Comprobar que overflow y underflow no alteran los elementos, índices ni contador.
- Rechazar capacidades inválidas.
- Verificar el orden FIFO después de múltiples vueltas circulares.
- Comprobar que la visualización del arreglo no modifica los datos.

Compilar y ejecutar con Java 21 y `-Xlint:all`, verificando el funcionamiento mediante pruebas reales y documentando sus resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio10 {
    public static class ColaCircularEnteros {
        private final int[] elementos;
        private int front = 0;
        private int rear = -1;
        private int cantidad = 0;

        public ColaCircularEnteros(int capacidad) {
            if (capacidad <= 0) throw new IllegalArgumentException("La capacidad debe ser positiva.");
            elementos = new int[capacidad];
        }
        public void enqueue(int valor) {
            // Validar antes de cambiar indices o contenido.
            if (isFull()) throw new IllegalStateException("Overflow: cola llena.");
            rear = (rear + 1) % elementos.length;
            elementos[rear] = valor;
            cantidad++;
        }
        public int dequeue() {
            if (isEmpty()) throw new IllegalStateException("Underflow: cola vacia.");
            // FIFO: retirar al mas antiguo; modulo permite atravesar el final.
            int valor = elementos[front];
            front = (front + 1) % elementos.length;
            cantidad--;
            return valor;
        }
        public int front() {
            if (isEmpty()) throw new IllegalStateException("Underflow: cola vacia.");
            return elementos[front];
        }
        public boolean isEmpty() { return cantidad == 0; }
        public boolean isFull() { return cantidad == elementos.length; }
        public int size() { return cantidad; }

        public void mostrarEstado() {
            System.out.print("Fisico: {");
            for (int i = 0; i < elementos.length; i++) {
                if (i > 0) System.out.print(", ");
                // Distancia circular desde front: solo cantidad posiciones estan activas.
                // No usamos el valor 0 como marca: cero es un dato valido.
                int distancia = i >= front ? i - front : elementos.length - front + i;
                if (distancia < cantidad) System.out.print(elementos[i]);
                else System.out.print("libre");
            }
            System.out.println("}");
            System.out.print("Indices fisicos: {");
            for (int i = 0; i < elementos.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(i);
            }
            System.out.println("}");
            System.out.print("Logico FIFO: {");
            int indice = front;
            for (int i = 0; i < cantidad; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(elementos[indice]);
                indice = (indice + 1) % elementos.length;
            }
            System.out.println("}");
            System.out.println("front = " + front + ", rear = " + rear + ", size = " + cantidad
                    + ", vacia = " + isEmpty() + ", llena = " + isFull());
        }
    }

    private static void agregar(ColaCircularEnteros cola, int valor) {
        int anterior = cola.rear;
        System.out.println("enqueue(" + valor + ")");
        try {
            cola.enqueue(valor);
            if (anterior == cola.elementos.length - 1 && cola.rear == 0) {
                System.out.println("rear vuelve al indice 0 mediante modulo: posicion reutilizada.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        cola.mostrarEstado();
    }
    private static void retirar(ColaCircularEnteros cola) {
        int anterior = cola.front;
        System.out.println("dequeue(): " + cola.dequeue());
        if (anterior == cola.elementos.length - 1 && cola.front == 0) {
            System.out.println("front vuelve al indice 0 mediante modulo, conservando FIFO.");
        }
        cola.mostrarEstado();
    }
    public static void main(String[] args) {
        ColaCircularEnteros cola = new ColaCircularEnteros(5);
        cola.mostrarEstado();
        for (int valor : new int[]{10, 20, 30}) agregar(cola, valor);
        retirar(cola);
        retirar(cola);
        for (int valor : new int[]{40, 50, 60, 70, 80}) agregar(cola, valor);
        System.out.println("front(): " + cola.front());
        cola.mostrarEstado();
        while (!cola.isEmpty()) retirar(cola);
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
        cola.mostrarEstado();
        agregar(cola, 90);
        System.out.println("La cola circular reutiliza el arreglo incluso despues de vaciarse.");
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
