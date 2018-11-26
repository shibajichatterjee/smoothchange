package com.rest.smoothchange.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.background.service.impl.ProjectBackgroundServiceImpl;

@Component
@Transactional
public class CommonUtil {
	@Autowired
	private ProjectBackgroundService projectService;

	public ProjectBackgroundDto getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
		return dto;
	}

	public boolean isNull(String input) {
		return StringUtils.isBlank(input);
	}

	public boolean isNotEmpty(String input) {
		return StringUtils.isNotEmpty(input);
	}

	public String stringNoNull(String inputString) {
		if ("null".equalsIgnoreCase(inputString)) {
			return "";
		}

		return StringUtils.defaultString(inputString);
	}

	public String joinTwoStrings(String oldValue, String newValue, String delimiter) {
		return Stream.of(oldValue, newValue).filter(s -> !isNull(s)).collect(Collectors.joining(delimiter));

	}

	/*
	 * public Map<String, String> convertListsToMap(List<String> keys,
	 * List<String> values) { if (!isNull(keys) && !isNull(values)) {
	 * Iterator<String> keyIter = keys.iterator(); Iterator<String> valIter =
	 * values.iterator(); return IntStream.range(0,
	 * keys.size()).boxed().collect( Collectors.toMap(x -> keyIter.next(), x ->
	 * valIter.next())); } return null; }
	 */
	/*
	 * public List<String> convertStringToListWithDelimiter(String value, String
	 * delimiter) { return new ArrayList<>(
	 * Arrays.asList(ConversionUtil.split(value, delimiter))); }
	 */
	public boolean isInputNumeric(String value) {

		return StringUtils.isNumeric(value);
	}

}
