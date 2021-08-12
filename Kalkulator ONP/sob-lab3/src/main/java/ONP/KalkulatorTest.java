package ONP;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KalkulatorTest {
    ONP onp = null;

    @Before
    public void prepare() {
        onp = new ONP();
    }

    @Test
    public void testKilkuOperacjiArytmetycznychRazem() throws Exception {
        String rownanie = "((2+2)*2/4)^(4+2)=";
        //przeksztalcamy rownanie na ONP
        String rownianieONP = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy czy wynik bedzie prawidlowy
        assertEquals("64.0", onp.obliczOnp(rownianieONP));
    }

    @Test
    public void testDodawanie() throws Exception {
        String rownanie = "2+6=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("8.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testOdejmowanie() throws Exception {
        String rownanie = "2-6=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("-4.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testMnozenie() throws Exception {
        String rownanie = "2*6=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("12.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testDzielenie() throws Exception {
        String rownanie = "6/2=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("3.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testPotegowanie() throws Exception {
        String rownanie = "6^2=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("36.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testPierwiastkowanie() throws Exception {
        String rownanie = "3#27=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("3.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testSilnia() throws Exception {
        String rownanie = "5!=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("120.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testModulo() throws Exception {
        String rownanie = "15%4=";
        String rownanieOnp = onp.przeksztalcNaOnp(rownanie);
        //sprawdzamy wynik
        assertEquals("3.0", onp.obliczOnp(rownanieOnp));
    }

    @Test
    public void testWyjatkow() throws Exception {

        String rownanie = "(4*5+3)/0=";
        //sprawdzamy czy wyjątek dzielenia przez zero zostanie wyrzucony
        assertThrows(dzieleniePrzezZeroException.class, ()->onp.przeksztalcNaOnp(rownanie));

        //sprawdzamy czy wyjątek nieprawidłowego operatora zostanie wyrzucony
        String rownanie2 = "(4*5)/3_=";
        assertThrows(zlyOperatorException.class, ()->onp.przeksztalcNaOnp(rownanie2));

        //sprawdzamy czy zostanie wyrzucony wyjatek nieprawidlowego rownania (brak znaku =)
        String rownanie3 = "4!+6";
        assertThrows(zleRownanieException.class, ()->onp.przeksztalcNaOnp(rownanie3));
    }

    @After
    public void clean() {
        onp = null;
    }
}