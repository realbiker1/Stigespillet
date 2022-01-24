import gameFiles.Brett;
import gameFiles.Spiller;
import gameFiles.Terning;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StigepillTest {

    Brett brett;
    Spiller spiller;
    Terning terning;

    @BeforeEach
    void setUp() {
        brett = new Brett();
        spiller = new Spiller("navn", "farge");
        terning = new Terning();
    }

    @Test
    void trillTest() {
        int verdi = terning.trill();
        assertTrue(verdi >= 1 && verdi <= 20);
    }

    @Test
    void trekkTest() {
        assertEquals(1, spiller.getPos());
        spiller.trekk(brett, terning);
        assertNotEquals(1, spiller.getPos());
        spiller.setPos(100);
        spiller.trekk(brett, terning);
        assertEquals(100, spiller.getPos());
    }

    @Test
    void TransporterTest() {
        brett.sjekkOmStigeSlange(spiller, 1);
        assertEquals(1, spiller.getPos());
        brett.sjekkOmStigeSlange(spiller, 80);
        assertEquals(100, spiller.getPos());
    }

    @Test
    void sjekkOmVinnerTest() {
        assertFalse(spiller.sjekkOmVinner());
        spiller.setPos(100);
        assertTrue(spiller.sjekkOmVinner());
    }

}