/*
Implementá en Java una pila genérica `Pila<T>` utilizando un arreglo de tamaño fijo, capaz de almacenar diferentes tipos de datos, como `Integer`, `String` y objetos definidos por el usuario.

**Estructura elegida:** pila genérica implementada manualmente mediante un arreglo, siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** utilizar una clase parametrizada `Pila<T>` para definir una estructura que pueda almacenar elementos de distintos tipos sin duplicar su implementación. Internamente, utilizar un arreglo `Object[]` de capacidad fija y una variable entera `top`, inicializada en -1. Los elementos deben agregarse, retirarse y consultarse exclusivamente por el extremo superior.

**Justificación:** una pila limitada a `int` solo permite almacenar enteros primitivos. El uso de genéricos permite reutilizar la misma estructura para números, textos y objetos, manteniendo comprobaciones de tipos durante la compilación y evitando crear una clase diferente para cada tipo de dato.

**Operaciones requeridas:**
- `push(T elemento)`: agregar un elemento al tope de la pila.
- `pop()`: retirar y devolver el elemento del tope.
- `peek()`: consultar el elemento superior sin retirarlo.
- `isEmpty()`: indicar si la pila está vacía.
- `isFull()`: indicar si se alcanzó la capacidad máxima.
- `size()`: devolver la cantidad de elementos almacenados.

**Manejo del arreglo interno:**
- Crear el almacenamiento mediante `new Object[capacidad]`, porque Java no permite crear directamente un arreglo con `new T[capacidad]`.
- Realizar las conversiones necesarias de `Object` a `T` únicamente dentro de la implementación de la pila.
- Si se utiliza `@SuppressWarnings("unchecked")`, aplicarlo exclusivamente a los métodos o expresiones que lo requieran y explicar por qué la conversión es segura.
- Mantener el arreglo encapsulado, sin exponerlo al código que utiliza la pila.
- Al ejecutar `pop()`, limpiar la posición liberada asignándole `null` para evitar conservar referencias innecesarias.

**Casos especiales:**
- Overflow: `push()` sobre una pila llena debe lanzar `IllegalStateException` sin modificar el estado.
- Underflow: `pop()` o `peek()` sobre una pila vacía deben lanzar `IllegalStateException` sin modificar el estado.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Elemento nulo: para mantener una política clara y evitar ambigüedades, rechazar `push(null)` mediante `IllegalArgumentException`, sin modificar la pila.
- Permitir elementos repetidos.

**Complejidad:**
- `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio5.java`.
- Implementar una clase pública `Ejercicio5` con un método `main`.
- Implementar una clase genérica `Pila<T>` de forma independiente, preferentemente como clase estática anidada en `Ejercicio5` para evitar conflictos de nombres con otros ejercicios.
- Utilizar exclusivamente un arreglo como estructura interna de almacenamiento.
- Mantener privados el arreglo y el índice `top`.
- Implementar manualmente las seis operaciones.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- Incorporar comentarios explicando el principio LIFO, la variable `top`, los genéricos, el arreglo `Object[]` y las conversiones controladas.
- Mostrar por pantalla el contenido lógico de la pila y los resultados de las operaciones.
- No depender de clases implementadas en otros ejercicios.

**Ejemplo principal con Integer:**
1. Crear `Pila<Integer>` de capacidad 3.
2. Ejecutar `push(10)`, `push(20)` y `push(30)`.
3. Comprobar que `peek()` devuelve 30 sin alterar el tamaño.
4. Retirar los elementos mediante `pop()` y verificar el orden 30, 20 y 10.

**Ejemplo con String:**
1. Crear `Pila<String>` de capacidad 3.
2. Agregar `"Ana"`, `"Juan"` y `"Lucia"`.
3. Verificar que los elementos se retiran en orden `"Lucia"`, `"Juan"` y `"Ana"`.

**Ejemplo con objetos:**
1. Crear una clase sencilla `Producto` con nombre y precio.
2. Crear `Pila<Producto>` de capacidad 3.
3. Agregar tres productos diferentes.
4. Verificar que `peek()` y `pop()` devuelvan los objetos correctos, respetando el orden LIFO.
5. Comprobar que el producto mantiene asociados su nombre y precio.

**Pruebas adicionales:**
- Pilas vacías y completamente llenas.
- Capacidad 1.
- Alternancia de `push` y `pop`.
- Elementos repetidos.
- Enteros negativos, cero y extremos de `int` mediante `Integer`.
- Cadenas vacías, si se desea almacenarlas como elementos válidos.
- Comprobar `isEmpty`, `isFull` y `size`.
- Verificar que `peek()` no modifica el estado.
- Verificar que overflow y underflow no alteran la pila.
- Rechazar capacidades inválidas y elementos nulos.
- Comprobar que las pilas de distintos tipos funcionan de manera independiente.
- Comprobar que no existan errores de tipos en tiempo de ejecución durante los casos válidos.

Compilar y ejecutar con Java 21 utilizando `-Xlint:all`, verificando los resultados y documentando las pruebas realmente realizadas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio5 {
    public static class Pila<T> {
        private final Object[] elementos;
        private int top = -1;

        public Pila(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
            }
            // Java no permite new T[]: el almacenamiento queda encapsulado.
            elementos = new Object[capacidad];
        }

        public void push(T elemento) {
            if (elemento == null) throw new IllegalArgumentException("No se admiten elementos nulos.");
            if (isFull()) throw new IllegalStateException("Overflow: pila llena.");
            elementos[++top] = elemento;
        }

        public T pop() {
            if (isEmpty()) throw new IllegalStateException("Underflow: pila vacia.");
            // Seguro con uso generico tipado: solo push(T) escribe en el arreglo privado.
            @SuppressWarnings("unchecked")
            T elemento = (T) elementos[top];
            elementos[top--] = null; // Liberar la referencia al retirar el objeto.
            return elemento;
        }

        public T peek() {
            if (isEmpty()) throw new IllegalStateException("Underflow: pila vacia.");
            // La misma garantia de push(T) permite recuperar T sin exponer Object[].
            @SuppressWarnings("unchecked")
            T elemento = (T) elementos[top];
            return elemento; // Consultar no modifica top ni el contenido.
        }

        public boolean isEmpty() { return top == -1; }
        public boolean isFull() { return top == elementos.length - 1; }
        public int size() { return top + 1; }
    }

    public static class Producto {
        private final String nombre;
        private final double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }

        @Override
        public String toString() { return nombre + " ($" + precio + ")"; }
    }

    private static void mostrar(Pila<?> pila) {
        System.out.print("Pila (base a tope): [");
        for (int i = 0; i <= pila.top; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(pila.elementos[i]);
        }
        System.out.println("] size = " + pila.size());
    }

    private static <T> void demostrar(Pila<T> pila) {
        mostrar(pila);
        System.out.println("peek(): " + pila.peek());
        mostrar(pila);
        // LIFO: cada pop devuelve el ultimo elemento que sigue almacenado.
        while (!pila.isEmpty()) {
            System.out.println("pop(): " + pila.pop());
            mostrar(pila);
        }
    }

    public static void main(String[] args) {
        Pila<Integer> enteros = new Pila<>(3);
        enteros.push(10);
        enteros.push(20);
        enteros.push(30);
        demostrar(enteros);

        Pila<String> nombres = new Pila<>(3);
        nombres.push("Ana");
        nombres.push("Juan");
        nombres.push("Lucia");
        demostrar(nombres);

        Pila<Producto> productos = new Pila<>(3);
        productos.push(new Producto("Cuaderno", 2500));
        productos.push(new Producto("Lapiz", 500));
        productos.push(new Producto("Regla", 800));
        demostrar(productos);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
