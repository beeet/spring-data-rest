package ch.suva.restdata.entities;

import ch.suva.restdata.converter.AddressTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AddressTypeSerializer.class)
public enum AddressType {
    
    PRIVATE,
    OFFICE
}
