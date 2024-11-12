class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}

interface SocketAdapter {
    Volt get3Volt();

    Volt get12Volt();

    Volt get120Volt();
}

class SocketClassAdapter extends Socket implements SocketAdapter {

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40); // 120V / 40 = 3V
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10); // 120V / 10 = 12V
    }

    @Override
    public Volt get120Volt() {
        return getVolt(); // default 120V
    }

    private Volt convertVolt(Volt v, int divisor) {
        return new Volt(v.getVolts() / divisor);
    }
}

public class MobileCharger_ {
    public static void main(String[] args) {
        SocketAdapter adapter = new SocketClassAdapter();

        Volt v3 = adapter.get3Volt();
        Volt v12 = adapter.get12Volt();
        Volt v120 = adapter.get120Volt();

        System.out.println("Mobile charger needs 3 volts: " + v3.getVolts() + "V");
        System.out.println("Laptop charger needs 12 volts: " + v12.getVolts() + "V");
        System.out.println("Home appliance uses default 120 volts: " + v120.getVolts() + "V");
    }
}
