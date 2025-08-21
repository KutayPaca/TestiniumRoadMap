package drone.model;

public enum DroneType {
    SAVUNMA(true),
    SALDIRI(true),
    KESIF(true);

    private boolean active;

    DroneType(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
