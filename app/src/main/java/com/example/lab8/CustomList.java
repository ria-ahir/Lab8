package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * This method gets the size of the list.
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * This adds a city object to the list
     * for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This method checks if city exists.
     * @param city the city we are searching for,
     * @return True if it exists, else false.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method deletes the selected city.
     * @param city The city to be deleted.
     * @return True if the city has been deleted, else false.
     */
    public boolean deleteCity(City city) {
        return cities.remove(city);
    }

    /**
     * This method returns the number of cities.
     * @return The number of cities.
     */
    public int countCities() {
        return getCount();
    }
}
