package com.example.bones;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bones.databinding.FragmentOperatorBinding;
import com.example.bones.databinding.ViewholderPersonajeBinding;

import java.util.List;

public class operator extends Fragment {

    private FragmentOperatorBinding binding;
    private PersonajesViewModel personajesViewModel;
    private NavController navController;

    class PersonajeViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderPersonajeBinding binding;

        public PersonajeViewHolder(ViewholderPersonajeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

        List<Personaje> personajes;

        @NonNull
        @Override
        public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajeViewHolder(ViewholderPersonajeBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {

            Personaje personaje = personajes.get(position);

            holder.binding.nombre.setText(personaje.nombre);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    personajesViewModel.seleccionar(personaje);
                    navController.navigate(R.id.action_mostrarPersonajeFragment);
                }
            });
        }
        @Override
        public int getItemCount() {
            return personajes != null ? personajes.size() : 0;
        }

        public void establecerLista(List<Personaje> personajes){
            this.personajes = personajes;
            notifyDataSetChanged();
        }
        public Personaje obtenerElemento(int posicion){
            return personajes.get(posicion);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentOperatorBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajesViewModel = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);
        navController = Navigation.findNavController(view);

        binding.irANuevoElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nuevoPersonajeFragment);
            }
        });

        PersonajesAdapter personajesAdapter = new PersonajesAdapter();

        binding.recyclerView.setAdapter(personajesAdapter);

        personajesViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Personaje>>() {
            @Override
            public void onChanged(List<Personaje> personajes) {
                personajesAdapter.establecerLista(personajes);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Personaje elemento = personajesAdapter.obtenerElemento(posicion);
                personajesViewModel.eliminar(elemento);
            }
        }).attachToRecyclerView(binding.recyclerView);
    }
}