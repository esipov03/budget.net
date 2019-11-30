package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.Process;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends CrudRepository<Process,Integer> {
}
