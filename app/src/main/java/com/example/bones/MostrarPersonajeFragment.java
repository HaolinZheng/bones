package com.example.bones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bones.databinding.FragmentMostrarPersonajeBinding;
import com.example.bones.databinding.ViewholderPersonajeBinding;

public class MostrarPersonajeFragment extends Fragment {
    private FragmentMostrarPersonajeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentMostrarPersonajeBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PersonajesViewModel personajesViewModel = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);
        personajesViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Personaje>() {
            @Override
            public void onChanged(Personaje elemento) {
                binding.nombre.setText(elemento.nombre);
                binding.class1.setText(elemento.class1);
                binding.class2.setText(elemento.class2);
                binding.damage.setText(elemento.damage);
                binding.calidad.setText(elemento.calidad + " Estrellas");
                binding.hp.setText("hp " + elemento.hp);
                binding.atk.setText("atk " + elemento.atk);
                binding.def.setText("def " + elemento.def);
                binding.res.setText("res " + elemento.res);
                binding.cost.setText("cost " + elemento.cost);
                binding.block.setText("block " + elemento.block);
                binding.redeploy.setText("redeploy " + elemento.redeploy);
                binding.interval.setText("interval " + elemento.interval + "s");
            }
        });
    }
}