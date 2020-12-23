package io.github.hooj0.generic.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 学校
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:19:20
 */
public class School {
	enum Class {
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN;
	}
	
	enum Grade {
		A, B, C, D, E, F, G
	}
	
	private final Class classes;
	private final Grade grade;
	
	private School(Class classes, Grade grade) {
		this.classes = classes;
		this.grade = grade;
	}
	
	public Class classes() {
		return this.classes;
	}
	
	public Grade grade() {
		return this.grade;
	}
	
	public String toString() {
		return grade + " (" + classes + ")";
	}
	
	private final static List<School> schools = new ArrayList<School>();
	
	static {
		for (Class c : Class.values()) {
			for (Grade g : Grade.values()) {
				schools.add(new School(c, g));
			}
		}
	}
	
	public static List<School> getSchools() {
		//return new ArrayList<School>(schools);
		return schools;
	}
	
	public static void main(String[] args) {
		for (School s : getSchools()) {
			System.out.println(s);
		}
	}
}
