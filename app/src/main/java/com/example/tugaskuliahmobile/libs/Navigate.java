package com.example.tugaskuliahmobile.libs;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Navigate {
    public static void push(Context context, Class<? extends AppCompatActivity> nextClass) {
        Intent intent = new Intent(context, nextClass);
        context.startActivity(intent);
    }
}
