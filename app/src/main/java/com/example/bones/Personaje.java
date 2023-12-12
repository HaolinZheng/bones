package com.example.bones;

public class Personaje {
    String nombre, class1, class2, damage;
    int calidad, hp, atk, def, cost, res, block, redeploy, votacion;
    float interval;

    public Personaje(String nombre, String class1, String class2, String damage, int calidad, int hp, int atk, int def, int cost, int res, int block, int redeploy, float interval) {
        this.nombre = nombre;
        this.class1 = class1;
        this.class2 = class2;
        this.damage = damage;
        this.calidad = calidad;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.cost = cost;
        this.res = res;
        this.block = block;
        this.redeploy = redeploy;
        this.interval = interval;
    }
}
