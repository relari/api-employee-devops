package pe.com.relari.employee.util;

/**
 * <b>Enum:</b> Constants.</br>
 * @author Relari.
 */

public class Constants {

    private Constants() {}
    
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String ARROBA = "@";
    public static final int ZERO = 0;
    public static final int ONE = 1;

    public static final String REGEXP_ONLY_LETTERS = "[a-zA-Z]*";
    public static final String REGEXP_ONLY_NUMBER = "\\d+";
    public static final String REGEXP_GENDER = "[M|F]";
    public static final String REGEXP_PHONE_NUMBER = "\\d{9}";
    public static final String REGEXP_DOCUMENT_TYPE = "DNI|PASAPORTE|RUC";
    public static final String REGEXP_JOBS_TITLES = "SCRUM_MASTER|TEAM_LEAD|DEVELOPER|MANAGER|ARCHITECT";
    public static final String REGEXP_LETTERS_AND_NUMBERS = "[a-zA-Z0-9]";
    public static final String REGEXP_DATE = "[0-9]{2}/[0-9]{2}/[0-9]{4}";

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";

    public static final Boolean ACTIVE = Boolean.TRUE;
    public static final Boolean INACTIVE = Boolean.FALSE;

    public static final Integer SUCCESS_STATUS = 200;
    public static final String SUCCESS_CODE = "OK";

    public static final String HEADER_REQUEST_ID = "Request-Id";
    public static final String HEADER_USER_ID = "User-Id";
    public static final String HEADER_SESSION_ID = "Session-Id";
    public static final String HEADER_X_FORWARDED_FOR = "X-Forwarded-For";

}
