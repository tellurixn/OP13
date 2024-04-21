package com.example.op.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.op.models.AboutData;
import com.example.op.models.FinalSumData;
import com.example.op.models.TableData;
import com.example.op.models.TotalData;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;


public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane aboutAnchor;

    @FXML
    private TableColumn<AboutData, Double> aboutCostColumn;

    @FXML
    private TableColumn<AboutData, Integer> aboutCountColumn;

    @FXML
    private TableView<FinalSumData> aboutFinalTable;

    @FXML
    private TableColumn<AboutData, String> aboutNameColumn;

    @FXML
    private TableColumn<AboutData, Double> aboutSumColumn;

    @FXML
    private Tab aboutTab;

    @FXML
    private TableView<AboutData> aboutTable;

    @FXML
    private ComboBox<String> addButton;

    @FXML
    private TableColumn<TableData, Double> addedColumn;

    @FXML
    private TableColumn<TableData, Integer> codeColumn;

    @FXML
    private AnchorPane dataAnchor;

    @FXML
    private TableColumn<FinalSumData, String> finalAboutColumn;

    @FXML
    private TableColumn<FinalSumData, Double> finalAboutSumColumn;

    @FXML
    private TableColumn<TotalData, Double> finalAddedColumn;

    @FXML
    private TableColumn<TotalData, String> finalColumn;

    @FXML
    private TableView<TotalData> finalMainTeble;

    @FXML
    private TableColumn<TotalData, Double> finalReminderStartColumn;

    @FXML
    private TableColumn<TotalData, Double> finalUsedColumn;

    @FXML
    private TableColumn<TotalData, Double> finalreminderReceiptColumn;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label mainLabel;

    @FXML
    private TableView<TableData> mainTable;

    @FXML
    private TableColumn<TableData, String> nameColumn;

    @FXML
    private TextField number;

    @FXML
    private TextField okpo;

    @FXML
    private TextField organizationName;

    @FXML
    private DatePicker receiptDate;

    @FXML
    private DatePicker releaseDate;

    @FXML
    private TableColumn<TableData, Double> reminderStartColumn;

    @FXML
    private TableColumn<TableData, Double> reminterReceiptColumn;

    @FXML
    private AnchorPane researchAnchor;

    @FXML
    private Tab researchTab;

    @FXML
    private Button saveAsButton;

    @FXML
    private DatePicker startDate;

    @FXML
    private TextField subdivision;

    @FXML
    private TabPane tab;

    @FXML
    private TextField typeOfDeal;

    @FXML
    private TextField typeOfOperation;

    @FXML
    private TableColumn<TableData, Double> usedColumn;

    private ObservableList<TableData> mainList = FXCollections.observableArrayList();
    private ObservableList<TotalData> totalList = FXCollections.observableArrayList();
    private ObservableList<AboutData> aboutList = FXCollections.observableArrayList();
    private ObservableList<FinalSumData> finalSumList = FXCollections.observableArrayList();

    private double countAllReminderStart(){
        double result = 0;
        for(TableData data : mainList)
            result += data.getReminderStart();

        return result;
    }

    private double countAllReminderReceipt(){
        double result = 0;
        for(TableData data : mainList)
            result += data.getReminderReceipt();

        return result;
    }

    private double countAllAdded(){
        double result = 0;
        for(TableData data : mainList)
            result += data.getAdded();

        return result;
    }

    private double countAllUsed(){
        double result = 0;
        for(TableData data : mainList)
            result += data.getUsed();

        return result;
    }

    private void updateTotalTable(){
        totalList.set(0, new TotalData(
                countAllReminderStart(),
                countAllReminderReceipt(),
                countAllAdded(),
                countAllUsed()));
    }

    private void updateFinalSumTable(){
        finalSumList.set(0, new FinalSumData(countAllSum()));
    }
    private double countAllSum(){
        double result = 0;
        for(AboutData data : aboutList)
            result += data.getSum();

        return result;
    }


    @FXML
    void initialize() {
        addButton.getItems().addAll("Соль", "Специи");



        // Настройка cellValueFactory для каждого столбца finalAboutTable
        finalAboutColumn.setCellValueFactory(new PropertyValueFactory<>("label"));
        finalAboutSumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));

        finalSumList.add(new FinalSumData());
        aboutFinalTable.setItems(finalSumList);
        aboutFinalTable.refresh();


        // Настройка cellValueFactory для каждого столбца aboutTable
        aboutNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        aboutCountColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        aboutCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        aboutSumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));

        aboutTable.setItems(aboutList);
        aboutTable.refresh();


        // Настройка cellValueFactory для каждого столбца totalTable
        finalColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        finalAddedColumn.setCellValueFactory(new PropertyValueFactory<>("totalAdded"));
        finalUsedColumn.setCellValueFactory(new PropertyValueFactory<>("totalUsed"));
        finalReminderStartColumn.setCellValueFactory(new PropertyValueFactory<>("totalReminderStart"));
        finalreminderReceiptColumn.setCellValueFactory(new PropertyValueFactory<>("totalReminderReceipt"));

        totalList.add(new TotalData());
        finalMainTeble.setItems(totalList);
        finalMainTeble.refresh();


        // Настройка cellValueFactory для каждого столбца mainTable
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        reminderStartColumn.setCellValueFactory(new PropertyValueFactory<>("reminderStart"));
        addedColumn.setCellValueFactory(new PropertyValueFactory<>("added"));
        reminterReceiptColumn.setCellValueFactory(new PropertyValueFactory<>("reminderReceipt"));
        usedColumn.setCellValueFactory(new PropertyValueFactory<>("used"));

        mainTable.setItems(mainList);
        mainTable.refresh();


        addButton.getSelectionModel().selectedItemProperty().addListener((option, oldValue, newValue) -> {
            if(newValue.equals("Соль")) {
                mainList.add(new TableData(newValue, 1, 0, 0, 0, 0));
                aboutList.add(new AboutData(newValue, 0, 10, 0));

                updateTotalTable();
            }
            else if (newValue.equals("Специи")) {
                mainList.add(new TableData(newValue, 2, 0, 0, 0, 0));
                aboutList.add(new AboutData(newValue, 0, 15, 0));
            }
        });

        //---------------------------Main Table----------------------------------//
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            TablePosition<TableData, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setName(newValue);
        });

        codeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        codeColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Integer> pos = event.getTablePosition();
            Integer newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setCode(newValue);
        });

        reminderStartColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        reminderStartColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setReminderStart(newValue);

            updateTotalTable();
        });

        reminterReceiptColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        reminterReceiptColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setReminderReceipt(newValue);

            updateTotalTable();
        });

        addedColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        addedColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setAdded(newValue);

            updateTotalTable();
        });

        usedColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        usedColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setUsed(newValue);

            updateTotalTable();
        });

        //------------------------About Table--------------------------//

        aboutNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        aboutNameColumn.setOnEditCommit(event -> {
            TablePosition<AboutData, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            AboutData rowData = event.getTableView().getItems().get(row);
            rowData.setName(newValue);


        });

        aboutCountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        aboutCountColumn.setOnEditCommit(event -> {
            TablePosition<AboutData, Integer> pos = event.getTablePosition();
            Integer newValue = event.getNewValue();
            int row = pos.getRow();
            AboutData rowData = event.getTableView().getItems().get(row);
            rowData.setCount(newValue);

            //todo дописать логику подсчета суммы и обновления таблицы с итогом
        });

        aboutCostColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        aboutCostColumn.setOnEditCommit(event -> {
            TablePosition<AboutData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            AboutData rowData = event.getTableView().getItems().get(row);
            rowData.setCost(newValue);

            //todo дописать логику подсчета суммы и обновления таблицы с итогом
        });

        aboutSumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        aboutSumColumn.setOnEditCommit(event -> {
            TablePosition<AboutData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            AboutData rowData = event.getTableView().getItems().get(row);
            rowData.setSum(newValue);


        });
        //--------------------------------------------------------------------------//

        aboutTable.setEditable(true);
        mainTable.setEditable(true);
    }



}
