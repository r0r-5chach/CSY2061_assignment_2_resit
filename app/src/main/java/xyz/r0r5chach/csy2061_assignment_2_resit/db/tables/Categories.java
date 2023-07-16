package xyz.r0r5chach.csy2061_assignment_2_resit.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Category;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.DescribedEntity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;

public class Categories extends Table {
    private static final Column name = Column.getNameCol();
    private static final Column description = Column.getDescription();
    public Categories() {
        super("categories", Column.getId(), getColumns());
    }

    public List<Entity> crud(SQLiteDatabase db, DBProcess process, Entity entity) {
        if (entity instanceof Category category) {
            return parseCursor(super.crud(db, process, generateContentValues(category), new String[]{String.valueOf(category.getId())}), uid.name());
        }
        return null;
    }

    public static List<Entity> parseCursor(Cursor cursor, String uid) {
        List<Entity> results = new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(uid));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Categories.name.name()));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(Categories.description.name()));
            results.add(new Category(id, name, description));
            cursor.moveToNext();
        }
        return results;
    }

    private static List<Column> getColumns() {
        Column[] columns = {name, description};
        return Arrays.stream(columns).collect(Collectors.toList());
    }

    private ContentValues generateContentValues(DescribedEntity category) {
        ContentValues values = new ContentValues();
        values.put(name.name(), category.getName());
        values.put(description.name(), category.getDescription());
        return values;
    }
}
