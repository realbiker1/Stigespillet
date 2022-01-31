package gameFiles;

/**
 * Klasse som skal simulere et terningkast.
 *
 * @author Adrian Birkedal og Anders Lerang
 */
public class Terning {

    int verdi;

    /**
     * Konstruktør, setter default verdi lik 1.
     */
    public Terning() {
        this.verdi = 1;
    }

    /**
     * Simulerer et terningkast mellom 1 og 6.
     *
     * @return verdien av terningkastet.
     */
    public int trill() {
        return (int) (Math.floor(Math.random() * 6) + 1);
    }


}
