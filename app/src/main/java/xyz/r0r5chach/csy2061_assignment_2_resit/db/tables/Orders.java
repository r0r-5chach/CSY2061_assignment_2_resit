package xyz.r0r5chach.csy2061_assignment_2_resit.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.DBProcess;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Order;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.OrderStatus;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Product;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.StringType;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.User;

public class Orders extends Table{
    private static final Column name = Column.getNameCol();
    private static final Column user = new Column("user", DataType.TEXT);
    private static final Column products = new Column("products", DataType.TEXT);
    private static final Column status = new Column("status", DataType.TEXT);

    public Orders() {
        super("orders", Column.getId(), getColumns());
    }

    public List<Entity> crud(SQLiteDatabase db, DBProcess process, Entity entity) {
        if (entity instanceof Order order) {
            return parseCursor(super.crud(db, process, generateContentValues(order), new String[]{String.valueOf(order.getId())}), uid.name(), db);
        }
        return null;
    }

    private List<Entity> parseCursor(Cursor cursor, String uid, SQLiteDatabase db) {
        List<Entity> results = new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(uid));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Orders.name.name()));
            String userUID = cursor.getString(cursor.getColumnIndexOrThrow(Orders.user.name()));
            String products = cursor.getString(cursor.getColumnIndexOrThrow(Orders.products.name()));
            String status = cursor.getString(cursor.getColumnIndexOrThrow(Orders.products.name()));

            User user = (User) Users.parseCursor(new Users().crud(db, DBProcess.READ, null, new String[]{userUID}), Users.getUID().name()).get(0);

            results.add(new Order(id, name, user, decodeProductList(products, db), OrderStatus.valueOf(status)));
            cursor.moveToNext();
        }

        return results;
    }

    private static List<Column> getColumns() {
        Column[] columns = {name, user, products, status};
        return Arrays.stream(columns).collect(Collectors.toList());
    }

    private ContentValues generateContentValues(Order order) {
        ContentValues values = new ContentValues();
        values.put(name.name(), order.getName());
        values.put(user.name(), order.getUser().getString(StringType.NAME));
        values.put(products.name(), encodeProductList(order.getProducts()));
        values.put(status.name(), order.getStatus().toString());

        return values;
    }

    private static String encodeProductList(List<Product> products) {
        StringBuilder encodedList = new StringBuilder();
        for (Product product : products) {
            encodedList.append(product.getId()).append("^");
        }
        encodedList.substring(0, encodedList.length()-1);
        return encodedList.toString();
    }

    private static List<Product> decodeProductList(String encodedList, SQLiteDatabase db) {
        List<Product> products = new ArrayList<>();
        String[] productIds = encodedList.split("\\^");

        for (String id : productIds) {
            Product product = (Product) Products.parseCursor(new Products().crud(db, DBProcess.READ, null, new String[] {id}), Column.getId().name());
            products.add(product);
        }
        return products;
    }
}
