package syveien.no;

/**
 * Created by arnfinno on 11.09.2016.
 */
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VareRepository extends MongoRepository<Vare, String> {

    public List<Vare> findByNavn(String Navn);
    public Vare findByid(String id);
    public Vare save(Vare vare);
    void delete(Vare vare);
    void deleteAll();

}