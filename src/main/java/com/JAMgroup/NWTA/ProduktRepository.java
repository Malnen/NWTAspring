
package com.JAMgroup.NWTA;

import org.springframework.data.repository.CrudRepository;

public interface ProduktRepository extends CrudRepository<Produkt, Integer> {

    public Iterable<Produkt> findByDzialNumerDzialu(Integer dzialNumerDzialu);
}

