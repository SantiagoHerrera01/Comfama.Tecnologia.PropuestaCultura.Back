package com.comfama.api.propuestasCultura.models.resProvider.resUploadFilesSharepoint;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResUploadFilesSharepoint {
    @SerializedName("@microsoft.graph.downloadUrl")
    private String downloadUrl;

    @SerializedName("lastModifiedDateTime")
    private String createdDateTime;

    @SerializedName("webUrl")
    private String webUrl;

    @SerializedName("parentReference")
    private ParentReference path;
}
