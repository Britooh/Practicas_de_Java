class Fighter {

    // Metodo main() sirve como punto de entrada del programa,
    // aqui probamos que las clases Warrior y Wizard funcionen
    // como esperamos, viendo los resultados impresos en consola.
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        System.out.println(warrior);
        System.out.println("Vulnerable: " + warrior.isVulnerable());
        System.out.println("Daño del guerrero contra el mago: " + warrior.getDamagePoints(wizard));

        System.out.println(wizard);
        System.out.println("Vulnerable antes de preparar: " + wizard.isVulnerable());
        wizard.prepareSpell();
        System.out.println("Vulnerable después de preparar: " + wizard.isVulnerable());
        System.out.println("Daño del mago contra el guerrero: " + wizard.getDamagePoints(warrior));
    }

    // Comportamiento por defecto de CUALQUIER luchador: por defecto
    // se considera vulnerable, a menos que una subclase (Warrior,
    // Wizard) lo sobreescriba con su propia regla.
    boolean isVulnerable() {
        return true;
    }

    // Comportamiento por defecto de daño: sirve como valor base
    // que las subclases van a reemplazar con su propia formula.
    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

// ================= TASK 1: Create the Warrior class =================
// "extends Fighter" sirve para decir que Warrior ES UN Fighter,
// heredando su comportamiento base y pudiendo sobreescribir
// lo que sea distinto para este tipo de luchador.
class Warrior extends Fighter {

    // ================= TASK 2: Describe a Warrior =================
    // Sirve para identificar en consola que este objeto es
    // especificamente un guerrero (util al hacer System.out.println).
    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    // ================= TASK 3: Make Warriors invulnerable =================
    // Sobreescribimos isVulnerable() porque, segun las reglas,
    // un guerrero NUNCA es vulnerable, sin importar nada mas.
    @Override
    boolean isVulnerable() {
        return false;
    }

    // ================= TAREA 4: Calcula los puntos de daño de un guerrero =================
    // Sirve para calcular cuanto daño hace el guerrero, dependiendo
    // de si el luchador al que ataca es vulnerable o no.
    @Override
    int getDamagePoints(Fighter fighter) {
        // Operador ternario: es un "if/else" resumido en una linea.
        // Si fighter.isVulnerable() es true, el resultado es 10;
        // si es false, el resultado es 6.
        return fighter.isVulnerable() ? 10 : 6;
    }
}

// ================= TAREA 5: Crea la clase de asistente (Mago) =================
// Igual que Warrior, hereda de Fighter con "extends" para reutilizar
// su comportamiento base y sobreescribir lo que sea propio de un mago.
class Wizard extends Fighter {

    // ================= TAREA 6: Describe un mago =================
    // Esta variable sirve para "describir" el estado propio de un mago:
    // si ya preparo o no un hechizo con antelacion. Es "private" porque
    // solo el propio mago deberia poder cambiar este dato directamente.
    private boolean hasPreparedSpell;

    // Sirve para identificar en consola que este objeto es
    // especificamente un mago (util al hacer System.out.println).
    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    // ================= TAREA 7: Permitir que los magos preparen un hechizo =================
    // Sirve para que, desde fuera de la clase, se le pueda avisar
    // al mago que ya preparo su hechizo con antelacion.
    void prepareSpell() {
        hasPreparedSpell = true;
    }

    // Sobreescribimos isVulnerable() porque en un mago la vulnerabilidad
    // depende de si preparo un hechizo o no (a diferencia del guerrero,
    // que siempre es igual).
    @Override
    boolean isVulnerable() {
        // El "!" invierte el valor: si hasPreparedSpell es true,
        // esto devuelve false (no vulnerable), y viceversa.
        return !hasPreparedSpell;
    }

    // ================= TAREA 8: Calcula los puntos de daño de un asistente =================
    // Sirve para calcular cuanto daño hace el mago, dependiendo
    // de si preparo un hechizo con antelacion o no.
    @Override
    int getDamagePoints(Fighter fighter) {
        // Si hasPreparedSpell es true, el resultado es 12;
        // si es false, el resultado es 3.
        return hasPreparedSpell ? 12 : 3;
    }
}