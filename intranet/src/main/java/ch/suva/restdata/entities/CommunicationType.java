package ch.suva.restdata.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CommunicationType {
    
    OFFICE("büro"),
    MOBILE("mobile"),
    URL("web");
    
    @JsonValue
    private String text;
    
    CommunicationType(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}
