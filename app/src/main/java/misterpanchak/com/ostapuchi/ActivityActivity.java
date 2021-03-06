package misterpanchak.com.ostapuchi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class ActivityActivity extends AppCompatActivity {

    List<City> cityList;
    RecyclerViewAdapter adp;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        cityList = new ArrayList<>();
        cityList.add(new City("Kyiv", R.drawable.kiev,0,0,"", "s", false, "vul. Saint Ostapuchi"));
        cityList.add(new City("Lviv", R.drawable.lviw,0,0,"", "s", false, "vul. Saint Ostapuchi"));
        cityList.add(new City("Drohobych", R.drawable.drogobych,0,0,"", "s", false, "vul. Saint Ostapuchi"));
        cityList.add(new City("London", R.drawable.london,0,0,"", "s", false, "vul. Saint Ostapuchi"));
        cityList.add(new City("Kharkov", R.drawable.kharkiv,0,0,"", "s", false, "vul. Saint Ostapuchi"));
         rv = (RecyclerView) findViewById(R.id.cityRecyclerView);



        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());


            }
        });
        adp = new RecyclerViewAdapter(this, cityList);
        rv.setLayoutManager(new GridLayoutManager(this, 1));
        rv.setAdapter(adp);
    }
    private void filter(String text){
        ArrayList<City> filteredList = new ArrayList<>();
        for(City city: cityList){
            if(city.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(city);

            }
        }
            adp.filteredListed(filteredList);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }
       public boolean onOptionsItemSelected(MenuItem item) {
           int id = item.getItemId();


           if (id == R.id.refreshicon) {

                cityList.clear();
                cityList.add(new City("Kyiv", R.drawable.kiev,0,0,"", "s", false, "vul. Saint Ostapuchi"));
                cityList.add(new City("Lviv", R.drawable.lviw,0,0,"", "s", false, "vul. Saint Ostapuchi"));
                //cityList.add(new City("Drohobych", R.drawable.drogobych,0,0,"", "s", false, "vul. Saint Ostapuchi"));
                //cityList.add(new City("London", R.drawable.london,0,0,"", "s", false, "vul. Saint Ostapuchi"));
                //cityList.add(new City("Kharkov", R.drawable.kharkiv,0,0,"", "s", false, "vul. Saint Ostapuchi"));
               adp.notifyDataSetChanged();

                return true;
        }
           return super.onOptionsItemSelected(item);
        }





}