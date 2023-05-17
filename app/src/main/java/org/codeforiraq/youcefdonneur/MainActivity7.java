package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity7 extends AppCompatActivity {
    Button button;
    CalendarView calendarView;
    RadioGroup radioGroup;
    String temps;
    String date,t1;
    int nombre,getnombre;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        button=findViewById(R.id.button7);
        calendarView=findViewById(R.id.calendarView);
        radioGroup=findViewById(R.id.group11);

        date="";
        temps="";
        chek();
        calender();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chek();
                calender();

                if(date.isEmpty()||temps.isEmpty()){
                    Toast.makeText(MainActivity7.this, "choisir le temps ou la date", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences preferences1=getSharedPreferences(MYKEY,0);
                    String pref= preferences1.getString("key","not foond");

                    databaseReference.child("les rendez vous").child(pref).child("Date").setValue(date);
                    databaseReference.child("les rendez vous").child(pref).child("temps").setValue(temps);

                    Toast.makeText(MainActivity7.this, "rejistred", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent gh=new Intent(MainActivity7.this,Userkisegel.class);
                    startActivity(gh);

                }
            }




        });

    }
    private void chek() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=findViewById(i);
                switch (radioButton.getId()) {
                    case R.id.f1:{
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f2: {
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f3: {
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f4: {
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f5: {
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f6: {
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f7: {
                        temps=radioButton.getText().toString();
                    }break;
                    case R.id.f8: {
                        temps=radioButton.getText().toString();
                    }break;


                }
            }
        });
    }
    private void calender() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date="year"+i+"/"+"Monthe :"+i1+"/"+"Day"+i2;
            }
        });
    }

}
