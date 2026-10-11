/*
Implementá en Java un simulador de torre de platos utilizando una pila implementada manualmente mediante un arreglo de enteros de tamaño fijo.

**Estructura elegida:** pila (Stack), siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** representar cada plato mediante un número entero y almacenarlo en un arreglo. Utilizar una variable `top`, inicialmente igual a -1, para identificar el plato que se encuentra en la parte superior de la torre. Agregar platos mediante `push()`, retirarlos mediante `pop()` y consultar el plato superior mediante `peek()`.

**Justificación:** una torre de platos funciona según el principio LIFO: el último plato colocado arriba debe ser el primero en retirarse. Una cola FIFO no representa correctamente este comportamiento porque retiraría primero el plato agregado más antiguamente, que está debajo de los demás.

**Operaciones:**
- Agregar plato: colocar un nuevo plato en la parte superior de la torre mediante `push(int plato)`.
- Retirar plato: retirar y devolver el plato superior mediante `pop()`.
- Consultar plato superior: obtener el plato que está arriba mediante `peek()`, sin retirarlo.
- Consultar si la torre está vacía mediante `isEmpty()`.
- Consultar si la torre está llena mediante `isFull()`.
- Consultar cantidad de platos mediante `size()`.

**Casos especiales:**
- Overflow: cuando se intenta agregar un plato a una torre llena, lanzar `IllegalStateException` sin modificar la estructura.
- Underflow: cuando se intenta retirar o consultar un plato de una torre vacía, lanzar `IllegalStateException` sin modificar la estructura.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.

**Complejidad:**
- Agregar, retirar, consultar el superior, verificar vacío o lleno y consultar tamaño: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija de la torre.
- Espacio auxiliar por operación: O(1).

**Requisitos:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio2.java`.
- Implementar una clase pública `Ejercicio2` con método `main`.
- Implementar una clase auxiliar para representar la pila de platos mediante `int[]`, evitando conflictos de nombres con la clase `PilaEnteros` del Ejercicio 1.
- La implementación debe ser independiente y no depender de otras clases de los ejercicios anteriores.
- Mantener privados el arreglo interno y el índice `top`.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- Mostrar mediante mensajes claros cuándo se agrega, retira o consulta un plato.
- Mostrar el estado lógico de la torre después de cada operación importante, identificando el plato que está arriba.
- Incorporar comentarios explicando por qué la torre utiliza LIFO y por qué no corresponde utilizar FIFO.
- Incluir un ejemplo principal con una torre de capacidad 3.
- Agregar los platos 10, 20 y 30, en ese orden.
- Verificar que `peek()` devuelva 30 y conserve el tamaño.
- Intentar agregar el plato 40 y comprobar el overflow.
- Retirar los platos y verificar que salgan en el orden 30, 20 y 10.
- Intentar retirar o consultar un plato cuando la torre esté vacía y comprobar el underflow.
- Verificar que las excepciones no modifiquen el estado.
- Probar torres de capacidad 1, alternancia entre agregar y retirar, platos repetidos, valores negativos, cero y extremos de `int`.
- Verificar que los platos almacenados no se pierdan ni se alteren y que el orden LIFO se mantenga.
- Compilar y ejecutar con Java 21 y `-Xlint:all`, realizando pruebas que verifiquen los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio2 {
    public static class PilaPlatos {
        private final int[] platos;
        private int top;

        public PilaPlatos(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
            }
            platos = new int[capacidad];
            top = -1;
        }

        public void push(int plato) {
            // Validar overflow antes de modificar el indice o el contenido.
            if (isFull()) throw new IllegalStateException("Overflow: torre llena.");
            top++;
            platos[top] = plato;
        }

        public int pop() {
            if (isEmpty()) throw new IllegalStateException("Underflow: torre vacia.");
            // LIFO: retirar el ultimo plato colocado, que esta arriba.
            // FIFO retiraria el mas antiguo, que esta debajo de los demas.
            int plato = platos[top];
            top--;
            return plato;
        }

        public int peek() {
            if (isEmpty()) throw new IllegalStateException("Underflow: torre vacia.");
            return platos[top]; // Consultar no elimina el plato ni cambia el tamanio.
        }

        public boolean isEmpty() { return top == -1; }
        public boolean isFull() { return top == platos.length - 1; }
        public int size() { return top + 1; }
    }

    private static void mostrarEstado(PilaPlatos torre) {
        System.out.print("Torre (base a cima): [");
        // Las celdas por encima de top no pertenecen al estado logico.
        for (int i = 0; i <= torre.top; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(torre.platos[i]);
        }
        System.out.print("] cantidad = " + torre.size() + ", vacia = " + torre.isEmpty()
                + ", llena = " + torre.isFull());
        if (torre.isEmpty()) System.out.println(", arriba: ninguno.");
        else System.out.println(", arriba: " + torre.peek());
    }

    public static void main(String[] args) {
        PilaPlatos torre = new PilaPlatos(3);
        mostrarEstado(torre);
        for (int plato : new int[]{10, 20, 30}) {
            torre.push(plato);
            System.out.println("Se agrega el plato " + plato + ".");
            mostrarEstado(torre);
        }
        System.out.println("Se consulta el plato superior: " + torre.peek());
        mostrarEstado(torre);
        System.out.println("Se intenta agregar el plato 40.");
        try {
            torre.push(40);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarEstado(torre);
        for (int i = 0; i < 3; i++) {
            System.out.println("Se retira el plato " + torre.pop() + ".");
            mostrarEstado(torre);
        }
        System.out.println("Se intenta retirar un plato de la torre vacia.");
        try {
            torre.pop();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarEstado(torre);
        System.out.println("Se intenta consultar el plato superior de la torre vacia.");
        try {
            torre.peek();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarEstado(torre);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
