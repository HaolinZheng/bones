package com.example.bones;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bones.databinding.FragmentNuevoPersonajeBinding;
import com.google.android.material.snackbar.Snackbar;

public class nuevoPersonajeFragment extends Fragment {
    private FragmentNuevoPersonajeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentNuevoPersonajeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        PersonajesViewModel personajesViewModel = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);
        NavController navController = Navigation.findNavController(view);


        binding.crear.setOnClickListener(v -> {
            String nombre = null;
            String class1 = null;
            String class2 = null;
            String damage = null;
            int calidad = 0;
            int hp = 0;
            int atk = 0;
            int def = 0;
            int cost = 0;
            int res = 0;
            int block = 0;
            int redeploy = 0;
            float interval = 0;
            if (binding.nombre.getText().toString().equals("") || binding.class1.getText().toString().equals("") || binding.class2.getText().toString().equals("") || binding.damage.getText().toString().equals("") || binding.calidad.getText().toString().equals("") || binding.hp.getText().toString().equals("") || binding.atk.getText().toString().equals("") || binding.def.getText().toString().equals("") || binding.cost.getText().toString().equals("") || binding.res.getText().toString().equals("") || binding.block.getText().toString().equals("") || binding.redeploy.getText().toString().equals("") || binding.interval.getText().toString().equals("")) {
                binding.error.setVisibility(View.VISIBLE);
            }
            else {
                nombre = binding.nombre.getText().toString();
                class1 = binding.class1.getText().toString();
                class2 = binding.class2.getText().toString();
                damage = binding.damage.getText().toString();
                calidad = Integer.parseInt(binding.calidad.getText().toString());
                hp = Integer.parseInt(binding.hp.getText().toString());
                atk = Integer.parseInt(binding.atk.getText().toString());
                def = Integer.parseInt(binding.def.getText().toString());
                cost = Integer.parseInt(binding.cost.getText().toString());
                res = Integer.parseInt(binding.res.getText().toString());
                block = Integer.parseInt(binding.block.getText().toString());
                redeploy = Integer.parseInt(binding.redeploy.getText().toString());
                interval = Float.parseFloat(binding.interval.getText().toString());
                personajesViewModel.insertar(new Personaje(nombre, class1, class2, damage, calidad, hp, atk, def, cost, res, block, redeploy, interval));
                navController.popBackStack();
            }
        });
    }

}