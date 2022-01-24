package gameFiles;

import java.util.HashMap;

/**
 * Klasse som skal etterlikne et brett i stigespillet
 *
 * @author Adrian Birkedal og Anders Lerang
 */
public class Brett {

    HashMap<Integer, Integer> brett = new HashMap<Integer, Integer>();

    /**
     * Konstruktør for brett, kaller metoden genererRute() som oppretter et map av stiger/slanger.
     */
    public Brett() {
        genererRuter();
    }

    /**
     * Genererer rutene til brettet. Stiger og slanger er angitt av et HashMap der nøkkel er rutenummer der
     * disse rutene er og verdi er hvor disse rutene leder til.
     */
    private void genererRuter() {
        //Stiger og slanger (key = rutenummer, verdi = hvor de leder til)
        brett.put(2, 38);
        brett.put(4, 14);
        brett.put(8, 31);
        brett.put(9, 5);
        brett.put(16, 6);
        brett.put(28, 84);
        brett.put(21, 42);
        brett.put(36, 44);
        brett.put(47, 26);
        brett.put(48, 11);
        brett.put(52, 67);
        brett.put(55, 53);
        brett.put(62, 18);
        brett.put(64, 60);
        brett.put(60, 27);
        brett.put(71, 90);
        brett.put(92, 73);
        brett.put(80, 100);
        brett.put(95, 75);
        brett.put(98, 78);
    }

    /**
     * Sjekker om spilleren står på en stige/slange rute, og oppdaterer spillerens posisjonen dersom det er sant.
     *
     * @param spiller spilleren som skal sjekkes og eventuelt transporteres
     * @param pos     Posisjonen til spilleren
     */
    public void sjekkOmStigeSlange(Spiller spiller, int pos) {
        if (brett.containsKey(pos)) {
            spiller.setPos(brett.get(pos));
        }
    }
}
