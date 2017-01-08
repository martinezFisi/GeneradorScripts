/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.novatronic.bean.Banco;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author amartinez
 */
public class Excel {
    
    public static ArrayList< ArrayList<String> > leerExcel(String ruta){
        
        //Matriz de arraylist
        ArrayList< ArrayList<String> > matriz = new ArrayList< ArrayList<String> >();
             
        try{
            //Lectura del archivo
            FileInputStream excel = new FileInputStream( new File(ruta) );
            //Objeto que almacenará el libro del archivo excel
            XSSFWorkbook workbook = new XSSFWorkbook(excel);
            //Objeto que almacenará la primera pestaña del libro
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //Contador de filas
            int cuentaFilas = 0;
            //Contador de columnas
            int cuentaColumnas = 0;
            
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            
            String cadena = "";
            
            //For que recorre las filas
            for( Row row : sheet ){
                
                //ArrayList de la fila actual
                ArrayList<String> fila = new ArrayList<String>();
                
                cuentaFilas++;
                
                //Salto de fila si aún no se llega a la novena
                if( cuentaFilas < 9 ){
                    System.out.println("Fila saltada: "+cuentaFilas);
                    continue;
                }
                
                //For que recorre las celdas(columnas)
                for( int i = 0; i < row.getLastCellNum(); i++ ){
                    Cell cell = row.getCell( i, Row.CREATE_NULL_AS_BLANK);
                    
                    //Salto de la primera columna
                    if( i < 61 ){
                        continue;
                    }
                    
                    //Identificación del tipo de dato de la celda
                    switch( cell.getCellType() ){
                          case Cell.CELL_TYPE_NUMERIC:
                                    if( DateUtil.isCellDateFormatted(cell) )
                                        cadena = cadena + cell.getDateCellValue() + ", ";
                                    else
                                        cadena = cadena + cell.getNumericCellValue() + ", ";
                              break;
                          
                          case Cell.CELL_TYPE_STRING:
                                    cadena = cadena + cell.getStringCellValue() + ", ";
                                    fila.add( cell.getStringCellValue() );
                              break;
                              
                          case Cell.CELL_TYPE_BOOLEAN:
                                    cadena = cadena + cell.getBooleanCellValue() + ", ";
                              break;    
                          
                          case Cell.CELL_TYPE_BLANK:
                                    cadena = cadena + "vacío, ";
                              break;
                          
                          case Cell.CELL_TYPE_FORMULA:
                                    
                                    //Identificación del tipo de dato que contiene la formula
                                    switch( evaluator.evaluateFormulaCell( cell ) ){
                                          case Cell.CELL_TYPE_NUMERIC:
                                                    if( DateUtil.isCellDateFormatted(cell) )
                                                        cadena = cadena + cell.getDateCellValue() + ", ";
                                                    else
                                                        cadena = cadena + cell.getNumericCellValue() + ", ";
                                              break;

                                          case Cell.CELL_TYPE_STRING:
                                                    cadena = cadena + cell.getStringCellValue() + ", ";
                                                    fila.add( cell.getStringCellValue() );
                                              break;

                                          case Cell.CELL_TYPE_BOOLEAN:
                                                    cadena = cadena + cell.getBooleanCellValue() + ", ";
                                              break;  

                                          case Cell.CELL_TYPE_FORMULA:
                                                    cadena = cadena + cell.getCellFormula() + ", ";
                                              break;
                                    }
                              
                              break;
                    }
                    
                    
                }
                
                //Guardado del arrayList de la fila 
                matriz.add(fila);
                
                //Salto de linea a la cadena
                cadena = cadena + "\n";
            }

            //System.out.println("Excel: \n"+cadena);
            Fichero.crearArchivo(cadena);
            workbook.close();
            
        }catch(Exception e){
            System.out.println( "Error: "+e.toString() );
        }
        
        return matriz;
        
    }
    
    
    public static String obtenerCadena(ArrayList<String> arrayCodList, String ruta){
        
        //Matriz aue contiene todas las listas de bancos
        ArrayList< ArrayList<String> > matrizListaBancos = leerExcel( ruta );
        //Array que contiene todas los códigos de lista
        ArrayList< String > arrayCodigoListas = arrayCodList;
        
        String cadenaInicio = "insert into tp_banco (cod_lista, idx_banco, "+
                              "bank_id, bank_label, bank_name, bank_profile, bank_dominio) values (";
        String cadenaFin = ");";
        
        String script = "";
        
        System.out.println("");
        System.out.println("arrayCodigoListas.size(): "+arrayCodigoListas.size());
        System.out.println("matrizListaBancos.get(0).size(): "+matrizListaBancos.get(0).size() );
        System.out.println("matrizListaBancos.size(): "+matrizListaBancos.size());
        
        for( int j = 0; j < matrizListaBancos.get(0).size(); j++ ){
            
            System.out.println("\nBancos por columna: ");
            
            for( int i = 0; i < matrizListaBancos.size(); i++ ){
                String bancoNombre = matrizListaBancos.get(i).get(j);
                System.out.print( bancoNombre + ", ");
                Banco bancoActual = getBanco(bancoNombre);
                script = script + cadenaInicio + "'"+arrayCodigoListas.get(j)+"', " 
                         +  (i+1) +", " + "'"+bancoActual.getBancoId()+"', "  
                         + "'"+bancoActual.getBancoEtiqueta()+"', " 
                         + "'"+bancoActual.getBancoNombre()+"', " 
                         + "'"+bancoActual.getBancoPerfil()+"', " 
                         + "'"+bancoActual.getBancoDominio()+"' " 
                         + cadenaFin + "\n";
                        
            }
            
        }
        
        
        
        return script;
    }
    
    
    public static Banco getBanco( String nombreBanco ){
        
        Banco banco1 = new Banco( "XXXXXX", "Caja Arequipa", "Caja Arequipa", "CAREQUIPA USUARIO FINAL", "0104CAREQUIPA");
        Banco banco2 = new Banco( "XXXXXX", "Caja Cusco", "Caja Cusco", "CCUSCO USUARIO FINAL", "CCUSCO");
        Banco banco3 = new Banco( "XXXXXX", "Caja Ica", "Caja Ica", "CICA USUARIO FINAL", "0108CICA");
        Banco banco4 = new Banco( "XXXXXX", "Caja Piura", "Caja Piura", "CPIURA USUARIO FINAL", "0103CPIURA");
        Banco banco5 = new Banco( "XXXXXX", "Caja Prymera", "Caja Prymera", "CRPRYMERA USUARIO FINAL", "0170CRPRYMERA");
        Banco banco6 = new Banco( "XXXXXX", "Caja Sullana", "Caja Sullana", "CSULLANA USUARIO FINAL", "CSULLANA");
        Banco banco7 = new Banco( "XXXXXX", "Caja Trujillo", "Caja Trujillo", "CTRUJILLO USUARIO FINAL", "CTRUJILLO");
        Banco banco8 = new Banco( "XXXXXX", "Compartamos", "Compartamos", "FCOMPARTAMOS USUARIO FINAL", "FCOMPARTAMOS");
        Banco banco9 = new Banco( "XXXXXX", "Credinka", "Credinka", "CREDINKA USUARIO FINAL", "CREDINKA");
        Banco banco10 = new Banco( "XXXXXX", "Crediscotia", "Crediscotia", "CSF USUARIO FINAL", "CSF");
        Banco banco11 = new Banco( "XXXXXX", "Edpyme Acceso", "Edpyme Acceso", "EDPACCESO USUARIO FINAL", "0236EDPACCESO");
        Banco banco12 = new Banco( "XXXXXX", "Edpyme Alternativa", "Edpyme Alternativa", "EDPALTERNATIVA USUARIO FINAL", "0238EDPALTERNATIVA");
        Banco banco13 = new Banco( "XXXXXX", "Edpyme Solidaridad", "Edpyme Solidaridad", "EDPSOLIDARIDAD USUARIO FINAL", "0234EDPSOLIDARIDAD");
        Banco banco14 = new Banco( "XXXXXX", "GMONEY", "GMONEY", "GMONEY USUARIO FINAL", "GMONEY");
        Banco banco15 = new Banco( "XXXXXX", "Interbank", "Interbank", "INTERBANK USUARIO FINAL", "INTERBANK");
        Banco banco16 = new Banco( "XXXXXX", "MIBANCO", "MIBANCO", "MIBANCO USUARIO FINAL", "0123MIBANCO");
        Banco banco17 = new Banco( "XXXXXX", "QAPAQ", "QAPAQ", "FQAPAQ USUARIO FINAL", "0144FQAPAQ");
        Banco banco18 = new Banco( "XXXXXX", "Banco Financiero", "Banco Financiero", "BFINANCIERO USUARIO FINAL", "BFINANCIERO");
        Banco banco19 = new Banco( "XXXXXX", "Banco GNB", "Banco GNB", "GNB USUARIO FINAL", "GNB");
        Banco banco20 = new Banco( "XXXXXX", "BBVA Continental", "BBVA Continental", "BBVA USUARIO FINAL", "BBVA");
        Banco banco21 = new Banco( "XXXXXX", "BCP", "BCP", "BCP USUARIO FINAL", "BCP");

        ArrayList<Banco> bancos = new ArrayList<Banco>();
        bancos.add(banco1);
        bancos.add(banco2);
        bancos.add(banco3);
        bancos.add(banco4);
        bancos.add(banco5);
        bancos.add(banco6);
        bancos.add(banco7);
        bancos.add(banco8);
        bancos.add(banco9);
        bancos.add(banco10);
        bancos.add(banco11);
        bancos.add(banco12);
        bancos.add(banco13);
        bancos.add(banco14);
        bancos.add(banco15);
        bancos.add(banco16);
        bancos.add(banco17);
        bancos.add(banco18);
        bancos.add(banco19);
        bancos.add(banco20);
        bancos.add(banco21);
        
        for( Banco b : bancos ){
            if( b.getBancoEtiqueta().equals( nombreBanco ) )
                return b;
        }
        
        
        return null;
    }
    
    
    
}
