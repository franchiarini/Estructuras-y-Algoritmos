# TP3 — Ordenamiento

### Metodología de trabajo

ChatGPT actúa como agente analista: estudia las consignas, elige las estrategias, analiza la complejidad y elabora los prompts. Codex actúa como agente desarrollador: implementa los algoritmos en Java, ejecuta las pruebas y documenta los resultados.

Los prompts académicos se conservan literalmente en este README y al comienzo de cada archivo Java.

### Ejercicio 1 — Ordenamiento Burbuja paso a paso

**Estrategia:** Bubble Sort tradicional mediante dos ciclos `for` anidados, comparando vecinos e intercambiándolos cuando están en orden incorrecto. El límite interno disminuye después de cada pasada y se muestra el arreglo completo, sin finalización anticipada.

**Justificación:** Los intercambios desplazan los valores mayores hacia el final. Cada pasada ubica el mayor elemento pendiente en su posición definitiva.

**Complejidad:**

- Mejor caso: Θ(n²).
- Peor caso: Θ(n²).
- Caso promedio: Θ(n²).
- Espacio auxiliar: O(1).

La impresión de todas las pasadas también requiere tiempo cuadrático total para arreglos de longitud n.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el algoritmo Bubble Sort para ordenar un arreglo de números enteros de menor a mayor, mostrando cómo evoluciona el arreglo después de cada pasada.

**Estrategia:** utilizar dos ciclos `for` anidados. El ciclo externo controla las pasadas y el interno compara elementos vecinos, intercambiándolos cuando el primero es mayor que el segundo. Reducir el límite interno después de cada pasada porque los últimos elementos ya estarán ordenados.

**Justificación:** Bubble Sort desplaza progresivamente los elementos mayores hacia el final del arreglo. Después de cada pasada, el mayor elemento de la parte pendiente queda ubicado en su posición definitiva.

**Complejidad:**

- Mejor caso: Θ(n²).
- Peor caso: Θ(n²).
- Caso promedio: Θ(n²).
- Espacio auxiliar: O(1).

Se utilizará la versión tradicional sin finalización anticipada, para mostrar todas las pasadas del algoritmo.

**Requisitos:**

