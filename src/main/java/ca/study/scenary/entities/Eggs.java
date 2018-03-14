/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.study.scenary.entities;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")

/**
 *
 * @author alessandro
 */
public class Eggs {
   private int days = 0;
   private Date executionTime;
   
   public Eggs(){
   	super();
       this.executionTime = new Date();
 	}
   
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    
    public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

   
}
