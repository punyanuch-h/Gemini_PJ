package th.ac.mahidol.ict.gemini.repository;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.gemini.model.ScienceObserver;

public interface ScienceObserverRepository extends CrudRepository<ScienceObserver, Integer> {
    ScienceObserver findById(int id);

    ScienceObserver findByUsername(String username);
}
