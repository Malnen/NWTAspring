
package com.JAMgroup.NWTA;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface KartaProduktowRepository extends CrudRepository<KartaProduktow, Integer> {

    public Optional<KartaProduktow> findByKoszykNumerKoszyka(int koszykNumerKoszyka);
}

