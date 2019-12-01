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

    @Query("From Process p where :date between  p.dateCreate and p.dateEnd and p.executorEnterprise.id in (:exec_list)")
    public List<Process> getProcessBetweenDateStartAndDateEnd(@Param("date") Date date,@Param("exec_list") List<Integer> id);

}
