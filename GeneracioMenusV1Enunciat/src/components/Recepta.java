/*
 * Classe que defineix una recepta. Una recepta es defineix pel seu codi, nom,
 * un vector amb el seus ingredients (aliments), el text amb els passos per la seva elaboració,
 * el tipus de recepta què és, és a dir, si és un primer plat, un segon o postres,
 * i les calories que té.
 */
package components;

/**
 *
 * @author fta
 */
public class Recepta {
    
    private String codi;
    private String nom;
    private Aliment[] ingredients;
    private int posicioIngredients; //Possició actual buida del vector ingredients
    private String elaboracio;
    private String tipus;
    private double calories;
    private boolean assignada;

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

    /*
     Mètodes accessors    
     */  
    
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
