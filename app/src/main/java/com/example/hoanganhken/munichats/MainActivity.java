package com.example.hoanganhken.munichats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    private final static int LOGIN_PERMISSION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder()
                                .setAllowNewEmailAccounts(true).build(), LOGIN_PERMISSION
                );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_PERMISSION) {
            startNewActivity(resultCode, data);
        }
    }

    private void startNewActivity(int requestCode, Intent data) {
        if (requestCode == RESULT_OK) {
            Intent intent = new Intent(MainActivity.this, ListOnline.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }
}
