package gae.piaz.baeldung.reactiveapi.event;

import java.io.Serializable;

public class Foo implements Serializable {

    private Integer id;
    private String name;

    public Foo() {}

    public Foo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
