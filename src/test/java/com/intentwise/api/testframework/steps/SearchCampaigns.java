package com.intentwise.api.testframework.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intentwise.api.testframework.IntentwiseEndpoints;
import com.intentwise.model.CampaignFilter;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchCampaigns {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Step("Search campaigns")
    public void withFilters(String filters) {
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("X-AUTH-TOKEN", "003e7671-5a53-4423-b8a0-8630f37aa8d4")
                .body(filters)
                .when()
                .post(IntentwiseEndpoints.CAMPAIGNS_PREDEFINED.getUrl());
    }

    @Step("Transform filters to json string")
    public String transformFiltersToJsonString(List<Map<String, String>> campaignFilters) throws JsonProcessingException {
        if (!CollectionUtils.isEmpty(campaignFilters)) {
            List<Map<String, Object>> modifiedFilters = new ArrayList<>();
            campaignFilters.forEach(filter -> {
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
    public List<CampaignFilter> transformFilters(List<Map<String, String>> campaignFilters) {
        List<CampaignFilter> transformedFilters = new ArrayList<>();
        for (Map<String, String> filter : campaignFilters) {
            transformedFilters.add(objectMapper.convertValue(filter, CampaignFilter.class));
        }
        return transformedFilters;
    }

}
