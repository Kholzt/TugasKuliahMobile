package com.example.tugaskuliahmobile.libs;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

public class Dialog {

    public static void showSuccessDialog(Context context, String title, String message) {
        createDialog(context, title, message, android.R.drawable.ic_dialog_info, "OK", null, null, null);
    }

    public static void showConfirmDialog(Context context, String title, String message, DialogInterface.OnClickListener onConfirm) {
        createDialog(context, title, message, android.R.drawable.ic_dialog_alert, "Confirm", onConfirm, "Cancel", null);
    }

    public static void showInfoDialog(Context context, String title, String message) {
        createDialog(context, title, message, android.R.drawable.ic_dialog_info, "OK", null, null, null);
    }

    public static void showDangerDialog(Context context, String title, String message, DialogInterface.OnClickListener onConfirm) {
        createDialog(context, title, message, android.R.drawable.ic_delete, "Delete", onConfirm, "Cancel", null);
    }

    private static void createDialog(Context context, String title, String message, int icon,
                                     String positiveText, DialogInterface.OnClickListener positiveListener,
                                     String negativeText, DialogInterface.OnClickListener negativeListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
               .setMessage(message)
               .setIcon(icon)
               .setPositiveButton(positiveText, positiveListener)
               .setNegativeButton(negativeText, negativeListener);
        builder.create().show();

    }
}
