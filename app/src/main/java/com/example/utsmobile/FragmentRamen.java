package com.example.utsmobile;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentRamen extends Fragment {
    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout terlebih dahulu
        View view = inflater.inflate(R.layout.fragment_ramen, container, false);

        // Inisialisasi RecyclerView
        rvMakanan = view.findViewById(R.id.rv_makanan);
        rvMakanan.setHasFixedSize(true);

        if(list.isEmpty()) {
            list.addAll(getListMakanan());
        }
        // Tampilkan data pada RecyclerView
        showRecyclerList();

        return view;
    }

    public ArrayList<Makanan> getListMakanan() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Makanan> lisMakanan = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Makanan makanan = new Makanan();
            makanan.setName(dataName[i]);
            makanan.setDescription(dataDescription[i]);
            makanan.setPhoto(dataPhoto.getResourceId(i, -1));
            lisMakanan.add(makanan);
        }
        dataPhoto.recycle(); // Pastikan resource TypedArray direlease
        return lisMakanan;
    }

    private void showRecyclerList() {
        // Gunakan requireContext() untuk mendapatkan Context
        rvMakanan.setLayoutManager(new LinearLayoutManager(requireContext()));
        ListMakananAdapter listMakananAdapter = new ListMakananAdapter(list);
        rvMakanan.setAdapter(listMakananAdapter);
    }
}
