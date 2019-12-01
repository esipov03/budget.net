package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.Process;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<Process,Integer> {

    @Query("From Process p where p.number=:numberParam")
    public Process getProcessByNumber(@Param("numberParam") String number);


    @Query("From Process p where p.executorEnterprise.id=:executourId")
    public List<Process> getProcessByExecutorEnterprise(@Param("executourId") int executourId);

    @Query("From Process p where p.dateCreate < :dateEnd and p.dateEnd > :dateStart and p.executorEnterprise.id=:id")
    public List<Process> getProcessBetweenDateStartAndDateEnd(@Param("dateStart") Date dateStartU,@Param("dateEnd") Date dateEndU,@Param("id") int id);

}
