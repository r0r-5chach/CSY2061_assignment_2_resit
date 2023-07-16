package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

public class DescribedEntity extends NamedEntity {
    protected String description;

    public DescribedEntity(int id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public DescribedEntity(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
