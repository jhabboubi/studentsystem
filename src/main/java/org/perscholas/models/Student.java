package org.perscholas.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.hibernate.validator.constraints.Length;


import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
public class Student implements Serializable {
    private static final long serialVersionUID = 7187406997016008864L;
    //fields

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sId;

    @Length(min = 3, max = 25, message = "should be between {1} and {2}")
    @NotBlank(message = "Enter something") //@Size(min = 3, max = 25, message = "should be between {1} and {2}")
    String sUsername;
    @Email(regexp = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b",message = "Invalid email address")
    String sEmail;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "- at least 8 characters\n- must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number\n- Can contain special characters")
    String sPassword;

    @PostConstruct
    public void postConstruct(){
        log.warning("student constructed!");
    }
}
