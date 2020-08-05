package com.intentwise.util.predicate.filter;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.filter.base.FilterPredicate;

public class CampaignIdFilterPredicate extends FilterPredicate {

    public CampaignIdFilterPredicate(FilterOperator operator, SPKeywordFilter filter) {
        super(operator, filter);
    }

    @Override
    public boolean test(SPKeyword spKeyword) {
        if (spKeyword.getCampaignId() == null) {
            return false;
        }
        if (getOperator() == FilterOperator.EQUAL) {
            return spKeyword.getCampaignId().equals(getFilter().getValue());
        }
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
    }
}
