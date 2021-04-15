// Una clase para estructurar las asociaciones que pueden llegar a ser comparadas.
// (c) 1998, 2001 duane a. bailey

import java.util.Map;

/** @author 2001 duane a. bailey
 * @author Juan Diego Avila Sagastume
 */
public class ComparableAssociation <K extends Comparable<K>, V>
    extends Association<K,V>
    implements Comparable<ComparableAssociation<K,V>>
    , MapEntry <K,V>{


    /**
     * Construye una associacion que puede ser ordenada de una sola llave
     *
     * @pre key no es null.
     * @post construye una associacion comparable con el valor nulo
     * @param key La llave comparable
     */
    public ComparableAssociation(K key)
    {
        this(key,null);
    }

    /**
     * Construye una asociacion de la llave con el valor que puede ser ordenada.
     *
     * @pre key no es null
     * @post construye una asociacion entre la llave comparable y el valor
     *
     * @param key La llave comparable.
     * @param value El valor asociado con la llave
     */
    public ComparableAssociation(K key, V value)
    {
        super(key,value);
    }

    /**
     * Determina el orden de dos asociaciones.
     *
     * @pre that no es null
     * @post regresa el entero representando la relacion entre los valores.
     *
     * @param that la otra asociacion comparable.
     * @return Valor menor, igual o mayor que cero
     */
    public int compareTo(ComparableAssociation<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    /**
     * Contruye una representacion de ComparableAssociation.
     *
     * @post regresa la representacion en String
     *
     * @return El String que representa la ComparableAssociation
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append(""+getKey()+"="+getValue()+">");
        return s.toString();
    }
}
