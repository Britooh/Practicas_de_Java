public enum LogLevel {
    // UNKNOWN representa cualquier codigo que no este en la lista conocida.
    UNKNOWN("", 0),
    // Cada nivel asocia la abreviatura del log con su numero en el formato corto.
    TRACE("TRC", 1),
    DEBUG("DBG", 2),
    INFO("INF", 4),
    WARNING("WRN", 5),
    ERROR("ERR", 6),
    FATAL("FTL", 42);

    // Abreviatura que aparece entre corchetes en la linea original.
    private final String code;
    // Numero que identifica este nivel en la salida corta.
    private final int shortCode;

    // Guarda los dos valores asociados a cada constante del enum.
    LogLevel(String code, int shortCode) {
        this.code = code;
        this.shortCode = shortCode;
    }

    // Busca la abreviatura y devuelve UNKNOWN cuando no hay coincidencia.
    public static LogLevel fromCode(String code) {
        for (LogLevel level : values()) {
            if (level.code.equals(code)) {
                return level;
            }
        }
        return UNKNOWN;
    }

    // Entrega el numero usado al convertir una linea al formato corto.
    public int getShortCode() {
        return shortCode;
    }
}
