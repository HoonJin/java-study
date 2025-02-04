package com.hoonjin.study.java.annotation.basic;

@AnnoMeta // 타입 적용 가능
public class MetaData {

//    @AnnoMeta // 필드에는 오류 발생
    private String id;

    @AnnoMeta // 메서드에 적용
    public void call() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta typeAnno = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("typeAnno = " + typeAnno);

        AnnoMeta methodMeta = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("methodMeta = " + methodMeta);
    }
}
