package laskin;

import java.util.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {

    private Button undo;
    private Sovelluslogiikka sovellus;
    private Map<Button, Command> komennot;
    private Command edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus));
    }

    @Override
    public void handle(Event event) {
        if (event.getTarget() != undo) {
            Command komento = komennot.get((Button) event.getTarget());
            komento.run();
            edellinen = komento;
        } else {
            edellinen.undo();
            edellinen = null;
        }
    }

}
