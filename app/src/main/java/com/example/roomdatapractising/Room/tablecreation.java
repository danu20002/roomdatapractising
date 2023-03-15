package com.example.roomdatapractising.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public  class tablecreation {
    @PrimaryKey(autoGenerate = true)
    int id;
    String title;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public tablecreation(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