- Crear `Ejercicio1.java` dentro de `TP3-Ordenamiento/src`, verificando primero la estructura real del proyecto.
- Implementar Bubble Sort manualmente mediante dos ciclos `for` anidados.
- Ordenar los números de menor a mayor.
- Mostrar el arreglo original antes del ordenamiento.
- Mostrar el estado completo del arreglo después de cada pasada del ciclo externo, indicando el número de pasada.
- Incorporar comentarios que expliquen las comparaciones, los intercambios y por qué el elemento mayor se desplaza hacia el final.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Implementar un método `bubbleSort(int[] arreglo)`.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{5, 3, 8, 2}`.
- Verificar que las pasadas del ejemplo produzcan `{3, 5, 2, 8}`, `{3, 2, 5, 8}` y `{2, 3, 5, 8}`.
- Probar arreglos ordenados, inversamente ordenados, con números negativos, repetidos, vacíos y de un único elemento.
- Manejar explícitamente arreglos nulos.
- Verificar que el arreglo final esté correctamente ordenado.
- Compilar y ejecutar con Java 21, informando los resultados de las pruebas.

No modificar ejercicios anteriores ni realizar commits o push.
~~~

#### Resultado

Se implementó `bubbleSort(int[] arreglo)` en `Ejercicio1.java`, ordenando sobre el propio arreglo. Muestra el original, todas las pasadas numeradas y el resultado final. Los arreglos nulos lanzan `IllegalArgumentException`; los vacíos y unitarios no realizan pasadas. El comentario inicial conserva el prompt literal, sin modificaciones.

Se ejecutaron 11 pruebas: ejemplo principal, arreglo ordenado, orden inverso, negativos, repetidos, vacío, un elemento, extremos de `int`, dos elementos, todos iguales y arreglo nulo.

Se verificaron el orden final y la cantidad y numeración de las pasadas. La traza completa del ejemplo principal coincidió exactamente con:

~~~text
Arreglo original: {5, 3, 8, 2}
Pasada 1: {3, 5, 2, 8}
Pasada 2: {3, 2, 5, 8}
Pasada 3: {2, 3, 5, 8}
Arreglo ordenado: {2, 3, 5, 8}
~~~

También se verificó que el arreglo ya ordenado `{1, 2, 3, 4}` muestra sus tres pasadas sin cambios, confirmando la ausencia de finalización anticipada. Todas las pruebas fueron correctas y se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 2 — Comparación entre Burbuja y Selección

**Estrategia:** Bubble Sort compara e intercambia vecinos, reduciendo el límite interno sin finalización anticipada. Selection Sort busca el mínimo de la parte pendiente y lo intercambia con la posición actual solo si sus índices son diferentes.

**Justificación:** Burbuja desplaza valores mediante intercambios vecinos; Selección busca primero el mínimo y luego lo ubica. Aunque ambos tienen costo temporal cuadrático, sus cantidades de intercambios pueden diferir.

**Complejidad:**

- Bubble Sort: mejor, peor y caso promedio Θ(n²), espacio auxiliar O(1).
- Selection Sort: mejor, peor y caso promedio Θ(n²), espacio auxiliar O(1).
- Selection Sort realiza como máximo n - 1 intercambios para n >= 1, mientras que Bubble Sort puede realizar O(n²).
- Las copias independientes utilizadas para comparar ambos algoritmos en el main requieren O(n) de memoria adicional, fuera del espacio auxiliar de cada ordenamiento.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java dos algoritmos de ordenamiento para comparar Bubble Sort y Selection Sort utilizando el mismo arreglo de números enteros.

**Estrategia A — Bubble Sort:** recorrer el arreglo mediante dos ciclos `for` anidados, comparar elementos vecinos e intercambiarlos cuando estén desordenados. Reducir el límite interno después de cada pasada, sin incorporar finalización anticipada.

**Estrategia B — Selection Sort:** recorrer el arreglo buscando el elemento mínimo de la parte desordenada y colocarlo en su posición definitiva mediante un intercambio. Realizar el intercambio solamente si el mínimo está en una posición diferente de la actual.

**Justificación:** Bubble Sort realiza intercambios entre elementos vecinos, mientras que Selection Sort primero busca el mínimo y después lo coloca en la posición correspondiente. Comparar sus operaciones permite observar que dos algoritmos con complejidad temporal cuadrática pueden realizar diferentes cantidades de intercambios.

**Complejidad:**

- Bubble Sort: mejor, peor y caso promedio Θ(n²), espacio auxiliar O(1).
- Selection Sort: mejor, peor y caso promedio Θ(n²), espacio auxiliar O(1).
- Explicar que Selection Sort realiza como máximo n - 1 intercambios, mientras que Bubble Sort puede realizar O(n²).

**Requisitos:**

- Crear `Ejercicio2.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar los métodos `bubbleSort(int[] array)` y `selectionSort(int[] array)`.
- Ordenar los arreglos de menor a mayor.
- Implementar ambos algoritmos manualmente, sin `Arrays.sort()` ni otros métodos predefinidos de ordenamiento.
- Contabilizar por separado comparaciones entre elementos e intercambios reales de cada algoritmo.
- Considerar comparación cada vez que se comparan dos valores del arreglo, sin contar condiciones de control de los ciclos.
- Considerar intercambio solamente cuando se modifican efectivamente las posiciones de dos elementos; no contar intercambios consigo mismo.
- Utilizar copias independientes del mismo arreglo original para que ambos algoritmos reciban exactamente los mismos datos.
- Mostrar el arreglo original, el resultado de cada algoritmo y los contadores correspondientes.
- Incorporar comentarios explicando la estrategia de cada algoritmo y las diferencias entre ambos.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{5, 3, 8, 2}` y verificar que Bubble Sort realice 6 comparaciones y 4 intercambios, mientras que Selection Sort realice 6 comparaciones y 2 intercambios.
- Probar arreglos ordenados, inversamente ordenados, con elementos repetidos, negativos, vacíos y de un solo elemento.
- Manejar entradas nulas explícitamente.
- Verificar que ambos algoritmos produzcan exactamente el mismo arreglo ordenado.
- Compilar y ejecutar con Java 21, informando los resultados de las pruebas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementaron `bubbleSort(int[] array)` y `selectionSort(int[] array)` con contadores `long` separados para comparaciones entre valores e intercambios reales. No se cuentan controles de ciclos ni intercambios consigo mismo. El main usa copias independientes y muestra el original, ambos resultados y sus contadores. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 12 pruebas: diez arreglos y el rechazo de nulos en cada algoritmo. Ambos produjeron exactamente el orden esperado, conservaron el arreglo original usado como fuente y mostraron estos contadores verificados:

| Arreglo original | Comparaciones Bubble | Intercambios Bubble | Comparaciones Selection | Intercambios Selection |
|---|---:|---:|---:|---:|
| `{5, 3, 8, 2}` | 6 | 4 | 6 | 2 |
| `{1, 2, 3, 4}` | 6 | 0 | 6 | 0 |
| `{4, 3, 2, 1}` | 6 | 6 | 6 | 2 |
| `{3, 1, 3, 1}` | 6 | 3 | 6 | 2 |
| `{-1, -5, 0, -3}` | 6 | 3 | 6 | 3 |
| `{}` | 0 | 0 | 0 | 0 |
| `{7}` | 0 | 0 | 0 | 0 |
| `{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}` | 3 | 3 | 3 | 1 |
| `{2, 1}` | 1 | 1 | 1 | 1 |
| `{5, 5, 5}` | 3 | 0 | 3 | 0 |

Ambos métodos lanzaron `IllegalArgumentException` ante `null`. También se ejecutaron correctamente los ejemplos del main. Se corrigió un valor esperado erróneo en la prueba temporal de negativos: Selection Sort realiza tres intercambios en ese caso, como se confirmó revisando sus pasadas.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin pendientes.


### Ejercicio 3 — Insertion Sort con arreglo casi ordenado

**Estrategia:** Recorrer desde la segunda posición con un `for`, guardar el valor actual y desplazar hacia la derecha con un `while` los elementos mayores de la parte izquierda ordenada. Insertar luego el valor en su posición correcta.

**Justificación:** Cuando el arreglo está casi ordenado, los elementos requieren pocos desplazamientos. Los que ya están en su posición no provocan movimientos dentro del ciclo interno.

**Complejidad:**

- Mejor caso: Θ(n), con el arreglo ordenado.
- Peor caso: Θ(n²), con orden inverso.
- Caso promedio: Θ(n²), para distribución aleatoria.
- Espacio auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el algoritmo Insertion Sort para ordenar un arreglo de números enteros que se encuentra casi ordenado.

**Estrategia:** recorrer el arreglo desde la segunda posición, tomando cada elemento como valor a insertar dentro de la parte izquierda, que ya se encuentra ordenada. Desplazar una posición hacia la derecha los elementos mayores que el valor actual y colocarlo en su posición correcta.

**Justificación:** Insertion Sort es especialmente eficiente cuando los datos están casi ordenados porque cada elemento necesita pocos desplazamientos para alcanzar su posición definitiva. A diferencia de otros algoritmos, no necesita reorganizar constantemente todo el arreglo.

**Complejidad:**

- Mejor caso: Θ(n), cuando el arreglo ya está ordenado.
- Peor caso: Θ(n²), cuando está ordenado en sentido inverso.
- Caso promedio: Θ(n²), para arreglos con distribución aleatoria.
- Espacio auxiliar: O(1).

**Requisitos:**

- Crear `Ejercicio3.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `insertionSort(int[] array)` utilizando un ciclo `for` externo y un ciclo `while` interno.
- Ordenar los elementos de menor a mayor.
- Utilizar una variable temporal para almacenar el elemento que se desea insertar.
- Desplazar los elementos mayores hacia la derecha hasta encontrar la posición correcta.
- Contabilizar la cantidad de desplazamientos realizados.
- Considerar como desplazamiento cada movimiento de un elemento hacia la derecha dentro del ciclo interno.
- No contabilizar como desplazamiento la escritura final del elemento que se está insertando.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Mostrar el arreglo original, el arreglo ordenado y la cantidad total de desplazamientos.
- Incorporar comentarios que expliquen la estrategia, la parte ordenada del arreglo y la contabilización de desplazamientos.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{1, 2, 3, 5, 4, 6, 7}` y verificar que el resultado sea `{1, 2, 3, 4, 5, 6, 7}` con exactamente un desplazamiento.
- Probar también arreglos completamente ordenados, inversamente ordenados, con números repetidos, negativos, vacíos y de un único elemento.
- Manejar arreglos nulos explícitamente mediante `IllegalArgumentException`.
- Verificar que todos los elementos se conserven después del ordenamiento.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `insertionSort(int[] array)` con un contador `long`. Se cuenta únicamente cada movimiento hacia la derecha dentro del `while`; la escritura final del valor temporal no se contabiliza. El main muestra el original, el ordenado y el contador. Los arreglos nulos lanzan `IllegalArgumentException`. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 11 pruebas:

| Arreglo original | Desplazamientos |
|---|---:|
| `{1, 2, 3, 5, 4, 6, 7}` | 1 |
| `{1, 2, 3, 4}` | 0 |
| `{4, 3, 2, 1}` | 6 |
| `{3, 1, 3, 1}` | 3 |
| `{-1, -5, 0, -3}` | 3 |
| `{}` | 0 |
| `{7}` | 0 |
| `{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}` | 3 |
| `{2, 1}` | 1 |
| `{5, 5, 5}` | 0 |

El ejemplo principal produjo exactamente `{1, 2, 3, 4, 5, 6, 7}` con un desplazamiento. Se verificaron el orden final, los contadores exactos y la conservación de todos los valores y sus repeticiones. La entrada `null` lanzó `IllegalArgumentException`. Todas las pruebas fueron correctas y también se ejecutaron los ejemplos del main.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 4 — Ordenamiento de nombres con Selection Sort

**Estrategia:** Buscar mediante dos ciclos `for` el nombre lexicográficamente menor de la parte pendiente y colocarlo en la posición actual, intercambiando solo cuando los índices sean diferentes.

**Justificación:** La estrategia de selección se mantiene, pero las cadenas se comparan por contenido usando `String.compareTo()` en lugar de operadores numéricos. Se sigue el orden lexicográfico de Java.

**Complejidad:**

- Mejor caso: Θ(n²) comparaciones de cadenas.
- Peor caso: Θ(n²) comparaciones de cadenas.
- Caso promedio: Θ(n²) comparaciones de cadenas.
- Espacio auxiliar: O(1).
- El costo individual de `compareTo()` depende de la longitud de las cadenas y del prefijo compartido. La validación previa de nulos recorre el arreglo en O(n).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el algoritmo Selection Sort para ordenar alfabéticamente un arreglo de nombres representados mediante String.

**Estrategia:** recorrer el arreglo mediante dos ciclos `for` anidados. En cada pasada, buscar el nombre alfabéticamente menor dentro de la parte desordenada y colocarlo en la posición correspondiente mediante un intercambio.

**Justificación:** Selection Sort permite ordenar nombres utilizando la misma estrategia que con números, pero cambiando la forma de comparar los elementos. En lugar de operadores numéricos, debemos utilizar `compareTo()` para determinar qué cadena aparece primero alfabéticamente.

**Complejidad:**

- Mejor caso: Θ(n²) comparaciones de cadenas.
- Peor caso: Θ(n²) comparaciones de cadenas.
- Caso promedio: Θ(n²) comparaciones de cadenas.
- Espacio auxiliar: O(1).
- Aclarar que el costo individual de `compareTo()` depende de la longitud de las cadenas comparadas.

**Requisitos:**

- Crear `Ejercicio4.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `selectionSort(String[] nombres)`.
- Utilizar dos ciclos `for` anidados para buscar el nombre alfabéticamente menor en cada pasada.
- Comparar los nombres utilizando `String.compareTo()`.
- Ordenar los nombres de manera ascendente, siguiendo el orden lexicográfico de Java.
- Intercambiar los elementos únicamente cuando el índice del mínimo sea diferente de la posición actual.
- No utilizar `Arrays.sort()`, `Collections.sort()` ni métodos predefinidos de ordenamiento.
- Incorporar comentarios explicando cómo funciona Selection Sort y por qué se utiliza `compareTo()` en lugar de operadores numéricos.
- Incluir un método `main` con ejemplos de funcionamiento.
- Mostrar el arreglo original y el resultado ordenado.
- Utilizar como ejemplo principal `{"Lucia", "Ana", "Pedro", "Juan"}` y verificar que el resultado sea `{"Ana", "Juan", "Lucia", "Pedro"}`.
- Probar también nombres ya ordenados, inversamente ordenados, repetidos, arreglos vacíos y de un solo nombre.
- Utilizar nombres con capitalización consistente para mantener el criterio del ejemplo de la consigna.
- Manejar explícitamente arreglos nulos mediante `IllegalArgumentException`.
- Rechazar elementos String nulos mediante `IllegalArgumentException` antes de comenzar a ordenar, evitando modificaciones parciales.
- Verificar que el ordenamiento conserve todos los nombres originales.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar ejercicios anteriores ni realizar commits o push.
~~~

