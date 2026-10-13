# TP6 — Pilas y Colas con Listas Enlazadas

### Metodología de trabajo

ChatGPT actúa como agente analista: interpreta las consignas, razona sobre estructuras, referencias, casos especiales y complejidades, y elabora los prompts iniciales. Codex actúa como agente desarrollador: implementa las soluciones en Java, compila, ejecuta pruebas y documenta los resultados reales.

Los prompts iniciales se conservan literalmente en este README y al comienzo de cada archivo Java; los ajustes se registran expresamente.

### Ejercicio 1 — Pila enlazada de enteros

**Estrategia:** implementar una pila con nodos enlazados y una referencia privada `head` al tope. Agregar y retirar exclusivamente desde el inicio, sin arreglos, `tail` ni capacidad máxima artificial.

**Justificación:** LIFO retira primero el último elemento agregado. Operar sobre el inicio evita recorridos y permite crecimiento dinámico mientras exista memoria disponible.

**Estructura de clases:** `Ejercicio1` contiene el `main` y las clases estáticas anidadas `Nodo` y `PilaEnteros`. El nodo almacena un entero privado y una referencia privada al siguiente, inicialmente nula. La pila mantiene únicamente `head`, inicialmente nulo.

**Operaciones:** `push` agrega al tope; `pop` retira y devuelve el tope; `peek` consulta sin retirar; `isEmpty` comprueba si `head` es nulo; `contains` recorre hasta la primera coincidencia o `null`; `print` muestra del tope al fondo con flechas y terminación en `null`. Las operaciones son iterativas e independientes de otros prácticos.

**Manejo de referencias:** `push` ejecuta primero `nuevo.setSiguiente(head)` y luego `head = nuevo`, preservando los nodos previos. `pop` guarda el dato y actualiza `head = head.getSiguiente()`. Ambas operaciones cuestan O(1). El nodo retirado podrá ser recuperado posteriormente por el Garbage Collector si no quedan referencias que lo hagan alcanzable, sin liberación manual ni garantía de recolección inmediata.

**Casos especiales:** pila vacía, nodo único, repetidos, negativos, cero y extremos de `int`. `contains` devuelve `false` sobre pila vacía y `print` muestra `null`. `pop` y `peek` vacíos producen `IllegalStateException` antes de modificar referencias. La pila puede reutilizarse después de vaciarla.

**Complejidad:** `push`, `pop`, `peek` e `isEmpty` O(1). `contains` O(n) en el peor caso, `print` O(n). Espacio auxiliar O(1), sin contar el nodo creado por `push`, y almacenamiento total O(n).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una pila de números enteros mediante una lista enlazada simple construida desde cero, utilizando nodos y referencias en lugar de un arreglo.

**Estructura elegida:** pila enlazada de enteros, siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** implementar una clase `Nodo` que almacene un entero y una referencia al siguiente nodo. Implementar una clase `PilaEnteros` que mantenga una referencia `head` al nodo superior de la pila. Las operaciones de inserción y eliminación deben realizarse exclusivamente desde `head`, para mantener una complejidad O(1).

**Justificación:** una pila se caracteriza porque el último elemento que ingresa es el primero que se retira. Una lista enlazada permite implementar ese comportamiento agregando y quitando nodos desde el inicio. Como no es necesario recorrer los nodos, `push` y `pop` tienen complejidad O(1). A diferencia de una pila con arreglo de capacidad fija, la pila enlazada puede crecer dinámicamente mientras exista memoria disponible.

**Representación de los nodos:**
- Cada nodo almacena `int dato`.
- Cada nodo almacena una referencia `Nodo siguiente`.
- Al crearse, el siguiente nodo debe inicializarse en `null`.
- Los nodos se conectan mediante referencias.
- El último nodo de la pila debe apuntar a `null`.

**Representación de la pila:**
- Mantener una referencia privada `head`.
- `head` representa el tope de la pila.
- Inicializar `head = null`.
- Una pila estará vacía cuando `head == null`.
- No utilizar una referencia `tail` porque no resulta necesaria para administrar una pila LIFO desde el inicio.
- No utilizar arreglos como almacenamiento de la estructura.
- La pila no debe imponer una capacidad máxima artificial.

**Operaciones requeridas:**

1. `void push(int dato)`:
   - Crear un nuevo nodo con el dato recibido.
   - Hacer que el nuevo nodo apunte al `head` anterior.
   - Actualizar `head` para que apunte al nuevo nodo.
   - Mantener accesibles los nodos anteriores.
   - No recorrer la pila.

2. `int pop()`:
   - Verificar primero que la pila no esté vacía.
   - Obtener el valor almacenado en `head`.
   - Actualizar `head` para que apunte al siguiente nodo.
   - Devolver el valor retirado.
   - No recorrer el resto de la pila.
   - Si la pila queda vacía, `head` debe pasar a `null`.

3. `int peek()`:
   - Verificar que la pila no esté vacía.
   - Devolver el dato almacenado en `head`.
   - No retirar el nodo.
   - No modificar ninguna referencia.

4. `boolean isEmpty()`:
   - Devolver `true` si `head == null`.
   - Devolver `false` si existe al menos un nodo.

5. `boolean contains(int dato)`:
   - Recorrer la pila desde `head` utilizando una referencia auxiliar.
   - Comparar cada dato con el valor buscado.
   - Devolver `true` cuando se encuentre la primera coincidencia.
   - Si se alcanza `null` sin encontrar el valor, devolver `false`.
   - No modificar la pila.

6. `void print()`:
   - Recorrer desde `head` hasta `null`.
   - Mostrar los elementos comenzando por el tope.
   - Representar la pila utilizando flechas y terminar con `null`.
   - No modificar el contenido ni las referencias durante la impresión.

**Funcionamiento interno de push:**

Si la pila contiene:

`head -> 30 -> 20 -> 10 -> null`

Y ejecutamos `push(40)`, debemos:

1. Crear el nodo que almacena 40.
2. Conectar el nuevo nodo con el antiguo `head`.
3. Actualizar `head` al nodo 40.

Resultado:

`head -> 40 -> 30 -> 20 -> 10 -> null`

El orden de las referencias es fundamental:

`nuevo.setSiguiente(head);`

`head = nuevo;`

No invertir estas instrucciones, porque podríamos perder el acceso a los nodos originales.

**Funcionamiento interno de pop:**

Si la pila contiene:

`head -> 40 -> 30 -> 20 -> 10 -> null`

Al ejecutar `pop()`:

1. Verificar que `head` no sea `null`.
2. Guardar el valor 40.
3. Actualizar `head` para que apunte al nodo 30.
4. Devolver 40.

Resultado:

`head -> 30 -> 20 -> 10 -> null`

El nodo retirado deja de pertenecer a la pila. Cuando ya no existan referencias que lo hagan alcanzable, podrá ser recuperado posteriormente por el Garbage Collector de Java.

**Casos especiales:**
- Pila recién creada y vacía.
- Ejecutar `pop()` sobre una pila vacía.
- Ejecutar `peek()` sobre una pila vacía.
- Apilar el primer elemento.
- Retirar el único elemento.
- Apilar y desapilar varios elementos.
- Buscar en una pila vacía.
- Buscar el tope.
- Buscar un elemento intermedio.
- Buscar el último elemento.
- Buscar un valor inexistente.
- Valores repetidos.
- Números negativos, cero y extremos de `int`.
- Comprobar que `peek`, `contains` y `print` no modifican la estructura.
- Comprobar que una operación inválida no altera el estado.
- Verificar que los nodos restantes continúan enlazados correctamente después de cada `pop`.

**Política de errores:**
- `pop()` sobre una pila vacía debe lanzar `IllegalStateException`.
- `peek()` sobre una pila vacía debe lanzar `IllegalStateException`.
- Las excepciones no deben modificar `head` ni los enlaces.
- `contains()` sobre una pila vacía debe devolver `false`.
- `print()` sobre una pila vacía debe mostrar una representación clara de la estructura vacía, por ejemplo `null`.

**Complejidad:**
- `push`: O(1).
- `pop`: O(1).
- `peek`: O(1).
- `isEmpty`: O(1).
- `contains`: O(n) en el peor caso.
- `print`: O(n).
- Espacio auxiliar de las operaciones: O(1), sin contar la creación del nodo de `push`.
- Espacio total de almacenamiento: O(n), correspondiente a los nodos de la pila.

