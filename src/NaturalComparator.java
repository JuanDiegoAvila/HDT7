// Un comparator que implementa el orden natural.
// Fuente del código: (c) 2001 duane a. bailey
import java.util.Comparator;

/** @author 2001 duane a. bailey
 * @author Juan Diego Avila Sagastume
 *
 */
public class NaturalComparator<E extends Comparable<E>>
        implements Comparator<E> {


    /**
     * Compara los valores a y b.
     *
     * @param a objeto que realiza la comparacion
     * @param b objeto que sera comparado
     * @return valor <, ==, > 0 si a <, ==, > b usando a.compareTo
     * @pre a, b son non-null, y b es del mismo tipo que a
     * @post regresa valor <, ==, > 0 si a <, ==, > b
     */
    public int compare(E a, E b) {
        return a.compareTo(b);
    }



    /**
     * Returns true if the other object is a NaturalComparator.
     * @param b a possible NaturalComparator
     * @post returns true if b is a NaturalComparator
     * @return true if b is a NaturalComparator
     */
    public boolean equals(Object b)
    {
        return (b != null) && (b instanceof NaturalComparator);
    }
}
