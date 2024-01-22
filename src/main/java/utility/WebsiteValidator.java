package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebsiteValidator {

    private static final String WEBSITE_REGEX =
            "^(http://|https://)?(www\\.)?[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+(.*)?$";

    private static final Pattern pattern = Pattern.compile(WEBSITE_REGEX);

    public static boolean isWebsiteValid(String website) {
        if (website == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(website);
        return matcher.matches();
    }
}

