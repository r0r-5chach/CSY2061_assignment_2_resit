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
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.PriceType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Product;

public class Products extends Table {
    private static final Column name = Column.getNameCol();
    private static final Column description = Column.getDescription();
    private static final Column price = new Column("price", DataType.REAL);
    private static final Column list_price = new Column("list_price", DataType.REAL);
    private static final Column retail_price = new Column("retail_price", DataType.REAL);
    private static final Column date_created = new Column("date_created", DataType.TEXT);

    private static final Column category = new Column("category", DataType.INTEGER);

    private static final Column date_updated = new Column("date_updated", DataType.TEXT);

    public Products() {
        super("products", Column.getId(), getColumns());
    }

    public List<Entity> crud(SQLiteDatabase db, DBProcess process, Entity entity) {
        if (entity instanceof Product product) {
            return parseCursor(super.crud(db, process, generateContentValues(product), new String[]{String.valueOf(product.getId())}), uid.name());
        }
        return null;
    }

    public static List<Entity> parseCursor(Cursor cursor, String uid) {
        List<Entity> results = new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(uid));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Products.name.name()));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(Products.description.name()));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow(Products.price.name()));
            double list_price = cursor.getDouble(cursor.getColumnIndexOrThrow(Products.list_price.name()));
            double retail_price = cursor.getDouble(cursor.getColumnIndexOrThrow(Products.retail_price.name()));
            LocalDate date_created = LocalDate.parse(cursor.getString(cursor.getColumnIndexOrThrow(Products.date_created.name())));
            int imgUrl = cursor.getInt(cursor.getColumnIndexOrThrow(Products.category.name()));
            LocalDate date_updated = LocalDate.parse(cursor.getString(cursor.getColumnIndexOrThrow(Products.date_updated.name())));

            results.add(new Product(id, name, description, price, list_price, retail_price, date_created, date_updated, imgUrl));

            cursor.moveToNext();
        }
        return results;
    }

    private static List<Column> getColumns() {
        Column[] columns = {name, description, price, list_price, retail_price, date_created, date_updated, category};
        return Arrays.stream(columns).collect(Collectors.toList());
    }

    private ContentValues generateContentValues(Product product) {
        ContentValues values = new ContentValues();
        values.put(name.name(), product.getName());
        values.put(description.name(), product.getDescription());
        values.put(price.name(), product.getPrice(PriceType.ACTUAL));
        values.put(list_price.name(), product.getPrice(PriceType.LIST));
        values.put(retail_price.name(), product.getPrice(PriceType.RETAIL));
        values.put(date_created.name(), product.getDate(DateType.CREATED).toString());
        values.put(date_updated.name(), product.getDate(DateType.UPDATED).toString());
        values.put(category.name(), product.getCategory());

        return values;
    }
}
