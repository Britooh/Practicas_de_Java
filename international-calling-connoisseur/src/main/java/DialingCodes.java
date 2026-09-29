import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    // Guarda el diccionario de codigos de marcacion: la clave (Integer)
    // es el codigo de marcacion (ej: 1, 44), y el valor (String) es
    // el nombre del pais al que pertenece ese codigo. Usamos HashMap
    // porque necesitamos buscar un pais por su codigo de forma
    // rapida y directa. Es "final" porque el Map en si nunca se
    // reemplaza por otro (aunque su contenido si puede cambiar).
    private final Map<Integer, String> codes = new HashMap<>();

    // ================= TAREA 1: Devolver los códigos en un mapa =================
    // Sirve para exponer el diccionario completo hacia afuera de la
    // clase, por si alguien necesita ver todos los codigos guardados
    // de una sola vez (por ejemplo, para imprimirlos todos).
    public Map<Integer, String> getCodes() {
        return codes;
    }

    // ================= TAREA 2: Agregar entradas al diccionario =================
    // Sirve para guardar (o reemplazar) la relacion entre un codigo
    // de marcacion y un pais. put() agrega la entrada si el codigo
    // no existia, o actualiza el pais si el codigo ya estaba usado.
    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    // ================= TAREA 3: Buscar el país de un código de marcación =================
    // Sirve para consultar rapidamente el nombre del pais al que
    // pertenece un codigo dado. get() busca la clave (code) en el
    // Map y devuelve su valor asociado (el pais), o null si el
    // codigo no existe en el diccionario.
    public String getCountry(Integer code) {
        return codes.get(code);
    }

    // ================= TAREA 4: No permitir duplicados =================
    // Sirve para agregar una entrada nueva al diccionario, pero
    // SOLO si ese codigo y ese pais todavia no existen por separado.
    // Esto evita, por ejemplo, que un mismo pais quede registrado
    // con dos codigos distintos, o que un codigo se sobreescriba
    // sin querer.
    public void addNewDialingCode(Integer code, String country) {
        // containsKey() revisa si el codigo ya existe como clave.
        // containsValue() revisa si el pais ya existe como valor.
        // Usamos "!" (no) en ambos, y "&&" (and) para exigir que
        // NINGUNO de los dos ya exista antes de agregar la entrada.
        if (!codes.containsKey(code) && !codes.containsValue(country)) {
            codes.put(code, country);
        }
        // Si alguno de los dos ya existia, no hacemos nada
        // (la entrada duplicada se ignora silenciosamente).
    }

    // ================= TAREA 5: Encontrar el código de marcación de un país =================
    // Sirve para hacer la busqueda "al reves" de getCountry(): dado
    // un nombre de pais, encontrar su codigo de marcacion. Un Map
    // normal no tiene un metodo directo para esto (solo busca rapido
    // por clave, no por valor), asi que hay que recorrerlo a mano.
    public Integer findDialingCode(String country) {
        // entrySet() sirve para recorrer el Map como una lista de
        // pares clave-valor (Map.Entry), en vez de solo claves o
        // solo valores por separado.
        for (Map.Entry<Integer, String> entry : codes.entrySet()) {
            // Comparamos el valor (pais) de cada entrada contra el
            // pais que estamos buscando.
            if (entry.getValue().equals(country)) {
                // Si coincide, devolvemos la clave (el codigo)
                // de esa entrada.
                return entry.getKey();
            }
        }
        // Si recorrimos todo el diccionario y no encontramos el
        // pais, devolvemos null para indicar que no existe.
        return null;
    }

    // ================= TAREA 6: Actualizar el código de marcación del país =================
    // Sirve para cambiarle el codigo de marcacion a un pais que ya
    // esta registrado, asegurandonos de eliminar primero su codigo
    // viejo (para que no queden dos entradas del mismo pais con
    // codigos distintos).
    public void updateCountryDialingCode(Integer code, String country) {
        // Buscamos si el pais ya tenia un codigo asignado antes,
        // reutilizando el metodo de la Tarea 5.
        Integer previousCode = findDialingCode(country);

        // Si encontramos un codigo anterior (no es null), lo
        // eliminamos del diccionario para no dejar un codigo
        // "huerfano" apuntando al mismo pais.
        if (previousCode != null) {
            codes.remove(previousCode);
        }

        // Finalmente, guardamos el pais con su codigo nuevo.
        codes.put(code, country);
    }

    // Metodo principal: sirve para probar todos los metodos de
    // arriba y ver los resultados impresos en consola.
    public static void main(String[] args) {
        DialingCodes dialingCodes = new DialingCodes();

        // Registramos Estados Unidos con el codigo 1.
        dialingCodes.setDialingCode(1, "United States");

        // Agregamos Reino Unido con el codigo 44, usando la version
        // que evita duplicados (Tarea 4).
        dialingCodes.addNewDialingCode(44, "United Kingdom");

        // Actualizamos el codigo de Reino Unido al 1 (Tarea 6).
        // Esto deberia eliminar el 44 viejo, y ademas sobreescribir
        // el "United States" que tenia el codigo 1, ya que put()
        // reemplaza el valor si la clave ya existia.
        dialingCodes.updateCountryDialingCode(1, "United Kingdom");

        // Mostramos el diccionario completo despues de todos los cambios.
        System.out.println(dialingCodes.getCodes());

        // Consultamos que pais tiene el codigo 1 (deberia ser
        // "United Kingdom" despues de la actualizacion).
        System.out.println("Country for code 1: " + dialingCodes.getCountry(1));

        // Consultamos el codigo de Reino Unido (deberia ser 1).
        System.out.println("Code for United Kingdom: " + dialingCodes.findDialingCode("United Kingdom"));
    }
}