/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fri.worldOfFri.prostredie;

import fri.worldOfFri.hra.Hrac;
import fri.worldOfFri.predmety.IPouzitelny;
import java.util.Collection;


public class Vytah extends Miestnost implements IPouzitelny {
    
    private int aktualnePoschodie;
    private boolean ideHore;
    
    public Vytah() {
        super("vytah", "vytah sa da pouzit");
        this.aktualnePoschodie = 0;
        this.ideHore = true;
    }

    @Override
    public void pouzi(Hrac hrac) {
        
        DvereVytahove dvere = this.dajDverePodlaPoschodia(this.aktualnePoschodie);
        dvere.odomkniZamkni();
        if (this.ideHore) {
            this.aktualnePoschodie++;
            this.vypisInfo();   
        } else {
            this.aktualnePoschodie--;
            this.vypisInfo();
        }
        
        if ((this.aktualnePoschodie == 2) || (this.aktualnePoschodie == 0)) {
            this.ideHore = !this.ideHore;
        }
        dvere = this.dajDverePodlaPoschodia(this.aktualnePoschodie);
        dvere.odomkniZamkni();   
    }
    
    public DvereVytahove dajDverePodlaPoschodia(int poschodie) {
        Collection<IDvere> tmpZoznamDveri = this.dajZoznam();
        for (IDvere dvere : tmpZoznamDveri) {
            if (dvere instanceof DvereVytahove) {
                DvereVytahove mojeDvere = (DvereVytahove)dvere;
                if (mojeDvere.getPoschodie() == poschodie) {
                    return mojeDvere;
                }
            }
        }
        System.out.println("Na tomto poschodi vytah nema dvere");
        return null;
    }
    
    @Override
    public void vypisInfo() {    
        System.out.println("Teraz si v miestnosti " + this.getNazov());
        String vychod = this.dajDverePodlaPoschodia(this.aktualnePoschodie).dajDruhuMiestnost(this).getNazov();
        System.out.println("Vychody: " + vychod);
        this.vypisPredmety();
    }
}
