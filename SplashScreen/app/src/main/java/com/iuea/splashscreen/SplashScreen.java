package com.iuea.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SplashScreen extends AppCompatActivity {
    Connection_internet connectionInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        connectionInternet = new Connection_internet(this);

        if (connectionInternet.isConnected()) {
            // Delay for 3 seconds before transitioning to MainActivity
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
            Toast.makeText(this,"isconnected",Toast.LENGTH_LONG).show();
        } else {
            // Show Snackbar and prevent transition
            Snackbar.make(findViewById(android.R.id.content), "No Internet Network Connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recreate(); // Restart the activity to check connection again
                        }
                    })
                    .show();
        }
    }
}
