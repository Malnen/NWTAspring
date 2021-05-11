
package com.JAMgroup.NWTA;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface KartaProduktowRepository extends CrudRepository<KartaProduktow, Integer> {

    public Iterable<KartaProduktow> findByKoszykNumerKoszyka(Integer koszykNumerKoszyka);
    
    @Transactional
    public void deleteByKoszykNumerKoszyka(Integer koszykNumerKoszyka);
}