**Requisitos de implementación:**
- Crear `src/Ejercicio1.java` dentro de la carpeta real del TP6.
- Implementar una clase pública `Ejercicio1` con método `main`.
- Implementar una clase auxiliar `Nodo` con `dato` y `siguiente`.
- Implementar una clase auxiliar `PilaEnteros` con una referencia privada `head`.
- Preferir clases estáticas anidadas dentro de `Ejercicio1` para evitar conflictos de nombres con futuros ejercicios.
- Mantener privados los atributos internos.
- Implementar manualmente las seis operaciones solicitadas.
- No utilizar `Stack`, `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- No utilizar arreglos como estructura interna de almacenamiento.
- No utilizar recursividad para implementar `push`, `pop`, `peek`, `contains` o `print`.
- No depender de clases implementadas en otros trabajos prácticos.
- Incorporar comentarios que expliquen LIFO, el papel de `head`, el manejo de referencias y el Garbage Collector.
- Mostrar el contenido de la pila antes y después de las operaciones relevantes.
- Verificar que el último nodo siempre apunte a `null`.
- Verificar que no se generen ciclos ni nodos inaccesibles que deban continuar en la pila.

**Ejemplo principal:**
1. Crear una pila enlazada vacía.
2. Comprobar que `isEmpty()` devuelve `true`.
3. Ejecutar `push(10)`.
4. Ejecutar `push(20)`.
5. Ejecutar `push(30)`.
6. Mostrar `30 -> 20 -> 10 -> null`.
7. Consultar `peek()` y comprobar que devuelve 30.
8. Ejecutar `contains(20)` y comprobar que devuelve `true`.
9. Ejecutar `contains(99)` y comprobar que devuelve `false`.
10. Ejecutar `push(40)`.
11. Mostrar `40 -> 30 -> 20 -> 10 -> null`.
12. Ejecutar `pop()` y verificar que devuelve 40.
13. Ejecutar `pop()` y verificar que devuelve 30.
14. Ejecutar `pop()` y verificar que devuelve 20.
15. Ejecutar `pop()` y verificar que devuelve 10.
16. Verificar que `isEmpty()` devuelve `true`.
17. Comprobar que `head == null`.
18. Intentar ejecutar `pop()` y `peek()` sobre la pila vacía y verificar las excepciones correspondientes.
19. Comprobar que las operaciones inválidas conservaron el estado vacío.
20. Ejecutar `push(50)` después de vaciar la pila y comprobar que vuelve a funcionar correctamente.

**Pruebas adicionales:**
- Pila vacía.
- Pila de un nodo.
- Pila de múltiples nodos.
- Múltiples inserciones consecutivas.
- Múltiples retiros consecutivos.
- Alternancia de `push` y `pop`.
- Comprobación del orden LIFO.
- Consulta `peek()` sin eliminar.
- Búsqueda exitosa y fallida.
- Búsqueda de un dato repetido.
- Búsqueda de números negativos.
- Búsqueda del valor cero.
- Búsqueda de `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Rechazo de `pop()` sobre pila vacía.
- Rechazo de `peek()` sobre pila vacía.
- Conservación de identidad y datos de los nodos restantes.
- Comprobación de que `push` no pierde el antiguo `head`.
- Comprobación de que `pop` actualiza correctamente `head`.
- Comprobación de que el último nodo termina en `null`.
- Comprobación de ausencia de ciclos.
- Comprobación de que `contains` y `print` no modifican la pila.
- Verificar que puede volver a utilizarse después de quedar vacía.
- Verificar el comportamiento con secuencias largas de operaciones.

Compilar individualmente y ejecutar utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. Se utilizó la carpeta existente `TP6-Pilas-y-Colas-Listas`, conforme a la instrucción de respetar su nombre real. El prompt inicial permanece literal y la ausencia de ajustes se registra al final del archivo Java.

#### Resultado

Compilación individual correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias. Se ejecutaron el `main` y una prueba independiente: 200 139 casos/operaciones comprobados y 300 461 verificaciones aprobadas, 0 fallidos. El recuento de casos incluye individualmente las 100 000 inserciones y 100 000 retiros de la secuencia larga; no representa esa cantidad de escenarios independientes.

En el ejemplo principal:

- La pila comenzó vacía y mostró `null`.
- Tras apilar 10, 20 y 30 mostró `30 -> 20 -> 10 -> null`.
- `peek()` devolvió 30, `contains(20)` devolvió `true` y `contains(99)` devolvió `false`.
- Apilar 40 produjo `40 -> 30 -> 20 -> 10 -> null`.
- Los retiros devolvieron 40, 30, 20 y 10, en orden LIFO.
- Al vaciarse, `head == null` e `isEmpty()` fue `true`.
- `pop()` y `peek()` vacíos lanzaron `IllegalStateException`, conservando el estado.
- Apilar 50 después de vaciar produjo `50 -> null`.

También se comprobaron nodos únicos y múltiples, búsquedas del tope/medio/fondo y fallidas, repetidos, negativos, cero, extremos de `int` y cien rondas alternadas. La secuencia larga de 100 000 inserciones y retiros finalizó correctamente sin recursividad ni capacidad fija.

La prueba temporal verificó que cada nuevo nodo mantuviera enlazado el antiguo `head` y que cada retiro estableciera como nuevo `head` exactamente el siguiente nodo anterior, sin modificar sus datos. Se compararon contenido esperado, identidades y enlaces en los estados examinados, con terminación en `null` y sin ciclos o nodos perdidos. Se verificaron consultas e impresión sin modificaciones y salida exacta de `print`.

Los arreglos de expectativas pertenecen exclusivamente a las pruebas, no al almacenamiento de la pila. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 2 — Cola enlazada de enteros

**Estrategia:** implementar una cola FIFO mediante nodos, con referencias privadas `head` al primero y `tail` al último. Insertar al final y retirar desde el inicio, sin arreglos ni capacidad máxima artificial.

**Justificación:** `head` permite retirar en O(1) y `tail` permite insertar en O(1). Con solamente `head`, insertar al final requeriría recorrer la cola en O(n).

**Estructura de clases:** `Ejercicio2` contiene el `main` y las clases estáticas anidadas independientes `Nodo` y `ColaEnteros`. El nodo almacena un entero y un siguiente inicialmente nulo; la cola mantiene `head` y `tail`, inicialmente nulos. Todos los atributos internos son privados.

**Operaciones:** `enqueue` agrega al final; `dequeue` retira y devuelve el primero; `peek` consulta sin retirar; `isEmpty` comprueba `head == null`; `contains` recorre hasta la primera coincidencia o `null`; `print` muestra desde el frente con flechas y termina en `null`. Todas son iterativas.

**Manejo de referencias:** al insertar en cola vacía, ambas referencias apuntan al nuevo nodo. En otro caso, primero se ejecuta `tail.setSiguiente(nuevo)` y luego `tail = nuevo`. Al retirar, `head` avanza al siguiente; si queda nulo, también se asigna `tail = null`. Con un nodo, `head == tail`; en cola no vacía, `tail.getSiguiente() == null`. Los nodos desvinculados pueden ser recuperados posteriormente por el Garbage Collector cuando no quedan referencias que los hagan alcanzables, sin liberación manual ni garantía inmediata.

**Casos especiales:** cola vacía, nodo único, duplicados, búsquedas exitosas/fallidas, negativos, cero y extremos de `int`. `dequeue` y `peek` vacíos lanzan `IllegalStateException` sin cambiar las referencias. `contains` vacío devuelve `false` y `print` muestra `null`. Se permite reutilizar la cola después de vaciarla.

**Complejidad:** `enqueue`, `dequeue`, `peek` e `isEmpty` O(1); `contains` O(n) en el peor caso; `print` O(n). Espacio auxiliar O(1), sin contar el nodo agregado, y almacenamiento total O(n).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una cola de números enteros mediante una lista enlazada simple construida desde cero, utilizando nodos conectados por referencias y manteniendo tanto `head` como `tail`.

**Estructura elegida:** cola enlazada de enteros, siguiendo el principio FIFO (First In, First Out).

**Estrategia:** implementar una clase `Nodo` que almacene un entero y una referencia al siguiente nodo. Implementar una clase `ColaEnteros` con dos referencias: `head`, que apunta al primer elemento de la cola, y `tail`, que apunta al último. Las inserciones se realizan en `tail` y los retiros en `head`, permitiendo resolver ambas operaciones en O(1).

**Justificación:** una cola FIFO debe retirar primero el elemento que ingresó antes. Utilizar solamente `head` permitiría retirar el primer nodo en O(1), pero insertar al final requeriría recorrer toda la lista en O(n). La referencia `tail` evita ese recorrido, porque permite acceder directamente al último nodo y agregar uno nuevo en O(1).

**Representación de los nodos:**
- Cada nodo almacena un atributo `int dato`.
- Cada nodo contiene una referencia `Nodo siguiente`.
- Al crear un nodo, `siguiente` debe inicializarse en `null`.
- Los nodos se conectan mediante referencias.
- El último nodo de la cola debe apuntar siempre a `null`.

**Representación de la cola:**
- Mantener una referencia privada `head` al primer nodo.
- Mantener una referencia privada `tail` al último nodo.
- Inicializar `head = null` y `tail = null`.
- La cola está vacía cuando `head == null`.
- Si está vacía, ambas referencias deben ser `null`.
- Si contiene un solo elemento, `head` y `tail` deben apuntar al mismo nodo.
- Si contiene varios elementos, `head` debe apuntar al primero y `tail` al último.
- No utilizar arreglos ni establecer una capacidad máxima artificial.
- La estructura debe crecer dinámicamente mediante nuevos nodos, mientras exista memoria disponible.

**Operaciones requeridas:**

1. `void enqueue(int dato)`:
   - Crear un nuevo nodo con el valor recibido.
   - Si la cola está vacía, actualizar tanto `head` como `tail` para que apunten al nuevo nodo.
   - Si no está vacía, conectar el antiguo `tail` con el nuevo nodo.
   - Actualizar `tail` para que apunte al nuevo nodo.
   - No recorrer la cola.
   - Conservar el orden FIFO.

2. `int dequeue()`:
   - Verificar que la cola no esté vacía.
   - Guardar el dato del nodo apuntado por `head`.
   - Actualizar `head` para que apunte al siguiente nodo.
   - Si la cola queda vacía, actualizar también `tail = null`.
   - Devolver el dato retirado.
   - No recorrer la cola.

