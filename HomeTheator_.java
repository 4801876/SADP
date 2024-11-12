class Amplifier {
    public void on() {
        System.out.println("Amplifier is on.");
    }

    public void off() {
        System.out.println("Amplifier is off.");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void off() {
        System.out.println("DVD Player is off.");
    }

    public void play(String movie) {
        System.out.println("DVD Player is playing \"" + movie + "\".");
    }

    public void stop() {
        System.out.println("DVD Player stopped.");
    }

    public void eject() {
        System.out.println("DVD ejected.");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void off() {
        System.out.println("Projector is off.");
    }

    public void wideScreenMode() {
        System.out.println("Projector is in widescreen mode.");
    }
}

class TheaterLights {
    public void dim(int level) {
        System.out.println("Theater Lights dimmed to " + level + "%.");
    }

    public void on() {
        System.out.println("Theater Lights are on.");
    }
}

class Screen {
    public void down() {
        System.out.println("Screen is down.");
    }

    public void up() {
        System.out.println("Screen is up.");
    }
}

class PopcornMachine {
    public void on() {
        System.out.println("Popcorn Machine is on.");
    }

    public void off() {
        System.out.println("Popcorn Machine is off.");
    }

    public void pop() {
        System.out.println("Popcorn Machine is popping popcorn!");
    }
}

class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopcornMachine popcornMachine;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector proj, TheaterLights lights, Screen screen,
            PopcornMachine popcorn) {
        this.amplifier = amp;
        this.dvdPlayer = dvd;
        this.projector = proj;
        this.lights = lights;
        this.screen = screen;
        this.popcornMachine = popcorn;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popcornMachine.on();
        popcornMachine.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popcornMachine.off();
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }
}

public class HomeTheator_ {
    public static void main(String[] args) {

        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        PopcornMachine popcorn = new PopcornMachine();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights, screen, popcorn);

        homeTheater.watchMovie("The Matrix");
        System.out.println("\n");
        homeTheater.endMovie();
    }
}
