package com.example.ifood.model;

import com.example.ifood.helper.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class Produto {

    private String idUsuario;
    private String idProduto;
    private String nome;
    private String descricao;
    private Double preco;


    public Produto() {

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebase();
        DatabaseReference produtoRef = firebase
                .child("produtos");
        setIdProduto( produtoRef.push().getKey() );

    }


    public void salvar(){

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebase();
        DatabaseReference produtoRef = firebase
                .child("produtos")
                .child(getIdUsuario())
                .child( getIdProduto());
        produtoRef.setValue( this );


    }

    public void remover(){

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebase();
        DatabaseReference produtoRef = firebase
                .child("produtos")
                .child( getIdUsuario() )
                .child( getIdProduto() );
        produtoRef.removeValue();


    }


    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
