package com.example.tugaskuliahmobile.libs;

import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;

public class Form {

    public  static String getInputVal(EditText input) {
        return input.getText().toString();
    }
    public static String getSpinnerVal(Spinner input) {
        return input.getSelectedItem().toString();
    }

}
