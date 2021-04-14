// Interfaz de la clase MapEntry
// Fuente del código: (c) 2001 duane a. bailey

/** @author 2001 duane a. bailey
 * @author Juan Diego Avila Sagastume
 *
 */

public interface MapEntry <K,V>{

    /**
     * @param o Valor que sera comparado.
     * @post regresa true si la entrada <K,V> es igual al objeto o.
     */
    public boolean equals (Object o);


    /**
     *
     * @return la llave K de la entrada.
     */
    public K getKey();

    /**
     *
     * @return el valor V de la entrada.
     */
    public V getValue();

    /**
     *
     * @return el hashCode de la llave.
     */
    public int hashCode();

    /**
     *
     * @param value valor que sera reemplazado.
     * @post reemplaza el valor de la entrada.
     * @return nuevo valor.
     */
    public V setValue(V value);
}
