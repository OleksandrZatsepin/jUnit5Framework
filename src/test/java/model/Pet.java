package model;

import util.DataGenerator;

import java.util.List;

public class Pet {

    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private PetStatus petStatus;

    public static Pet getDefaultPet() {
        return getDefaultPet(PetStatus.AVAILABLE);
    }

    public static Pet getDefaultPet(PetStatus petStatus) {
        final Pet pet = new Pet();
        pet.setId(DataGenerator.randomId());
        pet.setCategory(Category.getDefaultCategory());
        pet.setName(DataGenerator.randomPetName());
        pet.setPhotoUrls(List.of(DataGenerator.randomUrl()));
        pet.setTags(List.of(Tag.getDefaultTag()));
        pet.setStatus(petStatus);
        return pet;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public PetStatus getStatus() {
        return petStatus;
    }

    public void setStatus(PetStatus status) {
        this.petStatus = status;
    }


}