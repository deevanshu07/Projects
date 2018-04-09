package com.infy.model.mapasobject;
import java.util.*;
public class Employee {
private int id;
private String name;
private Map benefits;
public Employee() {
}
public void setId(int i) {
id = i;
}
public int getId() {
return id;
}
public void setName(String s) {
name = s;
}
public String getName() {
return name;
}
public void setBenefits(Map m) {
benefits = m;
}
public Map getBenefits() {
return benefits;
}
}
