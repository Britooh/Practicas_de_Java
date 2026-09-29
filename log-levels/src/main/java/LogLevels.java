public class LogLevels {

    // Esta función agarra una línea de log completa y se queda solo con el mensaje,
    // descartando la parte del nivel (como [ERROR] o [INFO]).
    // Ejemplo: si le pasás "[ERROR]: Stack overflow", te devuelve "Stack overflow".
    public static String message(String logLine) {
        // Primero le sacamos espacios de más al principio y al final, por si la línea
        // viene con espacios extra que no queremos que molesten después.
        String normalized = logLine.trim();

        // Buscamos dónde aparece "]:" porque ahí termina el nivel y empieza el mensaje real.
        // indexOf nos da la posición donde arranca ese texto dentro del string.
        int separatorIndex = normalized.indexOf("]:");

        // Si no encontramos "]:" en ningún lado, es que la línea no tiene el formato
        // que esperamos, así que devolvemos un string vacío en vez de romper todo.
        if (separatorIndex == -1) {
            return "";
        }

        // Nos quedamos con todo lo que viene después de "]:" (por eso el +2, para saltarnos
        // esos dos caracteres) y le sacamos espacios sobrantes al resultado.
        return normalized.substring(separatorIndex + 2).trim();
    }

    // Esta función hace lo contrario: se queda solo con el nivel del log (ERROR, INFO, etc.),
    // ignorando el mensaje. Lo devuelve en minúscula para que sea más fácil de comparar después.
    public static String logLevel(String logLine) {
        String normalized = logLine.trim();

        // Buscamos el corchete que abre "[" y le sumamos 1, porque queremos empezar
        // a leer justo DESPUÉS del corchete, no desde el corchete mismo.
        int start = normalized.indexOf('[') + 1;

        // Buscamos el corchete que cierra "]", que marca dónde termina el nivel.
        int end = normalized.indexOf(']');

        // Si no encontramos el corchete de apertura (indexOf devuelve -1, y +1 nos daría 0,
        // que no es válido aqui) o si el cierre viene antes que el inicio, algo está mal
        // formado en la línea, así que devolvemos vacío para no explotar con un error.
        if (start <= 0 || end < start) {
            return "";
        }

        // Cortamos el string justo entre esos dos corchetes y lo pasamos a minúscula.
        return normalized.substring(start, end).toLowerCase();
    }

    // Esta función junta las dos anteriores para armar un formato distinto:
    // en vez de "[ERROR]: Stack overflow" arma algo como "Stack overflow (error)".
    // Básicamente cambia el orden y le da otra pinta al mismo dato.
    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }

    // Acá probamos todo con un ejemplo concreto, para ver con nuestros propios ojos
    // que cada función devuelve lo que esperamos antes de confiar en ellas en otro lado.
    public static void main(String[] args) {
        String logLine = "[ERROR]: Stack overflow";
        System.out.println(message(logLine));    // Stack overflow
        System.out.println(logLevel(logLine));   // error
        System.out.println(reformat(logLine));   // Stack overflow (error)
    }
}