package com.example.roomdatapractising.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {tablecreation.class},version = 1)
public   abstract class databsecreation extends RoomDatabase {

    public abstract operationDao getDao();


    public static databsecreation INSTANCE;




    public static databsecreation getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,databsecreation.class,"UserDatabase").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return INSTANCE;
    }


}
