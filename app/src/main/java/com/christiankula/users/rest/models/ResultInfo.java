package com.christiankula.users.rest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo {

    @JsonProperty("seed")
    private String seed;

    @JsonProperty("results")
    private int resultsCount;

    @JsonProperty("page")
    private int page;

    @JsonProperty("version")
    private String version;

    @JsonProperty("seed")
    public String getSeed() {
        return seed;
    }

    @JsonProperty("seed")
    public void setSeed(String seed) {
        this.seed = seed;
    }

    @JsonProperty("results")
    public int getResultsCount() {
        return resultsCount;
    }

    @JsonProperty("results")
    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    @JsonProperty("page")
    public int getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }
}
