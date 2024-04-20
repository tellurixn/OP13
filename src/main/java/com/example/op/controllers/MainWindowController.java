package com.example.op.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.example.op.models.tableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;

import java.util.Date;


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
    private TableColumn<tableData, Double> addedColumn;

    @FXML
    private TableColumn<tableData, Integer> codeColumn;

    @FXML
    private AnchorPane dataAnchor;

    @FXML
    private TableColumn<?, ?> finalAboutColumn;

    @FXML
    private TableColumn<?, ?> finalAboutSumColumn;

    @FXML
    private TableColumn<?, ?> finalAddedColumn;

    @FXML
    private TableColumn<?, ?> finalColumn;

    @FXML
    private TableView<?> finalMainTeble;

    @FXML
    private TableColumn<?, ?> finalReminderStartColumn;

    @FXML
    private TableColumn<?, ?> finalUsedColumn;

    @FXML
    private TableColumn<?, ?> finalreminderReceiptColumn;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label mainLabel;

    @FXML
    private TableView<tableData> mainTable;

    @FXML
    private TableColumn<tableData, String> nameColumn;

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
    private TableColumn<tableData, LocalDate> reminderStartColumn;

    @FXML
    private TableColumn<tableData, LocalDate> reminterReceiptColumn;

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
    private TableColumn<tableData, Double> usedColumn;

    @FXML
    void initialize() {
       // addButton.getItems().addAll("Соль", "Специи");

        ObservableList<tableData> list = FXCollections.observableArrayList();
        // Добавление нескольких примеров данных в таблицу
        for (int i = 0; i < 3; i++) {
            list.add(new tableData("name", 1, LocalDate.now(), LocalDate.now(), 1, 1));
        }

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
            TablePosition<tableData, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            tableData rowData = event.getTableView().getItems().get(row);
            rowData.setName(newValue);
        });

        codeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        codeColumn.setOnEditCommit(event -> {
            TablePosition<tableData, Integer> pos = event.getTablePosition();
            Integer newValue = event.getNewValue();
            int row = pos.getRow();
            tableData rowData = event.getTableView().getItems().get(row);
            rowData.setCode(newValue);
        });

// Для других столбцов делайте аналогично

// Установка таблицы редактируемой
        mainTable.setEditable(true);


    }



}
