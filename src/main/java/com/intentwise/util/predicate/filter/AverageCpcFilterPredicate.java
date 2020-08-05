package com.intentwise.util.predicate.filter;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.filter.base.DoubleFilterPredicate;

public class AverageCpcFilterPredicate extends DoubleFilterPredicate {
    public AverageCpcFilterPredicate(FilterOperator operator, SPKeywordFilter filter) {
        super(operator, filter);
    }

    @Override
    public boolean test(SPKeyword spKeyword) {
        if (spKeyword.getAverageCpc() == null) {
            return false;
        }
        return testDoubleValue(spKeyword.getAverageCpc());
    }
}
