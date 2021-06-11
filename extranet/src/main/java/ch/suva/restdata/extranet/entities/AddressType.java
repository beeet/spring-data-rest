package ch.suva.restdata.extranet.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressType {
    
    PRIVATE("privat"),
    OFFICE("geschaeft");
    
    @JsonValue // Remark: printout the value instead of the type
    private String text;
    
    AddressType(String text) {
        this.text = text;
    }
    
}
