package model;

import com.github.javafaker.Faker;

import java.util.Random;

public class Category {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Category getDefaultCategory() {
        final Category category = new Category();
        category.setId(new Random().nextLong());
        category.setName(new Faker().animal().name());
        return category;
    }
}
