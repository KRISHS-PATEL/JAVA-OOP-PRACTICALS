interface Switchable {
    void on();
    void off();
    default void toggle() {
        on();
        off();
    }
}

class Fan implements Switchable {
    public void on() { System.out.println("Fan on"); }
    public void off() { System.out.println("Fan off"); }
}

class Light implements Switchable {
    public void on() { System.out.println("Light on"); }
    public void off() { System.out.println("Light off"); }
}

@FunctionalInterface
interface SwitchRule {
    boolean maySwitchOn(Switchable device, int hour);
}

public class SwitchableDemo {
    public static void main(String[] args) {
        Switchable[] devices = {new Fan(), new Light()};
        for (Switchable device : devices) device.toggle();

        SwitchRule eveningRule = new SwitchRule() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 18;
            }
        };
        SwitchRule dayRule = (device, hour) -> hour >= 8 && hour <= 22;
        System.out.println(eveningRule.maySwitchOn(devices[0], 19));
        System.out.println(dayRule.maySwitchOn(devices[1], 12));
    }
}
