package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.StatusDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDocumentRepository extends CrudRepository<StatusDocument,Integer> {
}
