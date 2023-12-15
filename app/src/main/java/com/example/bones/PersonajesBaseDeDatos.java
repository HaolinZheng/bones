package com.example.bones;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;
import java.util.List;

@Database(entities = {Personaje.class}, version = 1, exportSchema = false)
public abstract class PersonajesBaseDeDatos extends RoomDatabase {

    private static volatile PersonajesBaseDeDatos INSTANCIA;

    static PersonajesBaseDeDatos obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (PersonajesBaseDeDatos.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                                    PersonajesBaseDeDatos.class, "elementos.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
    public abstract PersonajesDao obtenerPersonajesDao();
    @Dao
    interface PersonajesDao {
        @Query("SELECT * FROM Personaje")
        LiveData<List<Personaje>> obtener();

        @Insert
        void insertar(Personaje elemento);

        @Update
        void actualizar(Personaje elemento);

        @Delete
        void eliminar(Personaje elemento);
    }

}