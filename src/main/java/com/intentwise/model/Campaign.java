package com.intentwise.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "averageCpc",
        "ctr",
        "roas",
        "acos",
        "conversionRate",
        "id",
        "recommendedBidCount",
        "analysisDate",
        "portfolioId",
        "portfolioName",
        "adgroup",
        "campaign",
        "keywordText",
        "matchType",
        "currentBid",
        "campaignId",
        "keywordId",
        "adGroupId",
        "spend",
        "revenue",
        "impressions",
        "clicks",
        "state",
        "createdDate",
        "targetAcos",
        "conversions",
        "orders"
})
public class Campaign {

    @JsonProperty("averageCpc")
    private String averageCpc;
    @JsonProperty("ctr")
    private String ctr;
    @JsonProperty("roas")
    private String roas;
    @JsonProperty("acos")
    private String acos;
    @JsonProperty("conversionRate")
    private String conversionRate;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("recommendedBidCount")
    private Integer recommendedBidCount;
    @JsonProperty("analysisDate")
    private Long analysisDate;
    @JsonProperty("portfolioId")
    private String portfolioId;
    @JsonProperty("portfolioName")
    private String portfolioName;
    @JsonProperty("adgroup")
    private String adgroup;
    @JsonProperty("campaign")
    private String campaign;
    @JsonProperty("keywordText")
    private String keywordText;
    @JsonProperty("matchType")
    private String matchType;
    @JsonProperty("currentBid")
    private String currentBid;
    @JsonProperty("recommendedBid")
    private String recommendedBid;
    @JsonProperty("campaignId")
    private String campaignId;
    @JsonProperty("keywordId")
    private String keywordId;
    @JsonProperty("adGroupId")
    private String adGroupId;
    @JsonProperty("spend")
    private String spend;
    @JsonProperty("revenue")
    private String revenue;
    @JsonProperty("impressions")
    private Integer impressions;
    @JsonProperty("clicks")
    private Integer clicks;
    @JsonProperty("state")
    private String state;
    @JsonProperty("createdDate")
    private Long createdDate;
    @JsonProperty("targetAcos")
    private Integer targetAcos;
    @JsonProperty("conversions")
    private Integer conversions;
    @JsonProperty("orders")
    private Integer orders;

    @JsonProperty("averageCpc")
    public String getAverageCpc() {
        return averageCpc;
    }

    @JsonProperty("averageCpc")
    public void setAverageCpc(String averageCpc) {
        this.averageCpc = averageCpc;
    }

    @JsonProperty("ctr")
    public String getCtr() {
        return ctr;
    }

    @JsonProperty("ctr")
    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    @JsonProperty("roas")
    public String getRoas() {
        return roas;
    }

    @JsonProperty("roas")
    public void setRoas(String roas) {
        this.roas = roas;
    }

    @JsonProperty("acos")
    public String getAcos() {
        return acos;
    }

    @JsonProperty("acos")
    public void setAcos(String acos) {
        this.acos = acos;
    }

    @JsonProperty("conversionRate")
    public String getConversionRate() {
        return conversionRate;
    }

    @JsonProperty("conversionRate")
    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("recommendedBidCount")
    public Integer getRecommendedBidCount() {
        return recommendedBidCount;
    }

    @JsonProperty("recommendedBidCount")
    public void setRecommendedBidCount(Integer recommendedBidCount) {
        this.recommendedBidCount = recommendedBidCount;
    }

    @JsonProperty("analysisDate")
    public Long getAnalysisDate() {
        return analysisDate;
    }

    @JsonProperty("analysisDate")
    public void setAnalysisDate(Long analysisDate) {
        this.analysisDate = analysisDate;
    }

    @JsonProperty("portfolioId")
    public String getPortfolioId() {
        return portfolioId;
    }

    @JsonProperty("portfolioId")
    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    @JsonProperty("portfolioName")
    public String getPortfolioName() {
        return portfolioName;
    }

    @JsonProperty("portfolioName")
    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    @JsonProperty("adgroup")
    public String getAdgroup() {
        return adgroup;
    }

    @JsonProperty("adgroup")
    public void setAdgroup(String adgroup) {
        this.adgroup = adgroup;
    }

    @JsonProperty("campaign")
    public String getCampaign() {
        return campaign;
    }

    @JsonProperty("campaign")
    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    @JsonProperty("keywordText")
    public String getKeywordText() {
        return keywordText;
    }

    @JsonProperty("keywordText")
    public void setKeywordText(String keywordText) {
        this.keywordText = keywordText;
    }

