package javaLanguage.interfaces.defaultMethods;

import java.time.ZonedDateTime;

public interface HandleInvalidTimeZoneClient extends TimeClient {
    // Any class that implements the interface HandleInvalidTimeZoneClient will use the implementation of
    // getZonedDateTime specified by this interface instead of the one specified by the interface TimeClient.

    /**
     * When you extend an interface that contains a default method, you can do the following:
     * <p>
     * 1)Not mention the default method at all, which lets your extended interface inherit the default method.
     * 2)Redeclare the default method, which makes it abstract.
     */
    ZonedDateTime getZonedDateTime(String zoneString);

    // 3)Redefine the default method, which overrides it.
//    default ZonedDateTime getZonedDateTime(String zoneString) {
//        try {
//            return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
//        } catch (DateTimeException e) {
//            System.err.println("Invalid zone ID: " + zoneString +
//                    "; using the default time zone instead.");
//            return ZonedDateTime.of(getLocalDateTime(), ZoneId.systemDefault());
//        }
//    }

}