#### Resultado

Se implementó `selectionSort(String[] nombres)` en `Ejercicio4.java`. Se validan todos los elementos antes de ordenar; un arreglo nulo o cualquier nombre nulo lanza `IllegalArgumentException`, sin modificaciones parciales. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 13 pruebas:

- Ejemplo principal: `{"Lucia", "Ana", "Pedro", "Juan"}` produjo `{"Ana", "Juan", "Lucia", "Pedro"}`.
- Nombres ya ordenados e inversamente ordenados: ambos produjeron el orden anterior.
- Repetidos: `{"Lucia", "Ana", "Lucia", "Ana"}` produjo `{"Ana", "Ana", "Lucia", "Lucia"}`.
- Arreglo vacío y un único nombre: permanecieron sin cambios.
- Prefijos compartidos: `{"Ana", "Anabel", "An"}` produjo `{"An", "Ana", "Anabel"}`.
- Cadena vacía: `{"Beto", ""}` produjo `{"", "Beto"}`.
- Cinco entradas inválidas: arreglo nulo, único elemento nulo y nulos al inicio, en el medio y al final. Todas lanzaron `IllegalArgumentException`; los arreglos con elementos nulos permanecieron intactos.

En los ocho casos válidos se verificó el orden exacto y la conservación de todos los nombres y sus repeticiones. También se ejecutaron los ejemplos del main.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 5 — ShellSort explicando los gaps

**Estrategia:** Inserciones con saltos, comenzando con gap igual a n / 2 y reduciéndolo mediante división entera por 2. Cada etapa ordena elementos separados por el gap, hasta completar una inserción convencional con gap 1.

**Justificación:** Los saltos permiten mover elementos a distancias mayores y acercarlos antes a sus posiciones definitivas, reduciendo los desplazamientos respecto de Insertion Sort en muchos arreglos desordenados.

**Complejidad:**

- Peor caso: O(n²) para la secuencia de gaps elegida.
- Mejor caso y caso promedio: dependen de la distribución de los elementos y de la secuencia de gaps.
- Espacio auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el algoritmo ShellSort para ordenar un arreglo de números enteros de menor a mayor, mostrando cómo cambia el arreglo durante las diferentes etapas de ordenamiento.

**Estrategia:** utilizar ShellSort mediante inserciones con saltos. Comenzar con un gap igual a la mitad de la longitud del arreglo (`n / 2`) y reducirlo mediante división entera por 2 hasta llegar a 1. Para cada gap, aplicar una inserción que compare y desplace elementos separados por esa distancia.

