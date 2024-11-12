interface Command {
    void execute();
    void undo();
}

class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private int speed;

    public CeilingFan() {
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("Ceiling fan is on high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("Ceiling fan is on medium");
    }

    public void low() {
        speed = LOW;
        System.out.println("Ceiling fan is on low");
    }

    public void off() {
        speed = OFF;
        System.out.println("Ceiling fan is off");
    }

    public int getSpeed() {
        return speed;
    }
}

class CeilingFanHighCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        setSpeedToPrevious();
    }

    private void setSpeedToPrevious() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}

class CeilingFanMediumCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        setSpeedToPrevious();
    }

    private void setSpeedToPrevious() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}

class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        setSpeedToPrevious();
    }

    private void setSpeedToPrevious() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}

class RemoteControlWithUndo {
    private Command command;
    private Command lastCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        lastCommand = command;
    }

    public void pressUndoButton() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}

public class CeilingFan_ {
    public static void main(String[] args) {
        // Create the ceiling fan (receiver)
        CeilingFan ceilingFan = new CeilingFan();

        // Create command objects for each fan speed
        Command fanHigh = new CeilingFanHighCommand(ceilingFan);
        Command fanMedium = new CeilingFanMediumCommand(ceilingFan);
        Command fanOff = new CeilingFanOffCommand(ceilingFan);

        // Create the remote control
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        // Set and execute the commands
        remote.setCommand(fanMedium);
        remote.pressButton();

        remote.setCommand(fanHigh);
        remote.pressButton();

        // Undo the last command
        System.out.println("Undoing last command:");
        remote.pressUndoButton();

        // Turn off the fan and then undo the off command
        remote.setCommand(fanOff);
        remote.pressButton();

        System.out.println("Undoing last command:");
        remote.pressUndoButton();
    }
}
