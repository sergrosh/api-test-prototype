package com.intentwise.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intentwise.model.Campaign;
import com.intentwise.model.CampaignsResponse;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MockDataUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private MockDataUtil() {
    }

    private static CampaignsResponse getMockedCampaignResponse(String filePath) throws IOException, URISyntaxException {
        URL resource = MockDataUtil.class.getClassLoader().getResource(filePath);
        return objectMapper.readValue(Paths.get(resource.toURI()).toFile(), CampaignsResponse.class);
    }

    public static boolean matchMockCampaignResponse(CampaignsResponse campaignsResponse, String mockResponseFilePath) throws IOException, URISyntaxException {
        CampaignsResponse mockedCampaignResponse = getMockedCampaignResponse(mockResponseFilePath);

        List<Campaign> diff = new ArrayList<>(CollectionUtils.disjunction(campaignsResponse.getContent(), mockedCampaignResponse.getContent()));
        return diff.isEmpty();
    }
}
