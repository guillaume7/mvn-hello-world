package org.riflet.guillaume.enumexample.example1;


public enum EnumProperties {
 
  /* PROPERTY FILE, KEY, PROPERTY NAME, DEFAULT VALUE, DESCRIPTION */
  LOGFILE 	("default.properties", "org.riflet.guillaume.enumexample", "logfile", "enumApp.log", "Log filename and location"),
  MATCHPATTERN 	("default.properties", "org.riflet.guillaume.enumexample", "matchPattern", "([0-9]{4}-[0-9]{2}-[0-9]{2})", "Regex matcher pattern to identify events to process.");

  private final String file;
  private final String key;
  private final String property;
  private final String defaultValue;
  private final String description;

  EnumProperties(String file, String key, String property, String defaultValue, String description) {
    this.file = file;
    this.key = key;
    this.property = property;
    this.defaultValue = defaultValue;
    this.description = description;
  }

  private String file() { return file; }
  private String key() { return key; }
  private String property() { return property; }
  private String defaultValue() { return defaultValue; }
  private String description() { return description; }

  public void print() {
    System.out.println("file: " + file() + "\n" + "property: " + key() + "." + property() + "=" + defaultValue() + "\n" + "description: " + description());
  }

  private enum EnumFiles {
    DEFAULTPROPERTIES ("default.properties");

    private final String file;

    EnumFiles(String file) {
      this.file = file;
    }

  }

  private enum EnumKeys {
    ENUMEXAMPLE ("org.riflet.guillaume.enumexample");
  
    private final String key;

    EnumKeys(String key) {
      this.key = key;
    }

  }

}
