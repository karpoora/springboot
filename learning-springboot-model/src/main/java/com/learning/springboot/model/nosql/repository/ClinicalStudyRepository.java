package com.learning.springboot.model.nosql.repository;

import com.learning.springboot.model.document.ClinicalStudy;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by krvh271 on 8/15/17.
 */
public interface ClinicalStudyRepository extends MongoRepository<ClinicalStudy,Long> {
}
