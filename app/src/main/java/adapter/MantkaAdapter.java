package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gp.last.R;
import model.Mantka;

/**
 * Created by Maryam on 4/30/2016.
 */
public class MantkaAdapter extends RecyclerView.Adapter<MantkaAdapter.MyViewHolder> {
    List<Mantka> mantkaList ;


    public class MyViewHolder extends RecyclerView.ViewHolder {
       public TextView name ;

       public MyViewHolder(View view){
           super(view);
           name = (TextView) view.findViewById(R.id.mant2a) ;
       }
   }
    public MantkaAdapter (List<Mantka>mantkaList) {
        this.mantkaList = mantkaList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mantka mantka = mantkaList.get(position);
        holder.name.setText(mantka.getName());
    }

    @Override
    public int getItemCount() {
        return mantkaList.size();
    }

}
