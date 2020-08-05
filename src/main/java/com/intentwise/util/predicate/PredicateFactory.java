package com.intentwise.util.predicate;

import com.intentwise.model.FilterOperator;
import com.intentwise.model.FilterType;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.filter.*;

import java.util.function.Predicate;

public class PredicateFactory {

    private PredicateFactory() {
    }

    /**
     * Get SPKeyword predicate based on provided filter.
     *
     * @param filter spKeyword filter
     * @return spKeyword predicate
     */
    public static Predicate<SPKeyword> getSPKeywordPredicate(SPKeywordFilter filter) {
        FilterType type = FilterType.valueOf(filter.getName().toUpperCase());
        FilterOperator operator = FilterOperator.valueOf(filter.getOperator().toUpperCase());
        switch (type) {
            case IMPRESSIONS:
                return new ImpressionFilterPredicate(operator, filter);
            case SPEND:
                return new SpendPredicate(operator, filter);
            case ACOS:
                return new AcosFilterPredicate(operator, filter);
            case CAMPAIGNID:
                return new CampaignIdFilterPredicate(operator, filter);
            case AVERAGECPC:
                return new AverageCpcFilterPredicate(operator, filter);
            default:
                throw new UnsupportedOperationException("Unsupported spKeyword filter type was provided");
        }
    }
}
