package com.linkedin.javacd.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;

public interface RoomService {

	public boolean isAvailable(Long roomId);

	public ArrayNode list(List<Long> ids);
	
}