3. `int peek()`:
   - Verificar que la cola no esté vacía.
   - Devolver el dato almacenado en `head`.
   - No modificar la estructura.

4. `boolean isEmpty()`:
   - Devolver `true` cuando `head == null`.
   - Devolver `false` cuando exista al menos un nodo.
   - Mantener coherencia con el estado de `tail`.

5. `boolean contains(int dato)`:
   - Recorrer desde `head` utilizando una referencia auxiliar.
   - Comparar cada nodo con el valor buscado.
   - Devolver `true` cuando se encuentra la primera coincidencia.
   - Devolver `false` cuando se llega a `null` sin encontrar el valor.
   - No modificar la cola.

6. `void print()`:
   - Recorrer la cola desde `head` hasta `null`.
   - Imprimir los elementos en el orden FIFO, comenzando por el primero que debe salir.
   - Representar los nodos separados por flechas y terminar con `null`.
   - No modificar ninguna referencia.

**Funcionamiento interno de enqueue:**

Si la cola contiene:

`head -> 10 -> 20 -> 30 -> null`

Y `tail` apunta al nodo 30, ejecutar `enqueue(40)` debe:

1. Crear el nodo 40, con `siguiente = null`.
2. Ejecutar `tail.setSiguiente(nuevo)`.
3. Ejecutar `tail = nuevo`.

El resultado debe ser:

`head -> 10 -> 20 -> 30 -> 40 -> null`

Ahora `tail` debe apuntar al nodo 40.

El orden correcto es importante: primero conectar el nodo nuevo y después actualizar `tail`. Si se modifica primero `tail` sin conservar el enlace desde la lista, podría perderse la conexión con el nuevo nodo.

**Caso especial de enqueue sobre cola vacía:**

Si `head == null` y `tail == null`, el primer nodo debe asignarse a ambas referencias.

`head = nuevo;`

`tail = nuevo;`

La cola debe quedar con un único nodo correctamente conectado.

**Funcionamiento interno de dequeue:**

Si la cola contiene:

`head -> 10 -> 20 -> 30 -> null`

Ejecutar `dequeue()` debe:

1. Guardar el dato 10.
2. Actualizar `head` para que apunte al nodo 20.
3. Devolver 10.
4. Mantener `tail` apuntando al nodo 30.

Resultado:

`head -> 20 -> 30 -> null`

Si se retira el único nodo de la cola, `head` pasa a `null` y también debe establecerse `tail = null`.

**Importancia de head y tail:**
- `head` permite consultar y retirar el primer nodo en O(1).
- `tail` permite insertar al final en O(1).
- Sin `tail`, insertar al final requiere recorrer desde `head` hasta el último nodo, con costo O(n).
- Ambas referencias deben permanecer coherentes después de cada inserción y eliminación.
- No utilizar `tail` para retirar elementos, porque eso no respetaría el funcionamiento solicitado de una cola FIFO.

**Casos especiales:**
- Cola recién creada y vacía.
- Primer `enqueue` sobre una cola vacía.
- `dequeue` del único nodo.
- `dequeue` de una cola con varios nodos.
- `peek` en una cola vacía.
- `dequeue` en una cola vacía.
- Agregar nuevos elementos después de vaciar la cola.
- Buscar en una cola vacía.
- Buscar el primer elemento.
- Buscar un elemento intermedio.
- Buscar el último elemento.
- Buscar un valor inexistente.
- Valores repetidos.
- Números negativos, cero, `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que `peek`, `contains` y `print` no modifican la cola.
- Comprobar que las operaciones inválidas no alteran las referencias.
- Verificar que `tail.getSiguiente() == null` cuando la cola no está vacía.

**Política de errores:**
- `dequeue()` sobre una cola vacía debe lanzar `IllegalStateException`.
- `peek()` sobre una cola vacía debe lanzar `IllegalStateException`.
- Las excepciones no deben modificar `head`, `tail` ni los enlaces.
- `contains()` sobre una cola vacía debe devolver `false`.
- `print()` sobre una cola vacía debe mostrar `null` o una representación equivalente.

**Gestión de memoria:**
- Al retirar un nodo, debe dejar de pertenecer a la cola.
- Java administra automáticamente la memoria mediante el Garbage Collector.
- Un nodo desvinculado podrá recuperarse cuando ya no existan referencias que lo hagan alcanzable.
- No utilizar liberación manual de memoria.
- No afirmar que la recolección ocurre inmediatamente.

**Complejidad esperada:**
- `enqueue`: O(1).
- `dequeue`: O(1).
- `peek`: O(1).
- `isEmpty`: O(1).
- `contains`: O(n) en el peor caso.
- `print`: O(n).
- Espacio auxiliar por operación: O(1), sin contar el nodo agregado.
- Espacio total: O(n), correspondiente a los nodos almacenados.

**Requisitos de implementación:**
- Crear `TP6-Pilas-y-Colas-Listas/src/Ejercicio2.java`.
- Implementar una clase pública `Ejercicio2` con método `main`.
- Implementar una clase auxiliar `Nodo` con los atributos `dato` y `siguiente`.
- Implementar una clase auxiliar `ColaEnteros` con las referencias `head` y `tail`.
- Preferir clases estáticas anidadas dentro de `Ejercicio2` para evitar conflictos con el Ejercicio 1.
- Mantener privados los atributos internos.
- Implementar manualmente las seis operaciones.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList`, `Stack` ni colecciones predefinidas para implementar la cola.
- No utilizar arreglos como almacenamiento de la estructura.
- No utilizar recursividad para implementar las operaciones.
- No agregar métodos o funcionalidades ajenos a la consigna, salvo auxiliares de prueba necesarios.
- No depender de las clases de otros ejercicios.
- Incorporar comentarios que expliquen FIFO, las funciones de `head` y `tail`, la actualización de referencias y los casos especiales.
- Mostrar por consola el contenido de la cola antes y después de las operaciones principales.
- Verificar que los enlaces sean correctos y que no existan ciclos.
- Comprobar que `tail` siempre apunte al último nodo cuando la cola no esté vacía.

**Ejemplo principal:**
1. Crear una cola enlazada vacía.
2. Comprobar `isEmpty() == true`.
3. Comprobar que `head == null` y `tail == null`.
4. Ejecutar `enqueue(10)`.
5. Verificar que `head` y `tail` apuntan al mismo nodo.
6. Ejecutar `enqueue(20)`.
7. Ejecutar `enqueue(30)`.
8. Mostrar `10 -> 20 -> 30 -> null`.
9. Consultar `peek()` y verificar que devuelve 10 sin retirar el nodo.
10. Ejecutar `contains(20)` y verificar que devuelve `true`.
11. Ejecutar `contains(99)` y verificar que devuelve `false`.
12. Ejecutar `enqueue(40)`.
13. Mostrar `10 -> 20 -> 30 -> 40 -> null`.
14. Verificar que `tail` apunta al nodo que contiene 40.
15. Ejecutar `dequeue()` cuatro veces y comprobar que los valores retirados son 10, 20, 30 y 40.
16. Comprobar que la cola queda vacía.
17. Verificar que `head == null` y `tail == null`.
18. Intentar `dequeue()` y `peek()` sobre la cola vacía y comprobar `IllegalStateException`.
19. Verificar que las operaciones inválidas no modificaron las referencias.
20. Ejecutar `enqueue(50)` y comprobar que la cola vuelve a funcionar, con `head` y `tail` apuntando al nuevo nodo.
21. Ejecutar `enqueue(60)` y comprobar que el orden de retiro continúa siendo FIFO.

**Pruebas adicionales:**
- Cola vacía.
- Cola de un nodo.
- Cola de varios nodos.
- Inserción del primer elemento.
- Retiro del único elemento.
- Inserciones consecutivas.
- Retiros consecutivos.
- Alternancia de inserciones y retiros.
- Verificación del orden FIFO.
- Verificación de `head` después de `dequeue`.
- Verificación de `tail` después de `enqueue`.
- Verificación de ambas referencias al vaciar la cola.
- Verificación de que `head == tail` cuando existe un único nodo.
- Comprobación de que `tail.siguiente == null`.
- Consulta `peek` sin modificaciones.
- Búsquedas exitosas y fallidas.
- Valores repetidos.
- Valores negativos, cero y extremos de `int`.
- Rechazo de `dequeue` y `peek` sobre cola vacía.
- Conservación de identidad y datos de los nodos restantes.
- Comprobación de ausencia de ciclos.
- Comprobación de que no se pierden nodos durante inserciones.
- Comprobación de que `contains` y `print` no modifican el estado.
- Reinserción después de vaciar completamente la cola.
- Secuencias extensas de inserciones y retiros para verificar los enlaces.
- Verificación de que las operaciones principales no requieren recorridos innecesarios.

Compilar individualmente y conjuntamente con el Ejercicio 1 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar separadamente la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 y 2 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 200 241 casos/operaciones comprobados y 701 689 verificaciones aprobadas, 0 fallidos. El recuento incluye individualmente 100 000 inserciones y 100 000 retiros; no representa esa cantidad de escenarios independientes.

En el ejemplo principal se insertaron 10, 20 y 30, obteniendo `10 -> 20 -> 30 -> null`. La consulta devolvió 10 sin retirar; buscar 20 devolvió `true` y buscar 99 devolvió `false`. Agregar 40 dejó `tail` en el nodo de 40. Los retiros devolvieron 10, 20, 30 y 40 en orden FIFO, dejando `head = null` y `tail = null`.

