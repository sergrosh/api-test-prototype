package com.intentwise.util.predicate;

import com.intentwise.model.Campaign;
import com.intentwise.model.CampaignFilter;
import com.intentwise.model.FilterOperator;
import com.intentwise.model.FilterType;

import java.util.function.Predicate;

public class PredicateFactory {

    private static final String UNSUPPORTED_OPERATOR = "Unsupported operator was provided";

    private PredicateFactory() {
    }

    /**
     * Get campaign predicate based on provided filter.
     *
     * @param campaignFilter campaign filter
     * @return campaign predicate
     */
    public static Predicate<Campaign> getCampaignPredicate(CampaignFilter campaignFilter) {
        FilterType type = FilterType.valueOf(campaignFilter.getName().toUpperCase());
        FilterOperator operator = FilterOperator.valueOf(campaignFilter.getOperator().toUpperCase());
        switch (type) {
            case IMPRESSIONS:
                switch (operator) {
                    case EQUAL:
                        return campaign ->
                                campaign.getImpressions().equals(Integer.valueOf(campaignFilter.getValue()));
                    case GREATER_THAN:
                        return campaign ->
                                campaign.getImpressions() > (Integer.parseInt(campaignFilter.getValue()));
                    case LESS_THAN:
                        return campaign ->
                                campaign.getImpressions() < (Integer.parseInt(campaignFilter.getValue()));
                    default:
                        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
                }
            case SPEND:
                switch (operator) {
                    case EQUAL:
                        return campaign ->
                                Double.parseDouble(campaign.getSpend()) == (Double.parseDouble(campaignFilter.getValue()));
                    case GREATER_THAN:
                        return campaign ->
                                Double.parseDouble(campaign.getSpend()) > (Double.parseDouble(campaignFilter.getValue()));
                    case LESS_THAN:
                        return campaign ->
                                Double.parseDouble(campaign.getSpend()) < (Double.parseDouble(campaignFilter.getValue()));
                    default:
                        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
                }
            case ACOS:
                switch (operator) {
                    case EQUAL:
                        return campaign ->
                                Double.parseDouble(campaign.getAcos()) == (Double.parseDouble(campaignFilter.getValue()));
                    case GREATER_THAN:
                        return campaign ->
                                Double.parseDouble(campaign.getAcos()) > (Double.parseDouble(campaignFilter.getValue()));
                    case LESS_THAN:
                        return campaign ->
                                Double.parseDouble(campaign.getAcos()) < (Double.parseDouble(campaignFilter.getValue()));
                    default:
                        throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
                }
            case CAMPAIGNID:
                if (operator == FilterOperator.EQUAL) {
                    return campaign ->
                            campaign.getCampaignId().equals(campaignFilter.getValue());
                }
                throw new UnsupportedOperationException(UNSUPPORTED_OPERATOR);
            default:
                throw new UnsupportedOperationException("Unsupported campaign filter type was provided");
        }
    }
}
