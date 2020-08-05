package com.intentwise.util.predicate.filter;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.filter.base.IntegerFilterPredicate;

public class ImpressionFilterPredicate extends IntegerFilterPredicate {

    public ImpressionFilterPredicate(FilterOperator operator, SPKeywordFilter filter) {
        super(operator, filter);
    }

    @Override
    public boolean test(SPKeyword spKeyword) {
        if (spKeyword.getImpressions() == null) {
            return false;
        }
        return testIntegerValue(spKeyword.getImpressions());
    }
}
