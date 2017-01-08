/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.novatronic.bean;

/**
 *
 * @author amartinez
 */
public class DetalleListaBanco {
    private String codigoLista;
    private int posicionLista; 
    private String bancoId;
    private String bancoEtiqueta;
    private String bancoNombre;
    private String bancoPerfil;
    private String bancoDominio;

    public DetalleListaBanco(){}
    
    public DetalleListaBanco(String codList, int posList, String bId, 
                             String bEtiq, String bNom, String bPerf,
                             String bDom){
        setCodigoLista(codList);
        setPosicionLista(posList);
        setBancoId(bId);
        setBancoEtiqueta(bEtiq);
        setBancoNombre(bNom);
        setBancoPerfil(bPerf);
        setBancoDominio(bDom);
    }
    
    /**
     * @return the codigoLista
     */
    public String getCodigoLista() {
        return codigoLista;
    }

    /**
     * @param codigoLista the codigoLista to set
     */
    public void setCodigoLista(String codigoLista) {
        this.codigoLista = codigoLista;
    }

    /**
     * @return the posicionLista
     */
    public int getPosicionLista() {
        return posicionLista;
    }

    /**
     * @param posicionLista the posicionLista to set
     */
    public void setPosicionLista(int posicionLista) {
        this.posicionLista = posicionLista;
    }

    /**
     * @return the bancoId
     */
    public String getBancoId() {
        return bancoId;
    }

    /**
     * @param bancoId the bancoId to set
     */
    public void setBancoId(String bancoId) {
        this.bancoId = bancoId;
    }

    /**
     * @return the bancoEtiqueta
     */
    public String getBancoEtiqueta() {
        return bancoEtiqueta;
    }

    /**
     * @param bancoEtiqueta the bancoEtiqueta to set
     */
    public void setBancoEtiqueta(String bancoEtiqueta) {
        this.bancoEtiqueta = bancoEtiqueta;
    }

    /**
     * @return the bancoNombre
     */
    public String getBancoNombre() {
        return bancoNombre;
    }

    /**
     * @param bancoNombre the bancoNombre to set
     */
    public void setBancoNombre(String bancoNombre) {
        this.bancoNombre = bancoNombre;
    }

    /**
     * @return the bancoPerfil
     */
    public String getBancoPerfil() {
        return bancoPerfil;
    }

    /**
     * @param bancoPerfil the bancoPerfil to set
     */
    public void setBancoPerfil(String bancoPerfil) {
        this.bancoPerfil = bancoPerfil;
    }

    /**
     * @return the bancoDominio
     */
    public String getBancoDominio() {
        return bancoDominio;
    }

    /**
     * @param bancoDominio the bancoDominio to set
     */
    public void setBancoDominio(String bancoDominio) {
        this.bancoDominio = bancoDominio;
    }
}
