package com.novatronic.generadorscripts;

import com.novatronic.bean.ListaBanco;
import com.novatronic.controller.GeneradorScripts;
import java.text.SimpleDateFormat;

import java.util.Date;
import util.Excel;

/**
 * Hello world!
 *
 */
public class App 
{
    
    
    public static void main( String[] args )
    {
        
        System.out.println("Hola maven");
        ListaBanco listaBanco = new ListaBanco("999978","000001","900002","010049","01/01/2018","1");
        new GeneradorScripts().generarScript( listaBanco , "01/01/2024");
        
        System.out.println("");
        
        //Excel.leerExcel("C:\\OrdenEmisores.xlsx");
        
    }
}
