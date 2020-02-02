package com.example.currencyconvertor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button convert;
   TextView usd;
    TextView pkr;
     TextView yuan;
     EditText firstcrrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getSupportActionBar().setTitle("Currency Convertor");
       convert=findViewById(R.id.button);
       usd=findViewById(R.id.usd);
       pkr=findViewById(R.id.pk);
       yuan=findViewById(R.id.Yuan);
       firstcrrency=findViewById(R.id.firstcurrency);



        Spinner spinner1=findViewById(R.id.spinner_1);

        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.curency,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(this);






    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner1 = (Spinner)parent;

        if(spinner1.getId() == R.id.spinner_1)
        {
            String text1=parent.getItemAtPosition(position).toString();

          converted(text1);

        }




    }

    private void converted(final String text1) {
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edittext=firstcrrency.getText().toString();
                if(edittext.isEmpty()){
                    firstcrrency.setError("please enter Currency");
                }

                    Log.d("1","place");
                Double a=Double.parseDouble(edittext);
                    if(text1.equals("US$")){
                        Log.d("2","place");
                            Double b=a*1;
                        Double c=  (a*154.61000);
                        Double d=  (a* 6.93665);
                        usd.setText(String.valueOf(b).concat(" $"));
                        pkr.setText(String.valueOf(c).concat(" RS"));
                        yuan.setText(String.valueOf(d).concat(" Yuan"));
                    }
                    if(text1.equals("PKRupee")){
                        Double b=a*0.00647;
                        Double c=  (a*1);
                        Double d=  (a* 0.04487);
                        usd.setText(String.valueOf(b).concat(" $"));
                        pkr.setText(String.valueOf(c).concat(" RS"));
                        yuan.setText(String.valueOf(d).concat(" Yuan"));
                    }
                    if(text1.equals("Yuan")){
                        Double b=a*0.14416;
                        Double c= a*22.27;
                        Double d=  (a*1);
                        usd.setText(String.valueOf(b).concat(" $"));
                        pkr.setText(String.valueOf(c).concat(" RS"));
                        yuan.setText(String.valueOf(d).concat(" Yuan"));



                    }


                }

        });


    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