Sobre la cola vacía, `dequeue` y `peek` lanzaron `IllegalStateException` sin cambios. Reinsertar 50 estableció ambas referencias en el mismo nodo; agregar 60 y retirar ambos devolvió 50 y 60, dejando nuevamente ambos extremos nulos.

También se probaron nodo único, varios nodos, búsquedas del primero/medio/último, duplicados, negativos, cero, extremos de `int`, cien rondas alternadas y una secuencia larga de 100 000 inserciones y retiros. Cada inserción comprobó la conexión con el antiguo último y la nueva referencia `tail`; cada retiro comprobó el nuevo `head` y la conservación o limpieza de `tail`.

En los estados examinados se verificaron identidad, datos, enlaces, terminación en `null`, coherencia de ambos extremos, ausencia de ciclos y salida exacta de impresión. Las consultas, búsquedas, impresión y operaciones inválidas conservaron la estructura. Los arreglos de expectativas pertenecen exclusivamente a las pruebas, no al almacenamiento de la cola.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 3 — Pila genérica

**Estrategia y justificación:** utilizar `Nodo<T>` y `Pila<T>` para reutilizar una pila LIFO con distintos tipos, sin conversiones inseguras. `head` representa el tope; insertar y retirar desde el inicio cuesta O(1).

**Clases y operaciones:** `Ejercicio3` contiene las clases estáticas anidadas `Nodo<T>`, `Pila<T>` y `Alumno`, con atributos privados. La pila implementa `push`, `pop`, `peek`, `isEmpty`, `contains` y `print`, sin arreglos, colecciones ni dependencias de otros ejercicios.

**Manejo de referencias:** la lógica de la pila de enteros se conserva. `push` conecta primero el nuevo nodo al antiguo `head` y luego actualiza el tope. `pop` devuelve su dato y avanza `head`. Las consultas y recorridos no cambian los enlaces.

**Casos especiales y complejidad:** se admiten elementos `null`, repetidos y listas unitarias. La ausencia de nodos se determina mediante `head`, no por el dato del tope. `pop` y `peek` vacíos lanzan `IllegalStateException` sin cambios. `push`, `pop`, `peek` e `isEmpty` cuestan O(1); `contains` y `print` O(n), suponiendo igualdad y representación de costo constante. Espacio auxiliar O(1), sin contar el nodo creado, y almacenamiento O(n). El costo real de igualdad y representación depende del tipo almacenado.

**Comparación de objetos:** `contains` utiliza `Objects.equals`, que compara valores de forma segura incluso con `null`. `Alumno.equals` y `hashCode` utilizan el identificador: dos objetos distintos con igual identificador son lógicamente iguales. La identidad de nodos se comprueba por referencias en las pruebas y no se confunde con igualdad de datos.

#### Prompt generado por el agente analista

~~~markdown
Implementar una pila enlazada genérica en Java mediante `Nodo<T>` y `Pila<T>`, siguiendo el principio LIFO, para almacenar `Integer`, `String` y objetos propios.

**Estructura y justificación:** utilizar nodos con un dato de tipo `T` y una referencia `Nodo<T> siguiente`. La pila mantiene `head` como tope, ya que insertar y retirar desde el inicio permite ejecutar `push` y `pop` en O(1). Los genéricos permiten reutilizar la misma estructura con distintos tipos sin modificar los algoritmos ni utilizar conversiones inseguras.

**Clases:**
- `Ejercicio3`: clase pública con `main`.
- `Nodo<T>`: atributos privados `T dato` y `Nodo<T> siguiente`.
- `Pila<T>`: referencia privada `Nodo<T> head`.
- `Alumno`: clase sencilla con identificador y nombre para probar objetos propios.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio3`, evitando conflictos con los otros ejercicios.

**Operaciones de `Pila<T>`:**
- `void push(T dato)`: crear un nodo, enlazarlo al antiguo `head` y actualizar `head`.
- `T pop()`: retirar y devolver el dato del tope, actualizando `head`.
- `T peek()`: consultar el dato del tope sin retirarlo.
- `boolean isEmpty()`: verificar `head == null`.
- `boolean contains(T dato)`: recorrer los nodos buscando una coincidencia mediante `Objects.equals()`.
- `void print()`: mostrar los elementos desde el tope hasta `null`.

**Casos especiales:** admitir elementos `null` de forma coherente. Si `pop()` o `peek()` se ejecutan sobre una pila vacía, lanzar `IllegalStateException`. Conservar el estado ante operaciones inválidas. Verificar que los nodos permanezcan correctamente enlazados, sin ciclos ni pérdidas.

**Comparación de objetos:** utilizar `Objects.equals()` para comparar valores, evitando `==`. Para `Alumno`, implementar `equals()` y `hashCode()` coherentemente según su identificador, permitiendo encontrar un alumno mediante un objeto diferente con el mismo identificador.

**Complejidad:** `push`, `pop`, `peek` e `isEmpty`: O(1). `contains` y `print`: O(n), suponiendo comparaciones y representaciones de costo constante. Espacio auxiliar por operación: O(1). Almacenamiento total: O(n).

**Ejemplos y pruebas:**
1. `Pila<Integer>`: apilar 10, 20 y 30; verificar que `pop()` devuelve 30, 20 y 10.
2. `Pila<String>`: apilar "Ana", "Luis" y "Marta"; verificar que el primer retiro devuelve "Marta".
3. `Pila<Alumno>`: apilar tres alumnos, consultar el tope y buscar uno mediante otro objeto con igual identificador.
4. Probar pila vacía, nodo único, duplicados, elementos `null`, búsquedas exitosas y fallidas.
5. Verificar que `peek`, `contains` y `print` no modifican la pila.
6. Comprobar orden LIFO, identidad de nodos y enlaces correctos después de las operaciones.

**Restricciones:** implementar la pila desde cero, sin arreglos ni colecciones predefinidas (`Stack`, `LinkedList`, `ArrayList`, `Deque`, etc.). No utilizar clases de otros ejercicios ni modificar archivos anteriores. No realizar commits ni push.

Compilar individualmente y conjuntamente con los ejercicios 1 y 2 usando Java 21, `--release 21` y `-Xlint:all`. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 3 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 385 casos aprobados, 0 fallidos; 2585 verificaciones aprobadas, 0 fallidas. Los casos incluyen operaciones individuales y cien rondas de inserción/retiro de `null` por cada tipo, no 385 escenarios independientes.

Resultados del `main`:

- `Integer`: retiros 30, 20 y 10.
- `String`: retiros Marta, Luis y Ana.
- `Alumno`: consulta del alumno 3 (Marta), búsqueda exitosa del identificador 2 mediante un objeto diferente y retiros 3, 2 y 1.

Se probaron pilas vacías, nodo único, duplicados, negativos, cero, extremos de `int`, cadenas vacías, cadenas de igual contenido con distinta identidad, alumnos y elementos nulos. Se comprobó la coherencia de `equals` y `hashCode`, la independencia de pilas de distintos tipos y el rechazo de `pop` y `peek` vacíos sin cambios.

La prueba temporal inspeccionó `head`, identidades, datos y enlaces para comprobar que cada inserción preservara el tope anterior y cada retiro avanzara al siguiente nodo exacto. Se verificaron búsquedas exitosas/fallidas, consultas e impresión sin modificaciones, salida exacta desde el tope y terminación en `null`, sin ciclos ni nodos perdidos. Los arreglos de expectativas pertenecen solamente a las pruebas, no al almacenamiento de la pila.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 4 — Cola genérica

**Estrategia y justificación:** utilizar nodos `Nodo<T>` y una cola FIFO `Cola<T>` con `head` al primero y `tail` al último. Los genéricos permiten reutilizar la estructura con distintos tipos, sin conversiones inseguras. Insertar por `tail` y retirar por `head` cuesta O(1); sin `tail`, insertar al final requeriría O(n).

**Clases y operaciones:** `Ejercicio4` contiene las clases estáticas anidadas `Nodo<T>`, `Cola<T>` y `Cliente`, con atributos privados. La cola implementa `enqueue`, `dequeue`, `peek`, `isEmpty`, `contains` y `print`, sin arreglos, colecciones ni dependencias de otros ejercicios.

**Manejo de referencias:** la primera inserción establece ambas referencias en el nuevo nodo. Las demás conectan desde el antiguo `tail` antes de actualizarlo. Retirar avanza `head` y, si queda nulo, limpia también `tail`. Un nodo implica `head == tail`; el último siempre apunta a `null`.

**Comparación de objetos:** `contains` utiliza `Objects.equals`, que acepta `null` y aplica igualdad lógica. `Cliente.equals` y `hashCode` dependen del identificador; objetos diferentes con el mismo identificador se consideran iguales. La identidad de nodos se verifica separadamente mediante referencias.

**Casos especiales y complejidad:** se admiten datos nulos y repetidos, nodo único y reinserción después de vaciar. Una cola vacía se identifica por `head`, no por el dato almacenado. `dequeue` y `peek` vacíos lanzan `IllegalStateException` sin cambios. Inserción, retiro, consulta y vacío O(1); búsqueda e impresión O(n), suponiendo igualdad y representación de costo constante. Espacio auxiliar O(1), sin contar el nodo agregado, y almacenamiento O(n). El costo real de igualdad y representación depende del tipo almacenado.

#### Prompt generado por el agente analista

~~~markdown
Implementar desde cero una cola enlazada genérica en Java mediante `Nodo<T>` y `Cola<T>`, que respete el principio FIFO y permita almacenar distintos tipos de objetos.

**Estructura y justificación:** utilizar nodos con un dato de tipo `T` y una referencia `Nodo<T> siguiente`. La cola mantiene dos referencias: `head` al primer nodo y `tail` al último. Insertar por `tail` y retirar por `head` permite realizar `enqueue` y `dequeue` en O(1). Sin `tail`, insertar al final requeriría un recorrido O(n). La lógica FIFO es independiente del tipo de dato almacenado.

**Clases:**
- `Ejercicio4`: clase pública con método `main`.
- `Nodo<T>`: atributos privados `T dato` y `Nodo<T> siguiente`.
- `Cola<T>`: referencias privadas `Nodo<T> head` y `Nodo<T> tail`.
- `Cliente`: clase sencilla con identificador y nombre, `toString()`, `equals()` y `hashCode()` basados coherentemente en el identificador.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio4`, sin depender de otros ejercicios.

