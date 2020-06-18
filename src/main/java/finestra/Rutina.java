package finestra;



public class Rutina {

    String nom,Ex1,Ex2,Ex3;

    public Rutina(String nom, String ex1, String ex2, String ex3) {
        this.nom = nom;
        Ex1 = ex1;
        Ex2 = ex2;
        Ex3 = ex3;
    }

    public String getNom() {
        return nom;
    }

    public String getEx1() {
        return Ex1;
    }

    public String getEx2() {
        return Ex2;
    }

    public String getEx3() {
        return Ex3;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEx1(String ex1) {
        Ex1 = ex1;
    }

    public void setEx2(String ex2) {
        Ex2 = ex2;
    }

    public void setEx3(String ex3) {
        Ex3 = ex3;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "nom='" + nom + '\'' +
                ", Ex1='" + Ex1 + '\'' +
                ", Ex2='" + Ex2 + '\'' +
                ", Ex3='" + Ex3 + '\'' +
                '}';
    }
}
