package it.italiandudes.phasmophobia_randomizer.client.javafx.controllers;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
import it.italiandudes.phasmophobia_randomizer.client.javafx.alerts.ErrorAlert;
import it.italiandudes.phasmophobia_randomizer.data.equipment.Equipment;
import it.italiandudes.phasmophobia_randomizer.data.equipment.EquipmentView;
import it.italiandudes.phasmophobia_randomizer.data.map.Map;
import it.italiandudes.phasmophobia_randomizer.data.map.MapSize;
import it.italiandudes.phasmophobia_randomizer.data.map.MapView;
import it.italiandudes.phasmophobia_randomizer.utils.Randomizer;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ControllerSceneMain {

    // Graphic Elements
    @FXML private ListView<MapView> listViewMap;
    @FXML private Label labelRandomizedMap;
    @FXML private TableView<EquipmentView> tableViewEquipment;
    @FXML private TableColumn<EquipmentView, String> tableColumnName;
    @FXML private TableColumn<EquipmentView, String> tableColumnTier;
    @FXML private TableColumn<EquipmentView, String> tableColumnQuantity;
    @FXML private Button buttonCompleteRandomization;
    @FXML private Button buttonFairRandomization;

    //Initialize
    @FXML
    private void initialize() {
        listViewMap.addEventFilter(KeyEvent.ANY, Event::consume);
        listViewMap.setItems(FXCollections.observableArrayList(Arrays.stream(Map.values()).map(MapView::new).collect(Collectors.toList())));
        tableViewEquipment.widthProperty().addListener((source, oldWidth, newWidth) -> {
            TableHeaderRow header = (TableHeaderRow) tableViewEquipment.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((observable, oldValue, newValue) -> header.setReordering(false));
        });
        tableViewEquipment.setSelectionModel(null);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnTier.setCellValueFactory(new PropertyValueFactory<>("tier"));
        tableColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableViewEquipment.setItems(FXCollections.observableArrayList(Arrays.stream(Equipment.values()).map(EquipmentView::new).collect(Collectors.toList())));
        buttonCompleteRandomization.setTooltip(new Tooltip("Randomizza senza tenere conto della dimensione della mappa."));
        buttonCompleteRandomization.getTooltip().setWrapText(true);
        buttonFairRandomization.setTooltip(new Tooltip("Randomizza tenendo conto della dimensione della mappa, incrementando le possibilita' di avere equipaggiamento di tier superiore con mappe piu' grandi."));
        buttonFairRandomization.getTooltip().setWrapText(true);
    }

    // Methods
    @Nullable
    private Map randomizeMap() {
        List<MapView> allowedMaps = listViewMap.getItems().stream().filter(CheckBox::isSelected).collect(Collectors.toList());
        if (allowedMaps.isEmpty()) return null;
        Map map = allowedMaps.get(Randomizer.randomBetween(0, allowedMaps.size()-1)).getMap();
        labelRandomizedMap.setText(map.getFullName());
        return map;
    }

    // EDT
    @FXML
    private void addAllMaps() {
        for (MapView mapView : listViewMap.getItems()) mapView.setSelected(true);
    }
    @FXML
    private void removeAllMaps() {
        for (MapView mapView : listViewMap.getItems()) mapView.setSelected(false);
    }
    @FXML
    private void doCompleteRandomization() {
        if (randomizeMap() == null) {
            new ErrorAlert("ERRORE", "Errore di Inserimento", "Devi selezionare almeno una mappa!");
            return;
        }
        for (EquipmentView equipmentView : tableViewEquipment.getItems()) {
            equipmentView.doCompleteRandomization();
        }
        tableViewEquipment.refresh();
    }
    @FXML
    private void doFairRandomization() {
        Map map = randomizeMap();
        if (map == null) {
            new ErrorAlert("ERRORE", "Errore di Inserimento", "Devi selezionare almeno una mappa!");
            return;
        }
        if (map.getMapSize() == MapSize.UNKNOWN) {
            for (EquipmentView equipmentView : tableViewEquipment.getItems()) {
                equipmentView.doCompleteRandomization();
            }
        } else {
            for (EquipmentView equipmentView : tableViewEquipment.getItems()) {
                equipmentView.doFairRandomization(map.getMapSize());
            }
        }
        tableViewEquipment.refresh();
    }
}