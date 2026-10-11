/*
Implementá en Java un simulador de cola de impresión utilizando una cola FIFO construida manualmente mediante un arreglo de objetos de tamaño fijo.

**Estructura elegida:** cola simple o lineal (Queue), siguiendo el principio FIFO (First In, First Out).

**Estrategia:** representar cada documento mediante un objeto que almacene su nombre y cantidad de páginas. Utilizar un arreglo interno `Documento[]`, con índices `front` y `rear` y un contador `cantidad`. Agregar nuevos documentos al final de la cola e imprimirlos retirándolos desde el frente, respetando el orden de llegada.

**Justificación:** los trabajos de impresión deben procesarse en el mismo orden en que fueron enviados. Una cola FIFO representa este comportamiento porque el primer documento agregado es el primero en retirarse. Una pila LIFO invertiría el orden y permitiría que los documentos más recientes se imprimieran antes que los anteriores.

**Representación de documentos:**
- Cada documento debe tener un nombre y una cantidad de páginas.
- El nombre debe ser un `String` no nulo ni vacío.
- La cantidad de páginas debe ser un entero estrictamente positivo.
- Los atributos deben conservarse asociados al mismo documento durante todo el proceso.

**Operaciones requeridas:**
- `agregarDocumento(String nombre, int paginas)`: validar los datos, crear el documento y agregarlo al final de la cola mediante `enqueue`.
- `imprimirSiguiente()`: retirar y devolver el documento que está al frente mediante `dequeue`, mostrando su nombre y cantidad de páginas.
- `consultarSiguiente()`: consultar el documento que se imprimirá primero, sin retirarlo.
- `isEmpty()`: indicar si no quedan documentos pendientes.
- `isFull()`: indicar si se agotaron las posiciones de inserción del arreglo lineal.
- `size()`: devolver la cantidad de documentos pendientes.

**Manejo del arreglo:**
- Implementar una cola estrictamente lineal, no circular.
- Inicializar `front = 0`, `rear = -1` y `cantidad = 0`.
- Incrementar `rear` al agregar e incrementar `front` al retirar.
- No desplazar los elementos restantes después de una impresión.
- No utilizar módulo `%` para reutilizar posiciones.
- No reiniciar automáticamente los índices cuando la cola quede vacía.
- Limpiar con `null` cada posición liberada para no conservar referencias innecesarias.
- Reconocer que, cuando `rear` alcanza la última posición, la cola ya no admite nuevas inserciones aunque existan posiciones liberadas al inicio.

**Casos especiales:**
- Cola vacía: intentar imprimir o consultar el siguiente documento debe lanzar `IllegalStateException`.
- Cola sin posiciones de inserción: intentar agregar otro documento debe lanzar `IllegalStateException`, sin alterar su estado.
- Nombre inválido: rechazar `null`, cadenas vacías o compuestas únicamente por espacios mediante `IllegalArgumentException`.
- Cantidad de páginas inválida: rechazar valores menores o iguales a cero mediante `IllegalArgumentException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Las operaciones fallidas no deben modificar el contenido ni los índices de la cola.
- Permitir documentos con nombres repetidos, porque diferentes trabajos pueden tener el mismo nombre.

**Complejidad:**
- Inserción física en la cola mediante `enqueue`: O(1).
- Retiro mediante `dequeue`: O(1).
- Consulta del frente: O(1).
- `isEmpty`, `isFull` y `size`: O(1).
- Validación de nombre: O(L), siendo L la longitud del nombre.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija del arreglo.
- Espacio auxiliar por operación: O(1), sin contar el objeto Documento creado.
- Aclarar que el tiempo real de impresión depende de la cantidad de páginas y no forma parte del costo de las operaciones de la cola.

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio8.java`.
- Implementar una clase pública `Ejercicio8` con método `main`.
- Implementar una clase `Documento` que almacene nombre y número de páginas.
- Implementar una clase auxiliar para administrar la cola mediante `Documento[]`, `front`, `rear` y `cantidad`.
- Preferir clases estáticas anidadas dentro de `Ejercicio8` para evitar conflictos de nombres con los demás ejercicios.
- Mantener privados los atributos internos.
- No depender de clases implementadas en otros ejercicios.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- Incorporar comentarios que expliquen el principio FIFO, el significado de los índices y la relación entre llegada e impresión.
- Mostrar el nombre y la cantidad de páginas de cada documento al agregarse y al imprimirse.
- Mostrar el documento siguiente mediante una consulta que no lo retire.
- Mostrar la cantidad de documentos pendientes después de las operaciones relevantes.
- Mostrar mensajes claros cuando una operación no puede realizarse.

**Ejemplo principal:**
1. Crear una cola de impresión de capacidad 3.
2. Agregar `Trabajo practico.pdf`, con 12 páginas.
3. Agregar `Resumen.docx`, con 5 páginas.
4. Agregar `Apuntes.pdf`, con 20 páginas.
5. Consultar el siguiente documento y verificar que sea `Trabajo practico.pdf`, sin retirarlo.
6. Intentar agregar un cuarto documento y verificar el overflow.
7. Imprimir los tres documentos en el mismo orden en que ingresaron.
8. Verificar que la cola quede vacía.
9. Intentar imprimir nuevamente y verificar underflow.
10. Intentar agregar otro documento después de vaciar la cola y comprobar que se rechace porque se agotaron las posiciones físicas de inserción.

**Pruebas adicionales:**
- Cola de capacidad 1.
- Cola inicialmente vacía.
- Cola parcialmente ocupada.
- Cola completamente ocupada.
- Documentos de una página y documentos de muchas páginas.
- Nombres repetidos.
- Alternancia de agregar e imprimir.
- Verificar que consultar no elimina el documento.
- Verificar que se conserva el nombre y la cantidad de páginas.
- Verificar que el orden de impresión sea FIFO.
- Verificar que las referencias liberadas se limpien.
- Rechazar nombres nulos, vacíos y compuestos por espacios.
- Rechazar cantidades de páginas iguales a cero o negativas.
- Rechazar capacidades inválidas.
- Comprobar que overflow y underflow no alteran el estado.
- Verificar que no se reutilicen posiciones liberadas en la cola lineal.

Compilar y ejecutar con Java 21 y `-Xlint:all`, verificando el funcionamiento y documentando las pruebas realizadas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio8 {
    public static class Documento {
        private final String nombre;
        private final int paginas;

        public Documento(String nombre, int paginas) {
            this.nombre = nombre;
            this.paginas = paginas;
        }
        public String getNombre() { return nombre; }
        public int getPaginas() { return paginas; }
        @Override
        public String toString() { return nombre + " (" + paginas + " paginas)"; }
    }

    public static class ColaImpresion {
        private final Documento[] documentos;
        private int front = 0;
        private int rear = -1;
        private int cantidad = 0;

        public ColaImpresion(int capacidad) {
            if (capacidad <= 0) throw new IllegalArgumentException("La capacidad debe ser positiva.");
            documentos = new Documento[capacidad];
        }

        public void agregarDocumento(String nombre, int paginas) {
            // Validar todo antes de crear o insertar, conservando el estado ante errores.
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede ser nulo, vacio ni solo espacios.");
            }
            if (paginas <= 0) throw new IllegalArgumentException("Las paginas deben ser positivas.");
            if (isFull()) throw new IllegalStateException("Overflow: posiciones de insercion agotadas.");
            Documento documento = new Documento(nombre, paginas);
            enqueue(documento);
            System.out.println("Agregado: " + documento);
        }

        private void enqueue(Documento documento) {
            documentos[++rear] = documento;
            cantidad++;
        }

        public Documento imprimirSiguiente() {
            if (isEmpty()) throw new IllegalStateException("Underflow: no hay documentos pendientes.");
            Documento documento = dequeue();
            // Simulacion: mostrar el trabajo, sin ejecutar una impresion fisica.
            System.out.println("Imprimiendo: " + documento);
            return documento;
        }

        private Documento dequeue() {
            // FIFO: el primero enviado es el primero impreso. No mover los demas.
            Documento documento = documentos[front];
            documentos[front++] = null; // Liberar la referencia del trabajo retirado.
            cantidad--;
            return documento;
        }

        public Documento consultarSiguiente() {
            if (isEmpty()) throw new IllegalStateException("Underflow: no hay documentos pendientes.");
            return documentos[front]; // Consultar no modifica indices ni cantidad.
        }
        public boolean isEmpty() { return cantidad == 0; }
        // Cola lineal: rear no vuelve al inicio, incluso despues de vaciarla.
        public boolean isFull() { return rear == documentos.length - 1; }
        public int size() { return cantidad; }
    }

    private static void mostrarPendientes(ColaImpresion cola) {
        System.out.println("Documentos pendientes: " + cola.size());
        if (!cola.isEmpty()) System.out.println("Siguiente: " + cola.consultarSiguiente());
    }

    public static void main(String[] args) {
        ColaImpresion cola = new ColaImpresion(3);
        cola.agregarDocumento("Trabajo practico.pdf", 12);
        mostrarPendientes(cola);
        cola.agregarDocumento("Resumen.docx", 5);
        mostrarPendientes(cola);
        cola.agregarDocumento("Apuntes.pdf", 20);
        mostrarPendientes(cola);
        System.out.println("Consulta sin retirar: " + cola.consultarSiguiente());
        mostrarPendientes(cola);
        try {
            cola.agregarDocumento("Extra.pdf", 1);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarPendientes(cola);
        while (!cola.isEmpty()) {
            cola.imprimirSiguiente();
            mostrarPendientes(cola);
        }
        try {
            cola.imprimirSiguiente();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            cola.agregarDocumento("Nuevo.pdf", 2);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarPendientes(cola);
        System.out.println("La cola lineal agoto sus posiciones: no reutiliza el espacio liberado.");
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
