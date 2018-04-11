/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.hra;

import fri.worldOfFri.predmety.IPouzitelny;
import fri.worldOfFri.prostredie.IDvere;
import fri.worldOfFri.predmety.IPredmet;
import fri.worldOfFri.prostredie.MapaFakulty;
import fri.worldOfFri.prostredie.Miestnost;
import fri.worldOfFri.questy.NajdiNavleky;
import fri.worldOfFri.questy.Quest;
import fri.worldOfFri.questy.StavQuestu;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jancigova2
 */
public class Hrac {

    private Miestnost aktualnaMiestnost;
    private HashMap<String, IPredmet> batoh;
    private ArrayList<Quest> diar;
    
    public Hrac(MapaFakulty mapa) {
        this.aktualnaMiestnost = mapa.getStartovaciaMiestnost();
        this.batoh = new HashMap<String, IPredmet>();
        this.diar = new ArrayList<>();
        
        NajdiNavleky quest = new NajdiNavleky();
        this.pridajQuest(quest);
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    boolean chod(String smer) {
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

    public boolean maPredmet(String menoPredmetu) {
        return this.batoh.containsKey(menoPredmetu);
    }

    public void preskumaj(String menoPredmetu) {
        if (this.maPredmet(menoPredmetu)) {
            System.out.println(this.batoh.get(menoPredmetu).getPopis());       
        } else {
            System.out.println("Taky predmet nemas v batohu");
        }
        
    }

    void pouzi(String naPouzitie) {
        if (this.maPredmet(naPouzitie)) {
            if (this.batoh.get(naPouzitie) instanceof IPouzitelny) {
                IPouzitelny pouzitelnyPredmet = (IPouzitelny)this.batoh.get(naPouzitie);
                pouzitelnyPredmet.pouzi(this);
            }       
        } else {
            if (this.aktualnaMiestnost instanceof IPouzitelny) {
                IPouzitelny pouzitelnaMiestnost = (IPouzitelny)this.aktualnaMiestnost;
                pouzitelnaMiestnost.pouzi(this);
            } else {
                System.out.println(naPouzitie + " sa neda pouzit.");
            } 
        }
    }  

    private void pridajQuest(Quest quest) {
        if (quest!=null && quest.getStav()==StavQuestu.NAZADANY) {
            this.diar.add(quest);
        }     
    }
    
    void skontrolujQuesty() {
        for (Quest quest : diar) {
            quest.skontrolujCiSplneny(this); 
        }
    }
    
    void vypisQuesty() {
        for (Quest quest : diar) {
            System.out.println(quest.getPopis());
        }
    }
}
