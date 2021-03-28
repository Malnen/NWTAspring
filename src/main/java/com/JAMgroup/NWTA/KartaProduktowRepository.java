
package com.JAMgroup.NWTA;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface KartaProduktowRepository extends CrudRepository<KartaProduktow, Integer> {

    public Iterable<KartaProduktow> findByKoszykNumerKoszyka(Integer koszykNumerKoszyka);
}

