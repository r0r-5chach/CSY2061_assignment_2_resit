package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

public class NamedEntity extends Entity {
    protected String name;

    public NamedEntity(int id, String name) {
        super(id);
        this.name = name;
    }

    public NamedEntity(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
