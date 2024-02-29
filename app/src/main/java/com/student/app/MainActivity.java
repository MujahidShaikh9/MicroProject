package com.student.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.student.app.model.StudentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2,edt3,edt4;
    RadioGroup rg1;
    RadioButton rb;
    Button b1,b2;

    ArrayList<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        ListView listView = findViewById(R.id.listview);

        edt1=findViewById(R.id.editTextText);
        edt2=findViewById(R.id.editTextText2);
        edt3=findViewById(R.id.editTextText3);
        edt4=findViewById(R.id.editTextText4);
        rg1=findViewById(R.id.rg);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb = findViewById(checkedId);
            }
        });





        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()){
                    if(rb.isChecked()){
                        try {
                            String name =edt1.getText().toString().trim();
                            String age = edt2.getText().toString().trim();
                            String address =edt3.getText().toString().trim();
                            String phone =edt4.getText().toString().trim();
                            String s = "Name : "+name+"\nAge : "+age+"\nAddress : "+address+"\nPhone no : "+phone+"\nGender : "+rb.getText()+"\n";
                            list.add(s);
                            listView.setAdapter(adapter);
                            edt1.setText("");
                            edt2.setText("");
                            edt3.setText("");
                            edt4.setText("");
                            rg1.clearCheck();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"NULL",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"select Gender",Toast.LENGTH_LONG).show();
                    }
                }



            }
        });

        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();

                listView.setAdapter(adapter);
            }
        });


    }




    public boolean check(){
        if(edt1.getText().toString().isEmpty()){
            edt1.setFocusable(true);
            edt1.setError("Cannot be empty");
            return false;
        }

        if(edt2.getText().toString().isEmpty()){
            edt2.setFocusable(true);
            edt2.setError("Cannot be empty");
            return false;
        }
        if(edt3.getText().toString().isEmpty()){
            edt3.setFocusable(true);
            edt3.setError("Cannot be empty");
            return false;
        }
        if(edt4.getText().toString().isEmpty()){
            edt4.setFocusable(true);
            edt4.setError("Cannot be empty");
            return false;
        }

        return true;
    }
}