**Justificación:** ShellSort mejora el ordenamiento por inserción porque permite desplazar elementos a distancias mayores durante las primeras etapas, acercándolos más rápidamente a sus posiciones correctas. Cuando el gap llega a 1, se completa el ordenamiento mediante una inserción convencional sobre un arreglo parcialmente ordenado.

**Complejidad:**

- Peor caso: O(n²) para la secuencia de gaps elegida.
- Mejor caso y caso promedio: dependen de la distribución de los elementos y de la secuencia de gaps.
- Espacio auxiliar: O(1), porque el algoritmo ordena el arreglo directamente sin utilizar estructuras auxiliares proporcionales a su tamaño.

**Requisitos:**

- Crear `Ejercicio5.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `shellSort(int[] array)`.
- Utilizar ciclos `for` y un ciclo `while` para realizar las inserciones con saltos.
- Comenzar con `gap = array.length / 2` y reducirlo a la mitad en cada etapa hasta llegar a 1.
- Ordenar los números de menor a mayor.
- Mostrar el arreglo original antes del ordenamiento.
- Mostrar el valor del gap utilizado al comienzo de cada etapa.
- Mostrar el estado completo del arreglo después de finalizar cada pasada correspondiente a un gap.
- Incorporar comentarios que expliquen qué representa el gap, cómo se realizan las comparaciones y desplazamientos, y por qué su reducción permite ordenar progresivamente el arreglo.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal `{8, 5, 3, 7, 6, 2, 4, 1}`.
- Verificar que las etapas del ejemplo produzcan los estados `{6, 2, 3, 1, 8, 5, 4, 7}` con gap 4, `{3, 1, 4, 2, 6, 5, 8, 7}` con gap 2 y `{1, 2, 3, 4, 5, 6, 7, 8}` con gap 1.
- Probar arreglos ordenados, inversamente ordenados, con elementos repetidos, números negativos, vacíos y de un solo elemento.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que el arreglo final esté ordenado y conserve todos sus elementos originales.
- Compilar y ejecutar con Java 21, comprobando los resultados y las trazas de los gaps.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `shellSort(int[] array)` con ciclos for para las etapas y los elementos, y un while para las inserciones con saltos. Muestra el original, el gap al comenzar cada etapa, su estado final y el arreglo ordenado. Los arreglos nulos lanzan `IllegalArgumentException`. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 12 pruebas: ejemplo principal, ordenado, inverso, repetidos, negativos, vacío, unitario, extremos de `int`, dos elementos, todos iguales, longitud impar y arreglo nulo.

La traza completa del ejemplo coincidió exactamente con los estados solicitados:

| Gap | Estado al finalizar la etapa |
|---|---|
| 4 | `{6, 2, 3, 1, 8, 5, 4, 7}` |
| 2 | `{3, 1, 4, 2, 6, 5, 8, 7}` |
| 1 | `{1, 2, 3, 4, 5, 6, 7, 8}` |

Se verificaron el orden final, la conservación de todos los valores y sus repeticiones, y la secuencia y cantidad de etapas de gaps en cada caso válido. Los arreglos vacíos y unitarios no ejecutaron etapas; null fue rechazado correctamente. Todas las pruebas fueron correctas y también se ejecutaron los ejemplos del main.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 6 — Quicksort con primer elemento como pivote

**Estrategia:** Partición dentro del mismo arreglo usando siempre el primer elemento del segmento como pivote, seguida de llamadas recursivas sobre ambos lados sin incluir el pivote.

**Justificación:** Divide y vencerás separa el ordenamiento en segmentos menores que pueden resolverse independientemente. La partición deja valores menores a la izquierda y mayores o iguales a la derecha.

**Caso base:** Un segmento vacío o de un elemento ya está ordenado.

**Caso recursivo:** Particionar y ordenar los intervalos izquierdo y derecho, excluyendo la posición definitiva del pivote para reducir el problema.

**Complejidad:**

- Mejor caso: Θ(n log n), con particiones equilibradas.
- Caso promedio: Θ(n log n), bajo una distribución adecuada de los datos.
- Peor caso: Θ(n²), con particiones muy desbalanceadas.
- Espacio auxiliar: O(log n) en particiones equilibradas y O(n) en el peor caso, por la pila de llamadas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el algoritmo Quicksort para ordenar un arreglo de números enteros de menor a mayor, utilizando siempre el primer elemento de cada subarreglo como pivote.

**Estrategia:** aplicar el paradigma divide y vencerás. Seleccionar el primer elemento del segmento como pivote, particionar el arreglo para ubicar los elementos menores a su izquierda y los mayores o iguales a su derecha, y ordenar recursivamente ambas partes.

**Justificación:** Quicksort permite resolver el ordenamiento dividiendo el arreglo en subproblemas más pequeños. El pivote establece una separación entre elementos menores y mayores, y la recursividad permite ordenar cada segmento de manera independiente.

**Caso base:** cuando el subarreglo contiene cero o un elemento, finalizar la llamada recursiva porque ese segmento ya está ordenado.

**Caso recursivo:** seleccionar el primer elemento como pivote, realizar la partición y llamar nuevamente a Quicksort sobre los segmentos izquierdo y derecho.

**Reducción del problema:** cada llamada recursiva trabaja sobre una porción menor del arreglo, excluyendo el pivote que ya quedó ubicado en su posición definitiva.

**Complejidad:**
- Mejor caso: Θ(n log n), cuando las particiones están equilibradas.
- Caso promedio: Θ(n log n), bajo una distribución adecuada de los datos.
- Peor caso: Θ(n²), cuando las particiones quedan muy desbalanceadas.
- Espacio auxiliar: O(log n) en particiones equilibradas y O(n) en el peor caso, debido a la pila de llamadas.

**Requisitos:**
- Crear `Ejercicio6.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `quickSort(int[] array)` y los métodos auxiliares necesarios para la recursividad y la partición.
- Utilizar siempre el primer elemento del segmento actual como pivote, incluso durante las llamadas recursivas.
- Implementar manualmente la partición utilizando intercambios dentro del mismo arreglo, sin crear arreglos auxiliares para cada subarreglo.
- Utilizar un esquema de partición consistente que garantice que el pivote quede en su posición definitiva y que las llamadas recursivas reduzcan el tamaño del problema.
- Ordenar de menor a mayor.
- Mostrar el arreglo original.
- En cada partición, mostrar el pivote elegido, los elementos del segmento izquierdo y los del segmento derecho después de particionar.
- Indicar visualmente mediante mensajes qué segmentos se procesan recursivamente y cuál es el caso base.
- Mostrar el arreglo final ordenado.
- Incorporar comentarios que expliquen el pivote, la partición, el caso base, el caso recursivo y el paradigma divide y vencerás.
- No utilizar `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Incluir un método `main` con ejemplos.
- Utilizar como ejemplo principal `{5, 3, 8, 2, 7, 1}` y comprobar que el resultado final sea `{1, 2, 3, 5, 7, 8}`.
- Probar arreglos ordenados, inversamente ordenados, con valores repetidos, negativos, vacíos, unitarios y extremos de `int`.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que todos los elementos originales se conserven y que el arreglo final esté correctamente ordenado.
- Compilar y ejecutar con Java 21, verificando los resultados y las trazas de partición.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementaron `quickSort(int[] array)` y auxiliares recursivos, de partición, intercambio y visualización. El ordenamiento se realiza sobre el arreglo original, sin arreglos auxiliares por segmento. Los nulos lanzan `IllegalArgumentException`. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 11 pruebas: ejemplo principal, ordenado, inverso, repetidos, negativos, vacío, unitario, extremos de `int`, todos iguales, dos elementos y nulo. Se verificaron el orden exacto, la conservación de valores y repeticiones, la elección del primer elemento como pivote y las desigualdades de ambos lados en cada partición de las trazas.

Particiones observadas en el ejemplo principal, en orden de ejecución:

| Segmento antes de particionar | Pivote | Izquierda después | Derecha después |
|---|---:|---|---|
| `{5, 3, 8, 2, 7, 1}` | 5 | `{1, 3, 2}` | `{7, 8}` |
| `{1, 3, 2}` | 1 | `{}` | `{3, 2}` |
| `{3, 2}` | 3 | `{2}` | `{}` |
| `{7, 8}` | 7 | `{}` | `{8}` |

El resultado final fue `{1, 2, 3, 5, 7, 8}`. Las trazas indican los segmentos procesados, las llamadas izquierda y derecha y los casos base. También se ejecutaron correctamente los ejemplos del main.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 7 — Peor caso de Quicksort

**Estrategia:** Quicksort in-place con el primer elemento como pivote, contando cada entrada al auxiliar recursivo, incluida la inicial y los casos base. Se compara un arreglo ordenado con otros órdenes de entrada.

**Justificación:** En el arreglo ascendente, el pivote es siempre el menor: un lado queda vacío y el otro conserva todos los elementos restantes. La profundidad lineal y la suma de trabajos n - 1, n - 2, etc. producen tiempo cuadrático.

**Caso base:** Un segmento vacío o unitario finaliza, pero su invocación también se cuenta.

**Caso recursivo:** Particionar y llamar sobre ambos lados, excluyendo el pivote. El contador se incrementa al entrar a cada invocación y se propaga entre ambas llamadas, sin estado global.

**Complejidad:**

- Mejor caso: Θ(n log n), con particiones equilibradas.
- Caso promedio: Θ(n log n), bajo una distribución adecuada de los datos.
- Peor caso: Θ(n²), con particiones completamente desbalanceadas.
- Espacio auxiliar: O(log n) equilibrado y O(n) en el peor caso, por la pila.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java Quicksort sobre un arreglo de números enteros ya ordenado de menor a mayor, utilizando siempre el primer elemento de cada subarreglo como pivote y contabilizando la cantidad de llamadas recursivas realizadas.

**Estrategia:** aplicar Quicksort mediante particiones recursivas, seleccionando siempre el primer elemento del segmento como pivote. Utilizar un arreglo previamente ordenado para observar cómo se generan particiones desbalanceadas.

**Justificación:** cuando el arreglo ya está ordenado y se selecciona siempre el primer elemento como pivote, este resulta ser el menor del segmento. Por eso, después de cada partición queda un subarreglo vacío y otro con todos los elementos restantes. La división es muy desigual y provoca un mayor número de niveles recursivos.

**Caso base:** cuando el segmento contiene cero o un elemento, finalizar la llamada porque ya se encuentra ordenado.

**Caso recursivo:** particionar el segmento alrededor del primer elemento y llamar nuevamente a Quicksort sobre los segmentos izquierdo y derecho.

**Reducción del problema:** cada llamada procesa un subarreglo más pequeño, pero en el peor caso su tamaño disminuye solamente en una unidad, generando una profundidad recursiva lineal.

**Complejidad:**
- Mejor caso: Θ(n log n), con particiones equilibradas.
- Caso promedio: Θ(n log n), bajo una distribución adecuada de los datos.
- Peor caso: Θ(n²), para particiones completamente desbalanceadas.
- Espacio auxiliar: O(log n) con particiones equilibradas y O(n) en el peor caso, debido a la pila de llamadas.

**Requisitos:**
- Crear `Ejercicio7.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar manualmente Quicksort utilizando siempre el primer elemento del segmento como pivote.
- Utilizar particiones in-place y llamadas recursivas, sin crear arreglos auxiliares para cada partición.
- Utilizar un método auxiliar recursivo que reciba los límites del segmento.
- Incorporar un contador que se incremente al entrar a cada invocación del método recursivo, incluyendo las llamadas que llegan directamente al caso base.
- Mostrar el arreglo original, el pivote utilizado en cada partición, los tamaños de los subarreglos izquierdo y derecho y la cantidad total de llamadas recursivas.
- Mostrar el arreglo final ordenado.
- Explicar mediante comentarios por qué las particiones quedan desbalanceadas y cómo esto produce una complejidad temporal cuadrática.
- Utilizar como ejemplo principal `{1, 2, 3, 4, 5, 6, 7}`.
- No utilizar `Arrays.sort()` ni otros métodos predefinidos de ordenamiento.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar un arreglo ya ordenado, uno inversamente ordenado y otro desordenado para comparar los comportamientos.
- Probar también arreglos vacíos, unitarios, con elementos repetidos y números negativos.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que los arreglos queden correctamente ordenados y conserven todos sus elementos.
- Verificar que el contador de llamadas sea consistente con la implementación, incluyendo los casos base.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `quickSort(int[] array)` con retorno del total de invocaciones y un auxiliar recursivo con límites y contador `long`. Las particiones son in-place. Los nulos lanzan `IllegalArgumentException`. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 10 pruebas:

