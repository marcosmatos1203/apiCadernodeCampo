package com.cadernodecampo.springcadernodecampo.ControllerExceptionModule;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private List<FieldMessage>errors = new ArrayList<>();
    public ValidationError(){
        super();
    }
    public List<FieldMessage> getErrors() {
        return errors;
    }
    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName,message));
    }
    public ValidationError(long timestamp, Integer status, String error){
        super(timestamp,status,error);
    }
}
