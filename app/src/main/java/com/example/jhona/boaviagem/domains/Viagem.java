package com.example.jhona.boaviagem.domains;

/**
 * Created by jhona on 11/11/2016.
 */

public class Viagem {
    private String destino;
    private String data;
    private String valor;
    private int foto;


    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
