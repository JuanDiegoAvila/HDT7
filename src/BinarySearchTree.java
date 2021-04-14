// Implementacion del arbol de busqueda binario.
// (c) 1998, 2001 duane a. bailey

import java.util.Comparator;
import java.util.Iterator;

/** @author 2001 duane a. bailey
 * @author Juan Diego Avila Sagastume
 */

public class BinarySearchTree<E extends Comparable<E>>{


    protected BinaryTree<E> root;
    protected final BinaryTree<E> EMPTY = new BinaryTree<E>();

    protected int count;
    protected Comparator<E> ordering;

    /**
     * @post Construye un arbol binario de busqueda vacio.
     */
    public BinarySearchTree()
    {
        this(new NaturalComparator<E>());
    }

    /**
     * @post Construye un arbol binario de busqueda vacio.
     */
    public BinarySearchTree(Comparator<E> ordenAlternativo){
        root = EMPTY;
        count = 0;
        ordering = ordenAlternativo;
    }

    /**
     * @pre raiz y el valor no son null.
     * @post regresa: 1 - nodo existente con el valor deseado.
     *                 2 - el nodo al que se deberia agregar el valor
     */
    protected BinaryTree<E> locate(BinaryTree<E> root, E value){
        E rootValue = root.value();
        BinaryTree<E> hijo;

        // se encontro en la raiz
        if (rootValue.equals(value)) return root;
        if (ordering.compare(rootValue,value) < 0)
        {
            hijo = root.right();
        } else {
            hijo = root.left();
        }
        // si no hay hijos que regrese el nodo
        if (hijo.isEmpty()) {
            return root;
        } else {
            return locate(hijo, value);
        }
    }

    /**
     * @param value El valor buscado
     * @return regresa verdadero si el arbol contiene ese valor.
     */
    public boolean contains(E value)
    {
        if (root.isEmpty()) return false;
        BinaryTree<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.value());
    }

    /**
     * @return regresa verdadero si el arbol binario de busqueda esta vacio.
     */
    public boolean isEmpty()
    {
        return root == EMPTY;
    }

    /**
     * @post Elimina todos los elementos del arbol.
     */
    public void clear(){
        root = new BinaryTree<E>();
        count = 0;
    }

    /**
     * @return El numero de nodos en el arbol binario.
     */
    public int size()
    {
        return count;
    }

    /**
     * @post Añade un valor al BST.
     * @param value referencia al valor que no es null-
     */
    public void add(E value){
        BinaryTree<E> newNode = new BinaryTree<E>(value,EMPTY,EMPTY);
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            BinaryTree<E> insertLocation = locate(root,value);
            E nodeValue = insertLocation.value();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            if (ordering.compare(nodeValue,value) < 0) {
                insertLocation.setRight(newNode);
            } else {
                if (!insertLocation.left().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRight(newNode);
                } else {
                    insertLocation.setLeft(newNode);
                }

            }
        }
        count++;
    }

    protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }

    protected BinaryTree<E> successor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.right();
        while (!result.left().isEmpty()) {
            result = result.left();
        }
        return result;
    }
    // pre: topNode contains the value we want to remove
    // post: we return an binary tree rooted with the predecessor of topnode.
    protected BinaryTree<E> removeTop(BinaryTree<E> topNode) {
        // remove topmost BinaryTree from a binary search tree
        BinaryTree<E> left = topNode.left();
        BinaryTree<E> right = topNode.right();
        // disconnect top node
        topNode.setLeft(EMPTY);
        topNode.setRight(EMPTY);
        // Case a, no left BinaryTree
        // easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right BinaryTree
        // easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        // easy: make right subtree of left
        BinaryTree<E> predecessor = left.right();
        if (predecessor.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        // harder: successor of root becomes new root
        // parent always points to parent of predecessor
        BinaryTree<E> parent = left;
        while (!predecessor.right().isEmpty())
        {
            parent = predecessor;
            predecessor = predecessor.right();
        }
        // Assert: predecessor is predecessor of root
        parent.setRight(predecessor.left());
        predecessor.setLeft(left);
        predecessor.setRight(right);
        return predecessor;

    }


    /**
     * @param value Valor que se desea obtener
     * @return el valor deseado.
     */
    public E get(E value)
    {
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = locate(root,value);
        if (value.equals(possibleLocation.value()))
            return possibleLocation.value();
        else
            return null;
    }

    /**
     * @param value Valor que se desea obtener.
     * @return valor que se elimina del arbol.
     */
    public E remove(E value)
    {
        if (isEmpty()) return null;

        if (value.equals(root.value())) // delete root value
        {
            BinaryTree<E> newroot = removeTop(root);
            count--;
            E result = root.value();
            root = newroot;
            return result;
        }
        else
        {
            BinaryTree<E> location = locate(root,value);

            if (value.equals(location.value())) {
                count--;
                BinaryTree<E> parent = location.parent();
                if (parent.right() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
                return location.value();
            }
        }
        return null;
    }


    /**
     * @post Returns iterator to traverse BST
     * @return An iterator over binary search tree
     */
    /*
    public Iterator<E> iterator()
    {
        return root.InOrderTransversal();
    }
    */


    /**
     * @return String que representa la raiz.
     */
    public String treeString(){
        return root.treeString();
    }

    /**
     * @post Genera un string que representa el BST.
     * @return String que representa el arbol.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<BinarySearchTree:");
        if (!root.isEmpty()) {
            s.append(root);
        }
        s.append(">");
        return s.toString();
    }

}

