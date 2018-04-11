package fri.worldOfFri.hra;

import fri.worldOfFri.prostredie.Miestnost;
import fri.worldOfFri.prikazy.Prikaz;
import fri.worldOfFri.prikazy.Parser;
import fri.worldOfFri.prostredie.MapaFakulty;

/**
 * Trieda Hra je hlavna trieda aplikacie "World of FRI". "World of FRI" je velmi
 * jednoducha textova hra - adventura. Hrac sa moze prechadzat po niektorych
 * priestoroch - miestnostiach fakulty. To je v tejto verzii vsetko. Hru treba
 * skutocne zancne rozsirit, aby bola zaujimava.
 *
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy Hra (hra) a poslite
 * jej spravu hraj.
 *
 * Hra vytvori a inicializuje vsetky potebne objekty: vytvori vsetky miestnosti,
 * vytvori parser a zacne hru. Hra tiez vyhodnocuje a vykonava prikazy, ktore
 * vrati parser.
 *
 * @author Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Hra {

    private Parser parser;
    private Miestnost aktualnaMiestnost;
    private Hrac hrac;

    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        MapaFakulty mapa = new MapaFakulty();
        this.hrac = new Hrac(mapa);
        this.parser = new Parser();
    }

    /**
     * Hlavna metoda hry. Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.
        boolean jeKoniec;

        do {
            Prikaz prikaz = this.parser.nacitajPrikaz();
            jeKoniec = this.vykonajPrikaz(prikaz);
        } while (!jeKoniec);

        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        this.hrac.getAktualnaMiestnost().vypisInfo();
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    private boolean vykonajPrikaz(Prikaz prikaz) {
        boolean jeKoniec = false;

        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();

        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz);
                return false;
            case "zober":
                this.zober(prikaz);
                return false;
            case "poloz":
                this.poloz(prikaz);
                return false;
            case "questy":
                this.hrac.vypisQuesty();
                return false;
            case "preskumaj":
                this.preskumaj(prikaz);
                return false;
            case "pouzi":
                this.pouzi(prikaz);
                return false;    
            case "ukonci":
                return this.ukonciHru(prikaz);
            default:
                return false;
        }
    }

    // implementacie prikazov:
    /**
     * Vypise text pomocnika do terminaloveho okna. Text obsahuje zoznam moznych
     * prikazov.
     */
    private void vypisNapovedu() {
        System.out.println("Zabludil/a si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc zober poloz questy preskumaj pouzi");
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom. Ak je tym
     * smerom vychod, hrac prejde do novej miestnosti. Inak sa vypise chybova
     * sprava do terminaloveho okna.
     */
    private void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        if (this.hrac.chod(smer)) {
            this.hrac.getAktualnaMiestnost().vypisInfo();
        } else {
            //System.out.println("Tam nie je vychod");
            this.hrac.getAktualnaMiestnost().vypisInfo();
        }
        
    }

    /**
     * Ukonci hru. Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * Prikaz ukoncenia nema parameter.
     *
     * @return true, if this command quits the game, false otherwise.
     * @return true, ak prikaz konci hru, inak false.
     */
    private boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

    private void zober(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevieme co zobrat
            System.out.println("Zober co?");
            return;
        }
        
        String menoPredmetu = prikaz.getParameter();
        
        if (this.hrac.getAktualnaMiestnost().maPredmet(menoPredmetu)) {
            this.hrac.zober(menoPredmetu);
            System.out.println("Zobral/a si " + menoPredmetu);
            this.hrac.skontrolujQuesty();
        } else {
            System.out.println("Taky predmet tu nie je");
            this.hrac.getAktualnaMiestnost().vypisInfo();
        }
    }

    private void poloz(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevieme co polozit
            System.out.println("Poloz co?");
            return;
        }
        
        String menoPredmetu = prikaz.getParameter();
        
        if (this.hrac.maPredmet(menoPredmetu)) {
            this.hrac.poloz(menoPredmetu);
            System.out.println("Polozil/a si " + menoPredmetu);
        } else {
            System.out.println("Taky predmet nemas v batohu");
        }
    }

    private void preskumaj(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevieme co preskumat
            System.out.println("Preskumaj co?");
            return;
        }
        
        String menoPredmetu = prikaz.getParameter();
        this.hrac.preskumaj(menoPredmetu);
            
    }

    private void pouzi(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevieme co pouzit
            System.out.println("Pouzi co?");
            return;
        }
        
        String menoPredmetu = prikaz.getParameter();
        this.hrac.pouzi(menoPredmetu);
    }  
}
