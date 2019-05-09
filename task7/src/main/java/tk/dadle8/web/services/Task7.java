package tk.dadle8.web.services;

public class Task7 {

    public static void main(String[] args) {

        switch (args[0]) {
            case "browse":
                new Browse().Browse();
                break;
            case "publish":
                new Publish().publish(args[1], args[2], args[3]);
                break;
        }
    }

}
