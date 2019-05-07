package com.octo.arrosemoi;

public class AddReferencedPlantRequestBody {
    private String name;
    private Integer wateringFrequency;

    public void setName(String name) {
        this.name = name;
    }

    public void setWateringFrequency(Integer wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public String getName() {
        return name;
    }

    public Integer getWateringFrequency() {
        return wateringFrequency;
    }
}
