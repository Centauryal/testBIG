package com.centaury.test.ui.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.centaury.test.R;
import com.centaury.test.data.model.ResultsItem;
import com.centaury.test.ui.detail.adapter.FilmsAdapter;
import com.centaury.test.ui.detail.adapter.SpeciesAdapter;
import com.centaury.test.ui.detail.adapter.StarShipsAdapter;
import com.centaury.test.ui.detail.adapter.VehiclesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.height)
    TextView mHeight;
    @BindView(R.id.mass)
    TextView mMass;
    @BindView(R.id.hair_color)
    TextView mHairColor;
    @BindView(R.id.skin_color)
    TextView mSkinColor;
    @BindView(R.id.eye_color)
    TextView mEyeColor;
    @BindView(R.id.birth_year)
    TextView mBirthYear;
    @BindView(R.id.gender)
    TextView mGender;
    @BindView(R.id.homeworld)
    TextView mHomeworld;
    @BindView(R.id.films)
    RecyclerView mFilms;
    @BindView(R.id.species)
    RecyclerView mSpecies;
    @BindView(R.id.vehicles)
    RecyclerView mVehicles;
    @BindView(R.id.starships)
    RecyclerView mStarships;
    @BindView(R.id.created)
    TextView mCreated;
    @BindView(R.id.edited)
    TextView mEdited;
    @BindView(R.id.url)
    TextView mUrl;
    private Bundle extras;
    private ResultsItem resultsItem;

    private List<String> filmsList;
    private FilmsAdapter filmsAdapter;
    private List<String> speciesList;
    private SpeciesAdapter speciesAdapter;
    private List<String> vehiclesList;
    private VehiclesAdapter vehiclesAdapter;
    private List<String> starshipsList;
    private StarShipsAdapter starShipsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        filmsList = new ArrayList<>();
        speciesList = new ArrayList<>();
        vehiclesList = new ArrayList<>();
        starshipsList = new ArrayList<>();

        extras = getIntent().getExtras();
        if (extras != null) {
            resultsItem = extras.getParcelable("star");

            mName.setText(resultsItem.getName());
            mHeight.setText(resultsItem.getHeight());
            mMass.setText(resultsItem.getMass());
            mHairColor.setText(resultsItem.getHairColor());
            mSkinColor.setText(resultsItem.getSkinColor());
            mEyeColor.setText(resultsItem.getEyeColor());
            mBirthYear.setText(resultsItem.getBirthYear());
            mGender.setText(resultsItem.getGender());
            mHomeworld.setText(resultsItem.getHomeworld());

            getFilms();
            for (int i = 0; i < resultsItem.getFilms().size(); i++) {
                filmsList.add(resultsItem.getFilms().get(i));
            }
            filmsAdapter.notifyDataSetChanged();

            getSpecies();
            for (int i = 0; i < resultsItem.getSpecies().size(); i++) {
                speciesList.add(resultsItem.getSpecies().get(i));
            }
            speciesAdapter.notifyDataSetChanged();

            getVehicles();
            for (int i = 0; i < resultsItem.getVehicles().size(); i++) {
                vehiclesList.add(resultsItem.getVehicles().get(i));
            }
            vehiclesAdapter.notifyDataSetChanged();

            getStarShips();
            for (int i = 0; i < resultsItem.getStarships().size(); i++) {
                starshipsList.add(resultsItem.getStarships().get(i));
            }
            starShipsAdapter.notifyDataSetChanged();

            mCreated.setText(resultsItem.getCreated());
            mEdited.setText(resultsItem.getEdited());
            mUrl.setText(resultsItem.getUrl());
        }
    }

    private void getFilms() {
        filmsAdapter = new FilmsAdapter(this, filmsList);
        mFilms.setLayoutManager(new LinearLayoutManager(this));
        mFilms.setAdapter(filmsAdapter);
    }

    private void getSpecies() {
        speciesAdapter = new SpeciesAdapter(this, speciesList);
        mSpecies.setLayoutManager(new LinearLayoutManager(this));
        mSpecies.setAdapter(speciesAdapter);
    }

    private void getVehicles() {
        vehiclesAdapter = new VehiclesAdapter(this, vehiclesList);
        mVehicles.setLayoutManager(new LinearLayoutManager(this));
        mVehicles.setAdapter(vehiclesAdapter);
    }

    private void getStarShips() {
        starShipsAdapter = new StarShipsAdapter(this, starshipsList);
        mStarships.setLayoutManager(new LinearLayoutManager(this));
        mStarships.setAdapter(starShipsAdapter);
    }
}
