package ch.suva.restdata.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AddressTypeSerializer.class)
public enum AddressType {
    
    PRIVATE,
    OFFICE
}
