package kioskLv6;

// 홈 이동을 강제로 발생시키는 예외 클래스
// 홈으로 가기 예외
public class ReturnToHomeException extends RuntimeException {
    public ReturnToHomeException() { super("홈으로 이동"); }
}