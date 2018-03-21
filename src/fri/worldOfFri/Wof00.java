package fri.worldOfFri;


import fri.worldOfFri.hra.Hra;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 * 
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */

/*
 - aby sa dala vyhrat
 - nepriatelia?
 - items? predmety(nazov, popis)
    - usb
    - isic
    - pocitac
    - navleky
    - pizza
    - automat na kavu
    > zober pizza
    > poloz pizza
    - hrac ma inventar; miestnost ma predmety
 - NPC = non-playable character
    - bufetarka
    - vratnicka
    - upratovacka
    - dekan

 - questy = ulohy?
    - kupit navleky

 - obtiaznost? 
 - zivoty?
 * 
 */


public class Wof00 {

    /**
     * @param args parametre programu
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}
