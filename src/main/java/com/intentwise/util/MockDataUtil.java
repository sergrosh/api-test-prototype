package com.intentwise.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intentwise.model.SPKeyword;
import com.intentwise.model.SPKeywordFilter;
import com.intentwise.model.SPKeywordResponse;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.intentwise.util.SPKeywordFilterCheckUtil.filterSPKeywords;

public class MockDataUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static SPKeywordResponse spKeywordResponse;

    private MockDataUtil() {
    }

    private static SPKeywordResponse getMockedSPKeywordResponse(String filePath) throws IOException, URISyntaxException {
        if (spKeywordResponse == null) {
            URL resource = MockDataUtil.class.getClassLoader().getResource(filePath);
            spKeywordResponse = objectMapper.readValue(Paths.get(resource.toURI()).toFile(), SPKeywordResponse.class);
        }
        return spKeywordResponse;
    }

    public static boolean matchMockSPKeywordResponse(SPKeywordResponse spKeywordResponse, String mockResponseFilePath,
                                                     List<SPKeywordFilter> filters) throws IOException, URISyntaxException {
        SPKeywordResponse mockedSPKeywordResponse = getMockedSPKeywordResponse(mockResponseFilePath);
        List<SPKeyword> filteredMockSPKeywords = filterSPKeywords(mockedSPKeywordResponse.getContent(), filters);
        List<SPKeyword> diff = new ArrayList<>(CollectionUtils.disjunction(spKeywordResponse.getContent(),
                filteredMockSPKeywords));
        return diff.isEmpty();
    }
}
