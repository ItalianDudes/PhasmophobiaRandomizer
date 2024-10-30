package it.italiandudes.phasmophobia_randomizer.client.javafx.controllers;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
import it.italiandudes.phasmophobia_randomizer.client.javafx.Client;
import it.italiandudes.phasmophobia_randomizer.data.equipment.Equipment;
import it.italiandudes.phasmophobia_randomizer.data.equipment.EquipmentView;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class ControllerSceneMain {

    // TODO: Map implementation and randomization

    // Graphic Elements
    @FXML private TableView<EquipmentView> tableViewEquipment;
    @FXML private TableColumn<EquipmentView, String> tableColumnName;
    @FXML private TableColumn<EquipmentView, String> tableColumnTier;
    @FXML private TableColumn<EquipmentView, String> tableColumnQuantity;

    //Initialize
    @FXML
    private void initialize() {
        Client.getStage().setFullScreen(false);
        Client.getStage().setMaximized(false);
        Client.getStage().setResizable(false);
        tableViewEquipment.widthProperty().addListener((source, oldWidth, newWidth) -> {
            TableHeaderRow header = (TableHeaderRow) tableViewEquipment.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((observable, oldValue, newValue) -> header.setReordering(false));
        });
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnTier.setCellValueFactory(new PropertyValueFactory<>("tier"));
        tableColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableViewEquipment.setItems(FXCollections.observableArrayList(Arrays.stream(Equipment.values()).map(EquipmentView::new).collect(Collectors.toList())));
    }

    // EDT
    @FXML
    private void doCompleteRandomization() {
        for (EquipmentView equipmentView : tableViewEquipment.getItems()) {
            equipmentView.doCompleteRandomization();
        }
        tableViewEquipment.refresh();
    }
    @FXML
    private void doFairRandomization() {
        tableViewEquipment.refresh();
    }
}