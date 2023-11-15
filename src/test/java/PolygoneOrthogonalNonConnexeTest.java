import org.junit.Test;
import org.polygones.AreteHorizontale;
import org.polygones.AreteVerticale;
import org.polygones.PolygoneOrthogonalNonConnexe;
import org.polygones.PolygoneOrthogonalSimplementConnexe;

import java.util.ArrayList;
import java.util.Arrays;

public class PolygoneOrthogonalNonConnexeTest {

    private AreteVerticale av1 = new AreteVerticale(1, 6, 2) ;
    private AreteHorizontale ah1 = new AreteHorizontale(6, 1, 4) ;
    private AreteVerticale av2 = new AreteVerticale(4, 6, 2) ;
    private AreteHorizontale ah2 = new AreteHorizontale(2,1 , 4) ;

    private PolygoneOrthogonalSimplementConnexe rectangle = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av1, ah1, av2, ah2))) ;
    private PolygoneOrthogonalNonConnexe ponc1 = new PolygoneOrthogonalNonConnexe(rectangle, null) ;

    private AreteVerticale av3 = new AreteVerticale(2, 5, 3) ;
    private AreteHorizontale ah3 = new AreteHorizontale(5, 2, 3) ;
    private AreteVerticale av4 = new AreteVerticale(3, 5, 3) ;
    private AreteHorizontale ah4 = new AreteHorizontale(3, 2, 3) ;

    private PolygoneOrthogonalSimplementConnexe carre = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av3, ah3, av4, ah4))) ;
    private PolygoneOrthogonalNonConnexe ponc2 = new PolygoneOrthogonalNonConnexe(rectangle, new ArrayList<PolygoneOrthogonalSimplementConnexe>(Arrays.asList(carre))) ;

    private AreteVerticale av5 = new AreteVerticale(0, 6, 0) ;
    private AreteHorizontale ah5 = new AreteHorizontale(6, 0, 6) ;
    private AreteVerticale av6 = new AreteVerticale(6, 6, 0) ;
    private AreteHorizontale ah6 = new AreteHorizontale(0, 4, 6) ;
    private AreteVerticale av7 = new AreteVerticale(4, 3, 0) ;
    private AreteHorizontale ah7 = new AreteHorizontale(3, 2, 4) ;
    private AreteVerticale av8 = new AreteVerticale(2, 3, 0) ;
    private AreteHorizontale ah8 = new AreteHorizontale(0, 0, 2) ;

    private PolygoneOrthogonalSimplementConnexe facade1 = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av5, ah5, av6, ah6, av7, ah7, av8, ah8))) ;

    private PolygoneOrthogonalNonConnexe ponc3 = new PolygoneOrthogonalNonConnexe(facade1, null) ;

    private AreteVerticale av9 = new AreteVerticale(1, 5, 4) ;
    private AreteHorizontale ah9 = new AreteHorizontale(5, 1, 3) ;
    private AreteVerticale av10 = new AreteVerticale(3, 5, 4) ;
    private AreteHorizontale ah10 = new AreteHorizontale(4, 1, 3) ;

    private PolygoneOrthogonalSimplementConnexe fenetre1 = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av9, ah9, av10, ah10))) ;

    private PolygoneOrthogonalNonConnexe ponc4 = new PolygoneOrthogonalNonConnexe(facade1, new ArrayList<>(Arrays.asList(fenetre1))) ;

    private AreteVerticale av11 = new AreteVerticale(0, 10, 0) ;
    private AreteHorizontale ah11 = new AreteHorizontale(10, 0, 12) ;
    private AreteVerticale av12 = new AreteVerticale(12, 10, 0) ;
    private AreteHorizontale ah12 = new AreteHorizontale(0, 0, 12) ;
    private PolygoneOrthogonalSimplementConnexe facade2 = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av11, ah11, av12, ah12))) ;
    private AreteVerticale av13 = new AreteVerticale(1, 8, 5) ;
    private AreteHorizontale ah13 = new AreteHorizontale(8, 1, 5) ;
    private AreteVerticale av14 = new AreteVerticale(5, 8, 5) ;
    private AreteHorizontale ah14 = new AreteHorizontale(5, 1, 5) ;
    private PolygoneOrthogonalSimplementConnexe fenetre2 = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av13, ah13, av14, ah14))) ;
    private AreteVerticale av15 = new AreteVerticale(8, 8, 5) ;
    private AreteHorizontale ah15 = new AreteHorizontale(8, 8, 11) ;
    private AreteVerticale av16 = new AreteVerticale(11, 8, 5) ;
    private AreteHorizontale ah16 = new AreteHorizontale(5, 8, 11) ;
    private PolygoneOrthogonalSimplementConnexe fenetre3 = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av15, ah15, av16, ah16))) ;
    private PolygoneOrthogonalNonConnexe ponc5 = new PolygoneOrthogonalNonConnexe(facade2, new ArrayList<>(Arrays.asList(fenetre2, fenetre3))) ;
    private AreteVerticale av17 = new AreteVerticale(1, 8, 4) ;
    private AreteHorizontale ah17 = new AreteHorizontale(8, 1, 5) ;
    private AreteVerticale av18 = new AreteVerticale(5, 8, 4) ;
    private AreteHorizontale ah18 = new AreteHorizontale(4, 1, 5) ;
    private PolygoneOrthogonalSimplementConnexe fenetre4 = new PolygoneOrthogonalSimplementConnexe(new ArrayList<>(Arrays.asList(av17, ah17, av18, ah18))) ;
    private PolygoneOrthogonalNonConnexe ponc6 = new PolygoneOrthogonalNonConnexe(facade2, new ArrayList<>(Arrays.asList(fenetre4, fenetre3))) ;

    @Test
    public void decomposerSimple() {

        ponc1.decomposerEnRectangles() ;
    }

    @Test
    public void decomposerSimple2() {
        ponc3.decomposerEnRectangles() ;
    }

    @Test
    public void decomposerNonConnexe() {
        ponc2.decomposerEnRectangles() ;
    }

    @Test
    public void decomposerNonConnexe2() {
        ponc4.decomposerEnRectangles() ;
    }

    @Test
    public void decomposerNonConnexe3() {
        ponc5.decomposerEnRectangles() ;
    }

    @Test
    public void decomposerNonConnexe4() {
        ponc6.decomposerEnRectangles() ;
    }
}
