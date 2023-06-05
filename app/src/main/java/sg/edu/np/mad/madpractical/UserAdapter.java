package sg.edu.np.mad.madpractical;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    ArrayList<User> data;
    ListActivity activity;

    public UserAdapter(ArrayList<User> users) {
        this.data = users;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview,
                parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User userlist = data.get(position);
        holder.text1.setText(userlist.getName());
        holder.text2.setText((userlist.getDescription()));
        holder.bigImage.setVisibility(
                userlist.getName().endsWith("7")
                        ? View.VISIBLE
                        : View.GONE
        );
        holder.image.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.image.getContext());
            builder.setTitle("Profile");
            builder.setMessage(userlist.getName());
            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i) {
                    Bundle extras = new Bundle();
                    extras.putInt("id", userlist.getId());
                    extras.putString("name", userlist.getName());
                    extras.putString("description", userlist.getDescription());
                    extras.putBoolean("value", userlist.isFollowed());
                    Intent in = new Intent(holder.image.getContext(), MainActivity.class);
                    in.putExtras(extras);
                    holder.image.getContext().startActivity(in);
                }
            });
            builder.setNegativeButton("Close", null);
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2;
        ImageView image, bigImage;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            text1 = itemView.findViewById(R.id.nametextview);
            text2 = itemView.findViewById(R.id.descriptionTextView);
            image = itemView.findViewById(R.id.imageView4);
            bigImage = itemView.findViewById(R.id.imageView2);
        }
    }
}
