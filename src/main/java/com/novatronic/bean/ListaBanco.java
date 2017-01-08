/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.bean;

/**
 *
 * @author amartinez
 */
public class ListaBanco {
    private String codigoAdquiriente;
    private String codigoProcesador;
    private String codigoAutorizador;
    private String codigoLista;
    private String fechaInicio;
    private String indiceEstado;

    public ListaBanco(){
    }
    
    public ListaBanco( String codAdq, String codProc, String codAut, 
                       String codLis, String fecIni, String indEst  ){
        setCodigoAdquiriente(codAdq);
        setCodigoProcesador(codProc);
        setCodigoAutorizador(codAut);
        setCodigoLista(codLis);
        setFechaInicio(fecIni);
        setIndiceEstado(indEst);
    }
    
    /**
     * @return the codigoAdquiriente
     */
    public String getCodigoAdquiriente() {
        return codigoAdquiriente;
    }

    /**
     * @param codigoAdquiriente the codigoAdquiriente to set
     */
    public void setCodigoAdquiriente(String codigoAdquiriente) {
        this.codigoAdquiriente = codigoAdquiriente;
    }

    /**
     * @return the codigoProcesador
     */
    public String getCodigoProcesador() {
        return codigoProcesador;
    }

    /**
     * @param codigoProcesador the codigoProcesador to set
     */
    public void setCodigoProcesador(String codigoProcesador) {
        this.codigoProcesador = codigoProcesador;
    }

    /**
     * @return the codigoAutorizador
     */
    public String getCodigoAutorizador() {
        return codigoAutorizador;
    }

    /**
     * @param codigoAutorizador the codigoAutorizador to set
     */
    public void setCodigoAutorizador(String codigoAutorizador) {
        this.codigoAutorizador = codigoAutorizador;
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
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the indiceEstado
     */
    public String getIndiceEstado() {
        return indiceEstado;
    }

    /**
     * @param indiceEstado the indiceEstado to set
     */
    public void setIndiceEstado(String indiceEstado) {
        this.indiceEstado = indiceEstado;
    }
}
