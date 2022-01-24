package gameFiles;

/**
 * Klasse som skal simulere et terningkast.
 *
 * @author Adrian Birkedal og Anders Lerang
 */
public class Terning {

    int verdi;

    public Terning() {
    }

    /**
     * Simulerer et terningkast mellom 1 og 6.
     *
     * @return verdien av terningkastet.
     */
    public int trill() {
        this.verdi = (int) (Math.floor(Math.random() * 6) + 1);
        return verdi;
    }

    public int getVerdi() {
        return verdi;
    }

}
