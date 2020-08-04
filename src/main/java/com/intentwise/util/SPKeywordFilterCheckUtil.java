package com.intentwise.util;

import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.PredicateFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SPKeywordFilterCheckUtil {

    private SPKeywordFilterCheckUtil() {
    }

    public static boolean matchFilters(List<SPKeyword> spKeywords, List<SPKeywordFilter> filters) {
        if (filters.isEmpty()) {
            return true;
        }
        Predicate<SPKeyword> predicate = buildCampaignPredicate(filters);
        return spKeywords.stream().allMatch(predicate);
    }

    public static List<SPKeyword> filterCampaigns(List<SPKeyword> spKeywords, List<SPKeywordFilter> filters) {
        if (filters.isEmpty()) {
            return spKeywords;
        }
        Predicate<SPKeyword> predicate = buildCampaignPredicate(filters);
        return spKeywords.stream().filter(predicate).collect(Collectors.toList());
    }

    private static Predicate<SPKeyword> buildCampaignPredicate(List<SPKeywordFilter> filters) {
        Predicate<SPKeyword> predicate = PredicateFactory.getCampaignPredicate(filters.get(0));
        if (filters.size() > 1) {
            for (int i = 1; i < filters.size(); i++) {
                predicate = predicate.and(PredicateFactory.getCampaignPredicate(filters.get(i)));
            }
        }
        return predicate;
    }
}
