import java.util.Locale;

class Badge {

    // Este metodo sirve para generar el texto completo de una
    // credencial de empleado, cubriendo tres situaciones distintas
    // segun los datos que reciba (id, name, department).
    public String print(Integer id, String name, String department) {

        // ================= TAREA 1: Imprime una credencial para un empleado =================
        // Sirve para armar la parte del texto con el ID y el nombre.
        // Usamos "Integer" (en vez de "int") a proposito, porque
        // "int" no puede ser null, y aqui SI necesitamos poder
        // representar la ausencia de un ID (ver Tarea 2).
        // Si el empleado SI tiene id, mostramos "[id] - nombre".
        String employee = id == null ? name : "[" + id + "] - " + name;

        // Sirve para armar la parte del texto con el departamento,
        // convertido a mayusculas con toUpperCase(Locale.ROOT)
        // (se usa Locale.ROOT para evitar errores raros con
        // caracteres especiales segun el idioma del sistema).
        // ================= TAREA 3: Imprime una credencial para el dueño =================
        // Si el departamento es null, asumimos que la persona es
        // el dueño de la fabrica, y mostramos "OWNER" en su lugar.
        String area = department == null ? "OWNER" : department.toUpperCase(Locale.ROOT);

        // ================= TAREA 2: Imprime una credencial para un empleado nuevo =================
        // Sirve para juntar las dos partes de arriba en el formato
        // final de la credencial. Si el id es null (empleado nuevo
        // que todavia no tiene numero asignado), "employee" solo
        // tendra el nombre, sin el "[id] -" delante.
        return employee + " - " + area;
    }

    // Metodo principal: sirve para probar el metodo print() con
    // distintas combinaciones de datos y ver los resultados en consola.
    public static void main(String[] args) {
        Badge badge = new Badge();

        // Caso normal: empleado con id y departamento asignados.
        // Deberia mostrar: "[17] - Ryder Herbert - MARKETING"
        System.out.println(badge.print(17, "Ryder Herbert", "Marketing"));

        // Caso empleado nuevo (Tarea 2): id es null, todavia no
        // tiene numero de credencial, pero si tiene departamento.
        // Deberia mostrar: "Bogdan Rosario - MARKETING"
        System.out.println(badge.print(null, "Bogdan Rosario", "Marketing"));

        // Caso sin departamento (Tarea 3): tiene id, pero el
        // departamento es null, asi que se asume que es el dueño.
        // Deberia mostrar: "[59] - Julie Sokato - OWNER"
        System.out.println(badge.print(59, "Julie Sokato", null));

        // Caso combinado: es un dueño Y ademas todavia no tiene id
        // asignado (ambos son null al mismo tiempo).
        // Deberia mostrar: "Amare Osei - OWNER"
        System.out.println(badge.print(null, "Amare Osei", null));
    }
}