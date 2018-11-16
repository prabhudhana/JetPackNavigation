package com.example.jetpacknavigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + getArguments().getBoolean("test_boolean"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + FirstFragmentArgs.fromBundle(getArguments()).getTestString(), Toast.LENGTH_SHORT).show();

        Button button = view.findViewById(R.id.button_frag2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                navController.navigateUp();

                navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
                    @Override
                    public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                        Log.d("TAG", destination.getLabel() + " ");
                    }
                });
            }
        });
    }
}
