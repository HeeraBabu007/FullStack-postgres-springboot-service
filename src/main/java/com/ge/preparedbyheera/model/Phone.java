/**
 * 
 */
package com.ge.preparedbyheera.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Heera Babu
 *
 */
@Entity
public class Phone {
	@Id
	@GeneratedValue
	private Long id;
	String number;
	
	public static boolean isValid(String number) 
	{ 
	    // 1) Begins with 0 or 91 	    // 2) Then contains 7 or 8 or 9. 	    // 3) Then contains 9 digits 
	    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 	  
	    Matcher m = p.matcher(number); 
	    return (m.find() && m.group().equals(number)); 
	}

	public Phone() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
	    if (isValid(number))  
			this.number = number;
	    else
			this.number = "Invalid Number";
	}

}