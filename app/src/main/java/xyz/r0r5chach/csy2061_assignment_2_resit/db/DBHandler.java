package xyz.r0r5chach.csy2061_assignment_2_resit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;

import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.Entity;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.entities.User;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.tables.Categories;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.tables.Orders;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.tables.Products;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.tables.Table;
import xyz.r0r5chach.csy2061_assignment_2_resit.db.tables.Users;

public class DBHandler extends SQLiteOpenHelper {
    private static final int dbVersion = 7;
    private static final String dbName = "KwesiShop";
    private final Table[] tables = { new Categories(), new Orders(), new Users(), new Products()};

    public DBHandler(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (Table table : tables) {
            String query;
            if (table instanceof Users) {
                query = table.getCreateQuery(false);
            }
            else {
                query = table.getCreateQuery(true);
            }
            sqLiteDatabase.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (Table table : tables) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table.getTableName());
        }
        onCreate(sqLiteDatabase);
    }

    public List<Entity> crud(Entity entity, DBProcess process) {
        SQLiteDatabase db;
        if (process == DBProcess.READ || process == DBProcess.READ_ALL) {
            db = getReadableDatabase();
        }
        else {
            db = getWritableDatabase();
        }
        List<Entity> results;
        for (Table table : tables) {
            results = table.crud(db, process, new User("",""));
            if (results != null) {
                return results;
            }
        }
        return null;
    }
}