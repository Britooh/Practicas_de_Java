public class GameMaster {

    // ================= TAREA 1: Describe un personaje =================
    // Sirve para generar la descripcion de un personaje del juego,
    // mostrando su nivel, su clase (Wizard, Warrior, etc.) y sus
    // puntos de vida actuales. Esto es lo primero que un jugador
    // necesita saber sobre su propio personaje.
    public String describe(Character character) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() +
                " with " + character.getHitPoints() + " hit points.";
    }

    // ================= TAREA 2: Describe un destino =================
    // Sirve para generar la descripcion de un lugar (pueblo, ciudad,
    // etc.) que los jugadores estan visitando, incluyendo su nombre
    // y cuantos habitantes tiene. Esto ayuda a darle vida al mundo
    // del juego, como menciona el enunciado.
    public String describe(Destination destination) {
        return "You've arrived at " + destination.getName() + ", which has " +
                destination.getInhabitants() + " inhabitants.";
    }

    // ================= TAREA 3: Describe el método de viaje =================
    // Sirve para generar la descripcion de COMO estan viajando los
    // personajes hacia su destino (a caballo o caminando).
    public String describe(TravelMethod travelMethod) {
        // Comparamos el metodo de viaje contra el valor HORSEBACK
        // del enum TravelMethod, para saber que frase usar.
        if (travelMethod == TravelMethod.HORSEBACK) {
            return "You're traveling to your destination on horseback.";
        }
        // Si no es a caballo, asumimos que es caminando.
        return "You're traveling to your destination by walking.";
    }

    // ================= TAREA 4: Describe un personaje que viaja a un destino =================
    // Sirve para combinar las tres descripciones anteriores (personaje,
    // metodo de viaje y destino) en un solo mensaje completo, cuando
    // SI sabemos exactamente como esta viajando el personaje.
    // Esto es un ejemplo de "sobrecarga de metodos" (overloading):
    // varios metodos con el mismo nombre "describe", pero que reciben
    // distinta cantidad o tipo de parametros.
    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        // Reutilizamos los tres metodos de arriba en vez de repetir
        // la logica de armado de texto, y los unimos con espacios.
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    // ================= TAREA 5: Describe un personaje que viaja a un destino sin especificar el método de viaje =================
    // Sirve para el caso en que NO nos importa (o no sabemos) como
    // esta viajando el personaje, y simplemente asumimos que va
    // caminando por defecto (TravelMethod.WALKING).
    // Este metodo reutiliza el de la Tarea 4 en vez de repetir la
    // logica de nuevo, solo que fija el metodo de viaje por defecto.
    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }

    // Metodo principal: sirve para probar todos los metodos
    // "describe" de arriba y ver los resultados impresos en consola.
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();

        // Creamos un personaje de ejemplo: un mago de nivel 4
        // con 28 puntos de vida.
        Character character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(4);
        character.setHitPoints(28);

        // Creamos un destino de ejemplo: el pueblo de Muros,
        // con 732 habitantes.
        Destination destination = new Destination();
        destination.setName("Muros");
        destination.setInhabitants(732);

        // Probamos cada version de "describe" por separado
        // para confirmar que cada una arma bien su propio texto.
        System.out.println(gameMaster.describe(character));
        System.out.println(gameMaster.describe(destination));
        System.out.println(gameMaster.describe(TravelMethod.HORSEBACK));

        // Probamos la version combinada que recibe los tres datos
        // juntos (Tarea 4).
        System.out.println(gameMaster.describe(character, destination, TravelMethod.HORSEBACK));

        // Probamos la version que omite el metodo de viaje
        // (Tarea 5), esperando que use "walking" por defecto.
        System.out.println(gameMaster.describe(character, destination));
    }
}