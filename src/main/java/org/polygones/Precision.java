package org.polygones;

/**
 * Cette classe auxiliaire sert à comparer des variables de type double ensemble selon une certaine précision.
 *
 */
public class Precision {

    /** La précision demandée */
    public static final double EPSILON = 1.0E-8 ;

    /**
     * Compare deux variables doubles
     * @param x Premier opérande
     * @param y Deuxième opérande
     * @return true si x et y sont approximativement égales, soit si leur différence est plus petite, en valeur absolue
     * que la précision demandée.
     */
    public static boolean DoubleEquals(double x, double y) {
        return Math.abs(x - y) < EPSILON ;
    }

    /**
     * Compare une variable double avec 0.
     * @param x Opérande
     * @return true si x est plus petit en valeur absolue que la précision.  Elle est alors considérée approximativement
     * nulle.
     */
    public static boolean DoubleEstNul(double x) {
        return Math.abs(x) < EPSILON ;
    }
}
