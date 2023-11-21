package es.masanz.examenut1.examenut1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class WindowController {

    private WindowManagement windowManagement;

    @FXML
    private TextField currentPathTxt;

    @FXML
    private TextField folderNameTxt;

    @FXML
    private TextField fileNameTxt;

    @FXML
    private TextArea fileSelectedContent;

    @FXML
    private ListView<String> foldersListView;
    @FXML
    private ListView<String> filesListView;

    @FXML
    void createFolder(ActionEvent event) {
        if(windowManagement!=null){
            String folderName = folderNameTxt.getText();
            String errorMsg = windowManagement.createFolder(folderName);
            if(errorMsg!=null && !errorMsg.isEmpty()){
                showErrorMsg(errorMsg);
            } else {
                hideErrorMsg();
            }
            updateWindow();
        }
    }

    @FXML
    void deleteFolder(ActionEvent event) {
        if(windowManagement!=null){
            String folderName = folderNameTxt.getText();
            String errorMsg = windowManagement.deleteFolder(folderName);
            if(errorMsg!=null && !errorMsg.isEmpty()){
                showErrorMsg(errorMsg);
            } else {
                hideErrorMsg();
            }
            updateWindow();
        }
    }

    @FXML
    void createFile(ActionEvent event) {
        if(windowManagement!=null){
            String fileName = fileNameTxt.getText();
            String errorMsg = windowManagement.createFile(fileName);
            if(errorMsg!=null && !errorMsg.isEmpty()){
                showErrorMsg(errorMsg);
            } else {
                hideErrorMsg();
            }
            updateWindow();
        }
    }

    @FXML
    void deleteFile(ActionEvent event) {
        if(windowManagement!=null){
            String fileName = fileNameTxt.getText();
            String errorMsg = windowManagement.deleteFile(fileName);
            if(errorMsg!=null && !errorMsg.isEmpty()){
                showErrorMsg(errorMsg);
            } else {
                hideErrorMsg();
            }
            updateWindow();
        }
    }

    private void showErrorMsg(String errorMsg) {
        fileSelectedContent.setText(errorMsg);
    }

    private void hideErrorMsg() {
        fileSelectedContent.setText("");
    }

    @FXML
    void updatePath(ActionEvent event) {
        String currentPath = currentPathTxt.getText();
        windowManagement = new WindowManagement(currentPath);
        updateWindow();
    }

    private void updateWindow(){
        if(windowManagement!=null) {
            List<String> folders = windowManagement.getFolders();
            List<String> files = windowManagement.getFiles();
            if (folders != null) {
                ObservableList<String> folderItems = FXCollections.observableArrayList(folders);
                foldersListView.setItems(folderItems);
                hideErrorMsg();
            } else {
                ObservableList<String> folderItems = FXCollections.observableArrayList(new ArrayList<>());
                foldersListView.setItems(folderItems);
                showErrorMsg("ERROR SELECCIONANDO LA RUTA INDICADA");
            }
            if (files != null) {
                ObservableList<String> filesItems = FXCollections.observableArrayList(files);
                filesListView.setItems(filesItems);
                hideErrorMsg();
            } else {
                ObservableList<String> filesItems = FXCollections.observableArrayList(new ArrayList<>());
                filesListView.setItems(filesItems);
                showErrorMsg("ERROR SELECCIONANDO LA RUTA INDICADA");
            }
        }
    }

    @FXML
    public void selectFolderOnKeyPressed(KeyEvent event) {
        selectFolder();
    }

    @FXML
    public void selectFolderOnMouseClicked(MouseEvent event) {
        selectFolder();
    }

    private void selectFolder() {
        if(windowManagement!=null) {
            filesListView.getSelectionModel().clearSelection();
            String selectedFolder = foldersListView.getSelectionModel().getSelectedItem();
            viewSelectedItemContent(selectedFolder);
            folderNameTxt.setText(selectedFolder);
        }
    }

    @FXML
    void selectFileOnKeyPressed(KeyEvent event) {
        selectFile();
    }

    @FXML
    void selectFileOnMouseClicked(MouseEvent event) {
        selectFile();
    }

    private void selectFile() {
        if(windowManagement!=null) {
            foldersListView.getSelectionModel().clearSelection();
            String selectedFile = filesListView.getSelectionModel().getSelectedItem();
            viewSelectedItemContent(selectedFile);
            fileNameTxt.setText(selectedFile);
        }
    }

    private void viewSelectedItemContent(String selectedItem) {
        if(windowManagement!=null) {
            String content = windowManagement.readItemContent(selectedItem);
            if (content != null) {
                fileSelectedContent.setText(content);
                fileSelectedContent.setDisable(false);
            } else {
                fileSelectedContent.setText("");
                fileSelectedContent.setDisable(true);
            }
        }
    }

    @FXML
    void updateFileSelectedContent(ActionEvent event) {
        if(windowManagement!=null) {
            String selectedFile = filesListView.getSelectionModel().getSelectedItem();
            if(selectedFile!=null && !selectedFile.isEmpty()){
                String selectedFileContent = fileSelectedContent.getText();
                if(selectedFileContent!=null && !selectedFileContent.isEmpty()){
                    windowManagement.overwriteFile(selectedFile, selectedFileContent);
                }
            }
        }
    }

}
