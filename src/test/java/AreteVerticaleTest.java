import org.junit.Test;
import org.polygones.AreteVerticale;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AreteVerticaleTest {

    private double delta = 1E-10 ;

    private AreteVerticale ah1 = new AreteVerticale(4, 15, 10) ;
    private AreteVerticale ah2 = new AreteVerticale(6, 30, 10) ;
    private AreteVerticale ah3 = new AreteVerticale(6, 15, 11) ;
    private AreteVerticale ah4 = new AreteVerticale(6, 30, 11) ;

    @Test
    public void fin() {
        assertEquals(10, ah1.fin(), delta) ;
    }

    @Test
    public void debut() {
        assertEquals(15, ah1.debut(), delta) ;
    }

    @Test
    public void position() {
        assertEquals(4, ah1.position(), delta) ;
    }

    @Test
    public void longueur() {
        assertEquals(5, ah1.longueur(), delta) ;
    }

    @Test
    public void contient() {
        assertTrue(ah1.contient(12)) ;
        assertFalse(ah1.contient(0)) ;
    }

    @Test
    public void compareTo() {
        assertTrue(ah1.compareTo(ah2) < 0) ;
        assertTrue(ah2.compareTo(ah1) > 0) ;

        assertTrue(ah2.compareTo(ah3) < 0) ;
        assertTrue(ah3.compareTo(ah2) > 0) ;

        assertTrue(ah2.compareTo(ah4) > 0) ;
        assertTrue(ah4.compareTo(ah2) < 0) ;

        assertEquals(0, ah1.compareTo(ah1));
    }

    @Test
    public void equals() {
        assertEquals(ah1, ah1);
        assertNotEquals(ah1, ah2);
        assertNotEquals(ah2, ah4);
    }


}
