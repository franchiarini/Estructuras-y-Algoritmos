# TP5 — Listas Enlazadas Simples

### Metodología de trabajo

ChatGPT actúa como agente analista: estudia las consignas, razona sobre las referencias, selecciona las estrategias y elabora los prompts. Codex actúa como agente desarrollador: implementa en Java, compila, ejecuta pruebas y documenta los resultados reales.

Los prompts iniciales se conservan literalmente en este README y al comienzo de cada archivo Java; los ajustes se registran expresamente.

### Ejercicio 1 — Crear una lista enlazada simple desde cero

**Estrategia:** conectar objetos `Nodo` mediante referencias `siguiente`, administrando solamente `head` y `size`. El recorrido comienza en `head` y termina en `null`, sin referencia `tail` ni arreglos de almacenamiento.

**Justificación:** la lista crece creando nodos, sin necesitar un arreglo de capacidad fija. A cambio, no ofrece acceso directo por índice y requiere recorridos para localizar el último elemento.

**Estructura de clases:** `Ejercicio1` contiene el `main` y las clases estáticas anidadas `Nodo` y `ListaEnlazada`. `Nodo` tiene un entero privado y una referencia privada al siguiente, inicialmente nula, con constructor y métodos de acceso. `ListaEnlazada` tiene únicamente `head` y `size` como atributos privados de control, inicialmente null y 0.

**Operaciones:** `insertarAlInicio(int dato)` conecta un nuevo primer nodo; `insertarAlFinal(int dato)` recorre hasta el último y conecta el nuevo; `imprimir()` muestra los datos seguidos de `->` y termina en `null`; `estaVacia()` comprueba `head == null`; `getSize()` devuelve el contador sin recorrer. Cada inserción incrementa el tamaño una sola vez.

**Manejo de referencias:** al insertar al inicio se ejecuta primero `nuevo.setSiguiente(head)` y después `head = nuevo`, conservando el acceso a los nodos anteriores. Al insertar al final se asigna `head` si la lista está vacía; en otro caso se enlaza el último nodo con el nuevo. El nuevo nodo termina en `null`. La impresión avanza una referencia local sin modificar los enlaces.

**Complejidad:** inserción al inicio O(1), inserción al final O(n), impresión O(n), consulta de vacío O(1) y consulta de tamaño O(1). Almacenamiento total O(n) para los nodos; espacio auxiliar O(1) por operación, sin contar el nuevo nodo de cada inserción.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una lista enlazada simple de números enteros desde cero, utilizando nodos conectados mediante referencias y sin emplear colecciones predefinidas de Java.

**Estructura elegida:** lista enlazada simple, formada por objetos `Nodo` que almacenan un entero y una referencia al siguiente nodo.

**Estrategia:** implementar una clase `Nodo` con los atributos `dato` y `siguiente`, y una clase `ListaEnlazada` con los atributos `head` y `size`. Utilizar `head` para acceder al primer nodo y recorrer la lista mediante referencias `siguiente`, hasta llegar a `null`.

**Justificación:** una lista enlazada simple permite almacenar elementos dinámicamente sin utilizar un arreglo de tamaño fijo. Cada nodo conoce al siguiente y los elementos pueden incorporarse modificando referencias. La lista no permite acceso directo por índice, por lo que determinadas operaciones requieren un recorrido secuencial.

**Representación de los nodos:**
- Cada nodo debe almacenar un atributo `int dato`.
- Cada nodo debe almacenar una referencia `Nodo siguiente`.
- Al crear un nodo, su referencia `siguiente` debe inicializarse en `null`.
- El último nodo de la lista siempre debe tener `siguiente == null`.

**Representación de la lista:**
- Utilizar una referencia `head` al primer nodo.
- Utilizar un atributo `size` para almacenar la cantidad de elementos.
- Inicializar `head = null` y `size = 0`.
- La lista estará vacía cuando `head == null`.
- Mantener la relación entre la cantidad de nodos alcanzables desde `head` y el atributo `size`.
- Utilizar solamente `head` y `size` como atributos de control; no agregar una referencia `tail` en esta implementación básica.

**Operaciones requeridas:**

1. `insertarAlInicio(int dato)`:
   - Crear un nuevo nodo.
   - Hacer que el nuevo nodo apunte al nodo actualmente referenciado por `head`.
   - Actualizar `head` para que apunte al nuevo nodo.
   - Incrementar `size` exactamente una vez.
   - Explicar por qué es importante actualizar las referencias en ese orden.

2. `insertarAlFinal(int dato)`:
   - Crear un nuevo nodo.
   - Si la lista está vacía, asignarlo directamente a `head`.
   - Si no está vacía, recorrer desde `head` hasta encontrar el último nodo.
   - Conectar el último nodo con el nuevo.
   - Incrementar `size` exactamente una vez.

3. `imprimir()`:
   - Recorrer la lista comenzando desde `head`.
   - Mostrar el dato de cada nodo seguido de `->`.
   - Terminar siempre con `null`.
   - Para una lista vacía, mostrar solamente `null`.
   - No modificar las referencias ni el tamaño durante el recorrido.

4. `estaVacia()`:
   - Devolver `true` cuando `head == null`.
   - Devolver `false` cuando exista al menos un nodo.

5. `getSize()`:
   - Devolver el valor del atributo `size`.
   - No recorrer la lista para calcular la cantidad de elementos.

**Orden correcto de las referencias:**

Al insertar al inicio debe realizarse primero:

`nuevo.setSiguiente(head);`

Y después:

`head = nuevo;`

Si se modifica primero `head`, se puede perder la referencia al comienzo original de la lista, dejando nodos inaccesibles.

**Complejidad:**
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque debe recorrerse la lista cuando no está vacía.
- `imprimir`: O(n).
- `estaVacia`: O(1).
- `getSize`: O(1).
- Espacio total de almacenamiento: O(n), correspondiente a los nodos.
- Espacio auxiliar de las operaciones: O(1), sin contar el nuevo nodo creado al insertar.

**Requisitos de implementación:**
- Crear `src/Ejercicio1.java` dentro de la carpeta real del TP5.
- Implementar una clase pública `Ejercicio1` con método `main`.
- Implementar las clases auxiliares `Nodo` y `ListaEnlazada`, preferentemente como clases estáticas anidadas dentro de `Ejercicio1`, evitando conflictos con los demás ejercicios.
- Utilizar referencias entre objetos para construir la lista.
- Mantener privados los atributos `dato`, `siguiente`, `head` y `size`.
- Incorporar los constructores y métodos de acceso necesarios.
- No utilizar arreglos como almacenamiento de la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue` ni colecciones predefinidas para implementar la estructura.
- No utilizar métodos de ordenamiento o estructuras auxiliares que sustituyan el recorrido enlazado.
- Incluir comentarios que expliquen qué es un nodo, qué representa `head`, cómo se conectan las referencias y cómo se administra `size`.
- Cada operación debe mantener la lista correctamente enlazada y terminar en `null`.
- No depender de clases de otros ejercicios.

**Ejemplo principal:**

1. Crear una lista vacía.
2. Verificar que `estaVacia()` devuelva `true` y `getSize()` devuelva 0.
3. Ejecutar `insertarAlInicio(30)`.
4. Ejecutar `insertarAlInicio(20)`.
5. Ejecutar `insertarAlInicio(10)`.
6. Mostrar la lista: `10 -> 20 -> 30 -> null`.
7. Verificar que el tamaño sea 3.
8. Ejecutar `insertarAlFinal(40)`.
9. Mostrar la lista: `10 -> 20 -> 30 -> 40 -> null`.
10. Ejecutar `insertarAlFinal(50)`.
11. Mostrar la lista: `10 -> 20 -> 30 -> 40 -> 50 -> null`.
12. Verificar que el tamaño sea 5 y `estaVacia()` devuelva `false`.

**Pruebas adicionales:**
- Lista recién creada y vacía.
- Insertar al inicio de una lista vacía.
- Insertar al final de una lista vacía.
- Insertar al inicio y al final de una lista con un solo elemento.
- Alternar inserciones al inicio y al final.
- Insertar números negativos.
- Insertar el valor cero.
- Insertar números repetidos.
- Insertar `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que el tamaño aumenta exactamente una unidad por inserción.
- Verificar que imprimir no altera la lista.
- Comprobar que el orden de los elementos es el esperado.
- Verificar que todos los nodos sean alcanzables desde `head`.
- Verificar que el último nodo apunta a `null` y que no se generan ciclos.

Compilar individualmente y ejecutar con Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Realizar pruebas reales, informando los resultados obtenidos.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. Se utilizó la carpeta existente `TP5-Listas-Enlazadas-Simples`. El prompt original permanece literal y la ausencia de ajustes se registra también al final del archivo Java.

#### Resultado

Se implementó la lista manualmente mediante nodos, sin colecciones predefinidas, arreglos de almacenamiento ni dependencias de otros ejercicios.

Compilación individual correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias. Se ejecutaron el `main` y una prueba independiente con 318 verificaciones aprobadas y 0 fallidas.

Salida del ejemplo principal:

~~~text
Vacia: true, size = 0
null
10 -> 20 -> 30 -> null
size = 3
10 -> 20 -> 30 -> 40 -> null
10 -> 20 -> 30 -> 40 -> 50 -> null
Vacia: false, size = 5
~~~

Se probaron la lista vacía, inserciones al inicio y al final sobre lista vacía y unitaria, inserciones alternadas, negativos, cero, repetidos y extremos de `int`. Se comprobó el orden esperado, el tamaño y su incremento unitario, la inicialización nula del siguiente de un nodo y la salida exacta de impresión.

La prueba temporal inspeccionó `head` y recorrió los enlaces: comprobó que hubiera exactamente `size` nodos alcanzables, sin nodos repetidos ni ciclos y con terminación en `null`. También verificó que imprimir conservara las identidades, los datos, los enlaces y el tamaño. Los arreglos utilizados para guardar resultados esperados pertenecen exclusivamente a la prueba temporal, no a la lista.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 2 — Buscar elementos en una lista enlazada

**Estrategia:** recorrer desde `head` mediante la referencia local `actual`, comparando cada dato y avanzando mediante `getSiguiente()`. Devolver `true` ante la primera coincidencia y `false` al llegar a `null`.

**Justificación:** los nodos no ofrecen acceso directo por índice; para llegar a un elemento se deben seguir los enlaces desde el comienzo.

**Estructura de clases:** `Ejercicio2` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`. Los atributos `dato`, `siguiente`, `head` y `size` son privados. No se utiliza `tail`, almacenamiento en arreglos ni colecciones predefinidas.

**Operaciones:** `buscar(int dato)` realiza la búsqueda secuencial. `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize` permiten construir y verificar la lista siguiendo la lógica del Ejercicio 1, sin depender de sus clases.

**Manejo de referencias:** avanzar `actual` modifica una variable local, sin cambiar `head`, los enlaces, los datos ni `size`. La búsqueda no crea ni elimina nodos. Cada iteración sin coincidencia avanza al siguiente nodo hasta terminar en `null`.

**Casos especiales:** lista vacía o dato inexistente devuelve `false`; primer nodo, intermedio o último coincidente devuelve `true`. Los valores repetidos se aceptan y la búsqueda termina en la primera coincidencia. Se admiten negativos, cero y extremos de `int`.

**Complejidad:** búsqueda con mejor caso O(1), peor caso O(n) y espacio auxiliar O(1). Almacenamiento de la lista O(n). Inserción al inicio O(1), al final O(n) sin `tail`, impresión O(n), consultas de vacío y tamaño O(1). Las operaciones auxiliares utilizan espacio auxiliar O(1), sin contar el nuevo nodo creado al insertar.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita buscar un número entero dentro de una lista enlazada simple, mediante el método `boolean buscar(int dato)`.

**Estructura elegida:** lista enlazada simple de enteros, formada por nodos conectados mediante referencias, con acceso desde `head`.

**Estrategia:** construir una lista enlazada manualmente, reutilizando conceptualmente la implementación desarrollada en el Ejercicio 1, pero manteniendo este ejercicio independiente. Incorporar un método `buscar(int dato)` que recorra secuencialmente los nodos desde `head`, comparando sus datos hasta encontrar el valor solicitado o llegar al final de la lista.

**Justificación:** a diferencia de un arreglo, una lista enlazada no permite acceder directamente a un elemento mediante un índice. Cada nodo almacena solamente su dato y una referencia al siguiente. Por eso, para buscar un valor debemos comenzar desde `head` y avanzar mediante las referencias `siguiente`, nodo por nodo.

**Estructura de clases:**
- `Nodo`: representa cada elemento de la lista, con los atributos `int dato` y `Nodo siguiente`.
- `ListaEnlazada`: administra la referencia `head`, el contador `size` y las operaciones sobre los nodos.
- `Ejercicio2`: clase pública con método `main` para demostrar la búsqueda y ejecutar las pruebas.

**Método principal:**

`boolean buscar(int dato)`

Su funcionamiento debe seguir estos pasos:

1. Crear una referencia auxiliar `actual` que inicialmente apunte a `head`.
2. Mientras `actual != null`, examinar el dato del nodo actual.
3. Si `actual.getDato() == dato`, devolver `true` inmediatamente.
4. Si no coincide, avanzar mediante `actual = actual.getSiguiente()`.
5. Si el recorrido llega a `null` sin encontrar el valor, devolver `false`.

**Manejo de referencias:**
- El recorrido debe comenzar siempre desde `head`.
- `actual` es una referencia auxiliar que permite desplazarse entre los nodos.
- No modificar `head` mientras se realiza la búsqueda.
- No modificar el atributo `siguiente` de ningún nodo.
- No cambiar los datos almacenados.
- No incrementar ni disminuir `size`.
- No crear ni eliminar nodos durante la búsqueda.
- Asegurar que `actual` avance en cada iteración para evitar ciclos infinitos.

**Operaciones auxiliares necesarias:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deberán seguir la lógica del Ejercicio 1 y servir para construir y verificar las listas utilizadas en las pruebas.

**Casos especiales:**
- Lista vacía: `buscar()` debe devolver `false`.
- Dato en el primer nodo: devolver `true` inmediatamente.
- Dato en un nodo intermedio: continuar el recorrido hasta encontrarlo.
- Dato en el último nodo: devolver `true`.
- Dato inexistente: recorrer hasta `null` y devolver `false`.
- Valores repetidos: devolver `true` cuando se encuentra la primera coincidencia.
- Permitir números negativos, cero y extremos de `int`.
- Buscar no debe modificar el estado de la lista.

**Complejidad:**
- Mejor caso de `buscar`: O(1), cuando el primer nodo contiene el dato.
- Peor caso de `buscar`: O(n), cuando el elemento está al final o no existe.
- Complejidad espacial auxiliar de `buscar`: O(1), porque solamente utiliza una referencia auxiliar.
- La lista completa requiere O(n) de espacio para almacenar sus nodos.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n) en esta implementación sin referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio2.java`.
- Implementar una clase pública `Ejercicio2` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` como clases auxiliares estáticas anidadas dentro de `Ejercicio2`, para evitar conflictos con las clases del Ejercicio 1.
- Implementar manualmente la estructura mediante referencias entre nodos.
- Mantener privados los atributos `dato`, `siguiente`, `head` y `size`.
- No utilizar arreglos ni colecciones predefinidas para almacenar o buscar los elementos de la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `HashSet`, `Map`, `Stream` ni otras estructuras que sustituyan el recorrido secuencial.
- No depender de las clases de otros ejercicios.
- Incluir comentarios que expliquen por qué la búsqueda no permite acceso directo por índice, cómo se utiliza la referencia `actual` y por qué se termina al llegar a `null`.
- Mantener el tamaño y los enlaces correctos.
- Mostrar resultados claros en consola.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`.
4. Ejecutar `buscar(10)` y verificar que devuelve `true`.
5. Ejecutar `buscar(30)` y verificar que devuelve `true`.
6. Ejecutar `buscar(50)` y verificar que devuelve `true`.
7. Ejecutar `buscar(99)` y verificar que devuelve `false`.
8. Ejecutar `buscar(-5)` y verificar que devuelve `false`.
9. Comprobar que la lista continúa conteniendo los mismos cinco nodos, en el mismo orden y con `size = 5`.

