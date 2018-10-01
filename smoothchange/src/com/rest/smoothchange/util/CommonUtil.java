package com.rest.smoothchange.util;

import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.background.service.impl.ProjectBackgroundServiceImpl;

public class CommonUtil {
	public  ProjectBackgroundDto getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundService projectService=new ProjectBackgroundServiceImpl();
		ProjectBackgroundDto dto = 
				projectService.getById(Long.parseLong(id));
		return dto;
	}
	public  boolean isNull(String input) {
		return StringUtils.isBlank(input);
	}

	public  boolean isNotEmpty(String input) {
		return StringUtils.isNotEmpty(input);
	}
		

	public  boolean isNull(
			@SuppressWarnings("rawtypes") Collection input) {

		return CollectionUtils.isEmpty(input);
	}
	
	public  String stringNoNull(String inputString) {
		if ("null".equalsIgnoreCase(inputString)) {
			return "";
		}

		return StringUtils.defaultString(inputString);
	}
	
	public  String joinTwoStrings(String oldValue, String newValue,
			String delimiter) {
		return Stream.of(oldValue, newValue)
				.filter(s -> !ValidationUtil.isNull(s))
				.collect(Collectors.joining(delimiter));

	}

	public  Map<String, String> convertListsToMap(List<String> keys,
			List<String> values) {
		if (!ValidationUtil.isNull(keys) && !ValidationUtil.isNull(values)) {
			Iterator<String> keyIter = keys.iterator();
			Iterator<String> valIter = values.iterator();
			return IntStream.range(0, keys.size()).boxed().collect(
					Collectors.toMap(x -> keyIter.next(), x -> valIter.next()));
		}
		return null;
	}
public  List<String> convertStringToListWithDelimiter(String value,
			String delimiter) {
		return new ArrayList<>(
				Arrays.asList(ConversionUtil.split(value, delimiter)));
	}
	public  boolean isInputNumeric(String value) {

		return StringUtils.isNumeric(value);
	}


}
