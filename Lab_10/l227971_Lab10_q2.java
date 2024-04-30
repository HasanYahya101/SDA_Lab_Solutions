import java.util.List;
import java.util.ArrayList;

// Interface
interface Observer {
    void update(String message);
}

// This is supposed to be the Subject Interface
interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}

// Concrete Class
class HomeHub implements Observable {
    private List<Observer> observers;

    public HomeHub() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void changeState(String device, String state) {
        // Notify observers about state change
        notifyObservers(device + " " + state);
    }
}

// Concrete Class
class SmartApp implements Observer {
    @Override
    public void update(String message) {
        System.out.println("SmartApp: " + message);
    }
}

// Concrete Class
class VoiceBot implements Observer {
    @Override
    public void update(String message) {
        System.out.println("VoiceBot: " + message);
    }
}

// ConcreteClass
class SecCam implements Observer {
    @Override
    public void update(String message) {
        System.out.println("SecCam: " + message);
    }
}

class SmartHomeSystem {
    public static void main(String[] args) {
        HomeHub homeHub = new HomeHub();
        SmartApp smartApp = new SmartApp();
        VoiceBot voiceBot = new VoiceBot();
        SecCam secCam = new SecCam();

        homeHub.registerObserver(smartApp);
        homeHub.registerObserver(voiceBot);
        homeHub.registerObserver(secCam);

        homeHub.changeState("None", "None");
        homeHub.changeState("Whatever", "Whatever");
        homeHub.changeState("LOL", "LOL");
    }
}

public class l227971_Lab10_q2
{
    public static void main(String[] args) {
        SmartHomeSystem system = new SmartHomeSystem();
        system.main(args);
    }
}