// Define interfaces for laptop components
interface Processor {
    String getProcessorType();
}

interface RAM {
    String getRAMType();
}

interface Storage {
    String getStorageType();
}

interface GraphicsCard {
    String getGraphicsCardType();
}

// concrete implimentation of interfaces
class IntelProcessor implements Processor {
    @Override
    public String getProcessorType() {
        return "Intel Processor";
    }
}

class AMDProcessor implements Processor {
    @Override
    public String getProcessorType() {
        return "AMD Processor";
    }
}

class DDR4RAM implements RAM {
    @Override
    public String getRAMType() {
        return "DDR4 RAM";
    }
}

class DDR3RAM implements RAM {
    @Override
    public String getRAMType() {
        return "DDR3 RAM";
    }
}

class SSDStorage implements Storage {
    @Override
    public String getStorageType() {
        return "SSD Storage";
    }
}

class HDDStorage implements Storage {
    @Override
    public String getStorageType() {
        return "HDD Storage";
    }
}

class NvidiaGraphicsCard implements GraphicsCard {
    @Override
    public String getGraphicsCardType() {
        return "Nvidia Graphics Card";
    }
}

class AMDGraphicsCard implements GraphicsCard {
    @Override
    public String getGraphicsCardType() {
        return "AMD Graphics Card";
    }
}

// factory interface and concrete factory classes for each brand type
interface LaptopFactory {
    Processor createProcessor();
    RAM createRAM();
    Storage createStorage();
    GraphicsCard createGraphicsCard();
}

class IntelLaptopFactory implements LaptopFactory {
    @Override
    public Processor createProcessor() {
        return new IntelProcessor();
    }

    @Override
    public RAM createRAM() {
        return new DDR4RAM();
    }

    @Override
    public Storage createStorage() {
        return new SSDStorage();
    }

    @Override
    public GraphicsCard createGraphicsCard() {
        return new NvidiaGraphicsCard();
    }
}

class AMDLaptopFactory implements LaptopFactory {
    @Override
    public Processor createProcessor() {
        return new AMDProcessor();
    }

    @Override
    public RAM createRAM() {
        return new DDR3RAM();
    }

    @Override
    public Storage createStorage() {
        return new HDDStorage();
    }

    @Override
    public GraphicsCard createGraphicsCard() {
        return new AMDGraphicsCard();
    }
}

// Laptop class for customized laptop
class Laptop {
    private Processor processor;
    private RAM ram;
    private Storage storage;
    private GraphicsCard graphicsCard;

    public Laptop(LaptopFactory factory) {
        processor = factory.createProcessor();
        ram = factory.createRAM();
        storage = factory.createStorage();
        graphicsCard = factory.createGraphicsCard();
    }

    public void displaySpecs() {
        System.out.println("Processor: " + processor.getProcessorType());
        System.out.println("RAM: " + ram.getRAMType());
        System.out.println("Storage: " + storage.getStorageType());
        System.out.println("Graphics Card: " + graphicsCard.getGraphicsCardType());
    }
}

// Usage example
public class l227971_Lab07_q2 {
    public static void main(String[] args) {
        LaptopFactory intelFactory = new IntelLaptopFactory();
        Laptop intelLaptop = new Laptop(intelFactory);
        intelLaptop.displaySpecs();

        System.out.println();

        LaptopFactory amdFactory = new AMDLaptopFactory();
        Laptop amdLaptop = new Laptop(amdFactory);
        amdLaptop.displaySpecs();
    }
}