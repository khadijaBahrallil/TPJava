import java.io.IOException;


public class main{
public static void main(String[] args) throws IOException {
        Pile pile = new Pile();
        /*p.empile(1);
        p.empile(2);
        p.plus();
        p.empile(3);
        p.mult();
        p.displayPile();
        */
        interprete i=new interprete();
        i.evaluate(args[0]);
        pile.displayPile();
}

}