package com.fscore.display;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Users1> list;

    public MyAdapter(Context context, ArrayList<Users1> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Users1 user=list.get(position);
        holder.JessyNo.setText(user.getJno());
        holder.PlayerName.setText(user.getName());
        holder.PlayerScore.setText(user.getScore());
        holder.RedCount.setText(user.getRedcnt());
        holder.YellowCount.setText(user.getYellowcnt());
        holder.TwoCount.setText(user.getTwocnt());

        if(user.getRedswth().equals("YES"))
            holder.Red.setVisibility(View.VISIBLE);
        else
            holder.Red.setVisibility(View.INVISIBLE);

        if(user.getTwoswitch().equals("YES"))
            holder.Two.setVisibility(View.VISIBLE);
        else
            holder.Two.setVisibility(View.INVISIBLE);

        if(user.getYellowswth().equals("YES"))
            holder.Yellow.setVisibility(View.VISIBLE);
        else
            holder.Yellow.setVisibility(View.INVISIBLE);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView JessyNo,PlayerName,PlayerScore,RedCount,YellowCount,TwoCount;
        ImageView Red,Yellow,Two;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            JessyNo=itemView.findViewById(R.id.jessynNo);
            PlayerName=itemView.findViewById(R.id.playerName);
            PlayerScore=itemView.findViewById(R.id.playerScore);
            RedCount=itemView.findViewById(R.id.redCount);
            YellowCount=itemView.findViewById(R.id.yellwCount);
            TwoCount=itemView.findViewById(R.id.twoCount);
            Red=itemView.findViewById(R.id.redCard);
            Yellow=itemView.findViewById(R.id.yellowCard);
            Two=itemView.findViewById(R.id.twoCard);

        }
    }
}
