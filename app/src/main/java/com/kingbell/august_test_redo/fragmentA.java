package com.kingbell.august_test_redo;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentA extends Fragment {

    ToggleButton redT,blueT,greenT;
    int red=0,green=0,blue=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment,container,false);

        redT = (ToggleButton) v.findViewById(R.id.redToggle);
        blueT = (ToggleButton) v.findViewById(R.id.blueToggle);
        greenT = (ToggleButton) v.findViewById(R.id.greenToggle);

        final secondActiviy act = (secondActiviy) getActivity();

        redT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    red =255;
                }
                else
                {
                    red = 0;
                }
                act.updateColor();
            }
        });

        greenT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    green = 255;
                } else {
                    green = 0;
                }
                act.updateColor();
            }
        });

        blueT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    blue = 255;
                } else {
                    blue = 0;
                }
                act.updateColor();
            }
        });

       return v;
    }

}
