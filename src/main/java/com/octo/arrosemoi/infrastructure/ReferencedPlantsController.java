package com.octo.arrosemoi.infrastructure;

import com.octo.arrosemoi.catalog.Catalog;
import com.octo.arrosemoi.AddReferencedPlantRequestBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReferencedPlantsController {
    private Catalog catalog;

    public ReferencedPlantsController(Catalog catalog) {

        this.catalog = catalog;
    }

    @PutMapping("/referenced-plants")
    public void addReferencedPlant(@RequestBody AddReferencedPlantRequestBody addReferencedPlantRequestBody) {
        System.out.println(addReferencedPlantRequestBody.getName() == null);
        System.out.println(addReferencedPlantRequestBody.getName() == "");
        if (StringUtils.isEmpty(addReferencedPlantRequestBody.getName()))
            throw new IllegalArgumentException("Name is required");
        this.catalog.saveReferencedPlant();
    }
}
