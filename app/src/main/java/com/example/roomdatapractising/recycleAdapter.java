package com.example.roomdatapractising;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatapractising.Room.tablecreation;

import java.util.ArrayList;
import java.util.List;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.ViewHolder> {
    private Context context;

    private List<tablecreation> titlelist;
    public  recycleAdapter(Context context){
        this.context=context;
        titlelist=new ArrayList<>();
    }
    public void addTitle(tablecreation tablecreation){
        titlelist.add(tablecreation);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public recycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowstoadd,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
     tablecreation tableCreation=titlelist.get(position);
     holder.Title.setText(tableCreation.getTitle());
     holder.Discription.setText(tableCreation.getDescription());
     holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View v) {
             AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);
             alertdialog.setTitle("delete this one");
             alertdialog.setMessage("are you sure");
             alertdialog.setIcon(R.drawable.baseline_delete_forever_24);
             alertdialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                     notifyItemRemoved(position);
                 }
             });
             alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     Toast.makeText(context, "NOT DELETED ANYWAY", Toast.LENGTH_SHORT).show();
                 }
             });
             alertdialog.show();

             return true;
         }
     });
    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Title,Discription;
        LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Title=itemView.findViewById(R.id.titlerow);
            Discription=itemView.findViewById(R.id.descriptionrow);
            llrow=itemView.findViewById(R.id.llrow);
        }
    }
}
