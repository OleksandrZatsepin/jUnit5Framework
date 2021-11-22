package model;

import util.DataGenerator;

public class Category {
    private Long id;
    private String name;

    public static Category getDefaultCategory() {
        final Category category = new Category();
        category.setId(DataGenerator.randomId());
        category.setName(DataGenerator.randomAnimalCategory());
        return category;
    }

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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
