package com.example.op.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.op.models.TableData;
import com.example.op.models.TotalData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableColumn<?, ?> aboutCostColumn;

    @FXML
    private TableColumn<?, ?> aboutCountColumn;

    @FXML
    private TableView<?> aboutFinalTable;

    @FXML
    private TableColumn<?, ?> aboutNameColumn;

    @FXML
    private TableColumn<?, ?> aboutSumColumn;

    @FXML
    private Tab aboutTab;

    @FXML
    private TableView<?> aboutTable;

    @FXML
    private ComboBox<String> addButton;

    @FXML
    private TableColumn<TableData, Double> addedColumn;

    @FXML
    private TableColumn<TableData, Integer> codeColumn;

    @FXML
    private AnchorPane dataAnchor;

    @FXML
    private TableColumn<?, ?> finalAboutColumn;

    @FXML
    private TableColumn<?, ?> finalAboutSumColumn;

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

    @FXML
    void initialize() {
        addButton.getItems().addAll("Соль", "Специи");

        ObservableList<TableData> list = FXCollections.observableArrayList();
        ObservableList<TotalData> totalList = FXCollections.observableArrayList();

        // Настройка cellValueFactory для каждого столбца
        finalColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        finalAddedColumn.setCellValueFactory(new PropertyValueFactory<>("totalAdded"));
        finalUsedColumn.setCellValueFactory(new PropertyValueFactory<>("totalUsed"));
        finalReminderStartColumn.setCellValueFactory(new PropertyValueFactory<>("totalReminderStart"));
        finalreminderReceiptColumn.setCellValueFactory(new PropertyValueFactory<>("totalReminderReceipt"));

        totalList.add(new TotalData());
        finalMainTeble.setItems(totalList);
        finalMainTeble.refresh();


        // Настройка cellValueFactory для каждого столбца
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        reminderStartColumn.setCellValueFactory(new PropertyValueFactory<>("reminderStart"));
        addedColumn.setCellValueFactory(new PropertyValueFactory<>("added"));
        reminterReceiptColumn.setCellValueFactory(new PropertyValueFactory<>("reminderReceipt"));
        usedColumn.setCellValueFactory(new PropertyValueFactory<>("used"));

        mainTable.setItems(list);
        mainTable.refresh();

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
        });

        reminterReceiptColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        reminterReceiptColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setReminderReceipt(newValue);
        });

        addedColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        addedColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setAdded(newValue);
        });

        usedColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        usedColumn.setOnEditCommit(event -> {
            TablePosition<TableData, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            TableData rowData = event.getTableView().getItems().get(row);
            rowData.setUsed(newValue);
        });

        addButton.getSelectionModel().selectedItemProperty().addListener((option, oldValue, newValue) -> {
            if(newValue.equals("Соль"))
                list.add(new TableData(newValue, 1, 0, 0, 0,0));
            else if (newValue.equals("Специи"))
                list.add(new TableData(newValue, 2, 0, 0, 0,0));

        });


        mainTable.setEditable(true);


    }



}
