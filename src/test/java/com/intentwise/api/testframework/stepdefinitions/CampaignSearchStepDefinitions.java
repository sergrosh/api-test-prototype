package com.intentwise.api.testframework.stepdefinitions;

import com.intentwise.api.testframework.steps.SearchCampaigns;
import com.intentwise.model.CampaignFilter;
import com.intentwise.model.CampaignsResponse;
import com.intentwise.util.CampaignFilterCheckUtil;
import com.intentwise.util.MockDataUtil;
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

public class CampaignSearchStepDefinitions {

    @Steps
    private SearchCampaigns searchCampaigns;
    private CampaignsResponse campaignsResponse;
    private String campaignFiltersJson;
    private List<CampaignFilter> campaignFilters;

    @Given("the following campaign filters:")
    public void the_following_campaign_filters(List<Map<String, String>> campaignFilters) throws IOException {
        this.campaignFilters = searchCampaigns.transformFilters(campaignFilters);
        campaignFiltersJson = searchCampaigns.transformFiltersToJsonString(campaignFilters);
    }

    @Given("no campaign filters")
    public void no_campaign_filters() {
        this.campaignFilters = Collections.emptyList();
        campaignFiltersJson = "";
    }

    @When("I search campaigns")
    public void i_search_campaigns() {
        searchCampaigns.withFilters(campaignFiltersJson);
        campaignsResponse = SerenityRest.lastResponse().getBody().as(CampaignsResponse.class);
    }

    @Then("the returned campaigns should match the criterias")
    public void the_returned_campaigns_should_match_criterias() {
        restAssuredThat(response -> response.statusCode(200));
        Assert.assertTrue(CampaignFilterCheckUtil.matchFilters(campaignsResponse.getContent(), campaignFilters));
    }

    @Then("the returned campaign response should match the mock response")
    public void the_returned_campaigns_should_match_mock_response() throws IOException, URISyntaxException {
        Assert.assertTrue(MockDataUtil.matchMockCampaignResponse(campaignsResponse, "data/mock_response.json"));
    }

}
