package com.example.converter.repositories;

import com.example.converter.entities.Convertation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvertationRepository extends CrudRepository<Convertation, Integer> {
    List<Convertation> getConvertationsByCategoryId(Integer categoryId);
    Convertation getConvertationByFromQuantityAndToQuantity(String fromQuantity, String toQuantity);
    List<Convertation> deleteConvertationsByCategoryId(Integer categoryId);
}
