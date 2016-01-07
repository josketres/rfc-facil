package com.josketres.rfcfacil;

// based on the non-published library spanish-numbers
// https://github.com/josketres/spanish-numbers
class SpanishNumbers {

    public static String cardinal(long number) {

        DigitList context = new DigitList(number);

        return (new SixthPeriod(context.periods[5]).format() +
                new FifthPeriod(context.periods[4], context.periodSize).format() +
                new FourthPeriod(context.periods[3]).format() +
                new ThirdPeriod(context.periods[2], context).format() +
                new SecondPeriod(context.periods[1]).format() +
                new FirstPeriod(context.periods[0], context.periodSize).format()).trim();
    }

}

class DigitList {

    public static final int MAX_COUNT = 19; // == Long.toString(Long.MAX_VALUE).length()
    private static final int MAX_PERIODS = 7; // == Math.ceil(MAX_COUNT / 3)

    public final char[] digits = new char[MAX_COUNT];
    public final long[] periods = new long[MAX_PERIODS];
    public final int periodSize;

    {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = '0';
        }
    }

    public DigitList(long number) {
        char[] chars = Long.toString(number).toCharArray();
        System.arraycopy(chars, 0, digits, digits.length - chars.length, chars.length);
        buildPeriods();
        periodSize = getPeriodSize();
    }

    private void buildPeriods() {
        periods[6] = Long.valueOf(String.valueOf(digits[0]));
        for (int i = 3; i < digits.length; i += 3) {
            int index = 6 - (i / 3);
            periods[index] = Long.valueOf(String.valueOf(digits[i - 2]) + String.valueOf(digits[i - 1]) + String.valueOf(digits[i]));
        }
    }

    private int getPeriodSize() {
        int size = periods.length;
        for (int i = size - 1; i >= 0; i--) {
            if (periods[i] == 0) {
                size--;
            } else {
                return size;
            }
        }
        return size;
    }
}


class FirstPeriod {

    private static final String[] UNIT = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
    private static final String[] TENS = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    private static final String[] CENTS = {"ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};
    private static final String[] TWO_DIGITS_CARDINAL_11_TO_29 = {"once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
    private static final String[] TWENTIES = {"veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"};

    private final int units;
    private final int tens;
    private final int cents;
    private final int periodSize;

    public FirstPeriod(long number, int periodSize) {
        this.periodSize = periodSize;

        units = (int) number % 10;
        tens = (int) (number / 10) % 10;
        cents = (int) (number / 100) % 10;
    }

    public String format() {
        return formatCents() + formatTens() + formatUnits();
    }

    private String formatCents() {

        if (cents == 0) {
            return "";
        } else if (cents == 1 && tens == 0 && units == 0) {
            return "cien";
        } else {
            return CENTS[cents - 1] + ((tens != 0 || units != 0) ? " " : "");
        }
    }

    private String formatTens() {

        if (tens == 0) {
            return "";
        } else if (units == 0) {
            return TENS[tens - 1];
        } else if (tens == 1) {
            return TWO_DIGITS_CARDINAL_11_TO_29[units - 1];
        } else if (tens == 2) {
            return TWENTIES[units - 1];
        } else {
            return TENS[tens - 1] + " y ";
        }
    }

    private String formatUnits() {

        if (tens == 1 || tens == 2) {
            return "";
        } else if ((tens != 0 || cents != 0) && units == 0) {
            return "";
        } else if (periodSize > 1 && units == 0) {
            return "";
        } else {
            return UNIT[units];
        }
    }
}


class SecondPeriod {

    private final long number;

    public SecondPeriod(long number) {
        this.number = number;
    }

    public String format() {
        if (number == 0) {
            return "";
        } else if (number == 1) {
            return "mil ";
        } else {
            return new FirstPeriod(number, 1).format() + " mil ";
        }
    }
}


class ThirdPeriod {
    private final long number;
    private final DigitList context;

    public ThirdPeriod(long number, DigitList context) {
        this.number = number;
        this.context = context;
    }

    public String format() {
        if (number == 0 && context.periods[3] != 0) {
            return "millones ";
        } else if (number == 0) {
            return "";
        } else if (number == 1) {
            return "un millón ";
        } else {
            return new FirstPeriod(number, 1).format() + " millones ";
        }
    }
}


class FourthPeriod {
    private final long number;

    public FourthPeriod(long number) {
        this.number = number;
    }

    public String format() {

        return new SecondPeriod(number).format();
    }
}


class FifthPeriod {
    private final long number;
    private final int periodSize;

    public FifthPeriod(long number, int periodSize) {
        this.periodSize = periodSize;
        this.number = number;
    }

    public String format() {
        if (number == 0 && periodSize > 5) {
            return "billones ";
        } else if (number == 0) {
            return "";
        } else if (number == 1) {
            return "un billón ";
        } else {
            return new FirstPeriod(number, 1).format() + " billones ";
        }
    }
}

class SixthPeriod {
    private final long number;

    public SixthPeriod(long number) {
        this.number = number;
    }

    public String format() {
        return new SecondPeriod(number).format();
    }
}