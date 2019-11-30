package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.Enterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise,Integer> {
    @Query("From Enterprise e where e.inn=:inn")
      Enterprise getEnterpriseByInn(@Param("inn") String inn);
}
