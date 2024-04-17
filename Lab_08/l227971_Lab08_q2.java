abstract class Menu {
    public abstract void generateMenu();
    public abstract String getDescription();
}

abstract class Drink {
    public abstract void serveDrink();
    public abstract String getDescription();
}

class SteakhouseMenu extends Menu {
    @Override
    public void generateMenu() {
        System.out.println("Menu:");
        System.out.println("1. Ribeye Steak");
        System.out.println("2. Filet Mignon");
        System.out.println("3. New York Strip");
        System.out.println("4. T-Bone Steak");
        System.out.println("5. Porterhouse Steak");
    }

    @Override
    public String getDescription() {
        return "Steakhouse Menu";
    }
}

class SeafoodMenu extends Menu {
    @Override
    public void generateMenu() {
        System.out.println("Menu:");
        System.out.println("1. Lobster");
        System.out.println("2. Crab");
        System.out.println("3. Shrimp");
        System.out.println("4. Salmon");
        System.out.println("5. Tuna");
    }

    @Override
    public String getDescription() {
        return "Seafood Menu";
    }
}

class Margarita extends Drink {
    @Override
    public void serveDrink() {
        System.out.println("Serving Margarita");
    }

    @Override
    public String getDescription() {
        return "Margarita";
    }
}

class Mocktails extends Drink {
    @Override
    public void serveDrink() {
        System.out.println("Serving Mocktails");
    }

    @Override
    public String getDescription() {
        return "Mocktails";
    }
}

interface MenuFactory {
    Menu createMenu();
    Drink createDrink();
}

class StandardMenuFactory implements MenuFactory {
    private static StandardMenuFactory instance;

    private StandardMenuFactory() {
        // Private constructor to enforce Singleton pattern
        System.out.println("Creating Standard Menu Factory Object");
    }

    public static StandardMenuFactory getInstance() {
        if (instance == null) {
            instance = new StandardMenuFactory();
        }
        return instance;
    }

    @Override
    public Menu createMenu() {
        return new SteakhouseMenu();
    }

    @Override
    public Drink createDrink() {
        return new Margarita();
    }
}

class VIPMenuFactory implements MenuFactory {
    private static VIPMenuFactory instance;

    private VIPMenuFactory() {
        // Private constructor to enforce Singleton pattern#
        System.out.println("Creating VIP Menu Factory Object");
    }

    public static VIPMenuFactory getInstance() {
        if (instance == null) {
            instance = new VIPMenuFactory();
        }
        return instance;
    }

    @Override
    public Menu createMenu() {
        return new SeafoodMenu();
    }

    @Override
    public Drink createDrink() {
        return new Mocktails();
    }
}

class Client {
    public static void main(String[] args) {
        // Standard Steakhouse Menu and Drink
        MenuFactory standardMenuFactory = StandardMenuFactory.getInstance();
        Menu standardMenu = standardMenuFactory.createMenu();
        Drink standardDrink = standardMenuFactory.createDrink();
        standardMenu.generateMenu();
        standardDrink.serveDrink();
        System.out.println("Standard Steakhouse Menu: " + standardMenu.getDescription());
        System.out.println("Standard Drink: " + standardDrink.getDescription());

        // VIP Seafood Menu and Drink
        MenuFactory vipMenuFactory = VIPMenuFactory.getInstance();
        Menu vipMenu = vipMenuFactory.createMenu();
        Drink vipDrink = vipMenuFactory.createDrink();
        vipMenu.generateMenu();
        vipDrink.serveDrink();
        System.out.println("VIP Seafood Menu: " + vipMenu.getDescription());
        System.out.println("VIP Drink: " + vipDrink.getDescription());
    }
}

public class l227971_Lab08_q2 {
    public static void main(String[] args) {
        Client.main(args);
    }
}