package com.learning.springboot.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by krvh271 on 8/15/17.
 */
@Document(collection = "clinicalStudy")
public class ClinicalStudy {
    @Id
    private long id;
}
