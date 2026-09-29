import java.util.ArrayList;
import java.util.List;

public class LanguageList {

    // Guarda la lista de idiomas que Karl quiere aprender.
    // Usamos ArrayList porque necesitamos poder agregar y quitar
    // elementos facilmente. Es "final" porque la lista en si nunca
    // se va a reemplazar por otra (aunque su contenido si cambie),
    // y "private" porque solo esta clase deberia poder acceder
    // directamente a ella.
    private final List<String> languages = new ArrayList<>();

    // ================= TAREA 1: Comprobar si la lista de idiomas está vacía =================
    // Sirve para saber si Karl todavia no ha agregado ningun idioma.
    // El metodo isEmpty() ya viene incluido en List, asi que solo
    // lo reutilizamos.
    public boolean isEmpty() {
        return languages.isEmpty();
    }

    // ================= TAREA 2: Agregar un idioma a la lista =================
    // Sirve para que Karl pueda anotar un nuevo idioma que quiere aprender.
    // El metodo add() agrega el idioma al final de la lista.
    public void addLanguage(String language) {
        languages.add(language);
    }

    // ================= TAREA 3: Eliminar un idioma de la lista =================
    // Sirve para que Karl pueda quitar un idioma antiguo que ya
    // no le interesa aprender. remove() busca ese idioma exacto
    // en la lista y lo saca si lo encuentra.
    public void removeLanguage(String language) {
        languages.remove(language);
    }

    // ================= TAREA 4: Devolver el primer elemento de la lista =================
    // Sirve para ver cual fue el primer idioma que Karl agrego.
    // get(0) devuelve el elemento que esta en la posicion 0
    // (la primera posicion de la lista).
    public String firstLanguage() {
        return languages.get(0);
    }

    // ================= TAREA 5: Devolver cuántos idiomas hay en la lista =================
    // Sirve para saber cuantos idiomas tiene Karl anotados en total.
    // size() devuelve la cantidad de elementos que hay en la lista.
    public int count() {
        return languages.size();
    }

    // ================= TAREA 6: Determinar si un idioma está en la lista =================
    // Sirve para que Karl pueda verificar si ya tiene anotado
    // cierto idioma, sin tener que revisar la lista el mismo.
    // contains() busca el idioma y devuelve true si lo encuentra.
    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    // ================= TAREA 7: Determinar si la lista es interesante =================
    // Sirve para saber si la lista tiene algo de Java o Kotlin,
    // que segun el enunciado serian los idiomas mas "emocionantes"
    // para Karl. El "||" (or) hace que sea true si tiene CUALQUIERA
    // de los dos, sin necesidad de tener ambos.
    public boolean isExciting() {
        return containsLanguage("Java") || containsLanguage("Kotlin");
    }

    // Metodo principal: sirve para probar todas las funciones de
    // arriba y ver los resultados impresos en la consola.
    public static void main(String[] args) {
        LanguageList languageList = new LanguageList();

        // Al principio la lista no tiene idiomas, deberia decir true.
        System.out.println("Lista vacía: " + languageList.isEmpty());

        // Agregamos dos idiomas a la lista.
        languageList.addLanguage("Java");
        languageList.addLanguage("Kotlin");

        // Mostramos el primer idioma agregado (deberia ser "Java").
        System.out.println("Primer idioma: " + languageList.firstLanguage());

        // Mostramos cuantos idiomas hay en total (deberia ser 2).
        System.out.println("Cantidad: " + languageList.count());

        // Revisamos si la lista contiene "Kotlin" (deberia decir true).
        System.out.println("Contiene Kotlin: " + languageList.containsLanguage("Kotlin"));

        // Revisamos si la lista es "emocionante" segun Karl (deberia decir true).
        System.out.println("Lista emocionante: " + languageList.isExciting());

        // Eliminamos "Java" de la lista.
        languageList.removeLanguage("Java");

        // Como todavia queda "Kotlin", la lista NO deberia estar vacia (false).
        System.out.println("Java eliminado; lista vacía: " + languageList.isEmpty());
    }
}