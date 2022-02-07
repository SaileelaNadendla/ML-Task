package com.bhavna;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class EmployeeWorksheetProcessor {

	static class EmployeeWorksheet {

		public EmployeeWorksheet(String[] data, Integer lineNumber) {
			this.name = data[0];
			this.dayOfMonth = data[1];
			this.hourOfDay = data[2];
			this.meridiem = data[3];
			this.lineNumber = lineNumber;
		}

		public EmployeeWorksheet(String errorMessage, Integer lineNumber) {
			this.errorMessage = errorMessage;
			this.lineNumber = lineNumber;
		}

		private String name;
		private String dayOfMonth;
		private String hourOfDay;
		private String meridiem;
		private Integer lineNumber;
		private String errorMessage;

		@Override
		public String toString() {
			return "EmployeeWorksheet [name=" + name + ", dayOfMonth=" + dayOfMonth + ", hourOfDay=" + hourOfDay
					+ ", meridiem=" + meridiem + ", lineNumber=" + lineNumber + "]";
		}

	}

	public static void main(String[] args) {
		Path path = Paths.get("employee_worksheet.txt");

		Map<String, List<EmployeeWorksheet>> workSheetMap = new HashMap<String, List<EmployeeWorksheet>>() {
			{
				put("SUCCESS", new ArrayList<EmployeeWorksheetProcessor.EmployeeWorksheet>());
				put("FAILURE", new ArrayList<EmployeeWorksheetProcessor.EmployeeWorksheet>());
			}
		};
		final class LineNumberInfo {

			public LineNumberInfo() {
				this.lineNumber = 1;
			}

			private int lineNumber;

			public int currentLineNumber() {
				return lineNumber;
			}

			public void incrementLineNumber() {
				this.lineNumber += 1;
			}
		}
		try {
			LineNumberInfo lineNumber = new LineNumberInfo();
			Stream<String> lines = Files.lines(path);
			lines.forEach(line -> {
				{
					if (StringUtils.isBlank(line)) {
						workSheetMap.get("SUCCESS")
								.add(new EmployeeWorksheet("EmptyLine", lineNumber.currentLineNumber()));
					} else {
						String[] tokens = line.split("\\t");
						if (tokens.length != 4) {
							workSheetMap.get("SUCCESS")
									.add(new EmployeeWorksheet("Data Missing", lineNumber.currentLineNumber()));
						} else {
							workSheetMap.get("FAILURE")
									.add(new EmployeeWorksheet(tokens, lineNumber.currentLineNumber()));
						}
					}
					lineNumber.incrementLineNumber();
				}
			});
			lines.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(workSheetMap);
	}

}







