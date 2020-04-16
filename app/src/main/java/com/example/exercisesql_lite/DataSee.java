package com.example.exercisesql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;

public class DataSee extends AppCompatActivity {
    EditText name, email, address, phone;
    String mode="",idUser="0";
    Button btnSimpan, btnKembali;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            switch (event.getAction()) {
                case KeyEvent.ACTION_DOWN:

                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();

                    return true;
            }
        }
        return false;
    }

    private static  String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_see);

        name =(EditText) findViewById(R.id.editTextNama);
        phone =(EditText) findViewById(R.id.editTextNoTelp);
        email =(EditText) findViewById(R.id.editTextEmail);
        address =(EditText) findViewById(R.id.editTextAlamat);

        btnSimpan=(Button) findViewById(R.id.btnsimpan);
        btnKembali=(Button) findViewById(R.id.btnkembali);

        Intent in = this.getIntent();
        mode= in.getStringExtra("mode");

        if(mode.equals("Edit")){
            idUser =  in.getStringExtra("id_user");

            DBHelper db = new DBHelper(getApplicationContext());
            ModKontak modKontak = db.getUserById(idUser);

            name.setText(modKontak.getNama());
            phone.setText(modKontak.getPhone());
            email.setText(modKontak.getEmail());
            address.setText(modKontak.getAlamat());

        }
    }
}
