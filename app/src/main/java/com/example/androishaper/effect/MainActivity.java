package com.example.androishaper.effect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Button buttonToast;
    ToggleButton toggleButton;
    Switch buttonSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonToast=findViewById(R.id.buttontoast);
        toggleButton=findViewById(R.id.tooglebutton);
        buttonSwitch=findViewById(R.id.buttonswitch);
        buttonToast.setOnClickListener(this);
        toggleButton.setOnCheckedChangeListener(this);
        buttonSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.buttontoast)
        {
            MyToast();
        }
    }

    private void MyToast() {
        LayoutInflater li= getLayoutInflater();
        View layout=li.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.customid));
        Toast toast=new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.getId()==R.id.tooglebutton){
            if (b)
            {
                UseToast("Wifi is on");

            }
            else
            {
                UseToast("Wifi is off");

            }

        }
        else if(compoundButton.getId()==R.id.buttonswitch)
        {
            if (b)
            {
                UseToast("Wifi1 is on");

            }
            else
            {
                UseToast("Wifi1 is off");

            }
        }

    }

    private void UseToast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
}
