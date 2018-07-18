package rebrickable.model.db;

// custom exception for if the API key is invalide
public class InvalidAPIKeyException extends Exception {

    public InvalidAPIKeyException(String message){
        super(message);
    }
}
