package org.riflet.guillaume.enumexample.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Enumerado de todas as propriedades para o report automation.
 * 
 * 
 * @author NB19963
 *
 */
public enum EnumProperty {

	/* PROPERTY FILE, KEY, PROPERTY NAME, DEFAULT VALUE, DESCRIPTION, MANDATORY */
	LOG_FILE(EnumPropertyFile.DEFAULT, EnumKey.EXAMPLE, "logfile", "enumApp.log",
			"Log filename and location.", true), 
	MATCH_PATTERN(EnumPropertyFile.DEFAULT, EnumKey.EXAMPLE, "matchPattern",
					"([0-9]{4}-[0-9]{2}-[0-9]{2})", "Regex matcher pattern to identify events to process.", true),
	SPECIAL_TREAT(EnumPropertyFile.SPECIAL, EnumKey.EXAMPLE, "specialTreat",
			"([a-zA-Z.]+)", "Regex matcher pattern to identify special events to process.", true),
	MY_PROPERTY(EnumPropertyFile.SPECIAL, EnumKey.EXAMPLE, "optionalProperty",
			null, "This is my property for no special purpose.", false);

	public enum EnumPropertyFile {
		DEFAULT("default.properties"), SPECIAL("special.properties");

		private final String file;

		EnumPropertyFile(String file) {
			this.file = file;
		}

		public String file() {
			return file;
		}
	}

	public enum EnumKey {
		EXAMPLE("org.riflet.guillaume.keyexample");
		
		private final String key;

		EnumKey(String key) {
			this.key = key;
		}

		public String key() {
			return key;
		}
	}

	private final EnumPropertyFile file;
	private final EnumKey key;
	private final String property;
	private final String defaultValue;
	private final String description;
	private final boolean mandatory;

	EnumProperty(EnumPropertyFile file, EnumKey key, String property, String defaultValue, String description, boolean mandatory) {
		this.file = file;
		this.key = key;
		this.property = property;
		this.defaultValue = defaultValue;
		this.description = description;
		this.mandatory = mandatory;
	}

	private String file() {
		return file.file();
	}

	private String key() {
		return key.key();
	}

	private String property() {
		return property;
	}

	private String fullProperty() {
		return key() + "." + property();
	}

	private String line() {
		if(isMandatory()) {
			return fullProperty() + "=" + defaultValue();
		} else {
			return "#" + fullProperty() + "=" + defaultValue();			
		}
	}

	private String defaultValue() {
		return defaultValue;
	}

	private String description() {
		return description;
	}
	
	private boolean isMandatory() {
		return mandatory;
	}

	public String toString() {
		return file() + ", " + line() + ", \"" + description() + "\", " + isMandatory();
	}

	public static String dump() {
		StringBuilder strBuild = new StringBuilder();
		for (EnumProperty p : EnumProperty.values()) {
			strBuild.append(p.toString()).append("\n");
		}
		return strBuild.toString();
	}

	public static List<EnumProperty> values(EnumPropertyFile file) {
		List<EnumProperty> result = new ArrayList<>();
		for (EnumProperty p : EnumProperty.values()) {
			if (p.file().equals(file.file())) {
				result.add(p);
			}
		}
		return result;
	}

	public static List<EnumProperty> values(EnumPropertyFile file, EnumKey key) {
		List<EnumProperty> result = new ArrayList<>();
		for (EnumProperty p : EnumProperty.values(file)) {
			if (p.key().equals(key.key())) {
				result.add(p);
			}
		}
		return result;
	}

	public static List<EnumProperty> values(EnumKey key) {
		List<EnumProperty> result = new ArrayList<>();
		for (EnumProperty p : EnumProperty.values()) {
			if (p.key().equals(key.key())) {
				result.add(p);
			}
		}
		return result;
	}

	public static String lines(EnumPropertyFile file) {
		StringBuilder str = new StringBuilder();
		for (EnumProperty p : EnumProperty.values(file)) {
			str.append(p.line()).append("\n");
		}
		return str.toString();
	}

}
