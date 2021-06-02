package com.serg.blog.repo;

import com.serg.blog.models.HeatTreatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeatTreatmentRepository extends CrudRepository<HeatTreatment, Long> {
    @Query("select quantity FROM HeatTreatment")
    List<String> countDetail();
}