**Pruebas adicionales:**
- Buscar en una lista vacía.
- Buscar el único elemento de una lista de tamaño 1.
- Buscar un valor inexistente en una lista de tamaño 1.
- Buscar el primer nodo.
- Buscar un nodo intermedio.
- Buscar el último nodo.
- Buscar un elemento inexistente.
- Buscar valores repetidos.
- Buscar números negativos.
- Buscar el valor cero.
- Buscar `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Ejecutar múltiples búsquedas consecutivas.
- Comprobar que las búsquedas no modifican `head`.
- Comprobar que las búsquedas no modifican `size`.
- Comprobar que las búsquedas no alteran los enlaces ni los datos de los nodos.
- Comprobar que el recorrido termina correctamente en `null`.
- Verificar que no se generan ciclos.

Compilar con Java 21, `--release 21` y `-Xlint:all`, y ejecutar pruebas reales que permitan verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 y 2 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 26 búsquedas verificadas y 771 comprobaciones aprobadas, 0 fallidas.

| Búsqueda principal | Resultado |
|---|---|
| `buscar(10)` | `true` |
| `buscar(30)` | `true` |
| `buscar(50)` | `true` |
| `buscar(99)` | `false` |
| `buscar(-5)` | `false` |

La lista permaneció `10 -> 20 -> 30 -> 40 -> 50 -> null`, con tamaño 5.

Se probaron lista vacía, lista unitaria con dato presente y ausente, tres rondas consecutivas de las cinco búsquedas principales, repetidos, negativos, cero y extremos de `int`. La prueba inspeccionó `head` y comparó las identidades, datos y enlaces de cada nodo antes y después, comprobando tamaño, orden, nodos alcanzables y terminación en `null` sin ciclos.

Una prueba adicional instrumentó un nodo posterior para fallar si se consultaba, y comprobó que una coincidencia en el primer nodo termina inmediatamente sin visitar el siguiente. Esta instrumentación pertenece exclusivamente a la prueba temporal. Los arreglos de resultados esperados también pertenecen solamente a las pruebas, no a la implementación enlazada.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 3 — Obtener un elemento por posición

**Estrategia:** validar primero la posición utilizando `size`, comenzar desde `head` y avanzar exactamente `posicion` enlaces mediante una referencia auxiliar, devolviendo el dato del nodo alcanzado.

**Justificación:** conocer la posición no permite acceso directo como en un arreglo; una lista enlazada requiere seguir las referencias desde el primer nodo.

**Estructura de clases:** `Ejercicio3` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`. Los atributos `dato`, `siguiente`, `head` y `size` son privados; no hay `tail` ni almacenamiento en arreglos o colecciones.

**Operaciones:** `obtener(int posicion)` consulta el nodo solicitado tras comprobar los límites. `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize` construyen y verifican las listas siguiendo la lógica anterior, sin depender de otros ejercicios.

**Manejo de referencias:** solo cambia la variable local `actual`; no se modifican `head`, datos, enlaces ni tamaño, y no se crean ni eliminan nodos. Para la posición 0 se devuelve el dato de `head` sin avanzar enlaces.

**Casos especiales:** en una lista vacía cualquier índice es inválido. En una lista unitaria solo se admite 0. Posiciones negativas, iguales a `size` o mayores producen `IndexOutOfBoundsException` antes del recorrido. Se admiten repetidos, negativos, cero y extremos de `int`. Las consultas válidas e inválidas conservan la estructura.

**Complejidad:** validación O(1), `obtener(0)` O(1), `obtener(posicion)` O(posicion + 1) y peor caso O(n), con espacio auxiliar O(1). Almacenamiento de nodos O(n). Inserción al inicio O(1), al final O(n) sin `tail`, impresión O(n), consultas de vacío y tamaño O(1). Espacio auxiliar de las operaciones O(1), sin contar el nuevo nodo al insertar.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita obtener el valor almacenado en una posición específica de una lista enlazada simple de números enteros, mediante el método `int obtener(int posicion)`.

**Estructura elegida:** lista enlazada simple formada por nodos que contienen un dato entero y una referencia al siguiente nodo.

**Estrategia:** construir una lista enlazada utilizando una clase `Nodo` con los atributos `dato` y `siguiente`, y una clase `ListaEnlazada` con `head` y `size`. Implementar `obtener(int posicion)` validando primero el índice solicitado y luego recorriendo secuencialmente desde `head` hasta alcanzar el nodo correspondiente.

**Justificación:** aunque el método recibe una posición, una lista enlazada simple no permite acceso directo por índice como ocurre con un arreglo. Cada nodo conoce solamente al siguiente. Por eso, acceder al elemento ubicado en una posición determinada requiere avanzar por las referencias desde el primer nodo.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones sobre la estructura.
- `Ejercicio3`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Método principal:**

`int obtener(int posicion)`

Debe realizar los siguientes pasos:

1. Validar que `posicion` esté comprendida entre 0 y `size - 1`.
2. Si `posicion < 0` o `posicion >= size`, lanzar `IndexOutOfBoundsException`.
3. Crear una referencia auxiliar `actual` que apunte a `head`.
4. Avanzar exactamente `posicion` veces mediante `actual = actual.getSiguiente()`.
5. Devolver el dato almacenado en el nodo alcanzado.
6. No modificar la lista durante la consulta.

**Validación de posiciones:**
- La primera posición válida es 0.
- La última posición válida es `size - 1`.
- Las posiciones negativas son inválidas.
- La posición igual a `size` es inválida.
- Las posiciones mayores a `size` son inválidas.
- En una lista vacía no existe ninguna posición válida.
- Las posiciones inválidas deben producir `IndexOutOfBoundsException`, no `NullPointerException`.

**Manejo de referencias:**
- El recorrido debe comenzar desde `head`.
- Utilizar una referencia auxiliar `actual` para avanzar entre los nodos.
- No cambiar `head`.
- No modificar las referencias `siguiente`.
- No crear ni eliminar nodos.
- No modificar los datos almacenados.
- No cambiar el atributo `size`.
- Evitar recorrer posiciones innecesarias: detenerse exactamente en el nodo solicitado.
- Explicar por qué obtener el elemento en la posición 0 no requiere recorrer enlaces.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben permitir construir listas para las pruebas y seguir la lógica de los ejercicios anteriores, manteniendo el Ejercicio 3 independiente.

**Casos especiales:**
- Lista vacía: cualquier posición solicitada debe producir `IndexOutOfBoundsException`.
- Lista de un solo elemento: únicamente es válida la posición 0.
- Primera posición: devolver el valor almacenado en `head`.
- Posición intermedia: recorrer los nodos necesarios.
- Última posición: devolver correctamente el último elemento.
- Posición negativa: rechazarla.
- Posición igual o mayor que `size`: rechazarla.
- Elementos repetidos: devolver el valor correspondiente a la posición, sin buscar por contenido.
- Permitir valores negativos, cero y extremos de `int`.
- Las consultas válidas e inválidas no deben alterar la estructura.

**Complejidad:**
- Validación de posición: O(1), utilizando el atributo `size`.
- `obtener(0)`: O(1).
- `obtener(posicion)`: O(posicion + 1), y O(n) en el peor caso.
- Espacio auxiliar de `obtener`: O(1), porque utiliza una sola referencia auxiliar.
- Espacio total de la lista: O(n), correspondiente a los nodos.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n) en una implementación sin `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio3.java`.
- Implementar una clase pública `Ejercicio3` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio3`, para evitar conflictos con los ejercicios anteriores.
- Implementar manualmente los nodos y referencias.
- Mantener privados `dato`, `siguiente`, `head` y `size`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue` ni estructuras equivalentes para implementar el acceso.
- No utilizar recorridos mediante `Stream` ni conversiones a arreglos.
- No depender de clases de otros ejercicios.
- Incorporar comentarios que expliquen la validación, el recorrido secuencial y la diferencia frente al acceso directo de los arreglos.
- Mostrar resultados claros en consola.
- Mantener correctamente los enlaces, el tamaño y la ausencia de ciclos.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los elementos 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`.
4. Ejecutar `obtener(0)` y verificar que devuelve 10.
5. Ejecutar `obtener(1)` y verificar que devuelve 20.
6. Ejecutar `obtener(2)` y verificar que devuelve 30.
7. Ejecutar `obtener(3)` y verificar que devuelve 40.
8. Ejecutar `obtener(4)` y verificar que devuelve 50.
9. Ejecutar `obtener(-1)` y verificar que lanza `IndexOutOfBoundsException`.
10. Ejecutar `obtener(5)` y verificar que lanza `IndexOutOfBoundsException`.
11. Ejecutar `obtener(100)` y verificar que lanza `IndexOutOfBoundsException`.
12. Comprobar que el contenido, los enlaces, `head` y `size` siguen intactos después de las consultas.

**Pruebas adicionales:**
- Obtener sobre una lista vacía.
- Obtener el único elemento de una lista de tamaño 1.
- Rechazar la posición 1 de una lista de tamaño 1.
- Rechazar posiciones negativas.
- Rechazar posiciones iguales a `size`.
- Rechazar posiciones mayores que `size`.
- Obtener el primer nodo.
- Obtener nodos intermedios.
- Obtener el último nodo.
- Obtener elementos repetidos en distintas posiciones.
- Obtener números negativos y cero.
- Obtener `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Alternar inserciones al inicio y al final antes de consultar.
- Realizar múltiples consultas consecutivas.
- Comprobar que `obtener()` no modifica `head`.
- Comprobar que `obtener()` no modifica `size`.
- Comprobar que no cambia ningún dato ni enlace.
- Comprobar que las excepciones conservan íntegramente la estructura.
- Verificar que no aparezcan ciclos ni nodos inaccesibles.

Compilar individualmente y conjuntamente con los ejercicios 1 y 2 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y comprobaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1, 2 y 3 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 45 casos aprobados, 1265 verificaciones aprobadas y 0 fallidas.

| Posición principal | Resultado |
|---|---|
| 0 | 10 |
| 1 | 20 |
| 2 | 30 |
| 3 | 40 |
| 4 | 50 |
| -1, 5, 100 | `IndexOutOfBoundsException` |

La lista permaneció `10 -> 20 -> 30 -> 40 -> 50 -> null`, con tamaño 5.

Se probaron cinco índices inválidos sobre lista vacía; tres rondas de diez consultas válidas e inválidas sobre la lista principal; cuatro posiciones sobre lista unitaria; y las seis posiciones de una lista construida alternando inserciones, con negativos, cero, repetidos y extremos de `int`. Los índices extremos de `int` también se rechazaron correctamente.

Antes y después de cada consulta, la prueba inspeccionó `head`, las identidades, datos y enlaces de los nodos y el tamaño. Se comprobó que hubiera exactamente los nodos esperados, alcanzables en orden y terminando en `null`, sin ciclos ni alteraciones ante excepciones. Los arreglos de resultados esperados pertenecen exclusivamente a la prueba temporal, no a la implementación enlazada.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 4 — Insertar un nodo en una posición específica

