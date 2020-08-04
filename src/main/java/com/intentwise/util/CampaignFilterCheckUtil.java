package com.intentwise.util;

import com.intentwise.model.Campaign;
import com.intentwise.model.CampaignFilter;
import com.intentwise.util.predicate.PredicateFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CampaignFilterCheckUtil {

    private CampaignFilterCheckUtil() {
    }

    public static boolean matchFilters(List<Campaign> campaigns, List<CampaignFilter> filters) {
        if (filters.isEmpty()) {
            return true;
        }
        Predicate<Campaign> predicate = buildCampaignPredicate(filters);
        return campaigns.stream().allMatch(predicate);
    }

    public static List<Campaign> filterCampaigns(List<Campaign> campaigns, List<CampaignFilter> filters) {
        if (filters.isEmpty()) {
            return campaigns;
        }
        Predicate<Campaign> predicate = buildCampaignPredicate(filters);
        return campaigns.stream().filter(predicate).collect(Collectors.toList());
    }

    private static Predicate<Campaign> buildCampaignPredicate(List<CampaignFilter> filters) {
        Predicate<Campaign> predicate = PredicateFactory.getCampaignPredicate(filters.get(0));
        if (filters.size() > 1) {
            for (int i = 1; i < filters.size(); i++) {
                predicate = predicate.and(PredicateFactory.getCampaignPredicate(filters.get(i)));
            }
        }
        return predicate;
    }
}
