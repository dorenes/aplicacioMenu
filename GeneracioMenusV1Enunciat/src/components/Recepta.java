/*
 * Classe que defineix una recepta. Una recepta es defineix pel seu codi, nom,
 * un vector amb el seus ingredients (aliments), el text amb els passos per la seva elaboració,
 * el tipus de recepta què és, és a dir, si és un primer plat, un segon o postres,
 * i les calories que té.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Recepta {

    private static final Scanner DADES = new Scanner(System.in);

    private String codi;
    private String nom;
    private Aliment[] ingredients = new Aliment[25];
    private int posicioIngredients = 0; //Possició actual buida del vector ingredients
    private String elaboracio;
    private String tipus;
    private double calories;
    private boolean assignada = false;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe, menys l'atribut ingredients
     , l'atribut posicioIngredients i l'atribut assignada.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - ingredients s'ha d'inicialtizar buit i amb una capacitat per 25 ingredients.
     - posicioIngredients s'ha d'inicialtizar a 0, ja que és la primera posició del
     vector ingredients.
     - assignada s'ha d'inicialitzar a false, ja que cuan es crea una recepta no està
     assignada a cap menú.
     */
    public Recepta(String cd, String nm, String elab, String tip, double cal) {
        codi = cd;
        nom = nm;
        elaboracio = elab;
        tipus = tip;
        calories = cal;
    }

    /*
     Mètodes accessors    
     */
    public void setCodi(String cd) {
        codi = cd;
    }

    public void setNom(String nm) {
        nom = nm;
    }

    public void setIngredients(Aliment[] alim) {
        ingredients = alim;
    }

    public void setPosicioIngredients() {
        posicioIngredients++;
    }

    public void setElaboracio(String elab) {
        elaboracio = elab;
    }

    public void setTipus(String tip) {
        tipus = tip;
    }

    public void setCalories(double cal) {
        calories = cal;
    }

    public void setAssignada(boolean as) {
        assignada = as;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public String getElaboracio() {
        return elaboracio;
    }

    public String getTipus() {
        return tipus;
    }

    public double getCalories() {
        return calories;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova recepta. Les dades
     a demanar són les que necessita el constructor.
    
     - En el cas del tipus, l'usuari ha d'introduir 1, si es tracta d'un primer plat, 2
     si es tracta d'un segon i P si són unes postres. Heu de comprovar que la dada
     introduida per l'usuari és la correcta (1, 2 o P) si no li mostrarem el missatge
     "\nLa dada introduida no és vàlida" i tornarem a demanr-li que introdueixi la dada.
     Això ho farem fins que introdueixi la dada correcta.
    
     - També heu de tenir en compte que l'elaboració, no estarà formada per una única
     paraula i que el nom, tampoc té perquè ser d'una única paraula, per exemple, 
     Francesc Xavier, o bé, matí i tarda.
     Retorn: La nova recepta.
     */
    public static Recepta novaRecepta() {
        String codi = "";
        String nom = "";
        String elaboracio = "";
        String tipus = "";
        double calories = 0;

        System.out.println("Introdueix les dades per crear la recepta:");
        System.out.println("Codi: ");
        codi = DADES.next();

        System.out.println("Nom: ");
        nom = DADES.nextLine();

        System.out.println("Elaboracio: ");
        elaboracio = DADES.nextLine();

        System.out.println("Tipus: 1:Primer plat, 2:segon plat, P:postre");
        tipus = DADES.nextLine();

        while (!tipus.equals("1") || !tipus.equals("2") || !tipus.equals("P")) {

            System.out.println("La dada introduida no és vàlida");

            System.out.println("Torna a introduir la dada.");
            tipus = DADES.nextLine();
        }

        System.out.println("Calories: ");
        calories = DADES.nextDouble();

        Recepta recepta = new Recepta(codi, nom, elaboracio, tipus, calories);

        return recepta; //Retorna l'objecte actual.
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas no
     es pot modificar l'atribut ingredients, ni l'atribut assignada.
     - En el cas del tipus, l'usuari ha d'introduir 1, si es tracta d'un primer plat, 2
     si es tracta d'un segon i P si són unes postres. Heu de comprovar que la dada
     introduida per l'usuari és la correcta (1, 2 o P) si no tornarem a demanr-li 
     que introdueixi la dada. Això ho farem fins que introdueixi la dada correcta.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarRecepta() {
        /*Quan el metode es public i volem editar o accedir als atributs del objecte actual, 
        s'ha de editar el atribut directament dins del metode.*/

 /*TAMBE ES CORRECTE*/
        System.out.println("Les dades actuals de la recepta son: ");
        System.out.println("codi" + getCodi());
        System.out.println("Nom" + getNom());
        System.out.println("Elaboracio" + getElaboracio());
        System.out.println("Tipus" + getTipus());
        System.out.println("Calories" + getCalories());

        System.out.println("Introdueix les dades a modificar de l'objecte actual: ");

        System.out.println("Codi: ");
        codi = DADES.nextLine();

        System.out.println("Nom: ");
        nom = DADES.nextLine();

        System.out.println("Elaboracio: ");
        elaboracio = DADES.nextLine();

        System.out.println("Tipus: 1:Primer plat, 2:segon plat, P:postre");
        tipus = DADES.nextLine();

        while (!tipus.equals("1") || !tipus.equals("2") || !tipus.equals("P")) {

            System.out.println("La dada introduida no és vàlida");

            System.out.println("Torna a introduir la dada.");
            tipus = DADES.nextLine();
        }

        System.out.println("Calories: ");
        calories = DADES.nextDouble();
    }

    public void mostrarRecepta() {
        System.out.println("\nLes dades de la recepta amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nTipus:" + tipus);
        System.out.println("\nCalories:" + calories);
        System.out.println("\nIngredients:");
        for (int i = 0; i < ingredients.length && ingredients[i] != null; i++) {
            ingredients[i].mostrarAliment();
        }
        System.out.println("\nElaboració:" + elaboracio);
    }

    /*
     INGREDIENT
     */
 /*
     Paràmetres: cap
     Accions:
    
     - afegeix un nou ingredient al vector d'ingredients d'aquesta recepta (l'objecte actual),
     si aquest encara no s'ha afegit, fent servir el mètode de la classe Ingredients pertinent,    
     i actualitza la posició del vector d'ingredients.
    
     - heu de fer servir el mètode escaient d'aquesta classe per comprovar si l'ingredient
     ja s'ha afegit o no.
    
     - Si l'ingredient ja s'habia afegit, no s'afegirà de nou i li mostrarem a l'usuari
     el missatge "\nL'ingredient ja existeix".
     Retorn: cap
     */
    public void afegirIngredient() {

        /*
        ingredients=new Aliment[posicioIngredient];
        posicioIngredients++;
         */
 /*
        Aliment ingredient = new Aliment();
        ingredients[posicioIngredients]=ingredient;
         */
        if (seleccionarIngredient(codi) == posicioIngredients) {
            System.out.println("L'ingredient ja existeix");
        } else {
            ingredients[posicioIngredients] = Aliment.nouAliment();
            posicioIngredients++;
        }

    }

    public int seleccionarIngredient(String codi) {

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioIngredients && !trobat; i++) {
            if (ingredients[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }
}
