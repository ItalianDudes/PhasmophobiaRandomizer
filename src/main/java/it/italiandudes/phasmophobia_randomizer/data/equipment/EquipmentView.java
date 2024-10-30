package it.italiandudes.phasmophobia_randomizer.data.equipment;

import it.italiandudes.phasmophobia_randomizer.utils.Randomizer;
import org.jetbrains.annotations.NotNull;

public final class EquipmentView {

    // Attributes
    @NotNull private final Equipment equipment;
    @NotNull private final String name;
    @NotNull private String tier;
    @NotNull private String quantity;

    // Constructors
    public EquipmentView(@NotNull final Equipment equipment) {
        this.equipment = equipment;
        this.name = equipment.getFullName();
        this.tier = "?";
        this.quantity = "?";
    }

    // Methods
    public void doCompleteRandomization() {
        this.tier = String.valueOf(Randomizer.randomBetween(1, 3));
        this.quantity = String.valueOf(Randomizer.randomBetween(equipment.getMinQuantity(), equipment.getMaxQuantity()));
    }
    public void doFairRandomization() {
        // TODO: fair randomization
    }
    public @NotNull Equipment getEquipment() {
        return equipment;
    }
    public @NotNull String getName() {
        return name;
    }
    public @NotNull String getTier() {
        return tier;
    }
    public @NotNull String getQuantity() {
        return quantity;
    }
    public void setTier(@NotNull String tier) {
        this.tier = tier;
    }
    public void setQuantity(@NotNull String quantity) {
        this.quantity = quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentView)) return false;

        EquipmentView that = (EquipmentView) o;
        return equipment == that.equipment && getName().equals(that.getName()) && getTier().equals(that.getTier()) && getQuantity().equals(that.getQuantity());
    }
    @Override
    public int hashCode() {
        int result = equipment.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getTier().hashCode();
        result = 31 * result + getQuantity().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return getName();
    }
}
