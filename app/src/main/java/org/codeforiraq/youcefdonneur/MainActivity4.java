package org.codeforiraq.youcefdonneur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;

public class MainActivity4 extends AppCompatActivity {
    Button button;
    CalendarView calendarView;
RadioGroup radioGroup;
    String temps;
    String date;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/user");

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button=findViewById(R.id.button6);


        date="";
        temps="";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView=findViewById(R.id.calendarView2);
                radioGroup=findViewById(R.id.group11);

                chek();
                calender();
                final String temps1=temps;
                 final String date1=date;
               if(date1.isEmpty()||temps1.isEmpty()){
                   Toast.makeText(MainActivity4.this, "choisir le temps ou la date", Toast.LENGTH_SHORT).show();
               }else {
                   databaseReference.child("les rendez vous").child("Date").setValue(date1);
                   databaseReference.child("les rendez vous").child("Tepms").setValue(temps1);
                   Toast.makeText(MainActivity4.this, "rejistred", Toast.LENGTH_SHORT).show();
                   finish();

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
                date="year"+i+"-"+"Monthe :"+i+"-"+"Day"+i2;
            }
        });
    }
}
/*    RadioGroup radioGroup1;
    Boolean n1,n2,n3,n4,n5,n6,n7,n8;
    String fi;
    Bundle extras;
    int reserve;
String data ;*/