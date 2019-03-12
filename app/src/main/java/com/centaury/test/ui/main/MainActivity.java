package com.centaury.test.ui.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.centaury.test.BuildConfig;
import com.centaury.test.R;
import com.centaury.test.data.model.ResultsItem;
import com.centaury.test.data.model.StarWars;
import com.centaury.test.ui.main.adapter.StarWarsAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyc_starwars)
    RecyclerView mRecycStarwars;

    private List<ResultsItem> resultsItemList;
    private StarWarsAdapter starWarsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private String pages;
    private boolean isLoading = true;
    private static final String BASE_URL = BuildConfig.BASEURL;

    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        resultsItemList = new ArrayList<>();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        starWarsAdapter = new StarWarsAdapter(this, resultsItemList);
        linearLayoutManager = new LinearLayoutManager(this);
        mRecycStarwars.setLayoutManager(linearLayoutManager);
        mRecycStarwars.setAdapter(starWarsAdapter);
        getStarWars();
    }

    private void getStarWars() {
        showProgressDialog(true);
        final OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + "people/?page=1";
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                showProgressDialog(false);
                Toast.makeText(MainActivity.this, "Gagal memuat data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                showProgressDialog(false);
                final String textResponse = response.body().string();
                final StarWars starWars = new Gson().fromJson(textResponse, StarWars.class);
                pages = starWars.getNext();

                for (int i = 0; i < starWars.getResults().size(); i++) {
                    resultsItemList.add(starWars.getResults().get(i));
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        starWarsAdapter.notifyDataSetChanged();
                        isLoading = false;
                    }
                });
            }
        });

        mRecycStarwars.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                int visibleThreshold = 5;
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold) && pages != null) {
                    Request req = new Request.Builder()
                            .url(pages)
                            .get()
                            .build();

                    client.newCall(req).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String textResponse = response.body().string();
                            StarWars starWars = new Gson().fromJson(textResponse, StarWars.class);
                            Log.d("starwars", starWars + "");
                            pages = starWars.getNext();
                            resultsItemList.addAll(starWars.getResults());

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    starWarsAdapter.notifyDataSetChanged();
                                    isLoading = false;
                                }
                            });
                        }
                    });

                    isLoading = true;
                }
            }
        });
    }

    public void showProgressDialog(boolean show) {
        if (show) {
            progressDialog.setMessage("Memuat");
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }
}
