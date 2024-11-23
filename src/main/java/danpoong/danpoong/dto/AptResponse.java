package danpoong.danpoong.dto;

public record AptResponse (
        String aptNm,
        String jibun,
        String excluUseAr,
        Integer deposit,
        Integer monthlyRent,
        String contractType
){

}