**Estrategia:** validar el índice entre 0 y `size`, inclusive. Para posición 0 insertar directamente al inicio; para las demás, recorrer desde `head` hasta el nodo anterior y conectar el nuevo nodo preservando el resto de la lista.

**Justificación:** insertar en una lista enlazada requiere modificar referencias, sin desplazar físicamente los datos existentes. El recorrido localiza el punto de conexión.

**Estructura de clases:** `Ejercicio4` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`. Los atributos son privados y la lista utiliza únicamente `head` y `size`, sin `tail`, arreglos ni colecciones de almacenamiento.

**Operaciones:** `insertarEnPosicion(int dato, int posicion)` valida antes de crear nodos, inserta y aumenta el tamaño exactamente una vez. Para posición 0 delega en `insertarAlInicio` y retorna, evitando un segundo incremento. Las operaciones auxiliares son `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize`.

**Manejo de referencias:** primero se preserva el enlace al resto y después se conecta el nuevo nodo:

~~~java
nuevo.setSiguiente(actual.getSiguiente());
actual.setSiguiente(nuevo);
~~~

Invertir el orden puede hacer que el nuevo nodo apunte a sí mismo, generando un ciclo y perdiendo acceso al resto. Al inicio se conecta primero el nuevo nodo con `head` y luego se actualiza `head`. Al final, el siguiente del nuevo nodo permanece en `null`. Los nodos existentes conservan sus datos y su orden relativo.

**Casos especiales:** lista vacía admite únicamente posición 0; lista unitaria permite insertar antes o después. Se aceptan inicio, medio y posición `size`. Índices negativos o mayores que `size` producen `IndexOutOfBoundsException` sin modificar la estructura. Se admiten repetidos, negativos, cero y extremos de `int`.

**Complejidad:** validación O(1), inserción en posición 0 O(1), inserción intermedia y al final O(n) en el peor caso sin `tail`. Crear el nodo y actualizar enlaces cuesta O(1). Espacio auxiliar O(1), sin contar el nuevo nodo, y almacenamiento total O(n). Inserción auxiliar al inicio O(1), al final O(n), impresión O(n), consultas de vacío y tamaño O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita insertar un nuevo nodo en una posición específica de una lista enlazada simple de enteros, utilizando el método `void insertarEnPosicion(int dato, int posicion)`.

**Estructura elegida:** lista enlazada simple formada por nodos que almacenan un entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, administrada mediante una referencia `head` y un atributo `size`. Para insertar en una posición, validar primero el índice, encontrar el nodo anterior cuando corresponda y modificar las referencias en el orden correcto, sin perder ninguno de los nodos existentes.

**Justificación:** en una lista enlazada simple, insertar un elemento no requiere desplazar físicamente los datos como en un arreglo. En su lugar, se crea un nuevo nodo y se modifican las referencias entre los nodos. Sin embargo, es fundamental preservar los enlaces existentes y actualizarlos en el orden adecuado para evitar perder parte de la lista o generar ciclos.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: contiene `head`, `size` y las operaciones de la lista.
- `Ejercicio4`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Método principal:**

`void insertarEnPosicion(int dato, int posicion)`

Debe permitir:
- Insertar al inicio de la lista.
- Insertar en una posición intermedia.
- Insertar al final de la lista.
- Insertar en una lista vacía cuando `posicion == 0`.

**Validación de posiciones:**
- Aceptar posiciones comprendidas entre 0 y `size`, inclusive.
- Rechazar `posicion < 0`.
- Rechazar `posicion > size`.
- Utilizar `IndexOutOfBoundsException` para informar posiciones inválidas.
- Validar la posición antes de crear el nodo o modificar referencias.
- Ante una posición inválida, conservar exactamente el estado previo de la lista.

**Inserción al inicio:**
1. Si `posicion == 0`, crear el nuevo nodo.
2. Hacer que el nuevo nodo apunte a `head`.
3. Actualizar `head` para que apunte al nuevo nodo.
4. Incrementar `size` una única vez.
5. No recorrer la lista.

La secuencia correcta es:

`nuevo.setSiguiente(head);`

`head = nuevo;`

Este orden conserva la referencia al primer nodo original.

**Inserción en el medio o al final:**
1. Si `posicion > 0`, comenzar desde `head`.
2. Recorrer hasta alcanzar el nodo ubicado en `posicion - 1`.
3. Crear un nuevo nodo para almacenar `dato`.
4. Hacer que el nuevo nodo apunte al que actualmente sigue al nodo anterior.
5. Hacer que el nodo anterior apunte al nuevo.
6. Incrementar `size` una única vez.

Las instrucciones centrales deben ejecutarse exactamente en este orden:

`nuevo.setSiguiente(actual.getSiguiente());`

`actual.setSiguiente(nuevo);`

Primero se preserva el enlace hacia la parte restante de la lista. Después se conecta el nodo nuevo al anterior.

Si se invierte el orden y se recupera después `actual.getSiguiente()`, esa referencia ya puede apuntar al nodo nuevo, generando un enlace incorrecto, un ciclo o la pérdida de acceso al resto de la lista.

**Inserción al final:**
- Se permite `posicion == size`.
- El recorrido llega al último nodo existente.
- Como su siguiente es `null`, el nuevo nodo debe quedar con `siguiente == null`.
- El último nodo original debe apuntar al nuevo.
- Si la lista está vacía, insertar en la posición 0 equivale a insertar al inicio.

**Manejo de referencias:**
- Mantener siempre accesibles todos los nodos desde `head`.
- No sobrescribir referencias antes de preservar el enlace siguiente.
- No generar ciclos.
- No eliminar ni modificar datos de los nodos existentes.
- Actualizar `head` únicamente cuando la inserción se realiza en la posición 0.
- Mantener el último nodo enlazado con `null`.
- Actualizar `size` exactamente una vez después de cada inserción válida.
- Utilizar una referencia auxiliar de recorrido, sin modificar `head` durante el recorrido.
- Evitar realizar recorridos innecesarios.

**Operaciones auxiliares necesarias:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deberán seguir la lógica de los ejercicios anteriores y permitir construir las listas utilizadas en las pruebas. Se puede reutilizar internamente `insertarAlInicio` en el caso de posición 0, siempre que no se incremente dos veces `size`.

**Casos especiales:**
- Lista vacía con posición 0: inserción válida.
- Lista vacía con otra posición: inserción inválida.
- Lista de un elemento: inserción antes o después del único nodo.
- Inserción en la primera posición de una lista con varios nodos.
- Inserción entre dos nodos existentes.
- Inserción en la última posición permitida (`posicion == size`).
- Posiciones negativas.
- Posiciones mayores que `size`.
- Valores repetidos.
- Números negativos, cero y extremos de `int`.
- Verificar que una posición inválida no altere los nodos, enlaces, `head` ni `size`.

**Complejidad:**
- Validación de posición: O(1).
- Inserción en posición 0: O(1).
- Inserción en posición intermedia: O(n) en el peor caso, por el recorrido.
- Inserción en posición `size`: O(n), porque la lista no mantiene una referencia `tail`.
- Creación del nodo y actualización de sus enlaces: O(1).
- Espacio auxiliar de la operación: O(1), sin contar el nuevo nodo.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n).
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio4.java`.
- Implementar una clase pública `Ejercicio4` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio4`, para evitar conflictos de nombres con los ejercicios anteriores.
- Implementar manualmente la lista mediante nodos y referencias.
- Mantener privados los atributos internos de las clases auxiliares.
- Utilizar solamente `head` y `size` como atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue` ni estructuras equivalentes.
- No utilizar conversiones a arreglos ni `Stream` para implementar la inserción.
- No depender de clases de otros ejercicios.
- Incluir comentarios que expliquen el orden de modificación de las referencias y qué ocurriría si se invirtiera.
- Mostrar claramente el contenido de la lista antes y después de cada inserción importante.
- Verificar que `size` coincida con la cantidad real de nodos.
- Verificar que la lista termine en `null` y no contenga ciclos.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Ejecutar `insertarAlFinal(10)`.
3. Ejecutar `insertarAlFinal(20)`.
4. Ejecutar `insertarAlFinal(30)`.
5. Mostrar `10 -> 20 -> 30 -> null`, con `size = 3`.
6. Ejecutar `insertarEnPosicion(15, 1)`.
7. Verificar `10 -> 15 -> 20 -> 30 -> null`, con `size = 4`.
8. Ejecutar `insertarEnPosicion(5, 0)`.
9. Verificar `5 -> 10 -> 15 -> 20 -> 30 -> null`, con `size = 5`.
10. Ejecutar `insertarEnPosicion(40, 5)`.
11. Verificar `5 -> 10 -> 15 -> 20 -> 30 -> 40 -> null`, con `size = 6`.
12. Intentar `insertarEnPosicion(99, -1)` y verificar `IndexOutOfBoundsException`.
13. Intentar `insertarEnPosicion(99, 7)` y verificar `IndexOutOfBoundsException`.
14. Comprobar que las inserciones inválidas conservaron el contenido, `head`, `size` y todos los enlaces.

**Pruebas adicionales:**
- Inserción en una lista vacía.
- Rechazo de posiciones inválidas en una lista vacía.
- Inserción al inicio de una lista de un nodo.
- Inserción al final de una lista de un nodo.
- Inserción al principio de una lista con varios nodos.
- Inserción en posiciones intermedias.
- Inserción exactamente en `size`.
- Rechazo de posiciones negativas.
- Rechazo de posiciones mayores que `size`.
- Inserciones consecutivas en la misma posición.
- Inserciones alternadas al inicio, medio y final.
- Valores duplicados.
- Valores negativos.
- Valor cero.
- `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que cada inserción válida incrementa `size` exactamente una vez.
- Comprobar que las inserciones inválidas no alteran el estado.
- Comprobar que el primer nodo sigue siendo alcanzable desde `head`.
- Comprobar que todos los nodos originales permanecen en orden relativo después de la inserción.
- Comprobar que el nodo nuevo aparece exactamente en la posición solicitada.
- Verificar que el último nodo apunte a `null`.
- Verificar que no se generan ciclos ni nodos inaccesibles.
- Comprobar que imprimir no modifica la lista.

Compilar individualmente y conjuntamente con los ejercicios 1, 2 y 3 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 4 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 28 casos y 1811 verificaciones aprobadas, 0 fallidas.

| Operación principal | Lista resultante | size |
|---|---|---:|
| Construcción inicial | `10 -> 20 -> 30 -> null` | 3 |
| `insertarEnPosicion(15, 1)` | `10 -> 15 -> 20 -> 30 -> null` | 4 |
| `insertarEnPosicion(5, 0)` | `5 -> 10 -> 15 -> 20 -> 30 -> null` | 5 |
| `insertarEnPosicion(40, 5)` | `5 -> 10 -> 15 -> 20 -> 30 -> 40 -> null` | 6 |

Las posiciones -1 y 7 produjeron `IndexOutOfBoundsException`, conservando la lista de seis nodos.

Se probaron inserción en lista vacía y unitaria, inicio/medio/final, inserciones consecutivas en posición 1, alternancia entre posiciones, repetidos, negativos, cero y extremos de `int`. También se rechazaron índices extremos, negativos y mayores que el tamaño.

La prueba temporal inspeccionó `head` y los nodos antes y después de cada operación. Se verificaron identidad y datos de todos los nodos originales en orden relativo, aparición de exactamente un nuevo nodo en la posición solicitada, incremento unitario de tamaño, nodos alcanzables y terminación en `null` sin ciclos. Las operaciones inválidas conservaron los nodos, enlaces, `head` y tamaño. Se comprobó la salida exacta de impresión y que imprimir no cambia enlaces ni tamaño. Los arreglos de expectativas se utilizaron exclusivamente en la prueba temporal, no para implementar la lista.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 5 — Eliminar un nodo por valor

**Estrategia:** comprobar lista vacía y coincidencia en `head`; para los demás casos, recorrer buscando el nodo anterior a la primera coincidencia, saltear el nodo encontrado y devolver inmediatamente `true`. Si no existe, devolver `false`.

**Justificación:** eliminar requiere cambiar enlaces, sin desplazar datos ni reconstruir la lista. Preservar la referencia al sucesor mantiene accesible el resto.

**Estructura de clases:** `Ejercicio5` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`. Los atributos son privados; la lista utiliza solamente `head` y `size`, sin `tail`, arreglos ni colecciones de almacenamiento.

**Operaciones:** `eliminar(int dato)` devuelve si se eliminó la primera aparición y disminuye `size` exactamente una vez solo en ese caso. Las operaciones auxiliares son `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize`.

**Manejo de referencias:** para eliminar el primer nodo se ejecuta `head = head.getSiguiente()`. Para un nodo intermedio o final se ejecuta:

~~~java
actual.setSiguiente(actual.getSiguiente().getSiguiente());
~~~

El sucesor se obtiene antes de cambiar el enlace del anterior. Así se conserva el resto; al retirar el último nodo, el anterior queda apuntando a `null`. Los datos y el orden relativo de los nodos conservados no cambian.

**Garbage Collector:** Java no requiere liberar manualmente el nodo eliminado. Si deja de ser alcanzable y no quedan otras referencias a él, su memoria puede recuperarse posteriormente por el Garbage Collector; no se garantiza liberación inmediata.

**Casos especiales:** lista vacía y dato inexistente devuelven `false` sin cambios. Eliminar el único nodo deja `head == null` y tamaño 0. Se contemplan primer nodo, intermedio, último y duplicados, retirando solo la primera aparición por llamada. Se admiten negativos, cero y extremos de `int`.

