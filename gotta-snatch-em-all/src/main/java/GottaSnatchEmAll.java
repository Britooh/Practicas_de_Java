import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    // Metodo principal: sirve para probar todos los metodos de
    // abajo y ver los resultados impresos en consola.
    public static void main(String[] args) {
        // Creamos dos colecciones de ejemplo. Como usamos Set
        // (colecciones que NO permiten duplicados), "Newthree"
        // repetido dos veces solo va a contar una vez.
        Set<String> myCollection = newCollection(List.of("Newthree", "Newthree", "Scientuna"));
        Set<String> theirCollection = newCollection(List.of("Scientuna", "Garilord"));

        System.out.println("Mi coleccion: " + myCollection);
        System.out.println("Se agrego Veevee: " + addCard("Veevee", myCollection));
        System.out.println("Podemos intercambiar: " + canTrade(myCollection, theirCollection));
        System.out.println("Tarjetas comunes: " + commonCards(List.of(myCollection, theirCollection)));
        System.out.println("Todas las tarjetas: " + allCards(List.of(myCollection, theirCollection)));
    }

    // ================= TAREA 1: Inicia una colección =================
    // Sirve para crear una coleccion nueva a partir de una lista de
    // tarjetas. Usamos un HashSet (en vez de una List) porque un
    // Set automaticamente elimina los duplicados, y en este
    // ejercicio las tarjetas repetidas no importan.
    static Set<String> newCollection(List<String> cards) {
        // El constructor "new HashSet<>(cards)" sirve para copiar
        // todos los elementos de la lista dentro de un Set nuevo,
        // descartando cualquier repetido automaticamente.
        return new HashSet<>(cards);
    }

    // ================= TAREA 2: Haz crecer la colección =================
    // Sirve para agregar una tarjeta nueva a una coleccion existente.
    static boolean addCard(String card, Set<String> collection) {
        // add() intenta agregar la tarjeta al Set. Devuelve "true"
        // si la tarjeta SI se agrego (porque no estaba antes), y
        // "false" si la tarjeta ya estaba en la coleccion (porque
        // un Set no permite duplicados).
        return collection.add(card);
    }

    // ================= TAREA 3: Empieza a intercambiar =================
    // Sirve para saber si dos personas pueden hacer un intercambio
    // interesante entre sus colecciones. La logica es: solo tiene
    // sentido intercambiar si NINGUNA de las dos colecciones ya
    // contiene TODAS las tarjetas de la otra (si ya la tuviera
    // completa, no ganaria nada intercambiando).
    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        // containsAll() revisa si una coleccion contiene absolutamente
        // todos los elementos de otra. Usamos "!" para invertir el
        // resultado: nos interesa que NO sea el caso.
        // El "&&" (and) exige que ambas condiciones se cumplan:
        // ni yo tengo todo lo suyo, ni el tiene todo lo mio.
        return !myCollection.containsAll(theirCollection) && !theirCollection.containsAll(myCollection);
    }

    // ================= TAREA 4: Identifica las tarjetas comunes =================
    // Sirve para encontrar que tarjetas tienen en comun TODAS las
    // colecciones de una lista (interseccion de conjuntos).
    static Set<String> commonCards(List<Set<String>> collections) {
        // Creamos un Set vacio donde vamos a ir guardando el resultado.
        Set<String> commonCards = new HashSet<>();

        // Si no hay ninguna coleccion, no hay nada en comun,
        // asi que devolvemos el Set vacio de una vez.
        if (collections.isEmpty()) {
            return commonCards;
        }

        // Empezamos copiando TODAS las tarjetas de la primera
        // coleccion como punto de partida.
        commonCards.addAll(collections.get(0));

        // Recorremos el resto de las colecciones (desde la segunda
        // en adelante, por eso subList(1, ...)) e ISl vamos "filtrando".
        for (Set<String> collection : collections.subList(1, collections.size())) {
            // retainAll() sirve para quedarnos SOLO con los elementos
            // que tambien esten en "collection", eliminando de
            // commonCards cualquier tarjeta que no se repita en todas.
            commonCards.retainAll(collection);
        }

        // Al final, commonCards solo tiene las tarjetas que
        // aparecian en TODAS las colecciones de la lista.
        return commonCards;
    }

    // ================= TAREA 5: Todas las tarjetas =================
    // Sirve para juntar TODAS las tarjetas de TODAS las colecciones
    // en un solo Set, sin repetir ninguna (union de conjuntos).
    static Set<String> allCards(List<Set<String>> collections) {
        // Creamos un Set vacio para ir acumulando el resultado.
        Set<String> allCards = new HashSet<>();

        // Recorremos cada coleccion de la lista...
        for (Set<String> collection : collections) {
            // ...y agregamos todas sus tarjetas al resultado.
            // Como es un Set, si una tarjeta ya estaba agregada
            // (porque aparecia en otra coleccion tambien), no se
            // duplica.
            allCards.addAll(collection);
        }

        return allCards;
    }
}