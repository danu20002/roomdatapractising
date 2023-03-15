package com.example.roomdatapractising;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatapractising.Room.databsecreation;
import com.example.roomdatapractising.Room.operationDao;
import com.example.roomdatapractising.Room.tablecreation;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText Title,Discription;
Button save_btn;

operationDao OperationDao;
RecyclerView myrecycler;
databsecreation Databsecreation;
tablecreation tableCreation;
private recycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title=findViewById(R.id.Title);
        Discription=findViewById(R.id.discription);
        save_btn=findViewById(R.id.save_btn);
        myrecycler=findViewById(R.id.recyclerview);

        Databsecreation=databsecreation.getInstance(this);
        OperationDao=Databsecreation.getDao();
        adapter=new recycleAdapter(this);
        myrecycler.setAdapter(adapter);
        myrecycler.setLayoutManager(new LinearLayoutManager(this));


        fetchdata();
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=Title.getText().toString();
                String discription=Discription.getText().toString();

                tableCreation=new tablecreation(0,title,discription);

                adapter.addTitle(tableCreation);
                OperationDao.insert(tableCreation);

                Title.setText("");
                Discription.setText("");
                Toast.makeText(MainActivity.this, "Inserted successfully", Toast.LENGTH_SHORT).show();
            }
        });



        }
        private void fetchdata(){
        List<tablecreation> titlelist=OperationDao.getAllNotes();
        for(int i=0;i<titlelist.size();i++){
            tablecreation Tablecreation=titlelist.get(i);
            adapter.addTitle(Tablecreation);
        }
    }

}