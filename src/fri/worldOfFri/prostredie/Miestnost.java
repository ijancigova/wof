package fri.worldOfFri.prostredie;


import fri.worldOfFri.predmety.IPredmet;
import java.util.Collection;
import java.util.HashMap;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private String popisMiestnosti;
    private String nazovMiestnosti;
    private HashMap<String, Miestnost> vychody;
    private HashMap<String, IPredmet> inventar;
    private HashMap<String, IDvere> zoznamDveri;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String nazov, String popis) {
        this.vychody = new HashMap<String, Miestnost>();
        this.inventar = new HashMap<String, IPredmet>();
        this.zoznamDveri = new HashMap<String, IDvere>();
        this.popisMiestnosti = popis;
        this.nazovMiestnosti = nazov;
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param nazov nazov smeru.
     * @param vychod miestnost danym smerom .
     */
    public void nastavVychod(String nazov, Miestnost vychod) {
        this.vychody.put(nazov, vychod);
    }

    public Miestnost getVychod(String smer) {
        return this.vychody.get(smer);
    }
    
    public String getNazov() {
        return this.nazovMiestnosti;
    }

    public void vypisInfo() {
        System.out.print("Teraz si v miestnosti ");
        System.out.println(this.nazovMiestnosti + ", " + this.popisMiestnosti);
        System.out.print("Vychody: ");
        
        for (String nazov : this.zoznamDveri.keySet()) {
            System.out.print(nazov + " ");
        }
        
        System.out.println();
        
        this.vypisPredmety();
    }

    public void spawn(IPredmet item) {
        this.inventar.put(item.getMeno(), item);
    }

    public boolean maPredmet(String menoPredmetu) {
        return this.inventar.containsKey(menoPredmetu);
    }

    public IPredmet odober(String menoPredmetu) {
        return this.inventar.remove(menoPredmetu);  
    }
    
    public void pridaj(IPredmet item) {
        this.inventar.put(item.getMeno(), item);  
    }

    protected void vypisPredmety() {
        System.out.print("Predmety: ");
        for (String nazov : this.inventar.keySet()) {
            System.out.print(nazov + " ");          
        }
        System.out.println();
    }

    void nastavDvere(String nazov, IDvere dvere) {
        this.zoznamDveri.put(nazov, dvere);
    }

    public IDvere getDverePodlaSmeru(String smer) {
        return this.zoznamDveri.get(smer);
    }

    public Collection<IDvere> dajZoznam() {
        return this.zoznamDveri.values();
    }
}
