package com.intentwise.util.predicate.filter.base;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeywordFilter;

public abstract class DoubleFilterPredicate extends FilterPredicate {
    public DoubleFilterPredicate(FilterOperator operator, SPKeywordFilter filter) {
        super(operator, filter);
    }

    protected boolean testDoubleValue(String valueString) {
        double value;
        double filterValue;
        try {
            value = Double.parseDouble(valueString);
            filterValue = Double.parseDouble(getFilter().getValue());
        } catch (NumberFormatException ex) {
            return false;
        }
        switch (getOperator()) {
            case EQUAL:
                return value == filterValue;
            case GREATER_THAN:
                return value > filterValue;
            case GREATER_THAN_OR_EQUAL:
                return value >= filterValue;
            case LESS_THAN:
                return value < filterValue;
            case LESS_THAN_OR_EQUAL:
                return value <= filterValue;
            default:
                throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
        }
    }
}
