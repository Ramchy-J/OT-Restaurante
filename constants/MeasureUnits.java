package constants;

public enum MeasureUnits {
    TABLESPOONS("tbsp"),
    TEASPOONS("tsp"),
    CUPS("cup"),
    GRAMS("g"),
    MILLILITERS("ml"),
    OUNCES("oz"),
    POUNDS("lb"),
    PINTS("pt"),
    QUARTS("qt"),
    LITERS("l");

    private final String abbreviation;

    MeasureUnits(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

