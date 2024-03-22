package com.comfama.api.propuestasCultura.models.resProvider.resUploadFilesSharepoint;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentReference {
    @SerializedName("path")
    private String path;
}
