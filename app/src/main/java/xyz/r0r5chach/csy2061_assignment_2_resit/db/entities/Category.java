package xyz.r0r5chach.csy2061_assignment_2_resit.db.entities;

public class Category extends DescribedEntity {

    public Category() {
        super("", "");
    }

    public Category(int id, String name, String description) {
        super(id, name, description);
    }
}
