/*
 */
package actv6ej2;

import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import mapa.*;

/**
 *
 * @author kingo
 */
public class Ej2ApB {

    public static void main(String[] args) {
        //System.out.println(extensionAbreviaturas("estoy atte. estudiando en la. Bibl.", "es"));
        Polinomio instance = new Polinomio();
        instance.añadirTermino(2, 6);
        instance.añadirTermino(2, -6);
        System.out.println(instance.coeficiente(2));
    }

    /**
     * htAbbreviations. Mapa constante que contiene para cada idioma, su
     * diccionario de abreviaturas correspondiente. el cual es otro Mapa que
     * contiene para cada abreviatura su extensión El Mapa se crea a partir de
     * ficheros JSON, uno para cada idioma
     */
    private static final Map<String, Map<String, String>> htAbbreviations = new HashMap<>();

    static {
        for (String i : new String[]{"abbrev.es.json",
            "abbrev.en.json",
            "abbrev.fr.json"
        }) {
            String lang = i.substring(7, 9).toUpperCase();
            InputStream is = Ej2ApB.class.getResourceAsStream(i);
            JsonReader rdr = Json.createReader(is);
            JsonObject jsonObject = rdr.readObject();
            rdr.close();
            Map<String, String> dict = new HashMap<>();
            jsonObject.keySet().forEach((abbrev) -> {
                dict.insertar(abbrev, jsonObject.getString(abbrev));
            });
            htAbbreviations.insertar(lang, dict);
        }
    }

    /**
     * traduccionAbreviaturas. Este método devuelve un nuevo texto con las
     * abreviaturas extendidas según su idioma correspondiente.
     *
     * @param textoExtender
     * @param idioma (limitado a Español (ES), Inglés (EN), Francés (FR))
     * @return Texto traducido
     */
    public static String extensionAbreviaturas(String textoExtender, String idioma) {
        idioma = idioma.toUpperCase();
        Map<String, String> mapaAbbr = htAbbreviations.get(idioma);
        if (mapaAbbr == null) {
            return "Yo no hablo " + idioma;
        }

        String[] partes = textoExtender.split(" ");
        StringBuilder toret = new StringBuilder();
        for (String p : partes) {
            String completo = mapaAbbr.get(p);
            toret.append(completo == null ? p : completo).append(" ");
        }
        return toret.toString();
    }

}
