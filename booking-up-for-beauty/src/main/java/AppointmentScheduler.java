import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {

    // Este formato define como se ve el texto de ENTRADA cuando
    // alguien agenda una cita, por ejemplo "7/25/2019 13:45:00".
    // Sirve para que el programa sepa como "leer" esa fecha en texto
    // y convertirla en un objeto LocalDateTime que Java entienda.
    // Locale.ENGLISH se usa para que los nombres de mes/dia (si los
    // hubiera en el patron) se interpreten en ingles, sin importar
    // el idioma configurado en la computadora.
    private static final DateTimeFormatter APPOINTMENT_FORMAT =
            DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss", Locale.ENGLISH);

    // Este formato define como se ve el texto de SALIDA cuando
    // le mostramos la cita al cliente, en un estilo mas amigable,
    // por ejemplo "Thursday, July 25, 2019, at 1:45 PM".
    private static final DateTimeFormatter DESCRIPTION_FORMAT =
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a", Locale.ENGLISH);

    // ================= TAREA 1: Convertir la fecha de una cita =================
    // Sirve para tomar el texto que escribe el cliente (o el sistema)
    // con la fecha y hora de la cita, y convertirlo en un objeto
    // LocalDateTime, que es el tipo de dato que Java usa para
    // trabajar con fechas y horas de forma segura.
    public LocalDateTime schedule(String appointmentDateDescription) {
        // parse() sirve para "traducir" el texto usando el formato
        // que definimos arriba (APPOINTMENT_FORMAT), y asi saber
        // exactamente donde esta el mes, el dia, el año, etc.
        return LocalDateTime.parse(appointmentDateDescription, APPOINTMENT_FORMAT);
    }

    // ================= TAREA 2: Comprobar si una cita ya pasó =================
    // Sirve para saber si una cita ya ocurrio en el pasado, comparando
    // su fecha con el momento actual.
    public boolean hasPassed(LocalDateTime appointmentDate) {
        // LocalDateTime.now() obtiene la fecha y hora actuales del
        // sistema. isBefore() sirve para preguntar si la cita es
        // ANTERIOR a ese momento actual (o sea, si ya paso).
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    // ================= TAREA 3: Comprobar si la cita es por la tarde =================
    // Sirve para saber si una cita cae en horario de tarde,
    // que para este salon se define como entre las 12:00 (mediodia)
    // y antes de las 18:00 (6pm).
    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        // getHour() extrae solo la hora de la cita (en formato 24h,
        // de 0 a 23), ignorando minutos y segundos.
        int hour = appointmentDate.getHour();

        // Comprobamos que la hora este dentro del rango de tarde:
        // desde las 12 (incluida) hasta antes de las 18.
        return hour >= 12 && hour < 18;
    }

    // ================= TAREA 4: Describir la fecha y la hora de la cita =================
    // Sirve para armar un mensaje legible y amigable para el cliente,
    // usando el formato de descripcion que definimos arriba
    // (DESCRIPTION_FORMAT), en vez de mostrar la fecha en formato
    // "tecnico" como 2019-07-25T13:45.
    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on " + DESCRIPTION_FORMAT.format(appointmentDate) + ".";
    }

    // ================= TAREA 5: Devolver la fecha del aniversario =================
    // Sirve para calcular la fecha del aniversario del salon
    // (15 de septiembre), pero siempre usando el AÑO ACTUAL,
    // ya que el salon abrio en 2012 pero el aniversario se celebra
    // cada año con la fecha correspondiente al año en curso.
    public LocalDate getAnniversaryDate() {
        // LocalDate.now().getYear() obtiene el año actual del sistema.
        // Month.SEPTEMBER y el 15 son fijos, porque esa es la fecha
        // exacta en la que abrio el salon (mes y dia no cambian).
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }

    // Metodo principal: sirve para probar todos los metodos de
    // arriba con una cita de ejemplo y ver los resultados en consola.
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();

        // Si el programa recibe un argumento por consola, lo usamos
        // como fecha de la cita; si no, usamos una fecha de ejemplo
        // fija ("7/25/2019 13:45:00") para poder probar sin necesidad
        // de escribir nada extra.
        String appointmentDescription = args.length > 0 ? args[0] : "7/25/2019 13:45:00";

        // Convertimos el texto de la cita en un LocalDateTime (Tarea 1).
        LocalDateTime appointment = scheduler.schedule(appointmentDescription);

        // Mostramos la cita ya convertida (formato tecnico de Java).
        System.out.println("Appointment: " + appointment);

        // Comprobamos si esa cita ya paso (Tarea 2). Como la fecha
        // de ejemplo es del 2019, esto deberia dar "true" en el
        // presente.
        System.out.println("Has passed: " + scheduler.hasPassed(appointment));

        // Comprobamos si es una cita de tarde (Tarea 3). La hora de
        // ejemplo es 13:45, que cae dentro del rango de tarde, asi
        // que deberia dar "true".
        System.out.println("Afternoon appointment: " + scheduler.isAfternoonAppointment(appointment));

        // Mostramos la descripcion amigable de la cita (Tarea 4).
        System.out.println(scheduler.getDescription(appointment));

        // Mostramos la fecha del aniversario del salon para el
        // año actual (Tarea 5).
        System.out.println("Anniversary date: " + scheduler.getAnniversaryDate());
    }
}