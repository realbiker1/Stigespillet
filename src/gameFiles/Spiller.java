package gameFiles;

/**
 * Klasse for opprettelse av spiller.
 *
 * @author Adrian Birkedal og Anders Lerang
 */
public class Spiller {

    private String navn;
    private String farge;
    private int pos;

    /**
     * Oppretter et spillerobjekt og setter posisjonen lik 1.
     *
     * @param navn
     * @param farge
     */
    public Spiller(String navn, String farge) {
        this.navn = navn;
        this.farge = farge;
        this.pos = 1;
    }

    /**
     * Gjør et trekk for en spiller. Sjekker om ny posisjon overskrider 100, for å så sjekke om spilleren landet
     * på en stige eller slange.
     *
     * @param brett
     * @param terning
     */
    public void trekk(Brett brett, Terning terning) {

        int verdi = terning.trill();
        int nyPos = verdi + pos;

        //Oppdaterer kun posisjon dersom den ikke overskrider 100.
        if (nyPos <= 100) {
            pos += verdi;
            brett.sjekkOmStigeSlange(this, pos);
        }
    }

    /**
     * Sjekker om spilleren er på rute 100.
     *
     * @return true dersom spilleren er på rute 100, false ellers.
     */
    public boolean sjekkOmVinner() {
        return pos == 100;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
