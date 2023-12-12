package com.example.bones;
import java.util.ArrayList;
import java.util.List;

public class PersonajeList {

    List<Personaje> elementos = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Personaje> elementos);
    }

    PersonajeList(){
        elementos.add(new Personaje("Friston-3", "Defender","Normal / Protector", "Physical", 1, 1152, 198, 235, 3, 0, 3, 200, 1.2f));
        elementos.add(new Personaje("Muelsyse", "Vanguard","Summoner / Tactician", "Physical", 6, 1813, 497, 117, 15, 0, 1, 70, 1f));
        elementos.add(new Personaje("Ho'olheyak", "Caster","ST / Core Caster", "Arts", 6, 1770, 633, 130, 21, 20, 1, 70, 1.6f));
        elementos.add(new Personaje("Melanite", "Sniper","Close Range / Heavyshooter", "Physical", 5, 1664, 792, 210, 19, 0, 1, 70, 1.6f));
        elementos.add(new Personaje("Silence the Paradigmatic", "Supporter","Buffer / Abjurer", "Arts",6, 1927, 467, 184, 15, 25, 1, 80, 1.6f));
        elementos.add(new Personaje("Ines", "Vanguard","Agent", "Physical", 6, 2121, 589, 281, 11, 0, 1, 35, 1f));
    }

    List<Personaje> obtener() {
        return elementos;
    }

    void insertar(Personaje personaje, Callback callback){
        elementos.add(personaje);
        callback.cuandoFinalice(elementos);
    }

    void eliminar(Personaje personaje, Callback callback) {
        elementos.remove(personaje);
        callback.cuandoFinalice(elementos);
    }

    void actualizar(Personaje elemento, int valoracion, Callback callback) {
        elemento.votacion = valoracion;
        callback.cuandoFinalice(elementos);
    }
}