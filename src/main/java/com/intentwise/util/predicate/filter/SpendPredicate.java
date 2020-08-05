package com.intentwise.util.predicate.filter;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.filter.base.DoubleFilterPredicate;

public class SpendPredicate extends DoubleFilterPredicate {

    public SpendPredicate(FilterOperator operator, SPKeywordFilter filter) {
        super(operator, filter);
    }

    @Override
    public boolean test(SPKeyword spKeyword) {
        if (spKeyword.getSpend() == null)
            return false;
        return testDoubleValue(spKeyword.getSpend());
    }
}
