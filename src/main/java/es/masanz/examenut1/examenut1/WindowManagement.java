package es.masanz.examenut1.examenut1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WindowManagement {

    private String currentPath;

    public WindowManagement(String currentPath) {
        this.currentPath = currentPath;
    }

    // TODO: Devolver los nombres de todas aquellas carpetas del path actual
    // TODO: Devolver una lista sin inicializar en caso de error
    public ArrayList<String> getFolders() {
        ArrayList<String> folderNames = null;
        try {
            folderNames = new ArrayList<>();
            File currentFile = new File(currentPath);
            File[] files = currentFile.listFiles();
            if(files!=null) {
                for (File auxFile : files) {
                    if (auxFile.isDirectory()) {
                        folderNames.add(auxFile.getName());
                    }
                }
            }
        } catch (Exception e) {
            folderNames = null;
            e.printStackTrace();
        }
        return folderNames;
    }

    // TODO: Devolver los nombres de todos aquellos archivos con extension "txt" del path actual
    // TODO: Devolver una lista sin inicializar en caso de error
    public ArrayList<String> getFiles() {
        ArrayList<String> filesNames = null;
        try {
            filesNames = new ArrayList<>();
            File currentFile = new File(currentPath);
            File[] files = currentFile.listFiles();
            if(files!=null) {
                for (File auxFile : files) {
                    if (auxFile.isFile() && auxFile.getName().toString().endsWith(".txt")) {
                        filesNames.add(auxFile.getName());
                    }
                }
            }
        } catch (Exception e) {
            filesNames = null;
            e.printStackTrace();
        }
        return filesNames;
    }

    // TODO: Crear la carpeta solicitada sobre el path actual.
    // TODO: Devolver mensaje de error en caso de que se produzca uno
    // TODO: Devolver mensaje de aviso en caso de que dicha carpeta ya exista o no se pueda crear
    public String createFolder(String folderName) {
        try {
            File file = new File(currentPath + "/" + folderName);
            if (file.exists()) {
                return "LA CARPETA QUE INTENTAS CREAR YA EXISTE";
            } else {
                boolean success = file.mkdir();
                if (!success) {
                    return "HA OCURRIDO ALGUN PROBLEMA INTENTANDO CREAR LA CARPETA SOLICITADA";
                }
            }
        } catch (Exception e) {
            return "HA OCURRIDO EL SIGUIENTE ERROR INTENTANDO CREAR LA CARPETA SOLICITADA: " + e.toString();
        }
        return null;
    }

    // TODO: Borrar la carpeta solicitada sobre el path actual (Y SOLO LA CARPETA).
    // TODO: Devolver mensaje de error en caso de que se produzca uno
    // TODO: Devolver mensaje de aviso en caso de que dicha carpeta no exista
    public String deleteFolder(String folderName) {
        try {
            File file = new File(currentPath + "/" + folderName);
            if (file.exists()) {
                boolean success = file.delete();
                if (!success) {
                    return "HA OCURRIDO ALGUN PROBLEMA INTENTANDO BORRAR LA CARPETA SOLICITADA";
                }
            } else {
                return "LA CARPETA QUE INTENTAS BORRAR NO EXISTE";
            }
        } catch (Exception e) {
            return "HA OCURRIDO EL SIGUIENTE ERROR INTENTANDO BORRAR LA CARPETA SOLICITADA: " + e.toString();
        }
        return null;
    }

    // TODO: Crear el archivo solicitado sobre el path actual.
    // TODO: UNICAMENTE podra crear archivos con extension "txt"
    // TODO: Devolver mensaje de error en caso de que se produzca
    // TODO: Devolver mensaje de aviso en caso de que dicho archivo ya exista o no se pueda crear
    public String createFile(String fileName) {
        try {
            if(fileName!=null && fileName.toLowerCase().endsWith(".txt")) {
                File file = new File(currentPath + "/" + fileName);
                if (file.exists()) {
                    return "EL ARCHIVO QUE INTENTAS CREAR YA EXISTE";
                } else {
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(currentPath + "/" + fileName)));
                    pw.close();
                }
            } else {
                return "NO SE PUEDA CREAR UN ARCHIVO SIN EXTENSION TXT";
            }
        } catch (Exception e) {
            return "HA OCURRIDO EL SIGUIENTE ERROR INTENTANDO CREAR EL ARCHIVO SOLICITADO: " + e.toString();
        }
        return null;
    }

    // TODO: Borrar el archivo solicitado sobre el path actual.
    // TODO: Devolver mensaje de error en caso de que se produzca uno
    // TODO: Devolver mensaje de aviso en caso de que dicho archivo ya exista
    public String deleteFile(String fileName) {
        try {
            File file = new File(currentPath + "/" + fileName);
            if (file.exists()) {
                boolean success = file.delete();
                if (!success) {
                    return "HA OCURRIDO ALGUN PROBLEMA INTENTANDO BORRAR EL ARCHIVO SOLICITADO";
                }
            } else {
                return "EL ARCHIVO QUE INTENTAS BORRAR NO EXISTE";
            }
        } catch (Exception e) {
            return "HA OCURRIDO EL SIGUIENTE ERROR INTENTANDO BORRAR EL ARCHIVO SOLICITADO: " + e.toString();
        }
        return null;
    }

    // TODO: Devolver el contenido del elemento seleccionado, solo si es un archivo
    public String readItemContent(String selectedItem) {
        File file = new File(currentPath+"/"+selectedItem);
        if(file.isDirectory()){
            return null;
        } else {
            String content = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader(currentPath+"/"+selectedItem));
                String line = br.readLine();
                while(line != null){
                    content += line + "\n";
                    line = br.readLine();
                }
                br.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                return content;
            }
        }
    }

    // TODO: Sobreescribir el contenido del archivo indicado. Se debera emplear PrintWriter
    public void overwriteFile(String fileName, String fileContent) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(currentPath+"/"+fileName)));
            pw.print(fileContent);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