**Complejidad:** lista vacía y eliminación del primer nodo O(1); eliminación intermedia, final o búsqueda fallida O(n) en el peor caso. Actualizar enlaces cuesta O(1). Espacio auxiliar O(1), almacenamiento de nodos O(n). Inserción al inicio O(1), al final O(n) sin `tail`, impresión O(n), consultas de vacío y tamaño O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita eliminar la primera aparición de un valor entero en una lista enlazada simple, utilizando el método `boolean eliminar(int dato)`.

**Estructura elegida:** lista enlazada simple formada por nodos con un dato entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, utilizando `head` como referencia al primer nodo y `size` como contador de elementos. Para eliminar un valor, recorrer la lista hasta localizar su primera aparición y actualizar las referencias para que ese nodo deje de formar parte de la cadena.

**Justificación:** en una lista enlazada simple, eliminar un elemento no requiere desplazar datos como ocurre con un arreglo. La eliminación se realiza modificando los enlaces entre nodos. Es fundamental conservar la referencia al nodo siguiente del eliminado para no perder el acceso al resto de la lista.

**Estructura de clases:**
- `Nodo`: contiene `int dato` y `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones de la estructura.
- `Ejercicio5`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Método principal:**

`boolean eliminar(int dato)`

Debe eliminar únicamente la primera aparición del valor solicitado y devolver:
- `true` si encontró y eliminó un nodo.
- `false` si la lista estaba vacía o el valor no estaba presente.

**Caso 1 — Lista vacía:**
1. Verificar si `head == null`.
2. Si la lista está vacía, devolver `false`.
3. No modificar `head` ni `size`.

**Caso 2 — Eliminar el primer nodo:**
1. Verificar si `head.getDato() == dato`.
2. Actualizar `head` para que apunte al siguiente nodo.
3. Disminuir `size` exactamente una vez.
4. Devolver `true`.

La actualización principal es:

`head = head.getSiguiente();`

Esta operación debe funcionar tanto para una lista de varios elementos como para una lista que contiene un único nodo.

**Caso 3 — Eliminar un nodo intermedio o final:**
1. Crear una referencia auxiliar `actual` que comience en `head`.
2. Mientras `actual.getSiguiente() != null`, examinar el dato del nodo siguiente.
3. Si el nodo siguiente contiene el valor buscado, modificar el enlace de `actual` para que apunte directamente al sucesor del nodo eliminado.
4. Disminuir `size` exactamente una vez.
5. Devolver `true` inmediatamente, para eliminar solo la primera aparición.
6. Si el siguiente nodo no coincide, avanzar `actual` al próximo nodo.
7. Si se llega al final sin encontrar el valor, devolver `false`.

La actualización fundamental de referencias es:

`actual.setSiguiente(actual.getSiguiente().getSiguiente());`

Esta operación permite saltear el nodo que se quiere eliminar, conservando el enlace hacia el resto de la lista.

**Orden de actualización de referencias:**
- Localizar correctamente el nodo anterior al que se desea eliminar.
- Conservar la referencia hacia el sucesor del nodo eliminado.
- Actualizar el enlace del nodo anterior.
- Evitar modificar o perder las referencias necesarias antes de completar la eliminación.
- No modificar los datos de otros nodos para simular la eliminación.
- No reconstruir toda la lista ni copiar sus elementos a otra estructura.
- Mantener siempre accesibles desde `head` todos los nodos que deben continuar en la lista.

**Garbage Collector:**
- Explicar que en Java no se libera manualmente la memoria de un nodo eliminado.
- Al dejar de ser alcanzable desde la lista y no conservar otras referencias hacia él, el nodo queda disponible para que el Garbage Collector recupere su memoria posteriormente.
- No afirmar que el Garbage Collector libera el nodo inmediatamente.
- No utilizar operaciones manuales de liberación de memoria.

**Manejo de `size`:**
- Disminuir `size` solamente cuando efectivamente se elimina un nodo.
- Disminuirlo exactamente una vez por eliminación exitosa.
- Mantenerlo sin cambios cuando el dato no existe.
- Si se elimina el último elemento, la lista debe quedar con `head == null` y `size == 0`.
- Después de cualquier operación, `size` debe coincidir con la cantidad de nodos alcanzables desde `head`.

**Casos especiales:**
- Lista vacía: devolver `false`.
- Lista de un solo nodo con el dato buscado: eliminarlo y dejar la lista vacía.
- Lista de un solo nodo con otro dato: devolver `false` y conservarlo.
- Eliminar el primer nodo de una lista con varios elementos.
- Eliminar un nodo intermedio.
- Eliminar el último nodo.
- Eliminar un valor inexistente.
- Valores repetidos: eliminar solamente la primera coincidencia.
- Eliminar varias veces consecutivas el mismo valor cuando existen duplicados.
- Permitir números negativos, cero y extremos de `int`.
- La búsqueda fallida no debe alterar la lista.
- La eliminación exitosa no debe cambiar los datos ni el orden relativo de los nodos restantes.
- No generar ciclos ni dejar nodos que deberían permanecer inaccesibles.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Las operaciones auxiliares deben respetar la implementación básica de los ejercicios anteriores y servir para construir los escenarios de prueba.

**Complejidad:**
- Eliminar en lista vacía: O(1).
- Eliminar el primer nodo: O(1).
- Eliminar un nodo intermedio: O(n) en el peor caso.
- Eliminar el último nodo: O(n).
- Buscar un valor inexistente: O(n).
- Actualizar los enlaces una vez localizado el nodo: O(1).
- Espacio auxiliar de `eliminar`: O(1), porque se utilizan referencias auxiliares.
- Espacio total de la lista: O(n), correspondiente a sus nodos.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza una referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio5.java`.
- Implementar una clase pública `Ejercicio5` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio5`, evitando conflictos con los ejercicios anteriores.
- Utilizar referencias entre nodos, sin arreglos ni colecciones predefinidas para almacenar la lista.
- Mantener privados los atributos internos.
- Mantener exclusivamente `head` y `size` como atributos de control, sin agregar `tail`.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para implementar la eliminación.
- No depender de las clases de otros ejercicios.
- No utilizar conversiones a arreglos ni `Stream` para resolver el problema.
- Incorporar comentarios que expliquen el tratamiento especial de `head`, la búsqueda del nodo anterior, la actualización de referencias y el papel del Garbage Collector.
- Mostrar el estado de la lista antes y después de las eliminaciones.
- Mantener correctamente el tamaño, los enlaces y la ausencia de ciclos.
- No modificar elementos ajenos al nodo eliminado.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`, con `size = 5`.
4. Ejecutar `eliminar(30)` y verificar que devuelve `true`.
5. Comprobar `10 -> 20 -> 40 -> 50 -> null`, con `size = 4`.
6. Ejecutar `eliminar(10)` y verificar que devuelve `true`.
7. Comprobar `20 -> 40 -> 50 -> null`, con `size = 3`.
8. Ejecutar `eliminar(50)` y verificar que devuelve `true`.
9. Comprobar `20 -> 40 -> null`, con `size = 2`.
10. Ejecutar `eliminar(99)` y verificar que devuelve `false`.
11. Comprobar que la lista permanece `20 -> 40 -> null`, con `size = 2`.
12. Ejecutar `eliminar(20)` y comprobar `40 -> null`, con `size = 1`.
13. Ejecutar `eliminar(40)` y comprobar `null`, con `size = 0`.
14. Ejecutar `eliminar(40)` sobre la lista vacía y verificar que devuelve `false`.

**Ejemplo adicional con duplicados:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `eliminar(10)`.
3. Verificar que devuelve `true`.
4. Comprobar `20 -> 10 -> 30 -> 10 -> null`, con `size = 4`.
5. Verificar que solamente desapareció la primera aparición.
6. Ejecutar nuevamente `eliminar(10)` y comprobar `20 -> 30 -> 10 -> null`, con `size = 3`.

**Pruebas adicionales:**
- Eliminar en una lista vacía.
- Eliminar el único nodo.
- No encontrar un dato en una lista de un nodo.
- Eliminar repetidamente el primer nodo.
- Eliminar nodos intermedios.
- Eliminar el último nodo.
- Eliminar un valor inexistente.
- Eliminar la primera aparición entre valores repetidos.
- Eliminar valores repetidos en posiciones consecutivas.
- Eliminar valores negativos.
- Eliminar el valor cero.
- Eliminar `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Alternar inserciones y eliminaciones.
- Comprobar que `head` se actualiza correctamente al eliminar el primer nodo.
- Comprobar que `head` no cambia al eliminar un nodo intermedio o final.
- Comprobar que cada eliminación exitosa decrementa `size` exactamente una vez.
- Comprobar que las eliminaciones fallidas no modifican `size`.
- Verificar que se preserva el orden relativo de los nodos restantes.
- Verificar que no se modifica el dato de los nodos conservados.
- Verificar que el último nodo apunte a `null`.
- Verificar que no se generan ciclos ni nodos perdidos.
- Verificar que imprimir no modifica la estructura.

Compilar individualmente y conjuntamente con los ejercicios 1 al 4 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 5 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 32 casos y 744 verificaciones aprobadas, 0 fallidas.

| Operación principal | Resultado | Lista resultante | size |
|---|---|---|---:|
| Inicial | — | `10 -> 20 -> 30 -> 40 -> 50 -> null` | 5 |
| `eliminar(30)` | `true` | `10 -> 20 -> 40 -> 50 -> null` | 4 |
| `eliminar(10)` | `true` | `20 -> 40 -> 50 -> null` | 3 |
| `eliminar(50)` | `true` | `20 -> 40 -> null` | 2 |
| `eliminar(99)` | `false` | `20 -> 40 -> null` | 2 |
| `eliminar(20)` | `true` | `40 -> null` | 1 |
| `eliminar(40)` | `true` | `null` | 0 |
| `eliminar(40)` nuevamente | `false` | `null` | 0 |

En `10 -> 20 -> 10 -> 30 -> 10 -> null`, la primera eliminación de 10 produjo `20 -> 10 -> 30 -> 10 -> null`, tamaño 4; la segunda produjo `20 -> 30 -> 10 -> null`, tamaño 3. Solo desapareció la primera coincidencia en cada llamada.

Se probaron lista vacía, nodo único presente y ausente, eliminación inicial/intermedia/final, duplicados consecutivos y separados, negativos, cero, extremos de `int` y alternancia de inserciones y eliminaciones. La prueba temporal comparó identidades, datos y enlaces de los nodos restantes, verificando su orden relativo, tamaño exacto, actualización correcta de `head`, terminación en `null` y ausencia de ciclos o nodos perdidos. Los intentos fallidos conservaron la estructura; imprimir conservó las identidades, datos, enlaces y tamaño y produjo la salida esperada.

Los arreglos de expectativas pertenecen exclusivamente a la prueba temporal, no a la lista. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 6 — Eliminar un nodo por posición

**Estrategia:** validar la posición entre 0 y `size - 1`. Para posición 0 actualizar `head`; para las demás, recorrer hasta el nodo anterior y enlazarlo con el sucesor del eliminado. Disminuir el tamaño una sola vez.

**Justificación:** una lista enlazada requiere recorrer referencias para localizar el anterior; eliminar consiste en cambiar enlaces sin desplazar datos ni reconstruir nodos.

**Estructura de clases:** `Ejercicio6` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`, con atributos privados. La lista utiliza únicamente `head` y `size`, sin `tail`, arreglos ni colecciones de almacenamiento.

**Operaciones:** `eliminarEnPosicion(int posicion)` valida antes de modificar y elimina exactamente un nodo. Las operaciones auxiliares son `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize`.

**Manejo de referencias:** para posición 0 se ejecuta `head = head.getSiguiente()`, sin recorrer el resto. Para posiciones posteriores se ejecuta:

~~~java
actual.setSiguiente(actual.getSiguiente().getSiguiente());
~~~

Se obtiene el sucesor antes de reemplazar el enlace del anterior, conservando el resto. Al eliminar el último nodo, el anterior queda apuntando a `null`. Los nodos restantes conservan identidad, datos y orden relativo.

**Garbage Collector:** eliminar desvincula un nodo. Cuando ya no quedan referencias que lo hagan alcanzable, su memoria puede ser recuperada posteriormente por el Garbage Collector; no se libera manualmente ni se garantiza recolección inmediata.

**Casos especiales:** lista vacía no admite posiciones; lista unitaria solo admite 0 y queda con `head = null` y tamaño 0 al eliminarlo. Se contemplan inicio, medio, final y duplicados, eliminando por posición y no por valor. Índices negativos o iguales o superiores a `size` producen `IndexOutOfBoundsException` sin cambios. Se admiten negativos, cero y extremos de `int` como datos.

**Complejidad:** validación y eliminación inicial O(1); eliminación intermedia o final O(n) en el peor caso. Actualizar enlaces cuesta O(1). Espacio auxiliar O(1), almacenamiento de nodos O(n). Inserción al inicio O(1), al final O(n) sin `tail`, impresión O(n), consultas de vacío y tamaño O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita eliminar el nodo ubicado en una posición específica de una lista enlazada simple de enteros, utilizando el método `void eliminarEnPosicion(int posicion)`.

**Estructura elegida:** lista enlazada simple formada por nodos que contienen un entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, administrada mediante los atributos `head` y `size`. Para eliminar un nodo por posición, validar primero el índice solicitado. Si corresponde al primer nodo, actualizar directamente `head`. En los demás casos, recorrer desde `head` hasta alcanzar el nodo anterior al que se desea eliminar y modificar su enlace para que apunte al nodo siguiente del eliminado.

**Justificación:** una lista enlazada simple no permite acceder directamente a una posición mediante un índice, como ocurre con un arreglo. Para eliminar un nodo que no está al inicio, primero es necesario encontrar su nodo anterior mediante recorrido secuencial. La eliminación consiste en modificar referencias, sin desplazar datos ni reconstruir la lista.