| Entrada | Llamadas, incluidos casos base |
|---|---:|
| `{1, 2, 3, 4, 5, 6, 7}` | 13 |
| `{7, 6, 5, 4, 3, 2, 1}` | 13 |
| `{4, 2, 6, 1, 3, 5, 7}` | 9 |
| `{}` | 1 |
| `{7}` | 1 |
| `{3, 1, 3, 1}` | 5 |
| `{-1, -5, 0, -3}` | 5 |
| `{5, 5, 5}` | 5 |
| `{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}` | 5 |

La décima prueba verificó el rechazo de null. En cada entrada válida se comprobaron el orden exacto, la conservación de elementos, el contador devuelto y mostrado y la relación `llamadas = 2 × particiones + 1`, porque cada partición genera dos llamadas y cada caso base también cuenta.

En el ejemplo principal los pivotes fueron 1, 2, 3, 4, 5 y 6, con tamaños izquierdo/derecho 0/6, 0/5, 0/4, 0/3, 0/2 y 0/1. El arreglo final fue `{1, 2, 3, 4, 5, 6, 7}`. En el desordenado, la primera partición tuvo tamaños 3/3, y el total fue 9 invocaciones. El número de invocaciones no mide por sí solo el tiempo ni la profundidad: también importa el tamaño procesado en cada partición.

