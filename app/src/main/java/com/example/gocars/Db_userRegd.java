package com.example.gocars;

import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Db_userRegd extends SQLiteOpenHelper {
    public ByteArrayOutputStream byteArrayOutputStream;
    public byte[] imageinbtye;
    public String imgname;

  //  public static final String DATABASE_NAME = "dbgocars.db";
  public static final String DATABASE_NAME = "dbgocars2.db";
    public static final String TABLE_NAME = "userregd";
    public static final String UCOL_1 = "ID";
    public static final String UCOL_2 = "FNAME";
    public static final String UCOL_3 = "LNAME";
    public static final String UCOL_4 = "EMAIL";
    public static final String UCOL_5 = "MOBILENO";
    public static final String UCOL_6 = "PASSWORD";
    public static final String UCOL_7 = "EXTRA";


    public static final String ADM_TABLE_NAME = "admindetails";
    public static final String ADM_COL_1 = "ID";
    public static final String ADM_COL_2 = "NAME";
    public static final String ADM_COL_3 = "EMAIL";
    public static final String ADM_COL_4 = "PASSWORD";
    public static final String ADM_COL_5 = "EXTRA";

    public static final String ADM_CARUPLOAD = "admincaruploadtb";
    public static final String ADM_Car_1 = "ID";
    public static final String ADM_Car_2 = "CARNAME";
    public static final String ADM_Car_3 = "CARIMAGE";
    public static final String ADM_Car_4 = "CLASSTYPE";
    public static final String ADM_Car_5 = "MODELYEAR";
    public static final String ADM_Car_6 = "MODELTYPE";
    public static final String ADM_Car_7 = "NOOFDOORS";
    public static final String ADM_Car_8 = "NOOFSEATS";
    public static final String ADM_Car_9 = "DRIVINGMODE";
    public static final String ADM_Car_10 = "COOLINGTYPE";
    public static final String ADM_Car_11 = "ODOMETER";
    public static final String ADM_Car_12 = "CARNUMBER";
    public static final String ADM_Car_13 = "SPECIFICATION";
    public static final String ADM_Car_14 = "EXPECTEDCOST";
    public static final String ADM_Car_15 = "UPLOADBY";
    public static final String ADM_Car_16 = "UPLOADDATE";
    public static final String ADM_Car_17 = "EXTRA";

    public static final String TABLECITY = "citylist";
    public static final String C_1 = "ID";
    public static final String C_2 = "CITYNAME";
    public static final String C_3 = "LOCATION";
    public Db_userRegd(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,LNAME TEXT,EMAIL TEXT, MOBILENO TEXT, PASSWORD TEXT, EXTRA TEXT)");
        db.execSQL("create table " + ADM_TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT, EXTRA TEXT)");
        db.execSQL("create table " + ADM_CARUPLOAD +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,CARNAME TEXT,CARIMAGE BLOB,CLASSTYPE TEXT,MODELYEAR TEXT,MODELTYPE TEXT,NOOFDOORS TEXT,NOOFSEATS TEXT,DRIVINGMODE TEXT,COOLINGTYPE TEXT,ODOMETER TEXT,CARNUMBER TEXT,SPECIFICATION TEXT,EXPECTEDCOST TEXT,UPLOADBY TEXT,UPLOADDATE TEXT,EXTRA TEXT)");
        db.execSQL("create table " + TABLECITY +" (ID INTEGER PRIMARY KEY ,CITYNAME TEXT,LOCATION TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ADM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ADM_CARUPLOAD);
        db.execSQL("DROP TABLE IF EXISTS "+TABLECITY);

        onCreate(db);
    }
 //====================================================================================================================
//===============================user details data including recovery password---------------------------------------------
    public boolean insertData(String fname,String lname,String email, String mobileno,String password, String extra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UCOL_2,fname);
        contentValues.put(UCOL_3,lname);
        contentValues.put(UCOL_4,email);
        contentValues.put(UCOL_5,mobileno);
        contentValues.put(UCOL_6,password);
        contentValues.put(UCOL_7,extra);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();



        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public Cursor checkLogin(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        String q;//= "select * from user where USERNAME = '"+username+"' and PASSWORD = '"+password+"'";
        q= "select * from userregd where EMAIL = '"+email+"' and PASSWORD = '"+password+"'";
        Cursor res = db.rawQuery(q, null);
        return res;

    }
    public Cursor recoverPass(String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        String q;//= "select * from user where USERNAME = '"+username+"' and PASSWORD = '"+password+"'";
        q= "select fname,Password from userregd where EMAIL = '"+email+"' ";
        Cursor res = db.rawQuery(q, null);
        return res;

    }
    public Cursor alreadyExist(String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        String q;//= "select * from user where USERNAME = '"+username+"' and PASSWORD = '"+password+"'";
        q= "select Email from userregd where EMAIL = '"+email+"' ";
        Cursor res = db.rawQuery(q, null);
        return res;

    }
    public Cursor userLoginID(String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        String q;//= "select * from user where USERNAME = '"+username+"' and PASSWORD = '"+password+"'";
        q= "select ID from userregd where EMAIL = '"+email+"' ";
        Cursor res2 = db.rawQuery(q, null);
        return res2;

    }
//------------------------------------------------------------------------------------------------------------------------------------

//============================================================================================================
// 11111111111111111-----------start admin details data contains   insertion etc

    public void deladmdata(){
        try{
            SQLiteDatabase db = getWritableDatabase();
            //  db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
            db.execSQL("DELETE FROM  " + ADM_TABLE_NAME);

            db.close();
        }catch(Exception e){
            //Toast.makeText((), "Error encountered while dropping.", Toast.LENGTH_LONG);
        }
    }

    public void  ADMdata()
    { SQLiteDatabase db = this.getWritableDatabase();
        String dta = "insert into "+ ADM_TABLE_NAME +" values (null, 'arzu', 'admin@gmail.com', 'admin','0')";
        db.execSQL(dta);
    }


    public boolean admInsertData(String name,String email,String password, String extra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ADM_COL_2,name);
        contentValues.put(ADM_COL_3,email);
        contentValues.put(ADM_COL_4,password);
        contentValues.put(ADM_COL_5,extra);
        long result = db.insert(ADM_TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }



    public Cursor checkLogin2(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        String q;//= "select * from user where USERNAME = '"+username+"' and PASSWORD = '"+password+"'";
        q= "select * from admindetails where EMAIL = '"+email+"' and PASSWORD = '"+password+"'";
        Cursor res = db.rawQuery(q, null);
        return res;

    }


    public Cursor admGetAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ADM_TABLE_NAME,null);
        return res;
    }
    //------------------------------------------======================================================

