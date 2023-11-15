import org.junit.Test;
import org.polygones.Arete;
import org.polygones.AreteHorizontale;
import org.polygones.AreteVerticale;
import org.polygones.PolygoneOrthogonalSimplementConnexe;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PolygoneOrthogonalSimplementConnexeTest {
    AreteVerticale av1 = new AreteVerticale(1, 6, 2) ;
    AreteHorizontale ah1 = new AreteHorizontale(6, 1, 4) ;
    AreteVerticale av2 = new AreteVerticale(4, 6, 2) ;
    AreteHorizontale ah2 = new AreteHorizontale(2, 1, 4) ;

    ArrayList<Arete> aretes = new ArrayList<Arete>(Arrays.asList(av1, ah1, av2, ah2)) ;

    PolygoneOrthogonalSimplementConnexe posc = new PolygoneOrthogonalSimplementConnexe(aretes) ;

    @Test
    public void getnAretes() {
        assertEquals(4, posc.getnAretes()) ;
    }

}
