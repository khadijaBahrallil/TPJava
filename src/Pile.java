import java.io.IOException;

public class Pile {
    //fields
    private int[] t;
    private int i;
    static private int n =100;
    //constructor
    public Pile(){
        this.i=-1;
        this.t= new int[n];
    }

    //methods
    public void empile(int element){
        t[i+1] = element;
        i++;
    }
    int getSommet(){
        return t[i];
    }
    public int depile(){

        i--;
        return t[i+1];
    }

    public void displayPile(){
        int position=0;

        while ( position <= i) {
            System.out.println(t[position]);
            position++;}
    }
    public void empile1_10() {
        for(int j=1;j<=10;j++)
            empile(j);
    }

    public int somme(){
        int somme = 0;
        for(int e : this.t ){
            somme += e;
        }
        return somme;
    }
    public void plus(){
        int resultat ;
        resultat = this.t[i];
        depile();
        resultat += this.t[i];
        depile();
        empile(resultat);
    }

    public void somme2(){
        while (i!=0){
            plus();
        }
    }
    public void mult(){
        int resultat ;
        resultat = this.t[i];
        depile();
        resultat *= this.t[i];
        depile();
        empile(resultat);
    }

    public void dup(){

        empile(t[i]);
    }

}
