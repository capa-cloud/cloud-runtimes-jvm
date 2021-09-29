package group.rxcloud.cloudruntimes.domain.enhanced.metrics;

public class OnEventRequest {

    private String appId;
    private Event event;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
