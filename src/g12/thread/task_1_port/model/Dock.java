package g12.thread.task_1_port.model;

public class Dock {
    private final int id;

    private Ship ship;

    public Dock(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        String status;

        if (ship == null) {
            status = "no ship\n";
        } else {
            status = ship.toString();
        }
        return String.format("Dock: id=%d-2d %s", id, status);
    }
}
