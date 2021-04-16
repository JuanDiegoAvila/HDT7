import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * @author Juan Diego Avila Sagastume
 */
public class Main {
    public static void main(String[]args){

        //leer archivo y crear arbol.
        ArrayList<List<String>> palabras = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("diccionario.txt"));
            int cont = 0;
            while (input.hasNextLine()) {
                palabras.add(Arrays.asList(input.nextLine().split(",")));
            }
        }catch (Exception ignored){ }

        BinarySearchTree<ComparableAssociation<String, List<String>>> Ingles = new BinarySearchTree<ComparableAssociation<String, List<String>>>();
        BinarySearchTree<ComparableAssociation<String, List<String>>> Frances = new BinarySearchTree<ComparableAssociation<String, List<String>>>();
        BinarySearchTree<ComparableAssociation<String, List<String>>> Espanol = new BinarySearchTree<ComparableAssociation<String, List<String>>>();

        for(List<String> l : palabras){
            ArrayList<String> valoresIn = new ArrayList<String>(Arrays.asList(l.get(1),l.get(2)));
            ComparableAssociation<String, List<String>> ing = new ComparableAssociation<>(l.get(0), valoresIn);

            ArrayList<String> valoresFr = new ArrayList<String>(Arrays.asList(l.get(0),l.get(1)));
            ComparableAssociation<String, List<String>> fr = new ComparableAssociation<>(l.get(2), valoresFr);

            ArrayList<String> valoresEs = new ArrayList<String>(Arrays.asList(l.get(0),l.get(2)));
            ComparableAssociation<String, List<String>> es = new ComparableAssociation<>(l.get(1), valoresEs);

            Ingles.add(ing);
            Frances.add(fr);
            Espanol.add(es);
        }

        ArrayList< ComparableAssociation<String, List<String>>> InglesInOrder = new ArrayList<>();
        InOrder<ComparableAssociation<String, List<String>>> iteratorI = Ingles.iterator();
        for(int i = 0; i<Ingles.size(); i++){
            if(Ingles.iterator().hasNext()){
                InglesInOrder.add(iteratorI.next());
            }
        }
        System.out.println("\n Palabras ordenadas en ingles : ");
        System.out.println("\t"+InglesInOrder.toString());

        ArrayList< ComparableAssociation<String, List<String>>> FrancesInOrder = new ArrayList<>();
        InOrder<ComparableAssociation<String, List<String>>> iteratorF = Frances.iterator();
        for(int i = 0; i<Frances.size(); i++){
            if(Ingles.iterator().hasNext()){
                FrancesInOrder.add(iteratorF.next());
            }
        }

        System.out.println("\n Palabras ordenadas en frances : ");
        System.out.println("\t"+FrancesInOrder.toString());

        ArrayList< ComparableAssociation<String, List<String>>> EspanolInOrder = new ArrayList<>();
        InOrder<ComparableAssociation<String, List<String>>> iteratorE = Espanol.iterator();
        for(int i = 0; i<Espanol.size(); i++){
            if(Ingles.iterator().hasNext()){
                EspanolInOrder.add(iteratorE.next());
            }
        }

        System.out.println("\n Palabras ordenadas en español : ");
        System.out.println("\t"+EspanolInOrder.toString());



        int opcion = 0;

        Outerloop:
        while(true){
            System.out.println("\n Bienvenido al menu principal, elija la opcion que desea realizar : ");
            System.out.println("\t [ 1 ] Traducir un texto.");
            System.out.println("\t [ 2 ] Salir.");

            Scanner scan = new Scanner(System.in);

            try{
                System.out.print("\t Opcion -> ");
                opcion = scan.nextInt();

                if(opcion<3 && opcion>0) {
                    scan.nextLine();
                    switch(opcion){
                        case 1 -> {
                            System.out.print("\n\t Ingrese el path del texto -> ");
                            String path = scan.nextLine();
                            ArrayList<String[]> oraciones = new ArrayList<>();
                            ArrayList<String> traducidos = new ArrayList<>();

                            try {
                                Scanner input = new Scanner(new File(path));
                                int cont = 0;
                                while (input.hasNextLine()) {
                                    oraciones.add(input.nextLine().split(" "));
                                }
                            } catch (Exception ignored) {
                            }

                            System.out.println("El archivo se leyó correctamente...");

                            for (String[] oracion : oraciones) {



                                System.out.println("\n Oracion a traducir :");
                                String original = String.join(" ",oracion);
                                System.out.println("\t "+ original);

                                System.out.print("\n\t Ingrese el idioma de origen [ingles,español,frances] -> ");

                                String origen = scan.nextLine();
                                origen = origen.toLowerCase(Locale.ROOT);

                                String destino = "";

                                LanguageLoop:
                                while (true) {
                                    switch (origen) {
                                        case "español" -> {
                                            System.out.print("\n\t Ingrese el idioma de destino [ingles,frances] -> ");
                                            destino = scan.nextLine();
                                            destino = destino.toLowerCase(Locale.ROOT);
                                            if (destino.equals("ingles") || destino.equals("frances")) {
                                                break LanguageLoop;
                                            } else {
                                                System.out.println("\nIngrese un idioma permitido ! ! !");
                                            }
                                        }
                                        case "ingles" -> {
                                            System.out.print("\n\t Ingrese el idioma de destino [español,frances] -> ");
                                            destino = scan.nextLine();
                                            destino = destino.toLowerCase(Locale.ROOT);
                                            if (destino.equals("español") || destino.equals("frances")) {
                                                break LanguageLoop;
                                            } else {
                                                System.out.println("\nIngrese un idioma permitido ! ! !");
                                            }
                                        }
                                        case "frances" -> {
                                            System.out.print("\n\t Ingrese el idioma de destino [ingles,español] -> ");
                                            destino = scan.nextLine();
                                            destino = destino.toLowerCase(Locale.ROOT);
                                            if (destino.equals("ingles") || destino.equals("español")) {
                                                break LanguageLoop;
                                            } else {
                                                System.out.println("\nIngrese un idioma permitido ! ! !");
                                            }
                                        }
                                    }
                                }


                                //Al tener el lenguaje de destino y de origen, inicia la traduccion.

                                StringBuilder traducido = new StringBuilder();

                                switch (origen) {
                                    case "ingles" -> {

                                        for (String p : oracion) {
                                            //recorrer cada palabra
                                            p = p.toLowerCase(Locale.ROOT);
                                            p = p.replaceAll(" ","");

                                            Boolean existe = false;
                                            for (int i = 0; i < InglesInOrder.size(); i++) {
                                                if ("frances".equals(destino)) {
                                                    if (Frances.get(FrancesInOrder.get(i)).getValue().get(0).equals(p)) {
                                                        traducido.append(Frances.get(FrancesInOrder.get(i)).getKey()).append(" ");
                                                        existe = true;
                                                    }
                                                } else if ("español".equals(destino)) {
                                                    if (Espanol.get(EspanolInOrder.get(i)).getValue().get(0).equals(p)) {
                                                        traducido.append(Espanol.get(EspanolInOrder.get(i)).getKey()).append(" ");
                                                        existe = true;
                                                    }

                                                }
                                            }

                                            if (!existe) {
                                                traducido.append("*").append(p).append("*").append(" ");
                                            }
                                        }
                                        traducidos.add(traducido.toString());

                                    }
                                    case "español" -> {

                                        for (String p : oracion) {
                                            //recorrer cada palabra
                                            p = p.toLowerCase(Locale.ROOT);

                                            Boolean existe = false;
                                            for (int i = 0; i < EspanolInOrder.size(); i++) {
                                                if ("frances".equals(destino)) {
                                                    if (Frances.get(FrancesInOrder.get(i)).getValue().get(1).equals(p)) {
                                                        traducido.append(Frances.get(FrancesInOrder.get(i)).getKey()).append(" ");
                                                        existe = true;
                                                    }
                                                } else if ("ingles".equals(destino)) {
                                                    if (Ingles.get(InglesInOrder.get(i)).getValue().get(0).equals(p)) {
                                                        traducido.append(Ingles.get(InglesInOrder.get(i)).getKey()).append(" ");
                                                        existe = true;
                                                    }

                                                }

                                            }

                                            if (!existe) {
                                                traducido.append("*").append(p).append("*").append(" ");
                                            }
                                        }
                                        traducidos.add(traducido.toString());

                                    }
                                    case "frances" -> {

                                        for (String p : oracion) {
                                            //recorrer cada palabra
                                            p = p.toLowerCase(Locale.ROOT);
                                            Boolean existe = false;
                                            for (int i = 0; i < FrancesInOrder.size(); i++) {
                                                if ("español".equals(destino)) {
                                                    if (Espanol.get(EspanolInOrder.get(i)).getValue().get(1).equals(p)) {
                                                        traducido.append(Espanol.get(EspanolInOrder.get(i)).getKey()).append(" ");
                                                        existe = true;
                                                    }
                                                } else if ("ingles".equals(destino)) {
                                                    if (Ingles.get(InglesInOrder.get(i)).getValue().get(1).equals(p)) {
                                                        traducido.append(Ingles.get(InglesInOrder.get(i)).getKey()).append(" ");
                                                        existe = true;
                                                    }

                                                }

                                            }

                                            if (!existe) {
                                                traducido.append("*").append(p).append("*").append(" ");
                                            }
                                        }
                                        traducidos.add(traducido.toString());

                                    }
                                }


                                System.out.println("\n Oracion traducida :");
                                System.out.println("\t "+traducidos.get(oraciones.indexOf(oracion)));
                                System.out.println("\n -----------------------------------------------------------------------");
                            }




                            for(int i = 0; i<traducidos.size();i++){


                            }

                        }
                        case 2 -> { break Outerloop; }
                    }
                }
                else{
                    System.out.println("\nIngrese valores entre 1 y 2 ! ! !");
                }
            }catch(Exception e){
                System.out.println("\n Ingese valores numericos ! ! !");
            }
        }




    }
}
