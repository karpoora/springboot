package com.pandian.learning.springboot.repository;

import com.pandian.learning.springboot.model.Cinema;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by krvh271 on 7/29/17.
 */
@RepositoryRestResource(collectionResourceRel = "cinemas", path = "cinemas")
public interface CinemaRepository extends PagingAndSortingRepository<Cinema,Long> {
    List<Cinema> findById(@Param("id") String id);
}
