package utils;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public ArrayList<String> leerCSV(String ruta){
        ArrayList<String> lineas = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea = br.readLine();
            while(linea != null){
                lineas.add(linea);
                linea = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public void escribirCSV(String ruta, ArrayList<String> listaLineas){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))){
            for(String linea : listaLineas){
                bw.write(linea);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> leerDat(String ruta){
        ArrayList<String> lineas = new ArrayList<>();
        try(ObjectInputStream flujoBytesEntrada = new ObjectInputStream(new FileInputStream(ruta)))
        {
            while(true){
                try{
                    Object obj = flujoBytesEntrada.readObject();
                    String linea = String.valueOf(obj);
                    lineas.add(linea);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    int id;
}
