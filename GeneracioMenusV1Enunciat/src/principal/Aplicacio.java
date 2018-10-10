/*
 * Classe Aplicacio per interactuar amb l'usuari i cridar a la resta de classes 
 * i mètodes mitjançant uns menús.
 */
package principal;

import components.Aliment;
import components.MenuOrdinari;
import components.MenuRegim;
import components.Recepta;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Aplicacio {

    private static final Scanner DADES = new Scanner(System.in);

    private static Cuina[] cuines = new Cuina[4];//Cuines dels estudiants
    private static int posicioCuines = 0; //La propera posició buida del vector cuines
    private static Cuina cuinaActual = null; //Cuina seleccionada    

    public static void main(String[] args) {

        menuPrincipal();

    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de cuines");
            System.out.println("\n2. Gestió de receptes");
            System.out.println("\n3. Gestió d'ingredients");
            System.out.println("\n4. Gestió de menús ordinaris");
            System.out.println("\n5. Gestió de menús de règim");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuCuina();
                    break;
                case 2:
                    if (cuinaActual != null) {
                        menuReceptes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                    break;
                case 3:
                    if (cuinaActual != null) {
                        menuAliments();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                    break;
                case 4:
                    if (cuinaActual != null) {
                        menuMenusOrdinaris();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                    break;
                case 5:
                    if (cuinaActual != null) {
                        menuMenusRegim();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    public static void menuCuina() {
        int opcio = 0;

        do {
            int pos = -1;

            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar cuines");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    cuines[posicioCuines] = Cuina.novaCuina();
                    posicioCuines++;
                    break;
                case 2:
                    pos = seleccionarCuina();
                    if (pos >= 0) {
                        cuinaActual = cuines[pos];
                    } else {
                        System.out.println("\nNo existeix aquesta cuina");
                    }
                    break;
                case 3:
                    pos = seleccionarCuina();
                    if (pos >= 0) {
                        cuines[pos].modificarCuina();
                    } else {
                        System.out.println("\nNo existeix aquesta cuina");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCuines; i++) {
                        cuines[i].mostrarCuina();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     Heu de desenvolupar el menú receptes amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una recepta en la cuina actual. Penseu que Cuina sap crear receptes       
     Opció 2. Modificar -->      Permet modificar una recepta que ha d'existir a la cuina actual
     (per comprovar l'existència tenim un mètode que ens ajuda a la classe Cuina)
     Opció 3. Afegir ingredient --> Afegeix un ingredient al vector d'ingredients d'una recepta, però
     penseu que Cuina sap fer-ho
     Opció 4. Llistar receptes-->Imprimeix les dades de les receptes de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
    public static void menuReceptes() {

        int opcio = 0;

        opcio = DADES.nextInt();
        System.out.println("Escull una opcio: ");
        while (opcio != 0) {
            System.out.println("0. Sortir.");
            System.out.println("1. Alta.");
            System.out.println("2. Modificar.");
            System.out.println("3. Afegir Ingredient.");
            System.out.println("4. Llistar receptes.");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    menuPrincipal();
                    break;
                case 1:
                    Cuina.novaCuina().afegirRecepta();
                    break;
                case 2:
                    Cuina.novaCuina().modificarCuina();
                    break;
                case 3:
                    Cuina.novaCuina().afegirAliment();
                    break;
                case 4:
                    Cuina.novaCuina().getRecepta(); //Falta trobar el metode (NO SE SI ESTA BE)
                    break;
                default:
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        }
    }

    /*
     Heu de desenvolupar el menú aliments amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un aliment en la cuina actual. Penseu que Cuina sap crear aliments       
     Opció 2. Modificar -->      Permet modificar un aliment que ha d'existir a la cuina actual
     (per comprovar l'existència tenim un mètode que ens ajuda a la classe Cuina)
     Opció 3. Llistar aliments-->Imprimeix les dades dels aliments de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
    public static void menuAliments() {

        int opcio = 0;
        int pos;

        System.out.println("Escull una opcio: ");
        opcio = DADES.nextInt();
        while (opcio != 0) {
            System.out.println("0. Sortir.");
            System.out.println("1. Alta.");
            System.out.println("2. Modificar.");
            System.out.println("3. Llistar aliments.");

            switch (opcio) {
                case 0:
                    menuPrincipal();
                    break;
                case 1:
                    Cuina.novaCuina().afegirAliment();
                    break;
                case 2:
                    pos = cuinaActual.seleccionarAliment(null);
                     cuinaActual.getAliment()[pos].modificarAliment();
                    break;
                case 3:
                    pos = cuinaActual.seleccionarAliment(null);
                    cuinaActual.getAliment()[pos].mostrarAliment(); 
                    break;
                default:
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;

            }
        }
    }

    /*
     Heu de desenvolupar el menú de menús ordinaris amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un nou menú ordinari en la cuina actual i li afegeix els
     plats necessaris. Penseu que Cuina sap crear menús ordinaris i afegir els seus plats.
     Per crear el nou menú, primer li heu de demanar a l'usuari quins són els plats que
     vol. Recordeu que els plats poden ser primer, segon i postres.
     Opció 2. Llistar menús ordinaris-->Imprimeix les dades dels menús ordinaris de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
    public static void menuMenusOrdinaris() {

        int opcio = 0;

        System.out.println("Escull una opcio: ");
        opcio = DADES.nextInt();
        while (opcio != 0) {
            System.out.println("0. Sortir.");
            System.out.println("1. Alta.");
            System.out.println("2. Llistar menus ordinaris.");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    menuPrincipal();
                    break;
                case 1:
                    Cuina.novaCuina().afegirMenuOrdinari();
                    break;
                case 2:
                    Cuina.novaCuina(); //Falta trobar el metode.
                    break;
                default:
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;

            }
        }
    }

    /*
     Heu de desenvolupar el menú de menús de règim amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un nou menú de règim en la cuina actual i li afegeix els
     plats necessaris. Penseu que Cuina sap crear menús ordinaris i afegir els seus plats. Abans
     de crear-lo, li demanarà a l'usuari les calories màximes del menú de règim.
     Opció 2. Llistar menús de règim-->Imprimeix les dades dels menús ordinaris de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
    public static void menuMenusRegim() {

        int opcio = 0;

        System.out.println("Escull una opcio: ");
        opcio = DADES.nextInt();
        while (opcio != 0) {
            System.out.println("0. Sortir.");
            System.out.println("1. Alta.");
            System.out.println("2. Llistar menus de regim.");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    menuPrincipal();
                    break;
                case 1:
                    Cuina.novaCuina().afegirMenuRegim();
                    break;
                case 2:
                    Cuina.novaCuina(); //Falta trobar el metode.
                    break;
                default:
                    System.out.println("S'ha de seleccionar una opció correcta del menú.");
                    break;

            }
        }
    }

    public static Integer seleccionarCuina() {

        System.out.println("\nCodi de la cuina?:");

        int codi = DADES.nextInt();
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioCuines && !trobat; i++) {
            if (cuines[i].getCodi() == codi) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

}
