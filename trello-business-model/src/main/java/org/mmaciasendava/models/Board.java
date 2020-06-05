package org.mmaciasendava.models;
import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"name", "description", "dateLastActivity", "creationMethod", "id", "url", "dateLastView", "shortUrl" })
public class Board {
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String description;
    @JsonProperty("dateLastActivity")
    private String dateLastActivity;
    @JsonProperty("creationMethod")
    private String creationMethod;
    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("dateLastView")
    private String dateLastView;
    @JsonProperty("shortUrl")
    private String shortUrl;
}
