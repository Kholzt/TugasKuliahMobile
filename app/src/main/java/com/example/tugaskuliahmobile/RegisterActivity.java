    package com.example.tugaskuliahmobile;

    import android.app.DatePickerDialog;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Adapter;
    import android.widget.ArrayAdapter;
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
    import com.example.tugaskuliahmobile.libs.Helpers;

    import java.util.Calendar;

    public class RegisterActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            Spinner gender = Form.getSpinner(findViewById(R.id.gender));
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            String[] genders = new String[]{"laki-laki", "perempuan"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            gender.setAdapter(adapter);

            Button btnRegister = findViewById(R.id.btn_register);
            EditText edtDateBirth = findViewById(R.id.date_of_birth);
            edtDateBirth.setOnClickListener(v -> showDatePickerDialog(edtDateBirth));
            btnRegister.setOnClickListener(v -> submitRegister());

        }

 private <T extends TextView> void showDatePickerDialog(T outputComponent) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                RegisterActivity.this,
                (view, year1, month1, dayOfMonth) -> {
                    String  monthName = Helpers.getMonthName(month1);
                    String date = dayOfMonth + "-" + monthName.substring(0,3) + "-" + year1;
                    outputComponent.setText(date);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

        private void submitRegister(){
            String fullName = Form.getInputVal(findViewById(R.id.fullname));
            String username = Form.getInputVal(findViewById(R.id.username));
            String password = Form.getInputVal(findViewById(R.id.password));
            String confirm = Form.getInputVal(findViewById(R.id.confirm));
            String dateBirth = Form.getInputVal(findViewById(R.id.date_of_birth));
    //        String gender = Form.getSpinnerVal(findViewById(R.id.gender));
            String alamat = Form.getInputVal(findViewById(R.id.alamat));
            String noHp = Form.getInputVal(findViewById(R.id.no_hp));
            String email = Form.getInputVal(findViewById(R.id.email));
            try {
                String content = "Fullname          :"+fullName+"\n" +
                                 "Email             :"+email+"\n"+
                                 "Tanggal lahir     :"+dateBirth+"\n";
                Dialog.showSuccessDialog(this, "Success", content);
                Toast.makeText(this,"Berhasil register",Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Log.e("RegisterActivity", "Error showing dialog", e);
            }
        }
    }