**Operaciones de `Cola<T>`:**
- `void enqueue(T dato)`: agregar un nodo al final. Si la cola está vacía, `head` y `tail` deben apuntar al nuevo nodo; en caso contrario, enlazarlo desde el antiguo `tail` y actualizar `tail`.
- `T dequeue()`: devolver y retirar el primer elemento, actualizando `head`. Si se retira el último nodo, actualizar también `tail = null`.
- `T peek()`: consultar el dato de `head` sin modificar la estructura.
- `boolean isEmpty()`: verificar si `head == null`.
- `boolean contains(T dato)`: recorrer los nodos y comparar mediante `Objects.equals()`.
- `void print()`: mostrar los elementos desde `head` hasta `null`, en orden FIFO.

**Manejo de referencias:** mantener `head == null` y `tail == null` cuando la cola está vacía. Si contiene un solo nodo, ambas referencias deben apuntar al mismo objeto. En una cola no vacía, `tail.siguiente` siempre debe ser `null`. No perder nodos ni generar ciclos.

**Casos especiales:** aceptar datos `null` de manera coherente; `dequeue()` y `peek()` sobre una cola vacía deben lanzar `IllegalStateException` sin alterar su estado. Probar duplicados, búsquedas exitosas y fallidas y reinserción después de vaciar la cola.

**Comparación de objetos:** utilizar `Objects.equals()` para que `contains()` funcione con `String`, `Cliente` y `null`. En `Cliente`, dos objetos diferentes con el mismo identificador deben considerarse iguales.

**Complejidad:** `enqueue`, `dequeue`, `peek` e `isEmpty`: O(1). `contains` y `print`: O(n), considerando operaciones sobre datos de costo constante. Espacio auxiliar: O(1). Almacenamiento total: O(n).

**Ejemplos y pruebas:**
1. `Cola<String>`: encolar `"Ana"`, `"Luis"` y `"Marta"`; verificar que los retiros devuelvan Ana, Luis y Marta, en ese orden.
2. `Cola<Cliente>`: encolar tres clientes, verificar el primero mediante `peek()` y atenderlos en orden de llegada.
3. Buscar un cliente utilizando otro objeto con el mismo identificador.
4. Probar cola vacía, un único nodo, duplicados, datos `null`, búsquedas, excepciones y reinserción.
5. Verificar que `peek`, `contains` y `print` no modifican la cola.
6. Comprobar identidad de nodos, orden FIFO, enlaces, actualización de `head` y `tail`, y ausencia de ciclos.

**Restricciones:** no utilizar arreglos ni colecciones predefinidas (`Queue`, `LinkedList`, `ArrayList`, `Deque`, etc.) para implementar la cola. No usar tipos raw ni conversiones inseguras. No modificar ejercicios anteriores ni realizar commits o push.

Compilar individualmente y conjuntamente con los ejercicios 1 al 3 utilizando Java 21, `--release 21` y `-Xlint:all`. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 4 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 385 casos aprobados, 0 fallidos; 2632 verificaciones aprobadas, 0 fallidas. Los casos incluyen operaciones individuales y cien rondas de inserción/retiro de `null` por tipo, no 385 escenarios independientes.

Resultados del `main`:

- `String`: consulta Ana; retiros Ana, Luis y Marta.
- `Cliente`: consulta del cliente 1 (Ana), búsqueda exitosa del identificador 2 mediante otro objeto y retiros 1, 2 y 3.

Se probaron también enteros, negativos, cero, extremos de `int`, cadenas vacías, duplicados, objetos distintos con igual contenido y datos nulos. Se verificaron igualdad y hash coherentes por identificador, listas independientes, búsqueda fallida, nodo único, reinserción y excepciones sobre cola vacía.

La prueba temporal comprobó identidades, datos y enlaces en los estados examinados, orden FIFO de los retiros, conservación de `head` al insertar, avance de `head` al retirar y `tail` apuntando al último nodo con siguiente nulo. Al vaciarse se verificó que ambas referencias quedaran nulas. Se comprobaron consultas e impresión sin cambios, salida exacta y ausencia de ciclos o nodos perdidos. Los arreglos de expectativas pertenecen solo a las pruebas, no al almacenamiento de la cola.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 5 — Historial de navegación con pila

**Estrategia y justificación:** almacenar las páginas anteriores en una pila enlazada LIFO. Al retroceder se recupera primero la última página abandonada; la página actual se mantiene separada del historial.

**Clases y operaciones:** `Ejercicio5` contiene las clases estáticas anidadas `Nodo`, `PilaHistorial` y `Navegador`, con atributos privados. La pila implementa `push`, `pop`, `isEmpty` e impresión iterativa. `visitar` guarda la página actual si existe y establece la nueva; `volver` recupera la anterior o devuelve `false` sin cambios; `consultarPaginaActual` devuelve la actual, inicialmente nula; `imprimirHistorial` muestra la actual y las anteriores en orden de retorno.

**Manejo de referencias:** `push` conecta `nuevo.siguiente = head` antes de actualizar `head = nuevo`. `pop` guarda la página y avanza `head = head.siguiente`. Visitar valida antes de modificar el historial o la página actual. Volver comprueba si hay nodos antes de retirar. No se almacena navegación hacia adelante.

**Casos especiales y complejidad:** navegador vacío, primer ingreso, retroceso sin historial y visitas repetidas. Páginas nulas, vacías o compuestas solo por espacios producen `IllegalArgumentException` sin cambios. Visitar, volver y consultar cuestan O(1) respecto de la cantidad de páginas; validar el nombre cuesta O(L) en el peor caso. Imprimir recorre O(n) nodos, además del costo de emitir sus textos. Espacio auxiliar O(1), sin contar el nodo agregado, y almacenamiento O(n).

#### Prompt generado por el agente analista

~~~markdown
Implementar desde cero un sistema sencillo de historial de navegación mediante una pila enlazada, que permita visitar páginas, retroceder, consultar la página actual e imprimir el historial.

**Estructura y justificación:** utilizar una pila enlazada de `String` siguiendo LIFO. Las páginas anteriores se almacenan en nodos, con `head` como tope. La última página abandonada debe ser la primera recuperada cuando el usuario vuelve atrás.

