package xyz.r0r5chach.csy2061_assignment_2_resit.db.tables;



import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;

public abstract class Table {
    protected final String tableName;
    protected final Column uid;
    protected final List<Column> columns;

    public Table(String name, Column uid, List<Column> columns) {
        this.uid = uid;
        this.tableName = name;
        this.columns = columns;
    }

    public abstract List<Entity> crud(SQLiteDatabase db, DBProcess process, Entity entity);

    public String getCreateQuery(boolean autoincrement) {
        StringBuilder query = new StringBuilder("CREATE TABLE " + tableName +"(");
        query.append(uid.name()).append(" ").append(uid.type()).append(" PRIMARY KEY");

        if (autoincrement) {
            query.append(" AUTOINCREMENT");
        }

        query.append(", ");

        for (Column column : columns) {
            query.append(column.name()).append(" ").append(column.type());

            if (!columns.get(columns.size()-1).equals(column)) {
                query.append(", ");
            }
        }

        query.substring(0, query.length()-2);
        query.append(")");
        return query.toString();
    }

    public String getTableName() {
        return tableName;
    }

    protected Cursor crud(SQLiteDatabase db, DBProcess process, ContentValues values, String[] whereArgs) {

        return switch(process) {
            case CREATE -> crud(db, values);
            case READ -> crud(db, whereArgs[0]);
            case READ_ALL -> crud(db);
            case UPDATE -> crud(db, values, whereArgs);
            case DELETE -> crud(db, whereArgs);
        };
    }

    @SuppressWarnings("SameReturnValue")
    private Cursor crud(SQLiteDatabase db, String[] whereArgs) {
        db.delete(tableName, uid.name() + " = ", whereArgs);
        return null;
    }

    @SuppressWarnings("SameReturnValue")
    private Cursor crud(SQLiteDatabase db, ContentValues values, String[] whereArgs) {
        db.update(tableName, values, uid.name() + " = ", whereArgs);
        return null;
    }

    @SuppressWarnings("SameReturnValue")
    private Cursor crud(SQLiteDatabase db, ContentValues values) {
        db.insert(tableName, null, values);
        return null;
    }

    private Cursor crud(SQLiteDatabase db) {
        String query = "SELECT * FROM " + tableName;
        return db.rawQuery(query, null);

    }

    private Cursor crud(SQLiteDatabase db, String whereArg) {
        String query = "SELECT * FROM " + tableName + " WHERE " + uid.name() + " = \"" + whereArg + "\"";
        return db.rawQuery(query, null);
    }
}
