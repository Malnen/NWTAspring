
package com.JAMgroup.NWTA;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface KoszykRepository extends CrudRepository<Koszyk, Integer> {
    public Optional<Koszyk> findByKontoLoginKonta(String kontoLoginKonta);
}
