package com.hakaton.budshet.repository;

import com.hakaton.budshet.entity.TypeDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDocumentRepository extends CrudRepository<TypeDocument,Integer> {
}
