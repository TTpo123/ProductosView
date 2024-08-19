package com.equipo3.productosview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.equipo3.productosview.CustomAdepter;
import com.equipo3.productosview.CustomModel;
import com.equipo3.productosview.databinding.FragmentHomeBinding;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private CustomAdepter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupRecyclerView();

        homeViewModel.getCustomModelLiveData().observe(getViewLifecycleOwner(), customModels -> {
            // Update RecyclerView with new data
            adapter.filterList(new ArrayList<>(customModels));
        });

        return root;
    }

    private void setupRecyclerView() {
        adapter = new CustomAdepter(getContext(), new ArrayList<>());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
