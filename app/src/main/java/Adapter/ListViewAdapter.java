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

import Data.DataBaseHandler;
import Model.ListItem;
import Model.Order;
import ie.mywaiter.mywaiter.NotesActivity;
import ie.mywaiter.mywaiter.NewOrder;
import ie.mywaiter.mywaiter.R;
import ie.mywaiter.mywaiter.SplashScreen;
import ie.mywaiter.mywaiter.TablesActivity;
import ie.mywaiter.mywaiter.ViewOrders;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
/**
 * Created by Kev on 25/02/2018.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    private Context context;
    private List<Order> orders;


    public ListViewAdapter(Context context, List orders){
        this.context = context;
        this.orders = orders;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_of_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Order order = orders.get(position);
        holder.starter.setText(order.getStarter());
        holder.main.setText(order.getMain());
        holder.desert.setText(order.getDesert());
        holder.drink.setText(order.getDrink());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Delete order")
                        .setMessage("Are you sure you want to delete this order?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DataBaseHandler db = new DataBaseHandler(context);
                                db.deleteOrder(order);
                                orders.remove(order);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }


    @Override
    public int getItemCount() {

        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView starter;
        public TextView main;
        public TextView desert;
        public TextView drink;

        public ViewHolder(View itemView){

            super(itemView);



            starter = (TextView) itemView.findViewById(R.id.viewStarter);
            main = (TextView) itemView.findViewById(R.id.viewMain);
            desert = (TextView) itemView.findViewById(R.id.viewDesert);
            drink = (TextView) itemView.findViewById(R.id.viewDrink);
        }


    }



}
