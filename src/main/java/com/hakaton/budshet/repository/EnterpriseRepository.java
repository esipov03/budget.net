package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Integer> {
    @Query("From Enterprise e where e.inn=:inn")
    Enterprise getEnterpriseByInn(@Param("inn") String inn);

    @Query("From Enterprise e where e.parentId=:parentId")
    List<Enterprise> getEnterpriseByParentId(@Param("parentId") int parentId);

    @Query("From Enterprise e where e.id in (:ids)")
    List<Enterprise> getEnterpriseByListId(@Param("ids") List<Integer> ids);




}
