package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Model.ListItem;
import ie.mywaiter.mywaiter.NotesActivity;
import ie.mywaiter.mywaiter.NewOrder;
import ie.mywaiter.mywaiter.R;
import ie.mywaiter.mywaiter.SplashScreen;
import ie.mywaiter.mywaiter.TablesActivity;
import ie.mywaiter.mywaiter.ViewOrders;

/**
 * Created by Kev on 25/02/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;


    public MyAdapter(Context context, List listitem){
        this.context = context;
        this.listItems = listitem;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        ListItem item = listItems.get(position);

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());


    }

    @Override
    public int getItemCount() {

        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;

        public ViewHolder(View itemView){

        super(itemView);

        itemView.setOnClickListener(this);

        name = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v){
        int position = getAdapterPosition();
        ListItem item = listItems.get(position);

        switch(position){

            case 0:
                Intent intent = new Intent(context, NewOrder.class);
                Toast.makeText(context,"Create Order", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(context, ViewOrders.class);
                Toast.makeText(context,"View Orders", Toast.LENGTH_SHORT).show();
                context.startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(context, TablesActivity.class);
                Toast.makeText(context,"Tables", Toast.LENGTH_SHORT).show();
                context.startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(context, NotesActivity.class);
                Toast.makeText(context,"Notes", Toast.LENGTH_SHORT).show();
                context.startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(context, NotesActivity.class);
                Toast.makeText(context,"Menu", Toast.LENGTH_SHORT).show();
                context.startActivity(intent4);
                break;

            case 5:
                Intent intent5 = new Intent(context, SplashScreen.class);
                Toast.makeText(context,"SPLASH!", Toast.LENGTH_SHORT).show();
                context.startActivity(intent5);
                break;

            default:
                Intent intent6 = new Intent(context, SplashScreen.class);
                Toast.makeText(context,"SPLASH!", Toast.LENGTH_SHORT).show();
                context.startActivity(intent6);
                break;
        }


        }
    }



}
