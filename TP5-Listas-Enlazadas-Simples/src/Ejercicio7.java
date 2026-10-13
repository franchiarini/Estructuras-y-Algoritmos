/*
Implementá en Java un programa que permita modificar el dato almacenado en una posición específica de una lista enlazada simple de enteros, utilizando el método `void modificar(int posicion, int nuevoDato)`.

**Estructura elegida:** lista enlazada simple formada por nodos que contienen un dato entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, utilizando `head` para acceder al primer nodo y `size` para conocer la cantidad de elementos. Para modificar un elemento, validar primero la posición solicitada, recorrer la lista desde `head` hasta llegar al nodo correspondiente y actualizar únicamente su atributo `dato`.

**Justificación:** una lista enlazada simple no permite acceder directamente por índice como un arreglo. Por eso, aunque conozcamos la posición del elemento, debemos recorrer los nodos mediante sus referencias `siguiente`. Una vez localizado el nodo, modificar su contenido no requiere cambiar sus enlaces ni crear un nodo nuevo.

**Estructura de clases:**
- `Nodo`: contiene `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones sobre la lista.
- `Ejercicio7`: clase pública con método `main` para ejecutar los ejemplos y las pruebas.

**Método principal:**

`void modificar(int posicion, int nuevoDato)`

Debe realizar los siguientes pasos:

1. Validar que `posicion` esté comprendida entre 0 y `size - 1`.
2. Si `posicion < 0` o `posicion >= size`, lanzar `IndexOutOfBoundsException`.
3. Crear una referencia auxiliar `actual` que inicialmente apunte a `head`.
4. Avanzar exactamente `posicion` veces mediante `actual = actual.getSiguiente()`.
5. Una vez ubicado el nodo correspondiente, ejecutar `actual.setDato(nuevoDato)`.
6. Finalizar sin modificar los enlaces, la referencia `head` ni el atributo `size`.

**Validación de posiciones:**
- Aceptar posiciones desde 0 hasta `size - 1`.
- Rechazar posiciones negativas.
- Rechazar posiciones iguales a `size`.
- Rechazar posiciones mayores que `size`.
- Rechazar cualquier posición si la lista está vacía.
- Utilizar `IndexOutOfBoundsException` en todos los casos inválidos.
- Validar antes de comenzar el recorrido y antes de modificar cualquier dato.
- Las operaciones inválidas deben conservar íntegramente el estado previo de la lista.

**Diferencia entre modificar datos y referencias:**

Modificar el dato:

`actual.setDato(nuevoDato);`

Esta instrucción reemplaza el valor almacenado en el nodo, pero no cambia su ubicación lógica ni la conexión con el siguiente nodo.

Modificar una referencia:

`actual.setSiguiente(otroNodo);`

Esta instrucción cambia el enlace hacia otro nodo y podría alterar la estructura de la lista.

En este ejercicio debe modificarse exclusivamente el atributo `dato`. No deben modificarse referencias `siguiente` para reemplazar un valor.

**Manejo de referencias:**
- Comenzar el recorrido desde `head`.
- Utilizar una referencia auxiliar `actual`.
- Avanzar mediante `actual.getSiguiente()` hasta la posición solicitada.
- No modificar `head`.
- No modificar ningún atributo `siguiente`.
- No crear nodos nuevos.
- No eliminar nodos.
- No reemplazar objetos Nodo por otros objetos.
- No modificar los datos de las posiciones distintas de la indicada.
- No incrementar ni disminuir `size`.
- Conservar la identidad de todos los nodos originales.
- Mantener el último nodo conectado a `null`.
- Evitar ciclos y pérdidas de referencias.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `obtener(int posicion)`, para consultar y verificar resultados.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Las operaciones auxiliares deben respetar la implementación básica de los ejercicios anteriores y permitir construir los escenarios de prueba. El Ejercicio 7 debe funcionar independientemente de los demás archivos.

**Casos especiales:**
- Lista vacía: cualquier modificación debe lanzar `IndexOutOfBoundsException`.
- Lista de un solo nodo: solamente puede modificarse la posición 0.
- Modificar el primer nodo.
- Modificar un nodo intermedio.
- Modificar el último nodo.
- Modificar varias veces consecutivas la misma posición.
- Modificar distintas posiciones de una misma lista.
- Reemplazar un dato por el mismo valor que ya contiene.
- Modificar nodos que contienen valores repetidos, sin alterar los otros nodos con el mismo valor.
- Utilizar como nuevo dato números negativos, cero, `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Rechazar posiciones negativas, iguales a `size` o superiores.
- Comprobar que toda modificación válida conserva `head`, `size`, la identidad de los nodos y sus enlaces.
- Comprobar que las modificaciones inválidas no cambian ningún dato ni referencia.

**Complejidad:**
- Validación de posición: O(1), porque se utiliza `size`.
- Modificar posición 0: O(1).
- Modificar una posición intermedia: O(n) en el peor caso.
- Modificar la última posición: O(n).
- Actualizar el atributo `dato` una vez localizado el nodo: O(1).
- Espacio auxiliar de `modificar`: O(1), porque solamente se utiliza una referencia auxiliar.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza `tail`.
- `obtener`: O(n) en el peor caso.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio7.java`.
- Implementar una clase pública `Ejercicio7` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio7`, para evitar conflictos de nombres.
- Implementar manualmente los nodos y referencias.
- Mantener privados los atributos internos de las clases auxiliares.
- Mantener `head` y `size` como únicos atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para implementar la modificación.
- No utilizar `Stream` ni conversiones a arreglos para resolver el problema.
- No depender de clases implementadas en otros ejercicios.
- Incorporar comentarios que expliquen la validación de posiciones, el recorrido secuencial y la diferencia entre modificar el contenido de un nodo y modificar sus referencias.
- Mostrar claramente el contenido de la lista antes y después de cada modificación importante.
- Verificar que el atributo `size` coincida con la cantidad de nodos alcanzables desde `head`.
- Verificar que la lista no tenga ciclos y termine en `null`.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 30 y 40.
3. Mostrar `10 -> 20 -> 30 -> 40 -> null`, con `size = 4`.
4. Ejecutar `modificar(2, 99)`.
5. Verificar `10 -> 20 -> 99 -> 40 -> null`, con `size = 4`.
6. Ejecutar `modificar(0, 5)`.
7. Verificar `5 -> 20 -> 99 -> 40 -> null`, con `size = 4`.
8. Ejecutar `modificar(3, 50)`.
9. Verificar `5 -> 20 -> 99 -> 50 -> null`, con `size = 4`.
10. Ejecutar `modificar(1, 20)` y comprobar que reemplazar un valor por sí mismo no altera la estructura.
11. Intentar `modificar(-1, 100)` y verificar `IndexOutOfBoundsException`.
12. Intentar `modificar(4, 100)` y verificar `IndexOutOfBoundsException`.
13. Intentar `modificar(100, 100)` y verificar `IndexOutOfBoundsException`.
14. Comprobar que todas las operaciones inválidas conservaron el contenido, `head`, `size` y los enlaces.
15. Verificar que los cuatro nodos originales continúan presentes y en el mismo orden.

**Ejemplo adicional con duplicados:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `modificar(2, 99)`.
3. Verificar `10 -> 20 -> 99 -> 30 -> 10 -> null`.
4. Comprobar que solamente se modificó el nodo de la posición 2.
5. Verificar que los otros dos nodos que contienen 10 permanecen sin cambios.
6. Comprobar que `size` sigue siendo 5.

**Pruebas adicionales:**
- Modificar una lista vacía.
- Modificar el único nodo de una lista.
- Rechazar la posición 1 en una lista de un solo nodo.
- Modificar la posición 0.
- Modificar posiciones intermedias.
- Modificar la última posición.
- Modificar el mismo nodo varias veces.
- Modificar diferentes nodos consecutivamente.
- Reemplazar un dato por el mismo valor.
- Modificar un nodo entre valores repetidos.
- Usar datos negativos, cero y extremos de `int`.
- Rechazar posiciones negativas.
- Rechazar posiciones iguales o superiores a `size`.
- Rechazar `Integer.MIN_VALUE` e `Integer.MAX_VALUE` cuando se utilicen como índices inválidos.
- Alternar inserciones y modificaciones.
- Verificar que `head` no cambia.
- Verificar que `size` no cambia.
- Comprobar que los nodos mantienen su identidad.
- Comprobar que los enlaces `siguiente` permanecen idénticos.
- Comprobar que solamente cambia el dato del nodo solicitado.
- Verificar que las excepciones no modifican el estado.
- Verificar que el último nodo apunta a `null`.
- Comprobar que no se generan ciclos ni nodos inaccesibles.
- Comprobar que imprimir no modifica la estructura.

Compilar individualmente y conjuntamente con los ejercicios 1 al 6 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio7 {
    public static class Nodo {
        private int dato;
        private Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            siguiente = null;
        }
        public void setDato(int dato) { this.dato = dato; }
        public int getDato() { return dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    public static class ListaEnlazada {
        private Nodo head = null; // Punto de entrada a todos los nodos de la lista.
        private int size = 0;

        public void insertarAlInicio(int dato) {
            Nodo nuevo = new Nodo(dato);
            // Conectar primero con el comienzo anterior para no perder sus nodos.
            nuevo.setSiguiente(head);
            head = nuevo;
            size++;
        }
        public void insertarAlFinal(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (estaVacia()) {
                head = nuevo;
            } else {
                // Sin tail: seguir las referencias hasta el ultimo nodo.
                Nodo actual = head;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevo);
            }
            size++; // Una sola actualizacion, tanto en lista vacia como no vacia.
        }
        public void imprimir() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente(); // Cambia la referencia local, no los enlaces.
            }
            System.out.println("null");
        }
        public int obtener(int posicion) {
            // Validar con size antes de recorrer: nunca acceder a un nodo inexistente.
            if (posicion < 0 || posicion >= size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
            Nodo actual = head;
            // A diferencia del arreglo, seguimos enlaces: exactamente posicion avances.
            // Para la posicion cero no se recorre ningun enlace.
            for (int i = 0; i < posicion; i++) actual = actual.getSiguiente();
            return actual.getDato(); // No cambia datos, enlaces, head ni size.
        }
        public void modificar(int posicion, int nuevoDato) {
            // Validar antes de recorrer o cambiar un dato, incluso en lista vacia.
            if (posicion < 0 || posicion >= size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
            Nodo actual = head;
            // La posicion cero no requiere avanzar; las demas requieren seguir enlaces.
            for (int i = 0; i < posicion; i++) actual = actual.getSiguiente();
            // Cambiar contenido conserva identidad y enlaces. setSiguiente cambiaria la estructura.
            actual.setDato(nuevoDato);
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    private static void mostrar(ListaEnlazada lista) {
        lista.imprimir();
        System.out.println("size = " + lista.getSize());
    }
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 30, 40}) lista.insertarAlFinal(dato);
        mostrar(lista);
        int[][] cambios = {{2, 99}, {0, 5}, {3, 50}, {1, 20}, {-1, 100}, {4, 100}, {100, 100}};
        for (int[] cambio : cambios) {
            System.out.println("modificar(" + cambio[0] + ", " + cambio[1] + ")");
            try {
                lista.modificar(cambio[0], cambio[1]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException: " + e.getMessage());
            }
            mostrar(lista);
        }
        System.out.println("Ejemplo con duplicados:");
        ListaEnlazada duplicados = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 10, 30, 10}) duplicados.insertarAlFinal(dato);
        mostrar(duplicados);
        duplicados.modificar(2, 99);
        mostrar(duplicados);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.