Se corrigió un valor esperado de la prueba temporal del arreglo desordenado tras revisar su árbol de llamadas: son 9 invocaciones, no 7. El código funcionó correctamente. También se ejecutaron los ejemplos del main.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados quedaron fuera del repositorio. Sin pendientes.


### Ejercicio 8 — MergeSort paso a paso

**Estrategia:** Dividir recursivamente cada segmento en dos mitades usando un índice central seguro y fusionar las mitades ordenadas con un arreglo auxiliar reutilizado.

**Justificación:** Divide y vencerás permite ordenar segmentos menores y combinar sus resultados. A diferencia de Quicksort, no hay pivotes y las divisiones permanecen aproximadamente equilibradas.

**Caso base:** Un segmento vacío o unitario ya está ordenado.

**Caso recursivo:** Ordenar ambas mitades y fusionarlas, tomando en cada paso el menor elemento disponible. El segmento se reduce aproximadamente a la mitad en cada llamada.

**Complejidad:**

- Mejor, peor y caso promedio: Θ(n log n).
- Espacio auxiliar: O(n) para el arreglo de fusión y O(log n) para la pila, con total O(n).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el algoritmo MergeSort para ordenar un arreglo de números enteros de menor a mayor, mostrando paso a paso cómo se divide el arreglo y cómo se fusionan sus partes.

**Estrategia:** utilizar el paradigma divide y vencerás. Dividir recursivamente cada segmento del arreglo en dos mitades hasta obtener segmentos de un único elemento. Luego fusionar las partes ordenadas, comparando sus elementos para reconstruir segmentos cada vez más grandes.

**Justificación:** MergeSort resuelve el problema dividiendo el arreglo en subproblemas más pequeños y combinando posteriormente sus resultados. A diferencia de Quicksort, no utiliza pivotes y mantiene divisiones aproximadamente equilibradas.

**Caso base:** cuando el segmento contiene cero o un elemento, finalizar la recursión porque ese segmento ya está ordenado.

**Caso recursivo:** calcular el índice central, ordenar recursivamente la mitad izquierda, ordenar recursivamente la mitad derecha y finalmente fusionar ambas partes en orden ascendente.

**Reducción del problema:** en cada llamada recursiva se divide el segmento aproximadamente por la mitad, hasta alcanzar el caso base.

**Complejidad:**
- Mejor caso: Θ(n log n).
- Peor caso: Θ(n log n).
- Caso promedio: Θ(n log n).
- Espacio auxiliar: O(n), debido al arreglo utilizado durante las fusiones, además de la pila recursiva O(log n).

