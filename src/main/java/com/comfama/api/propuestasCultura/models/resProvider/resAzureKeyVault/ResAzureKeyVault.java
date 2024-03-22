package com.comfama.api.propuestasCultura.models.resProvider.resAzureKeyVault;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResAzureKeyVault {
    @SerializedName("value")
    private String value;

    @SerializedName("id")
    private String id;

    @SerializedName("attributes")
    private Attributes attributes;

    @SerializedName("tags")
    private Tags tags;
}
