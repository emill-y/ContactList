public class Athlete extends Person{
    private String sport;
    private boolean isInjured;

    public Athlete(String firstName, String lastName, String phoneNumber, String sport, boolean isInjured){
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
        this.isInjured = isInjured;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    @Override
    public String toString(){
        if (isInjured()) {
            return super.toString() + " Sport: " + sport + " Athlete is injured :( ";
        }
        else {
            return super.toString() + " Sport: " + sport + " Athlete is not injured :)";
        }
    }
}
