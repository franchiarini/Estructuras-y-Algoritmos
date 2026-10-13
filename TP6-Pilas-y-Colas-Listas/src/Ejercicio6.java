/*
Implementar desde cero un sistema de atención de clientes de un banco mediante una cola enlazada, respetando el orden FIFO (First In, First Out).

**Estructura y justificación:** utilizar una cola de nodos que almacenan objetos `Cliente`. Cada nodo contiene el cliente y una referencia al siguiente. Mantener `head` para identificar al próximo cliente y `tail` para incorporar nuevos clientes al final. Así, agregar y atender cuestan O(1) sin recorrer la fila.

**Clases:**
- `Ejercicio6`: clase pública con `main`.
- `Cliente`: contiene nombre (`String`), número de turno (`int`) y motivo de consulta (`String`), con constructor, getters y `toString()`.
- `Nodo`: contiene un objeto `Cliente` y una referencia al siguiente nodo.
- `ColaAtencion`: mantiene `head` y `tail` privados y administra la fila.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio6`.

**Operaciones:**
- `void agregarCliente(Cliente cliente)`: agregar al final de la fila. Si está vacía, `head` y `tail` apuntan al nuevo nodo; si no, conectar `tail.siguiente` y actualizar `tail`.
- `Cliente atenderProximo()`: retirar y devolver el primer cliente. Avanzar `head` y, si la fila queda vacía, establecer también `tail = null`.
- `Cliente consultarSiguiente()`: devolver el cliente de `head` sin retirarlo.
- `void imprimirFila()`: recorrer desde `head` mostrando nombre, turno y motivo en orden de llegada.
- `boolean estaVacia()`: indicar si `head == null`.

**Casos especiales:** fila vacía, un solo cliente, varios clientes, atención hasta vaciar la cola y nuevos ingresos posteriores. Rechazar `cliente == null`, nombres o motivos vacíos y turnos negativos mediante `IllegalArgumentException`, sin alterar la cola. `atenderProximo()` y `consultarSiguiente()` sobre una fila vacía deben lanzar `IllegalStateException`.

Los turnos se reciben como parte de cada objeto `Cliente`; el sistema atiende según el orden de inserción, sin ordenar automáticamente por número de turno.

**Manejo de referencias:** garantizar que `head` represente al primero de la fila y `tail` al último. En una fila vacía, ambos son `null`; con un solo cliente apuntan al mismo nodo. El último nodo siempre debe tener `siguiente == null`. Conservar los objetos y enlaces de los clientes pendientes.

**Complejidad:** agregar, atender, consultar y verificar vacío: O(1). Imprimir la fila: O(n). Espacio auxiliar por operación: O(1); almacenamiento total: O(n).

**Ejemplo principal:**
1. Crear una fila vacía.
2. Agregar Ana (turno 101, depósito), Luis (102, consulta) y Marta (103, transferencia).
3. Verificar que el próximo cliente es Ana.
4. Mostrar los tres clientes en orden.
5. Atender y comprobar la secuencia Ana → Luis → Marta.
6. Verificar que `head == null` y `tail == null` al vaciarse.
7. Agregar Pedro (104, extracción) y comprobar que la fila vuelve a funcionar.

**Pruebas:** comprobar FIFO, datos de los clientes, consulta sin eliminación, rechazo de datos inválidos, fila vacía, nodo único, múltiples llegadas y atenciones, actualización de `head` y `tail`, identidad de clientes, ausencia de ciclos y conservación del orden de llegada.

**Restricciones:** implementar manualmente mediante nodos, sin arreglos ni colecciones predefinidas (`Queue`, `LinkedList`, `ArrayList`, `Deque`, etc.). No depender de otros ejercicios ni modificar sus archivos.

Compilar individualmente y conjuntamente con los ejercicios 1 al 5 con Java 21, `--release 21` y `-Xlint:all`. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No realizar commits ni push.
*/
public class Ejercicio6 {
    public static class Cliente {
        private final String nombre;
        private final int turno;
        private final String motivo;
        public Cliente(String nombre, int turno, String motivo) {
            this.nombre = nombre; this.turno = turno; this.motivo = motivo;
        }
        public String getNombre() { return nombre; }
        public int getTurno() { return turno; }
        public String getMotivo() { return motivo; }
        @Override public String toString() { return nombre + " (turno " + turno + ", " + motivo + ")"; }
    }
    public static class Nodo {
        private final Cliente cliente;
        private Nodo siguiente;
        public Nodo(Cliente cliente) { this.cliente = cliente; siguiente = null; }
    }
    public static class ColaAtencion {
        private Nodo head = null;
        private Nodo tail = null;
        public void agregarCliente(Cliente cliente) {
            // Validar antes de crear o enlazar: ninguna entrada invalida altera la fila.
            if (cliente == null || cliente.getNombre() == null || cliente.getNombre().isBlank()
                    || cliente.getMotivo() == null || cliente.getMotivo().isBlank() || cliente.getTurno() < 0) {
                throw new IllegalArgumentException("Cliente invalido: nombre y motivo requeridos, turno no negativo.");
            }
            Nodo nuevo = new Nodo(cliente);
            if (estaVacia()) { head = nuevo; tail = nuevo; }
            else { tail.siguiente = nuevo; tail = nuevo; }
        }
        public Cliente atenderProximo() {
            if (estaVacia()) throw new IllegalStateException("No hay clientes para atender.");
            Cliente cliente = head.cliente;
            head = head.siguiente; // FIFO por llegada, sin ordenar por turno.
            if (head == null) tail = null;
            return cliente;
        }
        public Cliente consultarSiguiente() {
            if (estaVacia()) throw new IllegalStateException("No hay clientes en la fila.");
            return head.cliente;
        }
        public boolean estaVacia() { return head == null; }
        public void imprimirFila() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.cliente + " -> ");
                actual = actual.siguiente; // Recorrido local sin cambiar enlaces.
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        ColaAtencion fila = new ColaAtencion();
        fila.imprimirFila();
        fila.agregarCliente(new Cliente("Ana", 101, "deposito"));
        fila.agregarCliente(new Cliente("Luis", 102, "consulta"));
        fila.agregarCliente(new Cliente("Marta", 103, "transferencia"));
        System.out.println("Siguiente: " + fila.consultarSiguiente());
        fila.imprimirFila();
        while (!fila.estaVacia()) {
            System.out.println("Atendido: " + fila.atenderProximo());
            fila.imprimirFila();
        }
        System.out.println("head == null: " + (fila.head == null) + ", tail == null: " + (fila.tail == null));
        fila.agregarCliente(new Cliente("Pedro", 104, "extraccion"));
        fila.imprimirFila();
        System.out.println("Siguiente: " + fila.consultarSiguiente());
    }
}

// Ajustes al prompt: no fueron necesarios. Se rechazan tambien nombres y motivos
// nulos o solo espacios. La insercion fisica es O(1); validar cadenas cuesta O(L).
