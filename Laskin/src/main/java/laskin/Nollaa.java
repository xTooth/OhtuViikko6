package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Operation {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
    }

    @Override
    public void run() {
        super.setPrevious(super.sovellus.tulos());
        super.sovellus.nollaa();
        super.print();
    }
}
