import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void locate() {
        BinaryTree<String> izq = new BinaryTree<String>("Izquierda");
        BinaryTree<String> der = new BinaryTree<String>("Derecha");
        BinaryTree<String> raiz = new BinaryTree<String>("Raiz",der,izq);

       BinarySearchTree<String> buscador = new BinarySearchTree<String>();
       BinaryTree<String> resultado = buscador.locate(raiz,"Izquierda");

        assertEquals(resultado.value(), "Izquierda");
    }

    @org.junit.jupiter.api.Test
    void add() {
        BinarySearchTree<String> test = new BinarySearchTree<String>();
        test.add("Valor esperado");
        //Regresara verdadero si el arbol ahora si contiene el valor.
        assertTrue(test.contains("Valor esperado"));
    }
}