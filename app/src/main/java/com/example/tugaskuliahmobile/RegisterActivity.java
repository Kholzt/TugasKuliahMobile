package com.example.tugaskuliahmobile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tugaskuliahmobile.libs.Dialog;
import com.example.tugaskuliahmobile.libs.Form;

public class RegisterActivity extends AppCompatActivity {
    private String fullName ;
    private String username ;
    private String email ;
    private String dateBirth ;
    private String password ;
    private String confirm ;
    private String alamat ;
    private String gender ;
    private String noHp ;
    private Button btnRegister ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister = findViewById(R.id.btn_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegister();
            }
        });

    }


    
    private void submitRegister(){
        this.fullName = Form.getInputVal(findViewById(R.id.fullname));
        this.username = Form.getInputVal(findViewById(R.id.username));
        this.password = Form.getInputVal(findViewById(R.id.password));
        this.confirm = Form.getInputVal(findViewById(R.id.confirm));
//        this.gender = Form.getSpinnerVal(findViewById(R.id.gender));
        this.alamat = Form.getInputVal(findViewById(R.id.alamat));
        this.noHp = Form.getInputVal(findViewById(R.id.no_hp));
        this.email = Form.getInputVal(findViewById(R.id.email));

        try {
            Toast.makeText(this,"Berhasil register",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("RegisterActivity", "Error showing dialog", e);
        }
    }
}