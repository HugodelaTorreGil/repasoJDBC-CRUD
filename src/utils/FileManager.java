package utils;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    /*
    Metodo que recibe la ruta del archivo cvs, lo lee, introduce lo leido en una lista
     */
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

    /*
    Metodo que recibe la ruta del archivo a crear, y las lineas del csv recibido y crea un archivo con esa informacion
     */
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

    /*
    Metodo que lee un archivo binario y lo guarda en una lista
     */
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

    public void escribirDat(String ruta, ArrayList<String> leerDat){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){
            for(String linea : leerDat){
                oos.writeObject(linea);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void pasarCsvADat(String rutaCSV, String rutaDat){
        ArrayList<String> listaLineas = leerCSV(rutaCSV);
        escribirDat(rutaDat, listaLineas);
    }

    public void pasarDatACsv(String rutaCsv, String rutaDat){
        ArrayList<String> listaLineas = leerDat(rutaDat);
        escribirCSV(rutaCsv, listaLineas);
    }


}
