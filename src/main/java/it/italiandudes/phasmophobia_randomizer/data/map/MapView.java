package it.italiandudes.phasmophobia_randomizer.data.map;

import javafx.scene.control.CheckBox;
import org.jetbrains.annotations.NotNull;

public class MapView extends CheckBox {

    // Attributes
    @NotNull private final Map map;

    // Constructors
    public MapView(@NotNull final Map map) {
        super(map.getFullName() + " (Dimensione: " + map.getMapSize() + ")");
        this.map = map;
        setMinWidth(USE_COMPUTED_SIZE);
        setPrefWidth(USE_COMPUTED_SIZE);
        setMaxWidth(Double.MAX_VALUE);
        setSelected(true);
    }

    // Methods
    public @NotNull Map getMap() {
        return map;
    }
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapView)) return false;

        MapView mapView = (MapView) o;
        return getMap() == mapView.getMap();
    }
    @Override
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override
    public String toString() {
        return map.getFullName() + " (Dimensione: " + map.getMapSize() + ")";
    }
}
