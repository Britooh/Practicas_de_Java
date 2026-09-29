import java.util.Arrays;

// Esta clase lleva el registro de cuántos pájaros se vieron cada día,
// como si fuera un cuadernito donde anotás un número por día de observación.
class BirdWatcher {

    // Acá guardamos los datos: un array donde cada posición representa un día,
    // y el número en esa posición es cuántos pájaros se vieron ese día.
    // Es "final" porque una vez que se crea el objeto, no vamos a reemplazar
    // el array completo por otro, solo vamos a modificar sus valores internos.
    private final int[] birdsPerDay;

    // El constructor recibe el array de datos y lo guarda.
    // Usamos .clone() en vez de guardar el array tal cual porque así hacemos
    // una copia independiente: si alguien modifica el array original desde afuera
    // después de crear el objeto, eso no nos va a afectar por accidente.
    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    // Esta función devuelve datos de ejemplo, como si fuera la semana pasada
    // ya registrada: 7 números, uno por cada día de la semana.
    // Es "static" porque no depende de ningún objeto en particular, es un dato fijo
    // que cualquiera puede pedir sin necesidad de tener un BirdWatcher ya creado.
    public static int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    // Devuelve cuántos pájaros se vieron HOY, asumiendo que "hoy" es siempre
    // el último día guardado en el array (la última posición).
    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    // Suma 1 al conteo de hoy. Se usa, por ejemplo, cuando ves un pájaro nuevo
    // en el momento y querés actualizar el número sin tener que recalcular todo.
    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    // Revisa si hubo algún día en el que NO se vio ni un solo pájaro (un día con un 0).
    // Recorremos todos los días uno por uno, y apenas encontramos un 0,
    // ya sabemos la respuesta y cortamos ahí mismo sin seguir revisando el resto.
    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay) {
            if (birds == 0) {
                return true;
            }
        }
        // Si terminamos de recorrer todo y nunca encontramos un 0,
        // significa que todos los días hubo al menos un pájaro.
        return false;
    }

    // Suma cuántos pájaros se vieron en total durante los primeros "numberOfDays" días.
    // Por ejemplo, si le pasás 3, suma lo que se vio el día 1, día 2 y día 3.
    public int getCountForFirstDays(int numberOfDays) {
        // Por seguridad, si alguien pide más días de los que realmente tenemos
        // guardados, nos quedamos con la cantidad real de días disponibles
        // en vez de intentar leer posiciones que no existen (y explotar el programa).
        int daysToCount = Math.min(numberOfDays, birdsPerDay.length);
        int total = 0;

        for (int i = 0; i < daysToCount; i++) {
            total += birdsPerDay[i];
        }

        return total;
    }

    // Cuenta cuántos días fueron "ocupados", entendiendo como ocupado un día
    // donde se vieron 5 pájaros o más. Es útil para saber, por ejemplo,
    // cuántos días valió la pena salir a observar.
    public int getBusyDays() {
        int busyDays = 0;

        for (int birds : birdsPerDay) {
            if (birds >= 5) {
                busyDays++;
            }
        }

        return busyDays;
    }

    // Acá probamos todo junto, simulando el uso real de la clase paso a paso
    // para ver cómo van cambiando los datos y qué devuelve cada función.
    public static void main(String[] args) {
        // Traemos los datos de ejemplo de la semana pasada.
        int[] lastWeek = getLastWeek();

        // Creamos un BirdWatcher con esos datos (se guarda una copia interna, como vimos arriba).
        BirdWatcher birdWatcher = new BirdWatcher(lastWeek);

        // Arrays.toString convierte el array en un texto legible tipo [0, 2, 5, 3, 7, 8, 4],
        // porque si imprimís un array directamente con println, te muestra algo
        // como una dirección de memoria rara en vez de los números.
        System.out.println("Last week: " + Arrays.toString(lastWeek));

        // El último día de la semana (posición 6) tiene un 4, entonces esto imprime 4.
        System.out.println("Today's count: " + birdWatcher.getToday());

        // Sumamos 1 al conteo de hoy: el 4 pasa a ser 5.
        birdWatcher.incrementTodaysCount();

        // Mostramos el array actualizado para confirmar que el último número cambió.
        System.out.println("After increment: " + Arrays.toString(birdWatcher.birdsPerDay));

        // Como el primer día tiene un 0, esto va a imprimir true.
        System.out.println("Any day without birds? " + birdWatcher.hasDayWithoutBirds());

        // Suma los primeros 3 días: 0 + 2 + 5 = 7
        System.out.println("Visits in first 3 days: " + birdWatcher.getCountForFirstDays(3));

        // Cuenta cuántos días tuvieron 5 o más pájaros. Con el incremento ya aplicado,
        // los días con 5+ son: día 3 (5), día 5 (7), día 6 (8) y ahora también el día 7 (5).
        System.out.println("Busy days: " + birdWatcher.getBusyDays());
    }
}