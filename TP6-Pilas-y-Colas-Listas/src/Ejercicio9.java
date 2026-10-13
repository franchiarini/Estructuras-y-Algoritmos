/*
Implementar desde cero un sistema de cola de impresión mediante una lista enlazada simple, que procese los documentos siguiendo FIFO (First In, First Out).

**Estructura y justificación:** utilizar una cola enlazada de objetos `TrabajoImpresion`, con `head` apuntando al primer trabajo pendiente y `tail` al último recibido. Una impresora debe procesar los documentos según su orden de llegada. Ambas referencias permiten agregar e imprimir trabajos en O(1).

**Clases:**
- `Ejercicio9`: clase pública con `main`.
- `TrabajoImpresion`: atributos privados `nombreArchivo`, `cantidadPaginas` y `usuario`, con constructor, getters y `toString()`.
- `Nodo`: almacena un `TrabajoImpresion` y una referencia al siguiente nodo.
- `ColaImpresion`: mantiene `head` y `tail` e implementa las operaciones.

Implementar las clases auxiliares como estáticas anidadas dentro de `Ejercicio9`.

**Operaciones:**
- `void agregarTrabajo(TrabajoImpresion trabajo)`: incorporar al final mediante `tail`, sin recorrer la cola.
- `TrabajoImpresion imprimirProximo()`: retirar y devolver el primer trabajo mediante `head`, simulando su procesamiento. No realizar impresión física.
- `TrabajoImpresion consultarProximo()`: devolver el primer trabajo sin eliminarlo.
- `void mostrarPendientes()`: recorrer los nodos desde `head` e imprimir los tres datos de cada trabajo en orden FIFO.
- `boolean estaVacia()`: indicar si la cola no tiene trabajos.

**Manejo de referencias:** cuando la cola está vacía, `head` y `tail` son `null`. Al agregar el primer trabajo, ambos apuntan al mismo nodo. Cuando se retira el último, ambos vuelven a `null`. El último nodo siempre apunta a `null`. No perder trabajos ni generar ciclos.

**Validaciones y casos especiales:** rechazar trabajos `null`, nombres de archivo o usuarios vacíos y cantidades de páginas menores o iguales a cero mediante `IllegalArgumentException`. `imprimirProximo()` y `consultarProximo()` sobre una cola vacía deben lanzar `IllegalStateException`. Rechazar operaciones inválidas sin modificar la cola. Probar cola vacía, un único trabajo, múltiples trabajos, archivos repetidos y nuevas inserciones después de vaciarla.

**Complejidad:** agregar, imprimir próximo, consultar próximo y verificar vacío: O(1). Mostrar pendientes: O(n). Espacio auxiliar por operación: O(1); almacenamiento total: O(n).

**Ejemplo principal:**
1. Crear una cola de impresión vacía.
2. Agregar `Informe.pdf` (5 páginas, Ana), `Apuntes.docx` (12 páginas, Luis) y `Factura.pdf` (2 páginas, Marta).
3. Consultar el próximo archivo y verificar que es `Informe.pdf`, sin retirarlo.
4. Mostrar los tres trabajos pendientes.
5. Procesar los trabajos y verificar el orden: `Informe.pdf` → `Apuntes.docx` → `Factura.pdf`.
6. Comprobar que la cola queda vacía, con `head == null` y `tail == null`.
7. Agregar un nuevo trabajo y verificar que la cola vuelve a funcionar.

**Pruebas:** comprobar FIFO, datos correctos, validaciones, consultas sin cambios, operaciones sobre cola vacía, conservación de identidad y enlaces, ausencia de ciclos y coherencia de `head` y `tail` después de cada operación.

**Restricciones:** implementar manualmente la cola mediante nodos. No utilizar `Queue`, `LinkedList`, `ArrayList`, `Deque`, arreglos ni otras colecciones para almacenar los trabajos. No depender de clases de otros ejercicios ni modificar sus archivos.

Compilar individualmente y conjuntamente con los ejercicios 1 al 8 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No realizar commits ni push.
*/
public class Ejercicio9 {
    public static class TrabajoImpresion {
        private final String nombreArchivo;
        private final int cantidadPaginas;
        private final String usuario;
        public TrabajoImpresion(String nombreArchivo, int cantidadPaginas, String usuario) {
            this.nombreArchivo = nombreArchivo;
            this.cantidadPaginas = cantidadPaginas;
            this.usuario = usuario;
        }
        public String getNombreArchivo() { return nombreArchivo; }
        public int getCantidadPaginas() { return cantidadPaginas; }
        public String getUsuario() { return usuario; }
        @Override public String toString() {
            return nombreArchivo + " (" + cantidadPaginas + " paginas, " + usuario + ")";
        }
    }
    public static class Nodo {
        private final TrabajoImpresion trabajo;
        private Nodo siguiente;
        public Nodo(TrabajoImpresion trabajo) { this.trabajo = trabajo; siguiente = null; }
    }
    public static class ColaImpresion {
        private Nodo head = null;
        private Nodo tail = null;
        public void agregarTrabajo(TrabajoImpresion trabajo) {
            // Validar todos los datos antes de crear o conectar un nodo.
            if (trabajo == null || trabajo.getNombreArchivo() == null || trabajo.getNombreArchivo().isBlank()
                    || trabajo.getUsuario() == null || trabajo.getUsuario().isBlank()
                    || trabajo.getCantidadPaginas() <= 0) {
                throw new IllegalArgumentException("Trabajo invalido: archivo y usuario requeridos, paginas positivas.");
            }
            Nodo nuevo = new Nodo(trabajo);
            if (estaVacia()) { head = nuevo; tail = nuevo; }
            else { tail.siguiente = nuevo; tail = nuevo; }
        }
        public TrabajoImpresion imprimirProximo() {
            if (estaVacia()) throw new IllegalStateException("No hay trabajos pendientes.");
            TrabajoImpresion trabajo = head.trabajo;
            head = head.siguiente; // FIFO: procesar el trabajo recibido primero.
            if (head == null) tail = null;
            // Simulacion mediante mensaje; no se envia nada a una impresora fisica.
            System.out.println("Procesado: " + trabajo);
            return trabajo;
        }
        public TrabajoImpresion consultarProximo() {
            if (estaVacia()) throw new IllegalStateException("No hay trabajos pendientes.");
            return head.trabajo;
        }
        public boolean estaVacia() { return head == null; }
        public void mostrarPendientes() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.trabajo + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        ColaImpresion cola = new ColaImpresion();
        cola.mostrarPendientes();
        cola.agregarTrabajo(new TrabajoImpresion("Informe.pdf", 5, "Ana"));
        cola.agregarTrabajo(new TrabajoImpresion("Apuntes.docx", 12, "Luis"));
        cola.agregarTrabajo(new TrabajoImpresion("Factura.pdf", 2, "Marta"));
        System.out.println("Proximo: " + cola.consultarProximo());
        cola.mostrarPendientes();
        while (!cola.estaVacia()) { cola.imprimirProximo(); cola.mostrarPendientes(); }
        System.out.println("head == null: " + (cola.head == null) + ", tail == null: " + (cola.tail == null));
        cola.agregarTrabajo(new TrabajoImpresion("Nuevo.pdf", 1, "Pedro"));
        cola.mostrarPendientes();
    }
}

// Ajustes al prompt: no fueron necesarios. Se rechazan tambien cadenas nulas o solo
// espacios. La insercion fisica cuesta O(1); validar los textos cuesta O(L).
