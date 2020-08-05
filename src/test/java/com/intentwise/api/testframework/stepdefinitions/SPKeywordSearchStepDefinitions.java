package com.intentwise.api.testframework.stepdefinitions;

import com.intentwise.api.testframework.steps.SearchSPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.model.SPKeywordResponse;
import com.intentwise.util.MockDataUtil;
import com.intentwise.util.SPKeywordFilterCheckUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SPKeywordSearchStepDefinitions {

    @Steps
    private SearchSPKeyword searchSPKeyword;
    private SPKeywordResponse spKeywordResponse;
    private String spKeywordFiltersJson;
    private List<SPKeywordFilter> spKeywordFilters;

    @Given("the following spkeyword filters:")
    public void the_following_spkeyword_filters(List<Map<String, String>> spKeywordFilters) throws IOException {
        this.spKeywordFilters = searchSPKeyword.transformFilters(spKeywordFilters);
        spKeywordFiltersJson = searchSPKeyword.transformFiltersToJsonString(spKeywordFilters);
    }

    @Given("no spkeyword filters")
    public void no_spkeyword_filters() {
        this.spKeywordFilters = Collections.emptyList();
        spKeywordFiltersJson = "";
    }

    @When("I search spkeywords")
    public void i_search_spkeywords() {
        searchSPKeyword.withFilters(spKeywordFiltersJson);
        spKeywordResponse = SerenityRest.lastResponse().getBody().as(SPKeywordResponse.class);
    }

    @Then("the returned spkeywords should match the criterias")
    public void the_returned_spkeywords_should_match_criterias() {
        restAssuredThat(response -> response.statusCode(200));
        Assert.assertTrue(SPKeywordFilterCheckUtil.matchFilters(spKeywordResponse.getContent(), spKeywordFilters));
    }

    @Then("the returned spkeyword response should match the mock response")
    public void the_returned_spkeywords_should_match_mock_response() throws IOException, URISyntaxException {
        Assert.assertTrue(MockDataUtil.matchMockSPKeywordResponse(spKeywordResponse, "data/mock_response.json", spKeywordFilters));
    }

}
