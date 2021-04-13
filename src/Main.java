import java.io.File;
import java.util.*;
/**
 * @author Juan Diego Avila Sagastume
 */
public class Main {
    public static void main(String[]args){

        //leer archivo y crear arbol.
        ArrayList<String[]> diccionario = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("diccionario.txt"));
            int cont = 0;
            while (input.hasNextLine()) {
                diccionario.add(input.nextLine().split(","));
            }
        }catch (Exception ignored){

        }

        for(String[] i : diccionario){
            System.out.println(Arrays.toString(i));
        }
        //recibir la oracion.
        //revisar en los tres arboles dependiendo del idioma de la oracion - In-order.
        //preguntar al lenguaje que se desea traducir.
        //traducirlo, si no esta en el diccionario encerrar palabra en **.

    }
}
