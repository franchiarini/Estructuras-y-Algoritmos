/*
Implementá en Java un sistema de turnos para una oficina, utilizando una cola de capacidad fija implementada manualmente mediante un arreglo.

**Estructura elegida:** cola simple o lineal (Queue), siguiendo el principio FIFO (First In, First Out).

**Estrategia:** representar cada turno mediante un objeto que contenga el nombre de la persona y su número de turno. Administrar los turnos mediante una cola implementada con un arreglo interno, utilizando índices `front` y `rear` y un contador `cantidad`. Cada persona que llega recibe un número correlativo y se agrega al final. Cuando se atiende a alguien, se retira a la persona que se encuentra al frente de la cola.

**Justificación:** un sistema de atención debe respetar el orden de llegada. FIFO permite que la primera persona que solicita un turno sea la primera en recibir atención. Utilizar una pila LIFO invertiría el orden y favorecería a las personas que llegaron más recientemente.

**Representación de los turnos:**
- Cada turno debe almacenar el número asignado y el nombre de la persona.
- Los números deben asignarse de forma correlativa, comenzando desde 1.
- Cada turno debe conservar su número original hasta ser atendido.
- La asignación de un número debe completarse solamente cuando el turno se agregue correctamente a la cola.

**Operaciones:**
- `agregarPersona(String nombre)`: validar el nombre, asignar el siguiente número disponible y agregar el turno al final mediante `enqueue`.
- `atenderSiguiente()`: retirar mediante `dequeue` y devolver el turno de la primera persona que llegó.
- `consultarPrimero()`: devolver el turno que se encuentra al frente sin retirarlo.
- `isEmpty()`: indicar si no quedan personas esperando.
- `isFull()`: indicar si se agotaron las posiciones de inserción de la cola lineal.
- `size()`: devolver la cantidad de personas esperando.

**Manejo del arreglo:**
- Utilizar un arreglo de objetos `Turno[]` de tamaño fijo.
- Inicializar `front = 0`, `rear = -1` y `cantidad = 0`.
- Avanzar `rear` al insertar y `front` al retirar.
- No desplazar los elementos después de atender a una persona.
- No utilizar una implementación circular ni el operador módulo para administrar los índices.
- No reutilizar posiciones liberadas al principio del arreglo.
- No reiniciar los índices cuando la cola quede vacía.
- Considerar que la cola puede estar vacía y, al mismo tiempo, no admitir nuevas inserciones si `rear` llegó al final del arreglo.
- Limpiar la referencia de cada turno retirado para evitar conservar objetos innecesariamente en memoria.

**Casos especiales:**
- Oficina sin personas: intentar atender o consultar el primer turno debe producir underflow mediante `IllegalStateException`.
- Cola llena: intentar agregar otra persona cuando `rear` llegó al final debe producir overflow mediante `IllegalStateException`.
- Nombre inválido: rechazar nombres nulos, vacíos o compuestos únicamente por espacios mediante `IllegalArgumentException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Las operaciones inválidas no deben modificar la cola ni consumir números de turno.
- Permitir nombres repetidos porque diferentes personas pueden tener el mismo nombre.

**Complejidad:**
- Inserción física mediante `enqueue`: O(1).
- Atención mediante `dequeue`: O(1).
- Consulta del primer turno: O(1).
- `isEmpty`, `isFull` y `size`: O(1).
- Validación de nombres: O(L), donde L es la longitud del nombre.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija de la cola.
- Espacio auxiliar por operación: O(1), sin contar los objetos de turno almacenados.

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio7.java`.
- Implementar una clase pública `Ejercicio7` con método `main`.
- Implementar una clase simple `Turno`, con número y nombre de la persona.
- Implementar una clase auxiliar para administrar los turnos mediante `Turno[]`, `front`, `rear` y `cantidad`.
- Utilizar clases anidadas en `Ejercicio7` para evitar conflictos de nombres con los demás ejercicios.
- Mantener privados los atributos internos.
- No depender de las clases de otros ejercicios.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- Incorporar comentarios explicando FIFO, los índices, la asignación correlativa de turnos y las validaciones.
- Mostrar en consola cuándo llega una persona, qué turno recibe, quién está primero y quién es atendido.
- Mostrar la cantidad de personas esperando después de las operaciones relevantes.
- Verificar que consultar el primer turno no lo elimine.

**Ejemplo principal:**
1. Crear un sistema con capacidad 4.
2. Agregar a Ana y asignarle el turno 1.
3. Agregar a Pedro y asignarle el turno 2.
4. Agregar a Lucia y asignarle el turno 3.
5. Consultar quién está primero: debe ser Ana, turno 1.
6. Atender a Ana y verificar que ahora el primero sea Pedro.
7. Agregar a Martin y asignarle el turno 4.
8. Atender a Pedro, Lucia y Martin, en ese orden.
9. Comprobar que la cola queda vacía.
10. Intentar atender nuevamente: debe producir underflow.
11. Intentar agregar una quinta persona: debe producir overflow porque la cola lineal agotó sus posiciones, aunque esté vacía.

**Pruebas adicionales:**
- Sistema de capacidad 1.
- Cola inicialmente vacía.
- Cola parcialmente ocupada.
- Alternancia de llegadas y atenciones.
- Personas con nombres repetidos.
- Consultar el primer turno sin modificar la cantidad.
- Verificar que los turnos se asignen correlativamente.
- Verificar que una operación rechazada no consuma un número de turno.
- Rechazar nombres nulos, vacíos y compuestos por espacios.
- Rechazar capacidades inválidas.
- Verificar el agotamiento de posiciones de la cola lineal.
- Verificar que las personas sean atendidas estrictamente en orden FIFO.
- Verificar que overflow y underflow no alteren el estado.

Compilar y ejecutar con Java 21 y `-Xlint:all`, documentando las pruebas realmente realizadas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio7 {
    public static class Turno {
        private final int numero;
        private final String nombre;

        public Turno(int numero, String nombre) {
            this.numero = numero;
            this.nombre = nombre;
        }
        public int getNumero() { return numero; }
        public String getNombre() { return nombre; }
        @Override
        public String toString() { return "Turno " + numero + ": " + nombre; }
    }

    public static class SistemaTurnos {
        private final Turno[] turnos;
        private int front = 0;
        private int rear = -1;
        private int cantidad = 0;
        private int siguienteNumero = 1;

        public SistemaTurnos(int capacidad) {
            if (capacidad <= 0) throw new IllegalArgumentException("La capacidad debe ser positiva.");
            turnos = new Turno[capacidad];
        }

        public Turno agregarPersona(String nombre) {
            // Validar antes de asignar: los errores no consumen numeros.
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede ser nulo, vacio ni solo espacios.");
            }
            if (isFull()) throw new IllegalStateException("Overflow: posiciones de insercion agotadas.");
            Turno turno = new Turno(siguienteNumero, nombre);
            enqueue(turno);
            siguienteNumero++; // Confirmar el numero solo despues de insertar correctamente.
            return turno;
        }

        private void enqueue(Turno turno) {
            turnos[++rear] = turno;
            cantidad++;
        }

        public Turno atenderSiguiente() {
            if (isEmpty()) throw new IllegalStateException("Underflow: no hay personas esperando.");
            return dequeue();
        }

        private Turno dequeue() {
            // FIFO: retirar al mas antiguo y liberar la referencia, sin mover los demas.
            Turno turno = turnos[front];
            turnos[front++] = null;
            cantidad--;
            return turno;
        }

        public Turno consultarPrimero() {
            if (isEmpty()) throw new IllegalStateException("Underflow: no hay personas esperando.");
            return turnos[front]; // Consultar no retira ni consume numeros.
        }
        public boolean isEmpty() { return cantidad == 0; }
        // Cola lineal: no se reutiliza el inicio ni se reinician los indices.
        public boolean isFull() { return rear == turnos.length - 1; }
        public int size() { return cantidad; }
    }

    private static void mostrarEspera(SistemaTurnos sistema) {
        System.out.println("Personas esperando: " + sistema.size());
        if (!sistema.isEmpty()) System.out.println("Primero: " + sistema.consultarPrimero());
    }

    public static void main(String[] args) {
        SistemaTurnos sistema = new SistemaTurnos(4);
        mostrarEspera(sistema);
        for (String nombre : new String[]{"Ana", "Pedro", "Lucia"}) {
            System.out.println("Llega " + nombre + ". " + sistema.agregarPersona(nombre));
            mostrarEspera(sistema);
        }
        System.out.println("Consulta: " + sistema.consultarPrimero());
        mostrarEspera(sistema);
        System.out.println("Atendido: " + sistema.atenderSiguiente());
        mostrarEspera(sistema);
        System.out.println("Llega Martin. " + sistema.agregarPersona("Martin"));
        mostrarEspera(sistema);
        while (!sistema.isEmpty()) {
            System.out.println("Atendido: " + sistema.atenderSiguiente());
            mostrarEspera(sistema);
        }
        try {
            sistema.atenderSiguiente();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            sistema.agregarPersona("Sofia");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarEspera(sistema);
        System.out.println("La cola lineal quedo vacia, pero agoto sus posiciones de insercion.");
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
