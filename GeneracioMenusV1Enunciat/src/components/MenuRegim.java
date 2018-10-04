/*
 * Classe que defineix un menú de regim. Un menú de regim es defineix pel seu codi,
 * data de creació, un vector amb els plats (receptes) que formen part del menú i
 * les  calories del menú.
 */
package components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class MenuRegim {

    private static final Scanner DADES = new Scanner(System.in);

    private int codi = properCodi;
    private static int properCodi = 1; //El proper codi a assignar
    private Date data = new Date(); //data de creació del menú
    private Recepta[] plats = new Recepta[3];
    private double calories;

    /*
     CONSTRUCTOR
     Paràmetres: el valor a assignar a calories
    
     Accions:
     - Assignar a calories el valor passat com a paràmetre.
     - plats s'ha d'inicialtizar buit i amb una capacitat per 3 plats.
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - data s'ha d'incialitzar amb la data actual del sistema.     
     */
    public MenuRegim(double cal) {
        calories = cal;
    }

    /*
     Mètodes accessors    
     */
    public void setCodi(int cod) {
        codi = cod;
    }

    public void setproperCodi() {
        properCodi++;
    }

    public void setData(Date da) {
        data = da;
    }

    public void setPlats(Recepta[] re) {
        plats = re;
    }

    public void setCalories(double cal) {
        calories = cal;
    }

    public int getCodi() {
        return codi;
    }

    public int getproperCodi() {
        return properCodi;
    }

    public Date getData() {
        return data;
    }

    public Recepta[] getPlats() {
        return plats;
    }

    public double getCalories() {
        return calories;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou menú. Les dades
     a demanar són les que necessita el constructor, és a dir, les calories.
     Retorn: El nou Menú.
     */
    public static MenuRegim nouMenuRegim() {
        double calories = 0;

        System.out.println("Introdueix les Calories del menu: ");
        calories = DADES.nextDouble();

        MenuRegim menr = new MenuRegim(calories);

        return menr;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves calories de l'objecte actual
     i modificar les calories corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual de les calories de l'objecte
     actual, abans de modificar-les
     Retorn: cap
     */
    public void modificarMenuRegim() {
        System.out.println("Introdueix les noves calories per a la recepta actual: ");
        System.out.println("Calories: ");
        calories = DADES.nextDouble();

    }

    public void mostrarMenu() {
        System.out.println("\nLes dades del menú amb codi " + codi + " són:");
        SimpleDateFormat formatData = new SimpleDateFormat("D - E dd-MM-yy hh:mm:ss");
        System.out.println("\nData de creació:" + formatData.format(data));
        System.out.println("\nLes calories són: " + calories);
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
                        plats[0].mostrarRecepta();
                    }
                    break;
            }
        }
    }

    /*
     PLATS
     */
 /*
     Paràmetres: recepta (plat) a afegir
     Accions:
     - Afegeix la recepta passada per paràmetre en la posició corresponent del vector 
     de plats segons el tipus de recepta, és a dir, si és un primer plat s'ha de 
     situar en la posició 0 de plats, si és un segon en la posició 1 i si és una 
     postre, en la posició 2.    
     - L'estat de la recepta afegida a de canviar a verdader.
     Retorn: cap
     */
    public void afegirPlat(Recepta rec) {
        boolean asign = false;
        if (rec.getTipus().equals("1") == true) {
            plats[0] = rec;
            asign = true;

        } else if (rec.getTipus().equals("2") == true) {
            plats[1] = rec;
            asign = true;
        } else if (rec.getTipus().equals("P") == true) {
            plats[2] = rec;
            asign = true;
        }

        rec.setAssignada(asign);
    }
}
