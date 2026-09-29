# Tim de Marketing

Te damos la bienvenida a Tim de Marketing en el track Java de Exercism.
Si necesitas ayuda para ejecutar las pruebas o enviar tu código, consulta `HELP.md`.
Si te atascas con el ejercicio, consulta `HINTS.md`, pero primero intenta resolverlo sin usarlos :)

## Introduction

## Nulabilidad

En Java, el literal `null` se usa para indicar la ausencia de un valor.

Todos los tipos de datos primitivos de Java tienen un valor predeterminado y, por lo tanto, nunca pueden ser `null`. Por convención, empiezan con una letra minúscula, por ejemplo, `int`.

Los tipos de referencia contienen la dirección de memoria de un objeto y pueden tener un valor `null`. Por lo general, empiezan con una letra mayúscula, por ejemplo, `String`.

Si intentas asignar un valor `null` a una variable primitiva, obtendrás un error en tiempo de compilación, ya que la variable siempre contiene un valor primitivo del tipo asignado.

```java
//Throws compile time error stating the required type is int, but null was provided
int number = null;
```

Asignar un valor `null` a una variable de referencia no producirá un error en tiempo de compilación, ya que las variables de referencia pueden ser `null`.

```java
//No error will occur as the String variable str is nullable
String str = null;
```

## Instructions

En este ejercicio vas a escribir código para imprimir credenciales con el nombre de los empleados de una fábrica.

## 1. Imprime una credencial para un empleado

Los empleados tienen un ID, un nombre y el nombre de un departamento. Las etiquetas de las credenciales de los empleados tienen este formato: `"[id] - name - DEPARTMENT"`.
Implementa el método `Badge.print()` para devolver la etiqueta de la credencial de un empleado:

```java
Badge badge = new Badge();
badge.print(734, "Ernest Johnny Payne", "Strategic Communication");
// => "[734] - Ernest Johnny Payne - STRATEGIC COMMUNICATION"
```

Fíjate que el departamento debe ir en mayúsculas en la etiqueta.

## 2. Imprime una credencial para un empleado nuevo

Debido a una peculiaridad del sistema informático, a veces los empleados nuevos todavía no tienen un ID cuando empiezan a trabajar en la fábrica.
Como las credenciales son obligatorias, recibirán una credencial temporal sin el prefijo del ID. Modifica el método `Badge.print()` para admitir empleados nuevos que todavía no tienen un ID:

```java
Badge badge = new Badge();
Badge.print(null, "Jane Johnson", "Procurement");
// => "Jane Johnson - PROCUREMENT"
```

## 3. Imprime una credencial para el dueño

Hasta el dueño de la fábrica tiene que llevar una credencial en todo momento.
Sin embargo, un dueño no tiene departamento. En este caso, la etiqueta debe imprimir `"OWNER"` en lugar del nombre del departamento.
Modifica el método `Badge.print()` para imprimir una etiqueta para el dueño:

```java
Badge badge = new Badge();
badge.print(254, "Charlotte Hale", null);
// => "[254] - Charlotte Hale - OWNER"
```

Ten en cuenta que es posible que el dueño también sea un empleado nuevo:

```java
Badge badge = new Badge();
badge.print(null, "Charlotte Hale", null);
// => "Charlotte Hale - OWNER"
```

## Source

### Created by

- @smcg468