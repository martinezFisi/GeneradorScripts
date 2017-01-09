/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author amartinez
 */
public class Fichero {
    
    private static final String NOMBRE_DIRECTORIO = "AppGeneradorScripts_Archivos";
    
    public static void crearArchivo( String cadena ){
        
        try{
            BufferedWriter bw = new BufferedWriter( new FileWriter( crearCarpeta()+"/"+getNombreArchivo() ) );
            bw.write(cadena);
            bw.close();
            
            JOptionPane.showMessageDialog(null, "Archivo creado");
            System.out.println("\nArchivo creado");
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
        
    }
    
    public static String crearCarpeta(){
        
        String ruta = "D:\\"+NOMBRE_DIRECTORIO;
        
        try{
            File directorio = new File(ruta);
            directorio.mkdirs();
            System.out.println("\nDirectorio creado");
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        
        return ruta;
        
    }
    
    public static String getNombreArchivo(){
        String nombreArchivo = "";
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date() );
        
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH);
        int anio= calendar.get(Calendar.YEAR);
        int hora= calendar.get(Calendar.HOUR_OF_DAY);
        int minuto= calendar.get(Calendar.MINUTE);
        int segundo= calendar.get(Calendar.SECOND);
        
        JOptionPane.showMessageDialog(null, ""+dia+"/"+mes+"/"+anio+" "+hora+":"+minuto+":"+segundo);
        nombreArchivo = "script"+dia+mes+anio+hora+minuto+segundo+".txt";
        
        return nombreArchivo;
    }
    
}
