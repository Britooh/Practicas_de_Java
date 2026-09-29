# Gotta Snatch 'Em All

Te damos la bienvenida a Gotta Snatch 'Em All en el track Java de Exercism.
Si necesitas ayuda para ejecutar las pruebas o enviar tu código, consulta `HELP.md`.
Si te atascas con el ejercicio, consulta `HINTS.md`, pero primero intenta resolverlo sin usarlos :)

## Introduction

## Conjuntos

Un [`Set`][set-docs] es una colección desordenada que (a diferencia de `List`) garantiza no contener valores duplicados.

El parámetro de tipo genérico de la interfaz `Set` denota el tipo de los elementos contenidos en el `Set`:

```java
Set<Integer> ints = Set.of(1, 2, 3);
Set<String> strings = Set.of("alpha", "beta", "gamma");
Set<Object> mixed = Set.of(1, false, "foo");
```

Fíjate que el método `Set.of()` crea una instancia de `Set` [_no modificable_][unmodifiable-set-docs].
Intentar llamar a métodos como `add` y `remove` en esta instancia provocará una excepción en tiempo de ejecución.

Para crear un `Set` modificable, necesitas instanciar una clase que implemente la interfaz `Set`.
La clase integrada más usada que implementa esta interfaz es la clase [`HashSet`][hashset-docs].

```java
Set<Integer> ints = new HashSet<>();
```

La interfaz `Set` hereda de las interfaces [`Collection`][collection-docs] e [`Iterable`][iterable-docs], y por lo tanto comparte muchos métodos con otros tipos de colecciones.
Una diferencia notable con la interfaz `Collection`, sin embargo, es que métodos como `add` y `remove` devuelven un `boolean` (en lugar de `void`) que indica si el elemento estaba contenido en el conjunto cuando se llamó a ese método:

```java
Set<Integer> set = new HashSet<>();
set.add(1);
// => true
set.add(2);
// => true
set.add(1);
// => false
set.size();
// => 2
set.contains(1);
// => true
set.contains(3);
// => false
set.remove(3);
// => false
set.remove(2);
// => true
set.size();
// => 1
```

[collection-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html
[hashset-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashSet.html
[iterable-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Iterable.html
[set-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html
[unmodifiable-set-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html#unmodifiable

## Instructions

Tu nostalgia por las tarjetas de Blorkemon™️ no muestra señales de disminuir; incluso comenzaste a coleccionarlas de nuevo y estás haciendo que tus amigos se unan a ti.

En este ejercicio, usarás la interfaz `Set` para ayudarte a administrar tu colección, ya que las tarjetas duplicadas no son importantes cuando tu objetivo es conseguir todas las tarjetas existentes.

## 1. Inicia una colección

¡Acabas de encontrar tu viejo alijo de tarjetas de Blorkemon™️!
El alijo contiene un montón de tarjetas duplicadas, así que es hora de empezar una nueva colección eliminando los duplicados.

Realmente quieres que tus amigos se unan a tu locura por Blorkemon™️, y la mejor manera es darles un empujón a su colección regalándoles una tarjeta.

Implementa el método `newCollection`, que transforma una lista de tarjetas en un `Set` que representa tu nueva colección.

```java
GottaSnatchEmAll.newCollection(List.of("Newthree", "Newthree", "Newthree"));
// => {"Newthree"}
```

## 2. Haz crecer la colección

Una vez que tienes una colección, cobra vida propia y debe crecer.

Implementa el método `addCard`, que recibe una nueva tarjeta y tu conjunto actual de tarjetas coleccionadas.
El método debe agregar la nueva tarjeta a la colección si aún no está presente, y debe devolver un `boolean` que indica si la colección se actualizó.

```java
Set<String> collection = GottaSnatchEmAll.newCollection("Newthree");
GottaSnatchEmAll.addCard("Scientuna",collection);
// => true

collection.contains("Scientuna");
// => true
```

## 3. Empieza a intercambiar

Realmente quieres que tus amigos se unan a tu locura por Blorkemon™️, ¡así que es hora de empezar a intercambiar!

Cuando intercambias con amigos, no todos los intercambios valen la pena ni se pueden hacer.
Solo deberías intercambiar si tanto tú como tu amigo tienen una tarjeta que el otro no tiene.

Implementa el método `canTrade`, que recibe tu colección actual y la colección de uno de tus amigos.
Debe devolver un `boolean` que indica si un intercambio es posible, siguiendo las reglas anteriores.

```java
Set<String> myCollection = Set.of("Newthree");
Set<String> theirCollection = Set.of("Scientuna");
GottaSnatchEmAll.canTrade(myCollection, theirCollection);
// => true
```

## 4. Identifica las tarjetas comunes

Tú y tus amigos entusiastas de Blorkemon™️ se reúnen y se preguntan cuáles son las tarjetas más comunes.

Implementa el método `commonCards`, que recibe una lista de colecciones y devuelve una colección de las tarjetas que todas las colecciones tienen.

```java
GottaSnatchEmAll.commonCards(List.of(Set.of("Scientuna"), Set.of("Newthree","Scientuna")));
// => {"Scientuna"}
```

## 5. Todas las tarjetas

¿Tú y tus amigos tienen colectivamente todas las tarjetas de Blorkemon™️?

Implementa el método `allCards`, que recibe una lista de colecciones y devuelve una colección con todas las tarjetas diferentes de todas las colecciones combinadas.

```java
GottaSnatchEmAll.allCards(List.of(Set.of("Scientuna"), Set.of("Newthree","Scientuna")));
// => {"Newthree", "Scientuna"}
```

## Source

### Created by

- @sanderploegsma

### Contributed to by

- @kahgoh