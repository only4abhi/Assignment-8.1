package com.example.abhishek.assignment81;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    EditText mName , mAge , mPhone , mCity ;
    Button btnSave , btnShow;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        mName = (EditText)findViewById(R.id.idName);
        mAge = (EditText)findViewById(R.id.idAge);
        mPhone = (EditText)findViewById(R.id.idPhone);
        mCity = (EditText)findViewById(R.id.idCity);

        btnSave = (Button)findViewById(R.id.idSave);
        btnShow = (Button)findViewById(R.id.idShow);

        //Action
        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.idSave:
                attemptSave();
                break;
            case R.id.idShow:
                attemptShow();
                break;
        }
    }

    public void attemptSave(){

        String nm = mName.getText().toString();
        String age  = mAge.getText().toString();
        String ph  = mPhone.getText().toString();
        String ct  = mPhone.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("name", nm);
        editor.putString("age", age);
        editor.putString("phone", ph);
        editor.putString("city", ct);
        editor.commit();

        Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();

    }

    public void attemptShow(){

        StringBuffer buffer = new StringBuffer();
        String sname = sharedpreferences.getString("name","");
        buffer.append("Name :"+ sname+"\n");
        String sage = sharedpreferences.getString("age","");
        buffer.append("Age :"+ sage+"\n");
        String sphone = sharedpreferences.getString("phone","");
        buffer.append("Phone :"+ sphone+"\n");
        String scity = sharedpreferences.getString("city","");
        buffer.append("City :"+ scity+"\n");

        // Show all data
        showMessage("Information",buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
