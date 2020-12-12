package com.qualitypointtech.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class  RandomStringGenerator {
public String userNameGeneration()
	{
	String randomString=RandomStringUtils.randomAlphabetic(7);
	return randomString;
	}
public String emailGeneration()
	{
	String randomString=RandomStringUtils.randomAlphabetic(7);
	String email1=randomString+"@gmail.com";
	return email1;
	}
}