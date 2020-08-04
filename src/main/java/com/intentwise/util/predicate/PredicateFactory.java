package com.intentwise.util.predicate;

import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.model.FilterOperator;
import com.intentwise.model.FilterType;

import java.util.function.Predicate;

public class PredicateFactory {

    private static final String UNSUPPORTED_OPERATOR = "Unsupported operator was provided";

    private PredicateFactory() {
    }

    /**
     * Get SPKeyword predicate based on provided filter.
     *
     * @param spKeywordFilter spKeyword filter
     * @return spKeyword predicate
     */
    public static Predicate<SPKeyword> getCampaignPredicate(SPKeywordFilter spKeywordFilter) {
        FilterType type = FilterType.valueOf(spKeywordFilter.getName().toUpperCase());
        FilterOperator operator = FilterOperator.valueOf(spKeywordFilter.getOperator().toUpperCase());
        switch (type) {
            case IMPRESSIONS:
                switch (operator) {
                    case EQUAL:
                        return spKeyword ->
                                spKeyword.getImpressions().equals(Integer.valueOf(spKeywordFilter.getValue()));
                    case GREATER_THAN:
                        return spKeyword ->
                                spKeyword.getImpressions() > (Integer.parseInt(spKeywordFilter.getValue()));
                    case LESS_THAN:
                        return spKeyword ->
                                spKeyword.getImpressions() < (Integer.parseInt(spKeywordFilter.getValue()));
                    default:
                        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
                }
            case SPEND:
                switch (operator) {
                    case EQUAL:
                        return spKeyword ->
                                Double.parseDouble(spKeyword.getSpend()) == (Double.parseDouble(spKeywordFilter.getValue()));
                    case GREATER_THAN:
                        return spKeyword ->
                                Double.parseDouble(spKeyword.getSpend()) > (Double.parseDouble(spKeywordFilter.getValue()));
                    case LESS_THAN:
                        return spKeyword ->
                                Double.parseDouble(spKeyword.getSpend()) < (Double.parseDouble(spKeywordFilter.getValue()));
                    default:
                        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
                }
            case ACOS:
                switch (operator) {
                    case EQUAL:
                        return spKeyword ->
                                Double.parseDouble(spKeyword.getAcos()) == (Double.parseDouble(spKeywordFilter.getValue()));
                    case GREATER_THAN:
                        return spKeyword ->
                                Double.parseDouble(spKeyword.getAcos()) > (Double.parseDouble(spKeywordFilter.getValue()));
                    case LESS_THAN:
                        return spKeyword ->
                                Double.parseDouble(spKeyword.getAcos()) < (Double.parseDouble(spKeywordFilter.getValue()));
                    default:
                        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
                }
            case CAMPAIGNID:
                if (operator == FilterOperator.EQUAL) {
                    return spKeyword ->
                            spKeyword.getCampaignId().equals(spKeywordFilter.getValue());
                }
                throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
            default:
                throw new UnsupportedOperationException("Unsupported spKeyword filter type was provided");
        }
    }
}
