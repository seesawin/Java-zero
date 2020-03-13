package javaLanguage.interfaces.defaultMethods;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface AbstractZoneTimeClient extends TimeClient {
    // Any class that implements the interface AbstractZoneTimeClient will have to implement the method
    // getZonedDateTime; this method is an abstract method like all other nondefault (and nonstatic)
    // methods in an interface.
    abstract public ZonedDateTime getZonedDateTime(String zoneString);
}

class ZomeTimeClientImpl implements AbstractZoneTimeClient {
    @Override
    public void setTime(int hour, int minute, int second) {

    }

    @Override
    public void setDate(int day, int month, int year) {

    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {

    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return null;
    }

    // Any class that implements the interface AbstractZoneTimeClient will have to implement the method getZonedDateTime;
    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
        return null;
    }
}
