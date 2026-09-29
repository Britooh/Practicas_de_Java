# Especialista en llamadas internacionales

Te damos la bienvenida a Especialista en llamadas internacionales en el track Java de Exercism.
Si necesitas ayuda para ejecutar las pruebas o enviar tu código, consulta `HELP.md`.
Si te atascas con el ejercicio, consulta `HINTS.md`, pero primero intenta resolverlo sin usarlos :)

## Introduction

## Maps

Un **Map** es una estructura de datos que sirve para almacenar pares de clave y valor.
Es similar a los diccionarios de otros lenguajes de programación.
La interfaz [Map][map-javadoc] define las operaciones sobre un mapa.

Java tiene varias implementaciones de Map diferentes.
[HashMap][hashmap-javadoc] es una de las más usadas.

```java
// Make an instance
Map<String, Integer> fruitPrices = new HashMap<>();
```

Agrega entradas al mapa con [put][map-put-javadoc].

```java
fruitPrices.put("apple", 100);
fruitPrices.put("pear", 80);
// => { "apple" => 100, "pear" => 80 }
```

Solo un valor puede estar asociado con cada clave.
Llamar a `put` con la misma clave actualiza el valor de esa clave.

```java
fruitPrices.put("pear", 40);
// => { "apple" => 100, "pear" => 40 }
```

Usa [get][map-get-javadoc] para obtener el valor de una clave.

```java
fruitPrices.get("apple"); // => 100
```

Usa [containsKey][map-containskey-javadoc] para ver si el mapa contiene una clave en particular.

```java
fruitPrices.containsKey("apple");  // => true
fruitPrices.containsKey("orange"); // => false
```

Elimina entradas con [remove][map-remove-javadoc].

```java
fruitPrices.put("plum", 90);  // Add plum to map
fruitPrices.remove("plum");   // Removes plum from map
```

El método [size][map-size-javadoc] devuelve el número de entradas.

```java
fruitPrices.size();  // Returns 2
```

Puedes usar los métodos [keySet][map-keyset-javadoc] o [values][map-values-javadoc] para obtener las claves o los valores de un Map como un Set o una colección, respectivamente.

```java
fruitPrices.keySet();  // Returns "apple" and "pear" in a set
fruitPrices.values();  // Returns 100 and 80, in a Collection
```

[map-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
[hashmap-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
[map-put-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#put(K,V)
[map-get-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#get(java.lang.Object)
[map-containskey-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#containsKey(java.lang.Object)
[map-remove-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#remove(java.lang.Object)
[map-size-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#size()
[map-keyset-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#keySet()
[map-values-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#values()

## Instructions

En este ejercicio escribirás código para administrar un diccionario de códigos de marcación internacional usando un `Map`.

El diccionario permite buscar el nombre de un país (el valor del mapa, como `String`) por el código de marcación internacional (la clave del mapa, como `Integer`).

## 1. Devolver los códigos en un mapa

Implementa el método `getCodes`, que no recibe parámetros y devuelve un mapa con los códigos de marcación y los países que actualmente hay en el diccionario.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.getCodes();
// => empty map 
```

## 2. Agregar entradas al diccionario

Hay que llenar el diccionario.
Implementa el método `setDialingCode`, que recibe un código de marcación y el país correspondiente, y agrega el código de marcación y el país.
Si el código de marcación ya está en el mapa, actualiza el mapa con el código y el país proporcionados.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.setDialingCode(679, "Unknown");
// => { 679 => "Unknown" }

dialingCodes.setDialingCode(679, "Fiji");
// => { 679 => "Fiji" }
```

## 3. Buscar el país de un código de marcación

Implementa el método `getCountry`, que recibe un código de marcación y devuelve el nombre del país correspondiente a ese código de marcación.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.setDialingCode(55, "Brazil");
dialingCodes.getCountry(55);
// => "Brazil"
```

## 4. No permitir duplicados

Al agregar un código de marcación, hay que tener cuidado de evitar que se agregue dos veces un código o un país.
Cuando esto ocurra, se puede asumir que la primera entrada es la correcta.
Implementa el método `addNewDialingCode`, que agrega una entrada para el código de marcación y el país dados.
Sin embargo, a diferencia de `setDialingCode`, no hace nada si el código de marcación o el país ya están en el mapa.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.addNewDialingCode(32, "Belgium");
dialingCodes.addNewDialingCode(379, "Vatican City");
// => { 32 => "Belgium", 379 => "Vatican City" }


dialingCodes.addNewDialingCode(32, "Other");
dialingCodes.addNewDialingCode(39, "Vatican City");
// => { 32 => "Belgium", 379 => "Vatican City" }
```

## 5. Encontrar el código de marcación de un país

No es común, pero se pueden cometer errores.
Para corregir el error, necesitamos saber a qué código de marcación está asignado actualmente el país.
Para encontrar qué código de marcación hay que corregir, implementa el método `findDialingCode`, que recibe un país y devuelve el código de marcación de ese país.
Devuelve `null` si el país _no_ está en el mapa.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.addDialingCode(44, "UK");
dialingCodes.findDialingCode("UK");
// => 44

dialingCodes.findDialingCode("Unlisted");
// => null
```

## 6. Actualizar el código de marcación del país

Ahora que sabemos qué código de marcación hay que corregir, procedemos a actualizarlo.
Implementa el método `updateCountryDialingCode`, que recibe el nuevo código de marcación del país y el nombre del país, y actualiza en consecuencia.
No hagas nada si el país _no_ está en el mapa (ya que este método solo sirve para ayudar a corregir errores).

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.addDialingCode(88, "Japan");
// => { 88 => "Japan" }

dialingCodes.updateCountryDialingCode(81, "Japan");
// => { 81 => "Japan" }

dialingCodes.updateCountryDialingCode(32, "Mars");
// => { 81 => "Japan"}
```

## Source

### Created by

- @kahgoh