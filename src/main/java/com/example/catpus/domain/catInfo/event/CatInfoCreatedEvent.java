package com.example.catpus.domain.catInfo.event;

import com.example.catpus.domain.catInfo.entity.CatInfo;
import org.springframework.context.ApplicationEvent;

public class CatInfoCreatedEvent extends ApplicationEvent {
    private final CatInfo catInfo;

    public CatInfoCreatedEvent(Object source, CatInfo catInfo) {
        super(source);
        this.catInfo = catInfo;
    }

    public CatInfo getCatInfo() {
        return catInfo;
    }
}
