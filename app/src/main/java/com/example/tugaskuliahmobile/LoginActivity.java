package com.example.tugaskuliahmobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tugaskuliahmobile.libs.Form;
import com.example.tugaskuliahmobile.libs.Navigate;

public class LoginActivity extends AppCompatActivity {
    private TextView registerLink;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        registerLink = findViewById(R.id.registerLink);
        btnLogin = findViewById(R.id.btn_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //inisialisasi awal setelah register memasukkan value email ke inputan
        EditText email = findViewById(R.id.email);
        Bundle extras = getIntent().getExtras();
        String emailVal = (extras != null) ? extras.getString("email") : "";
        email.setText(emailVal);

        //intent ke register activity
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigate.push(LoginActivity.this, RegisterActivity.class);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLogin();
            }
        });
    }

    private void submitLogin() {
        String email = Form.getInputVal(findViewById(R.id.email));
        String password = Form.getInputVal(findViewById(R.id.password));
        try {
            Bundle extras = getIntent().getExtras();
            String emailVal = (extras != null) ? extras.getString("email") : "";
            String passwordVal = (extras != null) ? extras.getString("password") : "";
            Intent intent = new Intent(this, OrderActivity.class);


            if (email.equals(emailVal) && password.equals(passwordVal)) {
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Pemberitahuan")
                        .setMessage("Email atau password salah")
                        .setIcon(android.R.drawable.ic_delete)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Intent to navigate to the RecyclerView activity
                                Intent intent = new Intent(LoginActivity.this, ListMahasiswaActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Dismiss the dialog if "Tidak" is clicked
                                dialog.dismiss();
                            }
                        });

                // Show the AlertDialog
                builder.create().show();

            }
        } catch (Exception e) {
            Toast.makeText(this, "Server Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
            ;
            Log.e("LoginActivity", "Error showing dialog", e);
        }
    }
}