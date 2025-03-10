package com.lookback.common.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CommonConverter {

    /**
     * 주어진 생년월일(Long 타입, yyyyMMdd 형태)을 기반으로 현재 나이를 계산합니다.
     *
     * @param birthDt 생년월일 (형식: yyyyMMdd, Long 타입)
     * @return 나이 (int)
     */
    public static Long ageConverter(Long birthDt) {

        if (birthDt == null) {
            return 00000000L;
        }

        // Long 값을 String으로 변환
        String birthDateString = birthDt.toString();

        // 생년월일을 LocalDate로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedBirthDate = LocalDate.parse(birthDateString, formatter);

        // 현재 날짜
        LocalDate currentDate = LocalDate.now();

        // 나이를 계산 (현재 날짜 기준)
        return ChronoUnit.YEARS.between(parsedBirthDate, currentDate);
    }

    public static String formatLocalDateTime(LocalDate dateTime) {
            if (dateTime == null) {
                return null;
            }
            int currentYear = LocalDateTime.now().getYear();
            int year = dateTime.getYear();

            DateTimeFormatter formatter;
            if (year == currentYear) {
                //올해면 년도 삭제
                formatter = DateTimeFormatter.ofPattern("MM/dd");
            } else {
                formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
            }

            return dateTime.format(formatter);
    }

}
