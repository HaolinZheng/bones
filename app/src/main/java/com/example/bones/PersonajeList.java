package com.example.bones;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class PersonajeList {
    interface Callback {
        void cuandoFinalice(List<Personaje> elementos);
    }
    static PersonajesBaseDeDatos.PersonajesDao personajesDao;
    PersonajeList(Application application){
        personajesDao = PersonajesBaseDeDatos.obtenerInstancia(application).obtenerPersonajesDao();
    }
    static LiveData<List<Personaje>> obtener(){
        return personajesDao.obtener();
    }
    static Executor executor = Executors.newSingleThreadExecutor();
    static void insertar(Personaje elemento){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personajesDao.insertar(elemento);
            }
        });
    }

    static void eliminar(Personaje elemento) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personajesDao.eliminar(elemento);
            }
        });
    }

    public static void actualizar(Personaje elemento, float valoracion) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personajesDao.actualizar(elemento);
            }
        });
    }

}