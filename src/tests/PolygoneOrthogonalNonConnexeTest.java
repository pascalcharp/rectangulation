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

    @Test
    public void decomposer() {
        ponc1.decomposerEnRectangles() ;
    }
}
