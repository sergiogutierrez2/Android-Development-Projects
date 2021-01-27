package edu.sjsu.android.homework2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

     Fragment mFragment;
    String data1[], data2[];
    int images[];
    Context context;
    public MyAdapter (Context ct, String animals[], String description[], int img [])
    {
        context = ct;
        data1 = animals;
        data2 = description;
        images = img;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.animal.setText(data1[position]);
        holder.myImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {

            // if (data1[position] == "Wolf"){
            //Toast.makeText(context, "Item last selected", Toast.LENGTH_LONG).show();}
            @Override
            public void onClick(View view) {

                 if (data1[position].equals("Wolf")){
                // Toast.makeText(context, "Item last selected", Toast.LENGTH_LONG).show();
                     openDialog();

                     }

                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1" , data1[position]);
                intent.putExtra("data2" , data2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView animal;
        ImageView myImage;
        ConstraintLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            animal = itemView.findViewById(R.id.Crocodile);
            myImage = itemView.findViewById(R.id.MyImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }


    public void openDialog(){

        // ExampleDialog exampleDialog = new ExampleDialog();
        // exampleDialog.show(getSupportFragmentManager(), "example dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Information")
                .setMessage("Wolves are scary. Do you wish to proceed?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(context, "Item last selected", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
