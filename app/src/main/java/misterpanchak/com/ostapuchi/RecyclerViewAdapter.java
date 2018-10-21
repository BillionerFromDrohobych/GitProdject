package misterpanchak.com.ostapuchi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context ccontext;
    private List<City> cityData;

    Intent intent;


    public RecyclerViewAdapter(Context ccontext, List<City> cityData) {
        this.ccontext = ccontext;
        this.cityData = cityData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater cInflater = LayoutInflater.from(ccontext);
        view = cInflater.inflate(R.layout.cardview, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.CityTextView.setText(cityData.get(i).getName());
        /* Picasso.get()
                .load(cityData.get(i).getImgUrl())
                .resize(300,300  )
                .into(myViewHolder.CityImageView);*/
        myViewHolder.CityImageView.setImageResource(cityData.get(i).getImgUrl());
                       myViewHolder.CityCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

              choise( cityData.get(i).getName(),
                      cityData.get(i).getImgUrl(),
                      cityData.get(i).getLocation(),
                      cityData.get(i).getDesctription(),
                      cityData.get(i).getSightorcity(),
                      cityData.get(i).getAdress());

            }


        });

    }
    /*public void setFilter(List<City> cityList){
        cityData.clear();
        cityData.addAll(cityList);
        notifyDataSetChanged();
    }*/

    public void choise(String name, int imgurl, String location, String desctription, boolean sightorcity, String adress) {
        intent = new Intent(ccontext, SightActivity.class);

        if(sightorcity ==false){
        switch (name) {
            case "Kiev":
                cityData.clear();
                cityData.add(new City("Kiev Politechnik Institute", R.drawable.kiev, "geo:50.454978,30.445443", "0", true, "vul. Saint Ostapuchi"));
                cityData.add(new City("Taras Shevchenko National University of Kyiv", R.drawable.kiev, "", "0", true,"vul. Saint Ostapuchi"));
            break;
            case "Lviv":
                cityData.clear();
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true,"vul. Saint Ostapuchi"));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true,"vul. Saint Ostapuchi"));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true,"vul. Saint Ostapuchi"));
                break;
            /*case "Kharkov":
                cityData.clear();
                cityData.add(new City("Kharkiv", R.drawable.drogobych, "", "0", true));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                break;

            case "Drohobych":
                cityData.clear();
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                break;

            case "London":
                cityData.clear();
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                cityData.add(new City("Kharkiv", R.drawable.kharkiv, "", "0", true));
                break;
            */}

        }else if(sightorcity == true) {

                intent.putExtra("name",name);
                intent.putExtra("adress",adress);
               // intent.putExtra("description",description);
                intent.putExtra("imgurl",imgurl);
                intent.putExtra("location",location);

         ccontext.startActivity(intent);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cityData.size();
    }
    public void filteredListed(ArrayList<City> filteredList){
        cityData = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView CityTextView;
        ImageView CityImageView;
        CardView CityCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            CityTextView = (TextView) itemView.findViewById(R.id.cityTextView);
            CityImageView = (ImageView) itemView.findViewById(R.id.cityImageView);
            CityCardView = (CardView) itemView.findViewById(R.id.CityCardView);

        }


    }
}
