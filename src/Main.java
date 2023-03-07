import ua.lviv.iot.algo.part1.lab1.Projector;
public class Main {
    public static void main(String[] args) {
        Projector[] projectors = new Projector[4];

        projectors[0] = new Projector();
        projectors[1] = new Projector("Epson", "1920x1080", 5, "HDMI");
        projectors[2] = Projector.getInstance();
        projectors[3] = Projector.getInstance();

        for(int i = 0; i< projectors.length; ++i){
            System.out.println(((i+1) + "-" + projectors[i]));
        }

        Projector projector = new Projector();
    }
}