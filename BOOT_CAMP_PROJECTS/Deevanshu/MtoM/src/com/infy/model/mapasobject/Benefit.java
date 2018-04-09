package com.infy.model.mapasobject;

public class Benefit {
private int id;
private int cost;
public Benefit() {
}
public Benefit(int c) {
cost = c;
}
public void setId(int i) {
id = i;
}
public int getId() {
return id;
}
public void setCost(int i) {
cost = i;
}
public int getCost() {
return cost;
}
}