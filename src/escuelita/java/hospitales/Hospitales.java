package escuelita.java.hospitales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Hospitales {
	private static final String HOSPITALES_DATA_FILE="hospitales.csv";
	private static final String DELIMITER = ",";
	
	public static void main(String[] args) throws IOException {
		//int numOfLines=countLines(HOSPITALES_DATA_FILE) ;
		//System.out.println(numOfLines);
		
		String[] array1 = obtenerIds() ;
		System.out.println(Arrays.toString(array1));
		
		String[] array2 = datosPorId("4") ;
		System.out.println(Arrays.toString(array2));		
		
		String DatosStr = mostrarPorConsola();
		System.out.println(DatosStr);
	}
	
	public static String[] obtenerIds() throws IOException{
		// Retorna un array de strings con el id de los hospitales 
		int numOfLines=countLines(HOSPITALES_DATA_FILE) ;
	    String[] idsArr = new String[numOfLines];
	    BufferedReader fileReader = null;
        fileReader = new BufferedReader(new FileReader(HOSPITALES_DATA_FILE));
        String line = "";
        int counter = 0;
        while ((line = fileReader.readLine()) != null)
        {
            String[] tokens = line.split(DELIMITER);
            
            idsArr[counter] = tokens[0];
            counter++;
        }			
        fileReader.close();
		return idsArr;    
	}	
	
	
	public static void mostrarPorConsola(String[] args) {
		// TRetorna un String que enumera todos los campos del hospital
	}	
	
	public static String[]  datosPorId(String numOfId) throws IOException{
		//Retorna un array de strings con todos los datos del hospital
	    String[] datosPorIdArr = null;
	    BufferedReader fileReader = null;
        fileReader = new BufferedReader(new FileReader(HOSPITALES_DATA_FILE));
        String line = "";
        String[] lineaArr;
        while ((line = fileReader.readLine()) != null)
        {
        	lineaArr = line.split(DELIMITER);
        	if (numOfId.equals(lineaArr[0])) {
        		datosPorIdArr= lineaArr;
        	}
        }			
        fileReader.close();
		return datosPorIdArr;   
	}

	public static String mostrarPorConsola() throws IOException {
		//Retorna un String que enumera todos los campos del hospital
		
	    String DatosStr = "";
	    BufferedReader fileReader = null;
        fileReader = new BufferedReader(new FileReader(HOSPITALES_DATA_FILE));
        String line = "";
        String[] lineaArr;
        while ((line = fileReader.readLine()) != null)
        {
        	DatosStr += line ;
        }			
        fileReader.close();
		return DatosStr; 		
	}	
	
	public static int  countLines(String fileName) throws IOException {
		int counter = 0;
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		//StringBuffer stringBuffer = new StringBuffer();
		@SuppressWarnings("unused")
		String line ;
		while ((line = bufferedReader.readLine()) != null) {
			counter++;
		}
		fileReader.close();
		return counter;
	}	

}
