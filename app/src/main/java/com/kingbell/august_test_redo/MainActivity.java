package com.kingbell.august_test_redo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    ListView ls;
    DataSource ds = new DataSource();
    String[] planetName;
    String[] planetDiameter;
    int[] imageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the Data Source values to Local Variables
        planetName=ds.planetNameData;
        planetDiameter=ds.planetDiameterData;
        imageName=ds.image;

        //List View initialize
        ls = (ListView) findViewById(R.id.listView);

        //CustomAdapter
        customAdapter adapter = new customAdapter(this,planetName,planetDiameter,imageName);
        ls.setAdapter(adapter);

        //ListView OnClick
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Calling Second Activity
                Intent intent = new Intent(MainActivity.this,secondActiviy.class);
                intent.putExtra("itemPosition",position);
                startActivity(intent);
            }
        });
    }

    public class customAdapter extends ArrayAdapter<String>{
        Context context;
        String[] planetN;
        String[] diameterN;
        int[] imageN;
        public customAdapter(Context context, String[] planetN, String[] diameterN, int[] imageN) {
            super(context, R.layout.single_layout, planetN);
            this.context = context;
            this.planetN = planetN;
            this.diameterN = diameterN;
            this.imageN = imageN;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.single_layout,parent,false);
            //Getting the view objects
            ImageView img = (ImageView) row.findViewById(R.id.imageView);
            TextView name = (TextView) row.findViewById(R.id.planetText);
            TextView dia = (TextView) row.findViewById(R.id.diameterText);
            //Assigning values
            img.setImageResource(imageN[position]);
            name.setText(planetN[position]);
            dia.setText(diameterN[position]);
            return row;
        }
    }
}

