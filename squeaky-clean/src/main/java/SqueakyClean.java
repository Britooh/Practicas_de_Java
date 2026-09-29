import java.util.HashMap;
import java.util.Map;

class SqueakyClean {

    // Mapa que asocia cada caracter "leetspeak" (numero) con la letra normal
    // que representa. Se usa en el Task 3 para "traducir" el leetspeak.
    private static final Map<Character, Character> LEETSPEAK_MAP = new HashMap<>();
    static {
        LEETSPEAK_MAP.put('1', 'l'); // el "1" se parece a la "l"
        LEETSPEAK_MAP.put('3', 'e'); // el "3" se parece a la "e"
        LEETSPEAK_MAP.put('4', 'a'); // el "4" se parece a la "a"
        LEETSPEAK_MAP.put('0', 'o'); // el "0" se parece a la "o"
        LEETSPEAK_MAP.put('5', 's'); // el "5" se parece a la "s"
        LEETSPEAK_MAP.put('7', 't'); // el "7" se parece a la "t"
    }

    static String clean(String identifier) {
        String result = identifier;

        // ----- TASK 1: Reemplazar espacios por guiones bajos -----
        // Un nombre SqueakyClean valido no puede contener espacios,
        // asi que cualquier espacio " " se convierte en "_".
        result = replaceSpacesWithUnderscores(result);

        // ----- TASK 2: Convertir kebab-case a camelCase -----
        // kebab-case usa guiones "-" para separar palabras (ej: "convert-to-string").
        // camelCase elimina el guion y pone en mayuscula la letra siguiente
        // (ej: "convertToString").
        result = kebabToCamelCase(result);

        // ----- TASK 3: Convertir leetspeak a texto normal -----
        // Leetspeak usa numeros que se parecen visualmente a letras
        // (ej: "3" en vez de "e"). Aqui los traducimos de vuelta a letras.
        result = leetspeakToNormalText(result);

        // ----- TASK 4: Eliminar caracteres que no sean letras -----
        // Al final, un nombre SqueakyClean valido solo puede tener
        // letras y guiones bajos "_". Cualquier otro caracter
        // (numeros que no eran leetspeak, simbolos, etc.) se elimina.
        result = omitNonLetterCharacters(result);

        return result;
    }

    // TASK 1
    // Recorre el string y sustituye cada espacio ' ' por un guion bajo '_'.
    private static String replaceSpacesWithUnderscores(String input) {
        return input.replace(' ', '_');
    }

    // TASK 2
    // Busca patrones "-x" (guion seguido de una letra) y los reemplaza
    // por la letra en mayuscula, eliminando el guion.
    // Ejemplo: "my-variable-name" -> "myVariableName"
    private static String kebabToCamelCase(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '-' && i + 1 < input.length()) {
                // Si encontramos un guion, saltamos al siguiente caracter
                // y lo agregamos en mayuscula (ignorando el guion).
                char nextChar = input.charAt(i + 1);
                sb.append(Character.toUpperCase(nextChar));
                i++; // avanzamos un caracter extra porque ya lo consumimos
            } else {
                // Si no es un guion, lo agregamos tal cual.
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }

    // TASK 3
    // Recorre cada caracter; si esta en el mapa LEETSPEAK_MAP, lo reemplaza
    // por su letra equivalente. Si no, lo deja igual.
    private static String leetspeakToNormalText(String input) {
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (LEETSPEAK_MAP.containsKey(c)) {
                sb.append(LEETSPEAK_MAP.get(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // TASK 4
    // Elimina cualquier caracter que no sea una letra ni un guion bajo.
    // Character.isLetter() detecta letras (mayusculas y minusculas);
    // ademas conservamos '_' porque es un caracter valido en el nombre.
    private static String omitNonLetterCharacters(String input) {
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c) || c == '_') {
                sb.append(c);
            }
            // Si no cumple la condicion, simplemente no se agrega (se omite).
        }

        return sb.toString();
    }
}
