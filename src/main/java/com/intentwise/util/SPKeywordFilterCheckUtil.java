package com.intentwise.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.util.predicate.PredicateFactory;

public class SPKeywordFilterCheckUtil {

    private SPKeywordFilterCheckUtil() {
    }

    public static boolean matchFilters(List<SPKeyword> spKeywords, List<SPKeywordFilter> filters) {
        if (filters.isEmpty()) {
            return true;
        }
        Predicate<SPKeyword> predicate = buildSPKeywordPredicate(filters);
        return spKeywords.stream().allMatch(predicate);
    }

    static List<SPKeyword> filterSPKeywords(List<SPKeyword> spKeywords, List<SPKeywordFilter> filters) {
        if (filters.isEmpty()) {
            return spKeywords;
        }
        Predicate<SPKeyword> predicate = buildSPKeywordPredicate(filters);
        return spKeywords.stream().filter(predicate).collect(Collectors.toList());
    }

    private static Predicate<SPKeyword> buildSPKeywordPredicate(List<SPKeywordFilter> filters) {
        Predicate<SPKeyword> predicate = PredicateFactory.getSPKeywordPredicate(filters.get(0));
        if (filters.size() > 1) {
            for (int i = 1; i < filters.size(); i++) {
                predicate = predicate.and(PredicateFactory.getSPKeywordPredicate(filters.get(i)));
            }
        }
        return predicate;
    }
}
