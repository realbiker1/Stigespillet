package gameFiles;

import java.util.ArrayList;

/**
 * Klasse som simulerer stigespillet
 *
 * @author Adrian Birkedal og Anders Lerang
 */
public class Stigespill {

    ArrayList<Spiller> spillerList = Meny.spillerList;
    Brett brett = new Brett();
    boolean vinner = false;

    /**
     * Initialiserer stigespillet
     */
    public Stigespill() {
        while (!vinner) {
            spillRunde();
        }
    }

    /**
     * Starter en runde med stigespill.
     */
    private void spillRunde() {
        for (Spiller spiller : spillerList) {
            if (!vinner) {
                spillTrekk(spiller);
            }
        }
    }

    /**
     * Gjør et trekk for en spiller.
     *
     * @param spiller
     */
    private void spillTrekk(Spiller spiller) {

        System.out.println("* * * * * * * * * * * * *\n" + spiller.getNavn() + " (" + spiller.getFarge() + ") sin tur");

        Terning terning = new Terning();
        int startPos = spiller.getPos();

        spiller.trekk(brett, terning);
        vinner = spiller.sjekkOmVinner();
        skrivTrekk(spiller, startPos, terning);

        //Rekursivt kall dersom spilleren får terningkast 6.
        if (terning.getVerdi() == 6 && !vinner) {
            System.out.println("Ny tur, siden " + spiller.getNavn() + " fikk terningkast 6!");
            spillTrekk(spiller);
        }
    }

    /**
     * Skriver ut trekket i konsollen.
     *
     * @param spiller
     * @param startPos
     * @param terning
     */
    private void skrivTrekk(Spiller spiller, int startPos, Terning terning) {

        System.out.println("Terningkast " + terning.getVerdi() + "!");
        int nyPos = startPos + terning.getVerdi();

        //Utskriftshåndtering for flytt over 100 eller ikke.
        if (nyPos > 100) {
            System.out.println("Kan ikke flytte lengre enn rute 100, ingen flytt...");
        } else {
            System.out.println(spiller.getFarge() + " flyttet seg fra rute " + startPos + " til " + nyPos);
        }

        //Utskriftshåndtering dersom spilleren møtte en stige eller slange.
        int offset = spiller.getPos() - nyPos;
        if (offset > 0) {
            System.out.println("På rute " + nyPos + " er det en stige! " + spiller.getFarge() +
                    " klatret opp " + offset + " steg, til rute " + spiller.getPos() + "!");
        } else if (offset < 0) {
            System.out.println("På rute " + nyPos + " er det en slange! " + spiller.getFarge() +
                    " falt ned " + Math.abs(offset) + " steg, til rute " + spiller.getPos() + "!");
        }
        if (vinner) {
            System.out.println(spiller.getNavn() + " (" + spiller.getFarge() + ") vant! Gratulerer!");
        }
    }
}