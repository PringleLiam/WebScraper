package webscraper.exceptions;

public class CouldNotConnectException extends RuntimeException {

    public CouldNotConnectException(String message){
        super(message);
    }
}
