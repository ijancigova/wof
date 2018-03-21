/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.hra;

import fri.worldOfFri.prostredie.IDvere;
import fri.worldOfFri.predmety.IPredmet;
import fri.worldOfFri.prostredie.MapaFakulty;
import fri.worldOfFri.prostredie.Miestnost;
import fri.worldOfFri.predmety.Predmet;
import java.util.HashMap;

/**
 *
 * @author jancigova2
 */
public class Hrac {

    private Miestnost aktualnaMiestnost;
    private HashMap<String, IPredmet> batoh;
    
    public Hrac(MapaFakulty mapa) {
        this.aktualnaMiestnost = mapa.getStartovaciaMiestnost();
        this.batoh = new HashMap<String, IPredmet>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    boolean chod(String smer) {
        //Miestnost nova = this.aktualnaMiestnost.getVychod(smer);
        IDvere dvere = this.aktualnaMiestnost.getDverePodlaSmeru(smer);
        
        if (dvere == null) {
            System.out.println("Tam nie su dvere.");
            return false;
        } else if (dvere.zamknute()) {
            System.out.println("Tieto dvere su zamknute.");
            return false;
        } else {
            this.aktualnaMiestnost = dvere.dajDruhuMiestnost(this.aktualnaMiestnost);
            return true;
        }      
    }

    void zober(String menoPredmetu) {
        IPredmet item = this.getAktualnaMiestnost().odober(menoPredmetu);
        this.batoh.put(item.getMeno(), item);
    }

    void poloz(String menoPredmetu) {
        IPredmet item = this.batoh.remove(menoPredmetu);
        this.getAktualnaMiestnost().pridaj(item);
        
    }

    boolean maPredmet(String menoPredmetu) {
        return this.batoh.containsKey(menoPredmetu);
    }

    public void preskumaj(String menoPredmetu) {
        if (this.maPredmet(menoPredmetu)) {
            System.out.println(this.batoh.get(menoPredmetu).getPopis());       
        } else {
            System.out.println("Taky predmet nemas v batohu");
        }
        
    }

    void pouzi(String menoPredmetu) {
        if (this.maPredmet(menoPredmetu)) {
            this.batoh.get(menoPredmetu).pouzi(this);       
        } else {
            System.out.println("Taky predmet nemas v batohu");
        } 
    }
    
    
}
