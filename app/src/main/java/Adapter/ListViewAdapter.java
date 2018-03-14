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
import Model.Order;
import ie.mywaiter.mywaiter.NotesActivity;
import ie.mywaiter.mywaiter.NewOrder;
import ie.mywaiter.mywaiter.R;
import ie.mywaiter.mywaiter.SplashScreen;
import ie.mywaiter.mywaiter.TablesActivity;
import ie.mywaiter.mywaiter.ViewOrders;

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
        Order order = orders.get(position);

        holder.starter.setText(order.getStarter());
        holder.main.setText(order.getMain());
        holder.desert.setText(order.getDesert());
        holder.drink.setText(order.getDrink());

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
