package com.example.bones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.bones.databinding.FragmentNuevoPersonajeBinding;

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

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombre.getText().toString();
                String class1 = binding.class1.getText().toString();
                String class2 = binding.class2.getText().toString();
                String damage = binding.damage.getText().toString();
                int calidad = Integer.parseInt(binding.calidad.getText().toString());
                int hp = Integer.parseInt(binding.hp.getText().toString());
                int atk = Integer.parseInt(binding.atk.getText().toString());
                int def = Integer.parseInt(binding.def.getText().toString());
                int cost = Integer.parseInt(binding.cost.getText().toString());
                int res = Integer.parseInt(binding.res.getText().toString());
                int block = Integer.parseInt(binding.block.getText().toString());
                int redeploy = Integer.parseInt(binding.redeploy.getText().toString());
                float interval = Float.parseFloat(binding.interval.getText().toString());

                personajesViewModel.insertar(new Personaje(nombre, class1,class2,damage,calidad,hp,atk,def,cost,res,block,redeploy,interval));

                navController.popBackStack();
            }
        });
    }

}