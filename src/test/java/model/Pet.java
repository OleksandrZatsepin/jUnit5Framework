package model;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

public class Pet {
    public static final String AVAILABLE_STATUS = "available";
    public static final String PENDING_STATUS = "pending";
    public static final String SOLD_STATUS = "sold";

    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
//    private List<PetStatus> status;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Pet getDefaultPet() {
        final Pet pet = new Pet();
        pet.setId(new Random().nextLong());
        pet.setCategory(Category.getDefaultCategory());
        pet.setName(new Faker().funnyName().name());
        pet.setPhotoUrls(List.of(new Faker().internet().url()));
        pet.setTags(List.of(Tag.getDefaultTag()));
        pet.setStatus(AVAILABLE_STATUS);
        return pet;
    }



}