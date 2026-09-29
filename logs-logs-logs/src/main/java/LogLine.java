public class LogLine {
    // Nivel reconocido y mensaje extraido de la linea original.
    private final LogLevel logLevel;
    private final String message;

    // Analiza el codigo entre corchetes y conserva el texto despues de "]: ".
    public LogLine(String logLine) {
        String code = logLine.substring(1, 4);
        this.logLevel = LogLevel.fromCode(code);
        this.message = logLine.substring(7);
    }

    // Devuelve el nivel ya analizado al crear este objeto.
    public LogLevel getLogLevel() {
        return logLevel;
    }

    // Forma la linea corta con el numero del nivel, dos puntos y el mensaje.
    public String getOutputForShortLog() {
        return logLevel.getShortCode() + ":" + message;
    }

    // Punto de entrada para ejecutar un ejemplo desde la terminal.
    public static void main(String[] args) {
        LogLine logLine = new LogLine("[ERR]: Stack Overflow");
        System.out.println(logLine.getLogLevel());
        System.out.println(logLine.getOutputForShortLog());
    }
}
