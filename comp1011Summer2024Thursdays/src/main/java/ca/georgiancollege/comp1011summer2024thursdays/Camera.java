package ca.georgiancollege.comp1011summer2024thursdays;

public class Camera {

    /*
    d: powerState: enum
p: color: string
v: storage: int
v: make: string
v: model:string
v:shutter: enum
v:battery: double
v: numberOfPhotos: int
v: hoursOfViewRecorded: double

p:takePhoto(mode: string, int howMany): boolean
p: savePhoto(photoId: int): boolean
p:recordVideo(howLong: double): boolean


     */
    public String color, name;
    private String make, model, imagePath;

    public enum PowerStates{ON, OFF}
    public enum ShutterTypes{OPEN, CLOSED}
    private PowerStates powerState = PowerStates.OFF;
    private ShutterTypes shutter = ShutterTypes.CLOSED;
    private int numberOfPhotos;
    private double hoursOfVideoRecordings;

    public boolean takePhoto(String mode, int howMany){
        numberOfPhotos++;
        System.out.println("Take photo in mode " + mode);
        return true;
    }
    public boolean savePhoto(int photoId){
        System.out.println("Saving photo with ID=" + photoId);
        return true;
    }
    public boolean recordVideo(double howLong){
        hoursOfVideoRecordings+= howLong;
        return true;
    }

    public Camera(){}

    //alt+insert

    private void validate(String title, String content){
        if(content.trim().isEmpty())
            throw new IllegalArgumentException(title + " is invalid. Should be at least 1 char");
    }
    public void setColor(String color) {
        validate("Color", color);
        this.color = color;
    }

    public void setName(String name) {
        validate("Name", name);
        this.name = name;
    }

    public void setMake(String make) {
        validate("Make", make);
        this.make = make;
    }

    public void setModel(String model) {
        validate("Model", model);
        this.model = model;
    }

    public Camera(String name, String make, String model, String color){
        setName(name);
        setMake(make);
        setModel(model);
        setColor(color);

    }
    public Camera(String name, String make, String model, String color, String imagePath, int numberOfPhotos){
        this(name, make, model, color);
        setImagePath(imagePath);
        this.numberOfPhotos = numberOfPhotos;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        if(imagePath.contains(".png") || imagePath.contains(".jpg"))
            this.imagePath = imagePath;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public void setNumberOfPhotos(int numberOfPhotos) {
        this.numberOfPhotos = numberOfPhotos;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", numberOfPhotos=" + numberOfPhotos +
                '}';
    }
}


