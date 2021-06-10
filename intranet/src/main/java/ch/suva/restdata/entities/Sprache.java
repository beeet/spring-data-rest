package ch.suva.restdata.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sprache {
    DE("deutsch"),
    FR("franzoesisch"),
    IT("italienisch"),
    EN("englisch");
    
    @JsonValue
    private String text;
    
    Sprache(String text) {
        this.text = text;
    }
    
}
