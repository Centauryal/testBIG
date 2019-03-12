package com.centaury.test.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.centaury.test.R;
import com.centaury.test.data.model.ResultsItem;
import com.centaury.test.ui.detail.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Centaury on 3/12/2019.
 */
public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.viewHolder> {

    private Context context;
    private List<ResultsItem> resultsItemList;

    public StarWarsAdapter(Context context, List<ResultsItem> resultsItemList) {
        this.context = context;
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_starwars, viewGroup, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        ResultsItem item = resultsItemList.get(i);

        viewHolder.mNameStarWars.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return resultsItemList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name_star_wars)
        TextView mNameStarWars;

        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("star", resultsItemList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
