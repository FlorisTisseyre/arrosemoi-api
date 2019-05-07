package com.octo.arrosemoi;

import com.octo.arrosemoi.catalog.Catalog;
import com.octo.arrosemoi.infrastructure.ReferencedPlantsController;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReferencedPlantsControllerTest {

    @Test
    public void shouldCallSavedReferencedPlant() {
        MockCatalog catalog = new MockCatalog();
        ReferencedPlantsController controller = new ReferencedPlantsController(catalog);
        AddReferencedPlantRequestBody requestBody = new AddReferencedPlantRequestBody();
        requestBody.setName("cactus");
        requestBody.setWateringFrequency(21);

        controller.addReferencedPlant(requestBody);

        assertTrue("oo", catalog.called);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveANameParameter() {
        MockCatalog catalog = new MockCatalog();
        ReferencedPlantsController controller = new ReferencedPlantsController(catalog);
        AddReferencedPlantRequestBody requestBody = new AddReferencedPlantRequestBody();
        requestBody.setWateringFrequency(2);

        controller.addReferencedPlant(requestBody);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveANonEmptyName() {
        MockCatalog catalog = new MockCatalog();
        ReferencedPlantsController controller = new ReferencedPlantsController(catalog);
        AddReferencedPlantRequestBody requestBody = new AddReferencedPlantRequestBody();
        requestBody.setName("");
        requestBody.setWateringFrequency(2);

        controller.addReferencedPlant(requestBody);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveAWateringFrequencyParameter() {
        MockCatalog catalog = new MockCatalog();
        ReferencedPlantsController controller = new ReferencedPlantsController(catalog);
        AddReferencedPlantRequestBody requestBody = new AddReferencedPlantRequestBody();
        requestBody.setName("cactus");

        controller.addReferencedPlant(requestBody);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHaveANonEmptyWateringFrequency() {
        MockCatalog catalog = new MockCatalog();
        ReferencedPlantsController controller = new ReferencedPlantsController(catalog);
        AddReferencedPlantRequestBody requestBody = new AddReferencedPlantRequestBody();
        requestBody.setName("cactus");
        requestBody.setWateringFrequency(0);

        controller.addReferencedPlant(requestBody);
    }

    private class MockCatalog implements Catalog {
        public boolean called = false;

        @Override
        public void saveReferencedPlant() {
            this.called = true;
        }
    }
}