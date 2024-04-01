package market;

public enum DiscountModifier {
    NULL("Normal", 1),

    NEWYERS("New Yers", 0.8),

    WOMENDAY("Women Day", 0.9),

    MENDAY("Men Day", 0.9);
    private final double code;
    private final String value;


    public String getValue() {
        return value;
    }

    DiscountModifier(String value, double code) {
        this.code = code;
        this.value = value;
    }

    public double getCode() {
        return code;
    }
}
