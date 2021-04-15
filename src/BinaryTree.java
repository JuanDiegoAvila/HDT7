// Una implementacion de nodos para usar arboles binarios.
// (c) 1998, 2001 duane a. bailey

import java.lang.Math;
import java.util.Iterator;

/**
 *@author 2001 duane a. bailey
 *@author Juan Diego Avila Sagastume
 */
public class BinaryTree <E>{



    protected E val; //valor asociado al nodo.
    protected BinaryTree<E> padre; //padre del nodo.
    protected BinaryTree<E> izquierda, derecha; //hijos del nodo.

    /**
     * @post Constructor que genera un nodo vacio.
     * @return un nodo vacio.
     */
    public BinaryTree(){
        val = null;
        padre = null; izquierda = derecha = this;
    }

    /**
     * @post Regresa un arbol que hace referencia a dos arboles vacios.
     * @param value Un valor que sirve de referncia para el nodo.
     */
    public BinaryTree(E value){
        val = value;
        derecha = izquierda = new BinaryTree<E>();
        setLeft(izquierda);
        setRight(derecha);
    }


    /**
     * @post Regresa un arbol que hace referencia al valor y sus dos sub-arboles.
     * @param value Un valor que sera referenciado por el nodo.
     * @param derecha El arbol que sera el arbol izquierdo del nodo.
     * @param izquierda El arbol que sera el arbol derecho del nodo.
     */
    public BinaryTree(E value, BinaryTree<E> derecha, BinaryTree<E> izquierda){
        val = value;
        if (izquierda == null) { izquierda = new BinaryTree<E>(); }
        setLeft(izquierda);

        if (derecha == null) { derecha = new BinaryTree<E>(); }
        setRight(derecha);
    }

    /**
     * @post regresa una referencia al arbol izquierdo.
     * @return El arbol izquierdo del nodo.
     */
    public BinaryTree<E> left(){
        return izquierda;
    }

    /**
     * @post regresa una referencia al arbol derecho.
     * @return El arbol derecho del nodo.
     */
    public BinaryTree<E> right(){
        return derecha;
    }

    /**
     * @post regresa una referencia al padre, o nulo.
     * @return Referencia al padre del nodo.
     */
    public BinaryTree<E> parent(){
        return padre;
    }

    /**
     * @post hace un set del arbol izquierdo a newLeft.
     * @param newLeft La raiz del nuevo arbol izquierdo.
     */
    public void setLeft(BinaryTree<E> newLeft){
        if (isEmpty()) return;
        if (izquierda != null && izquierda.parent() == this) izquierda.setParent(null);
        izquierda = newLeft;
        izquierda.setParent(this);

    }


    /**
     * @post hace un set del arbol derecho a newRight.
     * @param newRight La raiz del nuevo arbol derecho.
     */
    public void setRight(BinaryTree<E> newRight){
        if (isEmpty()) return;
        if (derecha != null && derecha.parent() == this) derecha.setParent(null);
        derecha = newRight;
        derecha.setParent(this);
    }

    /**
     * @post Cambia el padre del nodo.
     * @param newParent Una referencia al nuevo padre del nodo.
     */
    protected void setParent(BinaryTree<E> newParent){
        if(!isEmpty()){
            padre = newParent;
        }
    }

    /**
     * @post Regresa el tamaño del arbol.
     * @return tamaño del arbol.
     */
    public int size()
    {
        if (isEmpty()) return 0;
        return left().size() + right().size() + 1;
    }


    /**
     * @post regresa la raiz del nodo
     * @return raiz del arbol
     */
    public BinaryTree<E> root()
    {
        if (parent() == null) return this;
        else return parent().root();
    }


    /**
     * @post regresa verdadero si es un hijo izquierdo del padre.
     * @return Verdadero si es un hijo izquierdo del padre.
     */
    public boolean isLeftChild(){
        if (parent() == null) return false;
        return this == parent().left();
    }

    /**
     * @post regresa verdadero si es un hijo derecho del padre.
     * @return Verdadero si es un hijo derecho del padre.
     */
    public boolean isRightChild(){
        if (parent() == null) return false;
        return this == parent().right();
    }

    /**
     * @post regresa el valor asociado con el nodo.
     * @return el valor del nodo
     */
    public E value()
    {
        return val;
    }

    /**
     * @post cambia el valor asociado con el nodo.
     * @param value el nuevo valor del nodo.
     */
    public void setValue(E value){ val = value; }

    /**
     * @post regresa verdadero si el arbol esta vacio.
     * @return regresa true si esta vacio.
     */
    public boolean isEmpty() { return val == null; }

    /**
     * @post Regresa la profundidad del nodo en el arbol.
     * @return La longitud del camino de la raiz al arbol.
     */
    public int depth()
    {
        if (parent() == null) return 0;
        return 1 + padre.depth();
    }

    /**
     * @return Un string que representa el arbol anidado en este nodo.
     */
    public String treeString(){
        String s = "";
        for (int i=0; i < this.depth(); i++){
            s += "\t|";
        }

        s += ("<" + val + " : " + getHand() + ">\n");

        if (!izquierda.isEmpty()) s += izquierda.treeString();
        if (!derecha.isEmpty()) s += derecha.treeString();

        return s;
    }

    /**
     * @return R si el nodo es hijo izquierdo y L si es hijo derecho del nodo.
     */
    private String getHand(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";
    }

    /**
     * @post Representacion en String.
     * @return String que representa el arbol
     */
    public String toString()
    {
        if (isEmpty()) return "<BinaryTree: vacío>";
        StringBuffer s = new StringBuffer();
        s.append("<BinaryTree ").append(value());
        if (!left().isEmpty()) s.append(" ").append(left());
        else s.append(" -");
        if (!right().isEmpty()) s.append(" ").append(right());
        else s.append(" -");
        s.append('>');
        return s.toString();
    }

    public InOrder<E> iterator(){ return new InOrder<E>(this); }


}
