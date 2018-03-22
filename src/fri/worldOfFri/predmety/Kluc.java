/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.predmety;
    
import fri.worldOfFri.prostredie.DvereNaKluc;
import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.prostredie.IDvere;
import java.util.ArrayList;
import java.util.Collection;


public class Kluc implements IPredmet, IPouzitelny {
    private String meno;
    private String popis;
    private ArrayList<IDvere> zoznamDveri;
    
    public Kluc(String meno, String popis) {
        this.meno = meno;
        this.popis = popis;
        this.zoznamDveri = new ArrayList<IDvere>();
    }
    
    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public String getPopis() {
        return this.meno;
    }

    @Override
    public void pouzi(Hrac hrac) {
        Collection<IDvere> tmpZoznamDveri = hrac.getAktualnaMiestnost().dajZoznam();
        for (IDvere dvere : tmpZoznamDveri) {
            if (this.zoznamDveri.contains(dvere)) {
                if (dvere instanceof DvereNaKluc) {
                    DvereNaKluc mojeDvere = (DvereNaKluc)dvere;
                    mojeDvere.odomkniZamkni();
                }
            }
        }
    }
    
    public void pridajDvere(IDvere dvere) {
        this.zoznamDveri.add(dvere);
    }
}
