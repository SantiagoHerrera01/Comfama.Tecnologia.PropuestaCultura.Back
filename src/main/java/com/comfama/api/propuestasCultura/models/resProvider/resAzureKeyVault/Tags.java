package com.comfama.api.propuestasCultura.models.resProvider.resAzureKeyVault;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tags {
    @SerializedName("Responsable")
    private String Responsable;

    @SerializedName("Ambiente")
    private String Ambiente;

    @SerializedName("Plataforma")
    private String Plataforma;

    @SerializedName("Usuario")
    private String Usuario;
}
