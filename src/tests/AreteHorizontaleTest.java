import org.junit.Test;


import org.polygones.AreteHorizontale;
import org.polygones.AreteVerticale;

import static org.junit.Assert.*;

public class AreteHorizontaleTest {

    private final double delta = 1E-10 ;

    private final AreteHorizontale ah1 = new AreteHorizontale(4, 10, 15) ;
    private final AreteHorizontale ah2 = new AreteHorizontale(5, 5, 10) ;
    private final AreteHorizontale ah3 = new AreteHorizontale(5, 6, 9) ;
    private final AreteHorizontale ah4 = new AreteHorizontale(5, 6, 10) ;

    private final AreteHorizontale ah5 = new AreteHorizontale(4, 5, 10) ;

    private final AreteVerticale av1 = new AreteVerticale(1, 7, 5) ;
    private final AreteVerticale av2 = new AreteVerticale(2, 5, 0) ;
    private final AreteVerticale av3 = new AreteVerticale(100, 5, 3) ;
    private final AreteVerticale av4 = new AreteVerticale(16, 3, 0) ;

    @Test
    public void fin() {
        assertEquals(15, ah1.fin(), delta) ;
    }

    @Test
    public void debut() {
        assertEquals(10, ah1.debut(), delta) ;
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
    public void croise() {
        assertFalse(ah1.croise(av1)) ;
        assertTrue(ah1.croise(av2)) ;
        assertTrue(ah1.croise(av3)) ;
        assertFalse(ah1.croise(av4)) ;
    }

    @Test
    public void fusionnerVersLaGaucheAvec() {
        AreteHorizontale ahTest = ah1.fusionnerVersLaGaucheAvec(ah5) ;
        assertEquals(new AreteHorizontale(4, 5, 15), ahTest) ;
        assertEquals(ah1, ah1.fusionnerVersLaGaucheAvec(null)) ;
    }

    @Test
    public void prolongerVers() {
        AreteHorizontale ahTest = ah1.prolongerVers(av2) ;
        assertEquals(new AreteHorizontale(4, 2, 10), ahTest) ;

        AreteHorizontale ahTest2 = ah1.prolongerVers(av3) ;
        assertEquals(new AreteHorizontale(4, 15, 100), ahTest2) ;
    }

    @Test
    public void compareTo() {
        assertTrue(ah1.compareTo(ah2) < 0);
        assertTrue(ah2.compareTo(ah1) > 0);

        assertTrue(ah2.compareTo(ah3) < 0);
        assertTrue(ah3.compareTo(ah2) > 0);

        assertTrue(ah3.compareTo(ah4) < 0);
        assertTrue(ah4.compareTo(ah3) > 0);

        assertEquals(0, ah1.compareTo(ah1));
    }

    @Test
    public void equals() {
        assertEquals(ah1, ah1) ;
        assertNotEquals(ah1, ah2) ;
        assertNotEquals(ah3, ah4) ;
    }



}
