package com.comfama.api.propuestasCultura.models.resProvider;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResFinalToken {
    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("scope")
    private String scope;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("ext_expires_in")
    private int extExpiresIn;

    @SerializedName("access_token")
    private String accessToken;
}
