package com.example.appexamen;

public class Rectangulo {
    private float altura;
    private float base;

    public Rectangulo() {
        this.setAltura(altura);
        this.setBase(base);
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float calcularArea(){
        return (this.base * this.altura);
    }

    public float calcularPerimetro(){
        return 2*(this.base + this.altura);
    }
}


