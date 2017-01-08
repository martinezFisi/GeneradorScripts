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

/**
 *
 * @author amartinez
 */
public class Fichero {
    
    private static final String NOMBRE_DIRECTORIO = "Archivos";
    
    public static void crearArchivo( String cadena ){
        
        crearCarpeta();
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_DIRECTORIO+"/"+"script.txt"));
            bw.write(cadena);
            bw.close();
            System.out.println("\nArchivo creado");
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
        
    }
    
    public static void crearCarpeta(){
        
        try{
            File directorio = new File(NOMBRE_DIRECTORIO);
            directorio.mkdirs();
            System.out.println("\nDirectorio creado");
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        
    }
    
}
