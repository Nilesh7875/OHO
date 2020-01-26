package com.example.sharemyjourney;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.Set;

public class SetProfile extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button submitButton;
    private EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);

        final EditText editText=(EditText) findViewById(R.id.vehichlenumber);

        editText.setVisibility(View.INVISIBLE);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                switch(checkedId)
                {
                    case R.id.Yes:
                        editText.setVisibility(View.VISIBLE);
                        break;
                    case R.id.No:
                        editText.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        submitButton = (Button) findViewById(R.id.submit);
        nameText=(EditText) findViewById(R.id.username);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameText.getText().toString().equals(" ")){
                    Toast.makeText(SetProfile.this,"User Name is Empty..",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(SetProfile.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(SetProfile.this,"Profile Set Correctly..",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
