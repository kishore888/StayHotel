package com.hospitality.common.util;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyDateFormat extends DateFormat {

    private static final List<? extends DateFormat> DATE_FORMATS = Arrays.asList(
        new SimpleDateFormat("dd-MM-yyyy"),
        new SimpleDateFormat("dd-MM-yyyy hh:mm a"),
        new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a"),
        new SimpleDateFormat("dd MMM"),
        new SimpleDateFormat("dd/MM/yyyy"),
        new SimpleDateFormat("dd/MM/yyyy hh:mm a"),
        new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a"));

    @Override
    public StringBuffer format(final Date date, final StringBuffer toAppendTo, final FieldPosition fieldPosition) {
        throw new UnsupportedOperationException("This custom date formatter can only be used to *parse* Dates.");
    }

    @Override
    public Date parse(final String source, final ParsePosition pos) {
        Date res = null;
        for (final DateFormat dateFormat : DATE_FORMATS) {
            if ((res = dateFormat.parse(source, pos)) != null) {
                return res;
            }
        }

        return null;
    }
}
