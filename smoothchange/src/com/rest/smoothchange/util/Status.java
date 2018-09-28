package com.rest.smoothchange.util;

public enum Status {

	High('H'),
	Medium('M'),
	Low('L');
	
	private char numVal;

	Status(char numVal) {
        this.numVal = numVal;
    }

    public char getNumVal() {
        return numVal;
    }
	
}
