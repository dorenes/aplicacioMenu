/*
 * Classe que defineix un menú ordinari. Un menú ordinari es defineix pel seu codi,
 * data de creació i un vector amb els plats (receptes) que formen part del menú.
 */
package components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class MenuOrdinari {

    private static final Scanner DADES = new Scanner(System.in);

    private static int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private Date data; //data de creació del menú
    private Recepta[] plats;

    /*
     CONSTRUCTOR
     Paràmetres: cap
     Accions:
     - plats s'ha d'inicialtizar buit i amb una capacitat per 3 plats.
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - data s'ha d'incialitzar amb la data actual del sistema.     
     */
    public MenuOrdinari() {
        codi = properCodi;
        properCodi++;
        data = new Date();
        plats = new Recepta[3];

    }

    /*
     Mètodes accessors    
     */
    public void setCodi(int mCodi) {
        codi = mCodi;
    }

    public void setProperCodi(int mProper) {
        properCodi = mProper;
    }

    public void setPlats(Recepta[] platos) {
        plats = platos;
    }

    public Date getData() {
        return new Date();
    }

    public int getCodi() {
        return codi;
    }

    public Recepta[] getPlats() {
        return plats;
    }

    public void mostrarMenu() {
        System.out.println("\nLes dades del menú amb codi " + codi + " són:");
        SimpleDateFormat formatData = new SimpleDateFormat("D - E dd-MM-yy hh:mm:ss");
        System.out.println("\nData de creació:" + formatData.format(data));
        System.out.println("\nPlats:");
        for (int i = 0; i < plats.length; i++) {
            switch (i) {
                case 0:
                    if (plats[0] == null) {
                        System.out.println("\nNo hi ha primer plat");
                    } else {
                        System.out.println("\nPrimer plat: ");
                        plats[0].mostrarRecepta();
                    }
                    break;
                case 1:
                    if (plats[1] == null) {
                        System.out.println("\nNo hi ha segon plat");
                    } else {
                        System.out.println("\nSegon plat: ");
                        plats[1].mostrarRecepta();
                    }
                    break;
                case 2:
                    if (plats[2] == null) {
                        System.out.println("\nNo hi ha postres");
                    } else {
                        System.out.println("\nPostres: ");
                        plats[2].mostrarRecepta();
                    }
                    break;
            }
        }
    }

    /*
     PLATS
     */
 /*
     Paràmetres: recepta a afegir
     Accions:
     - Afegeix la recepta passada per paràmetre en la posició (si aquesta està buida)
     corresponent del vector de plats segons el tipus de recepta, és a dir, si és
     un primer plat s'ha de situar en la posició 0 de plats, si és un segon en la 
     posició 1 i si és una postre, en la posició 2.
     - L'estat de la recepta afegida a de canviar a verdader.
     Retorn: cap
     */
    public void afegirPlat(Recepta recep) {
        boolean afegit = false;

        switch (recep.getTipus()) {
            case "1":
                if (plats[0] == null) {
                    plats[0] = recep;
                    afegit = true;
                }
                break;
            case "2":
                if (plats[1] == null) {
                    plats[1] = recep;
                    afegit = true;
                }
                break;
            case "P":
                if (plats[2] == null) {
                    plats[2] = recep;
                    afegit = true;
                }
                break;
        } //fi switch
    } // fi afegir plat

   /* PARA MAS ADELANTE
    public void afegirPlatManual(Recepta recep) {
        boolean afegit = false;
        String resposta;

        System.out.println("Vols afegir primer plat? s/n");
        resposta = DADES.next();
        if(resposta.equals("s")){
            for (int i = 0; i < plats.length; i++) {
                if(recep.getTipus()=="1"){
                    recep.mostrarRecepta();
                }               
            } // fi for mostrar plats
            
        }
    }// fi afegir plat manual*/

}
