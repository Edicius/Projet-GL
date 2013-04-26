package projet_gl;

/**
 *  La classe attribut represente la donnee du lien qui relie deux noeuds.
 *  Cette donnee est caracterise par un nom et une valeur qui lui est associe.
 *  Exemple : since (nom) = 2011 (valeur)
 *
 */
public class Attribut {
    
    private String nom;
    private String valeur;

    public String getNom() {
        return nom;
    }

    public String getValeur() {
        return valeur;
    }

    public Attribut(String nom, String valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }
    
}

