package com.grupo.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
	    protected T data;
	    protected String message;

	public boolean isEmptyData(){
	        return data == null;
	    }
}
