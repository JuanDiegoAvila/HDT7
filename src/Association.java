public class Association <K,V>{

    protected K theKey; // the key of the key-value pair
    protected V theValue;

    /** @param key Un valor no null.
     * @param value Un objeto
    */
    public Association(K key, V value){
        theKey = key;
        theValue = value;
    }

    /**
     * @param other Otra asociacion.
     * @return verdadero si los valores son iguales.
     */
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }

    /**
     * @param key Valor de la llave.
     */
    public Association(K key){ this(key,null); }

    /**
     * @return regresa el valor deseado.
     */
    public V getValue(){ return theValue; }

    /**
     * @return regresa el valor de la llave.
     */
    public K getKey(){ return theKey; }

    /**
     @post asigna el valor.
     */
    public V setValue(V value){
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }


    /**
     * @return Representacion de String.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }

}
