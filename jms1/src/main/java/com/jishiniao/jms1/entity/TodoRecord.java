package com.jishiniao.jms1.entity;

import java.util.UUID;

public record TodoRecord(UUID id, Long userId, String name, String status){}