**Estructura de clases:**
- `Nodo`: contiene `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones sobre los nodos.
- `Ejercicio6`: clase pública con método `main` para demostrar el funcionamiento y ejecutar pruebas.

**Método principal:**

`void eliminarEnPosicion(int posicion)`

Debe eliminar exactamente un nodo de la posición indicada, considerando que las posiciones comienzan en 0.

**Validación de posiciones:**
- La primera posición válida es 0.
- La última posición válida es `size - 1`.
- Rechazar cualquier `posicion < 0`.
- Rechazar cualquier `posicion >= size`.
- En una lista vacía no existe ninguna posición válida.
- Utilizar `IndexOutOfBoundsException` para los índices inválidos.
- Validar antes de modificar `head`, enlaces o `size`.
- Toda operación inválida debe conservar íntegramente el estado anterior.

**Caso 1 — Eliminar el primer nodo:**
1. Si `posicion == 0`, identificar el nodo actual de `head`.
2. Hacer que `head` apunte al siguiente nodo.
3. Disminuir `size` exactamente una vez.
4. Terminar la operación sin recorrer el resto de la lista.

La instrucción principal es:

`head = head.getSiguiente();`

Si la lista contiene un solo elemento, `head` deberá quedar en `null` y `size` en 0.

**Caso 2 — Eliminar un nodo intermedio o final:**
1. Crear una referencia auxiliar `actual` que apunte inicialmente a `head`.
2. Recorrer hasta encontrar el nodo ubicado en `posicion - 1`.
3. Identificar mediante `actual.getSiguiente()` el nodo que se eliminará.
4. Hacer que el nodo anterior apunte directamente al sucesor del nodo eliminado.
5. Disminuir `size` exactamente una vez.
6. Terminar la operación conservando todos los demás nodos.

La instrucción principal es:

`actual.setSiguiente(actual.getSiguiente().getSiguiente());`

Esta operación saltea al nodo eliminado. Si era el último, la referencia del nodo anterior quedará en `null`.

**Orden de actualización de referencias:**
- Primero localizar el nodo anterior.
- Identificar el nodo que se quiere eliminar y su sucesor.
- Preservar el acceso al sucesor antes de modificar o descartar referencias.
- Actualizar el enlace del nodo anterior para saltear al eliminado.
- No modificar los datos de los nodos restantes.
- No reconstruir la lista mediante nuevas copias de nodos.
- Mantener el orden relativo de los elementos conservados.
- No generar ciclos ni perder nodos que deban continuar en la lista.
- Actualizar `head` solamente cuando se elimina la posición 0.

**Gestión de memoria en Java:**
- Explicar que eliminar un nodo consiste en desvincularlo de la lista.
- El nodo eliminado podrá ser recuperado posteriormente por el Garbage Collector cuando ya no existan referencias que lo hagan alcanzable.
- No utilizar liberación manual de memoria.
- No afirmar que la recolección ocurre inmediatamente.

**Manejo del atributo `size`:**
- Disminuirlo exactamente una vez después de una eliminación válida.
- No modificarlo ante posiciones inválidas.
- Asegurar que coincida con la cantidad de nodos alcanzables desde `head`.
- Cuando se elimina el único nodo, dejar `size = 0` y `head = null`.
- Evitar decrementos duplicados si se reutiliza un método auxiliar de eliminación al inicio.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben respetar la implementación básica de listas enlazadas de los ejercicios anteriores y permitir construir escenarios de prueba.

**Casos especiales:**
- Lista vacía: rechazar cualquier posición.
- Lista de un solo nodo: permitir únicamente posición 0.
- Eliminar el primer nodo de una lista con varios elementos.
- Eliminar un nodo intermedio.
- Eliminar el último nodo.
- Eliminar nodos consecutivos en operaciones sucesivas.
- Eliminar de manera repetida la posición 0 hasta vaciar la lista.
- Elementos repetidos: eliminar exclusivamente el nodo de la posición indicada, no todos los que tengan el mismo valor.
- Valores negativos, cero y extremos de `int`.
- Posiciones negativas.
- Posición igual a `size`.
- Posición mayor que `size`.
- Posiciones extremadamente grandes, como `Integer.MAX_VALUE`.
- Verificar que los intentos inválidos no alteren `head`, `size`, datos o enlaces.

**Complejidad:**
- Validación de posición: O(1), utilizando `size`.
- Eliminación en posición 0: O(1).
- Eliminación de un nodo intermedio: O(n) en el peor caso.
- Eliminación del último nodo: O(n).
- Cambio de enlaces una vez localizado el nodo anterior: O(1).
- Espacio auxiliar del método: O(1), utilizando referencias auxiliares.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque la implementación no mantiene una referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio6.java`.
- Implementar una clase pública `Ejercicio6` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio6`, para evitar conflictos de nombres con los ejercicios anteriores.
- Implementar manualmente la lista mediante referencias entre nodos.
- Mantener privados los atributos internos.
- Mantener `head` y `size` como únicos atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para resolver el ejercicio.
- No utilizar `Stream` ni conversiones a arreglos.
- No depender de clases implementadas en los ejercicios anteriores.
- Incorporar comentarios que expliquen la validación del índice, el recorrido hasta el nodo anterior, la actualización de referencias y el comportamiento del Garbage Collector.
- Mostrar los estados de la lista antes y después de las eliminaciones relevantes.
- Verificar que la lista termine en `null` y no tenga ciclos.
- Verificar que el tamaño coincida con los nodos realmente almacenados.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`, con `size = 5`.
4. Ejecutar `eliminarEnPosicion(2)`.
5. Verificar `10 -> 20 -> 40 -> 50 -> null`, con `size = 4`.
6. Ejecutar `eliminarEnPosicion(0)`.
7. Verificar `20 -> 40 -> 50 -> null`, con `size = 3`.
8. Ejecutar `eliminarEnPosicion(2)`.
9. Verificar `20 -> 40 -> null`, con `size = 2`.
10. Intentar `eliminarEnPosicion(-1)` y comprobar `IndexOutOfBoundsException`.
11. Intentar `eliminarEnPosicion(2)` y comprobar `IndexOutOfBoundsException`.
12. Verificar que las operaciones inválidas conservaron `20 -> 40 -> null`, con `size = 2`.
13. Ejecutar `eliminarEnPosicion(0)` y comprobar `40 -> null`, con `size = 1`.
14. Ejecutar nuevamente `eliminarEnPosicion(0)` y comprobar que la lista queda vacía, con `head = null` y `size = 0`.
15. Intentar `eliminarEnPosicion(0)` sobre la lista vacía y comprobar que lanza `IndexOutOfBoundsException`.

**Ejemplo adicional con valores repetidos:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `eliminarEnPosicion(2)`.
3. Verificar `10 -> 20 -> 30 -> 10 -> null`.
4. Comprobar que se eliminó solamente el segundo nodo que contenía 10 y que los demás nodos conservaron su identidad y orden.
5. Verificar que `size` disminuyó de 5 a 4.

**Pruebas adicionales:**
- Intentar eliminar en una lista vacía.
- Eliminar el único nodo de una lista.
- Rechazar posición 1 de una lista de un nodo.
- Eliminar la primera posición.
- Eliminar una posición intermedia.
- Eliminar la última posición.
- Eliminar sucesivamente todos los nodos.
- Eliminar posiciones distintas en una misma lista.
- Eliminar la posición correspondiente a un dato repetido.
- Comprobar que los duplicados restantes no se modifican.
- Rechazar posiciones negativas.
- Rechazar posiciones iguales o superiores a `size`.
- Rechazar `Integer.MIN_VALUE` e `Integer.MAX_VALUE` como posiciones.
- Comprobar que `head` cambia solamente al eliminar la primera posición.
- Comprobar que el tamaño disminuye exactamente una unidad por eliminación válida.
- Verificar que las excepciones no modifican el estado.
- Verificar que se preserva la identidad de todos los nodos restantes.
- Verificar que ningún dato restante se modifica.
- Verificar que el último nodo apunta a `null`.
- Verificar que no se generan ciclos.
- Comprobar que no quedan nodos inaccesibles que deberían permanecer.
- Alternar inserciones al inicio o al final con eliminaciones por posición.
- Comprobar que imprimir no modifica la lista.

Compilar individualmente y conjuntamente con los ejercicios 1 al 5 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 6 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 40 casos y 1104 verificaciones aprobadas, 0 fallidas.

| Operación principal | Lista resultante | size |
|---|---|---:|
| Inicial | `10 -> 20 -> 30 -> 40 -> 50 -> null` | 5 |
| Eliminar posición 2 | `10 -> 20 -> 40 -> 50 -> null` | 4 |
| Eliminar posición 0 | `20 -> 40 -> 50 -> null` | 3 |
| Eliminar posición 2 | `20 -> 40 -> null` | 2 |
| Intentar posiciones -1 y 2 | `20 -> 40 -> null` | 2 |
| Eliminar posición 0 | `40 -> null` | 1 |
| Eliminar posición 0 nuevamente | `null` | 0 |

Los índices inválidos produjeron `IndexOutOfBoundsException`, incluido el intento de eliminar posición 0 sobre la lista vacía.

En `10 -> 20 -> 10 -> 30 -> 10 -> null`, eliminar posición 2 produjo `10 -> 20 -> 30 -> 10 -> null`, con tamaño 4. Se conservó la identidad de los dos nodos restantes que contienen 10.

Se probaron lista vacía y unitaria, eliminación inicial/intermedia/final, vaciado sucesivo desde el inicio y desde el final, duplicados, negativos, cero, extremos de `int` y alternancia de inserciones y eliminaciones. Se rechazaron posiciones negativas, iguales o superiores al tamaño y ambos extremos de `int` como índices.

La prueba temporal verificó identidades, datos, orden relativo, enlaces y tamaño antes y después de cada operación, comprobando que solo desapareciera el nodo solicitado y que no hubiera ciclos ni nodos perdidos. Las operaciones inválidas conservaron la estructura; la impresión produjo la salida esperada sin modificar los nodos, datos, enlaces o tamaño. Los arreglos de expectativas pertenecen solamente a las pruebas, no a la implementación.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 7 — Modificar un elemento de la lista

**Estrategia:** validar la posición mediante `size`, recorrer desde `head` exactamente hasta el nodo solicitado y actualizar su dato mediante `actual.setDato(nuevoDato)`.

**Justificación:** conocer la posición no permite acceso directo como en un arreglo; es necesario seguir los enlaces. Una vez localizado el nodo, cambiar el contenido no requiere sustituirlo ni modificar referencias.

**Estructura de clases:** `Ejercicio7` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`. Los atributos son privados. `Nodo` incorpora `setDato`; la lista utiliza solamente `head` y `size`, sin `tail` ni almacenamiento en arreglos o colecciones.

**Operaciones:** `modificar(int posicion, int nuevoDato)` valida y cambia únicamente el dato indicado. Las operaciones auxiliares son `insertarAlInicio`, `insertarAlFinal`, `obtener`, `imprimir`, `estaVacia` y `getSize`.

**Manejo de referencias:** `actual` es una referencia local de recorrido. `actual.setDato(nuevoDato)` conserva el objeto y sus conexiones; `setSiguiente` cambiaría la estructura y no se utiliza para modificar el contenido. No se crean ni eliminan nodos ni se alteran `head`, `size` o enlaces.

**Casos especiales:** lista vacía no admite posiciones; lista unitaria solo admite 0. Se contemplan inicio, medio, final, modificaciones repetidas, valor idéntico y duplicados, cambiando solamente la posición indicada. Índices negativos o iguales o superiores a `size` producen `IndexOutOfBoundsException` sin cambios. Se admiten negativos, cero y extremos de `int` como nuevos datos.

**Complejidad:** validación y modificación inicial O(1); modificación intermedia o final O(n) en el peor caso. Actualizar el dato cuesta O(1). Espacio auxiliar O(1), almacenamiento total O(n). Inserción al inicio O(1), al final O(n) sin `tail`, consulta `obtener` O(n) en el peor caso, impresión O(n), consultas de vacío y tamaño O(1).

#### Prompt generado por el agente analista

~~~markdown
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
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 7 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 41 casos y 1566 verificaciones aprobadas, 0 fallidas.

| Operación principal | Lista resultante | size |
|---|---|---:|
| Inicial | `10 -> 20 -> 30 -> 40 -> null` | 4 |
| `modificar(2, 99)` | `10 -> 20 -> 99 -> 40 -> null` | 4 |
| `modificar(0, 5)` | `5 -> 20 -> 99 -> 40 -> null` | 4 |
| `modificar(3, 50)` | `5 -> 20 -> 99 -> 50 -> null` | 4 |
| `modificar(1, 20)` | `5 -> 20 -> 99 -> 50 -> null` | 4 |

Las posiciones -1, 4 y 100 produjeron `IndexOutOfBoundsException` sin cambios. En `10 -> 20 -> 10 -> 30 -> 10 -> null`, modificar posición 2 a 99 produjo `10 -> 20 -> 99 -> 30 -> 10 -> null`, conservando tamaño 5 y los otros dos valores 10.

Se probaron lista vacía y unitaria, inicio/medio/final, modificaciones sucesivas, datos idénticos, duplicados, negativos, cero y extremos de `int`, índices extremos inválidos y alternancia de inserciones y modificaciones. Las consultas `obtener` verificaron los resultados en todas las posiciones de las listas examinadas.

La prueba temporal comparó `head`, tamaño, identidad de cada nodo, datos y referencias `siguiente` antes y después de cada caso, comprobando que solo cambiara el dato solicitado. Las excepciones conservaron íntegro el estado. Se verificaron nodos alcanzables en orden, terminación en `null`, ausencia de ciclos, salida exacta de impresión e impresión sin modificaciones. Los arreglos de expectativas pertenecen exclusivamente a la prueba temporal, no a la implementación.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 8 — Contar ocurrencias de un valor

**Estrategia:** recorrer todos los nodos desde `head` hasta `null` mediante `actual`, incrementando un contador inicialmente cero por cada coincidencia.

**Justificación:** pueden existir coincidencias posteriores a la primera; a diferencia de `buscar`, contar requiere completar el recorrido para contabilizarlas todas.

**Estructura de clases:** `Ejercicio8` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`, con atributos privados. La lista mantiene solamente `head` y `size`, sin `tail`, arreglos ni colecciones de almacenamiento.