**Requisitos:**
- Crear `Ejercicio8.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar un método `mergeSort(int[] array)` y los métodos auxiliares recursivos y de fusión necesarios.
- Implementar MergeSort manualmente, sin `Arrays.sort()` ni métodos predefinidos de ordenamiento.
- Dividir el arreglo utilizando un índice central calculado de forma segura.
- Utilizar recursividad para procesar ambas mitades.
- Utilizar un arreglo auxiliar para fusionar los elementos ordenados.
- Mostrar el arreglo original antes del ordenamiento.
- Mostrar en consola cada división, indicando el segmento actual y las mitades obtenidas.
- Identificar mediante mensajes cuándo una llamada alcanza el caso base.
- Mostrar las fusiones realizadas, indicando los segmentos que se combinan y el resultado ordenado.
- Diferenciar claramente los mensajes de DIVISIÓN, CASO BASE y FUSIÓN.
- Mostrar el arreglo final completamente ordenado.
- Incorporar comentarios explicando la recursividad, el caso base, la división, la fusión y el paradigma divide y vencerás.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal `{8, 5, 2, 9, 6, 3}` y verificar que el resultado sea `{2, 3, 5, 6, 8, 9}`.
- Probar arreglos ordenados, inversamente ordenados, con elementos repetidos, números negativos, vacíos, unitarios y extremos de `int`.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que el arreglo final conserve todos los elementos originales.
- Verificar que las trazas de división, caso base y fusión sean coherentes con el funcionamiento del algoritmo.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementaron `mergeSort(int[] array)` y auxiliares de recursión, fusión y visualización. El auxiliar de tamaño n se reserva una sola vez. Las trazas distinguen DIVISIÓN, CASO BASE y FUSIÓN, mostrando los segmentos y resultados. Los nulos lanzan `IllegalArgumentException`. El comentario inicial conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 12 pruebas: ejemplo principal, ordenado, inverso, repetidos, negativos, vacío, unitario, extremos de `int`, todos iguales, dos elementos, longitud impar y nulo. Se verificaron el orden y la conservación de elementos, las mitades obtenidas en cada división, los segmentos de cero o un elemento en cada caso base y el resultado exacto de cada fusión.

En el ejemplo se observaron estas divisiones:

- `{8, 5, 2, 9, 6, 3}` en `{8, 5, 2}` y `{9, 6, 3}`.
- `{8, 5, 2}` en `{8, 5}` y `{2}`; luego `{8, 5}` en `{8}` y `{5}`.
- `{9, 6, 3}` en `{9, 6}` y `{3}`; luego `{9, 6}` en `{9}` y `{6}`.

Fusiones observadas, en orden de ejecución:

| Izquierda | Derecha | Resultado |
|---|---|---|
| `{8}` | `{5}` | `{5, 8}` |
| `{5, 8}` | `{2}` | `{2, 5, 8}` |
| `{9}` | `{6}` | `{6, 9}` |
| `{6, 9}` | `{3}` | `{3, 6, 9}` |
| `{2, 5, 8}` | `{3, 6, 9}` | `{2, 3, 5, 6, 8, 9}` |

El ejemplo produjo cinco divisiones, seis casos base y cinco fusiones. El arreglo final fue `{2, 3, 5, 6, 8, 9}`. Todas las pruebas fueron correctas y también se ejecutaron los ejemplos del main.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados quedaron fuera del repositorio. Sin pendientes.

### Ejercicio 9 — Comparación de algoritmos simples

**Estrategia:** Bubble Sort compara e intercambia vecinos mediante pasadas con límite decreciente, sin salida anticipada. Selection Sort busca el mínimo pendiente y lo intercambia únicamente si ocupa otra posición. Insertion Sort inserta cada clave en la zona izquierda ordenada desplazando los elementos mayores.

**Justificación:** intercambiar vecinos, buscar primero el mínimo e insertar en una zona ordenada producen diferentes cantidades de comparaciones y movimientos. Un intercambio modifica dos posiciones y un desplazamiento mueve un elemento hacia la derecha; sus contadores no representan costos directamente equivalentes.

**Complejidad:** Bubble Sort tradicional y Selection Sort tienen tiempo Θ(n²) en mejor, promedio y peor caso. Insertion Sort tiene mejor caso Θ(n), promedio Θ(n²) para datos aleatorios y peor caso Θ(n²). Los tres usan espacio auxiliar O(1), excluyendo las copias independientes O(n) utilizadas para comparar los algoritmos.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una comparación de los algoritmos Bubble Sort, Selection Sort e Insertion Sort, utilizando el mismo arreglo de números enteros y contabilizando las operaciones realizadas por cada uno.

**Estrategia A — Bubble Sort:** utilizar dos ciclos `for` anidados para comparar elementos vecinos e intercambiarlos cuando estén desordenados. Reducir el límite interno después de cada pasada, sin finalización anticipada.

**Estrategia B — Selection Sort:** buscar el elemento mínimo de la parte desordenada mediante dos ciclos `for` anidados y colocarlo en su posición definitiva. Intercambiar solamente cuando la posición del mínimo sea distinta de la posición actual.

**Estrategia C — Insertion Sort:** recorrer el arreglo desde el segundo elemento e insertar cada valor en su posición dentro de la parte previamente ordenada, desplazando hacia la derecha los elementos mayores.

**Justificación:** los tres algoritmos resuelven el mismo problema utilizando estrategias diferentes. Bubble Sort intercambia vecinos, Selection Sort busca el mínimo antes de moverlo e Insertion Sort construye progresivamente una zona ordenada. Comparar sus operaciones permite observar diferencias que no se reflejan únicamente en la notación Big O.

**Complejidad:**
- Bubble Sort tradicional: mejor, promedio y peor caso Θ(n²).
- Selection Sort: mejor, promedio y peor caso Θ(n²).
- Insertion Sort: mejor caso Θ(n), promedio y peor caso Θ(n²).
- Los tres algoritmos utilizan O(1) de espacio auxiliar, sin contar las copias independientes utilizadas exclusivamente para la comparación.

**Requisitos:**
- Crear `Ejercicio9.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Implementar manualmente tres métodos: `bubbleSort(int[] array)`, `selectionSort(int[] array)` e `insertionSort(int[] array)`.
- No utilizar `Arrays.sort()` ni otros métodos predefinidos de ordenamiento para implementar los algoritmos.
- Utilizar copias independientes del mismo arreglo original, de modo que los tres algoritmos reciban exactamente los mismos datos.
- Ordenar todos los arreglos de menor a mayor.
- Contabilizar las comparaciones reales entre valores del arreglo, sin contar las condiciones de control de los ciclos.
- En Bubble Sort, contabilizar cada intercambio efectivo entre elementos vecinos.
- En Selection Sort, contabilizar cada intercambio efectivo, evitando intercambios consigo mismo.
- En Insertion Sort, contabilizar cada desplazamiento hacia la derecha dentro del ciclo interno; no contar la escritura final de la clave como desplazamiento.
- En Insertion Sort, contabilizar cada comparación entre la clave y un elemento previo, incluida la comparación que detiene el desplazamiento cuando la clave no es menor.
- Mostrar el arreglo original y los resultados ordenados de los tres algoritmos.
- Mostrar para cada algoritmo su cantidad de comparaciones y de intercambios o desplazamientos, usando etiquetas que distingan ambos tipos de movimiento.
- Incorporar una conclusión textual que explique las diferencias observadas, sin equiparar directamente el costo de un intercambio con el de un desplazamiento.
- Incorporar comentarios explicando la estrategia y la contabilización de operaciones de cada algoritmo.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal `{5, 3, 8, 2}`.
- Verificar que los tres algoritmos produzcan `{2, 3, 5, 8}`.
- Para el ejemplo principal, verificar los contadores: Bubble Sort, 6 comparaciones y 4 intercambios; Selection Sort, 6 comparaciones y 2 intercambios; Insertion Sort, 5 comparaciones y 4 desplazamientos.
- Probar también arreglos ya ordenados, inversamente ordenados, casi ordenados, con elementos repetidos, negativos, vacíos, unitarios y extremos de `int`.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Verificar que todos los algoritmos produzcan el mismo resultado, conserven los elementos originales y no modifiquen el arreglo utilizado como fuente para las copias.
- Compilar y ejecutar con Java 21, documentando los resultados reales de las pruebas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementaron `bubbleSort(int[] array)`, `selectionSort(int[] array)` e `insertionSort(int[] array)`, con contadores locales de tipo `long`. Las comparaciones cuentan solamente valores, incluyendo en inserción la comparación que detiene los desplazamientos. Se excluyen las condiciones de control, los intercambios consigo mismo y la escritura final de la clave.

La compilación con Java 21, `--release 21` y `-Xlint:all` fue correcta, sin advertencias. Se ejecutó el `main` y una verificación independiente de diez arreglos: ejemplo principal, ordenado, inverso, casi ordenado, repetidos, negativos, vacío, unitario, extremos de `int` y todos iguales. Se comprobaron 30 ordenamientos y sus contadores exactos, la conservación de los elementos y del arreglo fuente. También se verificaron tres rechazos de `null` mediante `IllegalArgumentException`, uno por algoritmo. Todas las verificaciones aprobaron.

Para `{5, 3, 8, 2}`, los tres produjeron `{2, 3, 5, 8}`:

| Algoritmo | Comparaciones | Intercambios | Desplazamientos |
|---|---:|---:|---:|
| Bubble Sort | 6 | 4 | No aplica |
| Selection Sort | 6 | 2 | No aplica |
| Insertion Sort | 5 | No aplica | 4 |

