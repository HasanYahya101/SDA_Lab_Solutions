import java.util.ArrayList;
import java.util.List;

// Component interface
interface File {
    void printFileDetails();
}

// Leaf class
class ImageFile implements File {
    private String data;
    private String format;

    public ImageFile(String data, String format) {
        this.data = data;
        this.format = format;
    }

    @Override
    public void printFileDetails() {
        System.out.println("Image File - Data: " + data + ", Format: " + format);
    }
}

// Leaf class
class VideoFile implements File {
    private String data;
    private int duration;

    public VideoFile(String data, int duration) {
        this.data = data;
        this.duration = duration;
    }

    @Override
    public void printFileDetails() {
        System.out.println("Video File - Data: " + data + ", Duration: " + duration + " seconds");
    }
}

// Composite class
class Folder implements File {
    private String name;
    private List<File> files;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

    @Override
    public void printFileDetails() {
        System.out.println("Folder: " + name);
        for (File file : files) {
            file.printFileDetails();
        }
    }
}

// example for testing
class FileManagementSystem {
    public static void main(String[] args) {
        // Create files
        File imageFile = new ImageFile("Image data", "JPEG");
        File videoFile = new VideoFile("Video data", 120);

        // Create folders
        Folder rootFolder = new Folder("Root");
        Folder subFolder = new Folder("Subfolder");

        // Add files to folders
        rootFolder.addFile(imageFile);
        subFolder.addFile(videoFile);

        // Add subfolder to root folder
        rootFolder.addFile(subFolder);

        // Print file details
        rootFolder.printFileDetails();
    }
}

public class l227971_Lab09_q1 {
    public static void main(String[] args) {
        FileManagementSystem.main(args);
    }
}