**Operaciones:** `contarOcurrencias(int dato)` devuelve el total de coincidencias sin finalizar anticipadamente. Las operaciones auxiliares son `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize`.

**Manejo de referencias:** avanza únicamente la variable local `actual`; no se modifican `head`, tamaño, datos, identidades ni enlaces. No se crean ni eliminan nodos durante el conteo.

**Casos especiales:** lista vacía y valor inexistente devuelven 0; nodo único coincidente devuelve 1. Se cuentan coincidencias consecutivas, separadas y en los extremos. Si todos los nodos coinciden se devuelve `size`. Se admiten negativos, cero y extremos de `int`.

**Complejidad:** lista vacía O(1), lista no vacía O(n), incluso si el primer nodo coincide. Espacio auxiliar O(1) y almacenamiento total O(n). Inserción al inicio O(1), al final O(n) sin `tail`, impresión O(n), consultas de vacío y tamaño O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita contar cuántas veces aparece un número entero dentro de una lista enlazada simple, mediante el método `int contarOcurrencias(int dato)`.

**Estructura elegida:** lista enlazada simple de enteros formada por nodos conectados mediante referencias `siguiente`, con acceso desde `head`.

**Estrategia:** implementar una lista enlazada mediante las clases `Nodo` y `ListaEnlazada`, administrando el primer nodo mediante `head` y la cantidad de elementos mediante `size`. El método `contarOcurrencias(int dato)` debe utilizar una referencia auxiliar `actual` y un contador entero inicializado en cero. Recorrer todos los nodos desde `head` hasta llegar a `null`, incrementando el contador cada vez que el dato almacenado coincida con el valor buscado.

**Justificación:** a diferencia de una búsqueda que solamente necesita determinar si existe un valor, contar ocurrencias requiere examinar todos los nodos. Un mismo dato puede aparecer varias veces y detener el recorrido en la primera coincidencia produciría un resultado incorrecto.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones de la lista.
- `Ejercicio8`: clase pública con método `main` para demostrar el funcionamiento y ejecutar pruebas.

**Método principal:**

`int contarOcurrencias(int dato)`

Debe funcionar de la siguiente manera:

1. Inicializar una variable entera `contador = 0`.
2. Crear una referencia auxiliar `actual` que inicialmente apunte a `head`.
3. Mientras `actual != null`, comparar el valor de `actual.getDato()` con el dato buscado.
4. Si ambos valores coinciden, incrementar `contador`.
5. Avanzar siempre al siguiente nodo mediante `actual = actual.getSiguiente()`.
6. Continuar el recorrido incluso después de encontrar una o varias coincidencias.
7. Al llegar a `null`, devolver `contador`.

**Diferencia respecto de buscar(int dato):**
- `buscar(int dato)` devuelve un booleano e interrumpe la búsqueda al encontrar la primera coincidencia.
- `contarOcurrencias(int dato)` devuelve un entero y debe recorrer toda la lista, incluso cuando ya encontró una coincidencia.
- No utilizar `return` dentro del recorrido para terminar al encontrar el primer valor.
- El resultado debe ser cero cuando no existe ninguna coincidencia.

**Manejo de referencias:**
- Comenzar el recorrido desde `head`.
- Utilizar `actual` como referencia auxiliar.
- Avanzar exactamente de un nodo al siguiente en cada iteración.
- No modificar `head`.
- No modificar ninguna referencia `siguiente`.
- No modificar datos almacenados.
- No crear ni eliminar nodos.
- No cambiar `size`.
- No utilizar arreglos para contar los valores.
- Mantener la identidad y el orden de todos los nodos.
- Finalizar correctamente el recorrido al llegar a `null`.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben seguir la implementación básica utilizada en los ejercicios anteriores y servir para construir los casos de prueba.

**Casos especiales:**
- Lista vacía: devolver 0.
- Lista de un solo nodo que coincide: devolver 1.
- Lista de un solo nodo que no coincide: devolver 0.
- Valor inexistente: devolver 0.
- Valor presente una sola vez.
- Valor presente varias veces en posiciones consecutivas.
- Valor presente varias veces en posiciones separadas.
- Todas las posiciones contienen el valor buscado: devolver `size`.
- Primera posición coincidente.
- Última posición coincidente.
- Datos negativos, cero y extremos de `int`.
- Comprobar que contar ocurrencias no modifica la lista.

**Complejidad:**
- Lista vacía: O(1).
- Lista no vacía: O(n), porque debe examinar todos los nodos.
- El costo no disminuye aunque la primera posición contenga el valor buscado, ya que pueden existir otras coincidencias.
- Espacio auxiliar de `contarOcurrencias`: O(1), porque solo se utilizan un contador y una referencia auxiliar.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza una referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio8.java`.
- Implementar una clase pública `Ejercicio8` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio8`, para evitar conflictos de nombres.
- Implementar manualmente la estructura mediante nodos y referencias.
- Mantener privados los atributos internos.
- Utilizar `head` y `size` como únicos atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas como estructura de almacenamiento o mecanismo de conteo.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para implementar el ejercicio.
- No utilizar `Stream`, `Collections.frequency()` ni conversiones a arreglos para contar ocurrencias.
- No depender de clases implementadas en otros ejercicios.
- Incluir comentarios que expliquen el recorrido secuencial, el contador y por qué no se debe detener el recorrido en la primera coincidencia.
- Mostrar claramente el valor buscado y la cantidad de apariciones.
- Verificar que el atributo `size` coincida con la cantidad de nodos alcanzables desde `head`.
- Verificar que no existan ciclos y que el último nodo termine en `null`.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 10, 30 y 10.
3. Mostrar `10 -> 20 -> 10 -> 30 -> 10 -> null`, con `size = 5`.
4. Ejecutar `contarOcurrencias(10)` y verificar que devuelve 3.
5. Ejecutar `contarOcurrencias(20)` y verificar que devuelve 1.
6. Ejecutar `contarOcurrencias(30)` y verificar que devuelve 1.
7. Ejecutar `contarOcurrencias(99)` y verificar que devuelve 0.
8. Ejecutar `contarOcurrencias(-5)` y verificar que devuelve 0.
9. Verificar que `head`, `size`, los datos, las identidades y los enlaces de los nodos permanecieron intactos.
10. Mostrar nuevamente la lista y comprobar que su contenido no cambió.

**Ejemplo adicional con todos los elementos repetidos:**
1. Construir `7 -> 7 -> 7 -> 7 -> null`.
2. Ejecutar `contarOcurrencias(7)` y comprobar que devuelve 4.
3. Ejecutar `contarOcurrencias(8)` y comprobar que devuelve 0.
4. Verificar que el método recorre correctamente la lista completa y que `size` sigue siendo 4.

**Pruebas adicionales:**
- Contar ocurrencias en una lista vacía.
- Lista de un solo nodo con coincidencia.
- Lista de un solo nodo sin coincidencia.
- Valor inexistente en una lista de varios nodos.
- Valor que aparece una sola vez.
- Valor que aparece varias veces consecutivas.
- Valor que aparece varias veces separadas.
- Valor repetido al inicio y al final.
- Todos los nodos con el mismo dato.
- Todos los nodos con datos diferentes.
- Valores negativos.
- Valor cero.
- `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Alternar inserciones al inicio y al final antes de contar.
- Realizar múltiples conteos consecutivos sobre la misma lista.
- Verificar que el resultado nunca sea negativo.
- Verificar que el resultado no sea mayor que `size`.
- Verificar que contar ocurrencias no modifica `head`.
- Verificar que contar ocurrencias no modifica `size`.
- Verificar que los datos y las referencias `siguiente` permanecen idénticos.
- Verificar que se conserva la identidad de los nodos.
- Verificar que no se generan ciclos ni nodos inaccesibles.
- Verificar que imprimir no altera la estructura.

Compilar individualmente y conjuntamente con los ejercicios 1 al 7 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar por separado la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 8 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 47 casos aprobados, 0 fallidos; 1926 verificaciones aprobadas, 0 fallidas.

En `10 -> 20 -> 10 -> 30 -> 10 -> null`, con tamaño 5:

| Valor buscado | Ocurrencias |
|---|---:|
| 10 | 3 |
| 20 | 1 |
| 30 | 1 |
| 99 | 0 |
| -5 | 0 |

En `7 -> 7 -> 7 -> 7 -> null`, contar 7 devolvió 4 y contar 8 devolvió 0; el tamaño permaneció en 4. Estos resultados verifican que el método no se detiene en la primera coincidencia.

Se probaron lista vacía y unitaria, valores ausentes, una o varias coincidencias, duplicados consecutivos y separados, coincidencias iniciales y finales, todos iguales, todos diferentes, negativos, cero, extremos de `int`, conteos sucesivos e inserciones alternadas al inicio y final. Se verificó que cada resultado estuviera entre 0 y `size`.

La prueba temporal comparó `head`, tamaño, identidades, datos y enlaces antes y después de contar e imprimir. Se verificaron todos los nodos alcanzables en orden, terminación en `null`, ausencia de ciclos y salida exacta de impresión. Los arreglos de expectativas pertenecen exclusivamente a la prueba temporal, no al almacenamiento ni al algoritmo de conteo de la lista.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 9 — Invertir una lista enlazada simple

**Estrategia:** recorrer una sola vez con las referencias `anterior`, `actual` y `siguiente`, invirtiendo cada enlace y actualizando `head` al finalizar. El algoritmo es iterativo y no modifica `size`.

**Justificación:** invertir el orden requiere redirigir enlaces, sin intercambiar datos, crear nodos ni copiar la lista. Guardar el siguiente original evita perder la parte pendiente de procesar.

**Estructura de clases:** `Ejercicio9` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ListaEnlazada`, con atributos privados. La lista mantiene solamente `head` y `size`, sin `tail`, arreglos ni colecciones de almacenamiento.

**Operaciones:** `invertir()` redirige los enlaces de los mismos nodos. Las operaciones auxiliares son `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize`.

**Manejo de referencias:** `anterior` comienza en `null` y representa el extremo ya invertido; `actual` comienza en `head`; `siguiente` conserva el próximo nodo original. El orden es:

~~~java
Nodo siguiente = actual.getSiguiente();
actual.setSiguiente(anterior);
anterior = actual;
actual = siguiente;
~~~

Cambiar el enlace antes de guardar el siguiente puede perder nodos; avanzar por el enlace ya invertido recorre la cadena incorrecta. Al finalizar, `head = anterior` establece el nuevo primer nodo. El primer nodo original termina apuntando a `null`.

**Casos especiales:** lista vacía conserva `head == null`; lista unitaria conserva el mismo nodo. Se contemplan longitudes pares e impares, duplicados y datos extremos. Dos inversiones restauran los mismos nodos en su orden original; tres equivalen a una. Las inserciones posteriores siguen funcionando.

**Complejidad:** inversión O(n), con O(1) para lista vacía o unitaria y espacio auxiliar O(1). Almacenamiento total O(n). Inserción al inicio O(1), al final O(n) sin `tail`, impresión O(n), consultas de vacío y tamaño O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que permita invertir el orden de una lista enlazada simple de números enteros mediante el método `void invertir()`, modificando las referencias entre los nodos originales.

**Estructura elegida:** lista enlazada simple formada por nodos que almacenan un dato entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada mediante las clases `Nodo` y `ListaEnlazada`, administrada con `head` y `size`. Para invertirla, utilizar tres referencias auxiliares denominadas `anterior`, `actual` y `siguiente`. Recorrer los nodos una sola vez y modificar sus enlaces `siguiente` para invertir la dirección de la cadena sin crear una nueva lista ni reemplazar los nodos.

**Justificación:** una lista enlazada simple está organizada mediante referencias que conectan cada nodo con el siguiente. Para invertir su orden no es necesario intercambiar los datos ni copiar los elementos: basta con redirigir correctamente las referencias. Sin embargo, es fundamental guardar el siguiente nodo antes de modificar el enlace actual, porque de lo contrario podría perderse el acceso al resto de la lista.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones.
- `Ejercicio9`: clase pública con método `main` para demostrar la inversión y ejecutar pruebas.

**Método principal:**

`void invertir()`

Debe invertir físicamente las referencias entre los nodos de la lista, manteniendo sus identidades y datos originales.

**Referencias auxiliares:**
- `anterior`: indica el nodo que debe quedar después del nodo actual en la lista invertida.
- `actual`: identifica el nodo que se está procesando.
- `siguiente`: conserva temporalmente la referencia al próximo nodo de la lista original antes de modificar su enlace.

**Algoritmo requerido:**

1. Inicializar `anterior = null`.
2. Inicializar `actual = head`.
3. Mientras `actual != null`, repetir:
   - Guardar el nodo siguiente mediante `siguiente = actual.getSiguiente()`.
   - Invertir el enlace con `actual.setSiguiente(anterior)`.
   - Actualizar `anterior = actual`.
   - Avanzar mediante `actual = siguiente`.
