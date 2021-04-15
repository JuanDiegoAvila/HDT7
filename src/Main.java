import java.io.File;
import java.util.*;
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
            System.out.println("\t [ 1 ] Ingresar oración para traducir.");
            System.out.println("\t [ 2 ] Salir.");

            Scanner scan = new Scanner(System.in);

            try{
                System.out.print("\t Opcion -> ");
                opcion = scan.nextInt();

                if(opcion<3 && opcion>0) {
                    switch(opcion){
                        case 1 -> {
                            System.out.print("\n\t Ingrese la oracion que desea traducir.");
                            String oracion = scan.next();

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
