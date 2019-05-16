import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class interprete {
    //fields
    public String code;
    public Pile pile;
    public ArrayList<String> liste ;
    public Dictionnaire dico;

    //constructor
    public interprete() {
        pile = new Pile();
        dico = new Dictionnaire();

    }

    //method

    public ArrayList<String> analyse (String code){
        ArrayList<String> SplitCode = new ArrayList<String>();
        String[] result = code.split("\\s");
        for ( String e : result ){
            SplitCode.add(e);
        }
        return SplitCode;
    }
    public boolean estValeur(String chaine){
            try {
                Integer.parseInt(chaine);
            } catch (NumberFormatException e){
                return false;
            }
            return true;
    }
    public int valeur (String chaine ){
        return Integer.parseInt(chaine);
    }

    public void evaluate (String code ){
        this.liste = analyse(code);
        for ( String  e : this.liste ){
            if (estValeur(e)) {
                pile.empile(valeur(e));
            } else if (e.equals("PLUS"))
                pile.plus();
            else if (e.equals("MULT"))
                pile.mult();
            else if (e.equals("DUP"))
                pile.dup();
            else {
                evaluate(dico.analyse(e));
            }
        }
        pile.displayPile();
    }
    public void execute(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        BufferedReader br = new BufferedReader(file);
        this.code = br.readLine();
        evaluate(this.code);
        pile.displayPile();
        br.close();
    }

}
