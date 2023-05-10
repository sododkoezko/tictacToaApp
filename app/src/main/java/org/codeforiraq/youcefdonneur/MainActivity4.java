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
    RadioGroup radioGroup1;
    Boolean n1,n2,n3,n4,n5,n6,n7,n8;
    String fi;
    Bundle extras;
    int reserve;
String data ;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/user");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        calendarView=findViewById(R.id.calendarView2);
        button=findViewById(R.id.button6);
        radioGroup1=findViewById(R.id.group11);
        extras=getIntent().getExtras();
        String g=extras.getString("name9");
        n1=false;
        n2=false;
        n3=false;
        n4=false;
        n5=false;
        n6=false;
        n7=false;
        n8=false;
        data="no";
        fi="";
        reserve=0;


chek();
caland();

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(n1==false || n2==false ||n3==false || n4==false ||
                n5==false || n6==false ||n7==false || n8==false){
            Toast.makeText(MainActivity4.this, "choisir le temp", Toast.LENGTH_SHORT).show();

        }else if(data=="no") {
            Toast.makeText(MainActivity4.this, "choisir la date ", Toast.LENGTH_SHORT).show();
        }else{

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {


                    databaseReference.child("les rendez vous").child(g).child("date").setValue(data);
                    databaseReference.child("les rendez vous").child(g).child("temps").setValue(fi);
                    databaseReference.child("les rendez vous").child(g).child("number de reservation ").setValue(reserve);

                    Toast.makeText(MainActivity4.this, "rejistred", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent i = new Intent(MainActivity4.this, Userkisegel.class);

                    startActivity(i);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: <a
                 * href="https://firebase.google.com/docs/database/security/quickstart" target="_blank"> Security
                 * Quickstart</a>
                 *
                 * @param error A description of the error that occurred
                 */



            };
        }

    });
    }


    private void caland() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                data=""+i/i1/i2;
                reserve=reserve+1;
            }
        });
    }

    private void chek() {
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                switch (radioButton.getId()) {
                    case R.id.radioButton22: {
                         fi=radioButton.getText().toString();
                        n1=true;
                    }break;
                    case R.id.radioButton23: {
                       fi=radioButton.getText().toString();
                        n2=true;
                    }break;
                    case R.id.radioButton20: {
                        fi=radioButton.getText().toString();
                        n3=true;
                    }break;
                    case R.id.radioButton21: {
                      fi=radioButton.getText().toString();
                        n4=true;
                    }break;
                    case R.id.radioButton19: {
                      fi=radioButton.getText().toString();
                        n5=true;
                    }break;
                    case R.id.radioButton18: {
                       fi=radioButton.getText().toString();
                        n6=true;
                    }break;
                    case R.id.radioButton26: {
                        fi=radioButton.getText().toString();
                        n7=true;
                    }break;
                    case R.id.radioButton27: {
                        fi=radioButton.getText().toString();
                        n8=true;
                    }break;
                }
            }
        });
    }
}