package net.javaguides.springboot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class rnotfound extends RuntimeException{
	private static final long serialVersionUID=17;
	private String resourcename;
	private String fieldname;
	private Object fieldvalue;
	

    public rnotfound(String resourcename,String fieldname,Object fieldvalue){
        super(String.format("%s not found with %s :'%s'",resourcename,fieldname,fieldvalue));
        this.resourcename=resourcename;
        this.fieldname=fieldname;
        this.fieldvalue=fieldvalue;
        
    }
    public String getresourcename()
    {
    	return resourcename;
    	
    }
    public String getfieldname()
    {
    	return fieldname;
    	
    }
    public Object getfieldvalue()
    {
    	return fieldvalue;
    	
    }
    
}