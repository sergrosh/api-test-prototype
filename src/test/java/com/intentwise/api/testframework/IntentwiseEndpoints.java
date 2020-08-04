package com.intentwise.api.testframework;

public enum IntentwiseEndpoints {
    CAMPAIGNS_PREDEFINED("https://api.intentwise.com/organization/10390/account/10350/recommendation/keywordbids?campaignType=Sponsored%20Products&page=0&size=10000&sort=spend,desc&startDate=2020-03-01&endDate=2020-03-14&version=V2");

    private final String url;

    IntentwiseEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
