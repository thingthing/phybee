package validator;

/**
 * Created by Eric on 23/05/2015.
 */

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

        public EmailExistsException(String message) {
            super(message);
        }
}
