package pec.cse.fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class DBHelper extends SQLiteOpenHelper {
    public DBHelper(  Context context){
        super(context,"Login.db",null,1);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *

     */
    @Override
    public void onCreate(SQLiteDatabase myDB) {
     myDB.execSQL("create Table USERS(username Text primary key,email text,password text)");


    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *

     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
myDB.execSQL("drop Table if exists users");
    }
    public boolean insertData(String user, String username, String email, String password){
        SQLiteDatabase myDB =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result=myDB.insert("users",null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;

        }
        else
        {
            return false;
        }

    }
    public Boolean checkusernamePassword(String username,String password)
    {
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
