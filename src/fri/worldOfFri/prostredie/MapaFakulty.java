/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.predmety.Hodinky;
import fri.worldOfFri.predmety.Kluc;
import fri.worldOfFri.predmety.Predmet;

/**
 *
 * @author jancigova2
 */
public class MapaFakulty {

    private Miestnost startovaciaMiestnost;

    /**
     * Vytvori mapu hry - miestnosti.
     */
    public MapaFakulty() {
        
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa", "tu byva fri fest");
        Miestnost bufet = new Miestnost("bufet", "tu byva jedlo");
        Miestnost labakB2 = new Miestnost("labakB2", "tu byva ticho");
        Miestnost chodbaB = new Miestnost("chodbaB", "tu byva automat na kavu");
        Miestnost chodbaA = new Miestnost("chodbaA", "tu byva automat na kavu");
        Miestnost labakA12 = new Miestnost("labakA12", "tu byva cudna tabula");
        Miestnost ic = new Miestnost("IC", "tu byvaju knihy");
        Miestnost chillZone = new Miestnost("chill zone", "tu byva vela studentov");
        Miestnost vratnica = new Miestnost("vratnica", "tu byva vratnicka");
        Miestnost dekanat = new Miestnost("dekanat", "tu byva dekan");
        
        // inicializacia miestnosti = nastavenie dveri
        Dvere dvereTerasaVratnica = new Dvere(terasa, vratnica);
        Dvere dvereChodbaBVratnica = new Dvere(chodbaB, vratnica);
        Dvere dvereChodbaAVratnica = new Dvere(chodbaA, vratnica);
        
        Kluc klucIC = new Kluc("kluc", "otvara IC");
        DvereNaKluc dvereVratnicaIC = new DvereNaKluc(ic, vratnica);
        klucIC.pridajDvere(dvereVratnicaIC);
        terasa.spawn(klucIC);
        
        terasa.spawn(new Hodinky());
        terasa.spawn(new Predmet("navleky","modre navleky"));
        
        Miestnost chodbaDruhePoschodie = new Miestnost("chodbaNaDruhom", "druhe poschodie");
        Miestnost chodbaPrvePoschodie = new Miestnost("chodbaNaPrvom", "prve poschodie");
        Vytah vytah = new Vytah();
        DvereVytahove dvereVytahoveNaPrizemi = new DvereVytahove(vytah, chodbaA, 0);
        dvereVytahoveNaPrizemi.odomkniZamkni();
        vytah.nastavDvere("chodbaA", dvereVytahoveNaPrizemi); 
        vytah.nastavDvere("chodbaPrvePoschodie", new DvereVytahove(vytah, chodbaPrvePoschodie, 1)); 
        vytah.nastavDvere("chodbaDruhePoschodie", new DvereVytahove(vytah, chodbaDruhePoschodie, 2)); 
        
        Dvere dvereChodbaADekanat = new Dvere(chodbaA, dekanat);
        Dvere dvereChodbaAlabakA12 = new Dvere(chodbaA, labakA12);
        Dvere dvereChodbaAbufet = new Dvere(chodbaA, bufet);
        Dvere dvereChodbaBchillZone = new Dvere(chodbaB, chillZone);
        Dvere dvereChodbaBlabakB2 = new Dvere(chodbaB, labakB2);

        // startovacia miestnost hry
        this.startovaciaMiestnost = terasa; 
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
    
}