**Clases:**
- `Ejercicio5`: clase pública con `main`.
- `Nodo`: contiene `String pagina` y `Nodo siguiente`.
- `PilaHistorial`: administra `head` e implementa `push`, `pop`, `isEmpty` y recorrido.
- `Navegador`: mantiene la página actual y utiliza `PilaHistorial` para guardar las anteriores.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio5`.

**Operaciones:**
- `void visitar(String pagina)`: si existe una página actual, guardarla en la pila; luego establecer la nueva página como actual.
- `boolean volver()`: si hay historial, recuperar con `pop()` la última página anterior, convertirla en actual y devolver `true`. Si no existe historial, devolver `false` sin modificar el estado.
- `String consultarPaginaActual()`: devolver la página actual sin alterar referencias; devolver `null` si todavía no se visitó ninguna.
- `void imprimirHistorial()`: mostrar la página actual y las anteriores en orden de retorno, desde el tope hasta `null`, sin modificar la pila.

**Manejo de referencias:** `push` inserta un nodo al inicio mediante `nuevo.siguiente = head` y `head = nuevo`. `pop` recupera el dato del tope y avanza `head = head.siguiente`. No utilizar arreglos ni colecciones predefinidas para almacenar el historial.

**Casos especiales:** navegador recién creado, primer ingreso, retroceder sin historial, visitar la misma página dos veces, varias visitas y retrocesos consecutivos. Rechazar nombres de página `null`, vacíos o solo espacios con `IllegalArgumentException`, sin modificar el estado. No implementar navegación hacia adelante, porque no forma parte de la consigna.

**Complejidad:** visitar, volver y consultar página actual: O(1) respecto de la cantidad de páginas. Imprimir el historial: O(n). Espacio auxiliar por operación: O(1); almacenamiento total: O(n).

**Ejemplo principal:**
1. Crear un navegador sin página actual.
2. Visitar `"Google"`, `"YouTube"` y `"ChatGPT"`.
3. Comprobar que la página actual es `"ChatGPT"` y que el historial permite volver primero a `"YouTube"` y después a `"Google"`.
4. Ejecutar `volver()` y comprobar que la página actual pasa a `"YouTube"`.
5. Ejecutar nuevamente `volver()` y comprobar que pasa a `"Google"`.
6. Intentar otro retroceso y verificar que devuelve `false` sin modificar la página actual.
7. Visitar `"Wikipedia"` y comprobar que el historial vuelve a funcionar.

**Pruebas:** verificar LIFO, navegador vacío, visitas repetidas, nombres inválidos, conservación de referencias, ausencia de ciclos y que consultar o imprimir no modifica el estado.

**Restricciones:** implementar la pila manualmente mediante nodos. No utilizar `Stack`, `Deque`, `ArrayList`, `LinkedList` ni otras colecciones para el historial. No depender de clases de otros ejercicios ni modificar archivos anteriores.

Compilar individualmente y conjuntamente con los ejercicios 1 al 4 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No realizar commits ni push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java. Se explicita que O(1) para visitar se refiere a la cantidad de páginas, mientras que validar su nombre puede costar O(L).

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 5 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 217 casos aprobados, 0 fallidos; 1889 verificaciones aprobadas, 0 fallidas. Los casos incluyen comprobaciones de estado sucesivas y cien rondas alternadas, no 217 escenarios independientes.

| Operación principal | Página actual | Historial en orden de retorno | Resultado de volver |
|---|---|---|---|
| Inicial | `null` | `null` | — |
| Visitar Google | Google | `null` | — |
| Visitar YouTube | YouTube | `Google -> null` | — |
| Visitar ChatGPT | ChatGPT | `YouTube -> Google -> null` | — |
| Volver | YouTube | `Google -> null` | `true` |
| Volver | Google | `null` | `true` |
| Volver sin historial | Google | `null` | `false` |
| Visitar Wikipedia | Wikipedia | `Google -> null` | — |

Se probaron navegador vacío, consultas iniciales, retrocesos sin historial, visitas repetidas y cien rondas de visitas y retrocesos. Se rechazaron nombres nulos, vacíos, de espacios y de tabulación/salto de línea, conservando el estado. También se verificó que `pop` directo sobre la pila auxiliar vacía lanzara `IllegalStateException`.

La prueba temporal inspeccionó identidades, datos y referencias, comprobó el orden LIFO, el avance correcto de `head`, la salida exacta de impresión y que consultar e imprimir conservaran la página actual y todos los nodos y enlaces. Los recorridos terminaron en `null`, sin ciclos ni nodos perdidos. Las colecciones usadas para comprobación pertenecen exclusivamente a la prueba temporal; el historial utiliza solo nodos enlazados.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 6 — Cola de atención de clientes

**Estrategia y justificación:** utilizar una cola enlazada FIFO con `head` al próximo cliente y `tail` al último. Insertar al final y atender desde el inicio permite respetar el orden de llegada sin recorridos ni ordenamiento por turno.

**Clases y operaciones:** `Ejercicio6` contiene las clases estáticas anidadas `Cliente`, `Nodo` y `ColaAtencion`, con atributos privados. `Cliente` tiene nombre, turno, motivo, constructor, getters y representación textual. La cola implementa `agregarCliente`, `atenderProximo`, `consultarSiguiente`, `imprimirFila` y `estaVacia`, sin depender de otros ejercicios.

**Manejo de referencias:** al ingresar el primer cliente ambas referencias apuntan al nuevo nodo. Luego se conecta desde el antiguo `tail` antes de actualizarlo. Atender devuelve el mismo objeto Cliente y avanza `head`; al vaciarse también se asigna `tail = null`. El último nodo apunta a `null`.

**Casos especiales y complejidad:** se contemplan fila vacía, nodo único, múltiples ingresos y reutilización. Se rechazan clientes nulos, nombres o motivos nulos, vacíos o solo espacios y turnos negativos mediante `IllegalArgumentException`, sin cambios. Consultar o atender sin clientes produce `IllegalStateException`. Se permite turno 0 y nombres repetidos. Inserción física, atención, consulta y vacío O(1); validar cadenas cuesta O(L) en el peor caso, siendo L la suma de sus longitudes. Imprimir recorre O(n) nodos, además del costo de representar y emitir los datos. Espacio auxiliar O(1), sin contar el nodo agregado, y almacenamiento O(n).

#### Prompt generado por el agente analista

~~~markdown
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
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial permanece literal y esto se indica al final del Java. Se explicitan el rechazo seguro de cadenas nulas o solo espacios y el costo de validarlas, separado de la inserción física O(1).

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 6 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 231 casos aprobados, 0 fallidos; 1985 verificaciones aprobadas, 0 fallidas. Los casos incluyen comprobaciones de estado sucesivas y cien rondas alternadas, no 231 escenarios independientes.

El ejemplo consultó a Ana sin retirarla y atendió Ana (101, depósito), Luis (102, consulta) y Marta (103, transferencia), conservando sus objetos y datos. Al vaciarse, `head` y `tail` quedaron nulos. Agregar a Pedro (104, extracción) dejó la fila nuevamente operativa.

Se probaron fila vacía y unitaria, datos inválidos, consultas sin eliminación, nombres repetidos, cien rondas alternadas y reutilización. Clientes con turnos 999 y 0 fueron atendidos en ese orden de llegada, demostrando que no se ordena por turno. Se rechazaron nueve entradas inválidas: cliente nulo, nombres nulos/vacíos/de espacios, motivos nulos/vacíos/de espacios y turnos -1 e `Integer.MIN_VALUE`.

La prueba temporal comprobó identidades de clientes y nodos, datos, enlaces, extremos coherentes, terminación en `null`, ausencia de ciclos y salida exacta de impresión. Las consultas, impresión y errores conservaron el estado. Los arreglos usados para comprobar expectativas pertenecen exclusivamente a las pruebas; la fila utiliza nodos enlazados.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 7 — Verificador de paréntesis balanceados

**Estrategia y justificación:** recorrer la expresión y apilar aperturas en una pila enlazada LIFO. Cada cierre retira la última apertura pendiente; si no hay aperturas, devolver `false` inmediatamente. Al finalizar no deben quedar nodos pendientes.

**Clases y operaciones:** `Ejercicio7` contiene `estanBalanceados(String expresion)`, el `main` y las clases estáticas anidadas `Nodo` y `PilaCaracteres`, con atributos privados. La pila implementa `push(char)`, `pop()` e `isEmpty()`, sin arreglos auxiliares, colecciones ni recursividad.

**Manejo de referencias:** `push` conecta el nuevo nodo con el antiguo `head` antes de actualizar el tope. `pop` guarda el carácter y avanza `head` al siguiente. No se recorre ni copia la pila en estas operaciones. El verificador comprueba vacío antes de cada extracción.

**Casos especiales y complejidad:** cadena vacía y expresión sin paréntesis son balanceadas. Se detectan aperturas pendientes, cierres sin apertura y orden incorrecto; los demás caracteres se ignoran. `null` produce `IllegalArgumentException`. Tiempo O(n), espacio auxiliar O(n) en el peor caso por las aperturas acumuladas; cada operación de la pila cuesta O(1). Un cierre sin apertura puede terminar el recorrido anticipadamente.

#### Prompt generado por el agente analista

~~~markdown
Implementar en Java un verificador que determine si los paréntesis `(` y `)` de una expresión están correctamente balanceados, utilizando una pila enlazada construida desde cero.

**Estructura y justificación:** utilizar una pila de caracteres implementada mediante nodos, con `head` como tope. La pila es adecuada porque el último paréntesis abierto debe ser el primero en cerrarse (LIFO).

**Clases:**

- `Ejercicio7`: clase pública con `main` y método `static boolean estanBalanceados(String expresion)`.
- `Nodo`: almacena un `char` y una referencia al siguiente nodo.
- `PilaCaracteres`: administra `head` e implementa `push(char)`, `pop()` e `isEmpty()`.

Implementar las clases auxiliares como estáticas anidadas dentro de `Ejercicio7`.

**Algoritmo:**

1. Validar que la expresión no sea `null`; lanzar `IllegalArgumentException` si lo es.
2. Recorrer sus caracteres de izquierda a derecha.
3. Si aparece `(`, apilarlo mediante `push`.
4. Si aparece `)`, verificar si la pila está vacía. Si está vacía, devolver `false`; si no, retirar una apertura con `pop`.
5. Ignorar letras, números, espacios y operadores, porque solamente se evalúan paréntesis.
6. Al finalizar, devolver `true` únicamente si la pila está vacía.

**Manejo de referencias:** implementar `push` y `pop` modificando exclusivamente `head`, en O(1), sin recorrer ni copiar la pila. Mantener todos los nodos correctamente enlazados durante el proceso, sin ciclos ni pérdidas.

**Casos especiales:** expresión vacía (balanceada), expresión sin paréntesis (balanceada), paréntesis anidados, varios grupos separados, cierres sin apertura, aperturas sin cierre y expresiones mal ordenadas. Una expresión inválida no debe producir una extracción sobre una pila vacía.

**Complejidad:** O(n) de tiempo para una expresión de n caracteres y O(n) de espacio auxiliar en el peor caso por los nodos de apertura almacenados. Cada `push`, `pop` e `isEmpty` cuesta O(1).

**Ejemplos y pruebas:**

- `(2 + 3) * (5 - 1)` → `true`.
- `((a + b) * c)` → `true`.
- `(2 + 3` → `false`.
- `())(` → `false`.
- `)(` → `false`.
- `()` y `(()())` → `true`.
- `(()` y `())` → `false`.
- `""` y `"a + b"` → `true`.

Incluir pruebas adicionales con expresiones largas, aperturas consecutivas, cierres consecutivos, `null` y caracteres no relacionados con paréntesis.

**Restricciones:** implementar manualmente la pila enlazada, sin `Stack`, `Deque`, `LinkedList`, arreglos auxiliares ni otras colecciones para administrar los paréntesis. No usar recursividad ni depender de otros ejercicios. No modificar archivos anteriores ni realizar commits o push.

Compilar individualmente y conjuntamente con los ejercicios 1 al 6 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 7 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 34 casos aprobados, 0 fallidos; 43 verificaciones aprobadas, 0 fallidas.

| Expresión principal | Resultado |
|---|---|
| `(2 + 3) * (5 - 1)` | `true` |
| `((a + b) * c)` | `true` |
| `(2 + 3` | `false` |
| `())(` | `false` |
| `)(` | `false` |
| `()` | `true` |
| `(()())` | `true` |
| `(()` | `false` |
| `())` | `false` |
| Cadena vacía | `true` |
| `a + b` | `true` |

Se comprobaron 24 expresiones, rechazo de `null` y nueve casos sobre la pila auxiliar (estado inicial, extracción inválida, tres inserciones, tres retiros y reutilización). Las expresiones adicionales incluyeron caracteres ajenos, paréntesis aislados, aperturas y cierres consecutivos, grupos separados, 100 000 niveles de anidamiento, una apertura sin cierre y 100 000 pares consecutivos. La expresión más larga tuvo 200 001 caracteres.

`([)]` devolvió `true` porque solo se consideran los paréntesis redondos. Las entradas inválidas con cierres prematuros devolvieron `false` sin extraer de una pila vacía. Se verificaron identidad de los enlaces durante inserciones/retiros, terminación en `null` y reutilización de la pila después de vaciarla. No se usó recursividad.

Los arreglos de casos pertenecen exclusivamente a las pruebas y ejemplos, no al almacenamiento de paréntesis. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 8 — Invertir una palabra con pila enlazada

**Estrategia y justificación:** apilar los caracteres de izquierda a derecha y desapilarlos para construir el resultado con `StringBuilder`. LIFO devuelve primero el último carácter ingresado, invirtiendo el orden.

**Clases y operaciones:** `Ejercicio8` contiene `invertirPalabra(String palabra)`, el `main` y las clases estáticas anidadas `Nodo` y `PilaCaracteres`, con atributos privados. La pila implementa `push(char)`, `pop()` e `isEmpty()`, sin colecciones, arreglos auxiliares ni recursividad.

**Manejo de referencias:** `push` conecta `nuevo.siguiente = head` antes de actualizar `head = nuevo`. `pop` guarda el dato y avanza `head = head.siguiente`. Ambas operaciones cuestan O(1). El resultado se construye hasta que la pila queda vacía.

**Casos especiales y complejidad:** se conservan espacios, signos, números y capitalización. Cadena vacía produce cadena vacía; `null` genera `IllegalArgumentException`. Se invierten unidades `char` de Java, sin tratamiento adicional de Unicode compuesto. Tiempo O(n) y espacio auxiliar O(n) por los nodos y el resultado; operaciones individuales de la pila O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementar en Java un programa que invierta una palabra utilizando una pila enlazada de caracteres, construida manualmente mediante nodos.

**Estructura y justificación:** utilizar una pila LIFO, ya que el último carácter ingresado debe ser el primero en salir. Apilar los caracteres de izquierda a derecha y desapilarlos permite obtener la palabra en orden inverso.

**Clases:**

- `Ejercicio8`: clase pública con `main` y método `static String invertirPalabra(String palabra)`.
- `Nodo`: almacena un `char` y una referencia al siguiente nodo.
- `PilaCaracteres`: administra `head` e implementa `push(char)`, `pop()` e `isEmpty()`.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio8`.

**Algoritmo:**

1. Validar que `palabra` no sea `null`; si lo es, lanzar `IllegalArgumentException`.
2. Recorrer la cadena de izquierda a derecha y ejecutar `push()` con cada carácter.
3. Crear un `StringBuilder` para formar el resultado.
4. Mientras la pila no esté vacía, ejecutar `pop()` y agregar el carácter retirado al resultado.
5. Devolver la cadena invertida.

**Manejo de referencias:** `push()` inserta un nodo al inicio mediante `nuevo.siguiente = head` y `head = nuevo`. `pop()` retira el tope avanzando `head = head.siguiente`. Ambas operaciones deben ser O(1), sin recorrer la pila.

**Casos especiales:** cadena vacía, un solo carácter, caracteres repetidos, palíndromos, números, mayúsculas y minúsculas. Conservar todos los caracteres, incluidos espacios y signos, si aparecen en la entrada. Aclarar que se invierten unidades `char` de Java; no implementar tratamiento adicional de caracteres Unicode compuestos, que excede la consigna.

**Complejidad:** O(n) de tiempo y O(n) de espacio auxiliar para una cadena de longitud n, por los nodos y el resultado construido. Cada `push`, `pop` e `isEmpty` cuesta O(1).

**Ejemplos y pruebas:**

- `"algoritmo"` → `"omtirogla"`.
- `"HOLA"` → `"ALOH"`.
- `"ana"` → `"ana"`.
- `"a"` → `"a"`.
- `""` → `""`.
- `"12345"` → `"54321"`.
- `"a b"` → `"b a"`.
- `null` → `IllegalArgumentException`.

Verificar que invertir dos veces restaura la cadena original para los ejemplos compatibles con `char`, que no se pierden caracteres y que la pila queda vacía después de construir el resultado.

**Restricciones:** implementar manualmente la pila mediante nodos, sin `Stack`, `Deque`, `LinkedList`, arreglos auxiliares ni otras colecciones. No utilizar `StringBuilder.reverse()`, `Collections.reverse()`, recursividad ni recorrer la palabra directamente desde el final para resolver la inversión. No depender de otros ejercicios ni modificar archivos anteriores.

Compilar individualmente y conjuntamente con los ejercicios 1 al 7 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No realizar commits ni push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 8 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 17 casos aprobados, 0 fallidos; 89 verificaciones aprobadas, 0 fallidas.

| Original | Invertida |
|---|---|
| `algoritmo` | `omtirogla` |
| `HOLA` | `ALOH` |
| `ana` | `ana` |
| `a` | `a` |
| Cadena vacía | Cadena vacía |
| `12345` | `54321` |
| `a b` | `b a` |

Se comprobaron catorce cadenas, incluyendo repetidos, capitalización mixta, espacios, signos, letras acentuadas representables por `char`, tabulación/salto de línea y una cadena de 100 000 caracteres. En cada una se verificaron resultado exacto, longitud y restauración mediante doble inversión. `null` produjo `IllegalArgumentException`; también se probaron extracción inválida de la pila auxiliar y reutilización posterior.

La prueba temporal apiló y desapiló cada entrada mediante `PilaCaracteres`, comparó el resultado con el verificador y comprobó `isEmpty()` y `head == null` al finalizar. La revisión de `invertirPalabra` confirmó que usa ese mismo recorrido hasta vaciar la pila antes de devolver el resultado. No se utiliza inversión predefinida ni recorrido de entrada desde el final.

Los arreglos de ejemplos y expectativas pertenecen a la demostración y las pruebas, no al almacenamiento de caracteres de la pila. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 9 — Cola de impresión

**Estrategia y justificación:** almacenar trabajos en una cola enlazada FIFO con `head` al primero pendiente y `tail` al último recibido. Esto permite procesarlos por llegada e insertar sin recorrer la fila.

**Clases y operaciones:** `Ejercicio9` contiene las clases estáticas anidadas `TrabajoImpresion`, `Nodo` y `ColaImpresion`, con atributos privados. El trabajo conserva archivo, páginas y usuario, con getters y representación textual. La cola implementa `agregarTrabajo`, `imprimirProximo`, `consultarProximo`, `mostrarPendientes` y `estaVacia`, sin depender de otros ejercicios. Procesar solo muestra un mensaje y devuelve el trabajo: no realiza impresión física.

**Manejo de referencias:** el primer ingreso establece ambas referencias en el nuevo nodo. Los demás conectan desde `tail` antes de actualizarlo. Procesar avanza `head` y, si queda vacío, también asigna `tail = null`. El último nodo siempre apunta a `null`.

**Validaciones, casos especiales y complejidad:** trabajos nulos, archivos o usuarios nulos/vacíos/de espacios y páginas no positivas producen `IllegalArgumentException` sin cambios. Consultar o procesar sin trabajos produce `IllegalStateException`. Se permiten archivos repetidos y reinserción. Inserción física, retiro, consulta y vacío O(1); validar cadenas O(L) en el peor caso, siendo L la suma de sus longitudes. Mostrar pendientes recorre O(n) nodos; representar y emitir mensajes añade el costo de sus textos. Espacio auxiliar O(1), sin contar el nodo creado, y almacenamiento O(n). El tiempo real de impresión no se simula ni forma parte del costo estructural de la cola.

#### Prompt generado por el agente analista

~~~markdown
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
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original permanece literal y esto se indica al final del Java. Se explicitan validación segura de textos y su costo, separado de la inserción física O(1).

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 9 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 338 casos aprobados, 0 fallidos; 2109 verificaciones aprobadas, 0 fallidas. Los casos incluyen estados y operaciones individuales de cien rondas alternadas, no 338 escenarios independientes.

| Orden de procesamiento principal | Archivo | Páginas | Usuario |
|---|---|---:|---|
| 1 | Informe.pdf | 5 | Ana |
| 2 | Apuntes.docx | 12 | Luis |
| 3 | Factura.pdf | 2 | Marta |

La consulta devolvió Informe.pdf sin retirarlo. Los tres trabajos se procesaron en orden FIFO conservando sus objetos y datos. Al vaciarse, `head` y `tail` quedaron nulos. Agregar Nuevo.pdf (1 página, Pedro) funcionó correctamente.

Se probaron cola vacía y unitaria, diez entradas inválidas, consultas sin cambios, archivos repetidos, repetición del mismo objeto, cien rondas alternadas y páginas desde 1 hasta `Integer.MAX_VALUE`. Se verificaron los mensajes exactos de procesamiento, identidad de trabajos, datos y enlaces de nodos, coherencia de extremos, terminación en `null`, ausencia de ciclos, consultas e impresión sin cambios y rechazo de operaciones vacías.

Los arreglos de expectativas pertenecen exclusivamente a las pruebas; la cola almacena solo nodos enlazados. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 10 — Lista doblemente enlazada genérica

**Estrategia y justificación:** almacenar datos genéricos en nodos con referencias `anterior` y `siguiente`, manteniendo `head` y `tail`. Permite insertar en ambos extremos en O(1) y recorrer en ambos sentidos, a cambio de administrar una referencia adicional por nodo.

**Clases y operaciones:** `Ejercicio10` contiene las clases estáticas anidadas `Nodo<T>` y `ListaDoble<T>`, con atributos privados. La lista implementa `insertarAlInicio`, `insertarAlFinal`, `eliminar`, `imprimirAdelante`, `imprimirAtras`, `estaVacia` y `getSize`. Las comparaciones utilizan `Objects.equals`, admitiendo datos nulos y la semántica de igualdad del tipo almacenado.

**Manejo de referencias:** insertar enlaza el nuevo nodo con el extremo anterior en ambos sentidos y actualiza el extremo correspondiente; si estaba vacía, también el opuesto. Eliminar conecta ambos vecinos; si falta un vecino, actualiza `head` o `tail`. Así, el nuevo primero tiene anterior nulo y el último siguiente nulo. Retirar el único nodo deja ambos extremos nulos. Se elimina solo la primera coincidencia y se decrementa `size` una vez, sin copiar nodos ni alterar los datos conservados.

**Casos especiales y complejidad:** lista vacía, nodo único, duplicados, nulos, eliminación inicial/intermedia/final y dato ausente. Una eliminación fallida conserva la estructura. Inserciones O(1); búsqueda y eliminación por valor O(n) en el peor caso suponiendo igualdad de costo constante, con desvinculación O(1). Recorridos O(n), además del costo de representar y emitir los datos; consultas de vacío y tamaño O(1). Espacio auxiliar O(1), sin contar el nodo creado, y almacenamiento O(n). El costo de igualdad depende del tipo T.

#### Prompt generado por el agente analista

~~~markdown
Implementar desde cero una lista doblemente enlazada genérica en Java, que permita insertar elementos al inicio y al final, eliminar un elemento y recorrer la lista en ambas direcciones.

**Estructura y justificación:** utilizar una lista doblemente enlazada con nodos `Nodo<T>`, donde cada nodo almacena un dato de tipo `T` y dos referencias: `anterior` y `siguiente`. Mantener `head` al primer nodo y `tail` al último. Esta estructura permite recorrer la lista hacia adelante y atrás e insertar en ambos extremos en O(1), a cambio de almacenar y actualizar más referencias que una lista simple.

**Clases:**
- `Ejercicio10`: clase pública con método `main`.
- `Nodo<T>`: atributos privados `T dato`, `Nodo<T> anterior` y `Nodo<T> siguiente`.
- `ListaDoble<T>`: referencias privadas `Nodo<T> head` y `Nodo<T> tail`, y contador `int size`.

Implementar las clases auxiliares como estáticas anidadas dentro de `Ejercicio10`, sin conflictos con otros ejercicios.

**Operaciones:**
- `void insertarAlInicio(T dato)`: crear un nodo, conectarlo al antiguo `head` en ambos sentidos y actualizar `head`. Si la lista estaba vacía, actualizar también `tail`.
- `void insertarAlFinal(T dato)`: crear un nodo, conectarlo al antiguo `tail` en ambos sentidos y actualizar `tail`. Si estaba vacía, actualizar también `head`.
- `boolean eliminar(T dato)`: buscar desde `head` y eliminar solamente la primera coincidencia, comparando mediante `Objects.equals()`. Devolver `true` si se eliminó y `false` si no se encontró.
- `void imprimirAdelante()`: recorrer desde `head` siguiendo `siguiente` hasta `null`.
- `void imprimirAtras()`: recorrer desde `tail` siguiendo `anterior` hasta `null`.
- `boolean estaVacia()` y `int getSize()`: consultar el estado sin recorrer la lista.

**Manejo de referencias:** al eliminar un nodo intermedio, conectar su vecino anterior con su vecino siguiente y actualizar ambos enlaces. Al eliminar `head`, actualizar el nuevo `head.anterior = null`; al eliminar `tail`, actualizar el nuevo `tail.siguiente = null`. Al eliminar el único nodo, establecer ambas referencias en `null`.

Mantener siempre:
- `head == null` si y solo si `tail == null` y `size == 0`.
- En listas no vacías, `head.anterior == null` y `tail.siguiente == null`.
- Los recorridos hacia adelante y atrás deben visitar exactamente los mismos nodos en orden inverso.
- `size` debe coincidir con la cantidad real de nodos.
- No generar ciclos, referencias inconsistentes ni nodos inaccesibles.

**Casos especiales:** lista vacía, nodo único, inserciones en ambos extremos, eliminación del primer nodo, último nodo e intermedio, dato inexistente, valores duplicados y elementos `null`. Permitir `null` como dato y utilizar `Objects.equals()` para comparar de forma segura. Eliminar solamente la primera aparición. Las eliminaciones fallidas no deben modificar la lista.

**Complejidad:** insertar al inicio y al final: O(1). Buscar y eliminar por valor: O(n) en el peor caso; una vez encontrado, desvincular un nodo cuesta O(1). Imprimir hacia adelante o atrás: O(n). Consultar vacío y tamaño: O(1). Espacio auxiliar por operación: O(1); almacenamiento total: O(n).

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar 20 y 30 al final, y 10 al inicio.
3. Verificar recorrido hacia adelante: `10 <-> 20 <-> 30`.
4. Verificar recorrido hacia atrás: `30 <-> 20 <-> 10`.
5. Eliminar 20 y comprobar ambos recorridos: `10 <-> 30` y `30 <-> 10`.
6. Eliminar 10 y luego 30, comprobando `head == null`, `tail == null` y `size == 0`.
7. Insertar nuevamente un elemento y verificar que la lista sigue funcionando.

**Pruebas adicionales:** usar `Integer`, `String` y objetos propios sencillos; verificar genéricos, duplicados, datos `null`, eliminaciones fallidas, eliminación del primer duplicado, operaciones sobre lista vacía y actualizaciones de `head`, `tail`, `anterior`, `siguiente` y `size`. Confirmar que los nodos conservados mantienen sus identidades y datos originales. Probar listas extensas y recorridos en ambos sentidos sin ciclos.

**Restricciones:** implementar los nodos y enlaces manualmente, sin utilizar `LinkedList`, `ArrayList`, `List`, `Deque`, arreglos ni colecciones predefinidas como almacenamiento de la lista. No usar tipos raw, recursividad ni copiar los nodos para simular eliminaciones. No depender de clases de otros ejercicios.

Compilar individualmente y conjuntamente con los ejercicios 1 al 9 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No modificar archivos anteriores ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Compilación individual y conjunta de los ejercicios 1 al 10 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente: 1208 casos aprobados, 0 fallidos; 709 337 verificaciones aprobadas, 0 fallidas. Los casos incluyen operaciones individuales y estados comprobados, no 1208 escenarios independientes.

| Estado del ejemplo | Adelante | Atrás | size |
|---|---|---|---:|
| Insertar 20 y 30 al final, 10 al inicio | `10 <-> 20 <-> 30` | `30 <-> 20 <-> 10` | 3 |
| Eliminar 20 | `10 <-> 30` | `30 <-> 10` | 2 |
| Eliminar 10 | `30` | `30` | 1 |
| Eliminar 30 | Vacío | Vacío | 0 |
| Reinsertar 40 | `40` | `40` | 1 |

Al vaciarse, `head` y `tail` quedaron nulos. Las eliminaciones devolvieron `true` y la reinserción funcionó.

Se probaron Integer (negativos, cero, extremos y duplicados), String (vacías y objetos distintos con igual contenido) y objetos propios Persona con igualdad lógica, además de elementos nulos. Por tipo se ejecutaron 300 operaciones reproducibles (semilla 2026), comparadas con un modelo externo, seguidas de vaciado y reinserción. Se verificó que las eliminaciones retiraran la primera coincidencia por identidad y conservaran los nodos restantes.

Una lista extensa de 10 000 nodos se recorrió en ambos sentidos, verificando su salida completa y la eliminación de un nodo intermedio. Las pruebas inspeccionaron cada enlace anterior/siguiente, identidades y datos, tamaño y extremos, comprobando igualdad de los nodos recorridos en orden inverso, terminación en `null`, ausencia de ciclos, referencias coherentes e impresión sin modificaciones. Las colecciones del modelo pertenecen exclusivamente a la prueba temporal, no al almacenamiento de la lista.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.
