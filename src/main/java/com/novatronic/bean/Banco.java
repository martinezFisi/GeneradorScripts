/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.bean;

/**
 *
 * @author amartinez
 */
public class Banco {
    private String bancoId;
    private String bancoEtiqueta;
    private String bancoNombre;
    private String bancoPerfil;
    private String bancoDominio;

    public Banco(){
    }
    
    public Banco(String bId, String bLab, String bName, String bProf, 
                String bDom){
        setBancoId(bId);
        setBancoEtiqueta(bLab);
        setBancoNombre(bName);
        setBancoPerfil(bProf);
        setBancoDominio(bDom);
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
