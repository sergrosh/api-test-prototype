package com.intentwise.util.predicate.filter.base;

import java.util.function.Predicate;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;

public abstract class FilterPredicate implements Predicate<SPKeyword> {
    protected static final String UNSUPPORTED_OPERATOR = "Unsupported operator was provided";
    private final FilterOperator operator;
    private final SPKeywordFilter filter;

    public FilterPredicate(FilterOperator operator, SPKeywordFilter filter) {
        this.operator = operator;
        this.filter = filter;
    }

    public FilterOperator getOperator() {
        return operator;
    }

    public SPKeywordFilter getFilter() {
        return filter;
    }
}
