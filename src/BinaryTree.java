public class BinaryTree <E>{

    protected E val; //valor asociado al nodo.
    protected BinaryTree<E> padre; //padre del nodo.
    protected BinaryTree<E> izquierda, derecha; //hijos del nodo.

    // post: constructor that generates an empty node
    public BinaryTree(){
        val = null;
        padre = null; izquierda = derecha = this;
    }

    // post: returns a tree referencing value and two empty subtrees
    public BinaryTree(E value){
        if(value!=null) {
            val = value;
            derecha = izquierda = new BinaryTree<E>();
            setLeft(izquierda);
            setRight(derecha);
        }else{
            System.out.println("Los valores del arbol no pueden ser null");
        }
    }


    // post: returns a tree referencing value and two subtrees
    public BinaryTree(E value, BinaryTree<E> derecha, BinaryTree<E> izquierda){
        if(value!=null) {
            val = value;
            if(izquierda == null) izquierda = new BinaryTree<E>();
            setLeft(izquierda);
            if(derecha == null) derecha = new BinaryTree<E>();
            setRight(derecha);
        }else{
            System.out.println("Los valores del arbol no pueden ser null");
        }
    }

    // post: returns reference to (possibly empty) left subtree
    public BinaryTree<E> left(){
        return izquierda;
    }

    // post: returns reference to (possibly empty) left subtree
    public BinaryTree<E> right(){
        return derecha;
    }

    // post: returns reference to parent node, or null
    public BinaryTree<E> parent(){
        return padre;
    }

    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    public void setLeft(BinaryTree<E> newLeft){

    }


    // post: sets right subtree to newRight
    // re-parents newRight if not null
    public void setRight(BinaryTree<E> newRight){

    }

    // post: re-parents this node to parent reference, or null
    protected void setParent(BinaryTree<E> newParent){

    }

    /*
    // post: returns an in-order iterator of the elements
    public Iterator<E> iterator(){
        return null;
    }
     */

    // post: returns true if this is a left child of parent
    public boolean isLeftChild(){
        return false;
    }

    // post: returns value associated with this node
    public E value(){
        return null;
    }

    // post: sets the value associated with this node
    public void setValue(E value){

    }

}
