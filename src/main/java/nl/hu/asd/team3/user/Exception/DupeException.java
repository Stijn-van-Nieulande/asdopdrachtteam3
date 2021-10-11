package nl.hu.asd.team3.user.Exception;

public class DupeException extends Exception {
    private String msg = "customer already exists";
    private String reason;

    public DupeException(String reason){
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
