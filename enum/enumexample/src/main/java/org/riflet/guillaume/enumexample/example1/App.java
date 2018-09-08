package org.riflet.guillaume.enumexample.example1;

/**
 * This demo exemplifies how the properties enumerator class can act as a database for properties
 * and how it can generate templates of the properties files set with default values.
 *
 */
public class App {
	public static void main(String[] args) {

		for (EnumProperty.EnumPropertyFile f : EnumProperty.EnumPropertyFile.values()) {
			System.out.println("./" + f.file());
			System.out.println(EnumProperty.lines(f));
		}

		System.out.println("FILENAME, PROPERTY KEY.NAME=VALUE, \"PROPERTY DESCRIPTION.\", MANDATORY");
		System.out.println(EnumProperty.dump());
	}
}
