# Citas para el salón de belleza

Te damos la bienvenida a Citas para el salón de belleza en el track Java de Exercism.
Si necesitas ayuda para ejecutar las pruebas o enviar tu código, consulta `HELP.md`.
Si te atascas con el ejercicio, consulta `HINTS.md`, pero primero intenta resolverlo sin usarlos :)

## Introduction

## Fecha y hora

El paquete `java.time`, introducido en Java 8, contiene varias clases para trabajar con fechas y horas.

### `LocalDate`

La clase `java.time.LocalDate` representa una fecha sin zona horaria en el [sistema de calendario ISO-8601][iso-8601], como `2007-12-03`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
```

Las fechas se pueden comparar con otras fechas:

```java
LocalDate date1 = LocalDate.of(2007, 12, 3);
LocalDate date2 = LocalDate.of(2007, 12, 4);

date1.isBefore(date2);
// => true

date1.isAfter(date2);
// => false
```

Una instancia de `LocalDate` tiene métodos getter para obtener partes de la fecha:

```java
LocalDate date = LocalDate.of(2007, 12, 3);

date.getDayOfMonth();
// => 3
```

Una instancia de `LocalDate` tiene métodos para agregarle unidades de tiempo:

```exercism/note
Estos métodos devuelven una _nueva_ instancia de `LocalDate` y no actualizan la instancia existente, ya que la clase `LocalDate` es inmutable.
```

```java
LocalDate date = LocalDate.of(2007, 12, 3);

date.plusDays(3);
// => 2007-12-06
```

### `LocalDateTime`

La clase `java.time.LocalDateTime` representa una fecha y hora sin zona horaria en el [sistema de calendario ISO-8601][iso-8601], como `2007-12-03T10:15:30`:

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
```

Puedes convertir una instancia de `LocalDate` en una `LocalDateTime`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
LocalDateTime datetime = date.atTime(10, 15, 30);
datetime.toString();
// => "2007-12-03T10:15:30"
```

### Formato de fechas y horas

Tanto `LocalDate` como `LocalDateTime` usan la notación estándar [ISO-8601][iso-8601] al convertir desde y hacia un `String`.

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
LocalDateTime parsed = LocalDateTime.parse("2007-12-03T10:15:30");

datetime.isEqual(parsed);
// => true
```

No es posible parsear un `LocalDate` o un `LocalDateTime` desde un `String` como el anterior usando un formato diferente.
En su lugar, para dar formato a las fechas con un formato personalizado, debes usar `java.time.format.DateTimeFormatter`:

```java
DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse("03/12/2007", parser);

DateTimeFormatter printer = DateTimeFormatter.ofPattern("MMMM d, yyyy");
printer.format(date);
// => "December 3, 2007"
```

También puedes especificar una configuración regional al crear el formato personalizado, para dar formato y parsear según distintas regiones:

```java
DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.FRENCH).format(date);
// => décembre 3, 2007

DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.of("pt")).format(date);
// => dezembro 3, 2007
```

[iso-8601]: https://en.wikipedia.org/wiki/ISO_8601

## Instructions

En este ejercicio vas a trabajar en un agendador de citas para un salón de belleza en Nueva York que abrió sus puertas el 15 de septiembre de 2012.

## 1. Convertir la fecha de una cita

Implementa el método `AppointmentScheduler.schedule()` para convertir una representación textual de la fecha de una cita al `LocalDateTime` correspondiente:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.schedule("7/25/2019 13:45:00");
// => LocalDateTime.of(2019, 7, 25, 13, 45, 0)
```

## 2. Comprobar si una cita ya pasó

Implementa el método `AppointmentScheduler.hasPassed()`, que recibe la fecha de una cita y comprueba si la cita quedó en algún momento del pasado:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.hasPassed(LocalDateTime.of(1999, 12, 31, 9, 0, 0));
// => true
```

## 3. Comprobar si la cita es por la tarde

Implementa el método `AppointmentScheduler.isAfternoonAppointment()`, que recibe la fecha de una cita y comprueba si la cita es por la tarde (>= 12:00 y < 18:00):

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.isAfternoonAppointment(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
// => true
```

## 4. Describir la fecha y la hora de la cita

Implementa el método `AppointmentScheduler.getDescription()`, que recibe la fecha de una cita y devuelve una descripción de esa fecha y hora:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.getDescription(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
// => "You have an appointment on Friday, March 29, 2019, at 3:00 PM."
```

## 5. Devolver la fecha del aniversario

Implementa el método `AppointmentScheduler.getAnniversaryDate()`, que devuelve la fecha del aniversario de este año, que es el 15 de septiembre:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.getAnniversaryDate()
// => LocalDate.of(<current year>, 9, 15)
```

## Source

### Created by

- @sanderploegsma