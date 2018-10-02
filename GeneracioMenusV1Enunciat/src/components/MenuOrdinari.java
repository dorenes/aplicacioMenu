/*
 * Classe que defineix un menú ordinari. Un menú ordinari es defineix pel seu codi,
 * data de creació i un vector amb els plats (receptes) que formen part del menú.
 */
package components;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fta
 */
public class MenuOrdinari {

    private int codi;
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

    /*
     Mètodes accessors    
     */
   
    public void mostrarMenu() {
        System.out.println("\nLes dades del menú amb codi " + codi + " són:");
        SimpleDateFormat formatData= new SimpleDateFormat("D - E dd-MM-yy hh:mm:ss");
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
    public void afegirPlat() {

    }
}
