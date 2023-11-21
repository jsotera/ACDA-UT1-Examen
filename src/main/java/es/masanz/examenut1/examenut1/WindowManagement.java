package es.masanz.examenut1.examenut1;

import java.util.ArrayList;

public class WindowManagement {

    // TODO: Inicializar el constructor
    public WindowManagement(String currentPath) {

    }

    // TODO: Devolver los nombres de todas aquellas carpetas del path actual
    // TODO: Devolver una lista sin inicializar en caso de error
    public ArrayList<String> getFolders() {

        return null;
    }

    // TODO: Devolver los nombres de todos aquellos archivos con extension "txt" del path actual
    // TODO: Devolver una lista sin inicializar en caso de error
    public ArrayList<String> getFiles() {

        return null;
    }

    // TODO: Crear la carpeta solicitada sobre el path actual.
    // TODO: Devolver mensaje de error en caso de que se produzca
    // TODO: Devolver mensaje de aviso en caso de que dicha carpeta ya exista o no se pueda crear
    public String createFolder(String folderName) {

        return null;
    }

    // TODO: Borrar la carpeta solicitada sobre el path actual.
    // TODO: Devolver mensaje de error en caso de que se produzca
    // TODO: Devolver mensaje de aviso en caso de que dicha carpeta no exista
    public String deleteFolder(String folderName) {

        return null;
    }

    // TODO: Crear el archivo solicitado sobre el path actual.
    // TODO: UNICAMENTE podra crear archivos con extension "txt"
    // TODO: Devolver mensaje de error en caso de que se produzca
    // TODO: Devolver mensaje de aviso en caso de que dicho archivo ya exista o no se pueda crear
    public String createFile(String fileName) {

        return null;
    }

    // TODO: Borrar el archivo solicitado sobre el path actual.
    // TODO: Devolver mensaje de error en caso de que se produzca
    // TODO: Devolver mensaje de aviso en caso de que dicho archivo ya exista
    public String deleteFile(String fileName) {

        return null;
    }

    // TODO: Devolver el contenido del elemento seleccionado, solo si es un archivo
    public String readItemContent(String selectedItem) {

        return null;
    }

    // TODO: Sobreescribir el contenido del archivo indicado. Se debera emplear PrintWriter
    public void overwriteFile(String fileName, String fileContent) {

    }
}
