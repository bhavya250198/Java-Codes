/**
 * 
 */
package data.java;
import java.sql.*;
import java.io.*;
import java.util.*;
public class Employees
{
	private int cid;
	private String name;
	private String lastname;
	private int salary;
	 public int getcustomerid()
	 {
	   return cid;
	 }
	 public void setcustomerid(int cid)
	 {
	  this.cid =cid;
	 }
	 public String getcustomername()
	 {
	   return name;
	 }
	 public void setcustomername(String name)
	 {
	   this.name= name;
	 }
	 public String getcustomerlast()
	 {
		 return lastname;
	 }
	 public void settcustomerlast(String lastname)
	 {
	   this.lastname=lastname;
	 }
	 public int getcustomersalary()
	 {
	   return salary;
	 }
	 public void setcustomersalary(int salary)
	 {
		 this.salary=salary;
	 }
} 
	/**
	 * @param args
	 */
