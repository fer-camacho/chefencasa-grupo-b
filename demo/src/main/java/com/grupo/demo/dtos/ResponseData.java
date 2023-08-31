package com.grupo.demo.dtos;

public class ResponseData<T> {
	    protected T data;
	    protected String message;

	    public boolean isEmptyData(){
	        return data == null;
	    }
}