Para `{1, 2, 3, 4}`, burbuja y selección realizaron 6 comparaciones y 0 intercambios; inserción realizó 3 comparaciones y 0 desplazamientos. Para el arreglo casi ordenado `{1, 2, 3, 5, 4, 6, 7}`, inserción realizó 7 comparaciones y 1 desplazamiento. Estos resultados muestran cómo inserción aprovecha el orden previo. Los archivos de prueba y compilados se generaron fuera del repositorio. Sin pendientes.

### Ejercicio 10 — Sistema de ranking de puntajes

**Algoritmo elegido:** MergeSort.

**Estrategia:** dividir recursivamente el arreglo de objetos `Jugador` y fusionar las mitades por puntaje descendente utilizando un único arreglo auxiliar reutilizable. Ante un empate se elige primero el jugador de la mitad izquierda.

**Justificación:** MergeSort garantiza tiempo Θ(n log n), frente al peor caso cuadrático de otros algoritmos estudiados. La fusión estable conserva el orden original de jugadores empatados. Se mueven referencias a los objetos completos para conservar juntos nombres y puntajes.

**Caso base:** un segmento con cero o un jugador ya está ordenado.

**Caso recursivo:** ordenar ambas mitades y fusionarlas de mayor a menor puntaje. Cada llamada reduce aproximadamente a la mitad el segmento; la pila conserva los segmentos pendientes.

**Complejidad:** mejor, promedio y peor caso Θ(n log n). Espacio auxiliar O(n) para el único arreglo de fusión y O(log n) para la pila recursiva; en total O(n).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un sistema de ranking de jugadores que permita ordenar una colección de jugadores de mayor a menor puntaje utilizando MergeSort.

**Algoritmo elegido: MergeSort.**

**Estrategia:** representar cada jugador mediante un objeto que contenga su nombre y puntaje. Utilizar MergeSort para dividir recursivamente el arreglo de jugadores en dos mitades hasta llegar a segmentos individuales. Luego fusionar las mitades comparando los puntajes, colocando primero al jugador con mayor puntuación.

**Justificación:** MergeSort es una elección conveniente porque garantiza una complejidad temporal Θ(n log n), incluso en el peor caso. Además, permite mantener el orden original de los jugadores que tienen el mismo puntaje mediante una fusión estable. Esto resulta útil para construir un ranking predecible.

**Caso base:** cuando un segmento contiene cero o un jugador, ya se encuentra ordenado.

**Caso recursivo:** dividir el segmento en dos mitades, ordenar recursivamente cada una y fusionarlas según el puntaje descendente.

**Reducción del problema:** cada llamada recursiva procesa aproximadamente la mitad de los jugadores del segmento original.

**Complejidad:**
- Mejor caso: Θ(n log n).
- Caso promedio: Θ(n log n).
- Peor caso: Θ(n log n).
- Espacio auxiliar: O(n), debido al arreglo utilizado para fusionar los segmentos, además de la pila recursiva O(log n).

**Requisitos:**
- Crear `Ejercicio10.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Definir una clase `Jugador` con los atributos `nombre` y `puntaje`, incluyendo un constructor y los métodos necesarios para consultar sus valores.
- Implementar un método `mergeSort(Jugador[] jugadores)` que ordene el arreglo de mayor a menor puntaje.
- Implementar manualmente MergeSort mediante métodos auxiliares recursivos y de fusión.
- Utilizar un único arreglo auxiliar reutilizable durante las fusiones, evitando crear arreglos auxiliares nuevos en cada llamada recursiva.
- Realizar las comparaciones utilizando el puntaje de cada jugador.
- Mantener juntos el nombre y el puntaje de cada jugador durante todo el proceso de ordenamiento.
- En caso de empate, conservar el orden original de aparición. Para garantizar la estabilidad, durante la fusión debe elegirse primero el jugador de la mitad izquierda cuando ambos puntajes sean iguales.
- No utilizar `Arrays.sort()`, `Collections.sort()`, `Comparator.sort()` ni otros métodos predefinidos de ordenamiento.
- Mostrar la lista original de jugadores.
- Mostrar el ranking final con número de posición, nombre y puntaje.
- Incorporar comentarios que expliquen el algoritmo elegido, el criterio descendente, la recursividad y el tratamiento de empates.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal estos jugadores:
  - `Jugador("Ana", 1200)`
  - `Jugador("Pedro", 900)`
  - `Jugador("Lucia", 1500)`
- Verificar que el ranking resultante sea:
  1. Lucia — 1500
  2. Ana — 1200
  3. Pedro — 900
- Realizar una prueba adicional agregando `Jugador("Martin", 1200)` después de los tres jugadores originales y verificar que Ana permanezca delante de Martin al tener ambos 1200 puntos.
- Probar jugadores ya ordenados, ordenados en sentido inverso, con puntajes repetidos, con puntajes negativos y con valores extremos de `int`.
- Probar arreglos vacíos y de un solo jugador.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Validar que los elementos Jugador no sean nulos y que los nombres no sean nulos ni vacíos, antes de comenzar a ordenar, evitando modificaciones parciales.
- Permitir puntajes enteros negativos, porque pueden representar penalizaciones.
- Verificar que se conserven todos los jugadores y sus respectivos puntajes.
- Verificar expresamente que los empates mantengan el orden original.
- Compilar y ejecutar con Java 21, documentando los resultados reales de las pruebas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó la clase `Jugador` con nombre, puntaje, constructor y métodos de consulta, junto con `mergeSort(Jugador[] jugadores)` y auxiliares recursivos de ordenamiento y fusión. Se validan todos los jugadores y nombres antes de modificar el arreglo. Se permiten puntajes negativos.

Compilación correcta con Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Se ejecutaron el `main` y 14 casos independientes: diez rankings (principal, empate Ana/Martin, ordenado, inverso, todos empatados, negativos, extremos de `int`, vacío, unitario y empates repartidos) y cuatro entradas inválidas (arreglo nulo, jugador nulo, nombre nulo y nombre vacío).

En los diez rankings se verificaron orden descendente, estabilidad y conservación de cada objeto original mediante comparación con un resultado independiente estable. Las cuatro entradas inválidas produjeron `IllegalArgumentException`; los arreglos inválidos permanecieron intactos. Todas las pruebas aprobaron.

Ranking principal observado:

1. Lucia — 1500
2. Ana — 1200
3. Pedro — 900

Al agregar Martin después de los tres jugadores originales, se obtuvo:

1. Lucia — 1500
2. Ana — 1200
3. Martin — 1200
4. Pedro — 900

Ana permaneció delante de Martin, verificando el tratamiento estable del empate. Las pruebas y los compilados se generaron fuera del repositorio. Sin pendientes.
