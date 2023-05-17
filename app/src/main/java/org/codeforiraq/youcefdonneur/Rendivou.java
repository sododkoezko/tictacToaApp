package org.codeforiraq.youcefdonneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Rendivou extends AppCompatActivity {
    Button button;
    Bundle extras;
    Boolean n1,n2,n3,n4;
    RadioGroup radioGroup1, radioGroup2,radioGroup3, radioGroup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendivou);
        button=findViewById(R.id.button5);

        radioGroup1=findViewById(R.id.group1);
        radioGroup2=findViewById(R.id.group2);
        radioGroup3=findViewById(R.id.group3);
        radioGroup4=findViewById(R.id.group4);

        n1=true;
        n2=true;
        n3=true;
        n4=true;
        f1();
        f2();
        f3();
        f4();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(n1 & n2 & n3 & n4){
                    Intent i=new Intent(Rendivou.this,MainActivity7.class );

                    startActivity(i);

                }else{
                    Toast.makeText(Rendivou.this, "La réservation a échoué", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    private void f4() {
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton4 = findViewById(i);
                switch (radioButton4.getId()) {
                    case R.id.radioButton7: {
                        n4=true;
                    }break;
                    case R.id.radioButton8: {
                        n4=false;
                    }break;
                }
            }
        });
    }

    private void f3() {
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton3  = findViewById(i);
                switch (radioButton3.getId()) {
                    case R.id.radioButton5: {
                        n3=true;
                    }break;
                    case R.id.radioButton6: {
                        n3=false;
                    }break;
                }
            }
        });
    }

    private void f2() {
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton2 = findViewById(i);
                switch (radioButton2.getId()) {
                    case R.id.radioButton3: {
                        n2=true;
                    }break;
                    case R.id.radioButton4: {
                        n2=false;
                    }break;
                }
            }
        });
    }

    private void f1() {
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton1 = findViewById(i);
                switch (radioButton1.getId()) {
                    case R.id.radioButton1: {
                        n1=true;
                    }break;
                    case R.id.radioButton3: {
                        n1=false;
                    }break;
                }
            }
        });
    }
}