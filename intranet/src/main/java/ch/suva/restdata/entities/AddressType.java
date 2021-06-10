package ch.suva.restdata.entities;

import ch.suva.restdata.converter.AddressTypeSerializer;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AddressTypeSerializer.class) // Remark: custom serializer
public enum AddressType {
    
    PRIVATE("privat"),
    OFFICE("geschaeft");
    
    @JsonValue // Remark: printout the value instead of the type
    private String text;
    
    AddressType(String text) {
        this.text = text;
    }
    
}
