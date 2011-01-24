package com.dynamo.cr.contenteditor.resource;

import com.dynamo.camera.proto.Camera.CameraDesc;

public class CameraResource {

    private CameraDesc cameraDesc;

    public CameraResource(CameraDesc cameraDesc) {
        this.cameraDesc = cameraDesc;
    }

    public CameraDesc getCameraDesc() {
        return cameraDesc;
    }

}
