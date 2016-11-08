package syveien.no;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by arnfinno on 11.09.2016.
 */
public class Vare {


    public String id;

    public String navn;


    public Vare(String navn) {
        this.navn = navn;
    }

    public Vare(String id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    public Vare() {

    }

    public String getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String name) {
        this.navn = navn;
    }



}
