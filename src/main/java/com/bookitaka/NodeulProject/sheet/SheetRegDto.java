package com.bookitaka.NodeulProject.sheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SheetRegDto {

    @NotBlank(message = "책 제목을 입력해주세요.")
    private String sheetBooktitle;

    @NotBlank(message = "작가를 입력해주세요.")
    private String sheetBookauthor;

    @NotBlank(message = "출판사를 입력해주세요.")
    private String sheetBookpublisher;
    private String sheetBookisbn;

    @NotNull(message = "가격을 설정해주세요.")
    @Range(min = 100, max = 100000, message = "가격이 100이하이거나 100000이상입니다. 확인해주세요.")
    private Integer sheetPrice;

//    private String sheetBookimgname;

//    @NotNull
//    private String sheetFilename;

    @NotNull(message = "장르를 설정해주세요.")
    private String sheetGenreName;

    private String sheetAgegroupName;

    private String sheetContent;

    //미리보기 여부 체크하기로 했는디...
}
