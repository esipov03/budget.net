package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
    @Query("From Enterprise e where e.inn=:inn")
      Enterprise getEnterpriseByInn(@Param("inn") String inn);


}
