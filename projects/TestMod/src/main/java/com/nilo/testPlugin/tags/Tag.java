package com.nilo.testPlugin.tags;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.object.ObjectContents;
import net.kyori.adventure.text.object.PlayerHeadObjectContents;

import java.util.List;

public class Tag {
    private final String id;
    private List<String> values;
    private List<String> signatures;

    public Tag(String id, List<String> values, List<String> signatures) {
        this.id = id;
        this.values = values;
        this.signatures = signatures;
    }

    public String getId() {
        return id;
    }

    public Component getComponent() {
        if ((values.isEmpty() || signatures.isEmpty()) || (values.size() != signatures.size())) return Component.empty();

        TextComponent.Builder componentBuilder = Component.text();
        for (int i = 0; i < values.size(); i++) {
            componentBuilder.append(
                    Component.object(
                        ObjectContents.playerHead().profileProperty(
                                PlayerHeadObjectContents.property("textures", values.get(i), signatures.get(i))
                        ).build()
                    )
            );
        }
        return componentBuilder.build();
    }
}
