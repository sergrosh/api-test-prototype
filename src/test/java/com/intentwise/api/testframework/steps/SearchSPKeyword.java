package com.intentwise.api.testframework.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intentwise.api.testframework.IntentwiseEndpoints;
import com.intentwise.model.SPKeywordFilter;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSPKeyword {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Step("Search SPKeywords")
    public void withFilters(String filters) {
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("X-AUTH-TOKEN", System.getProperty("auth-token"))
                .body(filters)
                .when()
                .post(IntentwiseEndpoints.SEARCH_SP_KEYWORDS.getUrl());
    }

    @Step("Transform filters to json string")
    public String transformFiltersToJsonString(List<Map<String, String>> spKeywordFilters) throws JsonProcessingException {
        if (!CollectionUtils.isEmpty(spKeywordFilters)) {
            List<Map<String, Object>> modifiedFilters = new ArrayList<>();
            spKeywordFilters.forEach(filter -> {
                Map<String, Object> modifiedFilter = new HashMap<>(filter);
                if (filter.containsKey("value")) {
                    modifiedFilter.put("value", List.of(filter.get("value").split(",")));
                }
                modifiedFilters.add(modifiedFilter);
            });
            return objectMapper.writeValueAsString(modifiedFilters);
        }
        return "";
    }

    @Step("Transform filters")
    public List<SPKeywordFilter> transformFilters(List<Map<String, String>> spKeywordFilters) {
        List<SPKeywordFilter> transformedFilters = new ArrayList<>();
        for (Map<String, String> filter : spKeywordFilters) {
            transformedFilters.add(objectMapper.convertValue(filter, SPKeywordFilter.class));
        }
        return transformedFilters;
    }

}
