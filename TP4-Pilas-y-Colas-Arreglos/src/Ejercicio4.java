/*
Implementá en Java un simulador simple del historial de navegación de un navegador web, utilizando una pila de URLs construida manualmente mediante un arreglo de cadenas String de tamaño fijo.

**Estructura elegida:** pila (Stack) de URLs, siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** representar cada página visitada mediante su URL y almacenarla en un arreglo `String[]`. Utilizar una variable `top`, inicialmente igual a -1, para identificar la última página visitada. Cada nueva visita agrega una URL mediante `push()`. Para volver a la página anterior, retirar la página actual mediante `pop()` y consultar la nueva página del tope mediante `peek()`.

**Justificación:** el historial de navegación funciona bajo el principio LIFO porque, al retroceder, primero abandonamos la página visitada más recientemente. Una pila permite recuperar las páginas en orden inverso al de sus visitas.

**Operaciones:**
- `visitar(String url)`: agregar una nueva página al historial mediante `push()`.
- `volverAtras()`: retirar la página actual mediante `pop()` y devolver la URL de la página anterior mediante `peek()`.
- `paginaActual()`: consultar la URL en el tope sin modificar la estructura.
- `isEmpty()`: indicar si no hay páginas visitadas.
- `isFull()`: indicar si el historial alcanzó su capacidad máxima.
- `size()`: devolver la cantidad de páginas almacenadas.
- `vaciarHistorial()`: dejar el historial vacío para permitir una nueva secuencia de navegación.

**Casos especiales:**
- Historial vacío: no existe una página actual ni es posible retroceder.
- Una sola página: no se puede volver atrás porque no existe una página anterior.
- Historial lleno: si se intenta visitar una nueva página, debe producirse overflow.
- URLs inválidas: rechazar entradas `null`, vacías o compuestas únicamente por espacios mediante `IllegalArgumentException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Ante operaciones inválidas, conservar íntegramente el estado anterior del historial.

**Política de errores:**
- `paginaActual()` sobre un historial vacío debe lanzar `IllegalStateException`.
- `volverAtras()` con cero o una página debe lanzar `IllegalStateException`.
- `visitar()` sobre un historial lleno debe lanzar `IllegalStateException`.
- `vaciarHistorial()` puede ejecutarse incluso cuando el historial ya esté vacío.

**Complejidad:**
- `visitar`, `volverAtras`, `paginaActual`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- `vaciarHistorial`: O(1) si solamente reinicia el índice lógico `top`.
- Espacio del arreglo interno: O(C), siendo C la capacidad fija del historial.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio4.java`.
- Implementar una clase pública `Ejercicio4` con método `main`.
- Implementar una clase auxiliar propia para administrar el historial mediante `String[]` y `top`, evitando conflictos de nombres con las clases de los ejercicios anteriores.
- Mantener privados el arreglo y el índice `top`.
- No depender de las clases de otros ejercicios.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar el historial.
- No implementar funcionalidades adicionales no solicitadas, como navegación hacia adelante o manejo de pestañas.
- Incorporar comentarios que expliquen la relación entre el historial y LIFO, el funcionamiento de `push`, `pop` y `peek`, y las validaciones.
- Mostrar las URLs visitadas, la página actual y los retrocesos realizados.
- Mostrar mensajes claros cuando una operación no puede efectuarse.

**Ejemplo principal:**
1. Crear un historial con capacidad 3.
2. Visitar `google.com`.
3. Visitar `youtube.com`.
4. Visitar `github.com`.
5. Consultar la página actual: debe ser `github.com`.
6. Intentar visitar `stackoverflow.com`: debe producir overflow.
7. Volver atrás: debe devolver `youtube.com`.
8. Volver atrás nuevamente: debe devolver `google.com`.
9. Intentar volver atrás por tercera vez: debe producir underflow lógico porque no hay una página anterior.
10. Vaciar el historial y comprobar que queda vacío.
11. Intentar consultar la página actual sobre el historial vacío: debe producir `IllegalStateException`.

**Pruebas adicionales:**
- Historial de capacidad 1.
- Visitas y retrocesos alternados.
- URLs repetidas.
- Comprobación de que consultar la página actual no elimina elementos.
- Comprobación del orden LIFO.
- Comprobación de que overflow y retrocesos inválidos no alteran el historial.
- Rechazo de URLs nulas, vacías y con espacios.
- Rechazo de capacidades inválidas.
- Comprobación de que es posible volver a visitar páginas después de retroceder.
- Comprobación de que `vaciarHistorial()` reinicia el estado lógico.

Compilar y ejecutar con Java 21 utilizando `-Xlint:all`, verificando el funcionamiento mediante pruebas reales y documentando sus resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio4 {
    public static class HistorialNavegacion {
        private final String[] urls;
        private int top = -1;

        public HistorialNavegacion(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
            }
            urls = new String[capacidad];
        }

        public void visitar(String url) {
            // isBlank recorre la URL: O(L). No se cambia el texto recibido.
            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException("La URL no puede ser nula, vacia ni solo espacios.");
            }
            push(url);
        }

        private void push(String url) {
            // Verificar overflow antes de modificar el historial.
            if (isFull()) throw new IllegalStateException("Overflow: historial lleno.");
            urls[++top] = url;
        }

        private String pop() {
            if (isEmpty()) throw new IllegalStateException("Historial vacio.");
            String url = urls[top];
            urls[top--] = null;
            return url;
        }

        private String peek() {
            if (isEmpty()) throw new IllegalStateException("No existe una pagina actual.");
            return urls[top];
        }

        public String volverAtras() {
            // Validar antes de retirar: la unica pagina debe conservarse.
            if (size() < 2) throw new IllegalStateException("No existe una pagina anterior.");
            // LIFO: abandonar la ultima visita y consultar la anterior.
            pop();
            return peek();
        }

        public String paginaActual() { return peek(); }
        public boolean isEmpty() { return top == -1; }
        public boolean isFull() { return top == urls.length - 1; }
        public int size() { return top + 1; }

        public void vaciarHistorial() {
            // Reinicio logico O(1); las referencias anteriores quedan fuera del historial.
            top = -1;
        }
    }

    private static void mostrarEstado(HistorialNavegacion historial) {
        System.out.println("Paginas: " + historial.size() + ", vacio: " + historial.isEmpty()
                + ", lleno: " + historial.isFull());
        if (!historial.isEmpty()) System.out.println("Pagina actual: " + historial.paginaActual());
    }

    public static void main(String[] args) {
        HistorialNavegacion historial = new HistorialNavegacion(3);
        for (String url : new String[]{"google.com", "youtube.com", "github.com"}) {
            historial.visitar(url);
            System.out.println("Visita: " + url);
            mostrarEstado(historial);
        }
        System.out.println("Consulta: " + historial.paginaActual());
        System.out.println("Intento de visita: stackoverflow.com");
        try {
            historial.visitar("stackoverflow.com");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        mostrarEstado(historial);
        for (int i = 0; i < 2; i++) {
            System.out.println("Volver atras: " + historial.volverAtras());
            mostrarEstado(historial);
        }
        try {
            historial.volverAtras();
        } catch (IllegalStateException e) {
            System.out.println("Retroceso rechazado: " + e.getMessage());
        }
        mostrarEstado(historial);
        historial.vaciarHistorial();
        System.out.println("Historial vaciado.");
        mostrarEstado(historial);
        try {
            historial.paginaActual();
        } catch (IllegalStateException e) {
            System.out.println("Consulta rechazada: " + e.getMessage());
        }
    }
}

/* Ajustes: no se modifico el prompt original ni el algoritmo.
   Precision de complejidad: visitar tiene O(1) para el push y O(L) en el peor caso
   para validar una URL de longitud L mediante isBlank(). */
