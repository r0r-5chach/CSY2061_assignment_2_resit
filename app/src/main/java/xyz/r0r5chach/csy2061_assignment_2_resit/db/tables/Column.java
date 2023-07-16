package xyz.r0r5chach.csy2061_assignment_2_resit.db.tables;

public record Column(String name, DataType type) {

    public static Column getNameCol() {
        return new Column("name", DataType.TEXT);
    }

    public static Column getDescription() {
        return new Column("description", DataType.TEXT);
    }

    public static Column getId() {
        return new Column("id", DataType.INTEGER);
    }
}
