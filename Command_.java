interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("The light is on.");
    }

    public void off() {
        System.out.println("The light is off.");
    }
}

class GarageDoor {
    public void up() {
        System.out.println("The garage door is open.");
    }

    public void down() {
        System.out.println("The garage door is closed.");
    }
}

class Stereo {
    public void on() {
        System.out.println("Stereo is on.");
    }

    public void off() {
        System.out.println("Stereo is off.");
    }

    public void setCD() {
        System.out.println("Stereo is set for CD input.");
    }

    public void setVolume(int volume) {
        System.out.println("Stereo volume set to " + volume);
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class GarageDoorUpCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}

class StereoOnWithCDCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Command_ {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(garageDoorUp);
        remote.pressButton();

        remote.setCommand(stereoOnWithCD);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
