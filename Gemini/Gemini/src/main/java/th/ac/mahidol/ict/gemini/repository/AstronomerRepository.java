package th.ac.mahidol.ict.gemini.repository;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.gemini.model.Astronomer;

public interface AstronomerRepository extends CrudRepository<Astronomer, Integer> {
    Astronomer findById(int id);

    Astronomer findByUsername(String username);
}
