package com.project.escape.domain.store;

public enum Location {
    SEOUL, INCHEON, DAEGU, SEJONG, DAEJEON, GWANGJU, ULSAN, BUSAN,
    GYEONGGI, GANGWON, CHUNGCHEONG, JEOLLA, GYEONGSANG, JEJU, DEFAULT;

    public static Location mapLocation(String location) {
        return switch (location) {
            case "홍대", "강남", "건대", "잠실", "대학로", "신촌", "서울대입구", "신사", "신림" -> Location.SEOUL;
            case "인천" -> Location.INCHEON;
            case "광주" -> Location.GWANGJU;
            case "대구" -> Location.DAEGU;
            case "대전" -> Location.DAEJEON;
            case "부산" -> Location.BUSAN;
            case "수원", "부천", "성남", "안산", "범계", "동탄", "안양", "의정부" -> Location.GYEONGGI;
            case "천안" -> Location.CHUNGCHEONG;
            case "창원" -> Location.GYEONGSANG;
            case "전주", "익산" -> Location.JEOLLA;
            default -> Location.DEFAULT;
        };

    }
}
