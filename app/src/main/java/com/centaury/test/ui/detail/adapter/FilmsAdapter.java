package com.centaury.test.ui.detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.centaury.test.R;
import com.centaury.test.ui.detail.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Centaury on 3/12/2019.
 */
public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.viewHolder> {

    private Context context;
    private List<String> filmsList;

    public FilmsAdapter(Context context, List<String> filmsList) {
        this.context = context;
        this.filmsList = filmsList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text, viewGroup, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        String list = filmsList.get(i);

        viewHolder.mNameText.setText(list);
    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name_text)
        TextView mNameText;

        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
