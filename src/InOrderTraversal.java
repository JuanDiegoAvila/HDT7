import java.util.Stack;

public class InOrderTraversal<E> {
    protected BinaryTree<E> root;
    protected Stack<BinaryTree<E>> todo;

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

}
