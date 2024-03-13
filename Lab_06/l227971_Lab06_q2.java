interface Device 
{
    void turnOn();
    void turnOff();
}

interface Light extends Device 
{
    void dim();

    void brighten();
}

interface SmartSpeaker extends Device 
{
    void playMusic();

    void stopMusic();
}

class SmartBulb implements Light 
{

    private boolean status = false;
    private boolean dim = false;

    public void turnOn() 
    {
        if (!status) 
        {
            status = true;
            System.out.println("Light turned On");
        } 
        else 
        {
            System.out.println("Error: Light is already On");
        }
    }

    public void turnOff() 
    {
        if (status) {
            status = false;
            System.out.println("Light turned Off");
        } else {
            System.out.println("Error: Light is already Off");
        }
    }

    public void dim() 
    {
        if (!status) 
        {
            System.out.println("Error: Please turn light On First");
        } 
        else 
        {
            if (!dim) 
            {
                dim = true;
                System.out.println("Light Dimmed");
            } 
            else 
            {
                System.out.println("Error: Light is already Dimmed");
            }
        }
    }

    public void brighten() 
    {
        if (!status) 
        {
            System.out.println("Error: Please turn light On First");
        } 
        else 
        {
            if (dim) 
            {
                dim = false;
                System.out.println("Light Brightened");
            } 
            else 
            {
                System.out.println("Error: Light is already Brightened");
            }
        }
    }
}

class SmartSwitch implements Device {

    private boolean status = false;

    public void turnOn() 
    {
        if (!status) 
        {
            status = true;
            System.out.println("Light turned On");
        } 
        else 
        {
            System.out.println("Error: Light is already On");
        }
    }

    public void turnOff() 
    {
        if (status) 
        {
            status = false;
            System.out.println("Light turned Off");
        } 
        else 
        {
            System.out.println("Error: Light is already Off");
        }
    }
}

class SmartSpeakerDevice implements SmartSpeaker 
{

    private boolean status = false;
    private boolean playing = false;

    public void turnOn() 
    {
        if (!status) 
        {
            status = true;
            System.out.println("Music Device turned On");
        } 
        else 
        {
            System.out.println("Error: Music Device is already On");
        }
    }

    public void turnOff() 
    {
        if (status) 
        {
            status = false;
            System.out.println("Music Device turned Off");
        } else 
        {
            System.out.println("Error: Music Device is already Off");
        }
    }

    public void playMusic() 
    {
        if (!status) 
        {
            System.out.println("Error: Please turn Music Device On First");
        } else 
        {
            if (!playing) 
            {
                playing = true;
                System.out.println("Music Playing");
            } 
            else 
            {
                System.out.println("Error: Music is already Playing");
            }
        }
    }

    public void stopMusic() 
    {
        if (!status) 
        {
            System.out.println("Error: Please turn Music Device On First");
        } 
        else 
        {
            if (playing) 
            {
                playing = false;
                System.out.println("Music Stopped");
            } 
            else 
            {
                System.out.println("Error: Music is already Stopped");
            }
        }
    }
}

public class l227971_Lab06_q2 
{
    public static void main(String[] args) 
    {
        SmartBulb bulb = new SmartBulb();
        bulb.turnOn();
        bulb.dim();
        bulb.brighten();
        bulb.turnOff();

        SmartSwitch switch1 = new SmartSwitch();
        switch1.turnOn();
        switch1.turnOff();

        SmartSpeakerDevice speaker = new SmartSpeakerDevice();
        speaker.turnOn();
        speaker.playMusic();
        speaker.stopMusic();
        speaker.turnOff();
    }
}