package Spring.cores.lifecycle;

public class NetworkClient {

  private String url;

  public void setUrl(String url) {
    this.url = url;
  }

  // 초기화 작업을 수행하는 메서드
  public void init() {
    System.out.println("객체 초기화 작업 수행, url = " + url);
    connect();
    call("초기화 연결 메시지");
  }

  // 서비스 시작 시 호출
  public void connect(){
    System.out.println("connect : " + url);
  }

  public void call(String message){
    System.out.println("call : " + url + " message = " + message);
  }

  // 서비스 종료 시 호출
  public void disconnect(){
    System.out.println("close : " + url);
  }
}