4. Al terminar el recorrido, actualizar `head = anterior`.
5. Conservar `size` sin modificaciones.

**Orden correcto de actualización:**

La secuencia fundamental debe ser:

`Nodo siguiente = actual.getSiguiente();`

`actual.setSiguiente(anterior);`

`anterior = actual;`

`actual = siguiente;`

Primero se conserva la referencia al próximo nodo original. Después se invierte el enlace actual y finalmente avanzan las referencias auxiliares.

**Importancia del orden:**
- Si se modifica `actual.siguiente` antes de guardar el siguiente nodo, puede perderse el acceso a la parte de la lista que todavía no fue procesada.
- Si se avanza `actual` después de sobrescribir su referencia `siguiente`, puede recorrerse incorrectamente la cadena invertida.
- Si no se actualiza `head` al finalizar, la lista no tendrá como punto de entrada al nuevo primer nodo.
- Si no se inicializa `anterior` en `null`, el último nodo de la lista invertida puede quedar conectado incorrectamente.
- Si se cambian enlaces de forma incorrecta, pueden generarse ciclos o quedar nodos inaccesibles.

**Restricciones sobre los nodos:**
- No intercambiar los valores almacenados.
- No modificar el atributo `dato` de ningún nodo.
- No crear nodos nuevos para realizar la inversión.
- No eliminar nodos.
- No reconstruir una segunda lista.
- No utilizar arreglos, pilas, colas ni colecciones predefinidas para invertir.
- Conservar exactamente los mismos objetos Nodo, cambiando solamente sus referencias `siguiente`.
- Conservar `size` sin cambios.
- Después de la inversión, todos los nodos deben ser alcanzables desde el nuevo `head`.
- El último nodo debe apuntar a `null`.
- La lista no debe contener ciclos.

**Casos especiales:**
- Lista vacía: invertir debe conservar `head == null` y `size == 0`.
- Lista de un nodo: debe conservar el mismo nodo como `head`.
- Lista de dos nodos: invertir correctamente ambas referencias.
- Lista de tres o más nodos: invertir el orden completo.
- Valores repetidos: invertir los nodos respetando su identidad, sin confundirlos por tener el mismo dato.
- Valores negativos, cero y extremos de `int`.
- Invertir dos veces consecutivas: debe recuperar el orden y la identidad original de todos los nodos.
- Invertir varias veces: el resultado debe alternar entre el orden original y el inverso.
- Agregar elementos después de invertir: las operaciones de inserción deben seguir funcionando correctamente.
- Lista de gran tamaño: la inversión debe funcionar sin recurrir a recursividad ni agotar la pila de llamadas.

**Complejidad:**
- `invertir()` para una lista de n elementos: O(n) de tiempo.
- Lista vacía o de un solo nodo: O(1).
- Espacio auxiliar: O(1), porque solamente se utilizan tres referencias auxiliares.
- No utilizar espacio adicional proporcional a la cantidad de nodos.
- Espacio total de almacenamiento de la lista: O(n).
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben respetar la implementación básica de los ejercicios anteriores y servir para construir los escenarios de prueba.

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio9.java`.
- Implementar una clase pública `Ejercicio9` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio9`, evitando conflictos con los ejercicios anteriores.
- Implementar manualmente la estructura con nodos y referencias.
- Mantener privados los atributos internos.
- Utilizar solamente `head` y `size` como atributos de control, sin agregar `tail`.
- Implementar `invertir()` mediante un algoritmo iterativo, no recursivo.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Stack`, `Queue`, `Deque`, `Map`, `Set`, arreglos auxiliares ni estructuras equivalentes para realizar la inversión.
- No utilizar `Stream` ni copiar los datos a otra estructura.
- No depender de clases de otros ejercicios.
- Incorporar comentarios que expliquen las tres referencias auxiliares, el orden de actualización y la importancia de preservar el nodo siguiente.
- Mostrar por consola el contenido de la lista antes y después de invertir.
- Mostrar claramente cómo cambia `head`.
- Comprobar que se conservan `size`, los datos y las identidades de todos los nodos.
- Verificar que no se generen ciclos ni queden nodos inaccesibles.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los números 10, 20, 30 y 40.
3. Mostrar `10 -> 20 -> 30 -> 40 -> null`, con `size = 4`.
4. Ejecutar `invertir()`.
5. Verificar `40 -> 30 -> 20 -> 10 -> null`, con `size = 4`.
6. Comprobar que `head` ahora apunta al mismo nodo que originalmente contenía 40.
7. Comprobar que el nodo que contiene 10 ahora es el último y apunta a `null`.
8. Verificar que todos los nodos conservaron su identidad y su dato.
9. Ejecutar nuevamente `invertir()`.
10. Verificar `10 -> 20 -> 30 -> 40 -> null`, con `size = 4`.
11. Comprobar que se restauró el orden original de los mismos nodos.

**Ejemplo adicional con duplicados:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `invertir()`.
3. Verificar `10 -> 30 -> 10 -> 20 -> 10 -> null`.
4. Comprobar que los cinco nodos originales fueron invertidos por identidad, no simplemente comparando valores.
5. Verificar que `size` sigue siendo 5.

**Pruebas adicionales:**
- Invertir una lista vacía.
- Invertir una lista de un nodo.
- Invertir una lista de dos nodos.
- Invertir listas de longitud par e impar.
- Invertir listas de varios elementos.
- Invertir listas con datos repetidos.
- Invertir listas con números negativos.
- Invertir listas que contienen cero.
- Invertir listas con `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que invertir dos veces restaura el orden original.
- Comprobar que invertir tres veces equivale a una única inversión.
- Comprobar que `head` pasa a apuntar al último nodo original.
- Comprobar que el primer nodo original pasa a ser el último.
- Comprobar que el último nodo tiene `siguiente == null`.
- Verificar que todos los nodos siguen siendo alcanzables.
- Comprobar que no se generan ciclos.
- Verificar que no se crean nodos nuevos durante la inversión.
- Verificar que no se pierde ningún nodo.
- Verificar que los datos permanecen sin cambios dentro de cada objeto Nodo.
- Comprobar que `size` permanece constante.
- Alternar inserciones al inicio y al final con inversiones.
- Invertir una lista suficientemente larga para verificar que el método es iterativo.
- Comprobar que imprimir no modifica la estructura.

Para verificar identidades, enlaces y ausencia de ciclos durante las pruebas, pueden utilizarse referencias auxiliares y mecanismos de comprobación externos al algoritmo, sin cambiar la implementación de `invertir()` ni agregar colecciones como almacenamiento de la lista.

Compilar individualmente y conjuntamente con los ejercicios 1 al 8 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar por separado la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 9 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 30 casos aprobados, 0 fallidos; 800 794 verificaciones aprobadas, 0 fallidas.

| Estado principal | Lista | head | size |
|---|---|---:|---:|
| Original | `10 -> 20 -> 30 -> 40 -> null` | Nodo original de 10 | 4 |
| Primera inversión | `40 -> 30 -> 20 -> 10 -> null` | Nodo original de 40 | 4 |
| Segunda inversión | `10 -> 20 -> 30 -> 40 -> null` | Nodo original de 10 | 4 |

La lista con duplicados `10 -> 20 -> 10 -> 30 -> 10 -> null` quedó `10 -> 30 -> 10 -> 20 -> 10 -> null`, con tamaño 5 y los cinco objetos originales en orden inverso por identidad.

Se probaron siete conjuntos: vacío, unitario, dos nodos, longitud par, longitud impar con duplicados, negativos/cero/extremos de `int` y todos iguales. Cada conjunto se invirtió tres veces y una cuarta después de insertar al inicio y al final. Se invirtió dos veces una lista de 100 000 nodos, construida mediante inserciones al inicio, sin recursividad ni desbordamiento de la pila de llamadas.

La prueba temporal guardó identidades y datos antes de cada inversión y verificó la secuencia inversa exacta de los mismos objetos, cada enlace esperado, el nuevo `head`, tamaño constante y terminación en `null`. Así se comprobaron ausencia de nodos nuevos, perdidos o ciclos y conservación del dato dentro de cada nodo, incluso entre duplicados. En las listas pequeñas también se verificaron salida exacta de impresión e impresión sin cambios. Los arreglos de comprobación pertenecen exclusivamente a las pruebas, no al algoritmo ni al almacenamiento de la lista.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 10 — Convertir una lista enlazada en genérica

**Estrategia:** parametrizar `Nodo<T>` y `ListaEnlazada<T>`, sustituyendo el dato entero por `T` y las referencias por `Nodo<T>`. Se mantienen los algoritmos manuales de recorrido y modificación de enlaces, sin `tail`.

**Justificación:** las operaciones dependen de las conexiones entre nodos, no del tipo almacenado. Una implementación sirve para `Integer`, `String` y `Alumno`, con comprobación de tipos en compilación y sin conversiones inseguras. Los tipos primitivos como `int` se representan mediante `Integer` al utilizar genéricos.

**Estructura de clases:** `Ejercicio10` contiene las clases estáticas anidadas `Nodo<T>`, `ListaEnlazada<T>` y `Alumno`, con atributos privados. La lista mantiene únicamente `head` y `size`. `Alumno` tiene identificador y nombre, métodos de consulta y representación textual.

**Operaciones:** se implementan las trece operaciones requeridas: `insertarAlInicio`, `insertarAlFinal`, `buscar`, `obtener`, `insertarEnPosicion`, `eliminar`, `eliminarEnPosicion`, `modificar`, `contarOcurrencias`, `invertir`, `imprimir`, `estaVacia` y `getSize`. Los parámetros y retornos de datos utilizan `T`. La inserción por posición admite hasta `size`; obtener, modificar y eliminar por posición admiten hasta `size - 1`.

**Manejo de referencias:** se conservan los principios anteriores: conectar el nuevo nodo al resto antes de enlazarlo desde el anterior; eliminar salteando el nodo; modificar solo el dato; invertir iterativamente mediante tres referencias. No se reconstruyen los nodos restantes. Las inserciones aumentan el tamaño una vez y las eliminaciones exitosas lo disminuyen una vez; consultas, modificaciones e inversiones lo conservan.

**Comparación de objetos:** `buscar`, `eliminar` y `contarOcurrencias` utilizan `Objects.equals`, que admite `null` y aplica la igualdad definida por el tipo almacenado. `Alumno.equals` compara identificadores y `hashCode` se deriva del mismo identificador, aunque los nombres sean diferentes. La igualdad de datos se distingue de la identidad de nodos, comprobada mediante referencias en las pruebas.

**Casos especiales:** lista vacía devuelve `false`, `false` y 0 en búsqueda, eliminación por valor y conteo. Se admiten datos nulos y repetidos en todas las operaciones. Índices inválidos producen `IndexOutOfBoundsException` sin cambios. Se contemplan listas unitarias, operaciones iniciales/intermedias/finales, doble inversión y listas de distintos tipos independientes.

**Complejidad:** inserción al inicio O(1); al final O(n) sin `tail`. Búsqueda, acceso por posición, inserción por posición, eliminación por valor o posición y modificación tienen peor caso O(n). Conteo e inversión O(n). Consultas de vacío y tamaño O(1). Espacio auxiliar de las operaciones O(1), sin contar el nodo nuevo al insertar; almacenamiento O(n). Los costos de búsqueda, eliminación por valor y conteo suponen igualdad O(1); el costo de `equals` depende de `T` y puede aumentar el tiempo total. Imprimir recorre O(n) nodos, además del costo de convertir y emitir sus datos como texto.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una versión genérica de la lista enlazada simple desarrollada en los ejercicios anteriores, utilizando las clases `Nodo<T>` y `ListaEnlazada<T>`, de manera que pueda almacenar distintos tipos de objetos sin modificar los algoritmos de manejo de referencias.

**Estructura elegida:** lista enlazada simple genérica, formada por nodos `Nodo<T>` conectados mediante referencias `siguiente`, administrados desde una clase `ListaEnlazada<T>`.

**Estrategia:** transformar la implementación de enteros en una implementación parametrizada mediante `T`. Reemplazar el atributo `int dato` por `T dato` y las referencias `Nodo` por `Nodo<T>`. Mantener las operaciones sobre nodos utilizando exactamente los mismos principios de recorrido secuencial, inserción, modificación de referencias, eliminación e inversión.

**Justificación:** las operaciones de una lista enlazada dependen de cómo se conectan los nodos, no del tipo específico de información almacenada. La utilización de genéricos permite reutilizar una única implementación para `Integer`, `String`, `Alumno` y otros tipos de objetos, proporcionando comprobación de tipos durante la compilación.

**Estructura de clases:**
- `Nodo<T>`: contiene un dato de tipo `T` y una referencia `Nodo<T> siguiente`.
- `ListaEnlazada<T>`: administra `Nodo<T> head`, `int size` y las operaciones de la lista.
- `Alumno`: clase sencilla para demostrar el almacenamiento de objetos personalizados.
- `Ejercicio10`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Clase Nodo<T>:**
- Declarar `private T dato`.
- Declarar `private Nodo<T> siguiente`.
- Crear un constructor que reciba un dato de tipo `T`.
- Inicializar `siguiente` en `null`.
- Implementar los métodos de acceso necesarios para consultar y modificar el dato y la referencia siguiente.
- No utilizar tipos genéricos sin parametrizar ni conversiones inseguras.

