package org.codeforiraq.youcefdonneur;

import static org.codeforiraq.youcefdonneur.Sing.MYKEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    private EditText name,phone,password,typedesang,email,sex;
    private Button button;
    DatabaseReference databaseReference;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pemition-f968a-default-rtdb.firebaseio.com/");
    Bundle extras,extras1;
    ImageView imageView;
    String d1;
    SharedPreferences preferences1;
    String pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.h);
        typedesang=findViewById(R.id.typedesang);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        sex=findViewById(R.id.sex);
        button=findViewById(R.id.button3);
        imageView=findViewById(R.id.imageView2);
        getr1();

        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup=findViewById(R.id.n2);
                radioGroup.setVisibility(View.VISIBLE);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        RadioButton radioButton=findViewById(i);
                        switch(radioButton.getId()){
                            case R.id.homme:{
                                sex.setText(radioButton.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }break;
                            case R.id.famme:{
                                sex.setText(radioButton.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }break;
                        }
                    }
                });
            }
        });
        chek1();
        chek2();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt=name.getText().toString();
                String phonetxt=phone.getText().toString();
                String typedesangtxt=typedesang.getText().toString();
                String passwordtxt=password.getText().toString();
                String sextxt=sex.getText().toString();
                String emailtxt=email.getText().toString();
                if(nametxt.isEmpty()||emailtxt.isEmpty()||
                        typedesangtxt.isEmpty()||passwordtxt.isEmpty()||emailtxt.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Compléter tous les champs", Toast.LENGTH_SHORT).show();
                    name.setError("entrer ");
                    phone.setError("entrer ");
                    email.setError("entrer ");
                    typedesang.setError("entrer ");
                    password.setError("entrer ");

                    sex.setError("entrer ");
                    email.setError("entrer ");
                }
                else {
                    updateData(nametxt,phonetxt,typedesangtxt,sextxt,emailtxt,passwordtxt);

                }

            }

        });
    }


    private void updateData(String nametxt, String phonetxt, String typedesangtxt, String sextxt, String emailtxt, String passwordtxt) {
        HashMap User = new HashMap<>();
        User.put("name", nametxt);
        User.put("password", passwordtxt);
        User.put("typedesang", typedesangtxt);
        User.put("le sex", sextxt);
        User.put("l'age", emailtxt);
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        databaseReference.child(phonetxt).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    name.setText(nametxt);
                    phone.setText(phonetxt);
                    typedesang.setText(typedesangtxt);
                    sex.setText(sextxt);
                    email.setText(emailtxt);
                    password.setText(passwordtxt);
                    Toast.makeText(MainActivity2.this, "le conte est modifié", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(MainActivity2.this, "le conte n'a pas modifié ", Toast.LENGTH_SHORT).show();
                }

            }

            ;
        });




    }
    private void chek1 () {

        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.n2);
                radioGroup.setVisibility(View.VISIBLE);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        RadioButton radioButton = findViewById(i);
                        switch (radioButton.getId()) {
                            case R.id.homme: {
                                sex.setText(radioButton.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.famme: {
                                sex.setText(radioButton.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                        }
                    }
                });
            }
        });

    }


    private void chek2 () {
        typedesang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup2 = findViewById(R.id.n2);
                radioGroup2.setVisibility(View.VISIBLE);
                radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        RadioButton radioButton1 = findViewById(i);
                        switch (radioButton1.getId()) {
                            case R.id.a: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.ax: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.b: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.bx: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.fi: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.fx: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                            case R.id.homme:
                                b:
                                {
                                    typedesang.setText(radioButton1.getText().toString());
                                    radioGroup.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case R.id.abx: {
                                typedesang.setText(radioButton1.getText().toString());
                                radioGroup.setVisibility(View.INVISIBLE);
                            }
                            break;
                        }
                    }
                });
            }
        });
    }
    public void getr1(){
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                preferences1=getSharedPreferences(MYKEY,0);
                pref= preferences1.getString("key","not found");

                Log.d("youcef logging", "pref : " + pref);
                if(snapshot.exists()) {

                    d1 = snapshot.child("user").child(pref).child("le sex").getValue(String.class);



                    if(d1.equals("Homme")){
                        imageView.setImageResource(R.drawable.profilefff);
                    }


                }else{
                    Toast.makeText(MainActivity2.this, "fild to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}