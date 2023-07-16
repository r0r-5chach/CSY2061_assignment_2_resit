package xyz.r0r5chach.csy2061_assignment_2_resit.db.tables;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.DateType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.StringType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.User;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.UserType;

public class Users extends Table {
    private static final Column name = Column.getNameCol();
    private static final Column email = new Column("email", DataType.TEXT);
    private static final Column password = new Column("password", DataType.TEXT);
    private static final Column door_number = new Column("door_number", DataType.TEXT);
    private static final Column address = new Column("address", DataType.TEXT);
    private static final Column post_code = new Column("post_code", DataType.TEXT);
    private static final Column date_registered = new Column("date_registered", DataType.TEXT);

    private static final Column type = new Column("type", DataType.TEXT);

    private static final Column date_updated = new Column("date_updated", DataType.TEXT);

    public Users() {
        super("users", email, getColumns());
    }

    public List<Entity> crud(SQLiteDatabase db, DBProcess process, Entity entity) {
        if (entity instanceof User user) {
            return parseCursor(super.crud(db, process, generateContentValues(user), new String[]{user.getString(StringType.EMAIL)}), uid.name());
        }
        return null;
    }


    public static List<Entity> parseCursor(Cursor cursor, String uid) {
        List<Entity> results = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String email = cursor.getString(cursor.getColumnIndexOrThrow(uid));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(Users.name.name()));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(Users.password.name()));
                String door_number = cursor.getString(cursor.getColumnIndexOrThrow(Users.door_number.name()));
                String address = cursor.getString(cursor.getColumnIndexOrThrow(Users.address.name()));
                String post_code = cursor.getString(cursor.getColumnIndexOrThrow(Users.post_code.name()));
                LocalDate date_registered = LocalDate.parse(cursor.getString(cursor.getColumnIndexOrThrow(Users.date_registered.name())));
                UserType type = UserType.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(Users.type.name())));
                LocalDate date_updated;
                try {
                     date_updated = LocalDate.parse(cursor.getString(cursor.getColumnIndexOrThrow(Users.date_updated.name())));
                }
                catch (NullPointerException e) {
                    date_updated = null;
                }
                results.add(new User(name, email, password, door_number, post_code, date_registered, type, address, date_updated));
                cursor.moveToNext();
            }
        }
        return results;
    }

    public static Column getUID() {
        return email;
    }

    private static List<Column> getColumns() {
        Column[] columns = {name, password, door_number, address, post_code, date_registered, type, date_updated};
        return Arrays.stream(columns).collect(Collectors.toList());
    }

    private ContentValues generateContentValues(User user) {
        ContentValues values = new ContentValues();
        for (StringType type : StringType.values()) {
            values.put(getStringTypeColumn(type).name(), user.getString(type));
        }

        if (user.getType() != null) {
            values.put(type.name(), user.getType().toString());
        }

        if (user.getDate(DateType.REGISTERED) != null) {
            values.put(date_registered.name(), user.getDate(DateType.REGISTERED).toString());
        }
        if (user.getDate(DateType.UPDATED) != null) {
            values.put(date_updated.name(), user.getDate(DateType.UPDATED).toString());
        }

        return values;
    }

    private Column getStringTypeColumn(StringType type) {
        return switch(type) {
            case NAME -> name;
            case EMAIL -> email;
            case DOOR_NUMBER -> door_number;
            case PASSWORD -> password;
            case ADDRESS -> address;
            case POST_CODE -> post_code;
        };
    }
}
