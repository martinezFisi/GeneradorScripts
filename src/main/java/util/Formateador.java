/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amartinez
 */
public class Formateador {
    
    public static Date stringToDate(String strFecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            Logger.getLogger(Formateador.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return fecha;
    }
    
    public static String dateToString(Date fecha){
        DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = formateador.format(fecha);
        System.out.println("Fecha en string: "+strFecha);
	return strFecha;
    }
    
    public static Date sumarSieteDias(Date fecha){
        Calendar calendario = Calendar.getInstance();  
        calendario.setTime(fecha);
        calendario.add( Calendar.DAY_OF_MONTH, 7);
        fecha = calendario.getTime();
        System.out.println("Fecha Temporal: "+fecha);
        
        return fecha;
    }
    
    
    public static boolean fechaMayor(Date fecha1, Date fecha2){
        
        boolean resultado = false;
        
        if( fecha1.before(fecha2) ){
            System.out.println("\nMenor");
        }
        else{
            if( fecha1.after(fecha2) ){
                System.out.println("\nMayor");
                resultado = true;
            }
            else{
                System.out.println("\nIguales");
            }
        }
        
        return resultado;
        
    }
    
    
    
    
}