**Clase ListaEnlazada<T>:**
- Declarar `private Nodo<T> head`.
- Declarar `private int size`.
- Inicializar `head = null` y `size = 0`.
- No incorporar una referencia `tail`, manteniendo la implementación básica trabajada durante la clase.
- Garantizar que `size` coincida siempre con la cantidad de nodos alcanzables desde `head`.

**Operaciones requeridas para integrar lo aprendido:**

1. `void insertarAlInicio(T dato)`:
   - Crear un nodo genérico.
   - Conectarlo con el `head` anterior.
   - Actualizar `head`.
   - Incrementar `size`.

2. `void insertarAlFinal(T dato)`:
   - Si la lista está vacía, asignar el nuevo nodo a `head`.
   - Si no está vacía, recorrer hasta el último nodo y enlazarlo.
   - Incrementar `size`.

3. `boolean buscar(T dato)`:
   - Recorrer desde `head` hasta encontrar el dato o llegar a `null`.
   - Comparar los valores mediante una igualdad lógica apropiada para objetos.
   - Devolver `true` cuando se encuentra la primera coincidencia y `false` si no existe.

4. `T obtener(int posicion)`:
   - Validar que la posición esté comprendida entre 0 y `size - 1`.
   - Recorrer hasta el nodo indicado.
   - Devolver el dato de tipo `T`.

5. `void insertarEnPosicion(T dato, int posicion)`:
   - Aceptar posiciones de 0 a `size`, inclusive.
   - Insertar al inicio o localizar el nodo anterior.
   - Preservar las referencias mediante el orden correcto:
     `nuevo.setSiguiente(actual.getSiguiente());`
     `actual.setSiguiente(nuevo);`
   - Incrementar `size` una sola vez.

6. `boolean eliminar(T dato)`:
   - Eliminar únicamente la primera aparición.
   - Devolver `true` si se eliminó un nodo y `false` si el dato no se encontró.
   - Actualizar `head` cuando se elimina el primer nodo.
   - Para los demás casos, modificar el enlace del nodo anterior.
   - Disminuir `size` exactamente una vez por eliminación exitosa.

7. `void eliminarEnPosicion(int posicion)`:
   - Validar el índice.
   - Eliminar `head` o encontrar el nodo anterior.
   - Actualizar el enlace sin perder el resto de la lista.
   - Disminuir `size` una sola vez.

8. `void modificar(int posicion, T nuevoDato)`:
   - Validar la posición.
   - Recorrer hasta el nodo correspondiente.
   - Cambiar únicamente el atributo `dato`.
   - Conservar todas las referencias y el tamaño.

9. `int contarOcurrencias(T dato)`:
   - Recorrer todos los nodos.
   - Contar las coincidencias sin detenerse en la primera.
   - Devolver cero cuando el valor no esté presente.

10. `void invertir()`:
    - Invertir la lista modificando las referencias de los nodos originales.
    - Utilizar `anterior`, `actual` y `siguiente`.
    - No intercambiar los datos.
    - No crear una segunda lista.
    - Actualizar `head` al finalizar.
    - Conservar `size`.

11. `void imprimir()`:
    - Recorrer desde `head` y mostrar los datos separados por `->`, finalizando con `null`.
    - Permitir imprimir los distintos tipos mediante su representación textual.

12. `boolean estaVacia()`:
    - Devolver `true` cuando `head == null`.

13. `int getSize()`:
    - Devolver el atributo `size` sin recorrer la lista.

**Igualdad de elementos genéricos:**
- No utilizar `==` para comparar el contenido lógico de objetos.
- Utilizar `java.util.Objects.equals(a, b)` en `buscar`, `eliminar` y `contarOcurrencias`, para comparar valores de forma segura.
- Admitir datos `null` como elementos válidos, utilizando una política coherente en todas las operaciones.
- Explicar que `Objects.equals` utiliza la semántica de igualdad del tipo almacenado.
- Para la clase `Alumno`, implementar `equals` y `hashCode` de forma coherente utilizando un identificador del alumno, y explicar brevemente el criterio elegido.
- No confundir igualdad de datos con identidad de nodos: para comprobar que no se reemplazaron nodos, utilizar identidad de referencias en las pruebas.

**Qué cambia con los genéricos:**
- El tipo del dato pasa de `int` a `T`.
- Los nodos pasan de `Nodo` a `Nodo<T>`.
- La lista pasa de `ListaEnlazada` a `ListaEnlazada<T>`.
- Los parámetros y retornos de operaciones que trabajan con datos utilizan `T`.
- Las comparaciones de valores deben funcionar correctamente con objetos.
- Almacenar enteros requiere `Integer`, porque los parámetros genéricos no admiten tipos primitivos como `int`.

**Qué se mantiene igual:**
- El significado de `head`.
- El atributo `size`.
- La referencia `siguiente`.
- El recorrido nodo por nodo.
- La inserción al inicio y al final.
- El orden de actualización de referencias al insertar en una posición.
- La eliminación mediante modificación de enlaces.
- La inversión iterativa con tres referencias.
- Las validaciones de posiciones.
- El principio de que el último nodo apunta a `null`.
- Las complejidades estructurales de las operaciones.

**Casos especiales:**
- Lista vacía.
- Lista de un solo nodo.
- Inserción y eliminación al inicio.
- Inserción y eliminación en posiciones intermedias.
- Inserción y eliminación al final.
- Valores repetidos.
- Elementos `null`.
- Búsquedas exitosas y fallidas.
- Posiciones negativas o fuera de rango.
- Modificación de elementos sin cambiar referencias.
- Eliminación de la primera coincidencia.
- Conteo de múltiples ocurrencias.
- Inversión de listas vacías, unitarias y de varios elementos.
- Dos inversiones consecutivas que restauren el orden original.
- Uso simultáneo de listas con diferentes parámetros genéricos.
- Verificar que ninguna operación inválida altere el estado.

**Política de excepciones:**
- Para posiciones inválidas en `obtener`, `insertarEnPosicion`, `eliminarEnPosicion` y `modificar`, lanzar `IndexOutOfBoundsException`.
- En una lista vacía, `buscar`, `eliminar` y `contarOcurrencias` deben devolver respectivamente `false`, `false` y 0.
- Mantener sin cambios el estado ante una operación rechazada.
- Las posiciones válidas para insertar son de 0 a `size`, inclusive.
- Las posiciones válidas para obtener, modificar o eliminar por posición son de 0 a `size - 1`.

**Complejidad:**
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), al no utilizar `tail`.
- `buscar`: O(n) en el peor caso, considerando comparaciones de costo constante.
- `obtener`: O(n) en el peor caso.
- `insertarEnPosicion`: O(n) en el peor caso.
- `eliminar`: O(n) en el peor caso, considerando comparaciones de costo constante.
- `eliminarEnPosicion`: O(n) en el peor caso.
- `modificar`: O(n) en el peor caso.
- `contarOcurrencias`: O(n), considerando comparaciones de costo constante.
- `invertir`: O(n) de tiempo y O(1) de espacio auxiliar.
- `imprimir`: O(n) en cantidad de nodos, sin contar el costo de convertir los datos a texto.
- `estaVacia` y `getSize`: O(1).
- Espacio de almacenamiento de la lista: O(n).
- Explicar que el costo de `equals` depende del tipo `T` y puede afectar el tiempo total de las operaciones que comparan datos.

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio10.java`.
- Implementar una clase pública `Ejercicio10` con método `main`.
- Implementar `Nodo<T>`, `ListaEnlazada<T>` y `Alumno` preferentemente como clases estáticas anidadas dentro de `Ejercicio10`, evitando conflictos con los demás ejercicios.
- Mantener privados los atributos internos.
- Utilizar exclusivamente referencias entre nodos como estructura de almacenamiento.
- No utilizar arreglos ni colecciones predefinidas para implementar la lista ni sus operaciones.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Deque`, `Map`, `Set` ni estructuras equivalentes como almacenamiento.
- No utilizar `Stream` ni copiar datos a arreglos.
- No depender de clases implementadas en otros ejercicios.
- No utilizar tipos raw ni conversiones no comprobadas.
- No incorporar funcionalidades ajenas a la consigna.
- Incluir comentarios que expliquen los genéricos, las referencias, las diferencias entre `int` y `T` y las operaciones.
- Mantener correctamente `head`, `size`, identidades y enlaces.
- Evitar ciclos, nodos perdidos y modificaciones accidentales.

**Ejemplo principal con Integer:**
1. Crear `ListaEnlazada<Integer>`.
2. Insertar 10, 20, 30 y 40.
3. Verificar `10 -> 20 -> 30 -> 40 -> null`.
4. Buscar 30 y comprobar que devuelve `true`.
5. Obtener la posición 2 y comprobar que devuelve 30.
6. Insertar 15 en la posición 1.
7. Verificar `10 -> 15 -> 20 -> 30 -> 40 -> null`.
8. Modificar la posición 2 con 99.
9. Verificar `10 -> 15 -> 99 -> 30 -> 40 -> null`.
10. Eliminar 30 por valor.
11. Verificar `10 -> 15 -> 99 -> 40 -> null`.
12. Contar las ocurrencias de 10 y verificar que devuelve 1.
13. Invertir la lista.
14. Verificar `40 -> 99 -> 15 -> 10 -> null`.
15. Comprobar que los nodos originales se conservaron y que `size` es correcto.

**Ejemplo con String:**
1. Crear `ListaEnlazada<String>`.
2. Insertar `Ana`, `Luis` y `Marta`.
3. Verificar `Ana -> Luis -> Marta -> null`.
4. Buscar `Luis` y comprobar que devuelve `true`.
5. Modificar la posición 1 por `Pedro`.
6. Comprobar `Ana -> Pedro -> Marta -> null`.
7. Eliminar `Ana`.
8. Comprobar `Pedro -> Marta -> null`.
9. Invertir y comprobar `Marta -> Pedro -> null`.

**Ejemplo con Alumno:**
1. Implementar una clase sencilla `Alumno` con un identificador, nombre y un método `toString`.
2. Implementar `equals` y `hashCode` coherentemente según el identificador.
3. Crear `ListaEnlazada<Alumno>`.
4. Insertar tres alumnos diferentes.
5. Consultar los alumnos en sus posiciones.
6. Buscar un alumno mediante un objeto distinto pero con el mismo identificador.
7. Verificar que `buscar` funciona mediante igualdad lógica y no mediante identidad de referencia.
8. Eliminar un alumno por valor.
9. Comprobar que permanecen los otros dos alumnos, con los datos y enlaces correctos.
10. Invertir la lista y comprobar el orden final.

**Pruebas adicionales:**
- Lista vacía de Integer, String y Alumno.
- Listas de un solo elemento.
- Inserciones al inicio y final.
- Inserciones en distintas posiciones.
- Eliminaciones por valor y posición.
- Modificaciones por posición.
- Búsquedas de datos existentes e inexistentes.
- Conteo de ocurrencias.
- Inversión de listas de diferentes tamaños.
- Inversión doble.
- Valores duplicados.
- Elementos `null` y comparaciones seguras con `Objects.equals`.
- Números negativos, cero y extremos de Integer.
- Cadenas vacías y repetidas.
- Objetos Alumno con igual identificador.
- Listas con distintos tipos funcionando de manera independiente.
- Rechazo de posiciones inválidas sin cambios de estado.
- Conservación de referencias e identidad de nodos durante modificaciones e inversiones.
- Confirmación de que las eliminaciones modifican enlaces sin reconstruir nodos.
- Comprobación de `size` después de cada operación.
- Detección de ciclos y nodos perdidos.
- Ejecución de secuencias variadas de operaciones.
- Verificar que los resultados reales coincidan con los esperados.

Compilar individualmente y conjuntamente con los ejercicios 1 al 9 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar por separado la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 10 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias, tipos raw, conversiones no comprobadas ni conflictos. Se ejecutaron el `main` y una prueba independiente: 2081 casos aprobados, 0 fallidos; 240 123 verificaciones aprobadas, 0 fallidas.

Resultados de los ejemplos del `main`:

- `Integer`: búsqueda de 30 y consulta de posición 2 correctas; inserción de 15, modificación a 99 y eliminación de 30 produjeron `10 -> 15 -> 99 -> 40 -> null`. Contar 10 devolvió 1. La inversión produjo `40 -> 99 -> 15 -> 10 -> null`, tamaño 4.
- `String`: buscar Luis devolvió `true`; modificar, eliminar Ana e invertir produjo `Marta -> Pedro -> null`.
- `Alumno`: se consultaron los tres objetos; buscar mediante un objeto distinto con identificador 2 devolvió `true`. Eliminarlo conservó los alumnos 1 y 3; invertir produjo `3: Marta -> 1: Ana -> null`.

La prueba ejecutó 400 pasos reproducibles por tipo (semilla 2026), combinando las trece operaciones con un modelo independiente externo. Los 2081 casos incluyen esos pasos, comprobaciones adicionales de índices inválidos, vaciado final y casos de independencia y nulos. Se probaron enteros negativos, cero, extremos, cadenas vacías y objetos distintos con igual contenido, alumnos con igual identificador, duplicados y elementos `null`. Se comprobó la coherencia de `equals` y `hashCode` de Alumno.

Después de cada paso se verificaron tamaño, valores, orden, identidades y enlaces de los nodos esperados, terminación en `null`, ausencia de ciclos y conservación de referencias ante operaciones inválidas. Se comprobaron eliminación de la primera coincidencia, conteo completo, modificación sin sustituir nodos, inversión de los mismos objetos, doble inversión e impresión sin cambios. Las listas de diferentes tipos funcionaron de forma independiente y sin errores de tipos en ejecución.

Las colecciones utilizadas como modelo e identidades esperadas pertenecen exclusivamente a la prueba temporal; la implementación almacena únicamente nodos enlazados. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.
