/*
 * Classe que defineix una cuina. Una cuina es defineix per un codi i una adreça
 * (l'adreça del pis d'estudiants al que pertany la cuina). A més, contindrà arrays 
 * amb receptes, aliments, menús ordinàris i menús de règim. 
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
public class Cuina {

    private static final Scanner DADES = new Scanner(System.in);

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String adreca;
    private Recepta[] receptes;
    private int posicioReceptes; //Possició actual buida del vector receptes
    private Aliment[] aliments;
    private int posicioAliments; //Possició actual buida del vector aliments
    private MenuOrdinari[] menusOrdinaris;
    private int posicioMenusOrdinaris; //Possició actual buida del vector menusOrdinaris
    private MenuRegim[] menusRegim;
    private int posicioMenusRegim; //Possició actual buida del vector menusRegim

    /*
     CONSTRUCTOR
     Paràmetres: valor per l'atribut adreca
     Accions:
     - Assignar a l'atribut corresponent el valor passat com a paràmetre
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - receptes s'ha d'inicialtizar buit i amb una capacitat per 100 receptes.
     - aliments s'ha d'inicialtizar buit i amb una capacitat per 150 aliments.
     - menusOrdinaris s'ha d'inicialtizar buit i amb una capacitat per 50 menús ordinàris.
     - menusRegim s'ha d'inicialtizar buit i amb una capacitat per 50 menús de règim.
     - posicioReceptes, posicioAliments, posicioMenusOrdinaris i posicioMenusRegim
     s'han d'inicialtizar a 0, ja que és la primera posició del vector aliments.
     */
    public Cuina() {
        codi = properCodi;
        properCodi++;
        adreca = "";
        receptes = new Recepta[100];
        posicioReceptes = 0;
        aliments = new Aliment[150];
        posicioAliments = 0;
        menusOrdinaris = new MenuOrdinari[50];
        posicioMenusOrdinaris = 0;
        menusRegim = new MenuRegim[50];
        posicioMenusRegim = 0;
    }

    /*
     Mètodes accessors    
     */
    public void setCodi(int cCodi) {
        codi = cCodi;
    }

    public int getCodi() {
        return codi;
    }

    public void setProperCodi(int cProperCodi) {
        properCodi = cProperCodi;
    }

    public int getProperCodi() {
        return properCodi;
    }

    public void setAdreca(String cAdreca) {
        adreca = cAdreca;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setRecepta(Recepta[] recept) {
        receptes = recept;
    }

    public Recepta[] getRecepta() {
        return receptes;
    }

    public void setPosicioReceptes(int cPosicioReceptes) {
        posicioReceptes = cPosicioReceptes;
    }

    public int getPosicioReceptes() {
        return posicioReceptes;
    }

    public void setAliment(Aliment[] alim) {
        aliments = alim;
    }

    public Aliment[] getAliment() {
        return aliments;
    }

    public void setPosicioAliments(int cPosicioAliments) {
        posicioAliments = cPosicioAliments;
    }

    public int getPosicioAliments() {
        return posicioAliments;
    }

    public void setMenuOrdinari(MenuOrdinari[] menOr) {
        menusOrdinaris = menOr;
    }

    public MenuOrdinari[] getMenuOrdinari() {
        return menusOrdinaris;
    }

    public void setPosicioMenusOrdinaris(int posMenOr) {
        posicioMenusOrdinaris = posMenOr;
    }

    public int getPosicioMenusOrdinaris() {
        return posicioMenusOrdinaris;
    }

    public void setMenuRegim(MenuRegim[] menRe) {
        menusRegim = menRe;
    }

    public MenuRegim[] getMenuRegim() {
        return menusRegim;
    }

    public void setPosicioMenusRegim(int posMeRe) {
        posicioMenusRegim = posMeRe;
    }

    public int getPosicioMenusRegim() {
        return posicioMenusRegim;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova Cuina. Les dades
     a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom de l'adreça, poden ser frases, per exemple,
     C/ Gandia, 2.
     Retorn: La nova cuina creada.
     */
    public static Cuina novaCuina() {
        Cuina novaCuina = new Cuina();
        System.out.println("Adreca:");
        novaCuina.adreca = DADES.nextLine();
        return novaCuina;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només el de l'atribut adreça. 
     Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari els valors actuals dels atributs de l'objecte
     actual, abans de modificar-los.
     Retorn: cap
     */
    public void modificarCuina() {
        mostrarCuina();
        System.out.println("Introdueix l'adreça nova:");
        adreca = DADES.nextLine();
    }

    public void mostrarCuina() {
        System.out.println("\nLes dades de la cuina amb codi " + codi + " són:");
        System.out.println("\nAdreça:" + adreca);
    }

    /*
     RECEPTA
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix una nova recepta al vector de receptes d'aquesta cuina (l'objecte actual),
     fent servir el mètode de la classe Recepta pertinent.
     - actualitza la posició del vector de receptes.
     Retorn: cap
     */
    public void afegirRecepta() {

        receptes[posicioReceptes] = Recepta.novaRecepta();
        posicioReceptes++;
    }

    public int seleccionarRecepta() {

        System.out.println("\nCodi de la recepta?:");
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioReceptes && !trobat; i++) {
            if (receptes[i].getCodi().equals(DADES.next())) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     ALIMENT
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou aliment al vector d'aliments d'aquesta cuina (l'objecte actual),
     si aquest encara no s'ha afegit, fent servir el mètode de la classe Aliment pertinent,    
     i actualitza la posició del vector d'aliments.
     - heu de fer servir el mètode escaient d'aquesta classe per comprovar si l'aliment
     ja s'ha afegit o no.
     - Si l'aliment ja s'habia afegit, no s'afegirà de nou i li mostrarem a l'usuari
     el missatge "\nL'aliment ja existeix".
     Retorn: cap
     */
    public void afegirAliment() {

        Aliment alim = Aliment.nouAliment();
        if (aliments[posicioAliments] == null) {
            if (seleccionarAliment(alim.getCodi()) == -1) {
                aliments[posicioAliments] = Aliment.nouAliment();
                posicioAliments++;
            } else {
                System.out.println("\nL'aliment ja existeix");
            }

        }

    }

    public int seleccionarAliment(String codi) {

        if (codi == null) {
            System.out.println("\nCodi de l'aliment?:");
            codi = DADES.next();
        }

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioAliments && !trobat; i++) {
            if (aliments[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     MENÚ ORDINARI
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou menú ordinari al vector de menús ordinaris d'aquesta cuina (l'objecte actual),
     fent servir el mètode de la classe MenuOrdinar pertinent.
     - actualitza la posició del vector de menús ordinaris.
     Retorn: cap
     */
    public void afegirMenuOrdinari() {

        menusOrdinaris[posicioMenusOrdinaris] = new MenuOrdinari();
        posicioMenusOrdinaris++;

    }

    public int seleccionarMenuOrdinari() {

        System.out.println("\nCodi del menú ordinari?:");
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioMenusOrdinaris && !trobat; i++) {
            if (menusOrdinaris[i].getCodi() == DADES.nextInt()) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     MENÚ RÈGIM
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou menú de règim al vector de menús de regim d'aquesta cuina (l'objecte actual),
     fent servir el mètode de la classe MenuRegim pertinent.
     - actualitza la posició del vector de menús de regim.
     Retorn: cap
     */
    public void afegirMenuRegim() {
        menusRegim[posicioMenusRegim] = MenuRegim.nouMenuRegim();
        posicioMenusRegim++;
    }

    public int seleccionarMenuRegim() {

        System.out.println("\nCodi del menú de règim?:");
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioMenusRegim && !trobat; i++) {
            if (menusRegim[i].getCodi() == DADES.nextInt()) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     Paràmetres: cap
     Accions:
     - afegeix un nou ingredient al vector d'ingredients d'una recepta seleccionada,
     si la recepta existeix en la cuina.
     - heu de fer servir el mètode escaient d'aquesta classe per seleccionar la 
     recepta i el mètode escaient de la classe Recepta per afegir l'ingredient
     a la recepta seleccionada.
     - Si la recepta no existeix, no s'afegirà cap ingredient i li mostrarem a l'usuari
     el missatge "\nNo existeix aquesta recepta".
     Retorn: cap
     */
    public void afegeixIngredientRecepta() {
        int pos = seleccionarRecepta();

        if (pos == -1) {
            System.out.println("\nNo existeix aquesta recepta");
        } else {
            receptes[pos].afegirIngredient();
        }

    }

    /*
     Paràmetres: vector booleà de 3 posicions. La posició 0 representa el primer 
     plat del menú, la 1 el segon plat i la 3 les postres. Si es vol incloure algun
     dels plats al menú, el valor serà cert, si no fals.
     Accions:
     - Afegirem els plats (receptes) segons els valors del vector passat per paràmetre,
     a l'últim menú afegit al vector de menús ordinaris.
     - Heu d'afegir els plats tenint en compte que els seus ingredients i quantitats
     dels mateixos, es troben actualment en la cuina (vector d'ingredients) i que no
     està assignat a un altre menú.
     - Per afegir els plats heu de fer servir el mètode pertinent de la classe MenuOrdinari.    
     - Un cop afegits els plats al menú, l'aplicació finalitzarà.
     Retorn: cap
     */
 /*
    =======================
    
     */
    public void afegeixPlatsMenuOrdinari(boolean plat[]) {

        if (plat[0] == true) {
            boolean receptaAfegida = false;

            for (int i = 0; i < posicioReceptes && receptes[i].getTipus().equals("1") && receptes[i].getAssignada() == false && receptaAfegida == false; i++) {

                boolean alimentValid = true;

                for (int j = 0; j < posicioAliments && alimentValid == true; j++) {
                    int pos = seleccionarAliment(receptes[i].getIngredients()[j].getCodi());

                    if (pos > -1) {
                        if (aliments[j].getQuantitat() < receptes[i].getIngredients()[j].getQuantitat()) {
                            alimentValid = false;
                        }

                    }
                }
                if (alimentValid == true) {
                    menusOrdinaris[posicioMenusOrdinaris - 1].afegirPlat(receptes[i]);
                    receptaAfegida = true;
                }
            }
        } // if de plat 0
        if (plat[1] == true) {
            boolean receptaAfegida = false;

            for (int i = 0; i < posicioReceptes && receptes[i].getTipus().equals("2") && receptes[i].getAssignada() == false && receptaAfegida == false; i++) {

                boolean alimentValid = true;

                for (int j = 0; j < posicioAliments && alimentValid == true; j++) {
                    int pos = seleccionarAliment(receptes[i].getIngredients()[j].getCodi());

                    if (pos > -1) {
                        if (aliments[j].getQuantitat() < receptes[i].getIngredients()[j].getQuantitat()) {
                            alimentValid = false;
                        }

                    }
                }
                if (alimentValid == true) {
                    menusOrdinaris[posicioMenusOrdinaris - 1].afegirPlat(receptes[i]);
                    receptaAfegida = true;
                }
            }
        } // if de plat 1
        if (plat[2] == true) {
            boolean receptaAfegida = false;

            for (int i = 0; i < posicioReceptes && receptes[i].getTipus().equals("P") && receptes[i].getAssignada() == false && receptaAfegida == false; i++) {

                boolean alimentValid = true;

                for (int j = 0; j < posicioAliments && alimentValid == true; j++) {
                    int pos = seleccionarAliment(receptes[i].getIngredients()[j].getCodi());

                    if (pos > -1) {
                        if (aliments[j].getQuantitat() < receptes[i].getIngredients()[j].getQuantitat()) {
                            alimentValid = false;
                        }

                    }
                }
                if (alimentValid == true) {
                    menusOrdinaris[posicioMenusOrdinaris - 1].afegirPlat(receptes[i]);
                    receptaAfegida = true;
                }
            }
        } // if de Postres

    }


    /*
     Paràmetres: calories que ha de tenir el menú.
     Accions:
     - Afegirem els plats (receptes) tenint en compte que la suma total de les calories
     dels plats, no pot ser major que les calories passades per paràmetre.
     - En aquest cas també hi haurà un primer plat, segon i postres com a màxim,
     tot dependrà de les calories. És a dir, si trobem una recepta que té les mateixes
     calories o s'apropa a les passades per paràmetre, el menú només tindrà un plat. 
     Si la suma de les calories de dos plats (per exemple, primer i segon) coincideix 
     o s'apropa a les calories passades per paràmetre, el menú constarà només d'un 
     primer i un segon, i de la mateixa manera si la suma és igual a les calories 
     de tres plats (primer, segon i postres), el menú constarà de 3 plats.
     - Heu d'afegir els plats tenint en compte que els seus ingredients i quantitas
     dels mateixos, es troben actualment en la cuina (vector d'ingredients) i que no
     està assignat a un altre menú.
     - Per afegir els plats heu de fer servir el mètode pertinent de la classe MenuRegim.    
     - Un cop afegits els plats al menú, l'aplicació finalitzarà.
     Retorn: cap
     */
    public void afegeixPlatsMenuRegim(int calories) {
        double caloriesTotal = 0;
        boolean receptaAfegida = false;

        //plat 1
        for (int i = 0; i < posicioReceptes && receptes[i].getTipus().equals("1")
                && receptes[i].getAssignada() == false && receptaAfegida == false; i++) {

            if (receptes[i].getCalories() < calories) {
                boolean alimentValid = true;

                for (int j = 0; j < posicioAliments && alimentValid == true; j++) {
                    int pos = seleccionarAliment(receptes[i].getIngredients()[j].getCodi());

                    if (pos > -1) {
                        if (aliments[j].getQuantitat() < receptes[i].getIngredients()[j].getQuantitat()) {
                            alimentValid = false;
                        }

                    }
                }
                if (alimentValid == true) {
                    menusRegim[posicioMenusRegim - 1].afegirPlat(receptes[i]);
                    receptaAfegida = true;
                    caloriesTotal = +receptes[i].getCalories();
                }
            }
        }
        //Plat 2
        if (caloriesTotal < calories) {
            
            receptaAfegida = false;
            
            for (int i = 0; i < posicioReceptes && receptes[i].getTipus().equals("2")
                    && receptes[i].getAssignada() == false && receptaAfegida == false; i++) {

                if ((receptes[i].getCalories() + caloriesTotal) < calories) {
                    boolean alimentValid = true;

                    for (int j = 0; j < posicioAliments && alimentValid == true; j++) {
                        int pos = seleccionarAliment(receptes[i].getIngredients()[j].getCodi());

                        if (pos > -1) {
                            if (aliments[j].getQuantitat() < receptes[i].getIngredients()[j].getQuantitat()) {
                                alimentValid = false;
                            }

                        }
                    }
                    if (alimentValid == true) {
                        menusRegim[posicioMenusRegim - 1].afegirPlat(receptes[i]);
                        receptaAfegida = true;
                        caloriesTotal = +receptes[i].getCalories();
                    }
                }
            }
        }
        //Postres
        if (caloriesTotal < calories) {
            
            receptaAfegida = false;
            
            for (int i = 0; i < posicioReceptes && receptes[i].getTipus().equals("P")
                    && receptes[i].getAssignada() == false && receptaAfegida == false; i++) {

                if ((receptes[i].getCalories() + caloriesTotal) < calories) {
                    boolean alimentValid = true;

                    for (int j = 0; j < posicioAliments && alimentValid == true; j++) {
                        int pos = seleccionarAliment(receptes[i].getIngredients()[j].getCodi());

                        if (pos > -1) {
                            if (aliments[j].getQuantitat() < receptes[i].getIngredients()[j].getQuantitat()) {
                                alimentValid = false;
                            }

                        }
                    }
                    if (alimentValid == true) {
                        menusRegim[posicioMenusRegim - 1].afegirPlat(receptes[i]);
                        receptaAfegida = true;
                        caloriesTotal = +receptes[i].getCalories();
                    }
                }
            }
        }
    }

}