    @JsonProperty("matchType")
    public String getMatchType() {
        return matchType;
    }

    @JsonProperty("matchType")
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @JsonProperty("currentBid")
    public String getCurrentBid() {
        return currentBid;
    }

    @JsonProperty("currentBid")
    public void setCurrentBid(String currentBid) {
        this.currentBid = currentBid;
    }

    @JsonProperty("recommendedBid")
    public String getRecommendedBid() {
        return recommendedBid;
    }

    @JsonProperty("recommendedBid")
    public void setRecommendedBid(String recommendedBid) {
        this.recommendedBid = recommendedBid;
    }

    @JsonProperty("campaignId")
    public String getCampaignId() {
        return campaignId;
    }

    @JsonProperty("campaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    @JsonProperty("keywordId")
    public String getKeywordId() {
        return keywordId;
    }

    @JsonProperty("keywordId")
    public void setKeywordId(String keywordId) {
        this.keywordId = keywordId;
    }

    @JsonProperty("adGroupId")
    public String getAdGroupId() {
        return adGroupId;
    }

    @JsonProperty("adGroupId")
    public void setAdGroupId(String adGroupId) {
        this.adGroupId = adGroupId;
    }

    @JsonProperty("spend")
    public String getSpend() {
        return spend;
    }

    @JsonProperty("spend")
    public void setSpend(String spend) {
        this.spend = spend;
    }

    @JsonProperty("revenue")
    public String getRevenue() {
        return revenue;
    }

    @JsonProperty("revenue")
    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    @JsonProperty("impressions")
    public Integer getImpressions() {
        return impressions;
    }

    @JsonProperty("impressions")
    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    @JsonProperty("clicks")
    public Integer getClicks() {
        return clicks;
    }

    @JsonProperty("clicks")
    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("createdDate")
    public Long getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("targetAcos")
    public Integer getTargetAcos() {
        return targetAcos;
    }

    @JsonProperty("targetAcos")
    public void setTargetAcos(Integer targetAcos) {
        this.targetAcos = targetAcos;
    }

    @JsonProperty("conversions")
    public Integer getConversions() {
        return conversions;
    }

    @JsonProperty("conversions")
    public void setConversions(Integer conversions) {
        this.conversions = conversions;
    }

    @JsonProperty("orders")
    public Integer getOrders() {
        return orders;
    }

    @JsonProperty("orders")
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign1 = (Campaign) o;
        return Objects.equals(averageCpc, campaign1.averageCpc) &&
                Objects.equals(ctr, campaign1.ctr) &&
                Objects.equals(roas, campaign1.roas) &&
                Objects.equals(acos, campaign1.acos) &&
                Objects.equals(conversionRate, campaign1.conversionRate) &&
                Objects.equals(id, campaign1.id) &&
                Objects.equals(recommendedBidCount, campaign1.recommendedBidCount) &&
                Objects.equals(analysisDate, campaign1.analysisDate) &&
                Objects.equals(portfolioId, campaign1.portfolioId) &&
                Objects.equals(portfolioName, campaign1.portfolioName) &&
                Objects.equals(adgroup, campaign1.adgroup) &&
                Objects.equals(campaign, campaign1.campaign) &&
                Objects.equals(keywordText, campaign1.keywordText) &&
                Objects.equals(matchType, campaign1.matchType) &&
                Objects.equals(currentBid, campaign1.currentBid) &&
                Objects.equals(recommendedBid, campaign1.recommendedBid) &&
                Objects.equals(campaignId, campaign1.campaignId) &&
                Objects.equals(keywordId, campaign1.keywordId) &&
                Objects.equals(adGroupId, campaign1.adGroupId) &&
                Objects.equals(spend, campaign1.spend) &&
                Objects.equals(revenue, campaign1.revenue) &&
                Objects.equals(impressions, campaign1.impressions) &&
                Objects.equals(clicks, campaign1.clicks) &&
                Objects.equals(state, campaign1.state) &&
                Objects.equals(targetAcos, campaign1.targetAcos) &&
                Objects.equals(conversions, campaign1.conversions) &&
                Objects.equals(orders, campaign1.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageCpc, ctr, roas, acos, conversionRate, id, recommendedBidCount, analysisDate, portfolioId, portfolioName, adgroup, campaign, keywordText, matchType, currentBid, recommendedBid, campaignId, keywordId, adGroupId, spend, revenue, impressions, clicks, state, targetAcos, conversions, orders);
    }
}
