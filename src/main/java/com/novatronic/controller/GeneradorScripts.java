/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.controller;

import com.novatronic.bean.ListaBanco;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.Excel;
import util.Fichero;
import util.Formateador;


/**
 *
 * @author amartinez
 */
public class GeneradorScripts {
    
    
    public void generarScript(ListaBanco listaBanco, String strFecTerm, String rutaExcel){
        
        //Variables que reciben los valores ingresados por el usuario
        String codigoAdquiriente = listaBanco.getCodigoAdquiriente();
        String codigoProcesador = listaBanco.getCodigoProcesador();
        String codigoAutorizador = listaBanco.getCodigoAutorizador();
        int codigoLista = Integer.parseInt( listaBanco.getCodigoLista() );
        String strFecIni = listaBanco.getFechaInicio();
        String indiceEstado = listaBanco.getIndiceEstado();
        
        //Conversión de las fechas de String a tipo Date
        Date fechaInicio = Formateador.stringToDate(strFecIni);
        Date fechaTermino= Formateador.stringToDate(strFecTerm);
        
        //Variable temporal que irá incrementandose en 7 días
        Date fechaTemp = fechaInicio;
        
        //ArrayList que almacenará los códigos de lista incrementables
        ArrayList<String> arrayCodigoListas = new ArrayList<String>();
        
        System.out.println("Fecha de inicio: "+fechaInicio);
        System.out.println("Fecha de termino: "+fechaTermino);
        
        String cadenaInicio = "insert into tp_banco_lista (cod_adqui, cod_proc,"+
                              " cod_autoriza, cod_lista, fec_inicio, ind_estado) values (";
        String cadenaFin = ");";
        
        //Cadena que almacenará todo el script
        String script = "";
        
        //Mientras la fecha temporal no sobrepase la fecha de término
        while( !Formateador.fechaMayor(fechaTemp, fechaTermino) ){
            
            //Conversión a String de la fecha temporal para su registro en la cadena
            String strFecha = Formateador.dateToString(fechaTemp);
            //Guarado del codigo de Lista actual
            arrayCodigoListas.add(0+""+codigoLista);
            
            script = script + cadenaInicio+
                               "'"+codigoAdquiriente+"','"+codigoProcesador+"',"+
                               "'"+codigoAutorizador+"','0"+codigoLista+"',"+
                               "'"+strFecha+"',"+indiceEstado+
                               cadenaFin+"\n";
            
            /*
            System.out.println(cadenaInicio+
                               "'"+codigoAdquiriente+"','"+codigoProcesador+"',"+
                               "'"+codigoAutorizador+"','0"+codigoLista+"',"+
                               "'"+strFecha+"',"+indiceEstado+
                               cadenaFin);*/                  
            
            //Aumento en 7 dias de la fecha temporal
            fechaTemp = Formateador.sumarSieteDias(fechaTemp);
            
            //Aumento de 1 al codigo de lista
            codigoLista++;
        }
        
  
        //System.out.println("Script:\n"+script);
        
        script = script + Excel.obtenerCadena( arrayCodigoListas, rutaExcel);
        
        Fichero.crearArchivo(script);
        
        
    }
    
    
    
    
}
