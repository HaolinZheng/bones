package com.example.bones;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PersonajesViewModel extends AndroidViewModel {

    PersonajeList PersonajeRepositorio;
    static MutableLiveData<Personaje> personajeSeleccionado = new MutableLiveData<>();
    MutableLiveData<List<Personaje>> listElementosMutableLiveData = new MutableLiveData<>();
    public PersonajesViewModel(@NonNull Application application) {
        super(application);

        PersonajeRepositorio = new PersonajeList();

        listElementosMutableLiveData.setValue(PersonajeRepositorio.obtener());
    }

    MutableLiveData<List<Personaje>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Personaje elemento){
        PersonajeRepositorio.insertar(elemento, new PersonajeList.Callback() {
            @Override
            public void cuandoFinalice(List<Personaje> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(Personaje elemento){
        PersonajeRepositorio.eliminar(elemento, new PersonajeList.Callback() {
            @Override
            public void cuandoFinalice(List<Personaje> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }
    void actualizar(Personaje elemento, int votacion){
        PersonajeRepositorio.actualizar(elemento, votacion, new PersonajeList.Callback() {
            @Override
            public void cuandoFinalice(List<Personaje> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }
    void seleccionar(Personaje elemento){
        personajeSeleccionado.setValue(elemento);
    }

    static MutableLiveData<Personaje> seleccionado(){
        return personajeSeleccionado;
    }
}