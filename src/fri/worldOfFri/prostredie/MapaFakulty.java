/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.predmety.Predmet;
import fri.worldOfFri.predmety.Hodinky;
import fri.worldOfFri.predmety.Kluc;

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
        Miestnost terasa = new Miestnost("terasa","tu byva fri fest");
        Miestnost bufet = new Miestnost("bufet","tu byva jedlo");
        Miestnost labakB2 = new Miestnost("labakB2","tu byva ticho");
        Miestnost chodbaB = new Miestnost("chodbaB","tu byva automat na kavu");
        Miestnost chodbaA = new Miestnost("chodbaA","tu byva automat na kavu");
        Miestnost labakA12 = new Miestnost("labakA12","tu byva cudna tabula");
        Miestnost ic = new Miestnost("IC","tu byvaju knihy");
        Miestnost chillZone = new Miestnost("chill zone","tu byva vela studentov");
        Miestnost vratnica = new Miestnost("vratnica","tu byva vratnicka");
        Miestnost dekanat = new Miestnost("dekanat","tu byva dekan");
        
        // inicializacia miestnosti = nastavenie vychodov
        vratnica.nastavVychod("chodbaB", chodbaB);
        vratnica.nastavVychod("IC", ic);
        vratnica.nastavVychod("chodbaA", chodbaA);
        vratnica.nastavVychod("terasa", terasa);
        
        terasa.nastavVychod("vratnica", vratnica);
        Kluc klucIC = new Kluc("kluc","otvara IC");
   
        DvereNaKluc dvereVratnicaIC = new DvereNaKluc(ic, vratnica);
        klucIC.pridajDvere(dvereVratnicaIC);
        terasa.spawn(klucIC);
        
        terasa.spawn(new Hodinky());
        
        chodbaA.nastavVychod("vratnica", vratnica);
        chodbaA.nastavVychod("dekanat", dekanat);
        chodbaA.nastavVychod("labakA12", labakA12);
        chodbaA.nastavVychod("bufet", bufet);
        
        bufet.nastavVychod("chodbaA", chodbaA);
        
        dekanat.nastavVychod("chodbaA", chodbaA);
        
        labakA12.nastavVychod("chodbaA", chodbaA);
        
        chodbaB.nastavVychod("chillZone", chillZone);
        chodbaB.nastavVychod("vratnica", vratnica);
        chodbaB.nastavVychod("labakB2", labakB2);
        
        chillZone.nastavVychod("chodbaB", chodbaB);
        vratnica.nastavVychod("chodbaB", chodbaB);
        labakB2.nastavVychod("chodbaB", chodbaB);
        
        Dvere dvereTerasaVratnica = new Dvere(terasa, vratnica);
        // startovacia miestnost hry
        this.startovaciaMiestnost = terasa; 
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
    
}
