package com.dynamo.cr.contenteditor.resource;

import com.dynamo.gamesystem.proto.GameSystem.LightDesc;

public class LightResource {

    private LightDesc lightDesc;

    public LightResource(LightDesc lightDesc) {
        this.lightDesc = lightDesc;
    }

    public LightDesc getLightDesc() {
        return lightDesc;
    }

}
