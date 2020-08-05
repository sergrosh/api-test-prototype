package com.intentwise.util.predicate.filter.base;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeywordFilter;

public abstract class IntegerFilterPredicate extends FilterPredicate {
    public IntegerFilterPredicate(FilterOperator operator, SPKeywordFilter filter) {
        super(operator, filter);
    }

    protected boolean testIntegerValue(int value) {
        int filterValue;
        try {
            filterValue = Integer.parseInt(getFilter().getValue());
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
