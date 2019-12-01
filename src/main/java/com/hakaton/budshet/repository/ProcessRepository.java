package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.Process;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends CrudRepository<Process,Integer> {

    @Query("From Process p where p.number=:numberParam")
    public Process getProcessByNumber(@Param("numberParam") String number);
}
