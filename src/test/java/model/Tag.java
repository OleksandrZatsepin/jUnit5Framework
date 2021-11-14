package model;

import com.github.javafaker.Faker;

import java.util.Random;

public class Tag {
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

    public static Tag getDefaultTag() {
        final Tag tag = new Tag();
        tag.setId(new Random().nextLong());
        tag.setName(new Faker().animal().name());
        return tag;
    }

}
