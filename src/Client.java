public class Client implements IObservateur {
    private String message;

    public String recevoirNotification() {
        return this.message;
    }

    @Override
    public void actualiser(String message) {
        this.message = message;
        System.out.println("Nouvelle notification : " + this.message);
    }
}
