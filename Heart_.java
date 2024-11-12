interface BeatModelInterface {
    void initialize();
    void start();
    void stop();
    int getBPM();
    void setBPM(int bpm);
}

class HeartModel {
    private int heartRate;

    public HeartModel() {
        // Simulating a heart rate initialization
        this.heartRate = 72;  // Default heart rate in beats per minute
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void increaseHeartRate(int increase) {
        heartRate += increase;
    }

    public void decreaseHeartRate(int decrease) {
        heartRate = Math.max(heartRate - decrease, 0);
    }

    public void startBeating() {
        System.out.println("Heart model started beating.");
    }

    public void stopBeating() {
        System.out.println("Heart model stopped beating.");
    }
}

class HeartAdapter implements BeatModelInterface {
    private HeartModel heartModel;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing heart model through adapter.");
        heartModel.startBeating();
    }

    @Override
    public void start() {
        System.out.println("Starting heart model through adapter.");
        heartModel.startBeating();
    }

    @Override
    public void stop() {
        System.out.println("Stopping heart model through adapter.");
        heartModel.stopBeating();
    }

    @Override
    public int getBPM() {
        return heartModel.getHeartRate();
    }

    @Override
    public void setBPM(int bpm) {
        int currentHeartRate = heartModel.getHeartRate();
        if (bpm > currentHeartRate) {
            heartModel.increaseHeartRate(bpm - currentHeartRate);
        } else {
            heartModel.decreaseHeartRate(currentHeartRate - bpm);
        }
        System.out.println("Heart model BPM set to: " + heartModel.getHeartRate());
    }
}

public class Heart_ {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        BeatModelInterface beatModel = new HeartAdapter(heartModel);

        beatModel.initialize();
        System.out.println("Current BPM: " + beatModel.getBPM());

        beatModel.setBPM(80);
        System.out.println("Current BPM after setting: " + beatModel.getBPM());

        beatModel.start();
        beatModel.setBPM(60);
        System.out.println("Current BPM after reducing: " + beatModel.getBPM());

        beatModel.stop();
    }
}


