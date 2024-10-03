package com.example.tugaskuliahmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.MyViewHolder> {

    // Daftar data yang berisi array String dengan format {nama, telepon}
    private List<String[]> items;

    // Konstruktor adapter yang menerima data berupa List<String[]>
    public KontakAdapter(List<String[]> items) {
        this.items = items;
    }

    // ViewHolder digunakan untuk menyimpan referensi view dalam satu item di RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;  // TextView untuk menampilkan nama
        public TextView phoneTextView; // TextView untuk menampilkan nomor telepon

        // Konstruktor ViewHolder, mengikat itemView dengan komponen UI dari item layout
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Menghubungkan TextView dengan ID-nya di layout XML
            nameTextView = itemView.findViewById(R.id.name);
            phoneTextView = itemView.findViewById(R.id.phone);
        }
    }

    // Method ini digunakan untuk membuat dan menginisialisasi ViewHolder
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Meng-inflate layout XML untuk item dalam RecyclerView (kontak_item.xml)
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kontak_item, parent, false);
        return new MyViewHolder(itemView); // Mengembalikan ViewHolder baru
    }

    // Method ini menghubungkan data ke dalam ViewHolder (mengisi TextView dengan data yang sesuai)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Mengambil data kontak pada posisi saat ini
        String[] kontak = items.get(position); // kontak[0] adalah nama, kontak[1] adalah telepon

        // Mengisi TextView dengan data dari array String {nama, telepon}
        holder.nameTextView.setText(kontak[0]); // Menampilkan nama
        holder.phoneTextView.setText(kontak[1]); // Menampilkan nomor telepon
    }

    // Method ini digunakan untuk menentukan jumlah item yang ada dalam RecyclerView
    @Override
    public int getItemCount() {
        // Mengembalikan jumlah total item yang ada dalam list
        return items.size();
    }
}
