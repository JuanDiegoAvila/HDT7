import java.util.Stack;
import java.util.Iterator;

/**
 *@author 2001 duane a. bailey
 *@author Juan Diego Avila Sagastume
 */
public class InOrder<E> implements Iterator<E>{
    protected BinaryTree<E> root;
    protected Stack<BinaryTree<E>> todo;

    public InOrder(BinaryTree<E> root){
        todo = new Stack<BinaryTree<E>>();
        this.root = root;
        reset();
    }
    // post: resets the iterator to retraverse
    public void reset()
    {
        todo.clear();
        // stack is empty. Push on nodes from root to
        // leftmost descendant
        BinaryTree<E> current = root;
        while (!current.isEmpty()) {
            todo.push(current);
            current = current.left();
        }
    }


    public E next()
    {
        BinaryTree<E> old = todo.pop();
        E result = old.value();
        if (!old.right().isEmpty()) {
            BinaryTree<E> current = old.right();
            do {
                todo.push(current);
                current = current.left();
            } while (!current.isEmpty());
        }
        return result;
    }

    public E get(){return todo.peek().value();}

    @Override
    public boolean hasNext(){return !todo.isEmpty();}



}
