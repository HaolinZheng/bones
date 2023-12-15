package com.example.bones;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PersonajesViewModel extends AndroidViewModel {

    PersonajeList PersonajeRepositorio;
    MutableLiveData<Personaje> personajeSeleccionado = new MutableLiveData<>();
    public PersonajesViewModel(@NonNull Application application) {
        super(application);

        PersonajeRepositorio = new PersonajeList(application);
    }

    LiveData<List<Personaje>> obtener(){
        return PersonajeList.obtener();
    }

    void insertar(Personaje elemento){
        PersonajeList.insertar(elemento);
    }

    void eliminar(Personaje elemento){
        PersonajeList.eliminar(elemento);
    }

    void actualizar(Personaje elemento, float valoracion){
        PersonajeList.actualizar(elemento, valoracion);
    }
    void seleccionar(Personaje elemento){
        personajeSeleccionado.setValue(elemento);
    }

    MutableLiveData<Personaje> seleccionado(){
        return personajeSeleccionado;
    }
}