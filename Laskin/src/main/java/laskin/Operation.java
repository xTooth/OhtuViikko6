package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Operation implements Command {

    private TextField tulos;
    private TextField syote;
    private Button nollaa;
    private Button undo;
    private Button plus;
    private Button miinus;
    Sovelluslogiikka sovellus;
    private int previous;

    public Operation(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        tulos = tuloskentta;
        syote = syotekentta;
        this.nollaa = nollaa;
        this.miinus = miinus;
        this.plus = plus;
        this.sovellus = sovellus;
        this.undo = undo;
        previous = 0;
    }

    public int getInput() {
        int i;
        try{
            i = Integer.parseInt(syote.getText());
        }catch(NumberFormatException e){
            i = 0;
        }
        return i;
    }
    
    public void print(){
        tulos.setText("");
        tulos.setText("" + sovellus.tulos());
        if(sovellus.tulos() == 0){
            nollaa.disableProperty().set(true);
        }else{
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
   }
    
    @Override
    public void undo() {
        sovellus.palauta(previous);
        print();
    }

    public void setPrevious(int previous) {
        this.previous = previous;
        
    }


    

}