///////@@@@@@222222222222222222222222@@22222222  Admin car upload data

public boolean insertUploadData(String carname, byte[] carimage, String classtype, String modelyear, String modeltype, String noOfdoors, String noOfseats, String drivingmode, String coolingtype, String odometer, String carnumber, String specification,  String expectedcost, String uploadby , String uploaddate, String extra) {



        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ADM_Car_2,carname);
        contentValues.put(ADM_Car_3,carimage);
        contentValues.put(ADM_Car_4,classtype);
        contentValues.put(ADM_Car_5,modelyear);
        contentValues.put(ADM_Car_6,modeltype);
        contentValues.put(ADM_Car_7,noOfdoors);
        contentValues.put(ADM_Car_8,noOfseats);
        contentValues.put(ADM_Car_9,drivingmode);
        contentValues.put(ADM_Car_10,coolingtype);
        contentValues.put(ADM_Car_11,odometer);
        contentValues.put(ADM_Car_12,carnumber);
        contentValues.put(ADM_Car_13,specification);
        contentValues.put(ADM_Car_14,expectedcost);
        contentValues.put(ADM_Car_15,uploadby);
        contentValues.put(ADM_Car_16,uploaddate);
        contentValues.put(ADM_Car_17,extra);


        long result = db.insert("admincaruploadtb",null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;



}

    public ArrayList<Model> getAllImagesData()
    {
        try {
            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
            ArrayList<Model> modelArrayList=new ArrayList<>();
            Cursor cursor=sqLiteDatabase.rawQuery("select * from admincaruploadtb",null);
            if (cursor.getCount()!=0){
                while (cursor.moveToNext()){
                    String nameofimage =cursor.getString(1);
                    byte[] imageByte =cursor.getBlob(2);
                    String classtype =cursor.getString(3);
                    String noOfdoors=cursor.getString(6);
                    String noOfseats=cursor.getString(7);
                    String drivingmode=cursor.getString(8);
                    String coolingtype=cursor.getString(9);
                    String expectedcost=cursor.getString(13);
                    Integer rating=cursor.getInt(0);
                    Bitmap bitmap= BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                    modelArrayList.add(new Model(nameofimage,bitmap,classtype,noOfdoors,noOfseats,drivingmode,coolingtype,expectedcost,rating));

                }
                return modelArrayList;
            }
            else {
                Toast.makeText(faltu_context.context,"No values in database",Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(faltu_context.context,e.getMessage(),Toast.LENGTH_SHORT).show();
            return null;
        }

    }
    public ArrayList<Model_Pojo> showImagesData(String s)
    {
        try {
            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
            ArrayList<Model_Pojo> model_pojoArrayListt=new ArrayList<>();
            Cursor cursor=sqLiteDatabase.rawQuery("select * from admincaruploadtb where  ID="+s,null);
            if (cursor.getCount()!=0){
                while (cursor.moveToNext()){
                    String nameofimage =cursor.getString(1);
                    byte[] imageByte =cursor.getBlob(2);
                    String specification=cursor.getString(12);
                    String noOfdoors=cursor.getString(6);
                    String noOfseats=cursor.getString(7);
                    String drivingmode=cursor.getString(8);
                    String coolingtype=cursor.getString(9);
                    String expectedcost=cursor.getString(13);
                   // Integer rating=cursor.getInt(0);
                    Bitmap bitmap= BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);

                    model_pojoArrayListt.add(new Model_Pojo(nameofimage,bitmap,noOfdoors,noOfseats,drivingmode,coolingtype,expectedcost,specification));

                }
                return model_pojoArrayListt;
            }
            else {
                Toast.makeText(faltu_context.context,"No values in database",Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(faltu_context.context,e.getMessage(),Toast.LENGTH_SHORT).show();
            return null;
        }

    }
//=========================================================CITY DETAILS=================================
public void delcitydata(){
    try{
        SQLiteDatabase db = getWritableDatabase();
        //  db = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
        db.execSQL("DELETE FROM  " + TABLECITY);

        db.close();
    }catch(Exception e){
        //Toast.makeText((), "Error encountered while dropping.", Toast.LENGTH_LONG);
    }
}

    public void  cityData()
{ SQLiteDatabase db = this.getWritableDatabase();
    String cg1 = "insert into "+ TABLECITY +" values (1,'MONTREAL','Romeo-Vachon Blvd N, Dorval, Quebec H4Y 1H1')";
    db.execSQL(cg1);
    String cg2 = "insert into "+ TABLECITY +" values (2,'CALGARY','2000 Airport Rd NE, Calgary, AB T2E 6W5')";
    db.execSQL(cg2);
    String cg3 = "insert into "+ TABLECITY +" values (3,'BRAMPTON','light Centre and Flying Club, Brampton, 13691 McLaughlin Rd, Cheltenham, ON L7C 2B2')";
    db.execSQL(cg3);
    String cg4 = "insert into "+ TABLECITY +" values (4, 'MISSISSAUGA','6301 Silver Dart Dr, Mississauga, ON L5P 1B2')";
    db.execSQL(cg4);
    String cg5 = "insert into "+ TABLECITY +" values (5, 'QUEBEC CITY','505 Rue Principale, Québec, QC G2G 0J4')";
    db.execSQL(cg5);
    String cg6 = "insert into "+ TABLECITY +" values (6, 'EDMONTON','1000 Airport Rd, Edmonton International Airport, AB T9E 0V3')";
    db.execSQL(cg6);
    String cg7 = "insert into "+ TABLECITY +" values (7, 'SURREY','Surrey, BC V3S 9P4')";
    db.execSQL(cg7);
    String cg8 = "insert into "+ TABLECITY +" values (8, 'VANCOUVER','3211 Grant McConachie Way, Richmond, BC V7B 0A4')";
    db.execSQL(cg8);
    String cg9 = "insert into "+ TABLECITY +" values (9, 'LONDON','1750 Crumlin Rd, London, ON N5V 3B6')";
    db.execSQL(cg9);
    String cg10 = "insert into "+ TABLECITY +" values (10, 'TORONTO','2 Eireann Quay, Toronto, ON M5V 1A1')";
    db.execSQL(cg10);

}

//-----------------------------------------------------------/////fetch city list////////////////
public ArrayList<City_pojo> showcities()
{
    try {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ArrayList<City_pojo> city_pojos=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from citylist",null);
        if (cursor.getCount()!=0){
            while (cursor.moveToNext()){
                String nameofcity =cursor.getString(1);
             Integer id=cursor.getInt(0);
             String location =cursor.getString(2);

                city_pojos.add(new City_pojo(id,nameofcity,location));

            }
            return city_pojos;
        }
        else {
            Toast.makeText(faltu_context.context,"No values in database",Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    catch (Exception e)
    {
        Toast.makeText(faltu_context.context,e.getMessage(),Toast.LENGTH_SHORT).show();
        return null;
    }

}

    //-----------------------------------------------------------/////--CHANGE PASSWORD CODE////////////////
    public Cursor changePass(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        String q;//= "select * from user where USERNAME = '"+username+"' and PASSWORD = '"+password+"'";
        q= "select * from userregd where ID = '"+id+"' ";
        Cursor res = db.rawQuery(q, null);
        return res;

    }

    public boolean updatePassword(String id,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UCOL_6,password);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }












}

