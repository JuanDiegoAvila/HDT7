import java.io.File;
import java.util.*;
/**
 * @author Juan Diego Avila Sagastume
 */
public class Main {
    public static void main(String[]args){

        //leer archivo y crear arbol.
        ArrayList<List<String>> diccionario = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("diccionario.txt"));
            int cont = 0;
            while (input.hasNextLine()) {
                diccionario.add(Arrays.asList(input.nextLine().split(",")));
            }
        }catch (Exception ignored){

        }

        ArrayList<String> inglesOrdenado = new ArrayList<String>();
        ArrayList<String> francesOrdenado = new ArrayList<String>();
        ArrayList<String> espanolOrdenado = new ArrayList<String>();


        int veces = 0;
        do{
            ArrayList<String> temporal = new ArrayList<>();
            for (List<String> strings : diccionario) {
                temporal.add(strings.get(veces));
            }

            Collections.sort(temporal);

            switch(veces){
                case 0 -> { inglesOrdenado.addAll(temporal); }
                case 1 -> { francesOrdenado.addAll(temporal); }
                case 2 -> { espanolOrdenado.addAll(temporal); }
            }
            veces++;
        }while(veces<3);

        HashMap<Integer, String> Ingles = new HashMap<Integer, String>();
        HashMap<Integer, String> Frances = new HashMap<Integer, String>();
        HashMap<Integer, String> Espanol = new HashMap<Integer, String>();

        for(String palabra: inglesOrdenado){
            Ingles.put(inglesOrdenado.indexOf(palabra)+1,palabra);
        }
        for(String palabra: francesOrdenado){
            Frances.put(francesOrdenado.indexOf(palabra)+1,palabra);
        }
        for(String palabra: espanolOrdenado){
            Espanol.put(espanolOrdenado.indexOf(palabra)+1,palabra);
        }

    }
}
