/*
 * Classe que defineix un aliment. Un aliment es defineix pel seu codi, nom
 * i quantitat.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Aliment {

    private static final Scanner DADES = new Scanner(System.in);

    private String codi;
    private String nom;
    private double quantitat;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public Aliment() {
        codi = "";
        nom = "";
        quantitat = 0;
    }

    public Aliment(String aCodi, String aNom, double aQuantitat) {
        codi = aCodi;
        nom = aNom;
        quantitat = aQuantitat;
    }


    /*
     Mètodes accessors    
     */
    public void setCodi(String aCodi) {
        codi = aCodi;
    }

    public void setNom(String aNom) {
        nom = aNom;
    }

    public void setQuantitat(double aQuantitat) {
        quantitat = aQuantitat;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public double getQuantitat() {
        return quantitat;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou aliment. Les dades
     a demanar són les que necessita el constructor.
     - També heu de tenir en compte que el nom, no té perquè estar formt per una única
     paraula, per exemple, farina de força.
     Retorn: El nou aliment.
     */ public static Aliment nouAliment() {
        Aliment alim = new Aliment();
        
        System.out.println("Codi aliment:");
        alim.codi=DADES.next();
        System.out.println("Nom aliment:");
        alim.nom = DADES.nextLine();
        System.out.println("Quantitat:");
        alim.quantitat = DADES.nextInt();
        
        return alim;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarAliment() {

        System.out.println("Nou codi de l'aliment:");
        codi=DADES.next();
        System.out.println("Nou nom per l'aliment:");
        nom=DADES.nextLine();
        System.out.println("Nova quantitat:");
        quantitat=DADES.nextInt();
        mostrarAliment();
    }

    public void mostrarAliment() {
        System.out.println("\nLes dades de l'aliment amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nQuantitat: " + quantitat);
    }
}
