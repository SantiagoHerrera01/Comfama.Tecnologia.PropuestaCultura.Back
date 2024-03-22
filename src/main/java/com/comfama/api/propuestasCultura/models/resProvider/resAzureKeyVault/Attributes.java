package com.comfama.api.propuestasCultura.models.resProvider.resAzureKeyVault;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attributes {
    @SerializedName("enabled")
    private Boolean enabled;

    @SerializedName("created")
    private Integer created;

    @SerializedName("updated")
    private Integer updated;

    @SerializedName("recoveryLevel")
    private String recoveryLevel;

    @SerializedName("recoverableDays")
    private Integer recoverableDays;
}
