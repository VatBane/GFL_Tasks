package com.example.converter.RESTControllers;

import com.example.converter.entities.Convertation;
import com.example.converter.exceptions.DuplicateException;
import com.example.converter.exceptions.ResourceNotFoundException;
import com.example.converter.repositories.ConvertationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/convertations")
public class ConvertationRESTController {
    @Autowired
    private ConvertationRepository convertationRepository;

    @PostMapping("")
    public Convertation createCategory(@RequestBody Convertation convertation) {
        if (convertation.getFromQuantity() == null || convertation.getToQuantity() == null || convertation.getMultiplier() == 0) {
            throw new IllegalArgumentException("Нет данных!!!");
        }
        if (convertation.getCategoryId() == null || convertation.getCategoryId() == 0) {
            throw new ResourceNotFoundException("Нет такой категории");
        }
        if (convertationRepository.getConvertationByFromQuantityAndToQuantity(convertation.getFromQuantity(),
                convertation.getToQuantity()) != null) {
            throw new DuplicateException("Уже есть такой конвертер!");
        }
        if (convertation.getId() != null) {
            if (convertationRepository.findById(convertation.getId()).isPresent())
                throw new DuplicateException("Уже есть такой конвертер");
        }

        return convertationRepository.save(convertation);
    }

    @DeleteMapping("")
    public void deleteConvertationByQuantities(@RequestBody Convertation convertation) {
        if (convertation.getFromQuantity() == null || convertation.getToQuantity() == null) {
            throw new ResourceNotFoundException("Нет такого конвертера!");
        }
        convertation = convertationRepository.getConvertationByFromQuantityAndToQuantity(convertation.getFromQuantity(),
                convertation.getToQuantity());
        convertationRepository.delete(convertation);
//        convertationRepository.delete(convertation);
    }
}
