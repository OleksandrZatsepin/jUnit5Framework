package model;

import util.DataGenerator;

public class Tag {
    private Long id;
    private String name;

    public static Tag getDefaultTag() {
        final Tag tag = new Tag();
        tag.setId(DataGenerator.randomId());
        tag.setName(DataGenerator.randomAnimalTag());
        return tag;
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
}
