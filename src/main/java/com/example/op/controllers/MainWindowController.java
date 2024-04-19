package com.example.op.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private ComboBox<?> addButton;

    @FXML
    private TableColumn<?, ?> addedColumn;

    @FXML
    private TableColumn<?, ?> codeColumn;

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
    private TableView<?> mainTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

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
    private TableColumn<?, ?> reminderStartColumn;

    @FXML
    private TableColumn<?, ?> reminterReceiptColumn;

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
    private TableColumn<?, ?> usedColumn;

    @FXML
    void initialize() {

    }

}
