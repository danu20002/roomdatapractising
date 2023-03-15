package com.example.roomdatapractising.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface operationDao {

    @Insert
    void  insert(tablecreation Tablecreation);

    @Update
    void update(tablecreation Tablecreation);

    @Query("delete from tablecreation where id=:id")
     void delete(int id);

    @Query("select * from tablecreation")
    List<tablecreation>  getAllNotes();
}
